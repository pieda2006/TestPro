#ident  "@(#)makefile 1.0(12/09/04)"

#
###############################################################################
# makefile for libCOM_DiaDBIF
#
# create : Yuichi.Dejima
###############################################################################
#
# Source and Object path
#

SRC_PATH=$(MASTER_SRC)/SAC/libSAC
OBJ_PATH=$(OBJECT)
INC_PATH=$(MASTER_SRC)/SAC/include -I../../../../OSSlib/protobuf/include/

LOG_LV_FLG=-DDBG_SYS -DDBG_TAT
DFLAGS=-DCOM_DIA -DPR_OPF -DDBIF_HSS $(LOG_LV_FLG) -g -rdynamic

CFLAGS=$(STD_CFLAGS) $(PICFLAG) $(DFLAGS) 

#
# object files
#
OBJ_FILE=$(OBJECT)/ActionBase.o \
	$(OBJECT)/ActionFactory.o \
	$(OBJECT)/ActionInfo.o \
	$(OBJECT)/Agenda.o \
	$(OBJECT)/ConditionBase.o \
	$(OBJECT)/ConditionFactory.o \
	$(OBJECT)/ConditionResult.o \
	$(OBJECT)/Config.o \
	$(OBJECT)/DecisdeActionAnsJson.o \
	$(OBJECT)/DecisdeActionAnsProtobuf.o \
	$(OBJECT)/DecisdeActionAnswer.o \
	$(OBJECT)/DecisdeActionReqJson.o \
	$(OBJECT)/DecisdeActionReqProtobuf.o \
	$(OBJECT)/DecisdeActionRequest.o \
	$(OBJECT)/EvaluateBase.o \
	$(OBJECT)/EvaluateElement.o \
	$(OBJECT)/EvaluateEquals.o \
	$(OBJECT)/EvaluateFact.o \
	$(OBJECT)/EvaluateValue.o \
	$(OBJECT)/ExecuteBase.o \
	$(OBJECT)/ExecuteEventBase.o \
	$(OBJECT)/FactBase.o \
	$(OBJECT)/FactFactory.o \
	$(OBJECT)/FactJson.o \
	$(OBJECT)/FactList.o \
	$(OBJECT)/FactProtobuf.o \
	$(OBJECT)/MutexRwLock.o \
	$(OBJECT)/ResultInfo.o \
	$(OBJECT)/ServiceActionControl.o \
	$(OBJECT)/ServicePlanFactory.o \
	$(OBJECT)/SetJsonAction.o \
	$(OBJECT)/SetProtoBufAction.o \
	$(OBJECT)/ActionInfo.pb.o \
        $(OBJECT)/PolicyCounter.pb.o \
        $(OBJECT)/CurrentDate.pb.o \
	$(OBJECT)/EvaluateCompare.o \
	$(OBJECT)/EvaluateOr.o \
	$(OBJECT)/EvaluateAnd.o \
        $(OBJECT)/SubscrInfo.pb.o

#
# targets
#
TARGET=$(MASTER_LIB)/libSAC.a

ALL:	$(TARGET)

$(TARGET) :	$(OBJ_FILE)
			$(AR) -rv $@ $(OBJ_FILE)


#
# Compile
#


## ActionBase.o ##

$(OBJ_PATH)/ActionBase.o:  $(SRC_PATH)/ActionBase.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ActionBase.o $(SRC_PATH)/ActionBase.cpp

## ActionFactory.o ##

$(OBJ_PATH)/ActionFactory.o:  $(SRC_PATH)/ActionFactory.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ActionFactory.o $(SRC_PATH)/ActionFactory.cpp

## ActionInfo.o ##

$(OBJ_PATH)/ActionInfo.o:  $(SRC_PATH)/ActionInfo.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ActionInfo.o $(SRC_PATH)/ActionInfo.cpp

## Agenda.o ##

$(OBJ_PATH)/Agenda.o:  $(SRC_PATH)/Agenda.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/Agenda.o $(SRC_PATH)/Agenda.cpp

## ConditionBase.o ##

$(OBJ_PATH)/ConditionBase.o:  $(SRC_PATH)/ConditionBase.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ConditionBase.o $(SRC_PATH)/ConditionBase.cpp

