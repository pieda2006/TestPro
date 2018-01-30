#ifndef Default_Agenda_H
#define Default_Agenda_H

#include <list>
#include <iterator>
#include <ActionBase.h>
#include <ActionInfo.h>
#include <DecisdeActionAnswer.h>
#include <FactList.h>
#include <ConditionResult.h>

#define Agenda_OK 1
#define Agenda_NG -1
#define Agenda_Complete 0
#define Agenda_Retry 1

class ActionBase;
class ActionInfo;

class Agenda {
public :

    Agenda();
    ~Agenda();
    int executeAction(DecisdeActionAnswer* a_OutPutMessage, FactList* a_FactList, ConditionResult* a_Result);
    int registConditionAction(ActionBase* a_Action, int a_ConditionID, bool a_EvaluateResult);
    int clearAction();

private :

    std::list<ActionInfo*> m_ActionList;
    
};

#endif
