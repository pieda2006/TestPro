#ifndef Default_ServicePlanFactory_H
#define Default_ServicePlanFactory_H

#include <ConditionBase.h>
#include <map>
#include <stdio.h>
#include <Config.h>
#include <ConditionFactory.h>
#include <ActionFactory.h>

#define ServicePlanFactory_OK 0
#define ServicePlanFactory_NO_Regist 1
#define ServicePlanFactory_NG -1

/**
 * @brief サービスプランを生成するクラス
 * @details Jsonファイルを読み込んでサービスプランの生成を行う。
 * @attention
 * @date 2017/09/07
 */

class ServicePlanFactory {
public :
    static ServicePlanFactory* m_ServicePlanFactory;

    int createServicePlan();

    int getServicePlanCondition(FactList* a_FactList, ConditionBase** a_Condition);

    static ServicePlanFactory* getInstance();
    int setServicePlan(ConditionBase* a_Condition, int a_ServicePlanID);

    int initialize();
    int finalize();

private :

    std::map<int, ConditionBase*> m_ServicePlan;
    int createCondition(picojson::value a_Value, ConditionBase** a_Condition, int a_Counter);

    std::string* m_MessageName;
    picojson::array m_PlanName;

protected :

    ServicePlanFactory();
};

#endif
