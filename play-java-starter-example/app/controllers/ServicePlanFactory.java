package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

class ServicePlanFactory {

    private static ServicePlanFactory myinstance = null;
    private static final String servicePlanTableName = "SERVICE_PLAN";
    HashMap<String,ConditionBase> planHash = null;

    private final int PLAN_NAME = 0;
    private final int PLAN_VALUE = 1;
    public static final int ServicePlanFactory_OK = 0;

    public ServicePlanFactory(){
        planHash = new HashMap<String,ConditionBase>();
        createAllServicePlan();
    }

    public ServicePlanFactory getInstance(){
        if(myinstance == null){
            myinstance = new PlanFactory();
        }
        return myinstance;
    }
    
    public createAllServicePlan(){
        DataManager datamanage = DataManager.getInstance();
        ResultSet result = datamanage.getData(servicePlanTableName);
        ObjectMapper objmapper = new ObjectMapper();
        JsonNode servicePlan = null;
        ConditionBase condition = null;
        String planName = null = result.getString(PLAN_NAME);
        while(result.next()){
            servicePlan = objmapper.readTree(result.getBytes(PLAN_VALUE));
            condition = createCondition(servicePlan);
            planName = result.getString(PLAN_NAME)
            planHash.put(planName, condition);
        }
        retrun ServicePlanFactory_OK;
    }
    
    public ConditionBase createCondition(JsonNode planJson){
        
    }
}
