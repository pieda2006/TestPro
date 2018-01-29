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

        /*** Get request Json message ***/

        JsonNode inputJsonNode = request().body().asJson();

        /*** Get Request URI ***/

        String uri = request().uri();



        return ok("");

    }


}
