#ifndef Default_EvaluateOr_H
#define Default_EvaluateOr_H

#include <EvaluateBase.h>
#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>

class EvaluateOr : public EvaluateBase {

public :
    EvaluateOr();
    int evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo);
};


#endif
