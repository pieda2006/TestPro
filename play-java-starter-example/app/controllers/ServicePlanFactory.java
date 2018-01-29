package controllers;

class ServicePlanFactory {

    private static ServicePlanFactory myinstance = null;

    public ServicePlanFactory(){
    }

    public ServicePlanFactory getInstance(){
        if(myinstance == null){
            myinstance = new PlanFactory();
        }
        return myinstance;
    }
}
