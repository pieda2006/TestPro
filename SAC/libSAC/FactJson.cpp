#include <FactJson.h>$

int FactJson::setJsonValue(picojson::value a_value){
    m_value = a_value;
}

int FactJson::getStringParam(picojson::array a_ParamName, std::string** a_StringValue){
    int l_Depth;
    l_Depth = a_ParamName.size();
    int l_counter;
    picojson::value l_Value;
    l_Value = m_value;

    try {
        for(l_counter = 0; l_counter < l_Depth-1; l_counter++){
            l_Value = l_Value.get<picojson::object>()[a_ParamName[l_counter].get<std::string>()];
        }
        std::string* l_StringValue = new std::string();
        *l_StringValue = l_Value.get<picojson::object>()[a_ParamName[l_counter].get<std::string>()].get<std::string>();
        *a_StringValue = l_StringValue;
    } catch (const std::runtime_error& e) {
        return FactBase_NOSET;
    }

    return FactBase_OK;
}

int FactJson::getIntParam(picojson::array a_ParamName, int* a_IntValue){
    int l_Depth;
    l_Depth = a_ParamName.size();
    int l_counter;
    picojson::value l_Value;
    l_Value = m_value;
    try {
        for(l_counter = 0; l_counter < l_Depth-1; l_counter++){
            l_Value = l_Value.get<picojson::object>()[a_ParamName[l_counter].get<std::string>()];
        }
        int l_IntValue;
        picojson::value l_numval = l_Value.get<picojson::object>()[a_ParamName[l_counter].get<std::string>()];
        l_IntValue = (int)l_numval.get<double>();
        *a_IntValue = l_IntValue;
    } catch (const std::runtime_error& e){
        return FactBase_NOSET;
    }
    return FactBase_OK;
}
