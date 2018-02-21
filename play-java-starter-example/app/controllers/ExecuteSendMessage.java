package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;

import play.mvc.*;
import play.libs.ws.*;
import java.util.concurrent.*;

import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.ActorMaterializerSettings;
import play.shaded.ahc.org.asynchttpclient.*;
import play.libs.ws.ahc.*;

class ExecuteSendMessage extends ExecuteBase {
    private JsonNode sendUri;
    private int uriKind;
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

    public ExecuteSendMessage() {
    }
    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {
        // Set up Akka
        String name = "wsclient";
        ActorSystem system = ActorSystem.create(name);
        ActorMaterializerSettings settings = ActorMaterializerSettings.create(system);
        ActorMaterializer materializer = ActorMaterializer.create(settings, system, name);

        AsyncHttpClientConfig asyncHttpClientConfig = new DefaultAsyncHttpClientConfig.Builder()
            .setMaxRequestRetry(0)
            .setShutdownQuietPeriod(0)
            .setShutdownTimeout(0).build();
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient(asyncHttpClientConfig);

        // Set up WSClient instance directly from asynchttpclient.
        WSClient ws = new AhcWSClient(
            asyncHttpClient,
            materializer
        );

        String uri = null;
        String sendValue = null;

        /*** Get Json Data ***/
        uri = getStringData(sendUri, reqJson, ansJson, distJson, actionJson, uriKind);
        sendValue = getStringData(value, reqJson, ansJson, distJson, actionJson, valueKind);

        // implements WSBodyReadables or use WSBodyReadables.instance.json()
        if(method == POST){

//long t1 = System.currentTimeMillis ();

            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).post(sendValue).thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                setResultJson((JsonNode)compjson.get(), result, ansJson, distJson, dataKind);
            } catch(Exception e){
                //Error Action
            }

//long t2 = System.currentTimeMillis ();

//System.out.println("\n---------------\n");
//System.out.println("Signal TAT=" + (t2 - t1));
//System.out.println("\n---------------\n");

        } else if(method == GET){
            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).get().thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                setResultJson((JsonNode)compjson.get(), result, ansJson, distJson, dataKind);
            } catch(Exception e){
                //Error Action
            }
        } else if(method == PUT){
            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).put(sendValue).thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                setResultJson((JsonNode)compjson.get(), result, ansJson, distJson, dataKind);
            } catch(Exception e){
                //Error Action
            }
        } else if(method == DELETE){
            CompletionStage<JsonNode> jsonPromise = ws.url(uri).addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).delete().thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                setResultJson((JsonNode)compjson.get(), result, ansJson, distJson, dataKind);
            } catch(Exception e){
                //Error Action
            }
        } else if(method == OWN){
            try {
                ServiceControl servicectl = ServiceControl.getInstance();
                ObjectMapper objectmapper = new ObjectMapper();
                JsonNode jsondata = objectmapper.readTree(sendValue);
                JsonNode jsonRes = servicectl.decideAction(uri, jsondata);
                setResultJson(jsonRes, result, ansJson, distJson, dataKind);
            } catch (Exception e) {
                //Error Action
            }
        }
        try {
            ws.close();
        } catch (Exception e){
            //Error Action
        }
    }
    void setResultJson(JsonNode resultJson, JsonNode inputJson, LinkedHashMap ansJson, LinkedHashMap distJson, int setKind){
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
        if(setKind == DISTRIBUTION){
            opetree = distJson;
        } else {
            opetree = ansJson;
        }
        int count = 0;
        for(count = 0; inputJson.has(count); count++){
            if(count != 0){
                if(nextopetree == null){
                    nextopetree = new LinkedHashMap();
                    ((LinkedHashMap)opetree).put(inputJson.get(count-1).asText(), nextopetree);
                }
                opetree = nextopetree;
            }
            nextopetree = ((LinkedHashMap)opetree).get(inputJson.get(count).asText());
        }
        if(nextopetree == null){
            ((LinkedHashMap)opetree).put(inputJson.get(count-1).asText(), resultTree);
        } else {
            ((LinkedHashMap)opetree).replace(inputJson.get(count-1).asText(), resultTree);
        }
    }
    public String getStringData(JsonNode jsondata, JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, int getKind){
        JsonNode opeJson = null;
        Object opetree = null;
        ObjectMapper objectmapper = new ObjectMapper();

        /*** Get Json Data ***/
        if(getKind == REQUEST || getKind == ACTION){
            if(getKind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(int opecount = 0; jsondata.has(opecount); opecount++){
                opeJson = opeJson.path(jsondata.get(opecount).asText());
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
        else if(getKind == DISTRIBUTION || getKind == ANSWER){
            if(getKind == DISTRIBUTION){
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
    void setUriKind(int kind){
        uriKind = kind;
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
