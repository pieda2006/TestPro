#ifndef Default_ActionInfo_H
#define Default_ActionInfo_H

#include <ActionBase.h>
#include <ConditionResult.h>
#include <DecisdeActionAnswer.h>
#include <FactList.h>

#define ActionInfo_OK 0
#define ActionInfo_NG -1
#define ActionInfo_FactChange 1

class ActionBase;

/**
 * @brief Conditionの評価結果から抽出されたアクション情報のクラス
 * @details どのConditionIDのTrue/Falseどちらの結果で抽出されたアクションかを保持するクラス。
 * @attention 
 * @date 2017/09/04
 */

class ActionInfo {

    private :

    /**
     * @brief 抽出されたアクション
     * @details 
     */

    ActionBase* m_ActionBase;

    /**
     * @brief アクションが抽出されたConditionID
     * @details 
     */

    int m_ConditionID;

    /**
     * @brief True/Falseどちらの結果で抽出されたかを示す変数
     * @details 
     */

    bool m_ConditionResult;

    public :

    /**
     * @brief Conditionの評価で抽出されたアクションをメンバ変数に設定する関数。
     * @details 
     * @param [in] a_Action 登録対象のAction
     * @return ActionInfo_OK(0) 正常
     * @return ActionInfo_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setAction(ActionBase* a_Action);

    /**
     * @brief コンディションIDをメンバ変数に設定する関数。
     * @details 登録されたアクションがどのConditionIDで抽出されたアクションかを設定する。
     * @param [in] a_ConditionID 登録対象のConditionID
     * @return ActionInfo_OK(0) 正常
     * @return ActionInfo_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setConditionID(int a_ConditionID);

    /**
     * @brief 条件評価結果をメンバ変数に設定する関数。
     * @details 登録されたアクションがどのCondition評価結果で抽出されたアクションかを設定する。
     * @param [in] a_Result 登録対象の結果
     * @return ActionInfo_OK(0) 正常
     * @return ActionInfo_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setResult(bool a_Result);

    /**
     * @brief 条件評価結果をメンバ変数に設定する関数。
     * @details 登録されたアクションがどのCondition評価結果で抽出されたアクションかを設定する。
     * @param [in] a_FactList Fact情報
     * @param [in/out] a_OutputMessage Action実行結果の登録バッファ
     * @param [in] a_Result Factの評価結果
     * @return ActionInfo_OK(0) 正常
     * @return ActionInfo_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int executeAction(FactList* a_FactList, DecisdeActionAnswer* a_OutputMessage, ConditionResult* a_ConditionResult);

    /**
     * @brief Actionの優先度比較を行う関数
     * @details std::listでソートを行う際に使用するための関数。
     * @param [in] a_Result 登録対象の結果
     * @return true 条件一致
     * @return false 条件不一致
     * @exception なし
     * @attention なし
     */

    bool operator<(ActionInfo& a_RightActionInfo);

    ActionInfo();
};
#endif
