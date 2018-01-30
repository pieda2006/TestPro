#include <stdio.h>
#include <ConditionFactory.h>
#include <sys/time.h>
#include <Config.h>
#include <ActionFactory.h>
#include <ServicePlanFactory.h>
#include <DecisdeActionReqJson.h>
#include <picojson.h>
#include <ServiceActionControl.h>
#include <PolicyCounter.pb.h>
#include <SubscrInfo.pb.h>
#include <DecisdeActionReqProtobuf.h>
#include <iostream>
#include <fstream>
#include <string>
#include <pthread.h>
#include <stdlib.h>
#include <mcheck.h>
#include <execinfo.h>
#include <fstream>
#include <google/protobuf/message.h>

static void* thread_func(void*);
static bool timeout = false;
static bool skipflag = false;


//void *operator new(std::size_t s);
//void operator delete(void *p);

int main(){

    struct timeval start_timeval, end_timeval, tat_timeval;
    void* ret;

    pthread_t thid[2];

    pthread_create(&thid[0], NULL, thread_func, NULL); 
    //pthread_create(&thid[1], NULL, thread_func, NULL);
    
    pthread_join(thid[0], &ret);
    //pthread_join(thid[1], &ret);

/*
    printf("===== ConfigRead [START]=====\n");
    gettimeofday(&start_timeval, NULL);

    Config* l_Config = Config::getInstance();
    std::string* l_SgPath = new std::string("SAC.sg");
    l_Config->readSg(l_SgPath);

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("ConfigRead : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== ConfigRead [END]=====\n\n");

    printf("===== ConditionCreate [START]=====\n");
    gettimeofday(&start_timeval, NULL);

    ConditionFactory* l_ConditionFactory = ConditionFactory::getInstance();
    l_ConditionFactory->CreateCondition();

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("ConditionCreate : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);    
    printf("===== ConditionCreate [END]=====\n\n");

    printf("===== ActionCreate [START]=====\n");
    gettimeofday(&start_timeval, NULL);
    
    ActionFactory* l_ActionFactory = ActionFactory::getInstance();
    l_ActionFactory->CreateAction();

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("ActionCreate : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== ActionCreate [END]=====\n\n");

    printf("===== ServicePlanCreate [START]=====\n");
    gettimeofday(&start_timeval, NULL);
    
    ServicePlanFactory* l_ServicePlanFactory = ServicePlanFactory::getInstance();
    l_ServicePlanFactory->createServicePlan();
    
    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("ServicePlanCreate : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== ServicePlanCreate [END]=====\n\n");

    printf("===== DecideActionReqCreate [START]=====\n");

    gettimeofday(&start_timeval, NULL);
*/  
/* Json 
    DecisdeActionReqJson* l_DecisdeActionReqJson = DecisdeActionReqJson::getInstance();
*/
/* Protobuf 
    DecisdeActionReqProtobuf* l_DecisdeActionReqProtobuf = DecisdeActionReqProtobuf::getInstance();

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("DecideActionReqCreate : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== DecideActionReqCreate [END]=====\n\n");

    printf("===== FactCreate [START]=====\n");
    gettimeofday(&start_timeval, NULL);
*/
/* Json    
    std::stringstream ss;
    std::ifstream f;
    f.open("Fact.json", std::ios::binary);
    ss << f.rdbuf();
    std::string str;
    str = ss.str();
    f.close(); 
    std::string* l_fact = new std::string(str.c_str());
    l_DecisdeActionReqJson->setFactInfo(l_fact);
*/
/* Protobuf 
    SAC::PolicyCounter* l_PolicyCounter = new SAC::PolicyCounter();
    l_PolicyCounter->set_pid(1);
    l_PolicyCounter->set_pcs(1);
    l_DecisdeActionReqProtobuf->setFactInfo(l_PolicyCounter);
*/
/* Json 
    std::stringstream ss2;
    std::ifstream f2;
    f2.open("SubscribInfo.json", std::ios::binary);
    ss2 << f2.rdbuf();
    std::string str2;
    str2 = ss2.str();
    f.close();
    std::string* l_fact2 = new std::string(str2.c_str());
    l_DecisdeActionReqJson->setFactInfo(l_fact2);  
*/
/* Protobuf 
    SAC::SubscrInfo* l_SubscrInfo = new SAC::SubscrInfo();
    l_SubscrInfo->set_planid(100);
    l_DecisdeActionReqProtobuf->setFactInfo(l_SubscrInfo);


    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("FactCreate : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== FactCreate [END]=====\n\n");

    printf("===== DecideAction [START]=====\n");
    gettimeofday(&start_timeval, NULL);
    
    DecisdeActionAnswer* l_DecisdeActionAnswer;
   
    ServiceActionControl* l_ServiceActionControl = ServiceActionControl::getInstance();
*/
/* Json 
    l_ServiceActionControl->decideServiceAction(l_DecisdeActionReqJson, &l_DecisdeActionAnswer);
*/
/* Protobuf 
    l_ServiceActionControl->decideServiceAction(l_DecisdeActionReqProtobuf, &l_DecisdeActionAnswer);

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
    printf("DecideAction : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== DecideAction [END]=====\n\n");


    printf("===== Result [START]=====\n");
    gettimeofday(&start_timeval, NULL);

    int l_MessageType = l_DecisdeActionAnswer->getMessageType();
    if(l_MessageType == DecisdeActionAnswer_JSON){
        DecisdeActionAnsJson* l_DecisdeActionAnsJson = (DecisdeActionAnsJson*)l_DecisdeActionAnswer;
        std::string* l_Result;
        l_DecisdeActionAnsJson->getActionInfo(&l_Result);
        printf("--- Result ---\n");
        printf("%s\n",l_Result->c_str());
        printf("--- Result ---\n");
    }
    else {
        DecisdeActionAnsProtobuf* l_DecisdeActionAnsProtobuf = (DecisdeActionAnsProtobuf*)l_DecisdeActionAnswer;
        SAC::ActionInfo* l_ActionInfo;
        google::protobuf::Message* l_ActionMessage;
        l_DecisdeActionAnsProtobuf->getActionInfo(&l_ActionMessage);
        l_ActionInfo = (SAC::ActionInfo*)l_ActionMessage;
        printf("--- ActionID = %d ---\n",l_ActionInfo->actionid());
        printf("--- ChargingRule = %s ---\n",l_ActionInfo->chargingrulename().c_str());
    }
    printf("Result : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
    printf("===== Result [END]=====\n\n");
*/

    return 0;

}

