package com.nec.corestudy.udm.NudmUECM.common.api.SmfRegistration;

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
public class SmfRegistrationAccess {

    private static final Logger log = LoggerFactory.getLogger(SmfRegistrationAccess.class);

    public String addQuart(String str) {
        if (str == null) {
           return str;
        } else {
           return "\"" + str + "\"";
        }
    }

    public String selectTBL(String key, Integer pduSessionId) {
        log.debug("### selectTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : pduSessionId : " + pduSessionId);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataSmf");
        String result = udrAccess.execUdrQuery("select * from ContextDataSmfTBL where ueid = \"" + key + "\" and pduSessionId = " + pduSessionId + "");

        log.debug("### selectTBL End ###");
        return result;
    }

//    public void updateTBL(String key, Integer pduSessionId, SmfRegistrationModification updData) {
    public void updateTBL(String key, Integer pduSessionId, SmfRegistrationDB updData) {   // NoDefine 29503-061
        log.debug("### updateTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : pduSessionId : " + pduSessionId);
        log.debug("### Parameter : SmfRegistrationModification : " + updData);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataSmf");
        String insertParameter = "\'{ \"smfRegistration\": { \"smfId\": " + addQuart(updData.getSmfId())
            + ", \"supportedFeatures\": " + addQuart(updData.getSupportedFeatures())
            + ", \"pduSessionId\": " + updData.getPduSessionId()
            + ", \"dnn\": " + addQuart(updData.getDnn())
            + ", \"pcscfRestorationCallbackUri\": " + addQuart(updData.getPcscfRestorationCallbackUri())
            + " } }\'";
        String updParameter = "'$.smfRegistration.smfId', " + addQuart(updData.getSmfId())
            + ", '$.smfRegistration.supportedFeatures', " + addQuart(updData.getSupportedFeatures())
            + ", '$.smfRegistration.pduSessionId', " + updData.getPduSessionId()
            + ", '$.smfRegistration.dnn', " + addQuart(updData.getDnn())
            + ", '$.smfRegistration.pcscfRestorationCallbackUri', " + addQuart(updData.getPcscfRestorationCallbackUri());
        udrAccess.execUdrUpdate("insert into ContextDataSmfTBL ( ueid, pduSessionId, ContextDataSmf ) values ( \"" + key + "\", " + pduSessionId + ", " + insertParameter + " )"
            + " on duplicate key update ContextDataSmf = JSON_SET(ContextDataSmf, " + updParameter + ")");
        log.debug("### updateTBL End ###");
    }

    public void deleteTBL(String key, Integer pduSessionId) {
        log.debug("### deleteTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : pduSessionId : " + pduSessionId);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("ueid");
        udrAccess.setTblName("ContextDataSmf");
        String delParameter = "'$.smfRegistration.smfId'"
            + ", '$.smfRegistration.supportedFeatures'"
            + ", '$.smfRegistration.pduSessionId'"
            + ", '$.smfRegistration.dnn'"
            + ", '$.smfRegistration.pcscfRestorationCallbackUri'";
        udrAccess.execUdrUpdate("update ContextDataSmfTBL set ContextDataSmf = JSON_REMOVE(ContextDataSmf, " + delParameter + ") where ueid = \"" + key + "\" and pduSessionId = " + pduSessionId + "");

        log.debug("### deleteTBL End ###");
    }

    public SmfRegistrationDB getData(String key, Integer pduSessionId) {
        log.debug("### getData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : pduSessionId : " + pduSessionId);

        // get SmfRegistration from UDR
        String result = selectTBL(key, pduSessionId);
        log.debug("result : " + result);
        if(result == null) {
            log.info("SmfRegistration Nothing, key : " + key);

            log.debug("### getData End ###");
            return (null);
        }

        // Json => JavaObject
        ContextDataSmf contextDataSmf = new ContextDataSmf();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            contextDataSmf = objectMapper.readValue(result, ContextDataSmf.class);
        } catch (IOException e) {
            log.error("### getData Error End ###");
            log.error("### Parameter : key : " + key);
            log.error("result : " + result);
            log.error("contextDataSmf : " + contextDataSmf);
            log.error("Error ContextDataSmf objectMapper.readValue IOException");
            e.printStackTrace();
        }
        log.debug("contextDataSmf : " + contextDataSmf);

        // get SmfRegistration
        SmfRegistrationDB smfRegistration = contextDataSmf.getSmfRegistration();
        log.debug("smfRegistration : " + smfRegistration);

        log.debug("### getData End ###");
        return smfRegistration;
    }

//    public void setData(String key, Integer pduSessionId, SmfRegistrationModification updData) {
    public void setData(String key, Integer pduSessionId, SmfRegistrationDB updData) {   // NoDefine 29503-061
        log.debug("### setData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : pduSessionId : " + pduSessionId);
        log.debug("### Parameter : SmfRegistrationModification : " + updData);

        // set SmfRegistration from UDR
        updateTBL(key, pduSessionId, updData);

        log.debug("### setData End ###");
    }

    public void delData(String key, Integer pduSessionId) {
        log.debug("### delData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : pduSessionId : " + pduSessionId);

        // del SmfRegistration from UDR
        deleteTBL(key, pduSessionId);

        log.debug("### delData End ###");
    }
}
