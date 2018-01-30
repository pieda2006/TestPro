#include <ServicePlanFactory.h>

int initialize(void) __attribute__((constructor));

ServicePlanFactory* ServicePlanFactory::m_ServicePlanFactory = NULL;

int initialize(){

    Config* l_Config = Config::getInstance();
    std::string* l_SgPath = new std::string("SAC.sg");
    l_Config->readSg(l_SgPath);
    ConditionFactory* l_ConditionFactory = ConditionFactory::getInstance();
    l_ConditionFactory->CreateCondition();
    ActionFactory* l_ActionFactory = ActionFactory::getInstance();
    l_ActionFactory->CreateAction();
    ServicePlanFactory* l_ServicePlanFactory = ServicePlanFactory::getInstance();
    l_ServicePlanFactory->createServicePlan();

    delete l_SgPath;

    return ServicePlanFactory_OK;
}

int finalize(){
    return ServicePlanFactory_OK;
}

int ServicePlanFactory::getServicePlanCondition(FactList* a_FactList, ConditionBase** a_Condition) {

    std::multimap<int, FactBase*>::iterator l_Fact;

    int l_factcount = a_FactList->getFact(m_MessageName, &l_Fact);
    if(l_factcount == 0){
    	return ServicePlanFactory_NO_Regist;
    }

    FactBase* l_FactBase = l_Fact->second;

    int l_PlanID;
    l_FactBase->getIntParam(m_PlanName, &l_PlanID);

    std::map<int, ConditionBase*>::iterator l_iterator;
    l_iterator = m_ServicePlan.find(l_PlanID);
    if (l_iterator != m_ServicePlan.end()) {
        *a_Condition = l_iterator->second;
    } else {
    	return ServicePlanFactory_NO_Regist;
    }
    return ServicePlanFactory_OK;
}

ServicePlanFactory* ServicePlanFactory::getInstance() {
    if(m_ServicePlanFactory == NULL) {
        m_ServicePlanFactory = new ServicePlanFactory();
    }
    return m_ServicePlanFactory;
}

ServicePlanFactory::ServicePlanFactory() {
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("ServicePlanMessage");
    l_Config->getSgStringValue(l_ParamName, &m_MessageName);
    delete l_ParamName;
    l_ParamName = new std::string("PlanName");
    int l_Ret = Condig_OK;

    for(int l_Count = 0; l_Ret == Condig_OK; l_Count++){
        std::string* l_StringValue;
        l_Ret = l_Config->getSgStringArray(l_ParamName, &l_StringValue, l_Count);
        if(l_Ret == Config_ArrayOver){
            picojson::value l_value(*l_StringValue);
            m_PlanName.push_back(l_value);
        }
    }

    delete l_ParamName;
}

int ServicePlanFactory::setServicePlan(ConditionBase* a_Condition, int a_ServicePlanID){
    m_ServicePlan.insert(std::make_pair(a_ServicePlanID, a_Condition));
    return ServicePlanFactory_OK;
}

int ServicePlanFactory::createServicePlan(){

    /*** 今回は決め打ちでファイル読み込み次以降はDBから読み込み ***/
    std::stringstream ss;
    std::ifstream f;
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("ServicePlanName");
    std::string* l_ParamValue;
    ConditionBase* l_Condition;
    int l_Ret = Condig_OK;

    for(int l_Count = 0; l_Ret == Condig_OK; l_Count++){
        l_Ret = l_Config->getSgStringArray(l_ParamName, &l_ParamValue, l_Count);
        std::string* l_path = new std::string("");
        l_path->append(*l_ParamValue);

        if(l_Ret == Condig_OK){
            f.open(l_path->c_str(), std::ios::binary);
            ss.str("");
            ss << f.rdbuf();
            std::string str;
            str.clear();
            str = ss.str();
            f.close();
            picojson::value l_Value;
            picojson::parse(l_Value, str);

            int l_ConditionCount = 0;
            createCondition(l_Value, &l_Condition, l_ConditionCount);
            int l_ServicePlanID = atoi(l_ParamValue->c_str());
            setServicePlan(l_Condition, l_ServicePlanID);
        }
        delete l_path;
    }
    delete l_ParamName;
    return ServicePlanFactory_OK;
}

