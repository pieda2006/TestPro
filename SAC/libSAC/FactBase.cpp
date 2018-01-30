#include <FactBase.h>
#include <FactList.h>
#include <DecisdeActionRequest.h>
 
FactBase::FactBase() {
    m_FactType = FactBase_NOSET;
    m_FactID = FactBase_NOSET;
    m_MessageName = NULL;
}

int FactBase::setFactID(int a_FactID) {
    m_FactID = a_FactID;
    return FactBase_OK;
}

int FactBase::getFactID() {
    return m_FactID;
}

int FactBase::setFactType(int a_FactType) {
    m_FactType = a_FactType;
    return FactBase_OK;
}

int FactBase::getFactType() {
    return m_FactType;
}

int FactBase::getMessageName(std::string** a_MessageName){

    *a_MessageName = new std::string(*m_MessageName);

}

int FactBase::setMessageName(std::string* a_MessageName){
    m_MessageName = a_MessageName;
}

int FactBase::getStringParam(picojson::array a_ParamName, std::string** a_StringValue){
    return FactBase_NG;    
}

int FactBase::getIntParam(picojson::array a_ParamName, int* a_IntValue){
    return FactBase_NG;
}

FactBase::~FactBase(){
    if(m_MessageName != NULL){
        delete m_MessageName;
    }
}
