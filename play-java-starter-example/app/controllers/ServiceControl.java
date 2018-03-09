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

System.out.println("");
System.out.println("----- decideAction:InputData -----");
System.out.println("uri = " + uri);
System.out.println("reqJson = " + reqJson.toString());
System.out.println("---------------------");
System.out.println("");

        ConditionBase conditionObj = servicePlanfact.getCondition(uri);

        ArrayList<ActionBase> actionList = new ArrayList<ActionBase>();
        while(conditionObj != null) {
            conditionObj = conditionObj.evaluateCondition(reqJson, actionList);
        }

        LinkedHashMap<String,Object> ansJson = new LinkedHashMap<String,Object>();
        LinkedHashMap<String,Object> actionJson = new LinkedHashMap<String,Object>();

        for(int count = 0; count < actionList.size(); count++){
long t1 = System.currentTimeMillis ();

            actionList.get(count).executeAction(reqJson, ansJson, actionJson);

long t2 = System.currentTimeMillis ();

System.out.println("");
System.out.println("---- TAT ----");
System.out.println("action = " + actionList.get(count).getActionType() +  " Responce TAT=" + (t2 - t1));
System.out.println("-------------");
System.out.println("");
        }
        ObjectMapper objectmap = new ObjectMapper();
        JsonNode answer = null;
        try {
            answer = objectmap.readTree(objectmap.writeValueAsString(ansJson));

System.out.println("");
System.out.println("----- decideAction::Outputdata -----");
System.out.println("ansJson = " + objectmap.writeValueAsString(ansJson));
System.out.println("------------------------------------");
System.out.println("");
        } catch (Exception e) {
            //Error Action
        }
        return answer;
    }
}

