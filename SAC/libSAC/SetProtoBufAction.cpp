#include <SetProtoBufAction.h>$

SetProtoBufAction::SetProtoBufAction(){
    m_ParamName = NULL;
    m_MassageName = NULL;
    m_ParamValue = NULL;
    m_PramNum = 0;
}

int SetProtoBufAction::executeActionImple(FactList* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo, DecisdeActionAnswer *a_OutputMessage, int a_CondtionID, bool a_Result,ConditionResult* a_ConditionResult){

    int l_Ret;

    if(a_OutputMessage->getMessageType() == DecisdeActionAnswer_Protobuf){
       DecisdeActionAnsProtobuf* l_ActionAnsProto;
       l_ActionAnsProto = (DecisdeActionAnsProtobuf*)a_OutputMessage;
       const google::protobuf::Message* l_ConstMessage;
       google::protobuf::Message* l_Message;
       SAC::ActionInfo* l_ActionInfo;
       l_Ret = l_ActionAnsProto->getActionInfo(&l_Message);
       if(l_Ret == DecisdeActionAnswer_NODATA){
           l_ActionInfo = new SAC::ActionInfo();
           l_ActionAnsProto->setActionInfo(l_ActionInfo);
           l_Message = l_ActionInfo;
       }
       l_ConstMessage = l_Message;
       const google::protobuf::Descriptor* l_descriptor;
       const google::protobuf::FieldDescriptor* l_field;
       const google::protobuf::Reflection* l_reflection;
       if(m_MassageName != NULL){
           l_descriptor = l_ConstMessage->GetDescriptor();
           l_field = l_descriptor->FindFieldByName(*m_MassageName);
           l_reflection = l_ConstMessage->GetReflection();
           l_ConstMessage = &(l_reflection->GetMessage(*l_ConstMessage, l_field));
       }
       l_descriptor = l_ConstMessage->GetDescriptor();
       l_reflection = l_ConstMessage->GetReflection();


       for(int l_count = 0; l_count < m_PramNum; l_count++){
           l_field = l_descriptor->FindFieldByName(*m_ParamName[l_count]);

            

            switch (l_field->type()) {
            case google::protobuf::FieldDescriptor::TYPE_INT32:
            {
                int l_intValue = (int)a_Value->get<picojson::object>()[m_ParamValue[l_count]->c_str()].get<double>();

                if(l_field->label() == google::protobuf::FieldDescriptor::LABEL_REPEATED){
                    int l_RepeatNum = 0;
                    l_RepeatNum = l_reflection->FieldSize(*l_ConstMessage, l_field);
                    l_reflection->SetRepeatedInt32(l_Message, l_field, (l_RepeatNum + 1), l_intValue); 
                } else {
                    l_reflection->SetInt32(l_Message, l_field, l_intValue);
                }
                break;
            }
            case google::protobuf::FieldDescriptor::TYPE_STRING:
            {
                std::string l_stringValue = a_Value->get<picojson::object>()[m_ParamValue[l_count]->c_str()].get<std::string>();
                if(l_field->label() == google::protobuf::FieldDescriptor::LABEL_REPEATED){
                    int l_RepeatNum = 0;
                    l_RepeatNum = l_reflection->FieldSize(*l_ConstMessage, l_field);
                    l_reflection->SetRepeatedString(l_Message, l_field, (l_RepeatNum + 1), l_stringValue);
                } else {
                    l_reflection->SetString(l_Message, l_field, l_stringValue);
                }
                break;
            }
            default:
                break;
            }
        }
     }
}

int SetProtoBufAction::setMassageName(std::string* a_MessageName){
    m_MassageName = a_MessageName;
}

int SetProtoBufAction::setParamName(std::string** a_ParamName){
    m_ParamName = a_ParamName;
}
int SetProtoBufAction::setParamValue(std::string** a_ParamValue){
    m_ParamValue = a_ParamValue;
}
int SetProtoBufAction::setParamNum(int a_ParamNum){
    m_PramNum = a_ParamNum;
}

