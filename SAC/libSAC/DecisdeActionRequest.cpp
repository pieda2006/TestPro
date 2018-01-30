#include <DecisdeActionRequest.h>
 
DecisdeActionRequest::DecisdeActionRequest() {
}

int DecisdeActionRequest::getMessageType(){
    return m_MessageType;
}

int DecisdeActionRequest::setMessageType(int a_MessageType){
    m_MessageType = a_MessageType;
    return DecisdeActionRequest_OK;
}

DecisdeActionRequest::~DecisdeActionRequest(){
}
