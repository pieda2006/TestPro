#ifndef Default_EvaluateCompare_H
#define Default_EvaluateCompare_H

#include <EvaluateBase.h>
#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>

class EvaluateCompare : public EvaluateBase {

public :
    EvaluateCompare();
    int evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo);
};


#endif
