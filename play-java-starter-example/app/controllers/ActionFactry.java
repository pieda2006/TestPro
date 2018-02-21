package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

class ActionFactory {
    private static ActionFactory myinstance = null;
    private final static String actionTableName = "ACTION_TABLE";
    private final static String KeyParamName = "ACTIONID";
    private final static int ACTION_ID = 1;
    private final static int ACTION_JSON = 2;
    private HashMap<Integer,ActionBase> actionHash = null;

    public ActionFactory(){
        actionHash = new HashMap<Integer,ActionBase>();
    }
    public static ActionFactory getInstance(){
        if(myinstance == null){
            myinstance = new ActionFactory();
        }
        return myinstance;
    }
    public void createAllAction(){
        DataManager datamanage = DataManager.getInstance();
        ResultSet result = datamanage.getData(actionTableName);
        ObjectMapper objmapper = new ObjectMapper();
        JsonNode actionJson = null;
        ActionBase action = null;
        ExecuteBase executeObj = null;
        int actionID;
        try {
            while(result.next()){
                actionJson = objmapper.readTree(result.getString(ACTION_JSON)).path("Operation");
                action = new ActionBase();
                for(int count = 0; actionJson.has(count); count++){
                    executeObj = createOperation(actionJson.get(count));
                    action.setOperation(executeObj);
                }
                actionID = result.getInt(ACTION_ID);
                actionHash.put(actionID, action);
            }
        } catch (Exception e) {
            //Error Action
        }
    }
    
    public ExecuteBase createOperation(JsonNode actionJson){
        
        JsonNode operationJson = null;
        ExecuteBase executeObj = null;
        int operationType = actionJson.path("OperationType").asInt();

        switch (operationType){
            case 0: //get DB data
            case 1: //insert DB data
            case 2: //update DB data
            case 3: //delete DB data
            {
                ExecuteOperationDB executeDBObj = new ExecuteOperationDB();
                executeDBObj.setTableName(actionJson.path("TableName"));
                executeDBObj.setKey(actionJson.path("Key"));
                executeDBObj.setResult(actionJson.path("Data"));
                executeDBObj.setValue(actionJson.path("Value"));
                executeDBObj.setTableKind(actionJson.path("TableKind").asInt());
                executeDBObj.setKeyKind(actionJson.path("KeyKind").asInt());
                executeDBObj.setResultKind(actionJson.path("DataKind").asInt());
                executeDBObj.setValueKind(actionJson.path("ValueKind").asInt());
                executeDBObj.setkeyType(actionJson.path("KeyType").asInt());
                executeObj = executeDBObj;
                break;
            }
            case 4: //Json operation
            {
                ExecuteOperationJson executeJsonObj = new ExecuteOperationJson();
                executeJsonObj.setParamName(actionJson.path("ParamName"));
                executeJsonObj.setNameKind(actionJson.path("ParamKind").asInt());
                executeJsonObj.setParamValue(actionJson.path("ParamValue"));
                executeJsonObj.setParamType(actionJson.path("ParamType").asInt());
                executeJsonObj.setValueKind(actionJson.path("ValueKind").asInt());
                executeObj = executeJsonObj;
                break;
            }
            case 5: //setdMessage
            {
                ExecuteSendMessage executeMessageObj = new ExecuteSendMessage();
                executeMessageObj.setSendUri(actionJson.path("SendTo"));
                executeMessageObj.setUriKind(actionJson.path("URLKind").asInt());
                executeMessageObj.setMethod(actionJson.path("Method").asInt());
                executeMessageObj.setSendValue(actionJson.path("SendValue"));
                executeMessageObj.setResult(actionJson.path("Result"));
                executeMessageObj.setValueKind(actionJson.path("ValueKind").asInt());
                executeMessageObj.setDataKind(actionJson.path("DataKind").asInt());
                executeObj = executeMessageObj;
                break;
            }
            case 6:
            case 7:
            case 8:
            case 9:
            {
                ExecuteArithmetic executeArithmeticObj = new ExecuteArithmetic();
                executeArithmeticObj.setRight(actionJson.path("Right"));
                executeArithmeticObj.setRightKind(actionJson.path("RightType").asInt());
                executeArithmeticObj.setLeft(actionJson.path("Left"));
                executeArithmeticObj.setResult(actionJson.path("Result"));
                executeArithmeticObj.setLeftKind(actionJson.path("LeftType").asInt());
                executeArithmeticObj.setResultKind(actionJson.path("DataKind").asInt());
                executeObj = executeArithmeticObj;
                break;
            }
            case 10:
            {
                ExecuteRandom executeRandomObj = new ExecuteRandom();
                executeRandomObj.setResult(actionJson.path("Data"));
                executeRandomObj.setDataKind(actionJson.path("DataKind").asInt());
                executeRandomObj.setMin(actionJson.path("Min"));
                executeRandomObj.setMinKind(actionJson.path("MinKind").asInt());
                executeRandomObj.setMax(actionJson.path("Max"));
                executeRandomObj.setMaxKind(actionJson.path("MaxKind").asInt());
                executeObj = executeRandomObj;
                break;
            }
        }

        executeObj.setOperationType(operationType);
        return executeObj;
    }

    public ActionBase getAction(int actionType){
        ActionBase actionObj = actionHash.get(actionType);
        int actionID;
        if(actionObj == null){
            DataManager datamanage = DataManager.getInstance();
            ResultSet result = datamanage.getData(actionTableName,KeyParamName,actionType);
            try {
                ObjectMapper objmapper = new ObjectMapper();
                result.next();
                JsonNode actionJson = objmapper.readTree(result.getString(ACTION_JSON)).path("Operation");

                ActionBase action = new ActionBase();
                ExecuteBase executeObj = null;
                for(int count = 0; actionJson.has(count); count++){
                    executeObj = createOperation(actionJson.get(count));
                    action.setOperation(executeObj);
                }
                actionID = result.getInt(ACTION_ID);
                actionHash.put(actionID, action);
                actionObj = action;
                actionObj.setActionType(actionID);
            } catch (Exception e) {
                //Error Action
            }
        }
        ActionBase retAction = new ActionBase(actionObj);
        return retAction;
    }
}
