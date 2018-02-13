package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

class ActionBase {

    private ArrayList<ExecuteBase> executeArray = null;
    private JsonNode actionJson = null;
    int actionType;

    /*** Constructer ***/

    public ActionBase(){
        executeArray = new ArrayList<ExecuteBase>();
    }
    public ActionBase(ActionBase copyObj){
        ArrayList<ExecuteBase> executeObj = copyObj.getExecuteObj();
        setExecuteObj(executeObj);
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
    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson){
        for(int count = 0; count < executeArray.size(); count++){
            executeArray.get(count).executeAction(reqJson, ansJson, distJson, actionJson);
        }
    }
}
