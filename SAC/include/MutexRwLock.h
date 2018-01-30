#ifndef Default_MutexRwLock_H
#define Default_MutexRwLock_H

#include <iostream>
#include <errno.h>
#include <pthread.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/time.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <execinfo.h>
#include <errno.h>

#define MUTEXLOCK_RESULT_OK                  0
#define MUTEXLOCK_RESULT_NG                  1
#define MUTEXLOCK_RESULT_NG_ILLEGAL_PARAM    2

#define RWLOCK_PREFER_READER PTHREAD_RWLOCK_PREFER_READER_NP
#define WRITER_NONRECURSIVE PTHREAD_RWLOCK_PREFER_WRITER_NONRECURSIVE_NP


/**
 * @brief Mutexロック制御用クラス
 * @details Mutex Read/Writeロックを行うクラス。
 * @attention 
 * @date 2017/09/01
 */

class MutexRwLock
{

public :

    /**
     * @brief Mutexロッククラスのコンストラクタ
     * @details Mutexロックのリソース確保を行う。
     * @param [in] a_lock_num ロック数
     * @param [in] a_is_shared プロセス間でロック共有を行うかどうか。デフォルトはFalse
     * @param [in] a_shm_key 共有メモリキー
     * @param [in] a_np_kind ロックをする際の動作種別。デフォルトでは書き込みはロックを掛けた順序に従ってロックを取得可能。
     *                       RWLOCK_PREFER_READERを指定するとReadロックが全ていない状態になっていないとWriteロックを取得できない。
     * @return なし
     * @exception なし
     * @attention なし
     */

    MutexRwLock(int a_lock_num, bool a_is_shared = false, int a_shm_key = 0, int a_np_kind = WRITER_NONRECURSIVE);

    /**
     * @brief Mutexロッククラスのデストラクタ
     * @details Mutexロックのリソース解放を行う。
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    ~MutexRwLock();

    /**
    * @brief Writeロック関数
    * @details 指定されたインデックスのロックの取得を行う。
    * @param a_index ロックインデックス
    * @return MUTEXLOCK_RESULT_OK(0) 正常
    * @return MUTEXLOCK_RESULT_NG(1) 異常
    * @return MUTEXLOCK_RESULT_NG_ILLEGAL_PARAM(2) パラメータ異常
    * @exception なし
    * @attention なし
    */

    int writelock(int a_index);

    /**
     * @brief Readロック関数
     * @details 指定されたインデックスのロックの取得を行う。
     * @param a_index ロックインデックス
     * @return MUTEXLOCK_RESULT_OK(0) 正常
     * @return MUTEXLOCK_RESULT_NG(1) 異常
     * @return MUTEXLOCK_RESULT_NG_ILLEGAL_PARAM(2) パラメータ異常
     * @exception なし
     * @attention なし
     */

    int readlock(int a_index);

    /**
     * @brief アンロック関数
     * @details 指定されたインデックスのアンロックを行う。
     * @param a_index ロックインデックス
     * @return MUTEXLOCK_RESULT_OK(0) 正常
     * @return MUTEXLOCK_RESULT_NG(1) 異常
     * @return MUTEXLOCK_RESULT_NG_ILLEGAL_PARAM(2) パラメータ異常
     * @exception なし
     * @attention なし
     */

    int unlock(int a_index);

    /**
     * @brief ロック生成結果取得関数
     * @details ロックリソースの生成結果を返す。
     * @param なし
     * @return true 正常
     * @return false 失敗
     * @exception なし
     * @attention なし
     */

    bool isOK();

    /**
     * @brief ロックリソースの解放、再生成を行う関数
     * @details ロックリソースの解放、再生成を行う。
     * @param なし
     * @return MUTEXLOCK_RESULT_OK(0) 正常
     * @return MUTEXLOCK_RESULT_NG(1) 異常
     * @exception なし
     * @attention なし
     */

    int resetMutex();

private:

    /**
     * @brief ロック数
     * @details ロックリソース数。
     */

    int m_lock_num;

    /**
     * @brief プロセス間でのロック共有有無
     * @details プロセス間でのロック共有を行うかどうかの値を保持する。
     */

    bool m_is_shared;

    /**
     * @brief ロックリソースを配置する共有メモリキー
     * @details ロックリソースを確保する際の共有メモリキー。
     */

    int m_shm_key;

    /**
     * @brief ロックリソースを配置した共有メモリID
     * @details ロックリソースを確保した際に払い出された共有メモリID。
     */

    int m_shm_id;

    /**
     * @brief ロックリソースの確保結果
     * @details ロックリソースを確保した際の処理結果。
     */

    bool m_is_ok;

    /**
     * @brief ロックリソースのアクセスポインタ
     * @details ロックリソースを確保した領域の先頭アドレス。
     */

    pthread_rwlock_t* m_mutex_p;

    /**
     * @brief ロックリソースの設定パラメータ
     * @details ロックリソースの設定パラメータ。
     */

    pthread_rwlockattr_t m_mutexattr;
};
#endif
