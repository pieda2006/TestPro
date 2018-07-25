package com.nec.corestudy.udm.NudmUECM.api;

import com.nec.corestudy.udm.NudmUECM.model.Amf3GppAccessRegistration;
import com.nec.corestudy.udm.NudmUECM.model.Amf3GppAccessRegistrationModification;
import com.nec.corestudy.udm.NudmUECM.model.AmfNon3GppAccessRegistration;
import com.nec.corestudy.udm.NudmUECM.model.AmfNon3GppAccessRegistrationModification;
import com.nec.corestudy.udm.NudmUECM.model.SmfRegistration;
import com.nec.corestudy.udm.NudmUECM.model.SmsfRegistration;
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

import com.nec.corestudy.udm.NudmUECM.AppLogic.SubscriberRefMng.api.Amf3GppAccessCtl;
import com.nec.corestudy.udm.NudmUECM.AppLogic.SubscriberRefMng.api.IndSmf3gppAccessCtl;

import com.nec.corestudy.udm.NudmUECM.AppLogic.SubscriberRefMng.api.ObjectNotFoundAppException;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T20:24:10.908+09:00")

@Controller
public class UeIdApiController implements UeIdApi {

    private static final Logger log = LoggerFactory.getLogger(UeIdApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private Amf3GppAccessCtl Amf3GppAccessCtl;

    @Autowired
    private IndSmf3gppAccessCtl IndSmf3gppAccessCtl;

    @org.springframework.beans.factory.annotation.Autowired
    public UeIdApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    String LineSep = System.getProperty("line.separator");

    public ResponseEntity<Void> deleteIndividualSmfRegistration(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "pduSessionId. ",required=true) @PathVariable("pduSessionId") String pduSessionId) {
        String accept = request.getHeader("Accept");

//        log.info("deleteIndividualSmfRegistration start, ueId : " + ueId);
        log.debug("deleteIndividualSmfRegistration start");
        log.debug("ueId : " + ueId );
        log.debug("pduSessionId : " + pduSessionId );

        // delete
        IndSmf3gppAccessCtl.delData( ueId, Integer.parseInt(pduSessionId) );

//        log.info("deleteIndividualSmfRegistration end");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteSmsf3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId) {
        String accept = request.getHeader("Accept");

//        log.info("deleteSmsf3gppAccess start, ueId : " + ueId);
        log.debug("deleteSmsf3gppAccess start");
        log.debug("ueId : " + ueId);

        // to be added Business Logic
//        log.info("deleteSmsf3gppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteSmsfNon3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId) {
        String accept = request.getHeader("Accept");

//        log.info("deleteSmsfNon3gppAccess start, ueId : " + ueId);
        log.debug("deleteSmsfNon3gppAccess start");
        log.debug("ueId : " + ueId);

        // to be added Business Logic
//        log.info("deleteSmsfNon3gppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Amf3GppAccessRegistration> getAmf3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures) {
        String accept = request.getHeader("Accept");

//        log.info("getAmf3gppAccess start, ueId : " + ueId);
        log.debug("getAmf3gppAccess start");
        log.debug("ueId : " + ueId);
        log.debug("supportedFeatures : " + supportedFeatures);

        Amf3GppAccessRegistration retData;

        try{
            retData = Amf3GppAccessCtl.getData(ueId);
        } catch(ObjectNotFoundAppException e){
            log.warn("User Not Found [" + ueId + "]");
            log.warn("getAmf3gppAccess end");
            return new ResponseEntity<Amf3GppAccessRegistration>( HttpStatus.NOT_FOUND);
        }

        if (accept != null && accept.contains("application/json")) {
//            log.info("getAmf3gppAccess end");
            return new ResponseEntity<Amf3GppAccessRegistration>( retData, HttpStatus.OK);
        }
/*
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Amf3GppAccessRegistration>(objectMapper.readValue("<null>  <amfId>aeiou</amfId>  <supportedFeatures>aeiou</supportedFeatures>  <purgeFlag>true</purgeFlag>  <pei>aeiou</pei>  <imsVoPS>aeiou</imsVoPS>  <deregCallbackUri>aeiou</deregCallbackUri></null>", Amf3GppAccessRegistration.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Amf3GppAccessRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
*/

//        log.info("getAmf3gppAccess end");
        return new ResponseEntity<Amf3GppAccessRegistration>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AmfNon3GppAccessRegistration> getAmfNon3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures) {
        String accept = request.getHeader("Accept");

//        log.info("getAmfNon3gppAccess start, ueId : " + ueId);

        if (accept != null && accept.contains("application/json")) {
            try {
//                log.info("getAmfNon3gppAccess end");
                return new ResponseEntity<AmfNon3GppAccessRegistration>(objectMapper.readValue("{  \"deregCallbackUri\" : \"deregCallbackUri\",  \"supportedFeatures\" : \"supportedFeatures\",  \"purgeFlag\" : true,  \"pei\" : \"pei\",  \"amfId\" : \"amfId\"}", AmfNon3GppAccessRegistration.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("getAmfNon3gppAccess end");
                return new ResponseEntity<AmfNon3GppAccessRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
//                log.info("getAmfNon3gppAccess end");
                return new ResponseEntity<AmfNon3GppAccessRegistration>(objectMapper.readValue("<null>  <amfId>aeiou</amfId>  <supportedFeatures>aeiou</supportedFeatures>  <purgeFlag>true</purgeFlag>  <pei>aeiou</pei>  <deregCallbackUri>aeiou</deregCallbackUri></null>", AmfNon3GppAccessRegistration.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                log.error("getAmfNon3gppAccess end");
                return new ResponseEntity<AmfNon3GppAccessRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("getAmfNon3gppAccess end");
        return new ResponseEntity<AmfNon3GppAccessRegistration>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SmsfRegistration> getSmsf3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures) {
        String accept = request.getHeader("Accept");

//        log.info("getSmsf3gppAccess start, ueId : " + ueId);
        log.debug("getSmsf3gppAccess start");
        log.debug("ueId : " + ueId);
        log.debug("supportedFeatures : " + supportedFeatures);

        if (accept != null && accept.contains("application/json")) {
            try {
//                 log.info("getSmsf3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(objectMapper.readValue("{  \"supportedFeatures\" : \"supportedFeatures\",  \"smsfId\" : \"smsfId\"}", SmsfRegistration.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("getSmsf3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
//                log.info("getSmsf3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(objectMapper.readValue("<null>  <smsfId>aeiou</smsfId>  <supportedFeatures>aeiou</supportedFeatures></null>", SmsfRegistration.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                log.error("getSmsf3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("getSmsf3gppAccess end");
        return new ResponseEntity<SmsfRegistration>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SmsfRegistration> getSmsfNon3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures) {
        String accept = request.getHeader("Accept");

//        log.info("getSmsfNon3gppAccess start, ueId : " + ueId);

        if (accept != null && accept.contains("application/json")) {
            try {
//                log.info("getSmsfNon3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(objectMapper.readValue("{  \"supportedFeatures\" : \"supportedFeatures\",  \"smsfId\" : \"smsfId\"}", SmsfRegistration.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                log.error("getSmsfNon3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
//                log.info("getSmsfNon3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(objectMapper.readValue("<null>  <smsfId>aeiou</smsfId>  <supportedFeatures>aeiou</supportedFeatures></null>", SmsfRegistration.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                log.error("getSmsfNon3gppAccess end");
                return new ResponseEntity<SmsfRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

//        log.info("getSmsfNon3gppAccess end");
        return new ResponseEntity<SmsfRegistration>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patchAmf3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "The AMF registration for 3GPP access is replaced with the received information" ,required=true )  @Valid @RequestBody Amf3GppAccessRegistrationModification amf3GppAccessRegistrationModification) {
        String accept = request.getHeader("Accept");

//        log.info("patchAmf3gppAccess start, ueId : " + ueId);

//        log.info("patchAmf3gppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patchAmfNon3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "The AMF registration for non 3GPP access is modified with the received information." ,required=true )  @Valid @RequestBody AmfNon3GppAccessRegistrationModification amfNon3GppAccessRegistrationModification) {
        String accept = request.getHeader("Accept");

//        log.info("patchAmfNon3gppAccess start, ueId : " + ueId);

//        log.info("patchAmfNon3gppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> putAmf3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "The AMF registration for 3GPP access is replaced with the received information" ,required=true )  @Valid @RequestBody Amf3GppAccessRegistration amf3gppAccessRegistration) {
        String accept = request.getHeader("Accept");

//        log.info("putAmf3gppAccess start, ueId : " + ueId);
        log.debug("putAmf3gppAccess start");
        log.debug("ueId : " + ueId);
        log.debug("amf3gppAccessRegistration : " + LineSep + amf3gppAccessRegistration.toString());

        Amf3GppAccessCtl.setData(ueId, amf3gppAccessRegistration);

//        log.info("putAmf3gppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> putAmfNon3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "The AMF registration for non 3GPP access is replaced with the received information." ,required=true )  @Valid @RequestBody AmfNon3GppAccessRegistration amfNon3gppAccessRegistration) {
        String accept = request.getHeader("Accept");

//        log.info("putAmfNon3gppAccess start, ueId : " + ueId);

//        log.info("putAmfNon3gppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SmfRegistration> putIndividualSmfRegistration(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "pduSessionId. ",required=true) @PathVariable("pduSessionId") String pduSessionId,@ApiParam(value = "The registration that is to be created." ,required=true )  @Valid @RequestBody SmfRegistration smfRegistration) {
        String accept = request.getHeader("Accept");

//        log.info("putIndividualSmfRegistration start, ueId : " + ueId);
        log.debug("putIndividualSmfRegistration start");
        log.debug("ueId : " + ueId);
        log.debug("pduSessionId : " + pduSessionId);
        log.debug("smfRegistration : " + smfRegistration);

        IndSmf3gppAccessCtl.setData(ueId, Integer.parseInt(pduSessionId), smfRegistration);

        if (accept != null && accept.contains("application/json")) {
//            log.info("putIndividualSmfRegistration end");
            return new ResponseEntity<SmfRegistration>(smfRegistration, HttpStatus.NO_CONTENT);
        }

/*
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<SmfRegistration>(objectMapper.readValue("<null>  <smfId>aeiou</smfId>  <supportedFeatures>aeiou</supportedFeatures>  <pduSessionId>123</pduSessionId>  <dnn>aeiou</dnn>  <pcscfRestorationCallbackUri>aeiou</pcscfRestorationCallbackUri></null>", SmfRegistration.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<SmfRegistration>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
*/
//        log.info("putIndividualSmfRegistration end");
        return new ResponseEntity<SmfRegistration>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> putSmsf3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "The SMSF registration for 3GPP access is created or updated with the received information." ,required=true )  @Valid @RequestBody SmsfRegistration smsfRegistration) {
        String accept = request.getHeader("Accept");

//        log.info("putSmsf3gppAccess start, ueId : " + ueId);

//        log.info("putSmsf3gppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> putSmsfNon3GppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "The SMSF registration for non 3GPP access is created or updated with the received information." ,required=true )  @Valid @RequestBody SmsfRegistration smsfRegistration) {
        String accept = request.getHeader("Accept");

//        log.info("putSmsfNon3GppAccess start, ueId : " + ueId);

//        log.info("putSmsfNon3GppAccess end");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
