package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

class ActionFactory {
    private static ActionFactory myinstance = null;
    private final static String actionTableName = "ACTION";
    private final static String KeyParamName = "ACTION_ID";
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
        ExecuteBase executeObj = null;
        int actionID;
        while(result.next()){
            actionJson = objmapper.readTree(result.getBytes(ACTION_JSON));
            action = new ActionBase();
            for(int count = 0; actionJson.has(count); count++){
                executeObj = createOperation(actionJson.get(count));
                action.setOperation(executeObj);
            }
            actionID = result.getInt(ACTION_ID)
            planHash.put(actionID, action);
        }
        retrun ServicePlanFactory_OK;
    }
    
    public ExecuteBase createOperation(JsonNode actionJson){
        
        JsonNode operationJson = null;
        ExecuteBase executeObj = null;
        int operationType = actionJson.findValue("OperationType").asInt();

        switch (operationType){
            case 0: //get DB data
            case 1: //insert DB data
            case 2: //update DB data
            case 3: //delete DB data
            {
                ExecuteOperationDB executeDBObj = new ExecuteOperationDB();
                executeDBObj.setTableName(actionJson.findValue("TableName"));
                executeDBObj.setKey(actionJson.findValue("Key"));
                executeDBObj.setValue(actionJson.findValue("Value"));
                executeDBObj.setValue(actionJson.findValue("Data"));
                executeDBObj.setValueKind(actionJson.findValue("TableKind").asInt());
                executeDBObj.setValueKind(actionJson.findValue("KeyKind").asInt());
                executeDBObj.setValueKind(actionJson.findValue("ValueKind").asInt());
                executeDBObj.setValueKind(actionJson.findValue("DataKind").asInt());
                executeDBObj.setValueKind(actionJson.findValue("KeyType").asInt());
                executeObj = executeDBObj;
                break;
            }
            case 4 //Json operation
            {
                ExecuteOperationJson executeJsonObj = new ExecuteOperationJson();
                executeJsonObj.setPramName(actionJson.findValue("PramName"));
                executeJsonObj.setPramValue(actionJson.findValue("PramValue"));
                executeJsonObj.setParamType(actionJson.findValue("ParamType").asInt());
                executeJsonObj.setParamType(actionJson.findValue("ValueKind").asInt());
                executeObj = executeJsonObj;
                break;
            }
            case 5: //setdMessage
            {
                ExecuteSendMessage executeMessageObj = new ExecuteSendMessage();
                executeMessageObj.setSendTo(actionJson.findValue("SendTo"));
                executeMessageObj.setMethod(actionJson.findValue("Method"));
                executeMessageObj.setValue(actionJson.findValue("Value"));
                executeMessageObj.setResult(actionJson.findValue("Result"));
                executeObj = executeMessageObj;
                break;
            }
        }
        
        executeObj.setoperationType(operationType);
        return evaluateObj;
    }

    public ActionBase getAction(int actionType){
        ActionBase actionObj = actionHash.get(actionType);
        int actionID;
        if(actionObj == null){
            DataManager datamanage = getInstance();
            ResultSet result = datamanage.getData(actionTableName,KeyParamName,actionType);
            JsonNode actionJson = objmapper.readTree(result.getBytes(ACTION_JSON));
            ActionBase action = new ActionBase();
            ExecuteBase executeObj = null;
            for(int count = 0; actionJson.has(count); count++){
                executeObj = createOperation(actionJson.get(count));
                action.setOperation(executeObj);
            }
            actionID = result.getInt(ACTION_ID)
            planHash.put(actionID, action);
            actionObj = action;
        }
        ActionBase retAction = new ActionBase(actionObj);
        return retAction;
    }
}
