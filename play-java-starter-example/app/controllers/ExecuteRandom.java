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

    public ExecuteRandom(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {

        Random rand = new Random();

        int max = getIntFromJson(maxJson, maxKind, reqJson, actionJson, distJson, ansJson, operationJson);
        int min = getIntFromJson(minJson, minKind, reqJson, actionJson, distJson, ansJson, operationJson);
        int range = max - min;
        int randnum = rand.nextInt(range) + min;

        setResultObject(randnum, dataKind, data, distJson, ansJson);
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
