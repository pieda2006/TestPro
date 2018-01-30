#ifndef Default_EvaluateAnd_H
#define Default_EvaluateAnd_H

#include <EvaluateBase.h>
#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>

class EvaluateAnd : public EvaluateBase {

public :
    EvaluateAnd();
    int evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo);
};


#endif
