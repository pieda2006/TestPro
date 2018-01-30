#ifndef Default_FactFactory_H
#define Default_FactFactory_H

#include <FactBase.h>
#include <picojson.h>
#include <sys/time.h>
#include <DecisdeActionRequest.h>
#include <FactList.h>
#include <FactJson.h>
#include <DecisdeActionReqJson.h>
#include <DecisdeActionReqProtobuf.h>
#include <FactProtobuf.h>
#include <google/protobuf/message.h>

#define FactFactory_OK 0
#define FactFactory_NG -1

class FactFactory {
public :

    FactFactory();


    int createFact(DecisdeActionRequest* a_InputInfo, FactList** a_FactList);


    static FactFactory* getInstance();
    static FactFactory* m_FactFactory;
};

#endif
