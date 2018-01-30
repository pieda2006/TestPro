#ifndef Default_SetJsonAction_H
#define Default_SetJsonAction_H

#include <string>
#include <FactBase.h>
#include <ResultInfo.h>
#include <DecisdeActionAnswer.h>
#include <google/protobuf/message.h>
#include <ExecuteBase.h>
#include <DecisdeActionAnsJson.h>
#include <ActionInfo.pb.h>

/*** 今はActionInfoに固定でパラメータ設定、将来的には階層を意識した設定ができるように。 ***/

class SetJsonAction : public ExecuteBase {
private :
    std::string* m_MassageName;
    std::string** m_ParamName;
    std::string** m_ParamValue;
    int m_ParamNum;
    int* m_ParamType;

public :
    SetJsonAction();
    int executeActionImple(FactList* a_Fact, picojson::value* a_Value, ResultInfo* a_ResultInfo, DecisdeActionAnswer *a_OutputMessage, int a_CondtionID, bool a_Result,ConditionResult* a_ConditionResult);
    int setMassageName(std::string* a_MessageName);
    int setParamName(std::string** a_ParamName);
    int setParamNum(int a_ParamNum);
    int setParamValue(std::string** a_ParamValue);
    std::string** getParamValue();
    std::string* getMassageName();
    std::string** getParamName();
    int getParamNum();
    int setParamType(int* a_ParamType);

    ~SetJsonAction();
};
#endif
