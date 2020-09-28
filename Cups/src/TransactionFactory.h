#ifndef TransactionFactory_h
#define TransactionFactory_h

/* ヘッダファイル */

extern "C"
{
}

namespace cups {

/* クラス定義  */

class TransactionFactory
{

    public:

    /* 初期化処理 */
    int tranFactInit();

    /* インスタンス取得 */
    static TransactionFactory &getInstance(){
        static TransactionFactory instance;
        return instance;
    }

    /* Transaction生成 */
    Transaction* createTransaction(unsigned int pfcp_msg, unsigned int seq_no, struct in_addr a_upf_address, struct in_addr a_ownip,int a_status = -1);


};
}

#endif
