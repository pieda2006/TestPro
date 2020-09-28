/* �إå��ե����� */

extern "C"
{

#include "Lcups_lib.h"
#include "Ffpl.h"

}

#include "PFCPTrf.h"
#include "DbgCom.h"

/* �ؿ���� */

namespace cups {

/* ��������� */
int cups::PFCPTrf::PFCPTrfInit(){
}

/* PFCP����ꥯ�������������ȥ�ҥå��������  */
void cups::PFCPTrf::reqSendTrfCount( uint8_t a_num){
}

/* PFCP����ꥯ�������������ȥ�ҥå�������ȴؿ�����  */
Ffpl_trf_req_send_func cups::PFCPTrf::getReqSendTrfCountFunc(){
    return LreqSendTrfCount;
}

/* PFCP����ꥯ�����ȼ������ȥ�ҥå�������� */
void cups::PFCPTrf::reqReceiveTrfCount( uint8_t a_num){
}

/* PFCP����ꥯ�����ȼ������ȥ�ҥå�������ȴؿ�����  */
Ffpl_trf_req_recv_func cups::PFCPTrf::getReqReceiveTrfCountFunc(){
    return LreqReceiveTrfCount;
}

/* PFCP����쥹�ݥ��������ȥ�ҥå��������  */
void cups::PFCPTrf::respSendTrfCount( uint8_t a_num1, uint8_t a_num2){
}

/* PFCP����쥹�ݥ��������ȥ�ҥå�������ȴؿ�����  */
Ffpl_trf_rsp_send_func cups::PFCPTrf::getRespSendTrfCountFunc(){
    return LrespSendTrfCount;
}

/* PFCP����쥹�ݥ󥹼������ȥ�ҥå��������  */
void cups::PFCPTrf::respReceiveTrfCount( uint8_t a_num1, uint8_t a_num2){
}

/* PFCP����쥹�ݥ󥹼������ȥ�ҥå�������ȴؿ�����  */
Ffpl_trf_rsp_recv_func cups::PFCPTrf::getRespReceiveTrfCountFunc(){
    return LrespReceiveTrfCount;
}

}
