package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

class ServicePlanFactory {

    private static ServicePlanFactory myinstance = null;
    private static final String servicePlanTableName = "SERVICE_PLAN";
    private static final String KeyParamName = "PLANID";
    HashMap<String,ConditionBase> planHash = null;

    private final int PLAN_NAME = 1;
    private final int PLAN_VALUE = 2;
    public static final int ServicePlanFactory_OK = 0;

    public ServicePlanFactory(){
        planHash = new HashMap<String,ConditionBase>();
    }

    public static ServicePlanFactory getInstance(){
        if(myinstance == null){
            myinstance = new ServicePlanFactory();
        }
        return myinstance;
    }
    
    public ConditionBase getCondition(String uri){
        int conditionID;
        ConditionBase conditionObj = planHash.get(uri);
        if(conditionObj == null){
            ObjectMapper objmapper = new ObjectMapper();
            DataManager datamanage = DataManager.getInstance();

            ResultSet result = datamanage.getData(servicePlanTableName,KeyParamName,uri);
            JsonNode conditionJson = null;
            try {
                result.next();
                conditionJson = objmapper.readTree(result.getString(PLAN_VALUE));
                conditionObj = createCondition(conditionJson);
                String planName;
                planName = result.getString(PLAN_NAME);
                planHash.put(planName, conditionObj);
            } catch (Exception e) {
                 //Error Action
            }
        }
        return conditionObj;
    }
    
    public void createAllServicePlan(){
        DataManager datamanage = DataManager.getInstance();
        ResultSet result = datamanage.getData(servicePlanTableName);
        ObjectMapper objmapper = new ObjectMapper();
        JsonNode servicePlan = null;
        ConditionBase condition = null;
        String planName = null;
        try {
            while(result.next()){
                servicePlan = objmapper.readTree(result.getString(PLAN_VALUE));
                condition = createCondition(servicePlan);
                planName = result.getString(PLAN_NAME);
                planHash.put(planName, condition);
            }
        } catch (Exception e) {
            //Error Action
        }
    }
    
    public ConditionBase createCondition(JsonNode planJson){
        
        ConditionFactory conditionfact = ConditionFactory.getInstance();
        ActionFactory actionfact = ActionFactory.getInstance();
        int conditionType = planJson.path("ConditionType").asInt();
        ConditionBase conditionObj = conditionfact.getCondition(conditionType);

        Map.Entry<String,JsonNode> jsonmap = null;
        TreeMap<String,Object> jsonentry = new TreeMap<String,Object>();
        Iterator<Map.Entry<String,JsonNode>> jsonIte = planJson.fields();
        
        while(jsonIte.hasNext()){
            jsonmap = jsonIte.next();
            if(!jsonmap.getKey().equals("TrueAction") && !jsonmap.getKey().equals("FalseAction") && 
               !jsonmap.getKey().equals("TrueNextCondition") && !jsonmap.getKey().equals("FalseNextCondition")){
                if(jsonmap.getValue().isInt()){
                    jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asInt());
                } else if(jsonmap.getValue().isTextual()){
                    jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asText());
                }
            }
        }
        ObjectMapper objmapper = new ObjectMapper();
        JsonNode condiitonjson = null;
        try {
            condiitonjson = objmapper.readTree(objmapper.writeValueAsString(jsonentry));
        } catch (Exception e) {
            //Error Action
        }
        conditionObj.setConditionJson(condiitonjson);
        ActionBase actionObj = null;
        JsonNode actionjson = null;
        int actionType = 0;
        JsonNode actionInputJson = null;
        actionjson = planJson.path("TrueAction");

        if(!actionjson.isNull()){
            for(int count = 0; actionjson.has(count); count++){
                actionType = actionjson.get(count).path("ActionType").asInt();
                actionObj = actionfact.getAction(actionType);
                jsonentry = new TreeMap<String,Object>();
                jsonIte = actionjson.get(count).fields();

                while(jsonIte.hasNext()){
                    jsonmap = jsonIte.next();

                    if(!jsonmap.getKey().equals("Operation")){
                        if(jsonmap.getValue().isInt()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asInt());
                        } else if(jsonmap.getValue().isTextual()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asText());
                        }
                    }
                }

                objmapper = new ObjectMapper();
                try {
                    actionInputJson = objmapper.readTree(objmapper.writeValueAsString(jsonentry));
                } catch (Exception e) {
                    //Error Action
                }

                actionObj.setActionJson(actionInputJson);
                conditionObj.setAction(actionObj,true);

            }
        }
        actionjson = planJson.path("FalseAction");
        if(!actionjson.isNull()){
            for(int count = 0; actionjson.has(count); count++){
                actionType = actionjson.path("ActionType").get(count).asInt();
                actionObj = actionfact.getAction(actionType);
                jsonentry = new TreeMap<String,Object>();
                jsonIte = actionjson.get(count).fields();
                while(jsonIte.hasNext()){
                    jsonmap = jsonIte.next();
                    if(!jsonmap.getKey().equals("Operation")){
                        if(jsonmap.getValue().isInt()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asInt());
                        } else if(jsonmap.getValue().isTextual()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asText());
                        }
                    }
                }
                objmapper = new ObjectMapper();
                try {
                    actionInputJson = objmapper.readTree(objmapper.writeValueAsString(jsonentry));
                } catch (Exception e) {
                    //Error Action
                }
                actionObj.setActionJson(actionInputJson);
                conditionObj.setAction(actionObj,false);
            }
        }


        JsonNode conditionJson = null;
        ConditionBase nextCondition = null;
        conditionJson = planJson.path("TrueNextCondition");
        if(!conditionJson.isNull()){
            nextCondition = createCondition(conditionJson);
            conditionObj.setNextCondition(nextCondition,true);
        }
        conditionJson = planJson.path("FalseNextCondition");
        if(!conditionJson.isNull()){
            nextCondition = createCondition(conditionJson);
            conditionObj.setNextCondition(nextCondition,false);
        }

        return conditionObj;
    }
}
