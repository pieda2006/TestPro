#include <ResultInfo.h>$

ResultInfo::ResultInfo(){
    initialize();
}

int ResultInfo::setResultType(int a_ResultType){
    m_ResultType = a_ResultType;
    return ResultInfo_OK;
}

int ResultInfo::getResultType(){
    return m_ResultType;
}

int ResultInfo::setIntResult(int a_IntResult){
    m_IntResult = a_IntResult;
    return ResultInfo_OK;
}

int ResultInfo::getIntResult(){
    return m_IntResult;
}

int ResultInfo::setStringResult(std::string* a_StringResult){
    m_StringResult = a_StringResult;
    return ResultInfo_OK;
}

std::string* ResultInfo::getStringResult(){
    return m_StringResult;
}

int ResultInfo::setBoolResult(bool a_BoolResult){
    m_BoolResult = a_BoolResult;
    return ResultInfo_OK;
}

bool ResultInfo::getBoolResult(){
    return m_BoolResult;
}

int ResultInfo::initialize(){
    m_ResultType = ResultInfo_None;
    m_IntResult = 0;
    m_StringResult = NULL;
    m_BoolResult = false;
    return ResultInfo_OK;
}

ResultInfo::~ResultInfo(){
    if(m_StringResult != NULL){
        delete m_StringResult;
    }
}
