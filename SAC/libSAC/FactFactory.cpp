#include <FactFactory.h>

#include <iostream>
#include <fstream>
#include <string>

FactFactory* FactFactory::m_FactFactory = NULL;

FactFactory::FactFactory() {
}

int FactFactory::createFact(DecisdeActionRequest *a_InputInfo, FactList **a_FactList) {

    FactList* l_FactList = new FactList();
    int l_MessageType = a_InputInfo->getMessageType();

    if(l_MessageType == DecisdeActionRequest_JSON){
        DecisdeActionReqJson* l_DecisdeActionReqJson = (DecisdeActionReqJson*)a_InputInfo;
        std::string** l_JsonString;
        int l_InputNum = l_DecisdeActionReqJson->getFactInfo(&l_JsonString);

        FactJson* l_FactJson;
        picojson::value l_JsonValue;

        for(int l_Count = 0; l_Count < l_InputNum; l_Count++){
            picojson::parse(l_JsonValue, *l_JsonString[l_Count]);
            std::string* l_MessageName;
            l_MessageName = new std::string(l_JsonValue.get<picojson::object>()["MessageName"].get<std::string>());
            l_FactJson = new FactJson();
            l_FactJson->setJsonValue(l_JsonValue);
            l_FactJson->setMessageName(l_MessageName);
            l_FactList->setFact(l_FactJson);
        }
    }
     else if(l_MessageType == DecisdeActionRequest_Protobuf){
        DecisdeActionReqProtobuf* l_DecisdeActionReqProtobuf = (DecisdeActionReqProtobuf*)a_InputInfo;
        google::protobuf::Message** l_Message;
        int l_InputNum = l_DecisdeActionReqProtobuf->getFactInfo(&l_Message);
        FactProtobuf* l_FactProtoBuf;

        for(int l_Count = 0; l_Count < l_InputNum; l_Count++){
            std::string* l_MessageName;
            l_MessageName = new std::string(l_Message[l_Count]->GetDescriptor()->name());
            l_FactProtoBuf = new FactProtobuf();
            l_FactProtoBuf->setProtobufValue(l_Message[l_Count]);
            l_FactProtoBuf->setMessageName(l_MessageName);
            l_FactList->setFact(l_FactProtoBuf);
        }
    }

    *a_FactList = l_FactList;
    return FactFactory_OK;
}

FactFactory* FactFactory::getInstance() {
    if(m_FactFactory == NULL) {
        m_FactFactory = new FactFactory();
    }
    return m_FactFactory;
}
