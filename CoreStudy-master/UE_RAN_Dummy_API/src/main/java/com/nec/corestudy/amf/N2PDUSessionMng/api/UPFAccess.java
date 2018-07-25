package com.nec.corestudy.amf.N2PDUSessionMng.api;

import com.nec.corestudy.amf.GTPU_GNB1_CLI.*;
import com.nec.corestudy.amf.GTPU_GNB1_CLI.api.*;
import com.nec.corestudy.amf.GTPU_GNB1_CLI.model.*;
import com.nec.corestudy.amf.common.AMFcommon.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
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



public class UPFAccess{
    private String upf_path = null;
    private ApiClient ac = null;

    public static final Logger log = LoggerFactory.getLogger(UPFAccess.class);

    public UPFAccess(String upf_path){
        log.debug("UPFAccess Constructor");
        this.upf_path = upf_path;
        this.ac = new ApiClient();
    }

    public int tunnelCreate(String teId, CreategtpuGnb reqData, String[] auth, HttpHeaders header){
        log.debug("tunnelCreate START");
        log.debug("teID : {}, reqData : {}, auth : {}, header : {}",teId, reqData, auth, header);

        if(null == teId){
            log.error("teId is NULL");
            return constants.Jamf_NG;
        }
        if(null == reqData){
            log.error("reqData is NULL");
            return constants.Jamf_NG;
        }

        String destUri = upf_path + "/gnb1/gtpu/" + teId + "/";
        ac.setBasePath(destUri);
        log.debug("destUri : {}", destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("", HttpMethod.PUT, null, reqData, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<String>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}, reqData : {}", destUri, reqData);
            e.printStackTrace();
            log.error("tunnelCreate END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})",ac.getStatusCode());
        log.debug("tunnelCreate END(Jamf_OK)");
        return constants.Jamf_OK;

    }

    public int tunnelDelete(String teId, String[] auth, HttpHeaders header){
        log.debug("tunnelDelete START");
        log.debug("teID : {}, auth : {}, header : {}",teId, auth, header);

        if(null == teId){
            log.error("teId is NULL");
            return constants.Jamf_NG;
        }

        String destUri = upf_path + "/gnb1/gtpu/" + teId + "/";
        ac.setBasePath(destUri);
        log.debug("destUri : {}", destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("", HttpMethod.DELETE, null, null, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<String>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}" , destUri);
            e.printStackTrace();
            log.error("tunnelDelete END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})",ac.getStatusCode());
        log.debug("tunnelDelete END(Jamf_OK)");
        return constants.Jamf_OK;

    }


}

