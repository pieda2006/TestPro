#ifndef RedisAccess_h
#define RedisAccess_h

/* Define��� */
#define JREDIS_ACCESS_SERVER_MAX 10
#define JREDIS_ACCESS_SERVER_LEN 100
#define JREDIS_ACCESS_ENV_NAME "REDIS_HOST_PORT_"
#define JREDIS_ACCESS_ENV_LEN (sizeof(JREDIS_ACCESS_ENV_NAME) + 2)
#define JREDIS_ACCESS_OK 0
#define JREDIS_ACCESS_NG 1

/* template��� */
template <typename ... Args>

/* �إå��ե����� */

extern "C"
{
}

namespace cups {

/* ���饹���  */

class RedisAccess
{
    /* ���饹�������  */

    /* �ؿ���� */
    private:
    RedisAccess();

    public:

    /* ����� */
    int redisInit();

    /* ���󥹥��󥹼��� */
    static RedisAccess &getInstance(){
        static RedisAccess instance;
        return instance;
    }

    int redisClusterCommand( void **reply, const char *format, Args const & ... args);

};

}

#endif
