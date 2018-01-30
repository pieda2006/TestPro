#ifndef Default_EvaluateBase_H
#define Default_EvaluateBase_H

#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>
#include <Config.h>

#define EvaluateBase_OK 0
#define EvaluateBase_NG -1
#define EvaluateBase_None 0
#define EvaluateBase_INT 1
#define EvaluateBase_String 2
#define EvaluateBase_Bool 3

class EvaluateBase {
public :

    int m_OperationType;
    int m_EvaluateObjectCount;
    int m_EvaluateObjectNum;
    EvaluateBase** m_EvaluateObject;

    EvaluateBase();
    int setOperationType(int a_OperationType);
    int getOperationType();
    int setEvaluateBase(EvaluateBase* a_EvaluateBase);
    virtual int evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo);
};
#endif
