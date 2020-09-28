/* ヘッダファイル */

#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#include "RedisAccess.h"

extern "C" 
{

#include "hiredis-vip/ext/Ext_hiredis-vip.h"

}

#include "DbgCom.h"

/* 関数定義 */

namespace cups {

cups::RedisAccess::RedisAccess(){
}

/* Redisコネクション接続 */
int cups::RedisAccess::redisInit(){

    int ret;
    int redis_server_num;
    char *a_redis_server;
    char  redis_server[JREDIS_ACCESS_SERVER_MAX][JREDIS_ACCESS_SERVER_LEN];
    char *a_list_redis_server[JREDIS_ACCESS_SERVER_MAX];
    char         redis_env_name[JREDIS_ACCESS_ENV_LEN];

    DbgFTrc( DbgDTxt, "===> %s() start", __FUNCTION__);

    DbgFDbg( DbgDTxt, "JREDIS_ACCESS_SERVER_MAX = %d", JREDIS_ACCESS_SERVER_MAX);

    /* 初期化 */
    memset(redis_server, 0, sizeof(redis_server));

    /* 環境変数からアドレスとポートを取得 */
    for (redis_server_num = 0; redis_server_num < JREDIS_ACCESS_SERVER_MAX; redis_server_num++)
    {
        /* Redis環境変数名を作成 */
        snprintf(redis_env_name, JREDIS_ACCESS_ENV_LEN, "%s%d", JREDIS_ACCESS_ENV_NAME,redis_server_num);

        DbgFDbg( DbgDTxt, "redis_env_name = %s", redis_env_name);

        /* 環境変数名取得 */
        a_redis_server = getenv(redis_env_name);

        if(NULL == a_redis_server)
        {
            break;
        }
        memcpy(redis_server[redis_server_num], a_redis_server, strlen(a_redis_server) +1);
        a_list_redis_server[redis_server_num] = &redis_server[redis_server_num][0];

        DbgFDbg( DbgDTxt, "redis_server[%d] = %s", redis_server_num, redis_server[redis_server_num]);
    }

    if( redis_server_num == 0)
    {
        DbgFErr( DbgDTxt, "INFO:***** %s  Not Found *****",JREDIS_ACCESS_ENV_NAME );
        memcpy(redis_server[0], "localhost:6379", sizeof("localhost:6379") +1);
        a_list_redis_server[0] = &redis_server[0][0];
        redis_server_num = 1;
    }


    /* Redis 接続 */
    ret = Ext_redisInit( (const char **)a_list_redis_server, redis_server_num);

    if(REDIS_OK != ret)
    {
        DbgFErr( DbgDTxt, "ERROR:Ext_redisInit NG" );
        DbgFTrc( DbgDTxt, "<=== %s() end", __FUNCTION__);
        return JREDIS_ACCESS_NG;
    }

    DbgFTrc( DbgDTxt, "<=== %s() end", __FUNCTION__);
    return JREDIS_ACCESS_OK;
}

int cups::RedisAccess::redisClusterCommand( void **reply, const char *format, Args const & ... args){
    return Ext_redisClusterCommand(reply, format, args ...);
}
}
