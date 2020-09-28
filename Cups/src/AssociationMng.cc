/* ヘッダファイル */

extern "C"
{

#include "Lcups_lib.h"
#include "Ffpl.h"

}

#include "AssociationMng.h"
#include "DbgCom.h"

/* 関数定義 */

namespace cups {

/* 初期化処理 */
int cups::AssociationMng::assocMngInit(){
}

/* PFCP信号受信時関数  */
void cups::AssociationMng::recPFCPsignal(Ffpl_pfcp_recv *a_recv){
    /* Association情報取得 */
    Association* l_Association = getAssociationIns(a_recv->sockaddr_in.sin_addr);
    /* Associationに信号通知 */
    int l_ret = l_Association->receivePFCPMessage(a_recv);
    l_Association->releaseAssociationIns();
}

/* 信号受信時コール用関数 */
Ffpl_pfcp_recv_func cups::AssociationMng::getRecSigFunc(){
    return LrecPFCPsignal;
}

/* Association Release時関数 */
void cups::AssociationMng::AssociationRel(uint16_t a_num){
}

/* Association Release取得用関数 */
Ffpl_pfcp_assoc_rel_func cups::AssociationMng::getAssocRelFunc(){
    return LAssociationRel;
}
/* IPアドレスからluidへ変換  */
int cups::AssociationMng::chg_upfAddr_luid( struct in_addr upf_ipv4addr, Felb_luid *luid){
    /* 中身はあとで実装 */
    return 0;
}
Association* cups::AssociationMng::getAssociationIns(struct in_addr a_upf_address) {
    Association* l_Association;

    /* Redisからアソシエーション情報取得 */
    RedisAccess& l_redis_ins = RedisAccess::getInstance();
    char* l_getAssociationString = "HGET UPF_Association_Data:%s %s";
    char* l_node_addr  = getenv("EXTERNAL_IP_ADDRESS_IPV4");
    char l_upfip[INET_ADDRSTRLEN];
    inet_ntop(AF_INET, &a_upf_address, l_upfip, INET_ADDRSTRLEN);
    redisReply  *reply = NULL;
    int l_ret = l_redis_ins.redisClusterCommand(&reply, l_getAssociationString, l_node_addr,l_upfip);
    if( REDIS_REPLY_STRING != reply->type ) {
        DbgFErr( DbgDTxt, "unmatch reply->type=[%d]", reply->type );
        /* 応答データ解放 */
        freeReplyObject(reply);
        return AssociationMng_NG;
    }
    /* Jsonの分析を実施 */
    nats_JSON   *json = NULL;
    char        *strVal = NULL;
    int l_associationState;
    int l_status;
    long l_RecoveryTime_Own;
    long l_RecoveryTime_UPF;
    l_ret = nats_JSONParse(&json, reply->str, -1);
    if( ret == NATS_OK ){
        ret = nats_JSONGetValue(json, "associationState", TYPE_STR, (void**)&strVal);
        if( ret != NATS_OK ){
            DbgFErr( DbgDTxt, "nats_JSONGetValue NG get associationState" );
            /* データ解放 */
            nats_JSONDestroy(json);
            freeReplyObject(reply);
            return AssociationMng_NG;
        }
        /* 文字列を状態に変換 */
        if ( strncmp( strVal, "ous", 4) == 0 ) {
            l_associationState = JELB_STAT_OUS;
        }
        if ( strncmp( strVal, "ins", 4) == 0 ) {
            l_associationState = JELB_STAT_INS;
        }
        if ( strncmp( strVal, "flt", 4) == 0 ) {
            l_associationState = JELB_STAT_FLT;
        }

        ret = nats_JSONGetValue(json, "UpfRecoveryTime", TYPE_STR, (void**)&strVal);
        if( ret != NATS_OK ){
            DbgFErr( DbgDTxt, "nats_JSONGetValue NG get UpfRecoveryTime" );
            /* データ解放 */
            nats_JSONDestroy(json);
            freeReplyObject(reply);
            return AssociationMng_NG;
        }
        // strtol関数による変換
        l_RecoveryTime_UPF = std::strtol(strVal, NULL, 10);
        
        ret = nats_JSONGetValue(json, "CupsIfRecoveryTime", TYPE_STR, (void**)&strVal);
        if( ret != NATS_OK ){
            DbgFErr( DbgDTxt, "nats_JSONGetValue NG get CupsIfRecoveryTime" );
            /* データ解放 */
            nats_JSONDestroy(json);
            freeReplyObject(reply);
            return AssociationMng_NG;
        }
        // strtol関数による変換
        l_RecoveryTime_Own = std::strtol(strVal, NULL, 10);
        l_status = JLDB_INS;
    } else {
        /* Redis未登録の場合 */
        l_associationState = JELB_STAT_OUS;
        l_RecoveryTime_UPF = 0;
        l_RecoveryTime_Own = 0;
        l_status = JLDB_OUS;
    }

    /* インスタンス生成 */
    l_Association = new Association();
    l_Association->setAssociationStatus(l_associationState);
    l_Association->setCupsIfRecoveryTime(l_RecoveryTime_Own);
    l_Association->setUpfRecoveryTime(l_RecoveryTime_UPF);
    l_Association->setStatus(l_status);
    l_Association->setOwnIP(l_node_addr);
    l_Association->setUpfIPaddress(a_upf_address);
}


}
