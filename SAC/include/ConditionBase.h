#ifndef Default_ConditionBase_H
#define Default_ConditionBase_H

#define ConditionBase_OK 0
#define ConditionBase_NG -1
#define ConditionBase_True 0x00000001;
#define ConditionBase_False 0x00000010;
#define ConditionBase_TrueFalse 2;
#define ConditionBase_UPDATE 1
#define ConditionBase_NO_UPDATE 0

#include <FactList.h>
#include <Agenda.h>
#include <ConditionResult.h>
#include <EvaluateBase.h>
#include <vector>

/**
 * @brief 条件評価用クラス
 * @details 条件評価を行うためのクラス。
 * @attention 
 * @date 2017/09/04
 */

class ConditionBase {
public :

    /**
     * @brief 条件評価用クラスのコンストラクタ
     * @details 
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    ConditionBase();

    /**
     * @brief 条件評価用クラスのコピーコンストラクタ
     * @details
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */
    ConditionBase(ConditionBase* a_ConditionBase);

    /**
     * @brief 条件評価関数
     * @details Factを通知して条件評価を行う。
     * @param [in] a_InputFact 条件評価のインプット情報。
     * @param [in/out] a_Action 条件評価の結果、抽出されたアクションが設定される。
     * @param [in/out] a_ConditionResult 条件評価の結果が格納される。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int evaluateCondition(FactList* a_InputFact, Agenda* a_Action, ConditionResult* a_ConditionResult);

    /**
     * @brief Action取得関数
     * @details Conditionに登録されたアクションを取得する。
     * @param [in] a_InputFact 条件評価のインプット情報。
     * @param [in/out] a_Action Conditionに設定されたアクションが設定される。
     * @param [in/out] a_ActionNum Conditionに設定されたアクションの数を設定する。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

     int getFalseAction(ActionBase*** a_Action, int* a_ActionNum);

    /**
     * @brief Action取得関数
     * @details Conditionに登録されたアクションを取得する。
     * @param [in] a_InputFact 条件評価のインプット情報。
     * @param [in/out] a_Action Conditionに設定されたアクションが設定される。
     * @param [in/out] a_ActionNum Conditionに設定されたアクションの数を設定する。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

     int getTrueAction(ActionBase*** a_Action, int* a_ActionNum);

    /**
     * @brief 次Condition取得関数
     * @details Conditionに次Conditionとして登録されたオブジェクトを取得する。
     * @param なし
     * @return 次のConditionのアドレス
     * @exception なし
     * @attention なし
     */

    ConditionBase* getNextFalseCondition();

    /**
     * @brief 次Condition取得関数
     * @details Conditionに次Conditionとして登録されたオブジェクトを取得する。
     * @param なし
     * @return 次のConditionのアドレス
     * @exception なし
     * @attention なし
     */

    ConditionBase* getNextTrueCondition();

    /**
     * @brief ConditionID設定関数
     * @details 
     * @param [in] a_ConditionID 設定対象のConditionID
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setConditionID(int a_ConditionID);

    /**
     * @brief ConditionType取得関数
     * @details
     * @param なし
     * @return ConditionType
     * @exception なし
     * @attention なし
     */

    int getConditionType();


    int getConditionId();


    /**
     * @brief ConditionType設定関数
     * @details 
     * @param [in] a_ContionType 設定対象のConditionType。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setConditionType(int a_ContionType);

    /**
     * @brief Action設定関数
     * @details 
     * @param [in] a_Action 設定対象のアクションのオブジェクト。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setFalseAction(ActionBase* a_Action);

    /**
     * @brief Action設定関数
     * @details 
     * @param [in] a_Action 設定対象のアクションのオブジェクト。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setTrueAction(ActionBase* a_Action);

    /**
     * @brief Condition設定関数
     * @details 
     * @param [in] a_Condition 設定対象のConditionのオブジェクト。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setNextFalseCondition(ConditionBase* a_Condition);

    /**
     * @brief Condition設定関数
     * @details 
     * @param [in] a_Condition 設定対象のConditionのオブジェクト。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setNextTrueCondition(ConditionBase* a_Condition);

    /**
     * @brief Conditionパラメータ設定関数
     * @details 
     * @param [in] a_value 設定対象のパラメータ。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setJsonValue(picojson::value a_value);

    /**
     * @brief Conditionで参照するMessage名設定関数
     * @details 
     * @param [in] a_MessageName 設定対象のメッセージ名。
     * @return ConditionBase_OK(0) 正常
     * @return ConditionBase_NG(-1) 異常
     * @exception なし
     * @attention 引数で設定したメッセージ名の領域を保持するため呼び元で解放不要。
     */

    int setMessageName(std::string* a_MessageName);

    /**
     * @brief Conditionで参照する条件評価オブジェクトの設定
     * @details
     * @param [in] a_EvaluateObj 設定対象のオブジェクト。
     * @return ConditionBase_OK(0) 正常
     * @exception なし
     * @attention なし
     */

    int setEvaluateObj(EvaluateBase* a_EvaluateObj);

    /**
     * @brief Conditionで参照する条件評価オブジェクトを取得する
     * @details
     * @param なし
     * @return EvaluateBaseオブジェクト
     * @exception なし
     * @attention なし
     */
    EvaluateBase* getEvaluateObj();

    int getMaxActionNum();
    std::string* getMessageName();

    /**
     * @brief 評価対象のFactの名前を保持する変数
     * @details
     */

    std::string* m_MessageName;

private :

    /**
     * @brief ConditionIDを保持するメンバ変数
     * @details 
     */

    int m_ConditionID;

    /**
     * @brief ConditionTypeを保持するメンバ変数
     * @details 
     */

    int m_ConditionType;

    /**
     * @brief Conditionを保持するメンバ変数
     * @details 条件評価がFalseのものがあった場合に実行する次条件
     */

    ConditionBase* m_FalseCondition;

    /**
     * @brief Conditionを保持するメンバ変数
     * @details 条件評価がTrueのものがあった場合に実行する次条件
     */

    ConditionBase* m_TrueCondition;

    /**
     * @brief 条件評価ロジックを実装しているオブジェクトを保持する変数
     * @details 
     */

    EvaluateBase* m_EvaluateObject;

    /**
     * @brief 条件評価用のパラメータを保持している変数
     * @details 
     */

    picojson::value m_value;

    /**
     * @brief 条件評価がTrue時のアクションを保持する変数
     * @details 
     */

    ActionBase** m_TrueAction;

    /**
     * @brief 条件評価がFalse時のアクションを保持する変数
     * @details 
     */

    ActionBase** m_FalseAction;

    /**
     * @brief 評価対象のFactの名前を保持する変数
     * @details 
     

    std::string* m_MessageName;
    */

    /**
     * @brief 登録されているアクションの数
     * @details 
     */

    int m_TrueActionNum;

    /**
     * @brief 登録されているアクションの数
     * @details 
     */

    int m_FalseActionNum;

    /**
     * @brief 登録可能なアクションの最大数
     * @details 
     */

    int m_MaxActionNum;

};

#endif
