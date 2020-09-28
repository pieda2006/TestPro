/* �إå��ե����� */

#include "Transaction.h"

extern "C"
{
}

/* using��� */

using cups::AssociationMng;

/* �ؿ���� */

namespace cups {

cups::Transaction::Transaction(){
    m_status = TRANSACTION_INIT;
}

void cups::Transaction::setMsgType(unsigned int a_pfcp_msg){
    m_pfcp_msg = a_pfcp_msg;
}
void cups::Transaction::setSeqNo(unsigned int a_seq_no);
    m_pfcp_msg = a_seq_no;
}
void cups::Transaction::setEncData(Ffpl_enc* a_enc){
    m_enc = a_enc;
}

void cups::Transaction::setDstIPaddr(struct in_addr a_upf_address){
    m_upf_address = a_upf_address;
}

void cups::Transaction::setStatus(int a_status){
    m_status = a_status;
}

int receivePFCPMessage(unsigned int  a_pfcp_msg){
    /* �ȥ�󥶥��������֥����å�  */
    int l_status = checkStatus(a_pfcp_msg);
    if(l_status == TRANSACTION_ILLIGALE){
        return TRANSACTION_NG;
    }
    m_assciation->setTransaction(this);
    int l_ret = receivePFCPMessageImpl(a_pfcp_msg) ;
    m_status = l_status;
}

int cups::Transaction::sendPFCPMessage(unsigned int a_pfcp_msg){
    /* �ȥ�󥶥��������֥����å�  */
    int l_status = checkStatus(a_pfcp_msg);
    if(l_status == TRANSACTION_ILLIGALE){
        return TRANSACTION_NG;
    }

    AssociationMng& l_AssociationMng = AssociationMng::getInstance();
    m_AssociationIns =  l_AssociationMng.getAssociationIns(m_upf_address, m_ownip);
    l_AssociationIns->setTransaction(this);
    int ret = sendPFCPMessageImpl(a_pfcp_msg);
    if(TRANSACTION_OK != ret){
       DbgFErr( DbgDTxt, "sendPFCPMessageImpl NG %d", ret );
       m_AssociationIns->releaseAssociationIns();
       return TRANSACTION_NG;
    }
    m_status = l_status;
    m_AssociationIns->releaseAssociationIns();
}
int cups::Transaction::checkStatus(unsigned int a_pfcp_msg) {
   if(50 > a_pfcp_msg){
       /* 50��꾮�������ϴ����request */
       if((a_pfcp_msg % 2) == 0){
           return statustable[m_status][TRANSACTION_RESPONSE];
       } else {
           return statustable[m_status][TRANSACTION_REQUEST];
       }
   } else {
       /* 50�ʾ�϶�����request */
       return statustable[m_status][(a_pfcp_msg % 2)];
   }
}

int cups::Transaction::updateTransaction(){
    RedisAccess l_RedisAccess = RedisAccess::getInstance();
    redisReply  *reply = NULL;
    char l_upf_address[INET_ADDRSTRLEN];
    char l_ownip[INET_ADDRSTRLEN];

    char* l_setTransactionString = "HMSET Transaction:%d status %d upfip %s ownip %s msgtype %d";
    char* l_delTransactionString = "DEL Transaction:%d";
    if(TRANSACTION_SENDING_REQ == m_status || TRANSACTION_RECIEVE_REQ == m_status){
        /* Redis�إȥ�󥶥�����������Ͽ */
        inet_ntop(AF_INET, &m_upf_address, l_upf_address, INET_ADDRSTRLEN);
        inet_ntop(AF_INET, &m_ownip, l_ownip, INET_ADDRSTRLEN);
        l_RedisAccess.redisClusterCommand(&reply, l_setTransactionString, m_seq_no, m_status,l_upf_address,l_ownip,m_pfcp_msg);
        
    } else if(TRANSACTION_SENDED_RESPONSE == m_status || TRANSACTION_RECIEVED_RESPONSE == m_status){
        /* Redis����ȥ�󥶥��������ֺ�� */
        l_RedisAccess.redisClusterCommand(&reply, l_delTransactionString, m_seq_no);
    }
}

}
