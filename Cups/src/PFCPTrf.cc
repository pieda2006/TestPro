/* ヘッダファイル */

extern "C"
{

#include "Lcups_lib.h"
#include "Ffpl.h"

}

#include "PFCPTrf.h"
#include "DbgCom.h"

/* 関数定義 */

namespace cups {

/* 初期化処理 */
int cups::PFCPTrf::PFCPTrfInit(){
}

/* PFCP信号リクエスト送信時トラヒックカウント  */
void cups::PFCPTrf::reqSendTrfCount( uint8_t a_num){
}

/* PFCP信号リクエスト送信時トラヒックカウント関数取得  */
Ffpl_trf_req_send_func cups::PFCPTrf::getReqSendTrfCountFunc(){
    return LreqSendTrfCount;
}

/* PFCP信号リクエスト受信時トラヒックカウント */
void cups::PFCPTrf::reqReceiveTrfCount( uint8_t a_num){
}

/* PFCP信号リクエスト受信時トラヒックカウント関数取得  */
Ffpl_trf_req_recv_func cups::PFCPTrf::getReqReceiveTrfCountFunc(){
    return LreqReceiveTrfCount;
}

/* PFCP信号レスポンス送信時トラヒックカウント  */
void cups::PFCPTrf::respSendTrfCount( uint8_t a_num1, uint8_t a_num2){
}

/* PFCP信号レスポンス送信時トラヒックカウント関数取得  */
Ffpl_trf_rsp_send_func cups::PFCPTrf::getRespSendTrfCountFunc(){
    return LrespSendTrfCount;
}

/* PFCP信号レスポンス受信時トラヒックカウント  */
void cups::PFCPTrf::respReceiveTrfCount( uint8_t a_num1, uint8_t a_num2){
}

/* PFCP信号レスポンス受信時トラヒックカウント関数取得  */
Ffpl_trf_rsp_recv_func cups::PFCPTrf::getRespReceiveTrfCountFunc(){
    return LrespReceiveTrfCount;
}

}
