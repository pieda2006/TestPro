package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

class ActionFactory {
    private static ActionFactory myinstance = null;
    private final static String actionTableName = "ACTION";
    private final static int ACTION_ID = 0;
    private final static int ACTION_JSON = 1;
    private HashMap<String,ActionBase> actionHash = null;
    
    public ActionFactory(){
        actionHash = new HashMap<String,ActionBase>();
    }
    public static ActionFactory getInstance(){
        if(myinstance == null){
            myinstance = new ActionFactory();
        }
    }
    public void createAllAction(){
        DataManager datamanage = DataManager.getInstance();
        ResultSet result = datamanage.getData(actionTableName);
        ObjectMapper objmapper = new ObjectMapper();
        JsonNode actionJson = null;
        ActionBase action = null;
        String actionID = null;
        while(result.next()){
            actionJson = objmapper.readTree(result.getBytes(ACTION_JSON));
            actionJson.findValue("Action");
            action = createOperation(actionJson);
            actionID = result.getInt(ACTION_ID)
            planHash.put(actionID, action);
        }
        retrun ServicePlanFactory_OK;
    }
    public ExecuteBase createOperation(JsonNode actionJson){
        
        JsonNode operationJson = null;
        EvaluateBase evaluateObj = null;
        int operationType = conditionJson.findValue("OperationType").asInt();

        switch (operationType){
            case 0: 
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
    }
}
