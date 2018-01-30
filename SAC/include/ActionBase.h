#ifndef Default_ActionBase_H
#define Default_ActionBase_H

#include <FactList.h>
#include <Agenda.h>
#include <ConditionResult.h>
#include <DecisdeActionAnswer.h>
#include <picojson.h>
#include <ExecuteBase.h>

#define ActionBase_OK 0
#define ActionBase_NG -1
#define ActionBase_FactChange 1



class ActionBase {
public :

    virtual int executeAction(FactList* a_FactList, DecisdeActionAnswer* a_OutputMessage, ConditionResult* a_ConditionResult, int a_CondtionID, bool a_Result);
    
    ActionBase();

    ActionBase(ActionBase* a_ActionBase);
    
    int setActionID(int a_ActionID);
    
    int setActionType(int a_ActionType);
    
    int setPrecedence(int a_Precedence);

    int setExecuteObj(ExecuteBase* a_Execute);

    int getActionType();
    
    int getPrecedence();
    
    int setJsonValue(picojson::value a_jsonvalue);

    ExecuteBase* getExecuteObj();

    int m_ActionID;
    
    int m_ActionType;
    
    int m_Precedence;
    
    ExecuteBase* m_ExecuteBase;

    picojson::value m_jsonvalue;    

};

#endif
