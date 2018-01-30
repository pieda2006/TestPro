#include <Agenda.h>

Agenda::Agenda() {
}

int Agenda::executeAction(DecisdeActionAnswer* a_OutPutMessage, FactList* a_FactList, ConditionResult* a_Result) {
    m_ActionList.sort();

    std::list<ActionInfo*>::iterator l_BeginAction = m_ActionList.begin();
    std::list<ActionInfo*>::iterator l_EndAction = m_ActionList.end();
    std::list<ActionInfo*>::iterator l_ActionIte;
    int l_Result = ActionBase_OK;


    for(l_ActionIte = l_BeginAction; l_ActionIte != l_EndAction; ++l_ActionIte){
        l_Result = (*l_ActionIte)->executeAction(a_FactList, a_OutPutMessage, a_Result);
        if(l_Result == ActionInfo_FactChange) {
	    return Agenda_Retry;
	} else if(l_Result == ActionInfo_NG){
	    return Agenda_NG;
	}
    }
    return Agenda_Complete;
}

int Agenda::registConditionAction(ActionBase* a_Action, int a_ConditionID, bool a_EvaluateResult) {
    ActionInfo* l_ActionInfo = new ActionInfo();
    l_ActionInfo->setAction(a_Action);
    l_ActionInfo->setConditionID(a_ConditionID);
    l_ActionInfo->setResult(a_EvaluateResult);
    m_ActionList.insert(m_ActionList.begin(), l_ActionInfo);
    return Agenda_OK;
}
int Agenda::clearAction(){
    m_ActionList.clear();
    return Agenda_OK;
}

Agenda::~Agenda(){
   std::list<ActionInfo*>::iterator l_ite = m_ActionList.begin();
   std::list<ActionInfo*>::iterator l_end = m_ActionList.end();
   
   for(; l_ite != l_end; ++l_ite){
       if(*l_ite != NULL){
           delete *l_ite;       
       }
   }
   m_ActionList.clear();
}
