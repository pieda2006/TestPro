package controllers;

class ResultInfo {
	
	private String stringResult;
	private int intResult;
	private boolean boolResult;
    private int resultType;
    
    public final static int INTTYPE = 0;
    public final static int STRINGTYPE = 1;
    public final static int BOOLTYPE = 2;

    public ResultInfo(){
    }
    void setBoolResult(boolean boolRes){
        boolResult = boolRes;
    }
    void setIntResult(intRes : int){
        intResult = intRes;
    }
    void setStringResult(String stringRes){
        stringResult = stringRes;
    }
    boolean getBoolResult(){
        return boolResult;
    }
    int getIntResult(){
        return intResult;
    }
    String getStringResult(){
        return stringResult;
    }
    void setResultType(type : int){
        resultType = type;
    }
    int getResultType(){
        return resultType;
    }
}
