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
    HashMap<int,ConditionBase> conditionHash = null;
 
    public ConditionFactory(){
        conditionHash = new HashMap<int,ConditionBase>();
    }

    public static ConditionFactory getInstance(){
        if(myinstance == null){
            myinstance = new ConditionFactory
        }
        return myinstance;
    }
    
    public int createAllCondition(){
        DataManager datamanage = DataManager.getInstance();
        ResultSet result = datamanage.getData(conditionTableName);
        JsonNode conditionJson = null;
        ConditionBase condition = null;
        ObjectMapper objmapper = new ObjectMapper();
        EvaluateBase evaluateObj = null;
        while(result.next()){
            conditionJson = objmapper.readTree(result.getBytes(CONDITION_JSON));
            condition = new ConditionBase();
            evaluateObj = createOperation(conditionJson);
            condition.setEvaluateObj(evaluateObj);
            int conditionID = result.getString(CONDITION_ID)
            conditionHash.put(conditionID, condition);
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
            case 2
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
                evaluateElementObj.setParamName(conditionJson.findValue("PramName").asText);
                evaluateElementObj.setParamType(conditionJson.findValue("PramType").asInt);
                evaluateObj = evaluateElementObj;
                break;
            }
        }
        
        evaluateObj.setoperationType(operationType);
        return evaluateObj;
    }
    public ConditionBase getCondition(int conditionType){
        int conditionID;
        ConditionBase conditionObj = conditionHash.get(conditionType);
        if(conditionObj == null){
            DataManager datamanage = getInstance();
            ResultSet result = datamanage.getData(conditionTableName,KeyParamName,conditionType);
            JsonNode conditionJson = objmapper.readTree(result.getBytes(CONDITION_JSON));
            ConditionBase condition = new ConditionBase();
            EvaluateBase evaluateObj = null;
            evaluateObj = createOperation(conditionJson);
            condition.setOperation(evaluateObj);

            conditionID = result.getInt(CONDITION_ID)
            planHash.put(conditionID, condition);
            conditionObj = condition;
        }
        ConditionBase retCondition = new ConditionBase(conditionObj);
        return retCondition;
    }
    
}