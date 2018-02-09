package controllers;

class ExecuteOperationJson {

    private JsonNode paramName;
    private JsonNode paramValue;
    private int nameKind;
    private int valueKind;
    private int paramType;
    public final static int TYPEINT = 0;
    public final static int TYPESTRING = 1;
    public final static int TYPENULL = 2;
    public final static int TYPEOBJECT = 3;
    public final static int REQUEST = 0;
    public final static int ACTION = 1;
    public final static int DISTRIBUTION = 2;
    public final static int ANSWER = 3;
    
    public ExecuteOperationJson(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {

        JsonNode opeJson = null;
        JsonNode setJson = null;
        Object opeTree = null;
	    Object setTree = null;
	    Object registObj = null;
        int opecount = 0;
        int setcount = 0;

        /*** Get Json Data ***/
        if(nameKind == REQUEST || nameKind == ACTION){
            if(nameKind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(opecount = 0; paramName.has(opecount); opecount++){
                opeJson = opeJson.findValue(paramName.get(opecount).asText);
            }
            if(opeJson.isInt()){
                registObj = opeJson.asInt();
            } else if(opeJson.isTextual()){
                registObj = opeJson.asText();
            } else if(opeJson.isObject()){
                registObj = objectmap.readValue(opeJson.toString(), LinkedHashMap.class);
            }
        } 
        /*** Get Tree Data ***/
        else if(nameKind == DISTRIBUTION || nameKind == ANSWER){
            if(nameKind == DISTRIBUTION){
            	opetree = distJson;
            } else {
                opetree = ansJson;
            }
            for(opecount = 0; inputJson.has(opecount); opecount++){
                    opetree = (LinkedHashMap)opetree.get(inputJson.get(opecount).asText);
                }
            }
            registObj = opetree;
        }
        /*** Set Data ***/
        if(valueKind == DISTRIBUTION){
            setTree = distJson;
        } else {
            setTree = ansJson;
        }
            
        for(setcount = 0; inputJson.has(setcount); setcount++){
            setTree = setnextTree;
            setnextTree = (LinkedHashMap)opetree.get(inputJson.get(setcount).asText);
        }
        if(setnextTree == null){
            (LinkedHashMap)setTree.put(inputJson.get(count-1).asText, registObj);
        } else {
            (LinkedHashMap)setTree.replace(inputJson.get(count-1).asText, registObj);
        }
    }

    /*** getter setter ***/
    void setParamName(JsonNode name){
        paramName = name;
    }
    void setParamValue(JsonNode value){
        paramValue = value;
    }
    void setNameKind(int kind){
        nameKind = kind;
    }
    void setValueKind(int kind){
        valueKind = kind;
    }
    void setParamType(int type){
        paramType = type;
    }
}
