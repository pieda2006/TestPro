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
    private JsonNode header;
    private JsonNode headvalue;
    private JsonNode user;
    private JsonNode pass;
    private int valueKind;
    private int dataKind;
    private int headerkind;
    private int headvaluekind;
    private int userKind;
    private int passKind;


    public final static int TYPEINT = 0;
    public final static int TYPESTRING = 1;
    public final static int TYPENULL = 2;
    public final static int TYPEOBJECT = 3;

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
    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson, JsonNode operationJson) {

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
        String headerString = null;
        String hValueString = null;
        String userValue = null;
        String passValue = null;

        /*** Get Json Data ***/
        uri = getStringFromJson(sendUri, uriKind, reqJson, actionJson, distJson, ansJson, operationJson);
        if(!value.toString().equals("")){
            sendValue = getStringFromJson(value, valueKind, reqJson, actionJson, distJson, ansJson, operationJson);
        } else {
           sendValue = "";
        }

        headerString = getStringFromJson(header, headerkind, reqJson, actionJson, distJson, ansJson, operationJson);
        hValueString = getStringFromJson(headvalue, headvaluekind, reqJson, actionJson, distJson, ansJson, operationJson);
        userValue = getStringFromJson(user, userKind, reqJson, actionJson, distJson, ansJson, operationJson);
        passValue = getStringFromJson(pass, passKind, reqJson, actionJson, distJson, ansJson, operationJson);

        if(method == POST){

            WSRequest request = ws.url(uri);

           if(!header.toString().equals("")){
               request = request.addHeader(headerString, hValueString);
           }

           if(!user.toString().equals("")){
               request = request.setAuth(userValue, passValue);
           }

            CompletionStage<JsonNode> jsonPromise = request
            .addHeader("Content-Type", "application/json")
            .setRequestTimeout(10000).post(sendValue).thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                ObjectMapper objectmapper = new ObjectMapper();
                Object resultObj = objectmapper.readValue(compjson.get().toString(), LinkedHashMap.class);
                setResultObject(resultObj, dataKind, result, distJson, ansJson);
            } catch(Exception e){
                //Error Action
            }
        } else if(method == GET){

            WSRequest request = ws.url(uri);

           if(!header.toString().equals("")){
              request = request.addHeader(headerString, hValueString);
           }

           if(!user.toString().equals("")){
               request = request.setAuth(userValue, passValue);
           }

            CompletionStage<JsonNode> jsonPromise = request
            .addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).get().thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                ObjectMapper objectmapper = new ObjectMapper();
                Object resultObj = objectmapper.readValue(compjson.get().toString(), LinkedHashMap.class);
                setResultObject(resultObj, dataKind, result, distJson, ansJson);
            } catch(Exception e){
                //Error Action
            }
        } else if(method == PUT){

            WSRequest request = ws.url(uri);

           if(!header.toString().equals("")){
              request = request.addHeader(headerString, hValueString);
           }

           if(!user.toString().equals("")){
               request = request.setAuth(userValue, passValue);
           }

            CompletionStage<JsonNode> jsonPromise = request
            .addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).put(sendValue).thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                ObjectMapper objectmapper = new ObjectMapper();
                Object resultObj = objectmapper.readValue(compjson.get().toString(), LinkedHashMap.class);
                setResultObject(resultObj, dataKind, result, distJson, ansJson);
            } catch(Exception e){
                //Error Action
            }
        } else if(method == DELETE){

            WSRequest request = ws.url(uri);

           if(!header.toString().equals("")){
              request = request.addHeader(headerString, hValueString);
           }

           if(!user.toString().equals("")){
               request = request.setAuth(userValue, passValue);
           }

            CompletionStage<JsonNode> jsonPromise = request.addHeader("Content-Type", "application/json")
            .setRequestTimeout(1000).delete().thenApply(r -> r.getBody(WSBodyReadables.instance.json()));
            CompletableFuture<JsonNode> compjson = (CompletableFuture<JsonNode>)jsonPromise;
            try {
                ObjectMapper objectmapper = new ObjectMapper();
                Object resultObj = objectmapper.readValue(compjson.get().toString(), LinkedHashMap.class);
                setResultObject(resultObj, dataKind, result, distJson, ansJson);
            } catch(Exception e){
                //Error Action
            }
        } else if(method == OWN){
            try {
                ServiceControl servicectl = ServiceControl.getInstance();
                ObjectMapper objectmapper = new ObjectMapper();
                JsonNode jsondata = objectmapper.readTree(sendValue);
                JsonNode jsonRes = servicectl.decideAction(uri, jsondata);
                Object resultObj = objectmapper.readValue(jsonRes.toString(), LinkedHashMap.class);
                setResultObject(resultObj, dataKind, result, distJson, ansJson);
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
    void setHeader(JsonNode headerJson){
        header = headerJson;
    }
    void setHeaderKind(int kind){
        headerkind = kind;
    }
    void setHeadValue(JsonNode headValueJson){
        headvalue = headValueJson;
    }
    void setHeadValueKind(int kind){
        headvaluekind = kind;
    }
    void setUser(JsonNode userJson){
        user = userJson;
    }
    void setUserKind(int kind){
        userKind = kind;
    }
    void setPass(JsonNode passJson){
        pass = passJson;
    }
    void setPassKind(int kind){
        passKind = kind;
    }
}
