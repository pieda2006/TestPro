#include <EvaluateCompare.h>

EvaluateCompare::EvaluateCompare(){
    setOperationType(4);
}

int EvaluateCompare::evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo){

    ResultInfo* l_ResultInfo[2];
    l_ResultInfo[0] = new ResultInfo();
    l_ResultInfo[1] = new ResultInfo();

    std::string* l_StringValue[2];

    m_EvaluateObject[0]->evaluateConditionImple(a_Fact, a_Value, l_ResultInfo[0]);
    m_EvaluateObject[1]->evaluateConditionImple(a_Fact, a_Value, l_ResultInfo[1]);

    a_ResultInfo->setResultType(ResultInfo_Bool);

    if(l_ResultInfo[0]->getResultType() == ResultInfo_INT &&
       l_ResultInfo[1]->getResultType() == ResultInfo_INT){
        if(l_ResultInfo[0]->getIntResult() < l_ResultInfo[1]->getIntResult()){
            a_ResultInfo->setBoolResult(true);
            return EvaluateBase_OK;
        } else {
            a_ResultInfo->setBoolResult(false);
            return EvaluateBase_OK;
        }
    } else {
        return EvaluateBase_NG;
    }
}
