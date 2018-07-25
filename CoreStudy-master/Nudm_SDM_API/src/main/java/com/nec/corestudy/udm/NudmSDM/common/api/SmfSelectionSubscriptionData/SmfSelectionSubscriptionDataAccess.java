package com.nec.corestudy.udm.NudmSDM.common.api.SmfSelectionSubscriptionData;

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
public class SmfSelectionSubscriptionDataAccess {

    private static final Logger log = LoggerFactory.getLogger(SmfSelectionSubscriptionDataAccess.class);

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

    public void updateTBL(String key, SmfSelectionSubscriptionDataDB updData) {
        log.debug("### updateTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : SmfSelectionSubscriptionData : " + updData);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("supi");
        udrAccess.setTblName("SubscriptionData");
//        String insertParameter = "";
//        String updParameter = "";
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
        String delParameter = "'$.smfSelData.supportedFeatures'"
            + ", '$.smfSelData.subscribedSnssaiInfo'";
        udrAccess.execUdrUpdate("update SubscriptionDataTBL set SubscriptionData = JSON_REMOVE(SubscriptionData, " + delParameter + ") where supi = \"" + key + "\"");

        log.debug("### deleteTBL End ###");
    }

    public SmfSelectionSubscriptionDataDB getData(String key) {
        log.debug("### getData Start ###");
        log.debug("### Parameter : key : " + key);

        // get SmfSelectionSubscriptionData from UDR
        String result = selectTBL(key);
        log.debug("result : " + result);
        if(result == null) {
            log.info("SmfSelectionSubscriptionData Nothing, key : " + key);

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

        // get SmfSelectionSubscriptionData
        SmfSelectionSubscriptionDataDB smfSelectionSubscriptionData = subscriptionData.getSmfSelData();
        log.debug("smfSelectionSubscriptionData : " + smfSelectionSubscriptionData);

        log.debug("### getData End ###");
        return smfSelectionSubscriptionData;
    }

    public void setData(String key, SmfSelectionSubscriptionDataDB updData) {
        log.debug("### setData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : SmfSelectionSubscriptionData : " + updData);

        // set SmfSelectionSubscriptionData from UDR
        updateTBL(key, updData);

        log.debug("### setData End ###");
    }

    public void delData(String key) {
        log.debug("### delData Start ###");
        log.debug("### Parameter : key : " + key);

        // del SmfSelectionSubscriptionData from UDR
        deleteTBL(key);

        log.debug("### delData End ###");
    }
}
