/*
 * Nudm_UECM API
 * This is a UDM Server API.   [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * OpenAPI spec version: 0.6.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.api;

import com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.ApiException;
import com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.model.SmfRegistration;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for IndividualSmfRegistrationApi
 */
@Ignore
public class IndividualSmfRegistrationApiTest {

    private final IndividualSmfRegistrationApi api = new IndividualSmfRegistrationApi();

    
    /**
     * individual-smf-registration.
     *
     * see 29.503 6.2.3.5
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteIndividualSmfRegistrationTest() throws ApiException {
        String ueId = null;
        String pduSessionId = null;
        api.deleteIndividualSmfRegistration(ueId, pduSessionId);

        // TODO: test validations
    }
    
    /**
     * individual-smf-registration.
     *
     * see 29.503 6.2.3.5
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void putIndividualSmfRegistrationTest() throws ApiException {
        String ueId = null;
        String pduSessionId = null;
        SmfRegistration smfRegistration = null;
        SmfRegistration response = api.putIndividualSmfRegistration(ueId, pduSessionId, smfRegistration);

        // TODO: test validations
    }
    
}