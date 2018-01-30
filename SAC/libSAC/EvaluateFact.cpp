#include <EvaluateFact.h>

EvaluateFact::EvaluateFact(){
    setOperationType(1);
}

int EvaluateFact::evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo){

    int l_Ret;

    if(m_PramType == EvaluateBase_INT){
        int l_IntValue;

        l_Ret = a_Fact->getIntParam(m_PramName, &l_IntValue);
        if(l_Ret == FactBase_OK){
            a_ResultInfo->setResultType(ResultInfo_INT);
            a_ResultInfo->setIntResult(l_IntValue);
            return EvaluateBase_OK;
        } else {
            return EvaluateBase_NG;
        }
    } else if(m_PramType == EvaluateBase_String){
        std::string* l_StringValue;
        l_Ret = a_Fact->getStringParam(m_PramName, &l_StringValue);
        if(l_Ret == FactBase_OK){
            a_ResultInfo->setResultType(ResultInfo_String);
            a_ResultInfo->setStringResult(l_StringValue);
            return EvaluateBase_OK;
        } else {
            return EvaluateBase_NG;
        }
    }
    return EvaluateBase_NG; 
}
