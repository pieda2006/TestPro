#ifndef Default_ExecuteBase_H
#define Default_ExecuteBase_H

#define ExecuteBase_OK 0
#define ExecuteBase_NG -1
#define ExecuteBase_None 0
#define ExecuteBase_INT 1
#define ExecuteBase_String 2
#define ExecuteBase_Bool 3

#include <ResultInfo.h>
#include <FactBase.h>
#include <picojson.h>
#include <DecisdeActionAnswer.h>
#include <Config.h>
#include <ConditionResult.h>
#include <FactList.h>

class ExecuteBase {
private :
    int m_OperationType;
    int m_ExecuteObjectCount;
    int m_ExecuteObjectNum;
    ExecuteBase** m_ExecuteObject;
public :
    ExecuteBase();
    int setOperationType(int a_OperationType);
    int getOperationType();
    int setExecuteBase(ExecuteBase* a_ExecuteBase);
    virtual int executeActionImple(FactList* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo, DecisdeActionAnswer *a_OutputMessage,int a_CondtionID, bool a_Result,ConditionResult* a_ConditionResult);

};
#endif
