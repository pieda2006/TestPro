#ifndef Default_FactProtobuf_H
#define Default_FactProtobuf_H

#include <picojson.h>
#include <FactBase.h>
#include <google/protobuf/message.h>

class FactProtobuf : public FactBase{
    public :

    google::protobuf::Message* m_value;

    int setProtobufValue(google::protobuf::Message* a_value);
    int getStringParam(picojson::array a_ParamName, std::string** a_StringValue);
    int getIntParam(picojson::array a_ParamName, int* a_IntValue);
};
#endif
