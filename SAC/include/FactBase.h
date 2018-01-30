#ifndef Default_FactBase_H
#define Default_FactBase_H

#include <vector>
#include <string>
#include <picojson.h>

#define FactBase_OK 0
#define FactBase_NG -1
#define FactBase_NOSET 1



class FactBase {

private :

    /**
     * @brief Factのm_MessageName
     * @details 
     */
    std::string* m_MessageName;

    /**
     * @brief FactのFactTypeID
     * @details FactTypeIDは動的に払い出しが行われる。
     */

    int m_FactType;

    /**
     * @brief FactのFactID
     * @details FactIDは動的に払い出しが行われる。
     */

    int m_FactID;

public :

    /**
     * @brief Factのコンストラクタ。
     * @details 
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    FactBase();

    /**
     * @brief Factのデストラクタ。
     * @details 
     * @param [in] m_MessageName 作成するFactのMessageName。
     * @return なし
     * @exception なし
     * @attention なし
     */

    ~FactBase();

    /**
     * @brief FactIDを設定する
     * @details 指定されたFactIDをメンバ変数へ設定する。
     * @param [in] a_FactID メンバ変数へ設定するFactID
     * @return FactBase_OK(0) 正常
     * @return FactBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setFactID(int a_FactID);

    /**
     * @brief FactIDを取得する
     * @details メンバ変数に設定されたFactIDを取得する。
     * @param なし
     * @return FactID
     * @exception なし
     * @attention なし
     */

    int getFactID();
    
    /**
     * @brief 指定したFactTypeを設定する
     * @details 指定されたFactTypeをメンバ変数へ設定する。
     * @param [in] FactType メンバ変数へ設定するFactTypeID
     * @return FactBase_OK(0) 正常
     * @return FactBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setFactType(int a_FactType);

    /**
     * @brief FactTypeIDを取得する
     * @details メンバ変数に設定されたFactTypeを取得する。
     * @param なし
     * @return FactType
     * @exception なし
     * @attention なし
     */

    int getFactType();

    /**
     * @brief MessageNameを取得する
     * @details メンバ変数に設定されたMessageNameを取得する。
     * @param [out] a_MessageName FactのMessageName
     * @return FactBase_OK(0) 正常
     * @return FactBase_NG(-1) 異常
     * @exception なし
     * @attention 返却された文字列領域は取得側で解放する。
     */

    int getMessageName(std::string** a_MessageName);

    /**
     * @brief MessageNameを設定する
     * @details メンバ変数に設定されたMessageNameを取得する。
     * @param [in] a_MessageName FactのMessageName
     * @return FactBase_OK(0) 正常
     * @return FactBase_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int setMessageName(std::string* a_MessageName);

    /**
     * @brief Factに登録された要素をパラメータ指定で取得する
     * @details Factに登録されたパラメータ名に対応する要素をString型で取得する。
     * @param [in] a_ParamName 取得対象のパラメータ名
     * @param [out] a_StringValue 取得した文字列。
     * @return FactType
     * @exception なし
     * @attention a_StringValueで取得した文字列領域はユーザ側で解放すること。
     */

    virtual int getStringParam(picojson::array a_ParamName, std::string** a_StringValue);

    /**
     * @brief Factに登録された要素をパラメータ指定で取得する
     * @details Factに登録されたパラメータ名に対応する要素をint型で取得する。
     * @param [in] a_ParamName 取得対象のパラメータ名
     * @param [out] a_IntValue 取得した数字。
     * @return FactType
     * @exception なし
     * @attention なし
     */

    virtual int getIntParam(picojson::array a_ParamName, int* a_IntValue);
};

#endif
