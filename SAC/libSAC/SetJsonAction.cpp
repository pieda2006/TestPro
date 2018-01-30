#include <SetJsonAction.h>$

SetJsonAction::SetJsonAction(){
    m_ParamName = NULL;
    m_MassageName = NULL;
    m_ParamValue = NULL;
    m_ParamNum = 0;
    m_ParamType = NULL;
}

int SetJsonAction::executeActionImple(FactList* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo, DecisdeActionAnswer *a_OutputMessage,int a_CondtionID, bool a_Result,ConditionResult* a_ConditionResult){

    int l_Ret;

    if(a_OutputMessage->getMessageType() == DecisdeActionAnswer_JSON){
       DecisdeActionAnsJson* l_ActionAnsJson;
       l_ActionAnsJson = (DecisdeActionAnsJson*)a_OutputMessage;
       picojson::object l_object;

       for(int l_count = 0; l_count < m_ParamNum; l_count++){

            switch (m_ParamType[l_count]) {
            case 1://int
            {
                int l_intValue = (int)a_Value->get<picojson::object>()[m_ParamValue[l_count]->c_str()].get<double>();
                l_object.insert(std::make_pair(*m_ParamName[l_count],(double)l_intValue));
                break;
            }
            case 2://string
            {
                std::string l_stringValue = a_Value->get<picojson::object>()[m_ParamValue[l_count]->c_str()].get<std::string>();
                l_object.insert(std::make_pair(*m_ParamName[l_count],l_stringValue));
                break;
            }
            default:
                break;
            }
        }
        picojson::value l_value(l_object); 
        l_ActionAnsJson->setActionInfo(l_value);
     }
     return ExecuteBase_OK; 
}

int SetJsonAction::setMassageName(std::string* a_MessageName){
    m_MassageName = a_MessageName;
    return ExecuteBase_OK;
}

int SetJsonAction::setParamName(std::string** a_ParamName){
    m_ParamName = a_ParamName;
    return ExecuteBase_OK;
}
int SetJsonAction::setParamValue(std::string** a_ParamValue){
    m_ParamValue = a_ParamValue;
    return ExecuteBase_OK;
}
int SetJsonAction::setParamNum(int a_ParamNum){
    m_ParamNum = a_ParamNum;
    return ExecuteBase_OK;
}

int SetJsonAction::setParamType(int* a_ParamType){
    m_ParamType = a_ParamType;
}




