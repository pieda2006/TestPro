/* ヘッダファイル */

extern "C"
{
}

#include "Association.h"
#include "DbgCom.h"

/* 関数定義 */

namespace cups {

/* 信号送信関数 */
int cups::Association::sendPFCPMessage(Ffpl_enc* enc_data, int msgType, int a_seqnum){

    Ffpl_enc l_enc_data;
    Ffpl_msg_head pfcp_msg_head;
    Ffpl_ie_Recovery_Time_Stamp   time_stamp;
    struct timeval now_time = {0,0};
    struct sockaddr_in l_dst_addr_v4;
    l_dst_addr_v4.sin_family = AF_INET;
    l_dst_addr_v4.sin_port = htons(JPFCP_PORT);
    l_dst_addr_v4.sin_addr = m_upf_address;

    /* 信号送信判定 */
    if(m_status == JLDB_INS && m_associationStatus == JELB_STAT_INS && msgType != JPFCP_MSG_ASSOC_SETUP_REQ && msgType != JPFCP_MSG_ASSOC_RELEASE_REQ){
        /* インス状態の際は信号送信 */
        /* 送信要求 */

    } else if (m_status == JLDB_OUS && m_associationStatus == JELB_STAT_OUS && msgType == JPFCP_MSG_ASSOC_SETUP_REQ){
        /* Association setup Request送信 */
        memset( &l_enc_data, 0x00, sizeof(l_enc_data) );
        /* 信号情報生成 */
        /* ヘッダ部設定 */
        memset( &pfcp_msg_head, 0x00, sizeof(pfcp_msg_head) );
        memset( &time_stamp, 0x00, sizeof(time_stamp) );
        pfcp_msg_head.MP = 0;
        pfcp_msg_head.S  = 0;
        pfcp_msg_head.Message_Type = a_pfcp_msg;
        pfcp_msg_head.Sequence_Number = m_seqnum;
        Lfpl_enc_pfcp_req( &pfcp_msg_head, &l_enc_data);

        /* nodeid設定 */
        Ffpl_ie_Node_ID               node_id;
        memset( &node_id, 0x00, sizeof(node_id) );
        node_id.Node_ID_Type = JPFCP_IE_NODE_ID_TYPE_IPV4;
        node_id.Node_ID_value.IPV4 = (struct in_addr*)&m_ownip;
        Lfpl_enc_pfcp_ie( &l_enc_data, NODE_ID, (void *)&node_id );

        /* RECOVERY_TIME_STAMP設定 */
        gettimeofday(&now_time, NULL);
        time_stamp.Recovery_Time_Stamp = (unsigned int)now_time.tv_sec + JELB_EPOCH_TIME;
        Lfpl_enc_pfcp_ie( &l_enc_data, RECOVERY_TIME_STAMP, (void *)&time_stamp ); 

        /* 信号送信 */
        ret = Lfpl_send_pfcp_req( &l_enc_data, (struct sockaddr *)&l_dst_addr_v4, 0, 0, NULL, 0, 0, &a_seqnum);

        /* 状態変更 */
        m_status = JLDB_INS;
        m_associationStatus = JELB_STAT_FLT;
        m_myrecoverytime = now_time.tv_sec;
        m_upfrecoverytime = 0;
    } else if (msgType == JPFCP_MSG_ASSOC_RELEASE_REQ){
        /* Association release Request送信 */
    } else {
        /* 信号送信しない */
        return Association_NG;
    }
}

int cups::Association::receivePFCPMessage(Ffpl_pfcp_recv*　a_recv){
    /* デコード用の領域確保 */
    Ffpl_dec l_dec;
    memset( &l_dec, 0x00, sizeof(l_dec) );
    /* トランザクション管理インスタンス取得 */
    TransactionMng l_TransactionMng = TransactionMng::getInstance()
    /* 受信信号でコード */
    int l_ret = Lfpl_dec_pfcp(a_recv,  &l_dec);
    if( JFPL_OK != l_ret )
    {
        DbgFErr( DbgDTxt, "Lfpl_dec_pfcp NG  ret=%d", l_ret );
        return Association_NG;
    }
    /* メッセージタイプから受信判定 */
    if(m_state == JELB_STAT_INS && m_associationState == JELB_STAT_FLT && l_dec.head.Message_Type  == JPFCP_MSG_ASSOC_SETUP_RSP){
        /* Association Setup Request送信中にAssociation Setup Response受信 */
        /* トランザクション取得 */
        Transaction* l_Transaction = l_TransactionMng.getTransaction(l_dec.head.Message_Type, l_dec.head.Sequence_Number);
        l_Transaction->setAssociation(this);
        l_Transaction->setDecData(&l_dec);
        l_Transaction->setPFCPMessage(a_recv);
        
        l_ret = l_Transaction->receivePFCPMessage(l_dec.head.Message_Type);
    } else if(m_state == JELB_STAT_OUS && m_associationState == JELB_STAT_FLT && l_dec.head.Message_Type  == JPFCP_MSG_ASSOC_RELEASE_RSP){
        /* Association  Release Request送信中にAssociation Release Response受信 */
        
    } else if(m_state == JELBU_REDIS_ASSOC_INS && m_associationState == JELBU_REDIS_ASSOC_INS ) {
        /* Association状態確立中はトランザクションに通知 */
    } else {
        /* Association未確立状態でのリアクション */
    }
    m_Transaction = l_Transaction;
    m_Transaction.releaseTransactionIns();
}

void cups::Association::associationStatusChg(unsigned int  msgType){
     if(m_state == JELB_STAT_OUS && m_associationState == JELB_STAT_OUS && msgType  == JPFCP_MSG_ASSOC_SETUP_REQ){
        m_state == JELB_STAT_INS;
        m_associationState == JELB_STAT_FLT;
     } else if(m_state == JELB_STAT_INS && m_associationState == JELB_STAT_FLT && msgType  == JPFCP_MSG_ASSOC_SETUP_RSP){
        m_state == JELB_STAT_INS;
        m_associationState == JELB_STAT_INS;
     } else if(m_state == JELB_STAT_INS && m_associationState == JELB_STAT_FLT && msgType  == JPFCP_MSG_ASSOC_RELEASE_REQ){
        m_state == JELB_STAT_OUS;
        m_associationState == JELB_STAT_FLT;
     } else if(m_state == JELB_STAT_INS && m_associationState == JELB_STAT_INS && msgType  == JPFCP_MSG_ASSOC_RELEASE_REQ){
        m_state == JELB_STAT_OUS;
        m_associationState == JELB_STAT_FLT;
     } else if(m_state == JELB_STAT_OUS && m_associationState == JELB_STAT_FLT && msgType  == JPFCP_MSG_ASSOC_RELEASE_RSP){
        m_state == JELB_STAT_OUS;
        m_associationState == JELB_STAT_OUS;
     } 
}

void cups::Association::setAssociationStatus(int a_associationStatus){
    m_associationStatus = a_associationStatus;
}
void cups::Association::setCupsIfRecoveryTime(long a_RecoveryTime_Own){
    m_myrecoverytime = a_RecoveryTime_Own;
}
void cups::Association::setUpfRecoveryTime(long a_RecoveryTime_UPF){
    m_upfrecoverytime = a_RecoveryTime_UPF;
}
void cups::Association::setStatus(int a_status){
    m_status = a_status;
}
void cups::Association::setOwnIP(struct in_addr a_ownip){
    m_ownip = a_ownip;
}
void cups::Association::setUpfIPaddress(struct in_addr a_upf_address);
    m_upf_address = a_upf_address;
}
void cups::Association::releaseAssociationIns(){
    redisReply  *reply = NULL;
    char  *state_str;
    char  *associationState_str;

    /* 設定する文字列取得 */
    switch (m_state)
    {
        case JELB_STAT_INS:
            state_str = JELBU_REDIS_ASSOC_INS;
            break;
        case JELB_STAT_OUS:
            state_str = JELBU_REDIS_ASSOC_OUS;
            break;
        case JELB_STAT_FLT:  /* stateとして過渡期はない */
        case JELB_STAT_NONE:
        default:
            return JELB_NG;
    }
     /* 設定する文字列取得 */
    switch (m_associationState)
    {
        case JELB_STAT_INS:
            associationState_str = JELBU_REDIS_ASSOC_INS;
            break;
        case JELB_STAT_OUS:
            associationState_str = JELBU_REDIS_ASSOC_OUS;
            break;
        case JELB_STAT_FLT:
            associationState_str = JELBU_REDIS_ASSOC_FLT;
            break;
        case JELB_STAT_NONE:
        default:
            return JELB_NG;
    }

    /* Redis上にAssociation情報登録 */
    char* l_query = "HGET UPF_Association_Data:%s %s {\"status\":\"%s\",\"associationState\":\"%s\",\"UpfRecoveryTime\":\"%d\",\"CupsIfRecoveryTime\":\"%d\"}";
    RedisAccess l_RedisAccess = RedisAccess::getInstance();
    int l_ret = l_RedisAccess.redisClusterCommand((void **)&reply, l_query, state_str,associationState_str,m_myrecoverytime, m_upfrecoverytime);
    if(REDIS_OK != l_ret)
    {
        DbgFErr( DbgDTxt, "ERROR:Ext_redisClusterCommand NG" );
    }
    delete this;
}