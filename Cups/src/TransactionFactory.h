#ifndef TransactionFactory_h
#define TransactionFactory_h

/* �إå��ե����� */

extern "C"
{
}

namespace cups {

/* ���饹���  */

class TransactionFactory
{

    public:

    /* ��������� */
    int tranFactInit();

    /* ���󥹥��󥹼��� */
    static TransactionFactory &getInstance(){
        static TransactionFactory instance;
        return instance;
    }

    /* Transaction���� */
    Transaction* createTransaction(unsigned int pfcp_msg, unsigned int seq_no, struct in_addr a_upf_address, struct in_addr a_ownip,int a_status = -1);


};
}

#endif
