#ifndef ProcMain_h
#define ProcMain_h

/* �إå��ե����� */
extern "C"
{
#include "Ffpl.h"
}

#define JProcMain_OK 0
#define JProcMain_NG 1

namespace cups {

/* ���饹���  */

class ProcMain
{

    /* �ؿ����  */
    public:
    int startMain();

    private:
    void getCallback(Ffpl_init* a_pfcp_init);
};

}

#endif
