#include <ServiceActionControl.h>

ServiceActionControl* ServiceActionControl::m_ServiceActionControl = NULL;

int ServiceActionControl::decideServiceAction(DecisdeActionRequest* a_InputMessage, DecisdeActionAnswer** a_OutputMessage) {

    int l_Result = ServiceActionControl_NG;
    struct timeval start_timeval, end_timeval, tat_timeval;

    DecisdeActionAnswer* l_OutPutMessage;
    if(a_InputMessage->getMessageType() == DecisdeActionRequest_JSON){
        l_OutPutMessage = (DecisdeActionAnswer*)DecisdeActionAnsJson::getInstance();
    } 
    else if(a_InputMessage->getMessageType() == DecisdeActionRequest_Protobuf){
        l_OutPutMessage = (DecisdeActionAnswer*)DecisdeActionAnsProtobuf::getInstance();
    }
/*
    printf("===== FactFactory::createFact [START]=====\n");
    gettimeofday(&start_timeval, NULL);
*/
    FactFactory* l_FactFactory = FactFactory::getInstance();
    FactList* l_FactList = NULL;
    l_FactFactory->createFact(a_InputMessage,&l_FactList);

/*
    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("FactFactory::createFact : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== FactFactory::createFact [END]=====\n\n");

    printf("===== getServicePlanCondition [START]=====\n");
    gettimeofday(&start_timeval, NULL);
*/
    ServicePlanFactory* l_ServicePlanFactory = ServicePlanFactory::getInstance();
    ConditionBase* l_Condition = NULL;
    l_Result = l_ServicePlanFactory->getServicePlanCondition(l_FactList, &l_Condition);

    if(l_Result != ServicePlanFactory_OK){
        if(l_FactList != NULL){
            delete l_FactList;
        }
        return ServiceActionControl_NG; 
    }

/*
    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("getServicePlanCondition : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== getServicePlanCondition [END]=====\n\n");

    printf("===== CreateCondition Agenda [START]=====\n");
    gettimeofday(&start_timeval, NULL);
*/
    Agenda* l_Agenda = new Agenda();
    ConditionResult* l_ConditionResult = new ConditionResult();
/*
    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("CreateCondition Agenda : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== CreateCondition Agendan [END]=====\n\n");

    printf("===== evaluateCondition [START]=====\n");
    gettimeofday(&start_timeval, NULL);
*/
    l_Condition->evaluateCondition(l_FactList,l_Agenda,l_ConditionResult);
/*
    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("evaluateCondition : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== evaluateCondition [END]=====\n\n");

    printf("===== executeAction [START]=====\n");
    gettimeofday(&start_timeval, NULL);
*/
    l_Agenda->executeAction(l_OutPutMessage,l_FactList,l_ConditionResult);
/*
    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("executeAction : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== executeAction [END]=====\n\n");
*/
    *a_OutputMessage = l_OutPutMessage;

    if(l_FactList != NULL){
        delete l_FactList;
    }
    if(l_Agenda != NULL){
        delete l_Agenda;
    }
    if(l_ConditionResult != NULL){
        delete l_ConditionResult;
    }

    return ServiceActionControl_OK;
}

ServiceActionControl::ServiceActionControl() {
}

ServiceActionControl* ServiceActionControl::getInstance(){
    if(m_ServiceActionControl == NULL) {
        m_ServiceActionControl = new ServiceActionControl();
    }
    return m_ServiceActionControl;
}