## ConditionFactory.o ##

$(OBJ_PATH)/ConditionFactory.o:  $(SRC_PATH)/ConditionFactory.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ConditionFactory.o $(SRC_PATH)/ConditionFactory.cpp

## ConditionResult.o ##

$(OBJ_PATH)/ConditionResult.o:  $(SRC_PATH)/ConditionResult.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ConditionResult.o $(SRC_PATH)/ConditionResult.cpp

## Config.o ##

$(OBJ_PATH)/Config.o:  $(SRC_PATH)/Config.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/Config.o $(SRC_PATH)/Config.cpp

## DecisdeActionAnsJson.o ##

$(OBJ_PATH)/DecisdeActionAnsJson.o:  $(SRC_PATH)/DecisdeActionAnsJson.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/DecisdeActionAnsJson.o $(SRC_PATH)/DecisdeActionAnsJson.cpp

## DecisdeActionAnsProtobuf.o ##

$(OBJ_PATH)/DecisdeActionAnsProtobuf.o:  $(SRC_PATH)/DecisdeActionAnsProtobuf.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/DecisdeActionAnsProtobuf.o $(SRC_PATH)/DecisdeActionAnsProtobuf.cpp

## DecisdeActionAnswer.o ##

$(OBJ_PATH)/DecisdeActionAnswer.o:  $(SRC_PATH)/DecisdeActionAnswer.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/DecisdeActionAnswer.o $(SRC_PATH)/DecisdeActionAnswer.cpp

## DecisdeActionReqJson.o ##

$(OBJ_PATH)/DecisdeActionReqJson.o:  $(SRC_PATH)/DecisdeActionReqJson.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/DecisdeActionReqJson.o $(SRC_PATH)/DecisdeActionReqJson.cpp

## DecisdeActionReqProtobuf.o ##

$(OBJ_PATH)/DecisdeActionReqProtobuf.o:  $(SRC_PATH)/DecisdeActionReqProtobuf.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/DecisdeActionReqProtobuf.o $(SRC_PATH)/DecisdeActionReqProtobuf.cpp

## DecisdeActionRequest.o ##

$(OBJ_PATH)/DecisdeActionRequest.o:  $(SRC_PATH)/DecisdeActionRequest.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/DecisdeActionRequest.o $(SRC_PATH)/DecisdeActionRequest.cpp

## EvaluateBase.o ##

$(OBJ_PATH)/EvaluateBase.o:  $(SRC_PATH)/EvaluateBase.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateBase.o $(SRC_PATH)/EvaluateBase.cpp

## EvaluateElement.o ##

$(OBJ_PATH)/EvaluateElement.o:  $(SRC_PATH)/EvaluateElement.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateElement.o $(SRC_PATH)/EvaluateElement.cpp

## EvaluateEquals.o ##

$(OBJ_PATH)/EvaluateEquals.o:  $(SRC_PATH)/EvaluateEquals.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateEquals.o $(SRC_PATH)/EvaluateEquals.cpp

## EvaluateFact.o ##

$(OBJ_PATH)/EvaluateFact.o:  $(SRC_PATH)/EvaluateFact.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateFact.o $(SRC_PATH)/EvaluateFact.cpp

## EvaluateValue.o ##

$(OBJ_PATH)/EvaluateValue.o:  $(SRC_PATH)/EvaluateValue.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateValue.o $(SRC_PATH)/EvaluateValue.cpp

## ExecuteBase.o ##

$(OBJ_PATH)/ExecuteBase.o:  $(SRC_PATH)/ExecuteBase.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ExecuteBase.o $(SRC_PATH)/ExecuteBase.cpp

## ExecuteEventBase.o ##

$(OBJ_PATH)/ExecuteEventBase.o:  $(SRC_PATH)/ExecuteEventBase.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ExecuteEventBase.o $(SRC_PATH)/ExecuteEventBase.cpp

## FactBase.o ##

$(OBJ_PATH)/FactBase.o:  $(SRC_PATH)/FactBase.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/FactBase.o $(SRC_PATH)/FactBase.cpp

