#include <EvaluateBase.h>

EvaluateBase::EvaluateBase(){
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("EvaluateObjectNum");
    l_Config->getSgIntValue(l_ParamName, &m_EvaluateObjectNum);
    delete l_ParamName;
    m_EvaluateObject = new EvaluateBase*[m_EvaluateObjectNum];
    for(int l_Counter = 0; l_Counter < m_EvaluateObjectNum; l_Counter++){
        m_EvaluateObject[l_Counter] = NULL;
    }
    m_OperationType = -1;
    m_EvaluateObjectCount = 0;
}

int EvaluateBase::setOperationType(int a_OperationType){
    m_OperationType = a_OperationType;
    return EvaluateBase_OK;
}

int EvaluateBase::getOperationType(){
    return m_OperationType;
}

int EvaluateBase::setEvaluateBase(EvaluateBase* a_EvaluateBase){
    m_EvaluateObject[m_EvaluateObjectCount] = a_EvaluateBase;
    m_EvaluateObjectCount++;
    return EvaluateBase_OK;
}

int EvaluateBase::evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo){
    return EvaluateBase_OK;
}


