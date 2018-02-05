package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ServiceControl {

    private ServiceControl myinstance = null;

    /*** Constructer ***/

    public ServiceControl(){
    }

    public ServiceControl getInstance(){
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
        TreeMap<String,Object> ansJson = new TreeMap<String,Object>();
        TreeMap<String,Object> actionJson = new TreeMap<String,Object>();
        for(int count = 0; count < actionList.size(); count++){
            actionList.get(count).executeAction(reqJson, ansJson, actionJson);
        }
        ObjectMapper objectmap = new ObjectMapper();
        JsonNode answer = objectmap.readTree(objectmap.writeValueAsString(ansJson));
        return answer;
    }
}
