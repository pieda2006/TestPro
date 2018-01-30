#ifndef Default_EvaluateElement_H
#define Default_EvaluateElement_H

#include <EvaluateBase.h>
#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>
#include <vector>
#include <sstream>
#include <EvaluateValue.h>

class EvaluateElement : public EvaluateValue {
    public :

    EvaluateElement();
    int evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo);
};

#endif
