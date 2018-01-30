#include <DecisdeActionReqProtobuf.h>

pthread_key_t DecisdeActionReqProtobuf::m_pthread_key;
pthread_once_t DecisdeActionReqProtobuf::buffer_key_once = PTHREAD_ONCE_INIT;

DecisdeActionReqProtobuf::DecisdeActionReqProtobuf(){
    std::string* l_ParamName = new std::string("MaxFactTypeNum");
    Config* l_Config = Config::getInstance();
    l_Config->getSgIntValue(l_ParamName, &m_MaxInputMessage);
    delete l_ParamName;
    m_Message = new google::protobuf::Message*[m_MaxInputMessage];
    for(int l_count = 0;l_count < m_MaxInputMessage; l_count++){
        m_Message[l_count] = NULL;
    }
    m_FactCounter = 0;
    setMessageType(DecisdeActionRequest_Protobuf);
}

DecisdeActionReqProtobuf* DecisdeActionReqProtobuf::getInstance(){
    DecisdeActionReqProtobuf* l_DecisdeActionReqProtobuf = NULL;
    pthread_once(&DecisdeActionReqProtobuf::buffer_key_once, DecisdeActionReqProtobuf::init_routine);
    l_DecisdeActionReqProtobuf = (DecisdeActionReqProtobuf*)pthread_getspecific(DecisdeActionReqProtobuf::m_pthread_key);

    if(l_DecisdeActionReqProtobuf == NULL){
       l_DecisdeActionReqProtobuf = new DecisdeActionReqProtobuf();
        pthread_setspecific(DecisdeActionReqProtobuf::m_pthread_key, l_DecisdeActionReqProtobuf);
    }
    l_DecisdeActionReqProtobuf->initialize();
    return l_DecisdeActionReqProtobuf;
}

int DecisdeActionReqProtobuf::setFactInfo(google::protobuf::Message* a_FactInfo){
    m_Message[m_FactCounter] = a_FactInfo;
    m_FactCounter++;
}

int DecisdeActionReqProtobuf::getFactInfo(google::protobuf::Message*** a_FactInfo){
   *a_FactInfo = m_Message;
   return m_FactCounter;
}

int DecisdeActionReqProtobuf::initialize(){
    for(int l_Counter = 0; l_Counter < m_FactCounter; l_Counter++){
        if(m_Message[l_Counter] != NULL){
/*
            delete m_Message[l_Counter];
*/
        }
    }
    m_FactCounter = 0;
}

void DecisdeActionReqProtobuf::init_routine(){
    pthread_key_create(&DecisdeActionReqProtobuf::m_pthread_key, DecisdeActionReqProtobuf::DecisdeActionReqProtobuf_Destroy);
    pthread_setspecific(DecisdeActionReqProtobuf::m_pthread_key, NULL);
}

void DecisdeActionReqProtobuf::DecisdeActionReqProtobuf_Destroy(void* a_Object){
    DecisdeActionReqProtobuf* l_DecisdeActionReqProtobuf = (DecisdeActionReqProtobuf*)a_Object;
    delete l_DecisdeActionReqProtobuf;
}

