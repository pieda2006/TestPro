package com.nec.corestudy.amf.PduSesEstablishMng.api;

import com.nec.corestudy.amf.common.AMFcommon.*;
import com.nec.corestudy.amf.NamfSmfCLI.*;
import com.nec.corestudy.amf.NamfSmfCLI.model.*;
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

public class SmfAccess {
    private String smf_path = null;
    private ApiClient ac = null;

    private static final Logger log = LoggerFactory.getLogger(SmfAccess.class);

    public SmfAccess(String smf_path){
        this.smf_path = smf_path;
        this.ac = new ApiClient();
    }

    public int PDU_CreSMContext(SmContextCreateData reqBody, String[] auth, HttpHeaders header){
        log.debug("PDU_CreSMContext START");
        log.debug("reqBody : {}, auth : {}, header : {}",reqBody, auth, header);

        if(null == reqBody){
            log.error("SmContextCreateData is NULL");
            return constants.Jamf_NG;
        }
        String destUri = smf_path + "nsmf-pdusession/v1/sm-contexts";
        log.debug("destUri : {}",destUri);

        ac.setBasePath(destUri);
        try {
//            ac.invokeAPI("", HttpMethod.POST, null, reqBody,
//                          header, null, null, null, auth, new ParameterizedTypeReference<SmContextCreatedData>(){});
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("", HttpMethod.POST, null, reqBody, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<SmContextCreatedData>(){});

        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}, reqBody : {}",destUri, reqBody);
            e.printStackTrace();
            log.error("PDU_CreSMContext END (Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})", ac.getStatusCode());
        log.debug("PDU_CreSMContext END(Jamf_OK)");
        return constants.Jamf_OK;
    }

    public int PDU_RelSMContext(String supi, SmContextReleaseData reqBody, String[] auth, HttpHeaders header){
        log.debug("PDU_RelSMContext START");
        log.debug("reqBody : {}, auth : {}, header : {}",reqBody, auth, header);

        if(null == reqBody){
            log.error("SmContextReleaseData is NULL");
            return constants.Jamf_NG;
        }
        String destUri = smf_path + "nsmf-pdusession/v1/sm-contexts/" + supi +"/release";
        log.debug("destUri : {}",destUri);

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("", HttpMethod.POST, null, reqBody, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<SmContextReleasedData>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}, reqBody : {}",destUri, reqBody);
            e.printStackTrace();
            log.error("PDU_RelSMContext END (Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})", ac.getStatusCode());
        log.debug("PDU_RelSMContext END(Jamf_OK)");
        return constants.Jamf_OK;
    }

}



