/* ヘッダファイル */

#include "AssoSetupTransaction.h"

extern "C"
{
}

/* 関数定義 */

namespace cups {

int cups::AssoSetupTransaction::sendPFCPMessageImpl(unsigned int a_pfcp_msg){
    /* PFCP信号送信 */
    int l_ret = m_assciation->sendPFCPMessage(&enc_data, a_pfcp_msg);
    if(Association_OK!= l_ret){
        return Transaction_NG;
    }
}
int cups::AssoSetupTransaction::receivePFCPMessageImpl(unsigned int  a_pfcp_msg){
    m_assciation->associationStatusChg(a_pfcp_msg);
    return Transaction_OK;
}
void cups::AssoSetupTransaction::releaseTransactionIns(){

    /* トランザクション状態更新 */
    updateTransaction();
    /* トランザクションインスタンス削除 */
    delete this;
}

}
