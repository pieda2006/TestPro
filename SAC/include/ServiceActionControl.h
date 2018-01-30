#ifndef Default_ServiceActionControl_H
#define Default_ServiceActionControl_H
#include <ExecuteEventBase.h>
#include <ConditionResult.h>
#include <FactList.h>
#include <DecisdeActionRequest.h>
#include <DecisdeActionAnswer.h>
#include <picojson.h>
#include <ServicePlanFactory.h>
#include <ConditionBase.h>
#include <FactFactory.h>
#include <Agenda.h>
#include <sys/time.h>
#include <DecisdeActionAnsJson.h>
#include <DecisdeActionAnsProtobuf.h>

#define ServiceActionControl_OK 0
#define ServiceActionControl_NG -1
#define ServiceActionControl_Execute 1
#define ServiceActionControl_Stop 0

/**
 * @brief アクション決定を行うクラス
 * @details ユーザ側から通知されたFactを元にアクションの決定を行うクラス。
 * @attention
 * @date 2017/09/02
 */

class ServiceActionControl : public ExecuteEventBase {
public :

    /**
     * @brief アクション決定関数
     * @details インプット情報とサービスプランを元に実行対象のアクションの決定を行う。
     * @param [in] a_InputMessage Factを登録したDecisdeActionRequestのオブジェクトアドレス。
     * @param [out] a_OutputMessage Output情報を登録したDecisdeActionAnswerのオブジェクトアドレスを格納するアドレス。
     * @return ServiceActionControl_OK(0) 正常
     * @return ServiceActionControl_NG(-1) 異常
     * @exception なし
     * @attention a_OutputMessageはユーザ側でアドレス設定領域を確保すること。<br>
     *            ServiceActionControl_NGでReturnした場合はa_OutputMessageの設定は保証されません。<br>
     *            a_OutputMessageはベースクラスのDecisdeActionAnswerの型で返却するため、getMessageTypeで<br>
     *            Protocol BufferかJson形式かを確認して対応する派生クラスの型に変換を掛けて参照すること。<br>
     *            SAC.hをincludeすること。
     */

    int decideServiceAction(DecisdeActionRequest* a_InputMessage, DecisdeActionAnswer** a_OutputMessage);

    /**
     * @brief アクション決定クラスオブジェクト取得関数
     * @details
     * @param なし
     * @return ServiceActionControlのオブジェクトアドレス。
     * @exception なし
     * @attention SAC.hをincludeすること。
     */
    static ServiceActionControl* getInstance();
    ServiceActionControl();
    ~ServiceActionControl();
private :
    static ServiceActionControl* m_ServiceActionControl;
};

#endif
