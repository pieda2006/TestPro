package com.nec.corestudy.udm.NudmSDM.api;

import com.nec.corestudy.udm.NudmSDM.model.AccessAndMobilitySubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.Nssai;
import com.nec.corestudy.udm.NudmSDM.model.SdmSubscription;
import com.nec.corestudy.udm.NudmSDM.model.SessionManagementSubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.SmfSelectionSubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.SmsManagementSubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.SmsSubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.SubscriptionDataSets;
import com.nec.corestudy.udm.NudmSDM.model.UeContextInSmfData;
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

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api.AmDataCtl;
import com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api.SmDataCtl;
import com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api.SmfSelectDataCtl;
import com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api.UeContextSmfDataCtl;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

@Controller
public class SupiApiController implements SupiApi {

    private static final Logger log = LoggerFactory.getLogger(SupiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SupiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    private AmDataCtl   AmDataCtl;

    @Autowired
    private SmDataCtl   SmDataCtl;

    @Autowired
    private SmfSelectDataCtl    SmfSelectDataCtl;

    @Autowired
    private UeContextSmfDataCtl UeContextSmfDataCtl;


/*
    deleteSDMSubscription
*/

    public ResponseEntity<Void> deleteSDMSubscription(@ApiParam(value = "Represents the Subscription Permanent Identifier. ",required=true) @PathVariable("supi") String supi,@ApiParam(value = "The subscriptionId identifies an individual subscription to notifications. The value is allocated by the UDM  during creation of the Subscription resource.",required=true) @PathVariable("subscriptionId") String subscriptionId) {
        String accept = request.getHeader("Accept");

//        log.info("deleteSDMSubscription start, supi : " + supi);
        log.debug("deleteSDMSubscription");
        log.debug("supi : " + supi);
        log.debug("subscriptionId : " + subscriptionId);

//        log.info("deleteSDMSubscription end");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

/*
    getAmData
*/

    public ResponseEntity<AccessAndMobilitySubscriptionData> getAmData(@ApiParam(value = "supi.",required=true) @PathVariable("supi") String supi,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures,@ApiParam(value = "") @Valid @RequestParam(value = "plmn-id", required = false) String plmnId) {
        String accept = request.getHeader("Accept");

//        log.info("getAmData start, supi : " + supi);
        log.debug("getAmData");
        log.debug("supi : " + supi);
        log.debug("supportedFeatures : " + supportedFeatures);
        log.debug("plmn-id : " + plmnId);

        AccessAndMobilitySubscriptionData AmData = new AccessAndMobilitySubscriptionData();

        AmData = AmDataCtl.getData(supi);


//        if (accept != null && accept.contains("application/xml")) {
//            try {
//                return new ResponseEntity<AccessAndMobilitySubscriptionData>(objectMapper.readValue("<null>  <supportedFeatures>aeiou</supportedFeatures>  <gpsi>aeiou</gpsi>  <internalGroupId>aeiou</internalGroupId>  <ratRestriction>aeiou</ratRestriction>  <coreNetworkTypeRestriction>aeiou</coreNetworkTypeRestriction>  <rfspIndex>123</rfspIndex>  <subsRegTimer>123</subsRegTimer>  <ueUsageType>123</ueUsageType>  <ladnInformation>aeiou</ladnInformation>  <mpsPriority>true</mpsPriority></null>", AccessAndMobilitySubscriptionData.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/xml", e);
//                return new ResponseEntity<AccessAndMobilitySubscriptionData>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        if (accept != null && accept.contains("application/json"))
        {
//            log.info("getAmData end");
            return new ResponseEntity<AccessAndMobilitySubscriptionData>(AmData, HttpStatus.OK);
        }

//        log.info("getAmData end");
        return new ResponseEntity<AccessAndMobilitySubscriptionData>(HttpStatus.NOT_IMPLEMENTED);
    }

/*
    getNssai
*/

    public ResponseEntity<Nssai> getNssai(@ApiParam(value = "",required=true) @PathVariable("supi") String supi,@ApiParam(value = "") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures,@ApiParam(value = "") @Valid @RequestParam(value = "plmn-id", required = false) String plmnId) {
        String accept = request.getHeader("Accept");

//        log.info("getNssai start, supi : " + supi);
        log.debug("getNssai");
        log.debug("supi : " + supi);
        log.debug("supportedFeatures : " + supportedFeatures);
        log.debug("plmn-id : " + plmnId);

//        if (accept != null && accept.contains("application/xml")) {
//            try {
//                return new ResponseEntity<Nssai>(objectMapper.readValue("<null>  <supportedFeatures>aeiou</supportedFeatures></null>", Nssai.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/xml", e);
//                return new ResponseEntity<Nssai>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        if (accept != null && accept.contains("application/json")) {
            try {
//                log.info("getNssai end, supi : " + supi);
                return new ResponseEntity<Nssai>(objectMapper.readValue("{  \"supportedFeatures\" : \"supportedFeatures\",  \"defaultSingleNssais\" : [ {    \"sd\" : \"sd\",    \"sst\" : 0  }, {    \"sd\" : \"sd\",    \"sst\" : 0  } ],  \"singleNssais\" : [ {    \"sd\" : \"sd\",    \"sst\" : 0  }, {    \"sd\" : \"sd\",    \"sst\" : 0  } ]}", Nssai.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("getNssai end");
                return new ResponseEntity<Nssai>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("getNssai end");
        return new ResponseEntity<Nssai>(HttpStatus.NOT_IMPLEMENTED);
    }

/*
   getSmData
*/

    public ResponseEntity<List<SessionManagementSubscriptionData>> getSmData(@ApiParam(value = "",required=true) @PathVariable("supi") String supi,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "singleNssai", required = false) String singleNssai,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "dnn", required = false) String dnn,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "plmn-id", required = false) String plmnId) {
        String accept = request.getHeader("Accept");

//        log.info("getSmData start, supi : " + supi);
        log.debug("getSmData");
        log.debug("supi : " + supi);
        log.debug("supportedFeatures : " + supportedFeatures);
        log.debug("singleNssai : " + singleNssai);
        log.debug("dnn : " + dnn);
        log.debug("plmn-id : " + plmnId );

        List<SessionManagementSubscriptionData> SmData = new ArrayList<SessionManagementSubscriptionData>();

        SmData = SmDataCtl.getData(supi);

//        if (accept != null && accept.contains("application/xml")) {
//            try {
//                return new ResponseEntity<List<SessionManagementSubscriptionData>>(objectMapper.readValue("<null></null>", List.class), HttpStatus.NO_CONTENT);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/xml", e);
//                return new ResponseEntity<List<SessionManagementSubscriptionData>>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        if (null == SmData) {
            log.debug("SmData is Null");
        }
        if (accept != null && accept.contains("application/json")) {
//            log.info("getSmData end");
            return new ResponseEntity<List<SessionManagementSubscriptionData>>(SmData, HttpStatus.OK);
        }

//        log.info("getSmData end");
        return new ResponseEntity<List<SessionManagementSubscriptionData>>(HttpStatus.NOT_IMPLEMENTED);
    }

/*
   getSmfSelectdata
*/

    public ResponseEntity<SmfSelectionSubscriptionData> getSmfSelectdata(@ApiParam(value = "",required=true) @PathVariable("supi") String supi,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures,@ApiParam(value = "") @Valid @RequestParam(value = "plmn-id", required = false) String plmnId) {
        String accept = request.getHeader("Accept");

//        log.info("getSmfSelectdata start, supi : " + supi);
        log.debug("getSmfSelectdata");
        log.debug("supi : " + supi);
        log.debug("supportedFeatures : " + supportedFeatures);
        log.debug("plmn-id : " + plmnId );

        SmfSelectionSubscriptionData SmfSelectData = new SmfSelectionSubscriptionData();

        SmfSelectData = SmfSelectDataCtl.getData(supi);

//        if (accept != null && accept.contains("application/xml")) {
//            try {
//                return new ResponseEntity<SmfSelectionSubscriptionData>(objectMapper.readValue("<null>  <supportedFeatures>aeiou</supportedFeatures></null>", SmfSelectionSubscriptionData.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/xml", e);
//                return new ResponseEntity<SmfSelectionSubscriptionData>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        if (accept != null && accept.contains("application/json")) {
//            log.info("getSmfSelectdata end");
            return new ResponseEntity<SmfSelectionSubscriptionData>(SmfSelectData, HttpStatus.OK);
        }

//        log.info("getSmfSelectdata end");
        return new ResponseEntity<SmfSelectionSubscriptionData>(HttpStatus.NOT_IMPLEMENTED);
    }

/*
   getSmsData
*/

