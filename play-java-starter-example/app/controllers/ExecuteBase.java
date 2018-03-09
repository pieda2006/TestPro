package controllers;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExecuteBase {

    public final static int REQUEST = 0;
    public final static int ACTION = 1;
    public final static int DISTRIBUTION = 2;
    public final static int ANSWER = 3;
    public final static int OPERATION = 4;

    protected int operationType;
    protected ArrayList<ExecuteBase> executeArray = null;

    public ExecuteBase(){
        executeArray = new ArrayList<ExecuteBase>();
    }
    public void setOperationType(int opeType){
        operationType =opeType;
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {
    }

    void setExecuteObj(ExecuteBase execute){
        executeArray.add(execute);
    }

    int getIntFromJson(JsonNode inputJson, int kind, JsonNode reqJson, JsonNode actionJson, LinkedHashMap distJson, LinkedHashMap ansJson, JsonNode operationJson){
        String retString = null;
        JsonNode opeJson;
        ObjectMapper objectmapper = new ObjectMapper();
        int retint;
        Object opetree = null;

        if(kind == REQUEST || kind == ACTION || kind == OPERATION){
            if(kind == REQUEST){
                opeJson = reqJson;
            } else if(kind == ACTION){
                opeJson = actionJson;
            } else {
                opeJson = operationJson;
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

    String getStringFromJson(JsonNode inputJson, int kind, JsonNode reqJson, JsonNode actionJson, LinkedHashMap distJson, LinkedHashMap ansJson, JsonNode operationJson){
        String retString = null;
        JsonNode opeJson;
        ObjectMapper objectmapper = new ObjectMapper();
        int retint;
        Object opetree = null;

        if(kind == REQUEST || kind == ACTION || kind == OPERATION){
            if(kind == REQUEST){
                opeJson = reqJson;
            } else if(kind == ACTION){
                opeJson = actionJson;
            } else {
                opeJson = operationJson;
            }

            for(int count = 0; inputJson.has(count); count++){
                opeJson = opeJson.path(inputJson.get(count).asText());
            }
            if(opeJson.isInt()){
                retString = Integer.toString(opeJson.asInt());
            } else if(opeJson.isTextual()){
                retString = opeJson.asText();
            } else if(opeJson.isObject()){
                retString = opeJson.toString();
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
            if(opetree.getClass().getSimpleName().equals("String")){
                retString = (String)opetree;
            } else if(opetree.getClass().getSimpleName().equals("Integer")){
                retString = Integer.toString((int)opetree);
            } else if(opetree.getClass().getSimpleName().equals("LinkedHashMap")){
                try {
                    retString = objectmapper.writeValueAsString(opetree);
                } catch (Exception e) {
                    //Error Action
                }
            }
        }
        return retString;
    }

Object getObjectFromJson(JsonNode inputJson, int kind, JsonNode reqJson, JsonNode actionJson, LinkedHashMap distJson, LinkedHashMap ansJson, JsonNode operationJson){

        String retString = null;
        JsonNode opeJson;
        ObjectMapper objectmapper = new ObjectMapper();
        int retint;
        Object opetree = null;

        if(kind == REQUEST || kind == ACTION || kind == OPERATION){
            if(kind == REQUEST){
                opeJson = reqJson;
            } else if(kind == ACTION){
                opeJson = actionJson;
            } else {
                opeJson = operationJson;
            }

            for(int count = 0; inputJson.has(count); count++){
                opeJson = opeJson.path(inputJson.get(count).asText());
            }

            if(opeJson.isInt()){
                opetree = opeJson.asInt();
            } else if(opeJson.isTextual()){
                opetree = opeJson.asText();
            } else if(opeJson.isObject()){
                try {
                    opetree = objectmapper.readValue(opeJson.toString(), LinkedHashMap.class);
                } catch (Exception e) {
                    //Error Action
                }
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
        }
        return opetree;
    }


    void setResultObject(Object result, int kind, JsonNode inputJson, LinkedHashMap distJson, LinkedHashMap ansJson){
        String retString = null;
        JsonNode opeJson = null;
        Object opetree = null;
        Object nextopetree = null;
        if(kind == DISTRIBUTION){
            opetree = distJson;
        } else {
            opetree = ansJson;
        }

        int count = 0;
        for(count = 0; inputJson.has(count); count++){
            if(count != 0){
                if(nextopetree == null){
                    nextopetree = new LinkedHashMap();
                    ((LinkedHashMap)opetree).put(inputJson.get(count-1).asText(), nextopetree);
                }
                opetree = nextopetree;
            }
            nextopetree = ((LinkedHashMap)opetree).get(inputJson.get(count).asText());
        }
        if(nextopetree == null){
            nextopetree = ((LinkedHashMap)opetree).put(inputJson.get(count-1).asText(), result);
        } else {
            nextopetree = ((LinkedHashMap)opetree).replace(inputJson.get(count-1).asText(), result);
        }
    }
}
