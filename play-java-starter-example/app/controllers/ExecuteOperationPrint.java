package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExecuteOperationPrint extends ExecuteBase {

    private JsonNode paramName;
    private int paramKind;

    public ExecuteOperationPrint(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {

        Object dataObject = getObjectFromJson(paramName, paramKind, reqJson, actionJson, distJson, ansJson, operationJson);

        if(dataObject.getClass().getSimpleName().equals("String") ||
            dataObject.getClass().getSimpleName().equals("Integer")) {
            System.out.println(paramName.toString() + " = " + dataObject);
        } else if(dataObject.getClass().getSimpleName().equals("JsonNode")){
            System.out.println(paramName.toString() + " = " + ((JsonNode)dataObject).toString());
        } else if(dataObject.getClass().getSimpleName().equals("LinkedHashMap")){
            try {
                ObjectMapper objectmapper = new ObjectMapper();
                System.out.println(paramName.toString() + " = " + objectmapper.writeValueAsString(dataObject));
            } catch (Exception e) {
                //Error Action
            }
        }
    }

    /*** getter setter ***/
    void setParamName(JsonNode name){
        paramName = name;
    }
    void setParamKind(int kind){
        paramKind = kind;
    }
}
