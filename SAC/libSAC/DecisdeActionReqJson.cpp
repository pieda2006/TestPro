#include <DecisdeActionReqJson.h>

pthread_key_t DecisdeActionReqJson::m_pthread_key;
pthread_once_t DecisdeActionReqJson::buffer_key_once = PTHREAD_ONCE_INIT;

DecisdeActionReqJson::DecisdeActionReqJson(){
    std::string* l_ParamName = new std::string("MaxFactTypeNum");
    Config* l_Config = Config::getInstance();
    l_Config->getSgIntValue(l_ParamName, &m_MaxInputMessage);
    delete l_ParamName;
    m_Jsonvalue = new std::string*[m_MaxInputMessage];
    m_value = new picojson::value[m_MaxInputMessage];
    m_FactCounter = 0;
    setMessageType(DecisdeActionRequest_JSON);
}

DecisdeActionReqJson* DecisdeActionReqJson::getInstance(){
    DecisdeActionReqJson* l_DecisdeActionReqJson = NULL;
    pthread_once(&DecisdeActionReqJson::buffer_key_once, DecisdeActionReqJson::init_routine);
    l_DecisdeActionReqJson = (DecisdeActionReqJson*)pthread_getspecific(DecisdeActionReqJson::m_pthread_key);
    if(l_DecisdeActionReqJson == NULL){
        l_DecisdeActionReqJson = new DecisdeActionReqJson();
        pthread_setspecific(DecisdeActionReqJson::m_pthread_key, l_DecisdeActionReqJson);
    }
    l_DecisdeActionReqJson->initialize();
    return l_DecisdeActionReqJson;
}

int DecisdeActionReqJson::setFactInfo(std::string* a_FactInfo){
    m_Jsonvalue[m_FactCounter] = a_FactInfo;
    m_value[m_FactCounter] = picojson::value(*a_FactInfo);
    m_FactCounter++;
}

int DecisdeActionReqJson::getFactInfo(picojson::value** a_value){
    *a_value = m_value;
    return m_FactCounter;
}

int DecisdeActionReqJson::setFactInfo(picojson::value a_value){
    m_Jsonvalue[m_FactCounter] = new std::string(a_value.serialize().c_str());
    m_value[m_FactCounter] = a_value;
    m_FactCounter++;
}

int DecisdeActionReqJson::getFactInfo(std::string*** a_FactInfo){
   *a_FactInfo = m_Jsonvalue;
   return m_FactCounter;
}

int DecisdeActionReqJson::initialize(){
    for(int l_Counter = 0; l_Counter < m_FactCounter; l_Counter++){
        if(m_Jsonvalue[l_Counter] != NULL){
            delete m_Jsonvalue[l_Counter];
        }
    }
    m_FactCounter = 0;
}

void DecisdeActionReqJson::init_routine(){
    pthread_key_create(&DecisdeActionReqJson::m_pthread_key, DecisdeActionReqJson::DecisdeActionReqJson_Destroy);
    pthread_setspecific(DecisdeActionReqJson::m_pthread_key, NULL);
}

void DecisdeActionReqJson::DecisdeActionReqJson_Destroy(void* a_Object){
    DecisdeActionReqJson* l_DecisdeActionReqJson = (DecisdeActionReqJson*)a_Object;
    delete l_DecisdeActionReqJson;
}

