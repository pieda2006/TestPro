package controllers;

class ActionBase {

    private ArrayList<ExecuteBase> executeArray = null;
    private JsonNode actionJson = null;
    
    /*** Constructer ***/

    public ActionBase(){
        executeArray = new ArrayList<ExecuteBase>();
    }
    public ActionBase(ActionBase copyObj){
        setExecuteObj(copyObj.getExecuteObj());
    }
    public int getConditionType(){
        return conditionType;
    }
    public void setExecuteObj(ArrayList<ExecuteBase> objArray){
        executeArray = objArray;
    }
    public void setActionJson(JsonNode inputJson){
        actionJson = inputJson;
    }
    public ArrayList<ExecuteBase> getExecuteObj(){
        return executeArray;
    }
    public void setOperation(ExecuteBase operation){
        executeArray.add(operation);
    }
}
