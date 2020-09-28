#ifndef TransactionMng_h
#define TransactionMng_h

/* ヘッダファイル */

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

/* クラス定義  */

class TransactionMng
{

    private:

    struct in_addr m_mynodeIP;
    char* m_evalsha;

    public:

    /* 初期化処理 */
    int transactionMngInit();

    /* シーケンス番号取得関数 */
    int32_t getSeqnoHunt(uint32_t *a_num);

    /* シーケンス番号解放関数 */
    void getSeqnoFree(uint32_t a_num);

    /* インスタンス取得 */
    static TransactionMng &getInstance(){
        static TransactionMng instance;
        return instance;
    }
    /* 信号受信時コール用関数取得 */
    Ffpl_seqno_hunt_func getSeqnoHuntFunc();

    /* シーケンス番号解放コール用関数取得 */
    Ffpl_seqno_free_func getSeqnoFreeFunc();

    /* シーケンス番号取得 */
    unsigned int getSeq_Number();

    /* PFCP信号送信要求 */
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

    /* EndMarker送信要求 */
    int send_endmaker(
        struct in_addr upf_address,
        struct in_addr n3_upf_address,
        struct in_addr n3_gnb_address,
        unsigned int  n3_nnb_teid,
        unsigned int  upf_teid,
        int sock
    );

    /* Association Setup送信要求 */
    int sendAssociationSetup(
        struct in_addr upf_address
    );

};
}
#endif
