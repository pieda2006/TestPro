package controllers;

class EvaluateBase {

    private int operationType;
    ArrayList<EvaluateBase> evaluateObj;

    public EvaluateBase(){
        evaluateObj = new ArrayList<EvaluateBase>;
    }
    public void setOperationType(int opeType){
        operationType =opeType;
    }
    public ResultInfo evaluateCondition(JsonNode reqJson){
        ResultInfo resultinfo = new ResultInfo();
        resultinfo.setBoolResult(true);
        setResultType(ResultInfo.BOOLTYPE);
        return resultinfo;
    }
    void setEvaluateObj(EvaluateBase evaluate){
        evaluateObj.add(evaluate);
    }
}
