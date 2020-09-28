/* ヘッダファイル */

#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#include "ProcMain.h"
#include "RedisAccess.h"
#include "AssociationMng.h"
#include "TransactionMng.h"
#include "PFCPTrf.h"
#include "TransactionFactory.h"

#include "thread_ThreadMng.h"
#include "pfcp_Server.h"

#include "Lcol_macro.h"
#include "DbgCom.h"

extern "C"
{

#include "Ffpl.h"
#include "Lfpl.h"
#include "Lpfcp_lib.h"
}

/* Define定義 */
#define PFCP_IF_NAME "PFCP_IF_NAME"

/* using定義 */

using thread::ThreadMng;
using pfcpsvr::PFCP_Server;

/* 関数定義 */

namespace cups {

/* メイン処理 */
int cups::ProcMain::startMain( ) {

    /* udpソケット用のIF名 */
    char* ifname;

    /* Redis操作用のインスタンス取得 */
    RedisAccess& l_RedisAccess = RedisAccess::getInstance();
    /* Redis初期化処理 */
    l_RedisAccess.redisInit();
    /* スレッドプール生成 */
    ThreadMng& l_ThreadMng = ThreadMng::getInstance();

    /* アソシエーションインスタンス初期化  */
    AssociationMng& l_AssociationMng = AssociationMng::getInstance();
    l_AssociationMng.assocMngInit();

    /* トランザクションFactoryインスタンス初期化 */
    TransactionFactory& l_TransactionFactory = TransactionFactory::getInstance();
    l_TransactionFactory.tranFactInit();

    /* トランザクションインスタンス初期化  */
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    l_TransactionMng.transactionMngInit();

    /* トラヒックインスタンス初期化 */
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    l_PFCPTrf.PFCPTrfInit();
    /* PFCP初期化 */
    Ffpl_init pfcp_init;
    memset( &pfcp_init, 0x00, sizeof(pfcp_init) );
    /* コールバック関数取得 */
    getCallback(&pfcp_init);

    /* fpl初期化用設定 */
    /* IF名取得 */
    ifname = getenv(PFCP_IF_NAME);
    if(ifname == NULL){
        DbgFErr( DbgDTxt, " %s  Not Found *****",PFCP_IF_NAME );
        /* defaultはeth0にする */
        ifname = "eth0";
    }
    pfcp_init.a_if_name = ifname;
    pfcp_init.vrfid = 0;

    int ret = Lfpl_init(&pfcp_init, NULL);
    if(JFPL_OK != ret){
        DbgFErr( DbgDTxt, "Lfpl_init NG %d",ret );
        return -1;
    }

    /* NodeIPを取得 */
    char* l_node_addr  = getenv("EXTERNAL_IP_ADDRESS_IPV4");

    /* GRPC初期化 */
    struct in_addr *l_external_IP;
    ret = inet_aton(l_node_addr, l_external_IP);
    if(ret != 1){
        DbgFErr( DbgDTxt, "EXTERNAL_IP_ADDRESS_IPV4 Convert NG %d",ret );
    }
    ret = Spfcp_init(l_external_IP);

    LCOL_DBG("ログ出力");

    return 0;
}

void cups::ProcMain::getCallback(Ffpl_init* a_pfcp_init){

    /* AssociationMngインスタンス取得  */
    AssociationMng& l_AssociationMng = AssociationMng::getInstance();
    /* 信号受信時起動関数取得 */
    a_pfcp_init->recv_func = l_AssociationMng.getRecSigFunc();
    /* アソシエーション切断を受信時起動関数 */
    a_pfcp_init->assoc_rel_func = l_AssociationMng.getAssocRelFunc();
    /* TransactionMngインスタンス取得 */
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    /* シーケンス番号払い出し関数取得 */
    a_pfcp_init->seqno_hunt_func = l_TransactionMng.getSeqnoHuntFunc();
    /* シーケンス番号解放関数取得 */
    a_pfcp_init->seqno_free_func = l_TransactionMng.getSeqnoFreeFunc();
    /* トラヒック収集インスタンス取得 */
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    /* リクエスト信号送信、リクエスト信号受信、
       レスポンス信号送信、レスポンス信号受信時トラヒックカウント関数取得  */
    a_pfcp_init->trf_req_send_func = l_PFCPTrf.getReqSendTrfCountFunc();
    a_pfcp_init->trf_req_recv_func = l_PFCPTrf.getReqReceiveTrfCountFunc();
    a_pfcp_init->trf_rsp_send_func = l_PFCPTrf.getRespSendTrfCountFunc();
    a_pfcp_init->trf_rsp_recv_func = l_PFCPTrf.getRespReceiveTrfCountFunc();
}

}
