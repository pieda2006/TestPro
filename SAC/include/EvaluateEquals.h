#ifndef Default_EvaluateEquals_H
#define Default_EvaluateEquals_H

#include <EvaluateBase.h>
#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>

class EvaluateEquals : public EvaluateBase {

public :
    EvaluateEquals();
    int evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo);
};


#endif
