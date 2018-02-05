package controllers;

class EvaluateBase {

    public static final int BOOL = 0;
    public static final int STR = 0;
    public static final int NUM = 0;

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
        setResultType(BOOL);
        return resultinfo;
    }
    void setEvaluateObj(EvaluateBase evaluate){
        evaluateObj.add(evaluate);
    }
}