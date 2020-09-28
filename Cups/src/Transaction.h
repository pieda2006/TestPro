#ifndef Transaction_h
#define Transaction_h

/* ヘッダファイル */

extern "C"
{
}

#define TRANSACTION_INIT 0
#define TRANSACTION_SENDING_REQ 1
#define TRANSACTION_RECIEVE_REQ 2
#define TRANSACTION_RECIEVED_RESPONSE 3
#define TRANSACTION_SENDED_RESPONSE 4
#define TRANSACTION_ILLIGALE 99

#define TRANSACTION_REQUEST 0
#define TRANSACTION_RESPONSE 1

#define TRANSACTION_OK 0
#define TRANSACTION_NG 1

namespace cups {

/* クラス定義  */

class Transaction
{
    protected:

    unsigned int m_pfcp_msg;
    unsigned int m_seq_no;
    Ffpl_enc m_enc;
    struct in_addr m_upf_address;
    unsigned int m_status;
    struct in_addr m_ownip;
    Association* m_assciation;

    /* 信号送信時状態遷移テーブル */
    unsigned int statustable[][2] = {
        //Request               , //Response
        {TRANSACTION_SENDING_REQ, TRANSACTION_ILLIGALE},       //TRANSACTION_INIT
        {TRANSACTION_ILLIGALE   , TRANSACTION_ILLIGALE},       //TRANSACTION_SENDING_REQ
        {TRANSACTION_ILLIGALE   , TRANSACTION_SENDED_RESPONSE},//TRANSACTION_RECIEVE_REQ
        {TRANSACTION_ILLIGALE   , TRANSACTION_ILLIGALE},       //TRANSACTION_RECIEVED_RESPONSE
        {TRANSACTION_ILLIGALE   , TRANSACTION_ILLIGALE}        //TRANSACTION_SENDED_RESPONSE
    };

    public:

    Transaction();
    void setMsgType(unsigned int a_pfcp_msg);
    void setSeqNo(unsigned int a_seq_no);
    void setEncData(Ffpl_enc *a_enc);
    void setDstIPaddr(struct in_addr a_upf_address);
    int sendPFCPMessage(unsigned int a_pfcp_msg);
    virtual int sendPFCPMessageImpl(unsigned int a_pfcp_msg);
    void setStatus(int a_status);
    int checkStatus(unsigned int a_pfcp_msg);
    int updateTransaction();
};
}

#endif
