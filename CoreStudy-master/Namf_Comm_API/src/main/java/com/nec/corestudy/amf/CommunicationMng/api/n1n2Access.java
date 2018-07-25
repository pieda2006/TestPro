package com.nec.corestudy.amf.CommunicationMng.api;

import com.nec.corestudy.amf.N1N2IF_CLI.*;
import com.nec.corestudy.amf.N1N2IF_CLI.model.*;
import com.nec.corestudy.amf.NamfCommunication.model.*;
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



public class n1n2Access {

    private String n1n2_path = null;
    private ApiClient ac = null;

    private static final Logger log = LoggerFactory.getLogger(n1n2Access.class);

    public n1n2Access( ){
        log.debug("n1n2Access Constructor");
        this.n1n2_path = System.getenv("N1N2PATH");
        this.ac = new ApiClient();
    }


    public int N2pduSessionRequest(String ueId, AMFN2PduSesReqData reqData, String[] auth, HttpHeaders header ) {
        log.debug("N2pduSessionRequest START");
        log.debug("ueId : {}, reqData : {}, auth : {}, header : {}", ueId, reqData, auth, header);

        String destUri = n1n2_path + "namf-n1n2if/v1/" + ueId + "/";
        log.debug("destUri : {}",destUri);

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("n2pdu-session/request", HttpMethod.POST, null, reqData, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<String>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})",ac.getStatusCode());
            log.error("URI : {}, reqData : {}", destUri, reqData);
            e.printStackTrace();
            log.error("N2pduSessionRequest END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})",ac.getStatusCode());
        log.debug("N2pduSessionRequest END(Jamf_OK)");
        return constants.Jamf_OK;
    }


    public int N2ResourceRelease(String ueId, AMFN2ResRelReqData reqData, String[] auth, HttpHeaders header ) {
        log.debug("N2ResourceRelease START");
        log.debug("ueId : {}, reqData : {}, auth : {}, header : {}", ueId, reqData, auth, header);

        String destUri = n1n2_path + "namf-n1n2if/v1/" + ueId + "/";
        log.debug("destUri : {}",destUri);

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("n2resource-release/request", HttpMethod.POST, null, reqData, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<String>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})",ac.getStatusCode());
            log.error("URI : {}, reqData : {}", destUri, reqData);
            e.printStackTrace();
            log.error("N2ResourceRelease END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})",ac.getStatusCode());
        log.debug("N2ResourceRelease END(Jamf_OK)");
        return constants.Jamf_OK;
    }
}


