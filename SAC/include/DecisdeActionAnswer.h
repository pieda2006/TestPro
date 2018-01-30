#ifndef Default_DecisdeActionAnswer_H
#define Default_DecisdeActionAnswer_H

#include <string>
#include <stdio.h>

#define DecisdeActionAnswer_NODATA 1
#define DecisdeActionAnswer_OK 0
#define DecisdeActionAnswer_NG -1

#define DecisdeActionAnswer_JSON 1
#define DecisdeActionAnswer_Protobuf 2

/**
 * @brief アクション決定時のOutPut情報のクラス。
 * @details
 * @attention
 * @date 2017/09/07
 */

class DecisdeActionAnswer {
public :

    DecisdeActionAnswer();
    /**
     * @brief MessageTypeの取得関数
     * @details DecisdeActionAnswerがどの型で実装されているかを示す値を返却する。
     * @param なし
     * @return
     * @return DecisdeActionAnswer_JSON(1) Json形式
     * @return DecisdeActionAnswer_Protobuf(2) Protocol Buffers形式
     * @exception なし
     * @attention SAC.hをincludeしていること。
     */
    int getMessageType();

    int setMessageType(int a_MessageType);

    ~DecisdeActionAnswer();

private :
    int m_MessageType;
};

#endif
