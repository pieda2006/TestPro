#include <ExecuteBase.h>$

ExecuteBase::ExecuteBase(){
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("ExecuteObjectNum");
    l_Config->getSgIntValue(l_ParamName, &m_ExecuteObjectNum);
    delete l_ParamName;
    m_ExecuteObject = new ExecuteBase*[m_ExecuteObjectNum];
    for(int l_Counter = 0; l_Counter < m_ExecuteObjectNum; l_Counter++){
        m_ExecuteObject[l_Counter] = NULL;
    }
    m_OperationType = -1;
    m_ExecuteObjectCount = 0;
}

int ExecuteBase::setOperationType(int a_OperationType){
    m_OperationType = a_OperationType;
    return ExecuteBase_OK;
}

int ExecuteBase::getOperationType(){
    return m_OperationType;
}

int ExecuteBase::setExecuteBase(ExecuteBase* a_ExecuteBase){
    m_ExecuteObject[m_ExecuteObjectCount] = a_ExecuteBase;
    m_ExecuteObjectCount++;
    return ExecuteBase_OK;
}

int ExecuteBase::executeActionImple(FactList* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo, DecisdeActionAnswer* a_OutputMessage, int a_CondtionID, bool a_Result,ConditionResult* a_ConditionResult){
    return ExecuteBase_OK;
}


