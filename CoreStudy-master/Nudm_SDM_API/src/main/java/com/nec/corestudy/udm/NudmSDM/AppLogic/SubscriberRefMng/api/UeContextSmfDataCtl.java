package com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.nec.corestudy.udm.NudmSDM.common.api.UeContextInSmfData.UeContextInSmfDataAccess;
import com.nec.corestudy.udm.NudmSDM.common.model.UeContextInSmfDataDB;

import com.nec.corestudy.udm.NudmSDM.model.UeContextInSmfData;
import com.nec.corestudy.udm.NudmSDM.model.PduSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class UeContextSmfDataCtl{

    private static final Logger log = LoggerFactory.getLogger(UeContextSmfDataCtl.class);

    @Autowired
    private UeContextInSmfDataAccess UeConSmfDataAccess;

    // Nudm_SDM
//    private UeContextInSmfData retUeConSmfData = null;

    // method
    public UeContextInSmfData getData(String InputSupi){
        log.debug( "getData is Called" );
        log.debug( "InputSupi : " + InputSupi );

        UeContextInSmfData retUeConSmfData = null;

        retUeConSmfData = new UeContextInSmfData();

        // getData API
        UeContextInSmfDataDB UeConSmfData = UeConSmfDataAccess.getData( InputSupi );

        log.debug("getData : " + UeConSmfData.toString() );

        // DB UeConSmfData -> ret UeConSmfData
        // pduSessions

        for(int i = 0; i < UeConSmfData.getPduSessions().size() ; i++ )
        {

            retUeConSmfData.addPduSessionsItem(new PduSession() );

            //   pduSessionId
            retUeConSmfData.getPduSessions().get(i).setPduSessionId( UeConSmfData.getPduSessions().get(i).getPduSessionId() );

            //   dnn
            retUeConSmfData.getPduSessions().get(i).setDnn( UeConSmfData.getPduSessions().get(i).getDnn() );

            //   smfId
            retUeConSmfData.getPduSessions().get(i).setSmfId( UeConSmfData.getPduSessions().get(i).getSmfId() );

            //   smfAddress
            retUeConSmfData.getPduSessions().get(i).setSmfAddress( UeConSmfData.getPduSessions().get(i).getSmfAddress() );

        }

        log.debug("return UeConSmfData : " + retUeConSmfData.toString() );

        return retUeConSmfData;

    }

    public void setData(String InputAmData){
        log.debug("setData is Called");
        log.debug("InputAmData : " + InputAmData);

        // ffs

    }

}


