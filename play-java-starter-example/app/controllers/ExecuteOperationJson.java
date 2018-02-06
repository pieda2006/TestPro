package controllers;

class ExecuteOperationJson {

    private JsonNode paramName;
    private JsonNode paramValue;
    private int nameKind;
    private int valueKind;
    private int paramType;
    
    private JsonNode paramValueKind;

    public ExecuteOperationJson(){
    }

    void executeAction(JsonNode reqJson, LinkedHashMap ansJson, LinkedHashMap distJson, JsonNode actionJson) {

        JsonNode opeJson = null;
        JsonNode setJson = null;
        LinkedHashMap opeTree = null;
	    LinkedHashMap setTree = null;
        int opecount = 0;
        int setcount = 0;

        if(nameKind == REQUEST || nameKind == ACTION){
            if(nameKind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(opecount = 0; paramName.has(opecount); opecount++){
                opeJson = opeJson.findValue(paramName.get(opecount).asText);
            }
        } else if(nameKind == DISTRIBUTION || nameKind == ANSWER){
            if(nameKind == DISTRIBUTION){
            	opetree = distJson;
            } else {
                opetree = ansJson;
            }
            for(int opecount = 0; inputJson.has(opecount); opecount++){
                opetree = (LinkedHashMap)opetree.get(inputJson.get(opecount).asText);
            }
        }
        if(valueKind == REQUEST || valueKind == ACTION){
            if(valueKind == REQUEST){
                setJson = reqJson;
            } else {
                setJson = actionJson;
            }
            for(int setcount = 0; paramName.has(setcount); setcount++){
                setJson = opeJson.findValue(paramName.get(setcount).asText);
            }
        } else if(valueKind == DISTRIBUTION || valueKind == ANSWER){
            if(valueKind == DISTRIBUTION){
            	setTree = distJson;
            } else {
                setTree = ansJson;
            }
            for(int setcount = 0; inputJson.has(setcount); setcount++){
            	if(inputJson.has(setcount + 1)){
                    setTree = (LinkedHashMap)opetree.get(inputJson.get(setcount).asText);
                } else {
                    
                }
            }
        }

    }

    void setResultJson(LinkedHashMap resultTree, JsonNode inputJson){
        String retString;
        JsonNode opeJson;
        Object opetree;
        Object nextopetree;
        if(valueKind == DISTRIBUTION){
            nextopetree = distJson;
        } else {
            nextopetree = ansJson;
        }
        int count = 0;
        for(count = 0; inputJson.has(count); count++){
        	opetree = nextopetree;
            nextopetree = (LinkedHashMap)opetree.get(inputJson.get(count).asText);
        }
        if(nextopetree == null){
            opetree.put(inputJson.get(count-1).asText, resultTree);
        } else {
        	opetree.replace(inputJson.get(count-1).asText, resultTree);
        }
    }
    
    String getStringFromJson(JsonNode inputJson, int kind){
        String retString = null;
        JsonNode opeJson;
        ObjectMapper objectmapper = new ObjectMapper();
        int retint;
        Object opetree = null;
        
        if(kind == REQUEST || kind == ACTION){
            if(kind == REQUEST){
                opeJson = reqJson;
            } else {
                opeJson = actionJson;
            }
            for(int count = 0; inputJson.has(count); count++){
                opeJson = opeJson.findValue(inputJson.get(count).asText);
            }
            if(opeJson.isInt()){
                retString = Integer.toString(opeJson.asInt());
            } else if(opeJson.isTextual()){
                retString = opeJson.asText();
            } else if(opeJson.isObject()){
                retString = opeJson.toString();
            }
        } else if(kind == DISTRIBUTION || kind == ANSWER){
            if(kind == DISTRIBUTION){
            	opetree = distJson;
            } else {
                opetree = ansJson;
            }
            for(int count = 0; inputJson.has(count); count++){
                opetree = (LinkedHashMap)opetree.get(inputJson.get(count).asText);
            }
            if(opetree.getClass().getSimpleName().equals("String")){
                retString = (String)opetree;
            } else if(opetree.getClass().getSimpleName().equals("Integer")){
                retString = Integer.toString(opetree);
            } else if(opetree.getClass().getSimpleName().equals("LinkedHashMap")){
                retString = objectmapper.writeValueAsString(opetree);
            }
        }
        return retString;
    }

    void setJsonValue(){
        
    }

    void setTableName(JsonNode table){
        tableName = table;
    }
    void setKey(JsonNode jsonKey){
        key = jsonKey;
    }
    void setValue(JsonNode jsonValue){
        value = jsonValue;
    }
    void setResult(JsonNode jsonResult){
        dataJson = jsonData;
    }
    void setTableKind(int kind){
        tableKind = kind;
    }
    void setKeyKind(int kind){
        keyKind = kind;
    }
    void setValueKind(int kind){
        valueKind = kind;
    }
    void setResultKind(int kind){
        dataKind = kind;
    }
    void setkeyType(int type){
        keyType = type;
    }
}