void* thread_func(void*){

    struct timeval start_timeval, end_timeval, tat_timeval;

for(int l_count = 0; /*l_count < 2*/ !timeout; l_count++){

//    printf("===== DecideActionReqCreate [START]=====\n");
    gettimeofday(&start_timeval, NULL);

/* Json
 *     DecisdeActionReqJson* l_DecisdeActionReqJson = DecisdeActionReqJson::getInstance();
 *     */
/* Protobuf */
    DecisdeActionReqProtobuf* l_DecisdeActionReqProtobuf = DecisdeActionReqProtobuf::getInstance();

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
//    printf("DecideActionReqCreate : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
//    printf("===== DecideActionReqCreate [END]=====\n\n");

//    printf("===== FactCreate [START]=====\n");
    gettimeofday(&start_timeval, NULL);

    std::stringstream ss;
    std::ifstream f;
    f.open("Fact.json", std::ios::binary);
    ss << f.rdbuf();
    std::string str;
    str = ss.str();
    f.close();
/* Json
   std::string* l_fact = new std::string(str.c_str());
   l_DecisdeActionReqJson->setFactInfo(l_fact);
*/
/* Protobuf */

    SAC::PolicyCounter* l_PolicyCounter = new SAC::PolicyCounter();
    l_PolicyCounter->set_pid(1);
    l_PolicyCounter->set_pcs(1);
    l_DecisdeActionReqProtobuf->setFactInfo(l_PolicyCounter);
    



/* Json
   std::stringstream ss2;
   std::ifstream f2;
   f2.open("SubscribInfo.json", std::ios::binary);
   ss2 << f2.rdbuf();
   std::string str2;
 *                         str2 = ss2.str();
 *                             f.close();
 *                                 std::string* l_fact2 = new std::string(str2.c_str());
 *                                     l_DecisdeActionReqJson->setFactInfo(l_fact2);
 *                                     */
/* Protobuf */
    SAC::SubscrInfo* l_SubscrInfo = new SAC::SubscrInfo();
    l_SubscrInfo->set_planid(10);
    l_DecisdeActionReqProtobuf->setFactInfo(l_SubscrInfo);

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
//    printf("FactCreate : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
//    printf("===== FactCreate [END]=====\n\n");

//    printf("===== DecideAction [START]=====\n");
    gettimeofday(&start_timeval, NULL);
    DecisdeActionAnswer* l_DecisdeActionAnswer;

    ServiceActionControl* l_ServiceActionControl = ServiceActionControl::getInstance();
/* Json
 *     l_ServiceActionControl->decideServiceAction(l_DecisdeActionReqJson, &l_DecisdeActionAnswer);
 *     */
/* Protobuf */

    l_ServiceActionControl->decideServiceAction(l_DecisdeActionReqProtobuf, &l_DecisdeActionAnswer);

    gettimeofday(&end_timeval, NULL);
    tat_timeval.tv_sec = end_timeval.tv_sec - start_timeval.tv_sec;
    tat_timeval.tv_usec = end_timeval.tv_usec - start_timeval.tv_usec;
    if (tat_timeval.tv_usec < 0) {
        tat_timeval.tv_sec -= 1;
        tat_timeval.tv_usec += 1000000;
    }
//    printf("DecideAction : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
//    printf("===== DecideAction [END]=====\n\n");


//    printf("===== Result [START]=====\n");
    gettimeofday(&start_timeval, NULL);

    int l_MessageType = l_DecisdeActionAnswer->getMessageType();
    if(l_MessageType == DecisdeActionAnswer_JSON){
        DecisdeActionAnsJson* l_DecisdeActionAnsJson = (DecisdeActionAnsJson*)l_DecisdeActionAnswer;
        std::string* l_Result;
        l_DecisdeActionAnsJson->getActionInfo(&l_Result);
//        printf("--- Result ---\n");
//        printf("%s\n",l_Result->c_str());
//        printf("--- Result ---\n");
    }
    else {
        DecisdeActionAnsProtobuf* l_DecisdeActionAnsProtobuf = (DecisdeActionAnsProtobuf*)l_DecisdeActionAnswer;
        SAC::ActionInfo* l_ActionInfo;
        google::protobuf::Message* l_ActionMessage;
        l_DecisdeActionAnsProtobuf->getActionInfo(&l_ActionMessage);
        l_ActionInfo = (SAC::ActionInfo*)l_ActionMessage;
//        printf("--- ActionID = %d ---\n",l_ActionInfo->actionid());
//        printf("--- ChargingRule = %s ---\n",l_ActionInfo->chargingrulename().c_str());
    }
//    printf("Result : %ld sec %ld usec \n",tat_timeval.tv_sec,tat_timeval.tv_usec);
//    printf("===== Result [END]=====\n\n");

delete l_SubscrInfo;
delete l_PolicyCounter;

timespec l_timer;
l_timer.tv_sec = 0;
l_timer.tv_nsec = 1000000;

nanosleep(&l_timer,NULL);

}
}

void *operator new(std::size_t s) { 
    void* l_malloc = malloc(s);
    if(!skipflag){
        size_t i;
        void *trace[128];
        char **ss_trace;
        size_t size = backtrace(trace, sizeof(trace) / sizeof(trace[0]));
        ss_trace = backtrace_symbols(trace, size);
        printf("Hunt Address : %p\n",l_malloc);

        for (i = 0; i < size; i++) {
            printf("%s\n",ss_trace[i]);
        }
        free(ss_trace);
    }
    return l_malloc; 
}
void operator delete(void *p) { 
    if(!skipflag){
        size_t i;
        void *trace[128];
        char **ss_trace;
        size_t size = backtrace(trace, sizeof(trace) / sizeof(trace[0]));
        ss_trace = backtrace_symbols(trace, size);
        printf("Free Address : %p\n",p);

        for (i = 0; i < size; i++) {
            printf("%s\n",ss_trace[i]);
        }
        free(ss_trace);
    }
    free(p); 
}

