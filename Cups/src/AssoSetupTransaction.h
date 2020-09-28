#ifndef AssoSetupTransaction_h
#define AssoSetupTransaction_h

/* ヘッダファイル */

extern "C"
{
}

namespace cups {

/* クラス定義  */

class AssoSetupTransaction : public Transaction
{
    int sendPFCPMessageImpl(unsigned int a_pfcp_msg);
    void releaseTransactionIns();
};
}

#endif
