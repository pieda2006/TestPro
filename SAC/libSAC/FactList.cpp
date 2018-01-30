#include <FactList.h>
 
FactList::FactList() {
    Config* l_Config = Config::getInstance();
    std::string* l_PramName = new std::string("MaxFactNum");
    l_Config->getSgIntValue(l_PramName, &m_MaxFactNum);
    delete l_PramName;
    l_PramName = new std::string("MaxFactTypeNum");
    l_Config->getSgIntValue(l_PramName, &m_MaxFactTypeNum);
    delete l_PramName;
    m_CangeKind = new int[m_MaxFactTypeNum];
    FactIdCounter = 0;
    FactTypeCounter = 0; 
    initializeCangeKind();
}

int FactList::setFact(FactBase* a_InputFact) {
    std::string* l_FactMessageName = NULL;
    a_InputFact->getMessageName(&l_FactMessageName);

    int l_MessageCount;
    l_MessageCount = m_FactTypeName.count(*l_FactMessageName);
    if(l_MessageCount == 1){
        std::map<std::string,int>::iterator l_iterator;
        l_iterator = m_FactTypeName.find(*l_FactMessageName);
        a_InputFact->setFactType(l_iterator->second);
        a_InputFact->setFactID(FactIdCounter);
        FactIdCounter++;
    } else {
        m_FactTypeName.insert(std::make_pair(*l_FactMessageName, FactTypeCounter));
        a_InputFact->setFactType(FactTypeCounter);
        FactTypeCounter++;
        a_InputFact->setFactID(FactIdCounter);
        FactIdCounter++;
    }

    m_FactList.insert(std::make_pair(a_InputFact->getFactType(), a_InputFact));
    m_CangeKind[a_InputFact->getFactType()] = FactList_UPDATE;

    if(l_FactMessageName != NULL){
        delete l_FactMessageName;
    }

    return FactList_OK;
}

int FactList::getFact(std::string* a_FactTypeName, std::multimap<int, FactBase*>::iterator* a_Fact) {
    int l_MessageCount;
    int l_FactCounter;
    l_MessageCount = m_FactTypeName.count(*a_FactTypeName);


    if(l_MessageCount == 1){
        std::map<std::string,int>::iterator l_iterator;
        l_iterator = m_FactTypeName.find(*a_FactTypeName);

        l_FactCounter = m_FactList.count(l_iterator->second);
        if(l_FactCounter == 1){
            *a_Fact = m_FactList.find(l_iterator->second);
            return l_FactCounter;
        } else {
            return 0;
        }
    } else {
        return 0;
    }
}

int FactList::judgeChange(std::string* a_FactTypeName) {
    int l_MessageCount;

    l_MessageCount = m_FactTypeName.count(*a_FactTypeName);
    if(l_MessageCount == 1){
        std::map<std::string,int>::iterator l_iterator;
        l_iterator = m_FactTypeName.find(*a_FactTypeName);
        return m_CangeKind[l_iterator->second];
    }
	return FactList_NO_UPDATE;
}

int FactList::delFact(std::string* a_FactTypeName) {
    int l_MessageCount;
    l_MessageCount = m_FactTypeName.count(*a_FactTypeName);
    if(l_MessageCount == 1){
        std::map<std::string,int>::iterator l_iterator;
        l_iterator = m_FactTypeName.find(*a_FactTypeName);
        m_FactList.erase(l_iterator->second);
        m_FactTypeName.erase(*a_FactTypeName);
        return FactList_OK;
    } else {
        return FactList_OK;
    }
}

int FactList::initializeCangeKind(){
    for(int l_Counter = 0; l_Counter < m_MaxFactTypeNum; l_Counter++){
        m_CangeKind[l_Counter] = FactList_NO_UPDATE;
    }
}

FactList::~FactList(){
    m_FactTypeName.clear();

    std::multimap<int, FactBase*>::iterator l_ite = m_FactList.begin();
    std::multimap<int, FactBase*>::iterator l_end = m_FactList.end();
    for(;l_ite != l_end; ++l_ite){
        if(l_ite->second != NULL){
            delete l_ite->second;
        }
    }
    m_FactList.clear();

    delete[] m_CangeKind;
}
