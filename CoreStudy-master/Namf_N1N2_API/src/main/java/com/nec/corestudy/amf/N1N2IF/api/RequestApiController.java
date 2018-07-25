package com.nec.corestudy.amf.N1N2IF.api;

import com.nec.corestudy.amf.N1N2IF.model.AMFReqMessage;
import com.nec.corestudy.amf.RegistrationMng.api.*;
import com.nec.corestudy.amf.PduSesEstablishMng.api.*;
import com.nec.corestudy.amf.common.AMFcommon.*;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T17:00:57.205+09:00")

@Controller
public class RequestApiController implements RequestApi {

    private static final Logger log = LoggerFactory.getLogger(RequestApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RequestApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> request2AMF(@ApiParam(value = "Request IEs"  )  @Valid @RequestBody AMFReqMessage reqMsg) {
        String accept = request.getHeader("Accept");
        /* add start */
        log.debug("recv Request from UE/RAN");
        log.debug("reqMsg : {}", reqMsg);

        int ret = constants.Jamf_NG;
        String reqType = reqMsg.getReqType();

        switch( reqType ) {
            /* REGISTRATION REQUEST */
            case constants.Jamf_REGISTRATION :
                log.debug("===== REGISTRATION REQUEST =====");
                /* call RegistrationMngMain */
                RegistrationMng regMng = new RegistrationMng( reqMsg );
                ret = regMng.chkParam();
                if( constants.Jamf_NG == ret ) {
                    log.error("Request parameters are not correst( RegReqMes = {})", reqMsg);
                    log.error("send response BAD_REQUEST");
                    return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
                }
                regMng.start();
            break;
            /* PDU SESSION ESTABLISHMENT REQUEST */
            case constants.Jamf_PDUSESSIONESTABLISHMENT :
            case constants.Jamf_PDUSESSIONRELEASE:
                log.debug("===== PDU SESSION ESTABLISHMENT/RELEASE REQUEST =====");
                PduSesEstablishMng pduMng = new PduSesEstablishMng( reqMsg );
                ret = pduMng.chkParam();
                if( constants.Jamf_NG == ret ) {
                    log.error("Request parameters are not correst( RegReqMes = {})", reqMsg);
                    log.error("send response BAD_REQUEST");
                    return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
                }
                pduMng.start();
            break;

            default:
                log.error("Request Type is not correst(reqType = {})", reqType);
                log.error("send response BAD_REQUEST");
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        log.debug("send response ACCEPTED");
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        /* add end */
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
