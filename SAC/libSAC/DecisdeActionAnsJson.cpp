#include <DecisdeActionAnsJson.h>

pthread_key_t DecisdeActionAnsJson::m_pthread_key;
pthread_once_t DecisdeActionAnsJson::buffer_key_once = PTHREAD_ONCE_INIT;

DecisdeActionAnsJson::DecisdeActionAnsJson(){
    m_Message = NULL;
    setMessageType(DecisdeActionAnswer_JSON);
}

DecisdeActionAnsJson* DecisdeActionAnsJson::getInstance(){
    DecisdeActionAnsJson* l_DecisdeActionAnsJson = NULL;
    pthread_once(&DecisdeActionAnsJson::buffer_key_once, DecisdeActionAnsJson::init_routine);
    l_DecisdeActionAnsJson = (DecisdeActionAnsJson*)pthread_getspecific(DecisdeActionAnsJson::m_pthread_key);
    if(l_DecisdeActionAnsJson == NULL){
        pthread_key_create(&DecisdeActionAnsJson::m_pthread_key, DecisdeActionAnsJson::DecisdeActionAnsJson_Destroy);
        l_DecisdeActionAnsJson = new DecisdeActionAnsJson();
        pthread_setspecific(DecisdeActionAnsJson::m_pthread_key, l_DecisdeActionAnsJson);
    }
    l_DecisdeActionAnsJson->initialize();
    return l_DecisdeActionAnsJson;
}

int DecisdeActionAnsJson::getActionInfo(picojson::value* a_value){
    if(!m_value.is<picojson::null>()){
        *a_value = m_value;
        return DecisdeActionAnswer_OK;
    } else {
       return DecisdeActionAnswer_NODATA; 
    }
}

int DecisdeActionAnsJson::setActionInfo(picojson::value a_value){
    m_value = a_value;
    m_Message = new std::string(a_value.serialize().c_str());
    return DecisdeActionAnswer_OK;
}

int DecisdeActionAnsJson::setActionInfo(std::string* a_ActionInfo){
    m_Message = a_ActionInfo;
    m_value = picojson::value(*a_ActionInfo);
}

int DecisdeActionAnsJson::getActionInfo(std::string** a_Message){
   if(m_Message != NULL){
       *a_Message = m_Message;
       return DecisdeActionAnswer_OK;
   } else {
       return DecisdeActionAnswer_NODATA;
   }
}

int DecisdeActionAnsJson::initialize(){
    if(m_Message == NULL){
        return DecisdeActionAnswer_OK; 
    }
    delete m_Message;
    m_Message = NULL;
    return DecisdeActionAnswer_OK;
}

void DecisdeActionAnsJson::init_routine(){
    pthread_key_create(&DecisdeActionAnsJson::m_pthread_key, DecisdeActionAnsJson::DecisdeActionAnsJson_Destroy);
    pthread_setspecific(DecisdeActionAnsJson::m_pthread_key, NULL);   
}

void DecisdeActionAnsJson::DecisdeActionAnsJson_Destroy(void* a_Object){
    DecisdeActionAnsJson* l_DecisdeActionAnsJson = (DecisdeActionAnsJson*)a_Object;
    delete l_DecisdeActionAnsJson;
}



