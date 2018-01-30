#ifndef Default_Config_H
#define Default_Config_H

#include <picojson.h>
#include <string>
#include <sstream>
#include <fstream>
#include <iostream>

#define Condig_OK 0
#define Condig_NG -1
#define Config_ArrayOver 1

/**
 * @brief Config値保持クラス
 * @details SAC.sgから読み込んだSG値を保持するクラス。
 * @attention シングルトンクラス。
 * @date 2017/09/01
 */

class Config {

private :

    /**
     * @brief Config値保持領域
     * @details SAC.sgから読み込んだSG値を保持する領域。
     *          階層構造は設定できない。
     */

    picojson::value m_SgValue;

    /**
     * @brief Config値保持領域
     * @details SAC.sgから読み込んだSG値を保持する領域。
     *          階層構造は設定できない。
     */
    
    static Config* m_Config;

public :

    /**
     * @brief コンストラクタ
     * @details 
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    Config();

    /**
     * @brief インスタンス取得関数
     * @details TAT測定結果：35 usec
     * @param なし
     * @return なし
     * @exception なし
     * @attention なし
     */

    static Config* getInstance();

    /**
     * @brief SGファイル読み込み
     * @details SGファイル読み込み処理を行い、読み込んだ情報をm_SgValueに保持する。
     *          3要素のJSON読み込みTAT測定結果：134 usec
     * @param [in] 読み込み対象のファイルパス
     * @return Condig_OK(0) 正常
     * @return Condig_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int readSg(std::string* a_FilePath);

    /**
     * @brief Int型のSG値の読み込み
     * @details m_SgValueから指定したパラメータ名の値を取得する。
     *          3要素のJSON読み込みTAT測定結果：1 usec
     * @param [in] パラメータ名
     * @param [out] SG値
     * @return Condig_OK(0) 正常
     * @return Condig_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int getSgIntValue(std::string* a_ParamName, int* a_IntValue);

    /**
     * @brief String型のSG値の読み込み
     * @details m_SgValueから指定したパラメータ名の値を取得する。
     *          3要素のJSON読み込みTAT測定結果：1 usec
     * @param [in] パラメータ名
     * @param [out] SG値
     * @return Condig_OK(0) 正常
     * @return Condig_NG(-1) 異常
     * @exception なし
     * @attention 取得した文字列領域は呼び出し元で解放すること。
     */

    int getSgStringValue(std::string* a_ParamName, std::string** a_StringValue);

    /**
     * @brief Int型のSG値の読み込み
     * @details m_SgValueから指定したパラメータ名の値を取得する。配列で設定された値の取得。
     * @param [in] パラメータ名
     * @param [out] SG値
     * @return Condig_OK(0) 正常
     * @return Condig_NG(-1) 異常
     * @exception なし
     * @attention なし
     */

    int getSgIntArray(std::string* a_ParamName, int* a_IntValue, int a_Index);

    /**
     * @brief String型のSG値の読み込み
     * @details m_SgValueから指定したパラメータ名の値を取得する。配列で設定された値の取得。
     * @param [in] パラメータ名
     * @param [out] SG値
     * @return Condig_OK(0) 正常
     * @return Condig_NG(-1) 異常
     * @exception なし
     * @attention 取得した文字列領域は呼び出し元で解放すること。
     */

    int getSgStringArray(std::string* a_ParamName, std::string** a_StringValue, int a_Index);










};

#endif
