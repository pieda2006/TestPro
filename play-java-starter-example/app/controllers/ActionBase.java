package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class ActionBase {

    private ArrayList<ExecuteBase> executeArray = null;
    private JsonNode actionJson = null;
    private JsonNode operationJson = null;
    int actionType;

    /*** Constructer ***/

    public ActionBase(){
        executeArray = new ArrayList<ExecuteBase>();
    }
    public ActionBase(ActionBase copyObj){
        ArrayList<ExecuteBase> executeObj = copyObj.getExecuteObj();
        setActionType(copyObj.getActionType());
        setExecuteObj(executeObj);
        setOperationJson(copyObj.getOperationJson());
    }
    public ArrayList<ExecuteBase> getExecuteObj(){
        return executeArray;
    }
    public void setActionType(int type){
        actionType = type;
    }
    public int getActionType(){
        return actionType;
    }
    public void setExecuteObj(ArrayList<ExecuteBase> objArray){
        executeArray = objArray;
    }
    public void setActionJson(JsonNode inputJson){
        actionJson = inputJson;
    }
    public void setOperation(ExecuteBase operation){
        executeArray.add(operation);
    }

    public void setOperationJson(JsonNode inputJson){
        operationJson = inputJson;
    }

    public JsonNode getOperationJson(){
        return operationJson;
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson){
        for(int count = 0; count < executeArray.size(); count++){

System.out.println("");
System.out.println("----- Action : Input Data -----");
System.out.println("reqJson = " + reqJson.toString());
System.out.println("actionJson = " + actionJson.toString());
System.out.println("operationJson = " + operationJson.toString());
try{
ObjectMapper map = new ObjectMapper();
System.out.println("ansJson = " + map.writeValueAsString(ansJson));
System.out.println("distJson = " + map.writeValueAsString(distJson));
} catch(Exception e){}
System.out.println("-------------------------------");
System.out.println("");

            executeArray.get(count).executeAction(reqJson, ansJson, distJson, actionJson, operationJson);
        }
    }
}
