package controllers;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExecuteStringOperation extends ExecuteBase {

    private JsonNode right;
    private JsonNode left;
    private JsonNode result;
    private int rightKind;
    private int leftKind;
    private int valueKind;
    private int dataKind;

    public ExecuteStringOperation(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {
        String rightstring = getStringFromJson(right, rightKind, reqJson, actionJson, distJson, ansJson, operationJson);
        String leftstring = getStringFromJson(left, leftKind, reqJson, actionJson, distJson, ansJson, operationJson);

        String calcResult = null;

        calcResult = leftstring + rightstring;

        setResultObject(calcResult, dataKind, result, distJson, ansJson);

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
