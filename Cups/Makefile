CP  = /bin/cp -pr
SRC_PATH=$(MASTER_SRC)/CUPS/src
OBJ_PATH=$(MASTER_SRC)/CUPS/obj
LIB_PATH=$(MASTER_SRC)/CUPS/lib
HEAD_PATH=$(MASTER_SRC)/CUPS/src
STDCPP11 = -std=c++11
PROTOC = protoc
GRPC_CPP_PLUGIN = grpc_cpp_plugin
GRPC_CPP_PLUGIN_PATH = $(ORG_MASTER)/OSS/grpc/bin/grpc_cpp_plugin
SPGW_INC_PATH=$(PRJ)/APL/head
MW_INC_PATH=$(PRJ)/MAST/head
OSS_INC_PATH=$(PRJ)/OSS/head
GRPC_INC_PATH=$(PRJ)/C++/A/GRPC/src

CFLAGS=$(STD_CFLAGS) $(PICFLAG) $(DFLAGS)

OBJ_FILE=$(OBJ_PATH)/cups_LibWrapper.o \
	$(OBJ_PATH)/RedisAccess.o \
	$(OBJ_PATH)/ProcMain.o \
	$(OBJ_PATH)/AssociationMng.o \
	$(OBJ_PATH)/TransactionMng.o \
	$(OBJ_PATH)/PFCPTrf.o \
	$(OBJ_PATH)/TransactionFactory.o


TARGET=$(LIB_PATH)/libcups.a

all:lib

lib:$(TARGET)

$(TARGET) : $(OBJ_FILE)
		$(AR) -rv $@ $(OBJ_FILE)
		$(CP) $(TARGET) $(MASTER_LIB)/.

$(OBJ_PATH)/cups_LibWrapper.o:  $(SRC_PATH)/cups_LibWrapper.cc
	$(CC_ISPF) $(STDCPP11) $(CFLAGS) -c -I$(MASTER_INC) -I$(SPGW_INC_PATH) \
	-o $@ $<

$(OBJ_PATH)/RedisAccess.o:  $(SRC_PATH)/RedisAccess.cc
	$(CC_ISPF) $(STDCPP11) $(CFLAGS) -c -I$(MASTER_INC) -I$(MW_INC_PATH) -I$(OSS_INC_PATH) \
	-o $@ $<

$(OBJ_PATH)/ProcMain.o:  $(SRC_PATH)/ProcMain.cc
	$(CC_ISPF) $(STDCPP11) $(CFLAGS) -c -I$(MASTER_INC) -I$(MW_INC_PATH) -I$(GRPC_INC_PATH) -I$(SPGW_INC_PATH) \
	-o $@ $<

$(OBJ_PATH)/AssociationMng.o:  $(SRC_PATH)/AssociationMng.cc
	$(CC_ISPF) $(STDCPP11) $(CFLAGS) -c -I$(MASTER_INC) -I$(MW_INC_PATH) -I$(GRPC_INC_PATH) -I$(SPGW_INC_PATH) \
	-o $@ $<

$(OBJ_PATH)/TransactionMng.o:  $(SRC_PATH)/TransactionMng.cc
	$(CC_ISPF) $(STDCPP11) $(CFLAGS) -c -I$(MASTER_INC) -I$(MW_INC_PATH) -I$(GRPC_INC_PATH) -I$(SPGW_INC_PATH) \
	-o $@ $<

$(OBJ_PATH)/PFCPTrf.o:  $(SRC_PATH)/PFCPTrf.cc
	$(CC_ISPF) $(STDCPP11) $(CFLAGS) -c -I$(MASTER_INC) -I$(MW_INC_PATH) -I$(GRPC_INC_PATH) -I$(SPGW_INC_PATH) \
	-o $@ $<

$(OBJ_PATH)/TransactionFactory.o:  $(SRC_PATH)/TransactionFactory.cc
	$(CC_ISPF) $(STDCPP11) $(CFLAGS) -c -I$(MASTER_INC) -I$(MW_INC_PATH) -I$(GRPC_INC_PATH) -I$(SPGW_INC_PATH) \
	-o $@ $<

clean:
	rm -f $(OBJ_PATH)/*.o $(SRC_PATH)/*.pb.cc $(SRC_PATH)/*.pb.h $(TARGET)

