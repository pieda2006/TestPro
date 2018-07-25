package com.nec.corestudy.smf.Service.SMCont_Mng;

import com.nec.corestudy.smf.Service.Session_Mng.SMContext_Internal;
import com.nec.corestudy.smf.Repository.Redis_API_client.RedisAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import java.io.File;
//import java.util.*;
import java.io.IOException;


public class SMContextManager {

  private String keytag = "IntSM:";
  private RedisAPI redis_api = new RedisAPI();

  public void InternalSMContext_Set(SMContext_Internal context_data) {

    // Key
    String key = keytag + context_data.getSupi();

    // Value
    // Java Obj -> JSON String
    String json = null;
    try {
      ObjectMapper mapper = new ObjectMapper();
      json = mapper.writeValueAsString(context_data);
    } catch (JsonProcessingException je) {
      System.err.println("Exception when calling jackson#mapper.writeValueAsString()");
      je.printStackTrace();
    }

    redis_api.Set(key,json);

    return;
  }

  public SMContext_Internal InternalSMContext_Get(String supi) {

    // Key
    String key = keytag + supi;

    String value = redis_api.Get(key);
    SMContext_Internal smcont_int = null;

    if(null != value){
      // Value
      // JSON String -> Java Obj
      try {
        ObjectMapper mapper = new ObjectMapper();
        smcont_int = mapper.readValue(value, SMContext_Internal.class);
      } catch (JsonMappingException je) {
        System.err.println("Exception when calling jackson#mapper.readValue()");
        je.printStackTrace();
      } catch (IOException ie) {
        System.err.println("IOException when calling jackson#mapper.readValue()");
        ie.printStackTrace();
      }
    }
    else{
      System.err.println("redis_api.Get NG key:" + key);
    }

    return smcont_int;
  }

  public void InternalSMContext_Del(String supi) {

    // Key
    String key = keytag + supi;

    redis_api.Del(key);

    return;
  }

}

