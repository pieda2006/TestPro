#include <EvaluateElement.h>$

EvaluateElement::EvaluateElement(){
    setOperationType(2);
}

int EvaluateElement::evaluateConditionImple(FactBase* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo){
    int l_Depth;
    l_Depth = m_PramName.size();
    int l_counter;
    picojson::value* l_Value;
    l_Value = a_Value;
    for(l_counter = 0; l_counter < l_Depth-1; l_counter++){
        *l_Value = l_Value->get<picojson::object>()[m_PramName[l_counter].get<std::string>()];
    }
    
    if(m_PramType == EvaluateBase_INT){
        int l_IntValue;
        
        l_IntValue = (int)l_Value->get<picojson::object>()[m_PramName[l_counter].get<std::string>()].get<double>();
        a_ResultInfo->setResultType(ResultInfo_INT);
        a_ResultInfo->setIntResult(l_IntValue);
        return EvaluateBase_OK;

    } else if(m_PramType == EvaluateBase_String){
    	std::string* l_StringValue = new std::string();

        *l_StringValue = l_Value->get<picojson::object>()[m_PramName[l_counter].get<std::string>()].get<std::string>();
        a_ResultInfo->setIntResult(ResultInfo_String);
        a_ResultInfo->setStringResult(l_StringValue);
        return EvaluateBase_OK;
    }

    return EvaluateBase_NG;
}
