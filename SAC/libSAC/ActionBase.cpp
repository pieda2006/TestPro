#include <ActionBase.h>

int ActionBase::executeAction(FactList* a_FactList, DecisdeActionAnswer* a_OutputMessage, ConditionResult* a_ConditionResult, int a_CondtionID, bool a_Result) {

    ResultInfo* l_ResultInfo = new ResultInfo();
    m_ExecuteBase->executeActionImple(a_FactList, &m_jsonvalue, l_ResultInfo, a_OutputMessage , a_CondtionID ,a_Result, a_ConditionResult); 
    delete l_ResultInfo;

    return ActionBase_OK;
}

ActionBase::ActionBase() {
    m_ActionID = -1;
    m_Precedence = -1;
    m_ActionType = -1;
    m_ExecuteBase = NULL;
}

ActionBase::ActionBase(ActionBase* a_ActionBase) {
    m_ActionID = -1;
    m_Precedence = -1;
    m_ActionType = a_ActionBase->getActionType();
    m_ExecuteBase = a_ActionBase->getExecuteObj();
}

ExecuteBase* ActionBase::getExecuteObj(){
    return m_ExecuteBase;
}

int ActionBase::setActionID(int a_ActionID) {
	m_ActionID = a_ActionID;
	return ActionBase_OK;
}

int ActionBase::setActionType(int a_ActionType) {
	m_ActionType = a_ActionType;
	return ActionBase_OK;
}

int ActionBase::getPrecedence(){
    return m_Precedence;
}

int ActionBase::setJsonValue(picojson::value a_jsonvalue){
    m_jsonvalue = a_jsonvalue;
    return ActionBase_OK;
}


int ActionBase::getActionType(){
    return m_ActionType;
}

int ActionBase::setExecuteObj(ExecuteBase* a_Execute){
    m_ExecuteBase = a_Execute;
    return ActionBase_OK;
}

int ActionBase::setPrecedence(int a_Precedence){
	m_Precedence = a_Precedence;
	return ActionBase_OK;
}
