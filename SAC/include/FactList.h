#ifndef Default_FactList_H
#define Default_FactList_H

#include <iterator>
#include <FactBase.h>
#include <Config.h>
#include <map>
#include <stdio.h>

#define FactList_OK 0
#define FactList_NG -1
#define FactList_UPDATE 1
#define FactList_NO_UPDATE 0
#define FactList_FILTER 1
#define FactList_NOFILTER 0

/**
 * @brief Factをリストとして保持するクラス
 * @details FactをFactTypeをキーとして検索可能なmapとして保持するクラス。
 * @attention 
 * @date 2017/09/02
 */

class FactList {
public :

    /**
     * @brief Fact保持クラスのコンストラクタ
     * @details Fact保持領域の確保を行う。
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    FactList();

    /**
     * @brief Fact保持クラスのデストラクタ
     * @details Fact保持領域の解放を行う。
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    ~FactList();

    /**
     * @brief Factの設定を行う。
     * @details メンバ変数にFactを登録する。
     * @param [in] a_InputFact 登録するFact
     * @return FactList_OK(0) 正常
     * @return FactList_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setFact(FactBase* a_InputFact);

    /**
     * @brief Factの設定を行う。
     * @details a_FactTypeNameで指定されたFactを削除する。
     * @param [in] a_FactTypeName 削除対象のFactType名。
     * @return FactList_OK(0) 正常
     * @return FactList_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int delFact(std::string* a_FactTypeName);

    /**
     * @brief Factの設定を行う。
     * @details a_FactTypeNameで指定されたFactを取得する。
     * @param [in] a_FactTypeName 取得対象のFactType名。
     * @param [out] a_Fact 取得したFactのリスト。
     * @return 登録されたFactの件数
     * @exception なし
     * @attention なし
     */

    int getFact(std::string* a_FactTypeName, std::multimap<int, FactBase*>::iterator* a_Fact);

    /**
     * @brief 指定されたFactTypeNameの変更有無を返す。
     * @details 
     * @param なし
     * @return FactList_NO_UPDATE(0) 変更無
     * @return FactList_UPDATE(1) 変更有
     * @return FactList_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int judgeChange(std::string* a_FactTypeName);

    /**
     * @brief Factの変更有無を初期化する。
     * @details 
     * @param なし
     * @return FactList_OK(0) 正常
     * @return FactList_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int initializeCangeKind();

private :
    /**
     * @brief Factに変更が入っているかを示す。
     * @details FactTypeIDを配列の添え字としてアクセスして変更有無を確認できる。
     */

    int* m_CangeKind;

    /**
     * @brief FactTypeのMax数。
     * @details SGから取得して設定する。
     */

    int m_MaxFactNum;
    /**
     * @brief FactTypeのMax数。
     * @details SGから取得して設定する。
     */

    int m_MaxFactTypeNum;

    /**
     * @brief FactNameとFactTypeIDの変換テーブル。
     * @details Factの名前からFactTypeIDを取得する。
     */

    std::map<std::string,int> m_FactTypeName;

    /**
     * @brief FactID払い出し用のカウンタ。
     * @details 
     */

    int FactIdCounter;

    /**
     * @brief FactTypeID払い出し用のカウンタ。
     * @details 
     */

    int FactTypeCounter;


    /**
     * @brief Factを保持するメンバ変数
     * @details FactTypeをキーにして検索が可能なマップ。
     */

    std::multimap<int, FactBase*> m_FactList;

};

#endif
