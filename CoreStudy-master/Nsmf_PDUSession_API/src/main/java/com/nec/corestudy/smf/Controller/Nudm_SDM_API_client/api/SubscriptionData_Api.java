/*
 * Nudm_SDM API
 * This is a UDM Server API.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * OpenAPI spec version: 0.6.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.api;

import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.ApiCallback;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.ApiClient;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.ApiException;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.ApiResponse;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.Configuration;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.Pair;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.ProgressRequestBody;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.model.SdmSubscription;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionData_Api {
    private ApiClient apiClient;

    public SubscriptionData_Api() {
        this(Configuration.getDefaultApiClient());
    }

    public SubscriptionData_Api(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for deleteSDMSubscription
     * @param supi Represents the Subscription Permanent Identifier.  (required)
     * @param subscriptionId The subscriptionId identifies an individual subscription to notifications. The value is allocated by the UDM  during creation of the Subscription resource. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteSDMSubscriptionCall(String supi, String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{supi}/sdm-subscriptions/{subscriptionId}"
            .replaceAll("\\{" + "supi" + "\\}", apiClient.escapeString(supi.toString()))
            .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/xml"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteSDMSubscriptionValidateBeforeCall(String supi, String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'supi' is set
        if (supi == null) {
            throw new ApiException("Missing the required parameter 'supi' when calling deleteSDMSubscription(Async)");
        }
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling deleteSDMSubscription(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteSDMSubscriptionCall(supi, subscriptionId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete the subscription identified by {subscriptionId}, i.e. unsubscribe.
     * Delete the subscription identified by {subscriptionId}, i.e. unsubscribe.
     * @param supi Represents the Subscription Permanent Identifier.  (required)
     * @param subscriptionId The subscriptionId identifies an individual subscription to notifications. The value is allocated by the UDM  during creation of the Subscription resource. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteSDMSubscription(String supi, String subscriptionId) throws ApiException {
        deleteSDMSubscriptionWithHttpInfo(supi, subscriptionId);
    }

    /**
     * Delete the subscription identified by {subscriptionId}, i.e. unsubscribe.
     * Delete the subscription identified by {subscriptionId}, i.e. unsubscribe.
     * @param supi Represents the Subscription Permanent Identifier.  (required)
     * @param subscriptionId The subscriptionId identifies an individual subscription to notifications. The value is allocated by the UDM  during creation of the Subscription resource. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteSDMSubscriptionWithHttpInfo(String supi, String subscriptionId) throws ApiException {
        com.squareup.okhttp.Call call = deleteSDMSubscriptionValidateBeforeCall(supi, subscriptionId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete the subscription identified by {subscriptionId}, i.e. unsubscribe. (asynchronously)
     * Delete the subscription identified by {subscriptionId}, i.e. unsubscribe.
     * @param supi Represents the Subscription Permanent Identifier.  (required)
     * @param subscriptionId The subscriptionId identifies an individual subscription to notifications. The value is allocated by the UDM  during creation of the Subscription resource. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteSDMSubscriptionAsync(String supi, String subscriptionId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteSDMSubscriptionValidateBeforeCall(supi, subscriptionId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for postSDMSubscription
     * @param supi . (required)
     * @param subdata The subscription that is to be created. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postSDMSubscriptionCall(String supi, SdmSubscription subdata, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = subdata;

        // create path and map variables
        String localVarPath = "/{supi}/sdm-subscriptions"
            .replaceAll("\\{" + "supi" + "\\}", apiClient.escapeString(supi.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/xml", "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/xml"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postSDMSubscriptionValidateBeforeCall(String supi, SdmSubscription subdata, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'supi' is set
        if (supi == null) {
            throw new ApiException("Missing the required parameter 'supi' when calling postSDMSubscription(Async)");
        }
        
        // verify the required parameter 'subdata' is set
        if (subdata == null) {
            throw new ApiException("Missing the required parameter 'subdata' when calling postSDMSubscription(Async)");
        }
        

        com.squareup.okhttp.Call call = postSDMSubscriptionCall(supi, subdata, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a subscription.
     * see 29.503 6.1.3.3. 
     * @param supi . (required)
     * @param subdata The subscription that is to be created. (required)
     * @return SdmSubscription
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SdmSubscription postSDMSubscription(String supi, SdmSubscription subdata) throws ApiException {
        ApiResponse<SdmSubscription> resp = postSDMSubscriptionWithHttpInfo(supi, subdata);
        return resp.getData();
    }

    /**
     * Create a subscription.
     * see 29.503 6.1.3.3. 
     * @param supi . (required)
     * @param subdata The subscription that is to be created. (required)
     * @return ApiResponse&lt;SdmSubscription&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SdmSubscription> postSDMSubscriptionWithHttpInfo(String supi, SdmSubscription subdata) throws ApiException {
        com.squareup.okhttp.Call call = postSDMSubscriptionValidateBeforeCall(supi, subdata, null, null);
        Type localVarReturnType = new TypeToken<SdmSubscription>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a subscription. (asynchronously)
     * see 29.503 6.1.3.3. 
     * @param supi . (required)
     * @param subdata The subscription that is to be created. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postSDMSubscriptionAsync(String supi, SdmSubscription subdata, final ApiCallback<SdmSubscription> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postSDMSubscriptionValidateBeforeCall(supi, subdata, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SdmSubscription>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}