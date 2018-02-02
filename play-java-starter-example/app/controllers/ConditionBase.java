package controllers;

class ConditionBase {

    private ConditionBase trueNextCondition = null;
    private ConditionBase falseNextCondition = null;
    private ArrayList<ActionBase> trueAction = null;
    private ArrayList<ActionBase> falseAction = null;
    private JsonNode conditionJson = null;
    private EvaluateBase evaluateObj = null;
    
    /*** Constructer ***/

    public ConditionBase(){
    }
    public ConditionBase(ConditionBase copyObj){
        setEvaluateObj(copyObj.getEvaluateObj());
    }
    public int getConditionType(){
        return conditionType;
    }
    public void setEvaluateObj(EvaluateBase evaluate){
        evaluateObj = evaluate;
    }
    public ConditionBase evaluateCondition(JsonNode reqJson, ArrayList<ActionBase> actionList){
        ResultInfo resultinf = null;
        resultinf = evaluateObj.evaluateCondition(JsonNode reqJson);
        if(resultinf.getBoolResult() == true){
            actionList.addAll(trueAction);
            return trueNextCondition;
        } else {
            actionList.addAll(falseAction);
            return falseNextCondition;
        }
    }
}
