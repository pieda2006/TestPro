package controllers;

class ExecuteBase {

    private int operationType;
    private ArrayList<ExecuteBase> executeArray = null;

    public ExecuteBase(){
        executeArray = new ArrayList<ExecuteBase>;
    }
    public void setOperationType(int opeType){
        operationType =opeType;
    }

    void executeAction(JsonNode reqJson, TreeMap ansJson, TreeMap distJson, JsonNode actionJson) {
    }

    void setExecuteObj(ExecuteBase execute){
        executeArray.add(execute);
    }
}
