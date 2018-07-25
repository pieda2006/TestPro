package com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface DataCtl{

    ObjectMapper mapper = new ObjectMapper();

    String LineSep = System.getProperty("line.separator");

    // method
    public String getData(String InputKey) throws JsonProcessingException;
    public void   setData(String InputData);

}


