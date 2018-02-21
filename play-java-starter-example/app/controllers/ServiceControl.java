package controllers;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ServiceControl {

    private static ServiceControl myinstance = null;

    /*** Constructer ***/

    public ServiceControl(){
    }

    public static ServiceControl getInstance(){
        if(myinstance == null){
            myinstance = new ServiceControl();
        }
        return myinstance;
    }

    public JsonNode decideAction(String uri, JsonNode reqJson){
        ServicePlanFactory servicePlanfact = ServicePlanFactory.getInstance();
        ConditionBase conditionObj = servicePlanfact.getCondition(uri);

        ArrayList<ActionBase> actionList = new ArrayList<ActionBase>();
        while(conditionObj != null) {
            conditionObj = conditionObj.evaluateCondition(reqJson, actionList);
        }

        LinkedHashMap<String,Object> ansJson = new LinkedHashMap<String,Object>();
        LinkedHashMap<String,Object> actionJson = new LinkedHashMap<String,Object>();

        for(int count = 0; count < actionList.size(); count++){
            actionList.get(count).executeAction(reqJson, ansJson, actionJson);
        }
        ObjectMapper objectmap = new ObjectMapper();
        JsonNode answer = null;
        try {
            answer = objectmap.readTree(objectmap.writeValueAsString(ansJson));
        } catch (Exception e) {
            //Error Action
        }
        return answer;
    }
}