## FactFactory.o ##

$(OBJ_PATH)/FactFactory.o:  $(SRC_PATH)/FactFactory.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/FactFactory.o $(SRC_PATH)/FactFactory.cpp

## FactJson.o ##

$(OBJ_PATH)/FactJson.o:  $(SRC_PATH)/FactJson.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/FactJson.o $(SRC_PATH)/FactJson.cpp

## FactList.o ##

$(OBJ_PATH)/FactList.o:  $(SRC_PATH)/FactList.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/FactList.o $(SRC_PATH)/FactList.cpp

## FactProtobuf.o ##

$(OBJ_PATH)/FactProtobuf.o:  $(SRC_PATH)/FactProtobuf.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/FactProtobuf.o $(SRC_PATH)/FactProtobuf.cpp

## MutexRwLock.o ##

$(OBJ_PATH)/MutexRwLock.o:  $(SRC_PATH)/MutexRwLock.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/MutexRwLock.o $(SRC_PATH)/MutexRwLock.cpp

## ResultInfo.o ##

$(OBJ_PATH)/ResultInfo.o:  $(SRC_PATH)/ResultInfo.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ResultInfo.o $(SRC_PATH)/ResultInfo.cpp

## ServiceActionControl.o ##

$(OBJ_PATH)/ServiceActionControl.o:  $(SRC_PATH)/ServiceActionControl.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ServiceActionControl.o $(SRC_PATH)/ServiceActionControl.cpp

## ServicePlanFactory.o ##

$(OBJ_PATH)/ServicePlanFactory.o:  $(SRC_PATH)/ServicePlanFactory.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ServicePlanFactory.o $(SRC_PATH)/ServicePlanFactory.cpp

## SetJsonAction.o ##

$(OBJ_PATH)/SetJsonAction.o:  $(SRC_PATH)/SetJsonAction.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/SetJsonAction.o $(SRC_PATH)/SetJsonAction.cpp

## SetProtoBufAction.o ##

$(OBJ_PATH)/SetProtoBufAction.o:  $(SRC_PATH)/SetProtoBufAction.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/SetProtoBufAction.o $(SRC_PATH)/SetProtoBufAction.cpp

## ActionInfo.pb.o ##

$(OBJ_PATH)/ActionInfo.pb.o:  $(SRC_PATH)/ActionInfo.pb.cc
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/ActionInfo.pb.o $(SRC_PATH)/ActionInfo.pb.cc


## PolicyCounter.pb.o ##

$(OBJ_PATH)/PolicyCounter.pb.o:  $(SRC_PATH)/PolicyCounter.pb.cc
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/PolicyCounter.pb.o $(SRC_PATH)/PolicyCounter.pb.cc

## CurrentDate.pb.o ##

$(OBJ_PATH)/CurrentDate.pb.o:  $(SRC_PATH)/CurrentDate.pb.cc
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/CurrentDate.pb.o $(SRC_PATH)/CurrentDate.pb.cc

## SubscrInfo.pb.o ##

$(OBJ_PATH)/SubscrInfo.pb.o:  $(SRC_PATH)/SubscrInfo.pb.cc
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/SubscrInfo.pb.o $(SRC_PATH)/SubscrInfo.pb.cc

## EvaluateAnd.o ##

$(OBJ_PATH)/EvaluateAnd.o:  $(SRC_PATH)/EvaluateAnd.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateAnd.o $(SRC_PATH)/EvaluateAnd.cpp

## EvaluateCompare.o ##

$(OBJ_PATH)/EvaluateCompare.o:  $(SRC_PATH)/EvaluateCompare.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateCompare.o $(SRC_PATH)/EvaluateCompare.cpp

## EvaluateOr.o ##

$(OBJ_PATH)/EvaluateOr.o:  $(SRC_PATH)/EvaluateOr.cpp
	$(CC_ISPF) $(CFLAGS) -c -I$(INC_PATH) -I$(MASTER_INC) \
		-o $(OBJ_PATH)/EvaluateOr.o $(SRC_PATH)/EvaluateOr.cpp

#
# Remove Object files
#

clean :
	-rm -f $(OBJ_PATH)/*.o *.cfront


