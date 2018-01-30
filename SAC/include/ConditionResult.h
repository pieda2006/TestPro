#ifndef Default_ConditionResult_H
#define Default_ConditionResult_H

#include <Config.h>

#define ConditionResult_OK 0
#define ConditionResult_NO_Eval -1

/**
 * @brief 条件評価結果保持クラス
 * @details ConditionBaseで条件評価した結果を保持して置く。
 * @attention 
 * @date 2017/08/31
 */

class ConditionResult {
private :

    /**
     * @brief Factが最大何件処理可能かを保持する変数
     * @details SG値からFactのマックス件数を読み込み設定する。
     */

    int m_MaxFactNum;

    /**
     * @brief Conditionが最大何件処理可能かを保持する変数
     * @details SG値からConditionのマックス件数を読み込み設定する。
     */

    int m_MaxConditionNum;

    /**
     * @brief 条件のツリー構造のどの位置を参照しているかを示す変数
     * @details 
     */

    int m_CurrentResultIndex;

    /**
     * @brief 条件の評価結果を保持する変数
     * @details 各Factの評価結果を変数内に保持する。
     */

    int** m_FactResult;

public :

    /**
     * @brief 条件評価結果保持クラスのコンストラクタ
     * @details 条件評価結果保持領域の確保を行う。
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    ConditionResult();

    /**
     * @brief 条件評価結果保持クラスのデストラクタ
     * @details 条件評価結果保持領域の解放を行う。
     * @param なし
     * @return なし
     * @exception なし
     * @attention 
     */

    ~ConditionResult();

    /**
     * @brief 条件評価した結果を結果保持領域に設定する。
     * @details ConditionBaseで条件評価した結果を結果保持領域に設定する。
     *          全Factの評価結果をまとめて通知する。
     * @param [in] a_ConditionID 結果を設定するConditionID
     * @param [in] a_Result 条件評価の結果
     * @return ConditionResult_OK(0) 正常
     * @exception なし
     * @attention 
     */

    int setResult(int a_ConditionID, int* a_Result);

    /**
     * @brief 条件評価結果取得する
     * @details ConditionBaseで条件評価した結果を結果保持領域の設定値を返却する。
     * @param [in] a_ConditionID 結果を設定するConditionID
     * @param [out] a_Result 条件評価の結果
     * @return ConditionResult_OK(0) 正常
     * @exception なし
     * @attention 
     */
     
    int getResult(int a_ConditionID, int* a_Result);
    
    /**
     * @brief 条件の最大件数を取得する
     * @details メンバ変数m_MaxConditionNumの値を返却する。
     * @param なし
     * @return m_MaxConditionNumの設定値
     * @exception なし
     * @attention 
     */
     
    int getMaxConditionNum();
    
    /**
     * @brief Factの最大数を返却する
     * @details メンバ変数m_MaxFactNumの値を返却する。
     * @param なし
     * @return m_MaxFactNumの設定値
     * @exception なし
     * @attention 
     */
     
    int getMaxFactNum();
    
    /**
     * @brief Factの評価結果の初期化関数
     * @details ConditionResult_NO_Evalで初期化する。
     * @param なし
     * @return m_MaxFactNumの設定値
     * @exception なし
     * @attention 
     */
     
    int initialize();
    
};

#endif
