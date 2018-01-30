#ifndef Default_DecisdeActionRequest_H
#define Default_DecisdeActionRequest_H

#define DecisdeActionRequest_OK 0
#define DecisdeActionRequest_NG -1

#define DecisdeActionRequest_JSON 1
#define DecisdeActionRequest_Protobuf 2

class DecisdeActionRequest {
public :

    DecisdeActionRequest();
    int getMessageType();
    int setMessageType(int a_MessageType);
    ~DecisdeActionRequest();

private :
    int m_MessageType;
};

#endif
