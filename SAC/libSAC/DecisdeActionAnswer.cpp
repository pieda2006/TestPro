#include <DecisdeActionAnswer.h>
 
DecisdeActionAnswer::DecisdeActionAnswer() {
        m_MessageType = 0;
}

int DecisdeActionAnswer::getMessageType(){
    return m_MessageType;
}

int DecisdeActionAnswer::setMessageType(int a_MessageType){
    m_MessageType = a_MessageType;
    return DecisdeActionAnswer_OK;
}

DecisdeActionAnswer::~DecisdeActionAnswer(){
}
