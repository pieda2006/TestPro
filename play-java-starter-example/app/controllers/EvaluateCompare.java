package controllers;

class EvaluateCompare {

    public final static int EQUALS = 0;
    public final static int COMPARE = 1;

    public EvaluateCompare(){
    }
    public ResultInfo evaluateCondition(JsonNode reqJson, JsonNode conditionJson){
    	ResultInfo result = new ResultInfo(ResultInfo.BOOLTYPE);
    	result.setResultType(ResultInfo.BOOLTYPE)
        ResultInfo resultLeft = null;
        ResultInfo resultRight = null;
        resultLeft = evaluateObj.get(0).evaluateCondition(reqJson, conditionJson);
        resultRight = evaluateObj.get(1).evaluateCondition(reqJson, conditionJson);
        if(operationType == EQUALS){
            if(resultLeft.getResultType() == resultRight.getResultType()){
                if(resultLeft.getResultType() == ResultInfo.INTTYPE){
                    if(resultLeft.getIntResult() == resultRight.getIntResult()){
                        result.setBoolResult(true);
                    } else {
                        result.setBoolResult(false);
                    }
                } else if(resultLeft.getResultType() == ResultInfo.STRINGTYPE){
                    if(resultLeft.getStringResult().equals(resultRight.getStringResult())){
                        result.setBoolResult(true);
                    } else {
                        result.setBoolResult(false);
                    }
                }
            }
        } else {
            if(resultLeft.getResultType() == ResultInfo.INTTYPE &&
               resultRight.getResultType() == ResultInfo.INTTYPE){
                if(resultLeft.getIntResult() < resultRight.getIntResult()){
                    result.setBoolResult(true);
                } else {
                    result.setBoolResult(false);
                }
            }
        }
        return result;
    }
}