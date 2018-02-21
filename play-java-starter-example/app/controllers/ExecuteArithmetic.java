package controllers;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExecuteArithmetic extends ExecuteBase {

    private JsonNode right;
    private JsonNode left;
    private JsonNode result;
    private int rightKind;
    private int leftKind;
    private int valueKind;
    private int dataKind;

    public final static int REQUEST = 0;
    public final static int ACTION = 1;
    public final static int DISTRIBUTION = 2;
    public final static int ANSWER = 3;
    public final static int ADD = 6;
    public final static int SUB = 7;
    public final static int MUL = 8;
    public final static int DIV = 9;
    public final static int INTKEY = 0;
    public final static int STRINGKEY = 1;

    public ExecuteArithmetic(){
    }
 
    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {

        int rightnum = getIntFromJson(right, rightKind, reqJson, actionJson, distJson, ansJson);
        int leftnum = getIntFromJson(left, leftKind, reqJson, actionJson, distJson, ansJson);

        int calcResult = 0;

        if(operationType == 6){
            calcResult = leftnum + rightnum;
        } else if(operationType == 7){
            calcResult = leftnum - rightnum;
        } else if(operationType == 8){
            calcResult = leftnum * rightnum;
        } else if(operationType == 9){
            calcResult = leftnum / rightnum;
        }

        /*** Set Data ***/
        int setcount = 0;
        Object setTree = null;
        Object setnextTree = null;

        if(dataKind == DISTRIBUTION){
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
            ((LinkedHashMap)setTree).put(result.get(setcount-1).asText(), calcResult);
        } else {
            ((LinkedHashMap)setTree).replace(result.get(setcount-1).asText(), calcResult);
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

    void setRight(JsonNode inputjson){
        right = inputjson;
    }
    void setLeft(JsonNode inputjson){
        left = inputjson;
    }
    void setResult(JsonNode inputjson){
        result = inputjson;
    }
    void setRightKind(int kind){
        rightKind = kind;
    }
    void setLeftKind(int kind){
        leftKind = kind;
    }
    void setResultKind(int kind){
        dataKind = kind;
    }
}
