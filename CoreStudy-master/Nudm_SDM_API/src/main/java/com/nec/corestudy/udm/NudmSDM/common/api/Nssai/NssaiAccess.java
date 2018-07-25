package com.nec.corestudy.udm.NudmSDM.common.api.Nssai;

import com.nec.corestudy.udm.NudmSDM.common.model.*;
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

import com.nec.corestudy.udm.NudmSDM.common.api.UdrAccess;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NssaiAccess {

    private static final Logger log = LoggerFactory.getLogger(NssaiAccess.class);

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
        udrAccess.setKeyName("supi");
        udrAccess.setTblName("SubscriptionData");
        String result = udrAccess.execUdrQuery("select * from SubscriptionDataTBL where supi = \"" + key + "\"");

        log.debug("### selectTBL End ###");
        return result;
    }

    public void updateTBL(String key, NssaiDB updData) {
        log.debug("### updateTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : Nssai : " + updData);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("supi");
        udrAccess.setTblName("SubscriptionData");
//        StringBuilder sbDefaultSingleNssais = new StringBuilder();
//        for (int i = 0; i < updData.getDefaultSingleNssais().size(); i++) {
//            sbDefaultSingleNssais.append(", '$.nssai.defaultSingleNssais[" + i + "]', " + addQuart(updData.getDefaultSingleNssais().get(i).toString()));
//        }
//        String defaultSingleNssaisStr = sbDefaultSingleNssais.toString();
//        StringBuilder sbSingleNssais = new StringBuilder();
//        for (int i = 0; i < updData.getSingleNssais().size(); i++) {
//            sbSingleNssais.append(", '$.nssai.singleNssais[" + i + "]', " + addQuart(updData.getSingleNssais().get(i).toString()));
//        }
//        String singleNssaisStr = sbSingleNssais.toString();
//        String insertParameter = "";
//        String updParameter = "'$.nssai.supportedFeatures', " + addQuart(updData.getSupportedFeatures()) 
//            + defaultSingleNssaisStr 
//            + singleNssaisStr;
//        udrAccess.execUdrUpdate("insert into SubscriptionDataTBL ( supi, SubscriptionData ) values ( \"" + key + "\", " + insertParameter + " )"
//            + " on duplicate key update SubscriptionData = JSON_SET(SubscriptionData, " + updParameter + ")");

        log.debug("### updateTBL End ###");
    }

    public void deleteTBL(String key) {
        log.debug("### deleteTBL Start ###");
        log.debug("### Parameter : key : " + key);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("supi");
        udrAccess.setTblName("SubscriptionData");
        String delParameter = "'$.nssai.supportedFeatures'"
            + ", '$.nssai.defaultSingleNssais'"
            + ", '$.nssai.singleNssais'";
        udrAccess.execUdrUpdate("update SubscriptionDataTBL set SubscriptionData = JSON_REMOVE(SubscriptionData, " + delParameter + ") where supi = \"" + key + "\"");

        log.debug("### deleteTBL End ###");
    }

    public NssaiDB getData(String key) {
        log.debug("### getData Start ###");
        log.debug("### Parameter : key : " + key);

        // get Nssai from UDR
        String result = selectTBL(key);
        log.debug("result : " + result);
        if(result == null) {
            log.info("Nssai Nothing, key : " + key);

            log.debug("### getData End ###");
            return (null);
        }

        // Json => JavaObject
        SubscriptionData subscriptionData = new SubscriptionData();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            subscriptionData = objectMapper.readValue(result, SubscriptionData.class);
        } catch (IOException e) {
            log.error("### getData Error End ###");
            log.error("### Parameter : key : " + key);
            log.error("result : " + result);
            log.error("subscriptionData : " + subscriptionData);
            log.error("Error SubscriptionData objectMapper.readValue IOException");
            e.printStackTrace();
        }
        log.debug("subscriptionData : " + subscriptionData);

        // get Nssai
        NssaiDB nssai = subscriptionData.getNssai();
        log.debug("nssai : " + nssai);

        log.debug("### getData End ###");
        return nssai;
    }

    public void setData(String key, NssaiDB updData) {
        log.debug("### setData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : Nssai : " + updData);

        // set Nssai from UDR
        updateTBL(key, updData);

        log.debug("### setData End ###");
    }

    public void delData(String key) {
        log.debug("### delData Start ###");
        log.debug("### Parameter : key : " + key);

        // del Nssai from UDR
        deleteTBL(key);

        log.debug("### delData End ###");
    }
}
