/* �إå��ե����� */

extern "C"
{

#include "Lcups_lib.h"
#include "Ffpl.h"

}

#include "TransactionMng.h"
#include "DbgCom.h"

/* �ؿ���� */

namespace cups {

/* ��������� */
int cups::TransactionMng::transactionMngInit(){
  /* ����������IP���ɥ쥹����  */
   char* l_nodeIP = getenv("EXTERNAL_IP_ADDRESS_IPV4");
   if(l_nodeIP == NULL){
       DbgFErr( DbgDTxt, "No Set EXTERNAL_IP_ADDRESS_IPV4");
       return TransactionMng_NG;
   }
   int l_ret = inet_aton(l_nodeIP, &m_mynodeIP);
   if(l_ret == 0){
       DbgFErr( DbgDTxt, "IP convert NG %s",l_nodeIP );
       return TransactionMng_NG;
   }

   /* Redis��Lua������ץ���Ͽ */
   char* l_luascript = "script load \"local num = redis.call('get','seqnum') local loopcount = 0 num = 'seqnum' .. num while (redis.call('setnx',num , 'lock') == 0) do if redis.call('incr','seqnum') == 10 then redis.call('set','seqnum','1') end num = redis.call('get','seqnum') num = 'seqnum' .. num loopcount = loopcount + 1 if loopcount == 10 then return 0 end end redis.call('expire',num , 30) return num\""
   redisReply* l_reply = NULL;
   l_redisIns = RedisAccess::getInstance();
   l_ret = l_redisIns.redisClusterCommand(&reply, l_luascript);
   DbgFDbg( DbgDTxt, "Ext_redisClusterCommand script=%d", ret );
   if(REDIS_OK != l_ret)
   {
       DbgFErr( DbgDTxt, "ERROR:Ext_redisClusterCommand NG" );
       DbgFTrc( DbgDTxt, "<=== %s() end", __FUNCTION__);
       return TransactionMng_NG;
   }
   m_evalsha = l_reply->str;
   DbgFDbg( DbgDTxt, "Ext_redisClusterCommand evalsha =%s", l_reply->str );

   return TransactionMng_OK
}

/* ���������ֹ�����ؿ� */
int32_t cups::TransactionMng::getSeqnoHunt(uint32_t *a_num){
    
    return 1;

}

/* ���������ֹ�����ؿ� */
void cups::TransactionMng::getSeqnoFree(uint32_t a_num){
    /* ����������������� */
}

/* ���������ֹ�����������Ѵؿ� */
Ffpl_seqno_hunt_func cups::TransactionMng::getSeqnoHuntFunc(){
    return LgetSeqnoHunt;
}

/* ���������ֹ�����������Ѵؿ� */
Ffpl_seqno_free_func cups::TransactionMng::getSeqnoFreeFunc(){
    return LgetSeqnoFree;
}

/* ���������ֹ���� GRPC���� */
unsigned int cups::TransactionMng::getSeq_Number(){
    unsigned int l_seqnum;
    int l_ret = getSeqnoHunt(&l_seqnum);
    if(TransactionMng_OK != l_ret){
        DbgFErr( DbgDTxt, "getSeqnoHunt NG" );
        return 0;
    }
    DbgFDbg( DbgDTxt, "seqnum = %d", l_seqnum );

    return l_seqnum;
}

/* PFCP���������׵� */
int cups::TransactionMng::snd_pfcp(
//    Felb_luid gwuid,
    struct in_addr upf_address,
    int th_id,
    unsigned int seq_no,
    unsigned char usr_no,
    Ffpl_enc *enc_pfcp,
    unsigned int pfcp_msg,
    unsigned short *err_fb,
    unsigned char *err_cause
){

    int l_count;
    struct in_addr l_upf_address;
    int l_status;
    int l_msgtype;
    int l_seqnum;
    struct in_addr l_ownip;
    struct in_addr l_upfip;
    Transaction* l_transaction;

    /* Redis�����������ƥ��������ֹ����Ͽ�����뤫�����å�����(̤����)  */
    RedisAccess& l_redis_ins = RedisAccess::getInstance();
    char* l_getTransactionString = "HGETALL Transaction:%d";
    redisReply  *reply = NULL;
    l_ret = l_redis_ins.redisClusterCommand(&reply, l_getTransactionString, seq_no);
    if(REDIS_OK != l_ret)
    {
        DbgFErr( DbgDTxt, "ERROR:Ext_redisClusterCommand NG" );
        DbgFTrc( DbgDTxt, "<=== %s() end", __FUNCTION__);
        return TransactionMng_NG;
    }

    /* �ȥ�󥶥�����󥤥󥹥������� */
    TransactionFactory& l_TransactionFact = TransactionFactory::getInstance();
    Transaction* l_Transaction = l_TransactionFact.createTransaction(pfcp_msg, seq_no, upf_address);
    if(NULL == l_Transaction){
        DbgFErr( DbgDTxt, "getTransactionObj NG" );
        return TransactionMng_NG;
    }

    if(reply->elements == 0){
        /* �ȥ�󥶥��������Ͽ̵ */
        /* Redis�Υǡ�����̵�����������׵�򸵤����� */
        /* �ȥ�󥶥�����󥤥󥹥������� */
        TransactionFactory& l_TransactionFact = TransactionFactory::getInstance();
        l_Transaction = l_TransactionFact.createTransaction(pfcp_msg, ,seq_no, upf_address, m_mynodeIP);
        if(NULL == l_Transaction){
            DbgFErr( DbgDTxt, "Create TransactionObj NG" );
            return TransactionMng_NG;
        }
    } else {
        /* �ȥ�󥶥��������Ͽͭ */
        /* Redis�Υǡ������������Redis�Υǡ����򸵤˺��� */
        /* �ȥ�󥶥�����󥤥󥹥������� */
        TransactionFactory& l_TransactionFact = TransactionFactory::getInstance();
        for (l_count = 0; l_count < reply->elements; l_count++){
            if (strncmp(reply->element[l_count]->str, "status", 6) == 0 ){
                /* �ȥ�󥶥�������������  */
                l_count++;
                l_status = atoi(reply->element[l_count]->str);
            } else if(strncmp(reply->element[l_count]->str, "upfip", 5) == 0){
                /* �и����֤Υ��ɥ쥹����  */
                l_count++;
                l_ret = inet_aton(reply->element[l_count]->str, &l_upfip);
                if(l_ret == 0){
                    DbgFErr( DbgDTxt, "transaction ipv4 upfaddress convert NG" );
                    return TransactionMng_NG;
                }
                if(l_upfip != upf_address) {
                    DbgFErr( DbgDTxt, "send UPF IP NG transaction ip = %ld, send ip = %ld", l_upfip, upf_address );
                    return TransactionMng_NG;
                }
            } else if(strncmp(reply->element[l_count]->str, "ownip", 5) == 0){
                /* ����������IP���ɥ쥹����  */
                l_count++;
                l_ret = inet_aton(reply->element[l_count]->str, &l_ownip);
                if(l_ret == 0){
                    DbgFErr( DbgDTxt, "transaction ipv4 ownaddress convert NG" );
                    return TransactionMng_NG;
                }
            } else if(strncmp(reply->element[l_count]->str, "msgtype", 7) == 0){
                /* ��å����������׼��� */
                l_count++;
                l_msgtype = atoi(reply->element[l_count]->str);
                if(l_msgtype != pfcp_msg){
                    DbgFErr( DbgDTxt, "Different message types. send message type = %d, transaction message type = %d",pfcp_msg,l_msgtype );
                    return TransactionMng_NG;
                }
            } else if(strncmp(reply->element[l_count]->str, "seqnum", 7) == 0){
                /* ���������ֹ���� */
                l_count++;
                l_seqnum = atoi(reply->element[l_count]->str);
            } else {
                /* ���������� */
                DbgFErr( DbgDTxt, "illegal parameter  %s",reply->element[l_count]->str );
                return TransactionMng_NG;
            }
        } 
        l_transaction = l_TransactionFact.createTransaction(l_msgtype, l_seqnum, l_upfip, l_ownip, l_status);
        if(NULL == l_Transaction){
            DbgFErr( DbgDTxt, "Create TransactionObj NG" );
            return TransactionMng_NG;
        }
    }

    /* �����оݥǡ������� */
    l_Transaction->setEncData(enc_pfcp);

    /* Message����  */
    l_ret = l_Transaction->sendPFCPMessage();
    if(Transaction_OK != l_ret){
        DbgFErr( DbgDTxt, "sendPFCPMessage NG" );
        return TransactionMng_NG;
    }
    /* �ȥ�󥶥�����󥤥󥹥��󥹲��� */
    l_Transaction->releaseTransactionIns();
    return TransactionMng_OK;
}

/* EndMarker�����׵� */
int cups::TransactionMng::send_endmaker(
    struct in_addr upf_address,
    struct in_addr n3_upf_address,
    struct in_addr n3_gnb_address,
    unsigned int  n3_nnb_teid,
    unsigned int  upf_teid,
    int sock
){
    /* ��Ǽ��� */
    return 0;
}
}
