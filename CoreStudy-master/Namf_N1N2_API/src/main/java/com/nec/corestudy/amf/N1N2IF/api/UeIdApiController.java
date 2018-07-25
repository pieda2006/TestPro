package com.nec.corestudy.amf.N1N2IF.api;

import com.nec.corestudy.amf.N1N2IF.model.AMFN2PduSesReqData;
import com.nec.corestudy.amf.N1N2IF.model.AMFN2ResRelReqData;
import com.nec.corestudy.amf.N1N2IF.model.AMFRegistrationAccData;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-12T20:14:44.512+09:00")

@Controller
public class UeIdApiController implements UeIdApi {

    private static final Logger log = LoggerFactory.getLogger(UeIdApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UeIdApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> postN2PDUSessionRequest(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFN2PduSesReqData n2PduSesReqData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postN2ResourceReleaseRequest(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFN2ResRelReqData n2ResRelReqData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postRegistrationAccept(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFRegistrationAccData regAccData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
