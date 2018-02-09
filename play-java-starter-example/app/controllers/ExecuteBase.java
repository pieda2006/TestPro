package controllers;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;

class ExecuteBase {

    protected int operationType;
    protected ArrayList<ExecuteBase> executeArray = null;

    public ExecuteBase(){
        executeArray = new ArrayList<ExecuteBase>();
    }
    public void setOperationType(int opeType){
        operationType =opeType;
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {
    }

    void setExecuteObj(ExecuteBase execute){
        executeArray.add(execute);
    }
}
