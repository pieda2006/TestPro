#ifndef PFCPTrf_h
#define PFCPTrf_h

/* ヘッダファイル */

extern "C"
{

#include "Ffpl.h"

}

namespace cups {

/* クラス定義  */

class PFCPTrf
{

    public:

    /* 初期化処理 */
    int PFCPTrfInit();

    /* PFCP信号リクエスト送信時トラヒックカウント  */
    void reqSendTrfCount( uint8_t a_num);

    /* PFCP信号リクエスト送信時トラヒックカウント関数取得  */
    Ffpl_trf_req_send_func getReqSendTrfCountFunc();

    /* PFCP信号リクエスト受信時トラヒックカウント */
    void reqReceiveTrfCount( uint8_t a_num);

    /* PFCP信号リクエスト受信時トラヒックカウント関数取得  */
    Ffpl_trf_req_recv_func getReqReceiveTrfCountFunc();

    /* PFCP信号レスポンス送信時トラヒックカウント  */
    void respSendTrfCount( uint8_t a_num1, uint8_t a_num2);

    /* PFCP信号レスポンス送信時トラヒックカウント関数取得  */
    Ffpl_trf_rsp_send_func getRespSendTrfCountFunc();

    /* PFCP信号レスポンス受信時トラヒックカウント  */
    void respReceiveTrfCount( uint8_t a_num1, uint8_t a_num2);

    /* PFCP信号レスポンス受信時トラヒックカウント関数取得  */
    Ffpl_trf_rsp_recv_func getRespReceiveTrfCountFunc();

    /* インスタンス取得 */
    static PFCPTrf &getInstance(){
        static PFCPTrf instance;
        return instance;
    }
};
}

#endif
