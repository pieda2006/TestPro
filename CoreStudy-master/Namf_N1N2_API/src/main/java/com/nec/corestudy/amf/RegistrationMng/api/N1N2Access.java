package com.nec.corestudy.amf.RegistrationMng.api;

import com.nec.corestudy.amf.common.AMFcommon.*;
import com.nec.corestudy.amf.N1N2IF_CLI.*;
import com.nec.corestudy.amf.N1N2IF_CLI.model.*;
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

public class N1N2Access {

    private String n1n2_path = null;
    private ApiClient ac = null;

    private static final Logger log = LoggerFactory.getLogger(N1N2Access.class);


    public N1N2Access(){
        log.debug("N1N2Access Constructor");
        this.n1n2_path = System.getenv("N1N2PATH");
        this.ac = new ApiClient();
    }

    public int N1N2_RegistrationAccept(String ueId, String[] auth, HttpHeaders header ) {
        log.debug("N1N2_RegistrationAccept START");
        log.debug("ueId : {}, auth : {}, header : {}", ueId, auth, header);

        String destUri = n1n2_path + "namf-n1n2if/v1/" + ueId + "/";
        log.debug("destUri : {}",destUri);

        AMFRegistrationAccData reqData = new AMFRegistrationAccData();
        log.debug("reqData : {}", reqData);

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI("registration/accept", HttpMethod.POST, null, reqData, header, null, accept,
                         MediaType.APPLICATION_JSON, auth, new ParameterizedTypeReference<String>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}, reqData : {}",destUri, reqData);
            e.printStackTrace();
            log.error("N1N2_RegistrationAccept END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})",ac.getStatusCode());
        log.debug("N1N2_RegistrationAccept END(Jamf_OK)");
        return constants.Jamf_OK;
    }

}
