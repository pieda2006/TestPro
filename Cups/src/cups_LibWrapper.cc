/* include  */
#include <stdio.h>
#include "ProcMain.h"
#include "AssociationMng.h"
#include "TransactionMng.h"
#include "PFCPTrf.h"

extern "C" 
{
#include "Ffpl.h"
#include "Felb_dv_base.h"
}

#include "Lcups_lib.h"

/* using定義 */

using cups::ProcMain;
using cups::AssociationMng;
using cups::TransactionMng;
using cups::PFCPTrf;

/* C -> C++ 向けラッパー実態 */

extern "C" int LstartMain() {
    ProcMain* l_mainProc = new ProcMain();
    l_mainProc->startMain();
}

extern "C" void LrecPFCPsignal(Ffpl_pfcp_recv *a_recv){
    AssociationMng& l_AssociationMng = AssociationMng::getInstance();
    l_AssociationMng.recPFCPsignal(a_recv);
}

extern "C" int32_t LgetSeqnoHunt(uint32_t *a_num){
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    return l_TransactionMng.getSeqnoHunt(a_num);
}

extern "C" void LgetSeqnoFree(uint32_t a_num){
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    l_TransactionMng.getSeqnoFree(a_num);
    return ;
}

extern "C" void LAssociationRel(uint16_t a_num){
    AssociationMng& l_AssociationMng = AssociationMng::getInstance();
    l_AssociationMng.AssociationRel(a_num);
}

extern "C" void LreqSendTrfCount( uint8_t a_num){
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    l_PFCPTrf.reqSendTrfCount(a_num);
}

extern "C" void LreqReceiveTrfCount( uint8_t a_num){
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    l_PFCPTrf.reqReceiveTrfCount( a_num);
}

extern "C" void LrespSendTrfCount( uint8_t a_num1, uint8_t a_num2){
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    l_PFCPTrf.respSendTrfCount( a_num1, a_num2);
}

extern "C" void LrespReceiveTrfCount( uint8_t a_num1, uint8_t a_num2){
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    l_PFCPTrf.respReceiveTrfCount( a_num1, a_num2);
}

extern "C" unsigned int Lglb_getSeq_Number(){
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    return l_TransactionMng.getSeq_Number();
}

extern "C" int Lglb_chg_upfAddr_luid( struct in_addr upf_ipv4addr, Felb_luid *luid){
   AssociationMng& l_AssociationMng = AssociationMng::getInstance();
   return l_AssociationMng.chg_upfAddr_luid(upf_ipv4addr, luid);
}

extern "C" int Lglb_snd_pfcp(
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
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    return l_TransactionMng.snd_pfcp(upf_address,th_id,seq_no,usr_no,enc_pfcp,pfcp_msg,err_fb,err_cause);
}

extern "C" int Lglb_send_endmaker(
    struct in_addr upf_address,
    struct in_addr n3_upf_address,
    struct in_addr n3_gnb_address,
    unsigned int  n3_nnb_teid,
    unsigned int  upf_teid,
    int sock
){
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    return l_TransactionMng.send_endmaker(upf_address,n3_upf_address,n3_gnb_address,n3_nnb_teid,upf_teid,sock);
}

extern "C" int Lglb_send_radius(
    struct in_addr upf_address,
    unsigned int  radius_teid,
    struct in_addr nas_address,
    unsigned short nas_port,
    struct in_addr radius_address,
    unsigned short radius_port,
    const char *radius_proto,
    int radius_proto_size,
    int sock_
) {
    return 0;
}
