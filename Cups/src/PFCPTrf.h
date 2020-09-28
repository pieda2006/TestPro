#ifndef PFCPTrf_h
#define PFCPTrf_h

/* �إå��ե����� */

extern "C"
{

#include "Ffpl.h"

}

namespace cups {

/* ���饹���  */

class PFCPTrf
{

    public:

    /* ��������� */
    int PFCPTrfInit();

    /* PFCP����ꥯ�������������ȥ�ҥå��������  */
    void reqSendTrfCount( uint8_t a_num);

    /* PFCP����ꥯ�������������ȥ�ҥå�������ȴؿ�����  */
    Ffpl_trf_req_send_func getReqSendTrfCountFunc();

    /* PFCP����ꥯ�����ȼ������ȥ�ҥå�������� */
    void reqReceiveTrfCount( uint8_t a_num);

    /* PFCP����ꥯ�����ȼ������ȥ�ҥå�������ȴؿ�����  */
    Ffpl_trf_req_recv_func getReqReceiveTrfCountFunc();

    /* PFCP����쥹�ݥ��������ȥ�ҥå��������  */
    void respSendTrfCount( uint8_t a_num1, uint8_t a_num2);

    /* PFCP����쥹�ݥ��������ȥ�ҥå�������ȴؿ�����  */
    Ffpl_trf_rsp_send_func getRespSendTrfCountFunc();

    /* PFCP����쥹�ݥ󥹼������ȥ�ҥå��������  */
    void respReceiveTrfCount( uint8_t a_num1, uint8_t a_num2);

    /* PFCP����쥹�ݥ󥹼������ȥ�ҥå�������ȴؿ�����  */
    Ffpl_trf_rsp_recv_func getRespReceiveTrfCountFunc();

    /* ���󥹥��󥹼��� */
    static PFCPTrf &getInstance(){
        static PFCPTrf instance;
        return instance;
    }
};
}

#endif
