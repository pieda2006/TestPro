#include <DecisdeActionAnsProtobuf.h>

pthread_key_t DecisdeActionAnsProtobuf::m_pthread_key;
pthread_once_t DecisdeActionAnsProtobuf::buffer_key_once = PTHREAD_ONCE_INIT;

DecisdeActionAnsProtobuf::DecisdeActionAnsProtobuf(){
    m_Message = NULL;
    setMessageType(DecisdeActionAnswer_Protobuf);
}

DecisdeActionAnsProtobuf* DecisdeActionAnsProtobuf::getInstance(){
    DecisdeActionAnsProtobuf* l_DecisdeActionAnsProtobuf = NULL;
    pthread_once(&DecisdeActionAnsProtobuf::buffer_key_once, DecisdeActionAnsProtobuf::init_routine);
    l_DecisdeActionAnsProtobuf = (DecisdeActionAnsProtobuf* )pthread_getspecific(DecisdeActionAnsProtobuf::m_pthread_key);
    if(l_DecisdeActionAnsProtobuf == NULL){
        l_DecisdeActionAnsProtobuf = new DecisdeActionAnsProtobuf();
        pthread_setspecific(DecisdeActionAnsProtobuf::m_pthread_key, l_DecisdeActionAnsProtobuf);
    }
    l_DecisdeActionAnsProtobuf->initialize();
    return l_DecisdeActionAnsProtobuf;
}

int DecisdeActionAnsProtobuf::setActionInfo(google::protobuf::Message* a_FactInfo){
    m_Message = a_FactInfo;
}

int DecisdeActionAnsProtobuf::getActionInfo(google::protobuf::Message** a_FactInfo){
   if(m_Message != NULL){
       *a_FactInfo = m_Message;
       return DecisdeActionAnswer_OK;
   } else {
       return DecisdeActionAnswer_NODATA; 
   }
}

int DecisdeActionAnsProtobuf::initialize(){
    if(m_Message != NULL){
        delete m_Message;
        m_Message = NULL;
    }
    return DecisdeActionAnswer_OK;
}

void DecisdeActionAnsProtobuf::init_routine(){
    pthread_key_create(&DecisdeActionAnsProtobuf::m_pthread_key, DecisdeActionAnsProtobuf::DecisdeActionAnsProtobuf_Destroy);
    pthread_setspecific(DecisdeActionAnsProtobuf::m_pthread_key, NULL);
}

void DecisdeActionAnsProtobuf::DecisdeActionAnsProtobuf_Destroy(void* a_Object){
    DecisdeActionAnsProtobuf* l_DecisdeActionAnsProtobuf = (DecisdeActionAnsProtobuf*)a_Object;
    delete l_DecisdeActionAnsProtobuf;
}

DecisdeActionAnsProtobuf::~DecisdeActionAnsProtobuf(){
    delete m_Message;
    pthread_setspecific(DecisdeActionAnsProtobuf::m_pthread_key, NULL);
}

