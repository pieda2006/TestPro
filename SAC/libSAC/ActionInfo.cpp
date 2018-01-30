#include <ActionInfo.h>

ActionInfo::ActionInfo(){
	m_ActionBase = NULL;
	m_ConditionID = -1;
	m_ConditionResult = false;
}

int ActionInfo::setAction(ActionBase* a_Action){
    m_ActionBase = a_Action;
    return ActionInfo_OK;
}

int ActionInfo::setConditionID(int a_ConditionID){
    m_ConditionID = a_ConditionID;
    return ActionInfo_OK;
}

int ActionInfo::setResult(bool a_Result){
    m_ConditionResult = a_Result;
    return ActionInfo_OK;
}

int ActionInfo::executeAction(FactList* a_FactList, DecisdeActionAnswer* a_OutputMessage, ConditionResult* a_ConditionResult){
    m_ActionBase->executeAction(a_FactList, a_OutputMessage, a_ConditionResult, m_ConditionID, m_ConditionResult);
    return ActionInfo_OK;
}

bool ActionInfo::operator<(ActionInfo& a_RightActionInfo){
	if(this->m_ActionBase == NULL || a_RightActionInfo.m_ActionBase == NULL){
	    return false;
	}
    if(this->m_ActionBase->getPrecedence() < a_RightActionInfo.m_ActionBase->getPrecedence()){
        return true;
    } else {
        return false;
    }
}
