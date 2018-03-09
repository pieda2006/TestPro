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

    public ExecuteHmac(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {

        Random rand = new Random();

        String keyInfo = getStringFromJson(keyJson, keyKind, reqJson, actionJson, distJson, ansJson, operationJson);
        String msgInfo = getStringFromJson(msgJson, msgKind, reqJson, actionJson, distJson, ansJson, operationJson);
        String algoInfo = getStringFromJson(algo, algoKind, reqJson, actionJson, distJson, ansJson, operationJson);

        String digestInfo = hmacDigest(msgInfo, keyInfo, algoInfo);

        setResultObject(digestInfo, resultKind, result, distJson, ansJson);
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
