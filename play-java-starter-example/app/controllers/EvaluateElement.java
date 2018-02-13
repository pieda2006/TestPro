package controllers;

import com.fasterxml.jackson.databind.JsonNode;

class EvaluateElement extends EvaluateBase {

    private JsonNode paramName;
    private int paramType;

    public final static int INTPARM = 0;
    public final static int STRINGPARM = 1;
    public final static int REQUEST = 4;
    public final static int CONDTION = 5;

    public EvaluateElement(){
    }
    public ResultInfo evaluateCondition(JsonNode reqJson, JsonNode conditionJson){
        ResultInfo resultinfo = new ResultInfo();

        String getJson = paramName.get(0).asText();
        JsonNode findJson = null;
        if(operationType == REQUEST){
            findJson = reqJson;
        } else {
            findJson = conditionJson;
        }
        for(int count = 0; paramName.has(count); count++){
            findJson = findJson.findValue(paramName.get(count).asText());
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
