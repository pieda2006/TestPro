#include <EvaluateAnd.h>

EvaluateAnd::EvaluateAnd(){
    setOperationType(5);
}

int EvaluateAnd::evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo){

    ResultInfo** l_ResultInfo;
    a_ResultInfo->setResultType(ResultInfo_Bool);

    if(m_EvaluateObjectCount <= 1){
        return EvaluateBase_NG;
    }

    for(int l_count = 0; l_count < m_EvaluateObjectCount; l_count++ ){
        l_ResultInfo[l_count] = new ResultInfo();
    }

    for(int l_count = 0; l_count < m_EvaluateObjectCount; l_count++){
        m_EvaluateObject[l_count]->evaluateConditionImple(a_Fact, a_Value, l_ResultInfo[l_count]);
        if(l_ResultInfo[l_count]->getResultType() == ResultInfo_Bool){
            if(l_ResultInfo[l_count]->getBoolResult() == false){
                a_ResultInfo->setBoolResult(false);
                return EvaluateBase_OK;
            }
        } else {
            return EvaluateBase_NG;
        }
    }
    a_ResultInfo->setBoolResult(true);
    return EvaluateBase_OK;
}
