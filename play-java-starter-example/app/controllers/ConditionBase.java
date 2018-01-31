package controllers;

class ConditionBase {

    private ConditionBase trueNextCondition = null;
    private ConditionBase falseNextCondition = null;
    private ArrayList<ActionBase> trueNextCondition = null;
    private ArrayList<ActionBase> falseNextCondition = null;
    private int conditionType;
    private JsonNode conditionJson = null;
    private evaluateObj = null;
    
    /*** Constructer ***/

    public ConditionBase(){
    }
    public ConditionBase(ConditionBase copyObj){
        copyObj
    }
    public int getConditionType(){
        return conditionType;
    }
}
