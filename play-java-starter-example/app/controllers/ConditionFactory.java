package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ConditionFactory {
    private static ConditionFactory myinstance = null;
    private static final String conditionTableName = "CONDITION";
    private static final String KeyParamName = "CONDITION_ID";
    private static final int CONDITION_ID = 0;
    private static final int CONDITION_JSON = 1;
    HashMap<Integer,ConditionBase> conditionHash = null;
 
    public ConditionFactory(){
        conditionHash = new HashMap<Integer,ConditionBase>();
    }

    public static ConditionFactory getInstance(){
        if(myinstance == null){
            myinstance = new ConditionFactory();
        }
        return myinstance;
    }
    
    public void createAllCondition(){
        DataManager datamanage = DataManager.getInstance();
        ResultSet result = datamanage.getData(conditionTableName);
        JsonNode conditionJson = null;
        ConditionBase condition = null;
        ObjectMapper objmapper = new ObjectMapper();
        EvaluateBase evaluateObj = null;
        try {
            while(result.next()){
                conditionJson = objmapper.readTree(result.getBytes(CONDITION_JSON));
                condition = new ConditionBase();
                evaluateObj = createOperation(conditionJson);
                condition.setEvaluateObj(evaluateObj);
                int conditionID = result.getInt(CONDITION_ID);
                conditionHash.put(conditionID, condition);
            }
        } catch (Exception e) {
            //Error Action
        }
    }
    public EvaluateBase createOperation(JsonNode conditionJson){

        JsonNode operationJson = null;
        EvaluateBase evaluateObj = null;
        int operationType = conditionJson.findValue("OperationType").asInt();

        switch (operationType){
            case 0: 
            case 1: 
            { /*** Equals / Compare ***/
                EvaluateCompare evaluateCompareObj = new EvaluateCompare();
                operationJson = conditionJson.findValue("Operation");
                evaluateCompareObj.setEvaluateObj(createOperation(operationJson.get(0)));
                evaluateCompareObj.setEvaluateObj(createOperation(operationJson.get(1)));
                evaluateObj = evaluateCompareObj;
                break;
            }
            case 2:
            case 3:
            { /*** Or / And ***/
                EvaluateLogical evaluateLogicalObj = new EvaluateLogical();
                operationJson = conditionJson.findValue("Operation");
                evaluateLogicalObj.setEvaluateObj(createOperation(operationJson.get(0)));
                evaluateLogicalObj.setEvaluateObj(createOperation(operationJson.get(1)));
                evaluateObj = evaluateLogicalObj;
                break;
            }
            case 4:
            case 5:
            { /*** Get Element/ Input ***/
                EvaluateElement evaluateElementObj = new EvaluateElement();
                evaluateElementObj.setParamName(conditionJson.findValue("ParamName"));
                evaluateElementObj.setParamType(conditionJson.findValue("ParamType").asInt());
                evaluateObj = evaluateElementObj;
                break;
            }
        }
        
        evaluateObj.setOperationType(operationType);
        return evaluateObj;
    }
    public ConditionBase getCondition(int conditionType){
        int conditionID;
        ConditionBase conditionObj = conditionHash.get(conditionType);
        if(conditionObj == null){
            ObjectMapper objmapper = new ObjectMapper();
            DataManager datamanage = DataManager.getInstance();
            JsonNode conditionJson = null;
            ResultSet result = datamanage.getData(conditionTableName,KeyParamName,conditionType);
            try {
                result.next();
                conditionJson = objmapper.readTree(result.getBytes(CONDITION_JSON));
                ConditionBase condition = new ConditionBase();
                EvaluateBase evaluateObj = null;
                evaluateObj = createOperation(conditionJson);
                condition.setEvaluateObj(evaluateObj);
                conditionID = result.getInt(CONDITION_ID);
                conditionHash.put(conditionID, condition);
                conditionObj = condition;
            } catch (Exception e) {
                //Error Action
            }
        }
        ConditionBase retCondition = new ConditionBase(conditionObj);
        return retCondition;
    }
    
}
