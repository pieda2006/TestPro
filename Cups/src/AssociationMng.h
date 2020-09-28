#ifndef AssociationMng_h
#define AssociationMng_h

/* ヘッダファイル */

extern "C"
{

#include "Ffpl.h"
#include "Felb_dv_base.h"

}

namespace cups {

/* クラス定義  */

class AssociationMng
{

    public:

    /* 初期化処理 */
    int assocMngInit();

    /* PFCP信号受信時関数  */
    void recPFCPsignal(Ffpl_pfcp_recv *a_recv);

    /* インスタンス取得 */
    static AssociationMng &getInstance(){
        static AssociationMng instance;
        return instance;
    }
    /* 信号受信時コール用関数取得 */
    Ffpl_pfcp_recv_func getRecSigFunc();

    /* Association Release時関数 */
    void AssociationRel(uint16_t a_num);

    /* Association Release取得用関数 */
    Ffpl_pfcp_assoc_rel_func getAssocRelFunc();

    /* IPアドレスからluidへ変換 */
   int chg_upfAddr_luid( struct in_addr upf_ipv4addr, Felb_luid *luid);

};
}

#endif
