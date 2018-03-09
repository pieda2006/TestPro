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
    private int valueKind;
    private int keyKind;
    private int dataKind;

    public final static int GET = 0;
    public final static int INSERT = 1;
    public final static int UPDATE = 2;
    public final static int DELETE = 3;
    public final static int INTKEY = 0;
    public final static int STRINGKEY = 1;
 
    public ExecuteOperationDB(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {

        DataManager datamanage = DataManager.getInstance();
        JsonNode opeJson;
        Object opetree;
        String opetable = null;
        String opekey = null;
        String opedata = null;
        String opevalue = null;
        int opeintkey;

        ObjectMapper objectmap = new ObjectMapper();
        opetable = getStringFromJson(tableName, tableKind, reqJson, actionJson, distJson, ansJson, operationJson);
        opekey = getStringFromJson(key, keyKind, reqJson, actionJson, distJson, ansJson, operationJson);
        opevalue = getStringFromJson(value, valueKind, reqJson, actionJson, distJson, ansJson, operationJson);

        if(operationType != GET && operationType != DELETE){
            opedata = getStringFromJson(dataJson, dataKind, reqJson, actionJson, distJson, ansJson, operationJson);
        }

        ResultSet resultSet = null;
        if(operationType == GET){
            if(keyType == INTKEY){
                resultSet = datamanage.getData(opetable, opekey, Integer.parseInt(opevalue));
            } else {
                resultSet = datamanage.getData(opetable, opekey, opevalue);
            }
            try {
                resultSet.next();

                LinkedHashMap resultTree = objectmap.readValue(resultSet.getString(2), LinkedHashMap.class);
                if(keyType == INTKEY){
                    resultTree.put("Key", resultSet.getInt(1));
                } else if(keyType == STRINGKEY){
                    resultTree.put("Key", resultSet.getString(1));
                }

                setResultObject(resultTree, dataKind, dataJson ,distJson, ansJson);
            } catch (Exception e){
                //Error Action
            }
        } else if(operationType == INSERT){
            if(keyType == INTKEY){
                datamanage.setData(opetable, opekey, Integer.parseInt(opevalue), opedata);
            } else {
                datamanage.setData(opetable, opekey, opevalue, opedata);
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

    void setJsonValue(){
    }

    void setTableName(JsonNode table){
        tableName = table;
    }
    void setKey(JsonNode jsonKey){
        key = jsonKey;
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
    void setResultKind(int kind){
        dataKind = kind;
    }
    void setkeyType(int type){
        keyType = type;
    }
    void setValue(JsonNode jsonData){
        value = jsonData;
    }
    void setValueKind(int kind){
        valueKind = kind;
    }
}
