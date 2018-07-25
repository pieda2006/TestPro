package com.nec.corestudy.gnb.GTPU_GNB1.api;

import com.nec.corestudy.gnb.GTPU_GNB1.model.CreategtpuGnb;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-12T14:03:16.070+09:00")

@Controller
public class TeidApiController implements TeidApi {

    private static final Logger log = LoggerFactory.getLogger(TeidApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TeidApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> tunnelCreate(@ApiParam(value = "",required=true) @PathVariable("teid") Integer teid,@ApiParam(value = "" ,required=true )  @Valid @RequestBody CreategtpuGnb body) {
        String accept = request.getHeader("Accept");
        log.info("recv tunnelCreate(teid : {})",teid);
        log.info("body : {}",body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> tunnelDelete(@ApiParam(value = "",required=true) @PathVariable("teid") Integer teid) {
        String accept = request.getHeader("Accept");
        log.info("recv tunnelDelete(teid : {})",teid);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
