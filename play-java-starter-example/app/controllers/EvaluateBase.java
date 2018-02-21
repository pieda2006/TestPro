package controllers;
 
import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;

class EvaluateBase {

    protected int operationType;
    protected ArrayList<EvaluateBase> evaluateObj = null;

    public EvaluateBase(){
        evaluateObj = new ArrayList<EvaluateBase>();
    }
    public void setOperationType(int opeType){
        operationType =opeType;
    }
    public ResultInfo evaluateCondition(JsonNode reqJson, JsonNode inputJson){
        ResultInfo resultinfo = new ResultInfo();
        resultinfo.setBoolResult(true);
        resultinfo.setResultType(ResultInfo.BOOLTYPE);
        return resultinfo;
    }
    public void setEvaluateObj(EvaluateBase evaluate){
        evaluateObj.add(evaluate);
    }
}
