package com.nec.corestudy.amf.RegistrationMng.api;

import com.nec.corestudy.amf.common.AMFcommon.*;
import com.nec.corestudy.amf.NamfUecmCLI.*;
import com.nec.corestudy.amf.NamfUecmCLI.model.*;
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

public class UecmAccess {

    private String uecm_path = null;
    private ApiClient ac = null;

    private static final Logger log = LoggerFactory.getLogger(UecmAccess.class);


    public UecmAccess(String uecm_path){
        log.debug("UecmAccess Constructor(uecm_path : {})",uecm_path);
        this.uecm_path = uecm_path;
        this.ac = new ApiClient();
    }

    public int UECM_Registration(String ueId, String[] auth, HttpHeaders header ) {
        log.debug("UECM_Registration START");
        log.debug("ueId : {}, auth : {}, header : {}", ueId, auth, header);

        //String destUri = udm_path + "nudm-uecm/v1/" + ueId + "/";
        String destUri = uecm_path + "nudm-uecm/v1/" + ueId + "/";
        log.debug("destUri : {}",destUri);

        Amf3GppAccessRegistration reqBody = new Amf3GppAccessRegistration();
        reqBody.setAmfId("AMF1");
        reqBody.setSupportedFeatures("DummySupportedFeatures");
        reqBody.setPurgeFlag(true);
        reqBody.setPei("DummyPei");
        reqBody.setImsVoPS(ImsVoPS.HOMOGENEOUS_SUPPORT);
        reqBody.setDeregCallbackUri(System.getenv("AMFPATH"));

        log.debug("reqBody is : {}",reqBody);

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("registrations/amf-3gpp-access", HttpMethod.PUT, null, reqBody, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<String>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}, reqBody : {}",destUri,reqBody);
            e.printStackTrace();
            log.error("UECM_Registration END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})",ac.getStatusCode());
        log.debug("UECM_Registration END(Jamf_OK)");
        return constants.Jamf_OK;
    }

}
