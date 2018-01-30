#include <ConditionBase.h>
#include <string>

ConditionBase::ConditionBase(ConditionBase* a_ConditionBase){
    m_ConditionType = a_ConditionBase->getConditionType();
    m_EvaluateObject = a_ConditionBase->getEvaluateObj();
    m_MessageName = a_ConditionBase->getMessageName();
    m_MaxActionNum = a_ConditionBase->getMaxActionNum();
    m_TrueAction = new ActionBase*[m_MaxActionNum];
    m_FalseAction = new ActionBase*[m_MaxActionNum];
    for(int l_Counter = 0; l_Counter < m_MaxActionNum; l_Counter++){
        m_TrueAction[l_Counter] = NULL;
        m_FalseAction[l_Counter] = NULL;
    }
    m_FalseCondition = NULL;
    m_TrueCondition = NULL;
    m_ConditionID = -1;
    m_TrueActionNum = 0;
    m_FalseActionNum = 0;
}

int ConditionBase::evaluateCondition(FactList* a_InputFact, Agenda* a_Action, ConditionResult* a_ConditionResult) {

    int l_ConditionChang = a_InputFact->judgeChange(m_MessageName);
    int l_ResultType = 0;
    int l_ConditionResult = 0;
    int l_FactCount = 0;

    int* l_Result = new int[a_ConditionResult->getMaxFactNum()];

    FactBase* l_FactBase = NULL;
    std::multimap<int, FactBase*>::iterator l_Fact;
    ResultInfo* l_ResultInfo = new ResultInfo();
    if(l_ConditionChang == FactList_UPDATE) {
        l_FactCount = a_InputFact->getFact(m_MessageName, &l_Fact);
        for(int l_Counter = 0; l_Counter < l_FactCount; l_Counter++){
            l_FactBase = l_Fact->second;
            m_EvaluateObject->evaluateConditionImple(l_FactBase, &m_value, l_ResultInfo);
            l_ResultType = l_ResultInfo->getResultType();
            if(l_ResultType == ResultInfo_Bool){
                l_Result[l_FactBase->getFactID()] = l_ResultInfo->getBoolResult();
                if(l_ResultInfo->getBoolResult() == true){
                    l_ConditionResult = l_ConditionResult | ConditionBase_True;
                } else {
                    l_ConditionResult = l_ConditionResult | ConditionBase_False;
                }
            } else {
                return ConditionBase_NG;
            }
        }
    } else {
        a_ConditionResult->getResult(m_ConditionID,l_Result);
        l_FactCount = a_InputFact->getFact(m_MessageName, &l_Fact);
        for(int l_Counter = 0; l_Counter < l_FactCount; l_Counter++){
            l_ConditionResult = l_ConditionResult | l_Result[l_FactCount];
        }
    }

    int l_ActionNum;
    ActionBase** l_ActionBase = NULL;
    int l_TrueFalse;
    l_TrueFalse = l_ConditionResult & ConditionBase_True;
    if(l_TrueFalse > 0){
        getTrueAction(&l_ActionBase, &l_ActionNum);
        for(int l_Counter = 0; l_Counter < l_ActionNum; l_Counter++){
            a_Action->registConditionAction(l_ActionBase[l_Counter], m_ConditionID, true);
        }
        if(m_TrueCondition != NULL){
            m_TrueCondition->evaluateCondition(a_InputFact,a_Action, a_ConditionResult);
        }
    }
    l_TrueFalse = l_ConditionResult & ConditionBase_False;
    if(l_TrueFalse > 0){
        getFalseAction(&l_ActionBase, &l_ActionNum);
        for(int l_Counter = 0; l_Counter < l_ActionNum; l_Counter++){
            a_Action->registConditionAction(l_ActionBase[l_Counter], m_ConditionID, false);
        }
        if(m_FalseCondition != NULL){
            m_FalseCondition->evaluateCondition(a_InputFact, a_Action, a_ConditionResult);
        }
    }
    delete l_ResultInfo;
    delete[] l_Result;

    return ConditionBase_OK;
}

ConditionBase::ConditionBase() {
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("MaxActionNum");
    l_Config->getSgIntValue(l_ParamName, &m_MaxActionNum);
    delete l_ParamName;
    m_TrueAction = new ActionBase*[m_MaxActionNum];
    m_FalseAction = new ActionBase*[m_MaxActionNum];
    for(int l_Counter = 0; l_Counter < m_MaxActionNum; l_Counter++){
        m_TrueAction[l_Counter] = NULL;
        m_FalseAction[l_Counter] = NULL;
    }
    m_FalseCondition = NULL;
    m_TrueCondition = NULL;
    m_ConditionID = -1;
    m_ConditionType = -1;
    m_TrueActionNum = 0;
    m_FalseActionNum = 0;
    m_MessageName = NULL;
}
int ConditionBase::getFalseAction(ActionBase*** a_Action, int* a_ActionNum){
    *a_Action = m_FalseAction;
    *a_ActionNum = m_FalseActionNum;
    return ConditionBase_OK;
}

int ConditionBase::getTrueAction(ActionBase*** a_Action, int* a_ActionNum){
    *a_Action = m_TrueAction;
    *a_ActionNum = m_TrueActionNum;


    return ConditionBase_OK;
}

ConditionBase* ConditionBase::getNextFalseCondition() {
    return m_FalseCondition;
}

ConditionBase* ConditionBase::getNextTrueCondition() {
    return m_TrueCondition;
}

int ConditionBase::setConditionID(int a_ConditionID) {
    m_ConditionID = a_ConditionID;
    return ConditionBase_OK;
}

int ConditionBase::setConditionType(int a_ContionType) {
    m_ConditionType = a_ContionType;
    return ConditionBase_OK;
}

int ConditionBase::setFalseAction(ActionBase* a_Action) {
    m_FalseAction[m_FalseActionNum] = a_Action;
    m_FalseActionNum++;
    return ConditionBase_OK;
}

int ConditionBase::setNextFalseCondition(ConditionBase* a_Condition) {
    m_FalseCondition = a_Condition;
    return ConditionBase_OK;
}

int ConditionBase::setNextTrueCondition(ConditionBase* a_Condition) {
    m_TrueCondition = a_Condition;
    return ConditionBase_OK;
}

int ConditionBase::setTrueAction(ActionBase* a_Action) {
    m_TrueAction[m_TrueActionNum] = a_Action;
    m_TrueActionNum++;
    return ConditionBase_OK;
}

int ConditionBase::setMessageName(std::string* a_MessageName){
    m_MessageName = a_MessageName;
    return ConditionBase_OK;
}

int ConditionBase::setJsonValue(picojson::value a_value){
    m_value = a_value;
    return ConditionBase_OK;
}

int ConditionBase::setEvaluateObj(EvaluateBase* a_EvaluateObj){
    m_EvaluateObject = a_EvaluateObj;
    return ConditionBase_OK;
}

int ConditionBase::getConditionType(){
    return m_ConditionType;
}

EvaluateBase* ConditionBase::getEvaluateObj(){
    return m_EvaluateObject;
}

std::string* ConditionBase::getMessageName(){
    return m_MessageName;
}

int ConditionBase::getMaxActionNum(){
    return m_MaxActionNum;
}

int ConditionBase::getConditionId(){
    return m_ConditionID;
}

