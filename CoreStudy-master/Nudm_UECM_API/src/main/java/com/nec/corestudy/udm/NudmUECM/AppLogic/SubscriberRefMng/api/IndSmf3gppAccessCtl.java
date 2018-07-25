package com.nec.corestudy.udm.NudmUECM.AppLogic.SubscriberRefMng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.nec.corestudy.udm.NudmUECM.common.api.SmfRegistration.SmfRegistrationAccess;
import com.nec.corestudy.udm.NudmUECM.common.model.SmfRegistrationDB;

import com.nec.corestudy.udm.NudmUECM.model.SmfRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class IndSmf3gppAccessCtl{

    private static final Logger log = LoggerFactory.getLogger(IndSmf3gppAccessCtl.class);

    @Autowired
    private SmfRegistrationAccess SmfRegAccess;

    String LineSep = System.getProperty("line.separator");

    // Nudm_UECM Format Data
//    private SmfRegistration retSmfRegData;

    // method
    public SmfRegistration getData(String ueId, Integer pduSessionId) throws ObjectNotFoundAppException{
        log.debug( "getData is Called" );
        log.debug( "ueId : " + ueId );
        log.debug( "pduSessionId : " + pduSessionId );

        SmfRegistration retSmfRegData = new SmfRegistration();

        SmfRegistrationDB SmfRegDataDB = SmfRegAccess.getData(ueId, pduSessionId);
        if(null == SmfRegDataDB){
            throw new ObjectNotFoundAppException( 0, "user not found" );
        }
        log.debug( "SmfRegDataDB : " + LineSep + SmfRegDataDB );

        // smfId
        if( null != SmfRegDataDB.getSmfId() ){
            retSmfRegData.setSmfId( new String( SmfRegDataDB.getSmfId() ) );
        }

        // supportedFeatures
        if( null != SmfRegDataDB.getSupportedFeatures() ){
            retSmfRegData.setSupportedFeatures( new String( SmfRegDataDB.getSupportedFeatures() ) );
        }

        // PduSessionId
        if( null != SmfRegDataDB.getPduSessionId() ){
            retSmfRegData.setPduSessionId( Integer.valueOf( SmfRegDataDB.getPduSessionId() ) );
        }

        // dnn
        if( null != SmfRegDataDB.getDnn() ){
            retSmfRegData.setDnn( new String( SmfRegDataDB.getDnn() ) );
        }

        // deregCallbackUri
        if( null != SmfRegDataDB.getPcscfRestorationCallbackUri() ){
           retSmfRegData.setPcscfRestorationCallbackUri( new  String(SmfRegDataDB.getPcscfRestorationCallbackUri() ) );
        }
        log.debug("retSmfRegData" + LineSep + retSmfRegData.toString() );

        return retSmfRegData;

    }

    public void setData(String ueId, Integer pduSessionId, SmfRegistration InputSmfRegData){
        log.debug("setData is Called");
        log.debug("ueId : " + ueId);
        log.debug("InputSmfRegData : " + LineSep + InputSmfRegData);
        log.debug("pduSessionId : " + pduSessionId);

        SmfRegistrationDB SmfRegDataDB = new SmfRegistrationDB();

        // smfId
        if( null != InputSmfRegData.getSmfId() ){
           SmfRegDataDB.setSmfId( new String( InputSmfRegData.getSmfId() ) );
        }

        // supportedFeatures
        if( null != InputSmfRegData.getSupportedFeatures() ){
           SmfRegDataDB.setSupportedFeatures( new  String( InputSmfRegData.getSupportedFeatures() ) );
        }

        // PduSessionId
        if( null != InputSmfRegData.getPduSessionId() ){
           SmfRegDataDB.setPduSessionId( Integer.valueOf( InputSmfRegData.getPduSessionId() ) );
        }

        // dnn
        if( null != InputSmfRegData.getDnn() ){
           SmfRegDataDB.setDnn( new String( InputSmfRegData.getDnn() ) );
        }

        // deregCallbackUri
        if( null != InputSmfRegData.getPcscfRestorationCallbackUri()){
            SmfRegDataDB.setPcscfRestorationCallbackUri( new  String(InputSmfRegData.getPcscfRestorationCallbackUri() ) );
        }

        log.debug("SmfRegDataDB" + LineSep + SmfRegDataDB.toString() );

        // Insert DB (void)
        SmfRegAccess.setData(ueId, pduSessionId, SmfRegDataDB);

    }

    public void delData(String ueId, Integer pduSessionId){
        log.debug("delData is Called");
        log.debug("ueId : " + ueId);
        log.debug("pduSessionId : " + pduSessionId);

        SmfRegAccess.delData( ueId, pduSessionId );

    }

}

