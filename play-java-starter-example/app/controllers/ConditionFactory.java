package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ConditionFactory {
    private static ConditionFactory myinstance = null;
    private static final String conditionTableName = "CONDITION";
    private static final int CONDITION_ID = 0;
    private static final int CONDITION_JSON = 1;
    HashMap<int,ConditionBase> conditionHash = null;
 
    public ConditionFactory(){
        conditionHash = new HashMap<int,ConditionBase>();

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
            conditionJson = conditionJson.findValue("Condition");
            condition = new ConditionBase();
            evaluateObj = createCondition(conditionJson);
            condition.setEvaluateObj(evaluateObj);
            int conditionID = result.getString(CONDITION_ID)
            conditionHash.put(conditionID, condition);
        }
    }
    public EvaluateBase createOperation(JsonNode conditionJson){

        JsonNode operationJson = null;
        EvaluateBase evaluateObj = null;

        switch (conditionJson.findValue("OperationType").asInt()){
            case 0: { /*** Equal ***/
                evaluateObj = new EvaluateEquals();
                operationJson = conditionJson.findValue(Operation);
                
            }
            case 1: { /*** Compare ***/
            }
        }
    }
}