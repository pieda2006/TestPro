package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

class ConditionBase {

    private ConditionBase trueNextCondition = null;
    private ConditionBase falseNextCondition = null;
    private ArrayList<ActionBase> trueAction = null;
    private ArrayList<ActionBase> falseAction = null;
    private JsonNode conditionJson = null;
    private EvaluateBase evaluateObj = null;
    private int conditionType;

    /*** Constructer ***/

    public ConditionBase(){
    }
    public ConditionBase(ConditionBase copyObj){
        setEvaluateObj(copyObj.getEvaluateObj());
    }
    public int getConditionType(){
        return conditionType;
    }
    public void setConditionType(int type){
        conditionType = type;
    }
    public void setEvaluateObj(EvaluateBase evaluate){
        evaluateObj = evaluate;
    }
    public EvaluateBase getEvaluateObj(){
        return evaluateObj;
    }
    public void setNextCondition(ConditionBase cond, boolean inputbool){
        if(inputbool){
            trueNextCondition = cond;
        } else {
            falseNextCondition = cond;
        }
    }
    public void setAction(ActionBase action, boolean inputbool){
        if(inputbool){
            trueAction.add(action);
        } else {
            falseAction.add(action);
        }
    }

    public void setConditionJson(JsonNode input){
        conditionJson = input;
    }
    public ConditionBase evaluateCondition(JsonNode reqJson, ArrayList<ActionBase> actionList){
        ResultInfo resultinf = null;
        resultinf = evaluateObj.evaluateCondition(reqJson, conditionJson);
        if(resultinf.getBoolResult() == true){
            actionList.addAll(trueAction);
            return trueNextCondition;
        } else {
            actionList.addAll(falseAction);
            return falseNextCondition;
        }
    }
    
}
