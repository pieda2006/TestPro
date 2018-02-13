package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

import play.mvc.*;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;

class ExecuteSendMessage extends ExecuteBase  implements WSBodyReadables, WSBodyWritables {
    private JsonNode sendUri;
    private int method;
    private JsonNode value;
    private JsonNode result;
    private int valueKind;

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
        uri = getStringData(sendUri);
        sendValue = getStringData(value);

        CompletionStage<JsonNode> jsonPromise = null;
        // implements WSBodyReadables or use WSBodyReadables.instance.json()
        jsonPromise = ws.url(uri).get().thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
        if(method == POST){
        	jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
        	.setRequestTimeout(1000).post(sendValue)
        	.thenApply(r -> r.getBody(WSBodyReadables.instance.json()));

        } else if(method == GET){
            wsres = wsreq.setContentType("application/json").setRequestTimeout(1000).get();
            jsonRes = wsres.asJson();
        } else if(method == PUT){
            wsres = wsreq.setContentType("application/json").setRequestTimeout(1000).put(jsonString);
            jsonRes = wsres.asJson();
        } else if(method == DELETE){
            wsres = wsreq.setContentType("application/json").setRequestTimeout(1000).delete();
            jsonRes = wsres.asJson();
        } else if(OWN){
            ServiceControl servicectl = ServiceControl.getInstance();
            JsonNode jsondata = objectmapper.readTree(sendValue);
            jsonRes = servicectl.decideAction(uri, jsondata);
        }
        /*** setData ***/
        LinkedHashMap tree = objectmapper.readValue(jsonRes.toString(), LinkedHashMap.class);
        setResultJson(tree, result);
    }
    void setResultJson(LinkedHashMap resultTree, JsonNode inputJson){
        String retString;
        JsonNode opeJson;
        Object opetree;
        Object nextopetree;
        if(dataKind == DISTRIBUTION){
            nextopetree = distJson;
        } else {
            nextopetree = ansJson;
        }
        int count = 0;
        for(count = 0; inputJson.has(count); count++){
            opetree = nextopetree;
            nextopetree = ((LinkedHashMap)opetree).get(inputJson.get(count).asText);
        }
        if(nextopetree == null){
            ((LinkedHashMap)opetree).put(inputJson.get(count-1).asText, resultTree);
        } else {
            ((LinkedHashMap)opetree).replace(inputJson.get(count-1).asText, resultTree);
        }
    }
    public String getStringData(JsonNode jsondata){
        JsonNode opeJson = null;

        /*** Get Json Data ***/
        if(nameKind == REQUEST || nameKind == ACTION){
            if(nameKind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(opecount = 0; jsondata.has(opecount); opecount++){
                opeJson = opeJson.findValue(jsondata.get(opecount).asText);
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
        else if(nameKind == DISTRIBUTION || nameKind == ANSWER){
            if(nameKind == DISTRIBUTION){
                opetree = distJson;
            } else {
                opetree = ansJson;
            }
            for(opecount = 0; jsondata.has(opecount); opecount++){
               opetree = ((LinkedHashMap)opetree).get(jsondata.get(opecount).asText);
            }
            registObj = opetree;
            if(opetree.getClass().getSimpleName().equals("String")){
                return (String)registObj;
            } else if(registObj.getClass().getSimpleName().equals("Integer")){
                return Integer.toString(opetree);
            } else if(registObj.getClass().getSimpleName().equals("LinkedHashMap")){
                return objectmapper.writeValueAsString(opetree);
            }
        }
        return null;
    }
    /*** getter setter ***/
    void setSendUri(JsonNode uri){
        sendUri = uri;
    }
    void setMethod(JsonNode sendmethod){
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
}
