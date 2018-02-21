package controllers;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExecuteRandom extends ExecuteBase {

    private JsonNode data;
    private int dataKind;
    private JsonNode maxJson;
    private int maxKind;
    private JsonNode minJson;
    private int minKind;

    public final static int REQUEST = 0;
    public final static int ACTION = 1;
    public final static int DISTRIBUTION = 2;
    public final static int ANSWER = 3;

    public ExecuteRandom(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {

        Random rand = new Random();

        int max = getIntFromJson(maxJson, maxKind, reqJson, actionJson, distJson, ansJson);
        int min = getIntFromJson(minJson, minKind, reqJson, actionJson, distJson, ansJson);
        int range = max - min;
        int randnum = rand.nextInt(range) + min;

        /*** Set Data ***/

        int setcount = 0;
        Object setTree = null;
        Object setnextTree = null;

        if(dataKind == DISTRIBUTION){
            setTree = distJson;
        } else {
            setTree = ansJson;
        }

        for(setcount = 0; data.has(setcount); setcount++){
            if(setcount != 0){
                if(setnextTree == null){
                    setnextTree = new LinkedHashMap();
                    ((LinkedHashMap)setTree).put(data.get(setcount-1).asText(), setnextTree);
                }
                setTree = setnextTree;
            }
            setnextTree = ((LinkedHashMap)setTree).get(data.get(setcount).asText());
        }
        if(setnextTree == null){
            ((LinkedHashMap)setTree).put(data.get(setcount-1).asText(), randnum);
        } else {
            ((LinkedHashMap)setTree).replace(data.get(setcount-1).asText(), randnum);
        }
    }

    int getIntFromJson(JsonNode inputJson, int kind, JsonNode reqJson, JsonNode actionJson, LinkedHashMap distJson, LinkedHashMap ansJson){
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
                return (int)opetree;
            } else if(opetree.getClass().getSimpleName().equals("String")){
                return Integer.parseInt((String)opetree);
            }
        }
        return 0;
    }

    void setResult(JsonNode inputjson){
        data = inputjson;
    }
    void setDataKind(int kind){
        dataKind = kind;
    }
    void setMin(JsonNode inputjson){
        minJson = inputjson;
    }
    void setMinKind(int kind){
        minKind = kind;
    }
    void setMax(JsonNode inputjson){
        maxJson = inputjson;
    }
    void setMaxKind(int kind){
        maxKind = kind;
    }
}
