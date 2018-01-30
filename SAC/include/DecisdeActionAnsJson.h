#ifndef Default_DecisdeActionAnsJson_H
#define Default_DecisdeActionAnsJson_H

#include <string>
#include <stdio.h>
#include <DecisdeActionAnswer.h>
#include <picojson.h>
#include <pthread.h>

/**
 * @brief アクション決定時のOutPut情報のクラス。
 * @details
 * @attention
 * @date 2017/09/07
 */

class DecisdeActionAnsJson : public DecisdeActionAnswer {
public :

    DecisdeActionAnsJson();

    int setActionInfo(std::string* a_ActionInfo);
    /**
     * @brief OutPut情報のProtocol Bufferのアドレスを返却する関数。
     * @details
     * @param [out] a_Message アクション決定の結果を格納したProtocol Buffersのオブジェクトのアドレス。
     * @return
     * @return DecisdeActionAnswer_OK(0) 正常
     * @return DecisdeActionAnswer_NG(-1) 異常
     * @return DecisdeActionAnswer_NODATA(1) データ未設定。(アクション無)
     * @exception なし
     * @attention Output情報のProtocol Buffersのオブジェクトのアドレス格納用のアドレス領域はユーザ側で確保すること。<br>
     *            DecisdeActionAnswer_NG,DecisdeActionAnswer_NODATAでreturnされた場合は<br>
     *            a_ActionInfoの設定は保証しない。
     *            SAC.hをincludeしていること。
     */
    int getActionInfo(std::string** a_Message);

    int getActionInfo(picojson::value* a_value);
    int setActionInfo(picojson::value a_value);

    int initialize();

    static DecisdeActionAnsJson* getInstance();
    static void DecisdeActionAnsJson_Destroy(void* a_Object);
    static void init_routine();

private :
    static pthread_key_t m_pthread_key;
    static pthread_once_t buffer_key_once;
    picojson::value m_value; /*** 将来的には複数持てるようにする ***/
    std::string* m_Message;

};

#endif
