package com.nec.corestudy.amf.RegistrationMng.api;

import com.nec.corestudy.amf.common.AMFcommon.*;
import com.nec.corestudy.amf.NamfSdmCLI.*;
import com.nec.corestudy.amf.NamfSdmCLI.model.*;
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

public class SdmAccess {

    private String sdm_path = null;
    private ApiClient ac = null;

    private static final Logger log = LoggerFactory.getLogger(SdmAccess.class);


    public SdmAccess(String sdm_path){
        log.debug("SdmAccess Constructor(sdm_path : {})",sdm_path);
        this.sdm_path = sdm_path;
        this.ac = new ApiClient();
    }

    public AccessAndMobilitySubscriptionData SDM_GetAmData(String supi, String[] auth, HttpHeaders header) {
        log.debug("SDM_GetAmData START");
        log.debug("supi : {}, auth : {}, header :{}",supi, auth, header);

        //String destUri = udm_path + "nudm-sdm/v1/" + supi + "/";
        String destUri = sdm_path + "nudm-sdm/v1/" + supi + "/";
        log.debug("destUri : {}",destUri);

        /* request body is not supported */

        AccessAndMobilitySubscriptionData resp = null;

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            resp = ac.invokeAPI("am-data", HttpMethod.GET, null, null,
                                 header, null, accept, MediaType.APPLICATION_JSON, auth,
                                 new ParameterizedTypeReference<AccessAndMobilitySubscriptionData>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}",destUri);
            e.printStackTrace();
            log.error("SDM_GetAmData END (resp : {})", resp);
            return null;
        }
        log.debug("invokeAPI OK (status code : {})", ac.getStatusCode());
        log.debug("SDM_GetAmData END(resp : {})", resp );
        return resp;
    }

    public SmfSelectionSubscriptionData SDM_GetSmfSelData(String supi, String[] auth, HttpHeaders header) {
        log.debug("SDM_GetSmfSelData START");
        log.debug("supi : {}, auth : {}, header :{}",supi, auth, header);

        //String destUri = udm_path + "nudm-sdm/v1/" + supi + "/";
        String destUri = sdm_path + "nudm-sdm/v1/" + supi + "/";
        log.debug("destUri : {}",destUri);

        /* request body is not supported */

        SmfSelectionSubscriptionData resp = null;

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            resp = ac.invokeAPI("smf-select-data", HttpMethod.GET, null, null,
                                 header, null, accept, MediaType.APPLICATION_JSON, auth,
                                 new ParameterizedTypeReference<SmfSelectionSubscriptionData>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}",destUri);
            e.printStackTrace();
            log.error("SDM_GetSmfSelData END (resp : {})", resp);
            return null;
        }
        log.debug("invokeAPI OK (status code : {})", ac.getStatusCode());
        log.debug("SDM_GetSmfSelData END(resp : {})", resp );
        return resp;
    }

    public UeContextInSmfData SDM_GetUCSmfData(String supi, String[] auth, HttpHeaders header) {
        log.debug("SDM_GetUCSmfData START");
        log.debug("supi : {}, auth : {}, header :{}",supi, auth, header);

        //String destUri = udm_path + "nudm-sdm/v1/" + supi + "/";
        String destUri = sdm_path + "nudm-sdm/v1/" + supi + "/";
        log.debug("destUri : {}",destUri);

        /* request body is not supported */

        UeContextInSmfData resp = null;

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            resp = ac.invokeAPI("ue-context-in-smf-data", HttpMethod.GET, null, null,
                                 header, null, accept, MediaType.APPLICATION_JSON, auth,
                                 new ParameterizedTypeReference<UeContextInSmfData>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}",destUri);
            e.printStackTrace();
            log.error("SDM_GetUCSmfData END (resp : {})", resp);
            return null;
        }
        log.debug("invokeAPI OK (status code : {})", ac.getStatusCode());
        log.debug("SDM_GetUCSmfData END(resp : {})", resp );
        return resp;
    }

    public int SDM_Subscribe(String supi, String[] auth, HttpHeaders header) {
        log.debug("SDM_Subscribe START");
        log.debug("supi : {}, auth : {}, header :{}",supi, auth, header);

        String destUri = sdm_path + "nudm-sdm/v1/" + supi + "/";
        log.debug("destUri : {}",destUri);

        SdmSubscription reqBody = new SdmSubscription();
        List monResourceUri = new ArrayList<String>();
        reqBody.setCallbackReference("CallBack");
        reqBody.setMonitoredResourceUri(monResourceUri);
        log.debug("reqBody : {}", reqBody);

        ac.setBasePath(destUri);
        try {
            List<MediaType> accept = new ArrayList<>();
            accept.add(MediaType.APPLICATION_JSON);
            ac.invokeAPI( "sdm-subscriptions", HttpMethod.POST, null, reqBody,
                           header, null, accept, MediaType.APPLICATION_JSON, auth,
                           new ParameterizedTypeReference<String>(){});
        } catch ( RestClientException e ) {
            log.error("invokeAPI NG (status code : {})", ac.getStatusCode());
            log.error("URI : {}",destUri);
            e.printStackTrace();
            log.error("SDM_Subscribe END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("invokeAPI OK (status code : {})", ac.getStatusCode());
        log.debug("SDM_Subscribe END(Jamf_OK)");
        return constants.Jamf_OK;
    }

}
