#ifndef Default_ResultInfo_H
#define Default_ResultInfo_H

#include <string>

#define ResultInfo_OK 0
#define ResultInfo_NG -1

#define ResultInfo_None 0
#define ResultInfo_INT 1
#define ResultInfo_String 2
#define ResultInfo_Bool 3

class ResultInfo {
public :
    int m_ResultType;
    int m_IntResult;
    std::string* m_StringResult;
    bool m_BoolResult;
    int m_TotalResult;

    ResultInfo();
    ~ResultInfo();
    int setResultType(int a_ResultType);
    int getResultType();
    int setIntResult(int a_IntResult);
    int getIntResult();
    int setStringResult(std::string* a_StringResult);
    std::string* getStringResult();
    int setBoolResult(bool a_BoolResult);
    bool getBoolResult();
    int initialize();
};
#endif
