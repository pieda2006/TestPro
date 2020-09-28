/* ヘッダファイル */

#include "TransactionFactory.h"

extern "C"
{
}

/* 関数定義 */

namespace cups {

/* 初期化処理 */
int cups::TransactionFactory::tranFactInit(){
    return 0;
}

/* トランザクション生成 */
Transaction* cups::TransactionFactory::createTransaction(unsigned int pfcp_msg, unsigned int seq_no, struct in_addr a_upf_address, struct in_addr a_ownip, int a_status){
    Transaction* l_transaction;

    switch (pfcp_msg) {
        /* Associationトランザクション生成 */
        case JPFCP_MSG_ASSOC_SETUP_REQ:
            l_transaction = new AssoSetupTransaction();
            break;
        /* 他のトランザクション生成もこの後に記載する */
        default:
            return null;
            break;
    }
    l_transaction->setMsgType(pfcp_msg);
    l_transaction->setSeqNo(seq_no);
    l_transaction->setDstIPaddr(a_upf_address);
    l_transaction->setOwnIP(a_ownip);
    if(a_status != -1){
        l_transaction->setStatus(a_status);
    }
    return l_transaction;
}

}
