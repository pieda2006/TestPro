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
    public void setBoolResult(boolean boolRes){
        boolResult = boolRes;
    }
    public void setIntResult(int intRes){
        intResult = intRes;
    }
    public void setStringResult(String stringRes){
        stringResult = stringRes;
    }
    public boolean getBoolResult(){
        return boolResult;
    }
    public int getIntResult(){
        return intResult;
    }
    public String getStringResult(){
        return stringResult;
    }
    public void setResultType(int type){
        resultType = type;
    }
    public int getResultType(){
        return resultType;
    }
}
