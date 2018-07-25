package com.nec.corestudy.amf.N1N2IF.api;

import com.nec.corestudy.amf.N1N2IF.model.AMFN2PduSesReqData;
import com.nec.corestudy.amf.N1N2IF.model.AMFN2ResRelReqData;
import com.nec.corestudy.amf.N1N2IF.model.AMFRegistrationAccData;
import com.nec.corestudy.amf.N2PDUSessionMng.api.*;
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
public class UeIdApiController implements UeIdApi {

    private static final Logger log = LoggerFactory.getLogger(UeIdApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private static int regAccCnt = 0;
    private static int pduReqCnt = 0;
    private static int pduRelCnt = 0;

    @org.springframework.beans.factory.annotation.Autowired
    public UeIdApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> postN2PDUSessionRequest(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFN2PduSesReqData n2PduSesReqData) {
        String accept = request.getHeader("Accept");
        pduReqCnt++;
        log.info("recv N2 PDU Session Request(ueId : {})", ueId);
        log.info("recv N2 PDU Session Request total : {}", pduReqCnt);
        log.debug("AMFN2PduSesReqData : {}",n2PduSesReqData);

        /* add kick upf shell */
        int ret = constants.Jamf_NG;
        N2PDUSessionMng n2pduMng = new N2PDUSessionMng(n2PduSesReqData);
        ret = n2pduMng.chk_param_est();
        if(constants.Jamf_NG == ret ){
            log.error("postN2PDUSessionRequest NG(BAD_REQUEST)");
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        ret = n2pduMng.N2PDUSession();
        if(constants.Jamf_NG == ret ){
            log.error("postN2PDUSessionRequest NG(INTERNAL_SERVER_ERROR)");
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postN2ResourceReleaseRequest(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFN2ResRelReqData n2ResRelReqData) {
        String accept = request.getHeader("Accept");
        pduRelCnt++;
        log.info("recv N2 PDU Session Release Request(ueId : {})", ueId);
        log.info("recv N2 PDU Session Release Request total : {}", pduRelCnt);
        /* add kick upf shell */
        int ret = constants.Jamf_NG;
        N2PDUSessionMng n2pduMng = new N2PDUSessionMng(n2ResRelReqData);
        ret = n2pduMng.chk_param_rel();
        if(constants.Jamf_NG == ret ){
            log.error("postN2PDUSessionRelease NG(BAD_REQUEST)");
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        ret = n2pduMng.N2PDUSessionRel();
        if(constants.Jamf_NG == ret ){
            log.error("postN2PDUSessionRelease NG(INTERNAL_SERVER_ERROR)");
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postRegistrationAccept(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFRegistrationAccData regAccData) {
        String accept = request.getHeader("Accept");
        regAccCnt++;
        log.info("recv Registration Accept(ueId : {})", ueId);
        log.info("recv Registration Accept total : {}", regAccCnt);
        log.debug("regAccData : {}",regAccData);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
