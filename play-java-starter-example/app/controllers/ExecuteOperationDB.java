package controllers;

import java.util.*;
import java.sql.ResultSet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExecuteOperationDB extends ExecuteBase {

    private JsonNode tableName;
    private JsonNode key;
    private JsonNode value;
    private JsonNode dataJson;
    private int keyType;
    private int tableKind;
    private int keyKind;
    private int valueKind;
    private int dataKind;

    public final static int REQUEST = 0;
    public final static int ACTION = 1;
    public final static int DISTRIBUTION = 2;
    public final static int ANSWER = 3;
    public final static int GET = 0;
    public final static int INSERT = 1;
    public final static int UPDATE = 2;
    public final static int DELETE = 3;
    public final static int INTKEY = 0;
    public final static int STRINGKEY = 1;

    public ExecuteOperationDB(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {
        DataManager datamanage = DataManager.getInstance();
        JsonNode opeJson;
        Object opetree;
        String opetable = null;
        String opekey = null;
        String opevalue = null;
        String opedata = null;
 
        int opeintkey;
        ObjectMapper objectmap = new ObjectMapper();
        
        opetable = getStringFromJson(tableName, tableKind, reqJson, actionJson, distJson, ansJson);
        opekey = getStringFromJson(key, keyKind, reqJson, actionJson, distJson, ansJson);
        opevalue = getStringFromJson(value, valueKind, reqJson, actionJson, distJson, ansJson);
        opedata = getStringFromJson(value, dataKind, reqJson, actionJson, distJson, ansJson);


        ResultSet resultSet = null;
        if(operationType == GET){
            if(keyType == INTKEY){
                resultSet = datamanage.getData(opetable, opekey, Integer.parseInt(opevalue));
            } else {
                resultSet = datamanage.getData(opetable, opekey, opevalue);
            }
            LinkedHashMap resultTree = objectmap.readValue(resultSet.getBytes(1), LinkedHashMap.class);
            setResultJson(resultTree, dataJson, distJson, ansJson);
        } else if(operationType == INSERT){
            if(keyType == INTKEY){
                datamanage.setData(opetable, Integer.parseInt(opevalue), opedata);
            } else {
                datamanage.setData(opetable, opevalue, opedata);
            }
        } else if(operationType == UPDATE){
            if(keyType == INTKEY){
                datamanage.upData(opetable, opekey, Integer.parseInt(opevalue), opedata);
            } else {
                datamanage.upData(opetable, opekey, opevalue, opedata);
            }
        } else if(operationType == DELETE){
            if(keyType == INTKEY){
                datamanage.delData(opetable, opekey, Integer.parseInt(opevalue));
            } else {
           	    datamanage.delData(opetable, opekey, opevalue);
            }
        }
    }

    void setResultJson(LinkedHashMap resultTree, JsonNode inputJson, LinkedHashMap distJson, LinkedHashMap ansJson){
        String retString = null;
        JsonNode opeJson = null;
        Object opetree = null;
        Object nextopetree = null;
        if(dataKind == DISTRIBUTION){
            nextopetree = distJson;
        } else {
            nextopetree = ansJson;
        }
        int count = 0;
        for(count = 0; inputJson.has(count); count++){
            opetree = nextopetree;
            nextopetree = ((LinkedHashMap)opetree).get(inputJson.get(count).asText());
        }
        if(nextopetree == null){
            nextopetree = ((LinkedHashMap)opetree).put(inputJson.get(count-1).asText(), resultTree);
        } else {
            nextopetree = ((LinkedHashMap)opetree).replace(inputJson.get(count-1).asText(), resultTree);
        }
    }

    String getStringFromJson(JsonNode inputJson, int kind, JsonNode reqJson, JsonNode actionJson, LinkedHashMap distJson, LinkedHashMap ansJson){
        String retString = null;
        JsonNode opeJson;
        ObjectMapper objectmapper = new ObjectMapper();
        int retint;
        Object opetree = null;
        
        if(kind == REQUEST || kind == ACTION){
            if(kind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(int count = 0; inputJson.has(count); count++){
                opeJson = opeJson.findValue(inputJson.get(count).asText());
            }
            if(opeJson.isInt()){
                retString = Integer.toString(opeJson.asInt());
            } else if(opeJson.isTextual()){
                retString = opeJson.asText();
            } else if(opeJson.isObject()){
                retString = opeJson.toString();
            }
        } else if(kind == DISTRIBUTION || kind == ANSWER){
            if(kind == DISTRIBUTION){
            	opetree = distJson;
            } else {
                opetree = ansJson;
            }
            for(int count = 0; inputJson.has(count); count++){
                opetree = ((LinkedHashMap)opetree).get(inputJson.get(count).asText());
            }
            if(opetree.getClass().getSimpleName().equals("String")){
                retString = (String)opetree;
            } else if(opetree.getClass().getSimpleName().equals("Integer")){
                retString = Integer.toString((int)opetree);
            } else if(opetree.getClass().getSimpleName().equals("LinkedHashMap")){
                retString = objectmapper.writeValueAsString(opetree);
            }
        }
        return retString;
    }

    void setJsonValue(){
        
    }

    void setTableName(JsonNode table){
        tableName = table;
    }
    void setKey(JsonNode jsonKey){
        key = jsonKey;
    }
    void setValue(JsonNode jsonValue){
        value = jsonValue;
    }
    void setResult(JsonNode jsonData){
        dataJson = jsonData;
    }
    void setTableKind(int kind){
        tableKind = kind;
    }
    void setKeyKind(int kind){
        keyKind = kind;
    }
    void setValueKind(int kind){
        valueKind = kind;
    }
    void setResultKind(int kind){
        dataKind = kind;
    }
    void setkeyType(int type){
        keyType = type;
    }
}
