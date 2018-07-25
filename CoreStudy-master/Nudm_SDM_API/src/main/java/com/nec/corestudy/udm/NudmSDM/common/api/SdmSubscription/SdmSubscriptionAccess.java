package com.nec.corestudy.udm.NudmSDM.common.api.SdmSubscription;

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
public class SdmSubscriptionAccess {

    private static final Logger log = LoggerFactory.getLogger(SdmSubscriptionAccess.class);

    public String addQuart(String str) {
        if (str == null) {
           return str;
        } else {
           return "\"" + str + "\"";
        }
    }

    public String selectTBL(String key, Integer subscriptionId) {
        log.debug("### selectTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : subscriptionId : " + subscriptionId);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("supi");
        udrAccess.setTblName("SdmSubscription");
        String result = udrAccess.execUdrQuery("select * from SdmSubscriptionTBL where supi = \"" + key + "\" and subscriptionId = " + subscriptionId + "");

        log.debug("### selectTBL End ###");
        return result;
    }

    public void updateTBL(String key, Integer subscriptionId, SdmSubscriptionDB updData) {
        log.debug("### updateTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : subscriptionId : " + subscriptionId);
        log.debug("### Parameter : SdmSubscriptionDB : " + updData);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("supi");
        udrAccess.setTblName("SdmSubscription");

        StringBuilder sbIns = new StringBuilder();
        StringBuilder sbUpd = new StringBuilder();
        for (int i = 0; i < updData.getMonitoredResourceUri().size(); i++) {
            sbIns.append(addQuart(updData.getMonitoredResourceUri().get(i)));
            sbUpd.append("'$.sdmSubscriptions.monitoredResourceUri[" + i + "]', " + addQuart(updData.getMonitoredResourceUri().get(i)));
            if ( i + 1 < updData.getMonitoredResourceUri().size() ) {
                sbIns.append(", ");
                sbUpd.append(", ");
            }
        }
        String monitoredResourceUriStrIns = null;
        String monitoredResourceUriStrUpd = sbUpd.toString();
        if ( 0 != updData.getMonitoredResourceUri().size() ) {
            monitoredResourceUriStrIns = "[ " + sbIns.toString() + " ]";
        } else {
            monitoredResourceUriStrIns = "null";
        }
        String insertParameter = "\'{ \"sdmSubscriptions\": { \"callbackReference\": " + addQuart(updData.getCallbackReference())
            + ", \"monitoredResourceUri\": " + monitoredResourceUriStrIns
            + " } }\'";
        String updParameter = "'$.sdmSubscriptions.callbackReference', " + addQuart(updData.getCallbackReference())
            + ", " + monitoredResourceUriStrUpd;
        udrAccess.execUdrUpdate("insert into SdmSubscriptionTBL ( supi, subscriptionId, SdmSubscription ) values ( \"" + key + "\", " + subscriptionId + ", " + insertParameter + " )"
            + " on duplicate key update SdmSubscription = JSON_SET(SdmSubscription, " + updParameter + ")");

        log.debug("### updateTBL End ###");
    }

    public void deleteTBL(String key, Integer subscriptionId) {
        log.debug("### deleteTBL Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : subscriptionId : " + subscriptionId);

        UdrAccess udrAccess = new UdrAccess();
        udrAccess.setKeyName("supi");
        udrAccess.setTblName("SdmSubscription");
        String delParameter = "'$.sdmSubscriptions.callbackReference'"
            + ", '$.sdmSubscriptions.monitoredResourceUri'";
        udrAccess.execUdrUpdate("update SdmSubscriptionTBL set SdmSubscription = JSON_REMOVE(SdmSubscription, " + delParameter + ") where supi = \"" + key + "\" and subscriptionId = " + subscriptionId + "");

        log.debug("### deleteTBL End ###");
    }

    public SdmSubscriptionDB getData(String key, Integer subscriptionId) {
        log.debug("### getData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : subscriptionId : " + subscriptionId);

        // get SdmSubscription from UDR
        String result = selectTBL(key, subscriptionId);
        log.debug("result : " + result);
        if(result == null) {
            log.info("SdmSubscription Nothing, key : " + key);

            log.debug("### getData End ###");
            return (null);
        }

        // Json => JavaObject
        SdmSubscription SdmSubscription = new SdmSubscription();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SdmSubscription = objectMapper.readValue(result, SdmSubscription.class);
        } catch (IOException e) {
            log.error("### getData Error End ###");
            log.error("### Parameter : key : " + key);
            log.error("result : " + result);
            log.error("SdmSubscription : " + SdmSubscription);
            log.error("Error SdmSubscription objectMapper.readValue IOException");
            e.printStackTrace();
        }
        log.debug("SdmSubscription : " + SdmSubscription);

        // get SdmSubscription
        SdmSubscriptionDB sdmSubscriptions = SdmSubscription.getSdmSubscriptions();
        log.debug("sdmSubscriptions : " + sdmSubscriptions);

        log.debug("### getData End ###");
        return sdmSubscriptions;
    }

    public void setData(String key, Integer subscriptionId, SdmSubscriptionDB updData) {
        log.debug("### setData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : subscriptionId : " + subscriptionId);
        log.debug("### Parameter : SdmSubscription : " + updData);

        // set SdmSubscription from UDR
        updateTBL(key, subscriptionId, updData);

        log.debug("### setData End ###");
    }

    public void delData(String key, Integer subscriptionId) {
        log.debug("### delData Start ###");
        log.debug("### Parameter : key : " + key);
        log.debug("### Parameter : subscriptionId : " + subscriptionId);

        // del SdmSubscription from UDR
        deleteTBL(key, subscriptionId);

        log.debug("### delData End ###");
    }
}
