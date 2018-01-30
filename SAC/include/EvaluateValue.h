#ifndef Default_EvaluateValue_H
#define Default_EvaluateValue_H

#include <EvaluateBase.h>
#include <FactBase.h>
#include <picojson.h>
#include <ResultInfo.h>
#include <vector>
#include <sstream>

class EvaluateValue : public EvaluateBase {

public :

    picojson::array m_PramName;
    int m_PramType;

    EvaluateValue();
    int setPramName(picojson::array a_PramName);
    int setPramType(int a_PramType);
};


#endif
