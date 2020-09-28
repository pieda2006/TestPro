#ifndef AssociationMng_h
#define AssociationMng_h

/* �إå��ե����� */

extern "C"
{

#include "Ffpl.h"
#include "Felb_dv_base.h"

}

namespace cups {

/* ���饹���  */

class AssociationMng
{

    public:

    /* ��������� */
    int assocMngInit();

    /* PFCP����������ؿ�  */
    void recPFCPsignal(Ffpl_pfcp_recv *a_recv);

    /* ���󥹥��󥹼��� */
    static AssociationMng &getInstance(){
        static AssociationMng instance;
        return instance;
    }
    /* ����������������Ѵؿ����� */
    Ffpl_pfcp_recv_func getRecSigFunc();

    /* Association Release���ؿ� */
    void AssociationRel(uint16_t a_num);

    /* Association Release�����Ѵؿ� */
    Ffpl_pfcp_assoc_rel_func getAssocRelFunc();

    /* IP���ɥ쥹����luid���Ѵ� */
   int chg_upfAddr_luid( struct in_addr upf_ipv4addr, Felb_luid *luid);

};
}

#endif
