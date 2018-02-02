package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

class ServicePlanFactory {

    private static ServicePlanFactory myinstance = null;
    private static final String servicePlanTableName = "SERVICE_PLAN";
    private static final String KeyParamName = "URI";
    private static final int PLAN_JSON = 1;
    HashMap<String,ConditionBase> planHash = null;

    private final int PLAN_NAME = 0;
    private final int PLAN_VALUE = 1;
    public static final int ServicePlanFactory_OK = 0;

    public ServicePlanFactory(){
        planHash = new HashMap<String,ConditionBase>();
    }

    public ServicePlanFactory getInstance(){
        if(myinstance == null){
            myinstance = new PlanFactory();
        }
        return myinstance;
    }
    
    public ConditionBase getCondition(String uri){
        int conditionID;
        ConditionBase conditionObj = planHash.get(uri);
        if(conditionObj == null){
            DataManager datamanage = getInstance();
            ResultSet result = datamanage.getData(conditionTableName,KeyParamName,uri);
            JsonNode conditionJson = objmapper.readTree(result.getBytes(PLAN_JSON));
            conditionObj = createCondition(conditionJson);
            String planName;
            planName = result.getString(PLAN_NAME);
            planHash.put(planName, conditionObj);
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
        while(result.next()){
            servicePlan = objmapper.readTree(result.getBytes(PLAN_VALUE));
            condition = createCondition(servicePlan);
            planName = result.getString(PLAN_NAME)
            planHash.put(planName, condition);
        }
    }
    
    public ConditionBase createCondition(JsonNode planJson){
        
        ConditionFactory conditionfact = null;
        
        conditionfact = ConditionFactory.getInstance();
        actionfact = ActionFactory.getInstance();
        int conditionType = planJson.findValue("ConditionType").asInt();

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
                } else if(jsonmap.isTextual()){
                    jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asText());
                }
            }
        }
        ObjectMapper objmapper = new ObjectMapper();
        JsonNode condiitonjson = objmapper.readTree(objmapper.writeValueAsString(jsonentry));
        conditionObj.setConditionJson(condiitonjson);
        ActionBase actionObj = null;
        JsonNode actionjson = null;
        int actionType;
        JsonNode actionInputJson = null;
        actionjson = planJson.findValue("TrueAction");
        if(!actionjson.isNull()){
            for(int count = 0; actionjson.has(count); count++){
                actionType = actionjson.findValue("ActionType").get(count).asInt();
                actionObj = actionfact.getAction(actionType);
                jsonentry = new TreeMap<String,Object>();
                jsonIte = actionjson.fields();
                while(jsonIte.hasNext()){
                    jsonmap = jsonIte.next();
                    if(!jsonmap.getKey().equals("Operation")){
                        if(jsonmap.getValue().isInt()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asInt());
                        } else if(jsonmap.isTextual()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asText());
                        }
                    }
                }
                objmapper = new ObjectMapper();
                actionInputJson = objmapper.readTree(objmapper.writeValueAsString(jsonentry));
                actionObj.setActionJson(actionInputJson);
            }
        }
        conditionObj.setAction(actionObj,true);
        actionjson = planJson.findValue("FalseAction");
        if(!actionjson.isNull()){
            for(int count = 0; actionjson.has(count); count++){
                actionType = actionjson.findValue("ActionType").get(count).asInt();
                actionObj = actionfact.getAction(actionType);
                jsonentry = new TreeMap<String,Object>();
                jsonIte = actionjson.fields();
                while(jsonIte.hasNext()){
                    jsonmap = jsonIte.next();
                    if(!jsonmap.getKey().equals("Operation")){
                        if(jsonmap.getValue().isInt()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asInt());
                        } else if(jsonmap.isTextual()){
                            jsonentry.put(jsonmap.getKey(),jsonmap.getValue().asText());
                        }
                    }
                }
                objmapper = new ObjectMapper();
                actionInputJson = objmapper.readTree(objmapper.writeValueAsString(jsonentry));
                actionObj.setActionJson(actionInputJson);
            }
        }
        conditionObj.setAction(actionObj,false);
        JsonNode conditionJson = null;
        ConditionBase nextCondition = null;
        conditionJson = planJson.findValue("TrueNextCondition");
        if(!conditionJson.isNull()){
            nextCondition = createCondition(conditionJson);
            conditionObj.setNextCondition(nextCondition,true);
        }
        conditionJson = planJson.findValue("FalseNextCondition");
        if(!conditionJson.isNull()){
            nextCondition = createCondition(conditionJson);
            conditionObj.setNextCondition(nextCondition,false);
        }
        return conditionObj;
    }
}
