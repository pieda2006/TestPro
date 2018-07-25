package com.nec.corestudy.pcf.api;


import com.nec.corestudy.pcf.model.PolicyAssociation;
import com.nec.corestudy.pcf.model.PolicyAssociationRequest;
import com.nec.corestudy.pcf.model.PolicyAssociationUpdateRequest;
import com.nec.corestudy.pcf.model.PolicyUpdate;
import com.nec.corestudy.pcf.model.ProblemDetails;



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
    


@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

@Controller

public class PoliciesApiController implements PoliciesApi {



    
    private static final Logger log = LoggerFactory.getLogger(PoliciesApiController.class);

    
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PoliciesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    




    public ResponseEntity<?> policiesPolAssoIdDelete(@ApiParam(value = "Identifier of a policy association",required=true) @PathVariable("polAssoId") String polAssoId) {
        
        
        String accept = request.getHeader("Accept");
        
        return new ResponseEntity<?>(HttpStatus.NOT_IMPLEMENTED);
        
        
        
        
    }


    public ResponseEntity<?> policiesPolAssoIdGet(@ApiParam(value = "Identifier of a policy association",required=true) @PathVariable("polAssoId") String polAssoId) {
        
        
        String accept = request.getHeader("Accept");
        
        return new ResponseEntity<?>(HttpStatus.NOT_IMPLEMENTED);
        
        
        
        
    }


    public ResponseEntity<?> policiesPolAssoIdUpdatePost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody PolicyAssociationUpdateRequest body,@ApiParam(value = "Identifier of a policy association",required=true) @PathVariable("polAssoId") String polAssoId) {
        
        
        String accept = request.getHeader("Accept");
        
        return new ResponseEntity<?>(HttpStatus.NOT_IMPLEMENTED);
        
        
        
        
    }


    public ResponseEntity<?> policiesPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody PolicyAssociationRequest body) {
        
        
        String accept = request.getHeader("Accept");
        
        return new ResponseEntity<?>(HttpStatus.NOT_IMPLEMENTED);
        
        
        
        
    }



}

