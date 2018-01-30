#include <ActionFactory.h>$

ActionFactory* ActionFactory::m_ActionFactory = NULL;

ActionFactory::ActionFactory(){
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("MaxActionNum");
    int l_PramValue;
    l_Config->getSgIntValue(l_ParamName, &l_PramValue);
    delete l_ParamName;
    m_Action = new ActionBase*[l_PramValue];
}

ActionFactory* ActionFactory::getInstance(){
    if(m_ActionFactory == NULL){
        m_ActionFactory = new ActionFactory();
    }
    return m_ActionFactory;
}

int ActionFactory::CreateAction(){
    int l_Ret = Condig_OK;
    int l_MakeRet;
    Config* l_Config = Config::getInstance();
    std::string* l_ParamName = new std::string("ActionFileName");
    std::string* l_ParamValue;
    ActionBase* l_Action;
    for(int l_Count = 0; l_Ret == Condig_OK; l_Count++){
        l_Ret = l_Config->getSgStringArray(l_ParamName, &l_ParamValue, l_Count);
        if(l_Ret == Condig_OK){
            l_MakeRet = makeAction(l_ParamValue, &l_Action);
            m_Action[l_Action->getActionType()] = l_Action;
        }
    }
    delete l_ParamName;
    return l_Ret;
}

int ActionFactory::makeAction(std::string* a_fileName, ActionBase** a_Action){
    int l_Ret;
    std::stringstream ss;
    std::ifstream f;
    std::string* l_path = new std::string("");
    l_path->append(*a_fileName);
    f.open(l_path->c_str(), std::ios::binary);
    delete l_path;
    ss << f.rdbuf();
    std::string str;
    str = ss.str();
    f.close();
    picojson::value l_jsonValue;
    picojson::parse(l_jsonValue, str);

    int l_ActionType = (int)l_jsonValue.get<picojson::object>()["ActionType"].get<double>();
    ActionBase* l_Action = new ActionBase();
    l_Action->setActionType(l_ActionType);
    picojson::value l_OperationValue;
    l_OperationValue = l_jsonValue.get<picojson::object>()["Action"];
    ExecuteBase* l_Execute;
    l_Ret = makeOperation(l_OperationValue, &l_Execute);
    l_Action->setExecuteObj(l_Execute);
    *a_Action = l_Action;
    return l_Ret;
}

int ActionFactory::makeOperation(picojson::value a_OperationValue, ExecuteBase** a_ExecuteBase){
    int l_OperationType = (int)a_OperationValue.get<picojson::object>()["OperationType"].get<double>();

    /*** OperationTypで生成するEvaluationを分けるのは将来的には派生クラスで実装する ***/
    picojson::array l_array;

    switch (l_OperationType) {
    case 1:
    {
        SetProtoBufAction* l_SetProtoBufAction = new SetProtoBufAction();
        l_SetProtoBufAction->setOperationType(l_OperationType);
        picojson::value l_MessageName = a_OperationValue.get<picojson::object>()["MessageName"];
        if(!l_MessageName.is<picojson::null>()){
            std::string* l_MessageString = new std::string(l_MessageName.get<std::string>());
            l_SetProtoBufAction->setMassageName(l_MessageString);
        }
        picojson::array l_ParamArray = a_OperationValue.get<picojson::object>()["ParamName"].get<picojson::array>();
        l_SetProtoBufAction->setParamNum(l_ParamArray.size());
        std::string** l_Param = new std::string*[l_ParamArray.size()];
        for(int l_count = 0; l_count < l_ParamArray.size(); l_count++){
            l_Param[l_count] = new std::string(l_ParamArray[l_count].get<std::string>());
        }
        l_SetProtoBufAction->setParamName(l_Param);
        l_ParamArray = a_OperationValue.get<picojson::object>()["ParamValue"].get<picojson::array>();
        l_Param = new std::string*[l_ParamArray.size()];
        for(int l_count = 0; l_count < l_ParamArray.size(); l_count++){
            l_Param[l_count] = new std::string(l_ParamArray[l_count].get<std::string>());
        }
        l_SetProtoBufAction->setParamValue(l_Param);

        *a_ExecuteBase = l_SetProtoBufAction;

        break;
    }
    case 2:
    {
        SetJsonAction* l_SetJsonAction = new SetJsonAction();
        l_SetJsonAction->setOperationType(l_OperationType);
        picojson::value l_MessageName = a_OperationValue.get<picojson::object>()["MessageName"];
        if(!l_MessageName.is<picojson::null>()){
            std::string* l_MessageString = new std::string(l_MessageName.get<std::string>());
            l_SetJsonAction->setMassageName(l_MessageString);
        }
        picojson::array l_ParamArray = a_OperationValue.get<picojson::object>()["ParamName"].get<picojson::array>();
        l_SetJsonAction->setParamNum(l_ParamArray.size());
        std::string** l_Param = new std::string*[l_ParamArray.size()];
        for(int l_count = 0; l_count < l_ParamArray.size(); l_count++){
            l_Param[l_count] = new std::string(l_ParamArray[l_count].get<std::string>());
        }
        l_SetJsonAction->setParamName(l_Param);
        l_ParamArray = a_OperationValue.get<picojson::object>()["ParamValue"].get<picojson::array>();
        l_Param = new std::string*[l_ParamArray.size()];
        for(int l_count = 0; l_count < l_ParamArray.size(); l_count++){
            l_Param[l_count] = new std::string(l_ParamArray[l_count].get<std::string>());
        }
        l_SetJsonAction->setParamValue(l_Param);

        l_ParamArray = a_OperationValue.get<picojson::object>()["ParamType"].get<picojson::array>();
        int* l_ParamType = new int[l_ParamArray.size()];
        for(int l_count = 0; l_count < l_ParamArray.size(); l_count++){
            l_ParamType[l_count] = (int)l_ParamArray[l_count].get<double>();
        }
        l_SetJsonAction->setParamType(l_ParamType);

        *a_ExecuteBase = l_SetJsonAction;

        break;
    }
    default:
    {
        break;
    }
    }

    return ActionFactory_OK; 
}

ActionBase* ActionFactory::getAction(int a_ActionType){
    ActionBase* l_ActionBase;
    switch (a_ActionType) {
    case 1:
        l_ActionBase = new ActionBase(m_Action[a_ActionType]);
        break;
    default:
        break;
    }
    return l_ActionBase;
}


ActionFactory::~ActionFactory(){
   delete[] m_Action;
}
