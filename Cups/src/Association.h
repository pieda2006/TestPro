#ifndef Association_h
#define Association_h

/* �إå��ե����� */

extern "C"
{
}

namespace cups {

/* ���饹���  */

class Association
{

    public:

    /* ���������ؿ� */
    int sendPFCPMessage(Ffpl_enc* enc_data, int msgType);
    int receivePFCPMessage(a_recv : Ffpl_pfcp_recv*);
};
}

#endif
