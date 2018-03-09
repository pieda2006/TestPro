package controllers;

import com.fasterxml.jackson.databind.JsonNode;

class EvaluateElement extends EvaluateBase {

    private JsonNode paramName;
    private int paramType;

    public final static int INTPARM = 0;
    public final static int STRINGPARM = 1;
    public final static int REQUEST = 4;
    public final static int CONDTION = 5;
    public final static int OPERATION = 6;

    public EvaluateElement(){
    }
    public ResultInfo evaluateCondition(JsonNode reqJson, JsonNode conditionJson, JsonNode operationJson){
        ResultInfo resultinfo = new ResultInfo();

        JsonNode findJson = null;
        if(operationType == REQUEST){
            findJson = reqJson;
        } else if(operationType == CONDTION){
            findJson = conditionJson;
        } else {
            findJson = operationJson;
        }
        for(int count = 0; paramName.has(count); count++){
            findJson = findJson.path(paramName.get(count).asText());
        }

        if(paramType == INTPARM){
            resultinfo.setResultType(ResultInfo.INTTYPE);
            resultinfo.setIntResult(findJson.asInt());

        } else {
            resultinfo.setResultType(ResultInfo.STRINGTYPE);
            resultinfo.setStringResult(findJson.asText());
        }
        return resultinfo;
    }

    public void setParamName(JsonNode input){
        paramName = input;
    }
    public void setParamType(int type){
        paramType = type;
    }
}
