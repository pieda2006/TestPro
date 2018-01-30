#include <FactProtobuf.h>

int FactProtobuf::setProtobufValue(google::protobuf::Message* a_value){
    m_value = a_value;
}

int FactProtobuf::getStringParam(picojson::array a_ParamName, std::string** a_StringValue){
    int l_Depth;
    l_Depth = a_ParamName.size();
    int l_counter;
    const google::protobuf::Message* l_Value;
    l_Value = m_value;
    for(l_counter = 0; l_counter < l_Depth-1; l_counter++){
        const google::protobuf::Descriptor* l_descriptor = l_Value->GetDescriptor();
        const google::protobuf::FieldDescriptor* l_field = l_descriptor->FindFieldByName(a_ParamName[l_counter].get<std::string>());
        const google::protobuf::Reflection* reflection = l_Value->GetReflection();
        l_Value = &(reflection->GetMessage(*l_Value, l_field));
    }

    const google::protobuf::Descriptor* l_descriptor = l_Value->GetDescriptor();
    const google::protobuf::FieldDescriptor* l_field = l_descriptor->FindFieldByName(a_ParamName[l_counter].get<std::string>());
    const google::protobuf::Reflection* reflection = l_Value->GetReflection();
    *a_StringValue = new std::string(reflection->GetString(*l_Value,l_field));

    return FactBase_OK;
}

int FactProtobuf::getIntParam(picojson::array a_ParamName, int* a_IntValue){

    int l_Depth;
    l_Depth = a_ParamName.size();
    int l_counter;
    const google::protobuf::Message* l_Value = NULL;
    l_Value = m_value;
    for(l_counter = 0; l_counter < l_Depth-1; l_counter++){
        const google::protobuf::Descriptor* l_descriptor = l_Value->GetDescriptor();
        const google::protobuf::FieldDescriptor* l_field = l_descriptor->FindFieldByName(a_ParamName[l_counter].get<std::string>());
        const google::protobuf::Reflection* reflection = l_Value->GetReflection();
        l_Value = &(reflection->GetMessage(*l_Value,l_field));
    }
    const google::protobuf::Descriptor* l_descriptor = l_Value->GetDescriptor();
    const google::protobuf::FieldDescriptor* l_field = l_descriptor->FindFieldByName(a_ParamName[l_counter].get<std::string>());
    const google::protobuf::Reflection* reflection = l_Value->GetReflection();

    *a_IntValue = reflection->GetInt32(*l_Value,l_field);

    return FactBase_OK;
}