int ServicePlanFactory::createCondition(picojson::value a_Value, ConditionBase** a_Condition, int a_Counter){

    int l_ConditionType = a_Value.get<picojson::object>()["ConditionType"].get<double>();
    ConditionFactory* l_ConditionFactory = ConditionFactory::getInstance();
    ConditionBase* l_ConditionBase;
    l_ConditionBase = l_ConditionFactory->getCondition(l_ConditionType);

    picojson::object l_CondObj, l_InputObj;
    l_InputObj = a_Value.get<picojson::object>();

    std::map<std::string, picojson::value>::iterator  l_ite = l_InputObj.begin();

    for(; l_ite != l_InputObj.end(); ++l_ite){
        if(l_ite->first != "TrueAction" &&
           l_ite->first != "FalseAction" &&
           l_ite->first != "TrueNextCondition" &&
           l_ite->first != "FalseNextCondition"){
            l_CondObj.insert(std::make_pair(l_ite->first,l_ite->second));
        }
    }

    picojson::value l_CondValue(l_CondObj);
    l_ConditionBase->setJsonValue(l_CondValue);

    picojson::value l_TrueObj = a_Value.get<picojson::object>()["TrueNextCondition"];
    if(l_TrueObj.is<picojson::null>() == false){
        picojson::value l_TrueCond(l_TrueObj);
        ConditionBase* l_TrueCondition;
        createCondition(l_TrueCond, &l_TrueCondition, (a_Counter + 1));
        l_ConditionBase->setNextTrueCondition(l_TrueCondition);
    }
    picojson::value l_FalseObj = a_Value.get<picojson::object>()["FalseNextCondition"];
    if(l_FalseObj.is<picojson::null>() == false){
        picojson::value l_FalseCond(l_FalseObj);
        ConditionBase* l_FalseCondition;
        createCondition(l_FalseCond, &l_FalseCondition, (a_Counter + 1));
        l_ConditionBase->setNextFalseCondition(l_FalseCondition);
    }

    /*** アクションの生成をここに。 ***/
    ActionFactory* l_ActionFactory = ActionFactory::getInstance();
    int l_ActionType;
    ActionBase* l_Action;
    picojson::value l_TrueAction = a_Value.get<picojson::object>()["TrueAction"];
    picojson::array l_jsonarray;
    if(l_TrueAction.is<picojson::null>() == false){
        l_jsonarray = l_TrueAction.get<picojson::array>();
        for(int l_count = 0; l_count < l_jsonarray.size(); l_count++){
            l_ActionType = (int)l_jsonarray[l_count].get<picojson::object>()["ActionType"].get<double>();
            l_Action = l_ActionFactory->getAction(l_ActionType);
            picojson::value l_TrueActionValue(l_jsonarray[l_count]);
            l_Action->setJsonValue(l_TrueActionValue);
            l_ConditionBase->setTrueAction(l_Action);
        }
    }
    picojson::value l_FalseAction = a_Value.get<picojson::object>()["FalseAction"];
    if(l_FalseAction.is<picojson::null>() == false){
        l_jsonarray = l_FalseAction.get<picojson::array>();
        for(int l_count = 0; l_count < l_jsonarray.size(); l_count++){
            l_ActionType = (int)l_jsonarray[l_count].get<picojson::object>()["ActionType"].get<double>();;
            l_Action = l_ActionFactory->getAction(l_ActionType);
            picojson::value l_FalseActionValue(l_jsonarray[l_count]);
            l_Action->setJsonValue(l_FalseActionValue);
            l_ConditionBase->setFalseAction(l_Action);
        }
    }

    l_ConditionBase->setConditionID(a_Counter);
    *a_Condition = l_ConditionBase;

    return ServicePlanFactory_OK;
}
