package controllers;

class EvaluateElement {

    private JsonNode paramName;

    public EvaluateElement(){
    }
    public ResultInfo evaluateCondition(JsonNode reqJson, JsonNode conditionJson){
        ResultInfo resultinfo = new ResultInfo();
        if(paramName.has(0)){
            String getJson = paramName.get(0).asText();
            if(getJson.equals("ReqJson")){
                reqJson.findValue();
            } else {
            }
        }
    }
}