/*
 * Namf_Communication API
 * This is a AMF Server API.   [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * OpenAPI spec version: 1.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Controller.Namf_Communication_API_client.api;

import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ApiException;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFAssignEbiData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFAssignEbiError;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFAssignedEbiData;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EbiAssignmentApi
 */
@Ignore
public class EbiAssignmentApiTest {

    private final EbiAssignmentApi api = new EbiAssignmentApi();

    
    /**
     * EBI Assignment
     *
     * see 29.518 6.1.3.2
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postEBIAssignmentTest() throws ApiException {
        String ueContextId = null;
        AMFAssignEbiData assignEbiData = null;
        AMFAssignedEbiData response = api.postEBIAssignment(ueContextId, assignEbiData);

        // TODO: test validations
    }
    
}