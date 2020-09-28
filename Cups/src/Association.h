#ifndef Association_h
#define Association_h

/* ヘッダファイル */

extern "C"
{
}

namespace cups {

/* クラス定義  */

class Association
{

    public:

    /* 信号送信関数 */
    int sendPFCPMessage(Ffpl_enc* enc_data, int msgType);
    int receivePFCPMessage(a_recv : Ffpl_pfcp_recv*);
};
}

#endif
