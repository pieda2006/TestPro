package com.nec.corestudy.amf.RegistrationMng.api;

import com.nec.corestudy.amf.common.AMFcommon.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PcfAccess {

    private String pcf_path = null;
//    private ApiClient ac = null;

    private static final Logger log = LoggerFactory.getLogger(PcfAccess.class);


    public PcfAccess(String pcf_path){
        log.debug("PcfAccess Constructor (pcf_path : {})", pcf_path);
        this.pcf_path = pcf_path;
        //this.ac = new ApiClient();
    }

    /* AM Policy Association Establishment with new Selected PCF */
    public String AMPolicyAssociationEst( ) {

        return "[PDU selection policy information]";
    }

}
