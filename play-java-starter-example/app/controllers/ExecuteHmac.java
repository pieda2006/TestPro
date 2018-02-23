package controllers;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

class ExecuteHmac extends ExecuteBase {

    private JsonNode keyJson;
    private int keyKind;
    private JsonNode msgJson;
    private int msgKind;
    private JsonNode algo;
    private int algoKind;
    private JsonNode result;
    private int resultKind;


    public final static int REQUEST = 0;
    public final static int ACTION = 1;
    public final static int DISTRIBUTION = 2;
    public final static int ANSWER = 3;

    public ExecuteHmac(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {

        Random rand = new Random();

        String keyInfo = getStringFromJson(keyJson, keyKind, reqJson, actionJson, distJson, ansJson);
        String msgInfo = getStringFromJson(msgJson, msgKind, reqJson, actionJson, distJson, ansJson);
        String algoInfo = getStringFromJson(algo, algoKind, reqJson, actionJson, distJson, ansJson);

        String digestInfo = hmacDigest(msgInfo, keyInfo, algoInfo);

        /*** Set Data ***/

        int setcount = 0;
        Object setTree = null;
        Object setnextTree = null;

        if(resultKind == DISTRIBUTION){
            setTree = distJson;
        } else {
            setTree = ansJson;
        }

        for(setcount = 0; result.has(setcount); setcount++){
            if(setcount != 0){
                if(setnextTree == null){
                    setnextTree = new LinkedHashMap();
                    ((LinkedHashMap)setTree).put(result.get(setcount-1).asText(), setnextTree);
                }
                setTree = setnextTree;
            }
            setnextTree = ((LinkedHashMap)setTree).get(result.get(setcount).asText());
        }
        if(setnextTree == null){
            ((LinkedHashMap)setTree).put(result.get(setcount-1).asText(), digestInfo);
        } else {
            ((LinkedHashMap)setTree).replace(result.get(setcount-1).asText(), digestInfo);
        }
    }

    int getStringFromJson(JsonNode inputJson, int kind, JsonNode reqJson, JsonNode actionJson, LinkedHashMap distJson, LinkedHashMap ansJson){
        String retString = null;
        JsonNode opeJson;
        ObjectMapper objectmapper = new ObjectMapper();
        int retint;
        Object opetree = null;
        
        if(kind == REQUEST || kind == ACTION){
            if(kind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(int count = 0; inputJson.has(count); count++){
                opeJson = opeJson.path(inputJson.get(count).asText());
            }
            if(opeJson.isInt()){
                return opeJson.asInt();
            } else if(opeJson.isTextual()){
                return Integer.parseInt((String)opeJson.asText());
            }
        } else if(kind == DISTRIBUTION || kind == ANSWER){
            if(kind == DISTRIBUTION){
                opetree = distJson;
            } else {
                opetree = ansJson;
            }
            for(int count = 0; inputJson.has(count); count++){
                opetree = ((LinkedHashMap)opetree).get(inputJson.get(count).asText());
            }
            if(opetree.getClass().getSimpleName().equals("Integer")){
                return Integer.toString(opetree);
            } else if(opetree.getClass().getSimpleName().equals("String")){
                return (String)opetree;
            } else if(opetree.getClass().getSimpleName().equals("LinkedHashMap")){
                try {
                    return objectmapper.writeValueAsString(opetree);
                } catch (Exception e){
                    //Error Action
                }
            }
        }
        return 0;
    }

  public String hmacDigest(String msg, String keyString, String algo) {
    String digest = null;
    try {
      SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
      Mac mac = Mac.getInstance(algo);
      mac.init(key);

      byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

      StringBuffer hash = new StringBuffer();
      for (int i = 0; i < bytes.length; i++) {
        String hex = Integer.toHexString(0xFF & bytes[i]);
        if (hex.length() == 1) {
          hash.append('0');
        }
        hash.append(hex);
      }
      digest = hash.toString();
    } catch (UnsupportedEncodingException e) {
    } catch (InvalidKeyException e) {
    } catch (NoSuchAlgorithmException e) {
    }
    return digest;
  }

    void setKeyJson(JsonNode inputjson){
        keyJson = inputjson;
    }
    void setKeyKind(int kind){
        keyKind = kind;
    }
    void setMsgJson(JsonNode inputjson){
        msgJson = inputjson;
    }
    void setMsgKind(int kind){
        msgKind = kind;
    }
    void setAlgoJson(JsonNode inputjson){
        algo = inputjson;
    }
    void setAlgoKind(int kind){
        algoKind = kind;
    }
    void setResultJson(JsonNode inputjson){
        result = inputjson;
    }
    void setResultKind(int kind){
        resultKind = kind;
    }
}