    public ResponseEntity<SmsSubscriptionData> getSmsData(@ApiParam(value = "",required=true) @PathVariable("supi") String supi) {
        String accept = request.getHeader("Accept");

//        log.info("getSmsData start, supi : " + supi);
        log.debug("getSmsData");

        if (accept != null && accept.contains("application/xml")) {
            try {
//                log.info("getSmsData end");
                return new ResponseEntity<SmsSubscriptionData>(objectMapper.readValue("<null>  <smsSupported>aeiou</smsSupported>  <smsf3GppAddress>aeiou</smsf3GppAddress>  <smsfNon3GppAddress>aeiou</smsfNon3GppAddress></null>", SmsSubscriptionData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                log.error("getSmsData end");
                return new ResponseEntity<SmsSubscriptionData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
//                log.info("getSmsData end");
                return new ResponseEntity<SmsSubscriptionData>(objectMapper.readValue("{  \"smsf3GppAddress\" : \"smsf3GppAddress\",  \"smsfNon3GppAddress\" : \"smsfNon3GppAddress\",  \"smsSupported\" : \"SMS_3GPP\"}", SmsSubscriptionData.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("getSmsData end");
                return new ResponseEntity<SmsSubscriptionData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("getSmsData end");
        return new ResponseEntity<SmsSubscriptionData>(HttpStatus.NOT_IMPLEMENTED);
    }

/*
    getSmsMngData
*/
    public ResponseEntity<SmsManagementSubscriptionData> getSmsMngData(@ApiParam(value = "",required=true) @PathVariable("supi") String supi) {
        String accept = request.getHeader("Accept");

//        log.info("getSmsMngData start, supi : " + supi);
        log.debug("getSmsMngData");

        if (accept != null && accept.contains("application/xml")) {
            try {
//                log.info("getSmsMngData end");
                return new ResponseEntity<SmsManagementSubscriptionData>(objectMapper.readValue("<null>  <supportedFeatures>aeiou</supportedFeatures>  <mtSmsSubscribed>true</mtSmsSubscribed>  <mtSmsBarringAll>true</mtSmsBarringAll>  <mtSmsbarringRoaming>true</mtSmsbarringRoaming>  <moSmsSubscribed>true</moSmsSubscribed>  <moSmsBarringAll>true</moSmsBarringAll>  <moSmsbarringRoaming>true</moSmsbarringRoaming></null>", SmsManagementSubscriptionData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                log.error("getSmsMngData end");
                return new ResponseEntity<SmsManagementSubscriptionData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
//                log.info("getSmsMngData end");
                return new ResponseEntity<SmsManagementSubscriptionData>(objectMapper.readValue("{  \"mtSmsbarringRoaming\" : true,  \"moSmsBarringAll\" : true,  \"supportedFeatures\" : \"supportedFeatures\",  \"moSmsbarringRoaming\" : true,  \"mtSmsSubscribed\" : true,  \"mtSmsBarringAll\" : true,  \"moSmsSubscribed\" : true}", SmsManagementSubscriptionData.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("getSmsMngData end");
                return new ResponseEntity<SmsManagementSubscriptionData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("getSmsMngData end");
        return new ResponseEntity<SmsManagementSubscriptionData>(HttpStatus.NOT_IMPLEMENTED);
    }

/*
    getSupi
*/

    public ResponseEntity<SubscriptionDataSets> getSupi(@ApiParam(value = "Represents the Subscription Permanent Identifier. ",required=true) @PathVariable("supi") String supi,@NotNull @ApiParam(value = "[TBD].", required = true) @Valid @RequestParam(value = "datasets", required = true) List<String> datasets) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {

//        log.info("getSupi start, supi : " + supi);
        log.debug("getSupi");

            try {
//                log.info("getSupi end");
                return new ResponseEntity<SubscriptionDataSets>(objectMapper.readValue("<null></null>", SubscriptionDataSets.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                log.error("getSupi end");
                return new ResponseEntity<SubscriptionDataSets>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
//                log.info("getSupi end");
                return new ResponseEntity<SubscriptionDataSets>(objectMapper.readValue("{  \"amData\" : {    \"ratRestriction\" : [ \"NR\", \"NR\" ],    \"supportedFeatures\" : \"supportedFeatures\",    \"subscribed-UeAmbr\" : {      \"uplink\" : \"uplink\",      \"downlink\" : \"downlink\"    },    \"gpsi\" : [ \"gpsi\", \"gpsi\" ],    \"ladnInformation\" : \"ladnInformation\",    \"nssai\" : {      \"supportedFeatures\" : \"supportedFeatures\",      \"defaultSingleNssais\" : [ {        \"sd\" : \"sd\",        \"sst\" : 0      }, {        \"sd\" : \"sd\",        \"sst\" : 0      } ],      \"singleNssais\" : [ {        \"sd\" : \"sd\",        \"sst\" : 0      }, {        \"sd\" : \"sd\",        \"sst\" : 0      } ]    },    \"internalGroupId\" : [ \"internalGroupId\", \"internalGroupId\" ],    \"coreNetworkTypeRestriction\" : \"coreNetworkTypeRestriction\",    \"rfspIndex\" : 1,    \"mpsPriority\" : true,    \"areaRestriction\" : [ {      \"restrictionType\" : \"SAR_ALLOWED_AREA\",      \"areaInformation\" : {        \"areaCode\" : [ \"areaCode\", \"areaCode\" ],        \"tac\" : [ \"tac\", \"tac\" ],        \"maxNumberTAs\" : [ 6, 6 ]      },      \"ratType\" : [ \"NR\", \"NR\" ]    }, {      \"restrictionType\" : \"SAR_ALLOWED_AREA\",      \"areaInformation\" : {        \"areaCode\" : [ \"areaCode\", \"areaCode\" ],        \"tac\" : [ \"tac\", \"tac\" ],        \"maxNumberTAs\" : [ 6, 6 ]      },      \"ratType\" : [ \"NR\", \"NR\" ]    } ],    \"subsRegTimer\" : 5,    \"ueUsageType\" : 5  },  \"smfSelData\" : {    \"supportedFeatures\" : \"supportedFeatures\",    \"subscribedSnssaiInfo\" : [ {      \"dnnInfos\" : [ {        \"defaultDnnIndicator\" : true,        \"dnn\" : \"dnn\",        \"lboRoamingAllowed\" : true      }, {        \"defaultDnnIndicator\" : true,        \"dnn\" : \"dnn\",        \"lboRoamingAllowed\" : true      } ],      \"singleNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 0      }    }, {      \"dnnInfos\" : [ {        \"defaultDnnIndicator\" : true,        \"dnn\" : \"dnn\",        \"lboRoamingAllowed\" : true      }, {        \"defaultDnnIndicator\" : true,        \"dnn\" : \"dnn\",        \"lboRoamingAllowed\" : true      } ],      \"singleNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 0      }    } ]  }}", SubscriptionDataSets.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("getSupi end");
                return new ResponseEntity<SubscriptionDataSets>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("getSupi end");
        return new ResponseEntity<SubscriptionDataSets>(HttpStatus.NOT_IMPLEMENTED);
    }
/*
    getUeContextInSmfData
*/

    public ResponseEntity<UeContextInSmfData> getUeContextInSmfData(@ApiParam(value = "",required=true) @PathVariable("supi") String supi,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures) {
        String accept = request.getHeader("Accept");

//        log.info("getUeContextInSmfData start, supi : " + supi);
        log.debug("getUeContextInSmfData");
        log.debug("supi : " + supi);
        log.debug("supportedFeatures : " + supportedFeatures);

        UeContextInSmfData UeConSmfData = new UeContextInSmfData();

        UeConSmfData = UeContextSmfDataCtl.getData(supi);

//        if (accept != null && accept.contains("application/xml")) {
//            try {
//                return new ResponseEntity<UeContextInSmfData>(objectMapper.readValue("<null></null>", UeContextInSmfData.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/xml", e);
//                return new ResponseEntity<UeContextInSmfData>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        if (accept != null && accept.contains("application/json")) {
//            log.info("getUeContextInSmfData end");
            return new ResponseEntity<UeContextInSmfData>(UeConSmfData, HttpStatus.OK);
        }

//        log.info("getUeContextInSmfData end");
        return new ResponseEntity<UeContextInSmfData>(HttpStatus.NOT_IMPLEMENTED);
    }

/*
    postSDMSubscription
*/

    public ResponseEntity<SdmSubscription> postSDMSubscription(@ApiParam(value = ".",required=true) @PathVariable("supi") String supi,@ApiParam(value = "The subscription that is to be created." ,required=true )  @Valid @RequestBody SdmSubscription subdata) {
        String accept = request.getHeader("Accept");

//        log.info("postSDMSubscription start, supi : " + supi);
        log.debug("postSDMSubscription");

        if (accept != null && accept.contains("application/xml")) {
            try {
//                log.info("postSDMSubscription end");
                return new ResponseEntity<SdmSubscription>(objectMapper.readValue("<null>  <callbackReference>aeiou</callbackReference>  <monitoredResourceUri>aeiou</monitoredResourceUri></null>", SdmSubscription.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                log.error("postSDMSubscription end");
                return new ResponseEntity<SdmSubscription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
//                log.info("postSDMSubscription end");
                return new ResponseEntity<SdmSubscription>(objectMapper.readValue("{  \"callbackReference\" : \"callbackReference\",  \"monitoredResourceUri\" : [ \"monitoredResourceUri\", \"monitoredResourceUri\" ]}", SdmSubscription.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("postSDMSubscription end");
                return new ResponseEntity<SdmSubscription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("postSDMSubscription end");
        return new ResponseEntity<SdmSubscription>(HttpStatus.NOT_IMPLEMENTED);
    }

}
