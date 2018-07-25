package com.nec.corestudy.udm.NudmUECM.common.api.Smsf3GppAccessRegistration;

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
public class Smsf3GppAccessRegistrationAccess {

    private static final Logger log = LoggerFactory.getLogger(Smsf3GppAccessRegistrationAccess.class);

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
        udrAccess.setTblName("ContextDataSmsf");
        String result = udrAccess.execUdrQuery("select * from ContextDataSmsfTBL where ueid = \"" + key + "\"");

        log.debug("### selectTBL End ###");
        return result;
    }

//    public void updateTBL(String key, SmsfRegistrationModificationDB updData) {
    public void updateTBL(String key, SmsfRegistrationDB updData) {   // NoDefine 29503-061
        log.debug("### updateTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : SmsfRegistrationModification : " + updData);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataSmsf");
        String insertParameter = "\'{ \"smsf3GppAccessRegistration\": { \"smsfId\": " + addQuart(updData.getSmsfId())
            + ", \"supportedFeatures\": " + addQuart(updData.getSupportedFeatures())
            + " }, \"smsfNon3GppAccessRegistration\": {} }\'";
        String updParameter = "'$.smsf3GppAccessRegistration.smsfId', " + addQuart(updData.getSmsfId())
            + ", '$.smsf3GppAccessRegistration.supportedFeatures', " + addQuart(updData.getSupportedFeatures());
        udrAccess.execUdrUpdate("update ContextDataSmsfTBL set ContextDataSmsf = JSON_SET(ContextDataSmsf, " + updParameter + ") where ueid = \"" + key + "\"");
        udrAccess.execUdrUpdate("insert into ContextDataAmfTBL ( ueid, ContextDataSmsf ) values ( \"" + key + "\", " + insertParameter + " )"
            + " on duplicate key update ContextDataSmsf = JSON_SET(ContextDataSmsf, " + updParameter + ")");

        log.debug("### updateTBL End ###");
    }

    public void deleteTBL(String key) {
        log.debug("### deleteTBL Start ###");
        log.debug("### Parameter : key : " + key);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataSmsf");
        String delParameter = "'$.smsf3GppAccessRegistration.smsfId'"
            + ", '$.smsf3GppAccessRegistration.supportedFeatures'";
        udrAccess.execUdrUpdate("update ContextDataSmsfTBL set ContextDataSmsf = JSON_REMOVE(ContextDataSmsf, " + delParameter + ") where ueid = \"" + key + "\"");

        log.debug("### deleteTBL End ###");
    }

    public SmsfRegistrationDB getData(String key) {
        log.debug("### getData Start ###");
        log.debug("### Parameter : key : " + key);

        // get SmsfRegistration from UDR
        String result = selectTBL(key);
        log.debug("result : " + result);
        if(result == null) {
            log.info("SmsfRegistration Nothing, key : " + key);

            log.debug("### getData End ###");
            return (null);
        }

        // Json => JavaObject
        ContextDataSmsf contextDataSmsf = new ContextDataSmsf();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            contextDataSmsf = objectMapper.readValue(result, ContextDataSmsf.class);
        } catch (IOException e) {
            log.error("### getData Error End ###");
            log.error("### Parameter : key : " + key);
            log.error("result : " + result);
            log.error("contextDataSmsf : " + contextDataSmsf);
            log.error("Error ContextDataSmsf objectMapper.readValue IOException");
            e.printStackTrace();
        }
        log.debug("contextDataSmsf : " + contextDataSmsf);

        // get SmsfRegistration
        SmsfRegistrationDB smsfRegistration = contextDataSmsf.getSmsf3GppAccessRegistration();
        log.debug("smsfRegistration : " + smsfRegistration);

        log.debug("### getData End ###");
        return smsfRegistration;
    }

//    public void setData(String key, SmsfRegistrationModification updData) {
    public void setData(String key, SmsfRegistrationDB updData) {   // NoDefine 29503-061
        log.debug("### setData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : SmsfRegistrationModification : " + updData);

        // set SmsfRegistration from UDR
        updateTBL(key, updData);

        log.debug("### setData End ###");
    }

    public void delData(String key) {
        log.debug("### delData Start ###");
        log.debug("### Parameter : key : " + key);

        // del SmsfRegistration from UDR
        deleteTBL(key);

        log.debug("### delData End ###");
    }
}
