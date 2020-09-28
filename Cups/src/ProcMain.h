#ifndef ProcMain_h
#define ProcMain_h

/* ヘッダファイル */
extern "C"
{
#include "Ffpl.h"
}

#define JProcMain_OK 0
#define JProcMain_NG 1

namespace cups {

/* クラス定義  */

class ProcMain
{

    /* 関数定義  */
    public:
    int startMain();

    private:
    void getCallback(Ffpl_init* a_pfcp_init);
};

}

#endif
