#include <ConditionFactory.h>

ConditionFactory* ConditionFactory::m_ConditionFactory = NULL;

ConditionFactory::ConditionFactory(){
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("MaxConditionNum");
    int l_PramValue;
    l_Config->getSgIntValue(l_ParamName, &l_PramValue);
    m_Condition = new ConditionBase*[l_PramValue];
}

ConditionFactory* ConditionFactory::getInstance(){
    if(m_ConditionFactory == NULL){
        m_ConditionFactory = new ConditionFactory();
    }
    return m_ConditionFactory;
}

int ConditionFactory::CreateCondition(){
    int l_Ret = Condig_OK;
    int l_MakeRet;
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("ConditionFileName");
    std::string* l_ParamValue;
    ConditionBase* l_Condition;
    for(int l_Count = 0; l_Ret == Condig_OK; l_Count++){
        l_Ret = l_Config->getSgStringArray(l_ParamName, &l_ParamValue, l_Count);
        if(l_Ret == Condig_OK){
            l_MakeRet = makeCondition(l_ParamValue, &l_Condition);
            m_Condition[l_Condition->getConditionType()] = l_Condition;
        }
    }
    delete l_ParamName;
    return l_Ret;
}

int ConditionFactory::makeCondition(std::string* a_fileName, ConditionBase** a_Condition){
    int l_Ret;
    std::stringstream ss;
    std::ifstream f;

    std::string* l_path = new std::string("");
    l_path->append(*a_fileName);
    f.open(l_path->c_str(), std::ios::binary);
    ss << f.rdbuf();
    std::string str;
    str = ss.str();
    f.close();
    picojson::value l_jsonValue;
    picojson::parse(l_jsonValue, str);
    int l_ConditionType = (int)l_jsonValue.get<picojson::object>()["ConditionType"].get<double>();
    ConditionBase* l_Condition = new ConditionBase();
    l_Condition->setConditionType(l_ConditionType);
    std::string* l_MessageName = new std::string(l_jsonValue.get<picojson::object>()["MessageName"].get<std::string>().c_str());
    l_Condition->setMessageName(l_MessageName);   
    picojson::value l_OperationValue;
    l_OperationValue = l_jsonValue.get<picojson::object>()["Condition"];
    EvaluateBase* l_Evaluate;
    l_Ret = makeOperation(l_OperationValue, &l_Evaluate);
    l_Condition->setEvaluateObj(l_Evaluate);
    *a_Condition = l_Condition;
    
    delete l_path;

    return l_Ret;
}

int ConditionFactory::makeOperation(picojson::value a_OperationValue, EvaluateBase** a_EvaluateBase){

    int l_OperationType = (int)a_OperationValue.get<picojson::object>()["OperationType"].get<double>();

    /*** OperationTypで生成するEvaluationを分けるのは将来的には派生クラスで実装する ***/
    picojson::array l_array;

    switch (l_OperationType) {
    case 1:
    {
        EvaluateEquals* l_EvaluateEquals = new EvaluateEquals();
        l_EvaluateEquals->setOperationType(l_OperationType);
        l_array = a_OperationValue.get<picojson::object>()["Operation"].get<picojson::array>();
        if(l_array.size() == 2){
            EvaluateBase* l_Evaluate;
            makeOperation(l_array[0],&l_Evaluate);
            l_EvaluateEquals->setEvaluateBase(l_Evaluate);
            makeOperation(l_array[1],&l_Evaluate);
            l_EvaluateEquals->setEvaluateBase(l_Evaluate);
        } else {
            return ConditionFactory_NG;
        }
        *a_EvaluateBase = l_EvaluateEquals;
        break;
    }
    case 2:
    {
        EvaluateElement* l_EvaluateElement = new EvaluateElement();
        l_EvaluateElement->setOperationType(l_OperationType);
        picojson::array l_ParamName = a_OperationValue.get<picojson::object>()["PramName"].get<picojson::array>();
        l_EvaluateElement->setPramName(l_ParamName);
        int l_ParamType = (int)a_OperationValue.get<picojson::object>()["PramType"].get<double>();
        l_EvaluateElement->setPramType(l_ParamType);
        *a_EvaluateBase = l_EvaluateElement;
        break;
    }
    case 3:
    {
        EvaluateFact* l_EvaluateFact = new EvaluateFact();
        l_EvaluateFact->setOperationType(l_OperationType);
        picojson::array l_ParamName = a_OperationValue.get<picojson::object>()["PramName"].get<picojson::array>();
        l_EvaluateFact->setPramName(l_ParamName);
        int l_ParamType = (int)a_OperationValue.get<picojson::object>()["PramType"].get<double>();
        l_EvaluateFact->setPramType(l_ParamType);
        *a_EvaluateBase = l_EvaluateFact;
        break;
    }
    case 4:
    {
        EvaluateCompare* l_EvaluateCompare = new EvaluateCompare();
        l_EvaluateCompare->setOperationType(l_OperationType);
        l_array = a_OperationValue.get<picojson::object>()["Operation"].get<picojson::array>();
        if(l_array.size() == 2){
            EvaluateBase* l_Evaluate;
            makeOperation(l_array[0],&l_Evaluate);
            l_EvaluateCompare->setEvaluateBase(l_Evaluate);
            makeOperation(l_array[1],&l_Evaluate);
            l_EvaluateCompare->setEvaluateBase(l_Evaluate);
        } else {
            return ConditionFactory_NG;
        }
        *a_EvaluateBase = l_EvaluateCompare;
        break;
    }
    case 5:
    {
        EvaluateAnd* l_EvaluateAnd = new EvaluateAnd();
        l_EvaluateAnd->setOperationType(l_OperationType);
        l_array = a_OperationValue.get<picojson::object>()["Operation"].get<picojson::array>();
        if(l_array.size() < 2){
            return ConditionFactory_NG;
        }
        for(int l_count = 0;l_count < l_array.size(); l_count++){
            EvaluateBase* l_Evaluate = NULL;
            makeOperation(l_array[l_count],&l_Evaluate);
            l_EvaluateAnd->setEvaluateBase(l_Evaluate);
        }
        *a_EvaluateBase = l_EvaluateAnd;
        break;
    }
    case 6:
    {
        EvaluateOr* l_EvaluateOr = new EvaluateOr();
        l_EvaluateOr->setOperationType(l_OperationType);
        l_array = a_OperationValue.get<picojson::object>()["Operation"].get<picojson::array>();
        if(l_array.size() < 2){
            return ConditionFactory_NG;
        }
        for(int l_count = 0;l_count < l_array.size(); l_count++){
            EvaluateBase* l_Evaluate = NULL;
            makeOperation(l_array[l_count],&l_Evaluate);
            l_EvaluateOr->setEvaluateBase(l_Evaluate);
        }
        *a_EvaluateBase = l_EvaluateOr;
        break;
    }
    default:
        break;
    }
}

ConditionBase* ConditionFactory::getCondition(int a_ConditionType){
    ConditionBase* l_Condition;
    l_Condition = new ConditionBase(m_Condition[a_ConditionType]);
    return l_Condition;
}


ConditionFactory::~ConditionFactory(){
}
