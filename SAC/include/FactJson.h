#ifndef Default_FactJson_H
#define Default_FactJson_H

#include <picojson.h>
#include <FactBase.h>

class FactJson : public FactBase{
    public :

    picojson::value m_value;

    int setJsonValue(picojson::value a_value);
    int getStringParam(picojson::array a_ParamName, std::string** a_StringValue);
    int getIntParam(picojson::array a_ParamName, int* a_IntValue);
};
#endif
