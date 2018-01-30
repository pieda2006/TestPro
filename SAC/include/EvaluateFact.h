#ifndef Default_EvaluateFact_H
#define Default_EvaluateFact_H

#include <EvaluateBase.h>
#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>
#include <vector>
#include <sstream>
#include <EvaluateValue.h>

class EvaluateFact : public EvaluateValue {

public :

    EvaluateFact();
    int evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo);
};


#endif
