#ifndef Default_DecisdeActionReqJson_H
#define Default_DecisdeActionReqJson_H

#include <string>
#include <DecisdeActionRequest.h>
#include <Config.h>
#include <pthread.h>

class DecisdeActionReqJson : public DecisdeActionRequest {
public :
    DecisdeActionReqJson();
    static DecisdeActionReqJson* getInstance();
    int setFactInfo(std::string* a_FactInfo);
    int getFactInfo(std::string*** a_FactInfo);
    int getFactInfo(picojson::value** a_value);
    int setFactInfo(picojson::value a_value);
    static void init_routine();
    static void DecisdeActionReqJson_Destroy(void* a_Object);
private :
    std::string** m_Jsonvalue;
    picojson::value* m_value;
    int m_MaxInputMessage;
    static pthread_key_t m_pthread_key;
    static pthread_once_t buffer_key_once;
    int m_FactCounter;
    int initialize();
};

#endif
