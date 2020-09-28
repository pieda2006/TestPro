#ifndef TransactionMng_h
#define TransactionMng_h

/* �إå��ե����� */

extern "C"
{

#include "Ffpl.h"

}

#define TransactionMng_OK JGLB_OK
#define TransactionMng_NG JGLB_NG

#define TransactionMng_INIT "0"
#define TransactionMng_SENTREQUEST "1"
#define TransactionMng_RECEIVEDRESPONSE "2"
#define TransactionMng_RECEIVEDREQUEST "3"
#define TransactionMng_SENTRESPONSE "4"

namespace cups {

/* ���饹���  */

class TransactionMng
{

    private:

    struct in_addr m_mynodeIP;
    char* m_evalsha;

    public:

    /* ��������� */
    int transactionMngInit();

    /* ���������ֹ�����ؿ� */
    int32_t getSeqnoHunt(uint32_t *a_num);

    /* ���������ֹ�����ؿ� */
    void getSeqnoFree(uint32_t a_num);

    /* ���󥹥��󥹼��� */
    static TransactionMng &getInstance(){
        static TransactionMng instance;
        return instance;
    }
    /* ����������������Ѵؿ����� */
    Ffpl_seqno_hunt_func getSeqnoHuntFunc();

    /* ���������ֹ�����������Ѵؿ����� */
    Ffpl_seqno_free_func getSeqnoFreeFunc();

    /* ���������ֹ���� */
    unsigned int getSeq_Number();

    /* PFCP���������׵� */
    int snd_pfcp(
//        Felb_luid gwuid,
        struct in_addr upf_address,
        int th_id,
        unsigned int seq_no,
        unsigned char usr_no,
        Ffpl_enc *enc_pfcp,
        unsigned int pfcp_msg,
        unsigned short *err_fb,
        unsigned char *err_cause
    );

    /* EndMarker�����׵� */
    int send_endmaker(
        struct in_addr upf_address,
        struct in_addr n3_upf_address,
        struct in_addr n3_gnb_address,
        unsigned int  n3_nnb_teid,
        unsigned int  upf_teid,
        int sock
    );

    /* Association Setup�����׵� */
    int sendAssociationSetup(
        struct in_addr upf_address
    );

};
}
#endif
