#ifndef AssoSetupTransaction_h
#define AssoSetupTransaction_h

/* �إå��ե����� */

extern "C"
{
}

namespace cups {

/* ���饹���  */

class AssoSetupTransaction : public Transaction
{
    int sendPFCPMessageImpl(unsigned int a_pfcp_msg);
    void releaseTransactionIns();
};
}

#endif
