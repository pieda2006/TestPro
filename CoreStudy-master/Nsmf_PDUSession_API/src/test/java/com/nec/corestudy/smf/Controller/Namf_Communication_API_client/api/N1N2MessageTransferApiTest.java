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
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageTransferError;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageTransferRspData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFProblemDetails;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for N1N2MessageTransferApi
 */
@Ignore
public class N1N2MessageTransferApiTest {

    private final N1N2MessageTransferApi api = new N1N2MessageTransferApi();

    
    /**
     * N1 N2 Message Transfer
     *
     * see 29.518 6.1.3.10
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postN1N2MessageTransferTest() throws ApiException {
        String ueContextId = null;
        AMFN1N2MessageData n1N2MessageData = null;
        AMFN1N2MessageTransferRspData response = api.postN1N2MessageTransfer(ueContextId, n1N2MessageData);

        // TODO: test validations
    }
    
}