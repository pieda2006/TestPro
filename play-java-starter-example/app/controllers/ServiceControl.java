package controllers;

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
    }
}
