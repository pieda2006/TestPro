package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

import play.mvc.*;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;

class ExecuteSendMessage extends ExecuteBase {
    private JsonNode sendUri;
    private int method;
    private JsonNode value;
    private JsonNode result;
    private int valueKind;
    private int dataKind;

    public final static int TYPEINT = 0;
    public final static int TYPESTRING = 1;
    public final static int TYPENULL = 2;
    public final static int TYPEOBJECT = 3;
    public final static int REQUEST = 0;
    public final static int ACTION = 1;
    public final static int DISTRIBUTION = 2;
    public final static int ANSWER = 3;
    
    public final static int GET = 0;
    public final static int HEAD = 1;
    public final static int POST = 2;
    public final static int PUT = 3;
    public final static int DELETE = 4;
    public final static int CONNECT = 5;
    public final static int OPTIONS = 6;
    public final static int TRACE = 7;
    public final static int PATCH = 8;
    public final static int OWN = 9;

    @Inject WSClient ws;

    public ExecuteSendMessage() {
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {

        String uri = null;
        String sendValue = null;

        /*** Get Json Data ***/
        uri = getStringData(sendUri, reqJson, ansJson, distJson, actionJson);
        sendValue = getStringData(value, reqJson, ansJson, distJson, actionJson);

        // implements WSBodyReadables or use WSBodyReadables.instance.json()
        if(method == POST){
            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).post(sendValue).thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            jsonPromise.thenCompose(jsonRes -> {
                setResultJson(jsonRes, result, ansJson, distJson);
                return null;
            });
        } else if(method == GET){
            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).get().thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            jsonPromise.thenCompose(jsonRes -> {
                setResultJson(jsonRes, result, ansJson, distJson);
                return null;
            });
        } else if(method == PUT){
            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).put(sendValue).thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            jsonPromise.thenCompose(jsonRes -> {
                setResultJson(jsonRes, result, ansJson, distJson);
                return null;
            });
        } else if(method == DELETE){
            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).delete().thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            jsonPromise.thenCompose(jsonRes -> {
                setResultJson(jsonRes, result, ansJson, distJson);
                return null;
            });
        } else if(method == OWN){
            try {
                ServiceControl servicectl = ServiceControl.getInstance();
                ObjectMapper objectmapper = new ObjectMapper();
                JsonNode jsondata = objectmapper.readTree(sendValue);
                JsonNode jsonRes = servicectl.decideAction(uri, jsondata);
                setResultJson(jsonRes, result, ansJson, distJson);
            } catch (Exception e) {
                //Error Action
            }
        }
    }
    void setResultJson(JsonNode resultJson, JsonNode inputJson, LinkedHashMap ansJson, LinkedHashMap distJson){
        String retString = null;
        JsonNode opeJson = null;
        Object opetree = null;
        Object nextopetree = null;
        ObjectMapper objectmapper = new ObjectMapper();

        LinkedHashMap resultTree = null;

        try {
            resultTree = objectmapper.readValue(resultJson.toString(), LinkedHashMap.class);
        } catch (Exception e) {
            //Error Action
        }
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
            ((LinkedHashMap)opetree).put(inputJson.get(count-1).asText(), resultTree);
        } else {
            ((LinkedHashMap)opetree).replace(inputJson.get(count-1).asText(), resultTree);
        }
    }
    public String getStringData(JsonNode jsondata, JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson){
        JsonNode opeJson = null;
        Object opetree = null;
        ObjectMapper objectmapper = new ObjectMapper();

        /*** Get Json Data ***/
        if(valueKind == REQUEST || valueKind == ACTION){
            if(valueKind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(int opecount = 0; jsondata.has(opecount); opecount++){
                opeJson = opeJson.findValue(jsondata.get(opecount).asText());
            }
            if(opeJson.isInt()){
                return Integer.toString(opeJson.asInt());
            } else if(opeJson.isTextual()){
                return opeJson.asText();
            } else if(opeJson.isObject()){
                return opeJson.toString();
            }
        } 
        /*** Get Tree Data ***/
        else if(valueKind == DISTRIBUTION || valueKind == ANSWER){
            if(valueKind == DISTRIBUTION){
                opetree = distJson;
            } else {
                opetree = ansJson;
            }
            for(int opecount = 0; jsondata.has(opecount); opecount++){
               opetree = ((LinkedHashMap)opetree).get(jsondata.get(opecount).asText());
            }
            if(opetree.getClass().getSimpleName().equals("String")){
                return (String)opetree;
            } else if(opetree.getClass().getSimpleName().equals("Integer")){
                return Integer.toString((Integer)opetree);
            } else if(opetree.getClass().getSimpleName().equals("LinkedHashMap")){
                try {
                    return objectmapper.writeValueAsString(opetree);
                } catch (Exception e) {
                    //Error Action
                }
            }
        }
        return null;
    }
    /*** getter setter ***/
    void setSendUri(JsonNode uri){
        sendUri = uri;
    }
    void setMethod(int sendmethod){
        method = sendmethod;
    }
    void setSendValue(JsonNode sendvalue){
        value = sendvalue;
    }
    void setResult(JsonNode recresult){
        result = recresult;
    }
    void setValueKind(int kind){
        valueKind = kind;
    }
    void setDataKind(int kind){
        dataKind = kind;
    }
}
