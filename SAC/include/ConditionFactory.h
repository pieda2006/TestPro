#ifndef Default_ConditionFactory_H
#define Default_ConditionFactory_H

#define ConditionFactory_OK 0
#define ConditionFactory_NG -1

/**
 * @brief Conditionのロジック作成クラス
 * @details SAC.sgから読み込んだSG名のファイルを読み込みクラスを生成する。
 * @attention シングルトンクラス。
 * @date 2017/09/06
 */

#include <string>
#include <ConditionBase.h>
#include <EvaluateEquals.h>
#include <EvaluateElement.h>
#include <EvaluateFact.h>
#include <EvaluateCompare.h>
#include <EvaluateAnd.h>
#include <EvaluateOr.h>


class ConditionFactory{

public :

    /**
     * @brief コンストラクタ
     * @details
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    ConditionFactory();

    /**
     * @brief インスタンス取得関数
     * @details
     * @param なし
     * @return ConditionFactoryのインスタンス。
     * @exception なし
     * @attention なし
     */

    static ConditionFactory* getInstance();

    /**
     * @brief Condition生成関数
     * @details ConfigからConditionのロジック記載ファイル名を取得し、該当ファイルを読み込みConditionのTreeを生成する。
     * @param なし
     * @return ConditionFactory_OK(0) 正常
     * @return ConditionFactory_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int CreateCondition();

    /**
     * @brief デストラクタ
     * @details
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    ~ConditionFactory();

    ConditionBase* getCondition(int a_ConditionType);

private :

    /**
     * @brief ConditionFactoryインスタンス保持領域
     * @details
     */

    static ConditionFactory* m_ConditionFactory;

    /**
     * @brief Condition保持領域
     * @details
     */

    ConditionBase** m_Condition;

    /**
     * @brief Condition生成関数
     * @details CreateConditionから呼び出されて指定されたファイルのJson定義に従ってConditionのTreeを生成する。
     * @param [in] a_fileName 読み込み対象ファイル名
     * @param [out] a_Condition 生成したConditionオブジェクト。
     * @return ConditionFactory_OK(0) 正常
     * @return ConditionFactory_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int makeCondition(std::string* a_fileName, ConditionBase** a_Condition);
    /**
     * @brief operationの生成関数
     * @details makeConditionから呼び出されて指定されたJsonオブジェクトのクラスオブジェクトの作成を行う。
     * @param [in] a_fileName 読み込み対象ファイル名
     * @return ConditionFactory_OK(0) 正常
     * @return ConditionFactory_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int makeOperation(picojson::value a_OperationValue, EvaluateBase** a_EvaluateBase);


};

#endif
