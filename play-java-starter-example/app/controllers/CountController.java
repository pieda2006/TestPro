package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;
import play.mvc.Http.RequestBody;
import play.libs.Json;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class CountController extends Controller {

    private final Counter counter;

    @Inject
    public CountController(Counter counter) {
       this.counter = counter;
    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result count() {
/*
        RequestBody body = request().body();
        JsonNode jsonNode = body.asJson();
        JsonNode jsonData = jsonNode.path("ConditionType");
        int ConditionType1 = jsonData.asInt();
        jsonData = jsonNode.path("TrueNextCondition");
        jsonData = jsonData.path("ConditionType");
        int ConditionType2 = jsonData.asInt();
        Iterator<Map.Entry<String,JsonNode>> jsonIte = jsonNode.fields();
        Map.Entry<String,JsonNode> jsonmap = null;
        String resultmessge = "";
        ObjectMapper objectmapper = new ObjectMapper();
        boolean bool = false;
        LinkedHashMap<String, Object> linkhash = new LinkedHashMap<String, Object>();
*/
        /*** Json Element Read
        while(jsonIte.hasNext()){
            jsonmap = jsonIte.next();
            resultmessge = resultmessge + jsonmap.getKey() + " : " + jsonmap.getValue().asText() + " : " + jsonmap.getValue().isInt() + "\n";
        } ***/
        /*** Array 
        jsonData = jsonNode.path("ConditionType");
        resultmessge = jsonData.get(1).path("test2").asText();
        resultmessge = "" + jsonData.has(2);
        ***/
        /*** Create JsonData 
        TreeMap<String,Object> jsonentry = new TreeMap<String,Object>();
        jsonentry.put("test","test");
        jsonentry.put("tkc","tkc");
        linkhash.put("test","test");
        linkhash.put("tkc","tkc");
        TreeMap<String,Object> jsonentry_child = new TreeMap<String,Object>();
        jsonentry_child.put("child","child");
        jsonentry.put("child",jsonentry_child);
        try {
            //resultmessge = objectmapper.writeValueAsString(jsonentry);
        } catch (Exception e) {
        }  
***/
        /*** Json Create from String
        try {
            jsonNode = objectmapper.readTree(objectmapper.writeValueAsString(jsonentry));
        } catch (Exception e) {
            resultmessge = e.getClass().getSimpleName();
        }
***/
        //resultmessge = jsonNode.path("test").asText();


        /*** JsonNode to String 
        resultmessge = jsonNode.toString();
***/
        //try {
        //    LinkedHashMap tree = objectmapper.readValue(/*resultmessge*/"1", LinkedHashMap.class);
        //    resultmessge = objectmapper.writeValueAsString(tree);
        //    resultmessge = Integer.toString((int)tree.get("PCS"));
        //    resultmessge = tree.get("TrueNextCondition").getClass().getSimpleName();
        //    tree = (LinkedHashMap)tree.get("TrueNextCondition");
        //    resultmessge = Integer.toString((int)tree.get("ConditionType"));
        //    bool = tree.getClass().isInstance(testTree);
        //} catch (Exception e) {
        //    resultmessge = e.getClass().getSimpleName();
        //}
        //return ok("\n--------------------\n" + resultmessge + "\n--------------------\n");
        return ok("{\"RESULT\":\"OK\"}");
        //return ok("\n--------------------\n" + request().uri() + "\n--------------------\n");
    }

}
