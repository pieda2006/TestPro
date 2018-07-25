package com.nec.corestudy.udm.NudmUECM.AppLogic.SubscriberRefMng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.nec.corestudy.udm.NudmUECM.common.api.Amf3GppAccessRegistration.Amf3GppAccessRegistrationAccess;
import com.nec.corestudy.udm.NudmUECM.common.model.Amf3GppAccessRegistrationDB;

import com.nec.corestudy.udm.NudmUECM.model.Amf3GppAccessRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class Amf3GppAccessCtl{

    private static final Logger log = LoggerFactory.getLogger(Amf3GppAccessCtl.class);

    @Autowired
    private Amf3GppAccessRegistrationAccess Amf3GppRegAccess;

    String LineSep = System.getProperty("line.separator");

    // Nudm_UECM Format Data
//    private Amf3GppAccessRegistration retAmf3GppRegData;

    // method
    public Amf3GppAccessRegistration getData(String ueId) throws ObjectNotFoundAppException{
        log.debug( "getData is Called" );
        log.debug( "ueId : " + ueId );

        Amf3GppAccessRegistration retAmf3GppRegData = new Amf3GppAccessRegistration();

        Amf3GppAccessRegistrationDB Amf3GppRegDataDB = Amf3GppRegAccess.getData( ueId );
        if(null == Amf3GppRegDataDB){
                throw new ObjectNotFoundAppException( 0, "user not found" );
            }
        log.debug( "Amf3GppRegDataDB : " + LineSep + Amf3GppRegDataDB );

        // amfId
        if(null != Amf3GppRegDataDB.getAmfId()){
            retAmf3GppRegData.setAmfId( new String( Amf3GppRegDataDB.getAmfId() ) );
        }

        // supportedFeatures
        if(null != Amf3GppRegDataDB.getSupportedFeatures()){
            retAmf3GppRegData.setSupportedFeatures( new  String(Amf3GppRegDataDB.getSupportedFeatures() ) );
        }

        // purgeFlag
        if(null != Amf3GppRegDataDB.isPurgeFlag()){
            retAmf3GppRegData.setPurgeFlag( new Boolean( Amf3GppRegDataDB.isPurgeFlag() ) );
        }

        // pei
        if(null != Amf3GppRegDataDB.getPei()){
            retAmf3GppRegData.setPei( new String(Amf3GppRegDataDB.getPei() ) );
        }

        // imsVoPS
        if(null != Amf3GppRegDataDB.getImsVoPS()){
            retAmf3GppRegData.setImsVoPS( retAmf3GppRegData.getImsVoPS().fromValue(Amf3GppRegDataDB.getImsVoPS().toString() ) );
        }

        // deregCallbackUri
        if(null != Amf3GppRegDataDB.getDeregCallbackUri()){
            retAmf3GppRegData.setDeregCallbackUri( new  String(Amf3GppRegDataDB.getDeregCallbackUri() ) );
        }
        log.debug("retAmf3GppRegData" + LineSep + retAmf3GppRegData.toString() );

        return retAmf3GppRegData;

    }

    public void setData(String ueId, Amf3GppAccessRegistration InputAmf3GppRegData){
        log.debug("setData is Called");
        log.debug("ueId : " + ueId );
        log.debug("InputAmf3GppRegData : " + LineSep + InputAmf3GppRegData);

        Amf3GppAccessRegistrationDB Amf3GppRegDataDB = new Amf3GppAccessRegistrationDB();

        // amfId
        if(null != InputAmf3GppRegData.getAmfId()){
            Amf3GppRegDataDB.setAmfId( new String( InputAmf3GppRegData.getAmfId() ) );
        }

        // supportedFeatures
        if(null != InputAmf3GppRegData.getSupportedFeatures()){
            Amf3GppRegDataDB.setSupportedFeatures( new  String(InputAmf3GppRegData.getSupportedFeatures() ) );
        }

        // purgeFlag
        if(null != InputAmf3GppRegData.isPurgeFlag()){
            Amf3GppRegDataDB.setPurgeFlag( new Boolean(InputAmf3GppRegData.isPurgeFlag() ) );
        }

        // pei
        if(null != InputAmf3GppRegData.getPei()){
            Amf3GppRegDataDB.setPei( new  String(InputAmf3GppRegData.getPei() ) );
        }

        // imsVoPS
        if(null != InputAmf3GppRegData.getImsVoPS()){
            Amf3GppRegDataDB.setImsVoPS( Amf3GppRegDataDB.getImsVoPS().fromValue(InputAmf3GppRegData.getImsVoPS().toString() ) );
        }
        // deregCallbackUri
        if(null != InputAmf3GppRegData.getDeregCallbackUri()){
            Amf3GppRegDataDB.setDeregCallbackUri( new  String(InputAmf3GppRegData.getDeregCallbackUri() ) );
        }
        log.debug("Amf3GppRegDataDB" + LineSep + Amf3GppRegDataDB.toString() );

        // Insert DB (void)
        Amf3GppRegAccess.setData(ueId, Amf3GppRegDataDB);

    }

}


