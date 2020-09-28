#ifndef RedisAccess_h
#define RedisAccess_h

/* Define定義 */
#define JREDIS_ACCESS_SERVER_MAX 10
#define JREDIS_ACCESS_SERVER_LEN 100
#define JREDIS_ACCESS_ENV_NAME "REDIS_HOST_PORT_"
#define JREDIS_ACCESS_ENV_LEN (sizeof(JREDIS_ACCESS_ENV_NAME) + 2)
#define JREDIS_ACCESS_OK 0
#define JREDIS_ACCESS_NG 1

/* template定義 */
template <typename ... Args>

/* ヘッダファイル */

extern "C"
{
}

namespace cups {

/* クラス定義  */

class RedisAccess
{
    /* クラスメンバ定義  */

    /* 関数定義 */
    private:
    RedisAccess();

    public:

    /* 初期化 */
    int redisInit();

    /* インスタンス取得 */
    static RedisAccess &getInstance(){
        static RedisAccess instance;
        return instance;
    }

    int redisClusterCommand( void **reply, const char *format, Args const & ... args);

};

}

#endif
