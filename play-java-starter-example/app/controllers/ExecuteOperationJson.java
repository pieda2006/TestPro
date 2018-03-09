package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
 
class ExecuteOperationJson extends ExecuteBase {

    private JsonNode paramName;
    private JsonNode paramValue;
    private int nameKind;
    private int valueKind;
    private int paramType;
    public final static int TYPEINT = 0;
    public final static int TYPESTRING = 1;
    public final static int TYPENULL = 2;
    public final static int TYPEOBJECT = 3;

    public ExecuteOperationJson(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {

        Object dataObject = getObjectFromJson(paramName, nameKind, reqJson, actionJson, distJson, ansJson, operationJson);
        setResultObject(dataObject, valueKind, paramValue, distJson, ansJson);
    }

    /*** getter setter ***/
    void setParamName(JsonNode name){
        paramName = name;
    }
    void setParamValue(JsonNode value){
        paramValue = value;
    }
    void setNameKind(int kind){
        nameKind = kind;
    }
    void setValueKind(int kind){
        valueKind = kind;
    }
    void setParamType(int type){
        paramType = type;
    }
}
