#ifndef Default_ActionFactory_H
#define Default_ActionFactory_H

#define ActionFactory_OK 0
#define ActionFactory_NG -1

#include <string>
#include <picojson.h>
#include <ConditionBase.h>
#include <ActionBase.h>
#include <ExecuteBase.h>
#include <SetProtoBufAction.h>
#include <SetJsonAction.h>

class ActionBase;

class ActionFactory{

public :

    ActionFactory();
    static ActionFactory* getInstance();
    int CreateAction();
    ~ActionFactory();
    ActionBase* getAction(int a_ActionType);

private :

    static ActionFactory* m_ActionFactory;
    ActionBase** m_Action;
    int makeAction(std::string* a_fileName, ActionBase** a_Action);
    int makeOperation(picojson::value a_OperationValue, ExecuteBase** a_ExecuteBase);

};

#endif
