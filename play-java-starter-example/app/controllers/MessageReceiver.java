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

@Singleton
public class MessageReceiver extends Controller {

    /*** Message Receive Function ***/

    public Result receiveEvent(){

long t1 = System.currentTimeMillis ();

        /*** Get request Json message ***/

        JsonNode inputJsonNode = request().body().asJson();

        /*** Get Request URI ***/

        String uri = request().uri();

        ServiceControl svcObj = ServiceControl.getInstance();
        JsonNode outputJsonNode = svcObj.decideAction(uri, inputJsonNode);

long t2 = System.currentTimeMillis ();

System.out.println("");
System.out.println("---- TAT ----");
System.out.println("URL = " + uri +  " Responce TAT=" + (t2 - t1));
System.out.println("-------------");
System.out.println("");

        return ok(outputJsonNode.toString());
    }


}
