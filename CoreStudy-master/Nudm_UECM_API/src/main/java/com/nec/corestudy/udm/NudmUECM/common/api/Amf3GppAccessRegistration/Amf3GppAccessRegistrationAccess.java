package com.nec.corestudy.udm.NudmUECM.common.api.Amf3GppAccessRegistration;

import com.nec.corestudy.udm.NudmUECM.common.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.nec.corestudy.udm.NudmUECM.common.api.UdrAccess;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Amf3GppAccessRegistrationAccess {

    private static final Logger log = LoggerFactory.getLogger(Amf3GppAccessRegistrationAccess.class);

    public String addQuart(String str) {
        if (str == null) {
           return str;
        } else {
           return "\"" + str + "\"";
        }
    }

    public String selectTBL(String key) {
        log.debug("### selectTBL Start ###");
        log.debug("### Parameter : key : " + key);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataAmf");
        String result = udrAccess.execUdrQuery("select * from ContextDataAmfTBL where ueid = \"" + key + "\"");

        log.debug("### selectTBL End ###");
        return result;
    }

    public void updateTBL(String key, Amf3GppAccessRegistrationDB updData) {
        log.debug("### updateTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : Amf3GppAccessRegistration : " + updData);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataAmf");
        String insertParameter = "\'{ \"amf3GppAccessRegistration\": { \"amfId\": " + addQuart(updData.getAmfId())
            + ", \"supportedFeatures\": " + addQuart(updData.getSupportedFeatures())
            + ", \"purgeFlag\": " + updData.isPurgeFlag()
            + ", \"pei\": " + addQuart(updData.getPei())
            + ", \"imsVoPS\": " + addQuart(updData.getImsVoPS().toString())
            + ", \"deregCallbackUri\": " +addQuart(updData.getDeregCallbackUri())
            + " }, \"amfNon3GppAccessRegistration\": {} }\'";
        String updParameter = "'$.amf3GppAccessRegistration.amfId', " + addQuart(updData.getAmfId())
            + ", '$.amf3GppAccessRegistration.supportedFeatures', " + addQuart(updData.getSupportedFeatures())
            + ", '$.amf3GppAccessRegistration.purgeFlag', " + updData.isPurgeFlag()
            + ", '$.amf3GppAccessRegistration.pei', " + addQuart(updData.getPei())
            + ", '$.amf3GppAccessRegistration.imsVoPS', " + addQuart(updData.getImsVoPS().toString())
            + ", '$.amf3GppAccessRegistration.deregCallbackUri', " + addQuart(updData.getDeregCallbackUri());
        udrAccess.execUdrUpdate("insert into ContextDataAmfTBL ( ueid, ContextDataAmf ) values ( \"" + key + "\", " + insertParameter + " )"
            + " on duplicate key update ContextDataAmf = JSON_SET(ContextDataAmf, " + updParameter + ")");

        log.debug("### updateTBL End ###");
    }

    public void updateTBL(String key, Amf3GppAccessRegistrationModificationDB updData) {
        log.debug("### updateTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : Amf3GppAccessRegistrationModification : " + updData);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataAmf");
        String updParameter = "'$.amf3GppAccessRegistration.purgeFlag', " + updData.isPurgeFlag()
            + ", '$.amf3GppAccessRegistration.pei', " + addQuart(updData.getPei())
            + ", '$.amf3GppAccessRegistration.imsVoPS', " + addQuart(updData.getImsVoPS().toString());
        udrAccess.execUdrUpdate("update ContextDataAmfTBL set ContextDataAmf = JSON_SET(ContextDataAmf, " + updParameter + ") where ueid = \"" + key + "\"");

        log.debug("### updateTBL End ###");
    }

    public void deleteTBL(String key) {
        log.debug("### deleteTBL Start ###");
        log.debug("### Parameter : key : " + key);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataAmf");
        String delParameter = "'$.amf3GppAccessRegistration.amfId'"
            + ", '$.amf3GppAccessRegistration.supportedFeatures'"
            + ", '$.amf3GppAccessRegistration.purgeFlag'"
            + ", '$.amf3GppAccessRegistration.pei'"
            + ", '$.amf3GppAccessRegistration.imsVoPS'"
            + ", '$.amf3GppAccessRegistration.deregCallbackUri'";
        udrAccess.execUdrUpdate("update ContextDataAmfTBL set ContextDataAmf = JSON_REMOVE(ContextDataAmf, " + delParameter + ") where ueid = \"" + key + "\"");

        log.debug("### deleteTBL End ###");
    }

    public Amf3GppAccessRegistrationDB getData(String key) {
        log.debug("### getData Start ###");
        log.debug("### Parameter : key : " + key);

        // get Amf3GppAccessRegistration from UDR
        String result = selectTBL(key);
        log.debug("result : " + result);
        if(result == null) {
            log.info("Amf3GppAccessRegistration Nothing, key : " + key);

            log.debug("### getData End ###");
            return (null);
        }

        // Json => JavaObject
        ContextDataAmf contextDataAmf = new ContextDataAmf();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            contextDataAmf = objectMapper.readValue(result, ContextDataAmf.class);
        } catch (IOException e) {
            log.error("### getData Error End ###");
            log.error("### Parameter : key : " + key);
            log.error("result : " + result);
            log.error("contextDataAmf : " + contextDataAmf);
            log.error("Error ContextDataAmf objectMapper.readValue IOException");
            e.printStackTrace();
        }
        log.debug("contextDataAmf : " + contextDataAmf);

        // get Amf3GppAccessRegistration
        Amf3GppAccessRegistrationDB amf3GppAccessRegistration = contextDataAmf.getAmf3GppAccessRegistration();
        log.debug("amf3GppAccessRegistration : " + amf3GppAccessRegistration);

        log.debug("### getData End ###");
        return amf3GppAccessRegistration;
    }

    public void setData(String key, Amf3GppAccessRegistrationDB updData) {
        log.debug("### setData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : Amf3GppAccessRegistration : " + updData);

        // set Amf3GppAccessRegistration from UDR
        updateTBL(key, updData);

        log.debug("### setData End ###");
    }

    public void setData(String key, Amf3GppAccessRegistrationModificationDB updData) {
        log.debug("### setData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : Amf3GppAccessRegistrationModification : " + updData);

        // set Amf3GppAccessRegistration from UDR
        updateTBL(key, updData);

        log.debug("### setData End ###");
    }

    public void delData(String key) {
        log.debug("### delData Start ###");
        log.debug("### Parameter : key : " + key);

        // del Amf3GppAccessRegistration from UDR
        deleteTBL(key);

        log.debug("### delData End ###");
    }
}
