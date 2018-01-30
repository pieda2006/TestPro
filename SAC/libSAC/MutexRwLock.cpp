#include <MutexRwLock.h>$

MutexRwLock::MutexRwLock(
    int a_lock_num,
    bool a_is_shared,
    int a_shm_key,
    int a_np_kind)
{

    int api_result = -1;
    int tmp_errno = 0;

    m_is_ok = false;
    m_lock_num = a_lock_num;
    m_is_shared = a_is_shared;
    m_shm_key = a_shm_key;
    
    pthread_rwlockattr_init(&m_mutexattr);
    pthread_rwlockattr_setkind_np(&m_mutexattr, a_np_kind); 

    if (a_is_shared == true) {
    
        pthread_rwlockattr_setpshared(&m_mutexattr, PTHREAD_PROCESS_SHARED);
        m_shm_id = shmget(a_shm_key, sizeof(pthread_rwlock_t) * m_lock_num, 0666);
        tmp_errno = errno;
        if ((m_shm_id < 0) && (ENOENT == tmp_errno)) {
            m_shm_id = shmget(a_shm_key, sizeof(pthread_rwlock_t) * m_lock_num, 0666 | IPC_CREAT);
            tmp_errno = errno;
            if(m_shm_id < 0){
                return;
            }
            m_mutex_p = (pthread_rwlock_t*)shmat(m_shm_id, 0, 0);
            tmp_errno = errno;
            if((void *)-1L == m_mutex_p){
                return;
            }
            for (int i=0; i<m_lock_num; i++) {
                pthread_rwlock_init(&m_mutex_p[i], &m_mutexattr);
            }
        }
        else if(m_shm_id < 0) {
            return;
        }
        else {
            m_mutex_p = (pthread_rwlock_t*)shmat(m_shm_id, 0, 0);
            tmp_errno = errno;
            if((void *)-1L == m_mutex_p){
                return;
            }
        }
    }
    else{
        pthread_rwlockattr_setpshared(&m_mutexattr, PTHREAD_PROCESS_PRIVATE);
        m_mutex_p = new pthread_rwlock_t[m_lock_num];
        for (int i=0; i<m_lock_num; i++) {
            pthread_rwlock_init(&m_mutex_p[i], &m_mutexattr);
        }
    }
    m_is_ok = true;
    return;
}

MutexRwLock::~MutexRwLock()
{
    if (m_is_shared == true) {
        shmdt(m_mutex_p);
    }
    else{
        delete[] m_mutex_p;
    }

    pthread_rwlockattr_destroy(&m_mutexattr);
    m_is_ok = false;

    return;

}


int MutexRwLock::writelock(
    int a_index)
{

    int api_result = -1;
    int tmp_errno = 0;

    if (a_index < 0 || a_index >= m_lock_num) {
        return MUTEXLOCK_RESULT_NG_ILLEGAL_PARAM;
    }
    api_result = pthread_rwlock_wrlock(&m_mutex_p[a_index]);
    if (api_result != 0) {
        return MUTEXLOCK_RESULT_NG;
    }
    return MUTEXLOCK_RESULT_OK;
}

int MutexRwLock::readlock(
    int a_index)
{
    int api_result = -1;
    int tmp_errno = 0;

    if (a_index < 0 || a_index >= m_lock_num) {
        return MUTEXLOCK_RESULT_NG_ILLEGAL_PARAM;
    }

    api_result = pthread_rwlock_rdlock(&m_mutex_p[a_index]);

    if (api_result != 0) {
        return MUTEXLOCK_RESULT_NG;

    }

    return MUTEXLOCK_RESULT_OK;

}


int MutexRwLock::unlock(
    int a_index)
{

    int api_result = -1;

    if (a_index < 0 || a_index >= m_lock_num) {
        return MUTEXLOCK_RESULT_NG_ILLEGAL_PARAM;
    }
    api_result = pthread_rwlock_unlock(&m_mutex_p[a_index]);

    if (api_result != 0) {
        return MUTEXLOCK_RESULT_NG;
    }

    return MUTEXLOCK_RESULT_OK;

}


bool MutexRwLock::isOK() {
    return m_is_ok;

}


int MutexRwLock::resetMutex()
{
    for (int i=0; i<m_lock_num; i++) {
        pthread_rwlock_destroy(&m_mutex_p[i]);
        pthread_rwlock_init(&m_mutex_p[i], &m_mutexattr);
    }

    return MUTEXLOCK_RESULT_OK;
}

