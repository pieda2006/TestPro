package controllers;

import java.util.*;
//import java.sql.ResultSet;
import redis.clients.jedis.Jedis;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExecuteOperationRedis extends ExecuteBase {

//    private JsonNode tableName;
    private JsonNode key;
    private JsonNode value;
    private JsonNode dataJson;
//    private int keyType;
//    private int tableKind;
    private int valueKind;
    private int keyKind;
    private int dataKind;

//    public final static int GET = 0;
//    public final static int INSERT = 1;
//    public final static int UPDATE = 2;
//    public final static int DELETE = 3;
    public final static int GET = 20;
    public final static int SET = 21;
    public final static int DEL = 22;
//    public final static int INTKEY = 0;
//    public final static int STRINGKEY = 1;

    public ExecuteOperationRedis(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {

        RedisManager datamanage = RedisManager.getInstance();
        JsonNode opeJson;
        Object opetree;
//        String opetable = null;
        String opekey = null;
        String opedata = null;
        String opevalue = null;
        int opeintkey;

        ObjectMapper objectmap = new ObjectMapper();
//        opetable = getStringFromJson(tableName, tableKind, reqJson, actionJson, distJson, ansJson, operationJson);
        opekey = getStringFromJson(key, keyKind, reqJson, actionJson, distJson, ansJson, operationJson);
        opevalue = getStringFromJson(value, valueKind, reqJson, actionJson, distJson, ansJson, operationJson);

        if(operationType != GET && operationType != DEL){
            opedata = getStringFromJson(dataJson, dataKind, reqJson, actionJson, distJson, ansJson, operationJson);
        }

//        ResultSet resultSet = null;
        String result = null;
        if(operationType == GET){
//            if(keyType == INTKEY){
//                resultSet = datamanage.getData(opetable, opekey, Integer.parseInt(opevalue));
//            } else {
                result = datamanage.getData(opekey);
//            }
            try {
//                resultSet.next();

//                LinkedHashMap resultTree = objectmap.readValue(result, LinkedHashMap.class);
//                if(keyType == INTKEY){
//                    resultTree.put("Key", resultSet.getInt(1));
//                } else if(keyType == STRINGKEY){
//                    resultTree.put("Key", opekey);
//                }

                setResultObject(result, dataKind, dataJson ,distJson, ansJson);
            } catch (Exception e){
                //Error Actin
            }
        } else if(operationType == SET){
//            if(keyType == INTKEY){
//                datamanage.setData(opetable, opekey, Integer.parseInt(opevalue), opedata);
//            } else {
                datamanage.setData(opekey, opedata);
//            }
//        } else if(operationType == UPDATE){
//            if(keyType == INTKEY){
//                datamanage.upData(opetable, opekey, Integer.parseInt(opevalue), opedata);
//            } else {
//                datamanage.upData(opetable, opekey, opevalue, opedata);
//            }
        } else if(operationType == DEL){
//            if(keyType == INTKEY){
//                datamanage.delData(opetable, opekey, Integer.parseInt(opevalue));
//            } else {
                datamanage.delData(opekey);
//            }
        }
    }

    void setJsonValue(){
    }

//    void setTableName(JsonNode table){
//        tableName = table;
//    }
    void setKey(JsonNode jsonKey){
        key = jsonKey;
    }
    void setResult(JsonNode jsonData){
        dataJson = jsonData;
    }
//    void setTableKind(int kind){
//        tableKind = kind;
//    }
    void setKeyKind(int kind){
        keyKind = kind;
    }
    void setResultKind(int kind){
        dataKind = kind;
    }
//    void setkeyType(int type){
//        keyType = type;
//    }
    void setValue(JsonNode jsonData){
        value = jsonData;
    }
    void setValueKind(int kind){
        valueKind = kind;
    }
}
