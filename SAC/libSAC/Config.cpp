#include <Config.h>
#include <iostream>

Config* Config::m_Config = NULL;

Config::Config(){
}

Config* Config::getInstance(){
    if(m_Config == NULL){
        m_Config = new Config();
    }
    return m_Config;
}

int Config::readSg(std::string* a_FilePath){
    std::stringstream ss;
    std::ifstream f;
    std::string* l_path = new std::string("");
    l_path->append(*a_FilePath);
    f.open(l_path->c_str(), std::ios::binary);
    ss << f.rdbuf();
    std::string str;
    str = ss.str();
    f.close();
    picojson::parse(m_SgValue, str);
    delete l_path;
    return Condig_OK;
}

int Config::getSgIntValue(std::string* a_ParamName, int* a_IntValue){

	if(m_SgValue.is<picojson::null>() || !m_SgValue.is<picojson::object>()){
	    return Condig_NG;
	}
	picojson::value l_SgValue = m_SgValue.get<picojson::object>()[a_ParamName->c_str()];
	if(l_SgValue.is<picojson::null>() || !l_SgValue.is<double>()){
		return Condig_NG;
	}
    *a_IntValue = (int)l_SgValue.get<double>();

    return Condig_OK;
}

int Config::getSgStringValue(std::string* a_ParamName, std::string** a_StringValue){
	if(m_SgValue.is<picojson::null>() || !m_SgValue.is<picojson::object>()){
		return Condig_NG;
	}
	picojson::value l_SgValue = m_SgValue.get<picojson::object>()[a_ParamName->c_str()];
	if(l_SgValue.is<picojson::null>() || !l_SgValue.is<std::string>()){
		return Condig_NG;
	}
    std::string* l_StringValue = new std::string(l_SgValue.get<std::string>());
    *a_StringValue = l_StringValue;
    return Condig_OK;
}

int Config::getSgIntArray(std::string* a_ParamName, int* a_IntValue, int a_Index){
    picojson::array l_array;
    if(m_SgValue.is<picojson::null>() || !m_SgValue.is<picojson::object>()){
    	return Condig_NG;
    }
    picojson::value l_SgValue = m_SgValue.get<picojson::object>()[a_ParamName->c_str()];
    if(l_SgValue.is<picojson::null>() || !l_SgValue.is<picojson::array>()){
    	return Condig_NG;
    }
    l_array = l_SgValue.get<picojson::array>();
    if(l_array.size() <= a_Index){
        return Config_ArrayOver;
    } else if(!l_array[a_Index].is<double>()){
    	return Condig_NG;
    }
    *a_IntValue = (int)l_array[a_Index].get<double>();
    return Condig_OK;
}

int Config::getSgStringArray(std::string* a_ParamName, std::string** a_StringValue, int a_Index){
    picojson::array l_array;
    if(m_SgValue.is<picojson::null>() || !m_SgValue.is<picojson::object>()){
    	return Condig_NG;
    }
    picojson::value l_SgValue = m_SgValue.get<picojson::object>()[a_ParamName->c_str()];
    if(l_SgValue.is<picojson::null>() || !l_SgValue.is<picojson::array>()){
    	return Condig_NG;
    }
    l_array = l_SgValue.get<picojson::array>();
    if(l_array.size() <= a_Index){
        return Config_ArrayOver;
    } else if(!l_array[a_Index].is<std::string>()){
    	return Condig_NG;
    }
    *a_StringValue = new std::string(l_array[a_Index].get<std::string>());

    return Condig_OK;
}
