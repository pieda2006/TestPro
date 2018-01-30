#include <EvaluateEquals.h>$

EvaluateEquals::EvaluateEquals(){
    setOperationType(3);
}

int EvaluateEquals::evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo){

    ResultInfo* l_ResultInfo[2];
    l_ResultInfo[0] = new ResultInfo();
    l_ResultInfo[1] = new ResultInfo();

    std::string* l_StringValue[2];

    m_EvaluateObject[0]->evaluateConditionImple(a_Fact, a_Value, l_ResultInfo[0]);
    m_EvaluateObject[1]->evaluateConditionImple(a_Fact, a_Value, l_ResultInfo[1]);

    a_ResultInfo->setResultType(ResultInfo_Bool);

    if(l_ResultInfo[0]->getResultType() == ResultInfo_INT &&
       l_ResultInfo[1]->getResultType() == ResultInfo_INT){
        if(l_ResultInfo[0]->getIntResult() == l_ResultInfo[1]->getIntResult()){
            a_ResultInfo->setBoolResult(true);
            delete l_ResultInfo[0];
            delete l_ResultInfo[1];
            return EvaluateBase_OK;
        } else {
            a_ResultInfo->setBoolResult(false);
            delete l_ResultInfo[0];
            delete l_ResultInfo[1];
            return EvaluateBase_OK;
        }
    } else if(l_ResultInfo[0]->getResultType() == ResultInfo_String &&
        l_ResultInfo[1]->getResultType() == ResultInfo_String){
        l_StringValue[0] = l_ResultInfo[0]->getStringResult();
        l_StringValue[1] = l_ResultInfo[1]->getStringResult();
        if(l_StringValue[0]->compare(*l_StringValue[1]) == 0){
            a_ResultInfo->setBoolResult(true);
            delete l_ResultInfo[0];
            delete l_ResultInfo[1];
            return EvaluateBase_OK;
        } else {
            a_ResultInfo->setBoolResult(false);
            delete l_ResultInfo[0];
            delete l_ResultInfo[1];
            return EvaluateBase_OK;
        }
    } else {
        delete l_ResultInfo[0];
        delete l_ResultInfo[1];
        return EvaluateBase_NG;
    }
}
