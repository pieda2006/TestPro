package controllers;

class EvaluateLogical {

    public final static int OR = 2;
    public final static int AND = 3;

    public EvaluateLogical(){
    }
    public ResultInfo evaluateCondition(JsonNode reqJson, JsonNode conditionJson){
    	ResultInfo result = new ResultInfo(ResultInfo.BOOLTYPE);
    	result.setResultType(ResultInfo.BOOLTYPE)
        ResultInfo resultLeft = null;
        ResultInfo resultRight = null;
        resultLeft = evaluateObj.get(0).evaluateCondition(reqJson, conditionJson);
        resultRight = evaluateObj.get(1).evaluateCondition(reqJson, conditionJson);
        if(operationType == OR){
            if(resultLeft.getResultType() == ResultInfo.BOOLTYPE &&
               resultRight.getResultType() == ResultInfo.BOOLTYPE){
                if(resultLeft.getBoolResult() || resultRight.getBoolResult()){
                    result.setBoolResult(true);
                } else {
                    result.setBoolResult(false);
                }
            }
        }else {
            if(resultLeft.getResultType() == ResultInfo.BOOLTYPE &&
               resultRight.getResultType() == ResultInfo.BOOLTYPE){
                if(resultLeft.getBoolResult() && resultRight.getBoolResult()){
                    result.setBoolResult(true);
                } else {
                    result.setBoolResult(false);
                }
            }
        }
        return result;
    }
}