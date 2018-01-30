#ifndef Default_DecisdeActionReqProtobuf_H
#define Default_DecisdeActionReqProtobuf_H

#include <string>
#include <google/protobuf/message.h>
#include <DecisdeActionRequest.h>
#include <Config.h>
#include <pthread.h>

/**
 * @brief アクション決定のためのInput情報となるクラス。
 * @details
 * @attention
 * @date 2017/09/07
 */

class DecisdeActionReqProtobuf : public DecisdeActionRequest {
public :
    /**
     * @brief Fact登録用関数
     * @details Protocol Buffers形式のFactの登録を行う。
     * @param [in] a_FactInfo 登録対象のFactのアドレス。
     * @return DecisdeActionRequest_OK(0) 正常
     * @return DecisdeActionRequest_NG(-1) 異常
     * @exception なし
     * @attention 複数のFactを登録したい場合、Factの数分本関数をコールすること。<br>
     *            Protocol Bufferで自動生成されるクラスはMessageクラスを継承しているため<br>
     *            Protocol Bufferのオブジェクトのアドレスをそのまま指定する。<br>
     *            SAC.hをincludeすること。
     */

    int setFactInfo(google::protobuf::Message* a_FactInfo);
    int getFactInfo(google::protobuf::Message*** a_FactInfo);
    int initialize();
    DecisdeActionReqProtobuf();
    static DecisdeActionReqProtobuf* getInstance();
    static void init_routine();
    static void DecisdeActionReqProtobuf_Destroy(void* a_Object);

private :
    int m_MaxInputMessage; 
    static pthread_key_t m_pthread_key;
    static pthread_once_t buffer_key_once;
    google::protobuf::Message** m_Message;
    int m_FactCounter;
};





#endif
