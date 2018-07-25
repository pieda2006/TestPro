package com.nec.corestudy.amf.CommunicationMng.api;

import com.nec.corestudy.amf.NamfSmfCLI.*;
import com.nec.corestudy.amf.NamfSmfCLI.model.*;
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



public class smfAccess {

    private String smf_path = null;
    private ApiClient ac = null;

    private static final Logger log = LoggerFactory.getLogger(smfAccess.class);

    public smfAccess( ){
        log.debug("smfAccess Constructor");
        this.smf_path = System.getenv("SMFPATH");
        this.ac = new ApiClient();
    }


    public int updateSmContext(String smContextRef, String[] auth, HttpHeaders header ) {
        log.debug("updateSmContext START");
        log.debug("smContextRef : {}, auth : {}, header : {}", smContextRef, auth, header);

        String destUri = smf_path + "nsmf-pdusession/v1/sm-contexts/" + smContextRef + "/";
        log.debug("destUri : {}",destUri);

        SmContextUpdateData reqData = new SmContextUpdateData();

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("", HttpMethod.PATCH, null, reqData, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<SmContextUpdatedData>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}, reqData : {}", destUri, reqData);
            e.printStackTrace();
            log.error("updateSmContext END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})",ac.getStatusCode());
        log.debug("updateSmContext END(Jamf_OK)");
        return constants.Jamf_OK;
    }


}


