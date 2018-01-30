#include <ConditionResult.h>

ConditionResult::ConditionResult() {
    Config* L_Config =  Config::getInstance();
    std::string* l_PramName = new std::string("MaxFactNum");
    L_Config->getSgIntValue(l_PramName, &m_MaxFactNum);
    delete l_PramName;
    l_PramName = new std::string("MaxConditionNum");
    L_Config->getSgIntValue(l_PramName, &m_MaxConditionNum);
    delete l_PramName;
    m_FactResult = new int*[m_MaxConditionNum];
    for(int l_Count = 0; l_Count < m_MaxConditionNum; l_Count++){
        m_FactResult[l_Count] = new int[m_MaxFactNum];
    }
    m_CurrentResultIndex = -1;
    initialize();
}

int ConditionResult::setResult(int a_ConditionID, int* a_Result) {
    memcpy(m_FactResult[a_ConditionID],a_Result,m_MaxFactNum*sizeof(int));
    return ConditionResult_OK;
}

int ConditionResult::getResult(int a_ConditionID, int* a_Result) {
    memcpy(a_Result,m_FactResult[a_ConditionID],m_MaxFactNum*sizeof(int));
    return ConditionResult_OK;
}

int ConditionResult::getMaxConditionNum(){
    return m_MaxConditionNum;
}

int ConditionResult::getMaxFactNum(){
    return m_MaxFactNum;
}

int ConditionResult::initialize(){
    for(int l_Count1 = 0; l_Count1 < m_MaxConditionNum; l_Count1++){
        for(int l_Count2 = 0; l_Count2 < m_MaxFactNum; l_Count2++){
            m_FactResult[l_Count1][l_Count2] = ConditionResult_NO_Eval;
        }
    }
    return 0;
}

ConditionResult::~ConditionResult(){
    for(int l_Count = 0; l_Count < m_MaxConditionNum; l_Count++){
        delete[] m_FactResult[l_Count];
    }
    delete[] m_FactResult;
}
