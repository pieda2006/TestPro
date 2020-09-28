/* �إå��ե����� */

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

/* Define��� */
#define PFCP_IF_NAME "PFCP_IF_NAME"

/* using��� */

using thread::ThreadMng;
using pfcpsvr::PFCP_Server;

/* �ؿ���� */

namespace cups {

/* �ᥤ����� */
int cups::ProcMain::startMain( ) {

    /* udp�����å��Ѥ�IF̾ */
    char* ifname;

    /* Redis����ѤΥ��󥹥��󥹼��� */
    RedisAccess& l_RedisAccess = RedisAccess::getInstance();
    /* Redis��������� */
    l_RedisAccess.redisInit();
    /* ����åɥס������� */
    ThreadMng& l_ThreadMng = ThreadMng::getInstance();

    /* ��������������󥤥󥹥��󥹽����  */
    AssociationMng& l_AssociationMng = AssociationMng::getInstance();
    l_AssociationMng.assocMngInit();

    /* �ȥ�󥶥������Factory���󥹥��󥹽���� */
    TransactionFactory& l_TransactionFactory = TransactionFactory::getInstance();
    l_TransactionFactory.tranFactInit();

    /* �ȥ�󥶥�����󥤥󥹥��󥹽����  */
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    l_TransactionMng.transactionMngInit();

    /* �ȥ�ҥå����󥹥��󥹽���� */
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    l_PFCPTrf.PFCPTrfInit();
    /* PFCP����� */
    Ffpl_init pfcp_init;
    memset( &pfcp_init, 0x00, sizeof(pfcp_init) );
    /* ������Хå��ؿ����� */
    getCallback(&pfcp_init);

    /* fpl����������� */
    /* IF̾���� */
    ifname = getenv(PFCP_IF_NAME);
    if(ifname == NULL){
        DbgFErr( DbgDTxt, " %s  Not Found *****",PFCP_IF_NAME );
        /* default��eth0�ˤ��� */
        ifname = "eth0";
    }
    pfcp_init.a_if_name = ifname;
    pfcp_init.vrfid = 0;

    int ret = Lfpl_init(&pfcp_init, NULL);
    if(JFPL_OK != ret){
        DbgFErr( DbgDTxt, "Lfpl_init NG %d",ret );
        return -1;
    }

    /* NodeIP����� */
    char* l_node_addr  = getenv("EXTERNAL_IP_ADDRESS_IPV4");

    /* GRPC����� */
    struct in_addr *l_external_IP;
    ret = inet_aton(l_node_addr, l_external_IP);
    if(ret != 1){
        DbgFErr( DbgDTxt, "EXTERNAL_IP_ADDRESS_IPV4 Convert NG %d",ret );
    }
    ret = Spfcp_init(l_external_IP);

    LCOL_DBG("������");

    return 0;
}

void cups::ProcMain::getCallback(Ffpl_init* a_pfcp_init){

    /* AssociationMng���󥹥��󥹼���  */
    AssociationMng& l_AssociationMng = AssociationMng::getInstance();
    /* �����������ư�ؿ����� */
    a_pfcp_init->recv_func = l_AssociationMng.getRecSigFunc();
    /* ������������������Ǥ��������ư�ؿ� */
    a_pfcp_init->assoc_rel_func = l_AssociationMng.getAssocRelFunc();
    /* TransactionMng���󥹥��󥹼��� */
    TransactionMng& l_TransactionMng = TransactionMng::getInstance();
    /* ���������ֹ�ʧ���Ф��ؿ����� */
    a_pfcp_init->seqno_hunt_func = l_TransactionMng.getSeqnoHuntFunc();
    /* ���������ֹ�����ؿ����� */
    a_pfcp_init->seqno_free_func = l_TransactionMng.getSeqnoFreeFunc();
    /* �ȥ�ҥå��������󥹥��󥹼��� */
    PFCPTrf& l_PFCPTrf = PFCPTrf::getInstance();
    /* �ꥯ�����ȿ����������ꥯ�����ȿ��������
       �쥹�ݥ󥹿����������쥹�ݥ󥹿���������ȥ�ҥå�������ȴؿ�����  */
    a_pfcp_init->trf_req_send_func = l_PFCPTrf.getReqSendTrfCountFunc();
    a_pfcp_init->trf_req_recv_func = l_PFCPTrf.getReqReceiveTrfCountFunc();
    a_pfcp_init->trf_rsp_send_func = l_PFCPTrf.getRespSendTrfCountFunc();
    a_pfcp_init->trf_rsp_recv_func = l_PFCPTrf.getRespReceiveTrfCountFunc();
}

}
