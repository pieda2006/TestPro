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

import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ApiCallback;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ApiClient;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ApiException;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ApiResponse;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.Configuration;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.Pair;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ProgressRequestBody;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFProblemDetails;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFUEContextRelease;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReleaseUeContextApi {
    private ApiClient apiClient;

    public ReleaseUeContextApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ReleaseUeContextApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for postReleaseUEContext
     * @param ueContextId ueContextId. (required)
     * @param uEContextRelease Defines the UE Context to be created. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postReleaseUEContextCall(String ueContextId, AMFUEContextRelease uEContextRelease, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = uEContextRelease;

        // create path and map variables
        String localVarPath = "/ue-contexts/{ueContextId}/release"
            .replaceAll("\\{" + "ueContextId" + "\\}", apiClient.escapeString(ueContextId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
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
    private com.squareup.okhttp.Call postReleaseUEContextValidateBeforeCall(String ueContextId, AMFUEContextRelease uEContextRelease, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'ueContextId' is set
        if (ueContextId == null) {
            throw new ApiException("Missing the required parameter 'ueContextId' when calling postReleaseUEContext(Async)");
        }
        
        // verify the required parameter 'uEContextRelease' is set
        if (uEContextRelease == null) {
            throw new ApiException("Missing the required parameter 'uEContextRelease' when calling postReleaseUEContext(Async)");
        }
        

        com.squareup.okhttp.Call call = postReleaseUEContextCall(ueContextId, uEContextRelease, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Release UE Context
     * see 29.518 6.1.3.2
     * @param ueContextId ueContextId. (required)
     * @param uEContextRelease Defines the UE Context to be created. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void postReleaseUEContext(String ueContextId, AMFUEContextRelease uEContextRelease) throws ApiException {
        postReleaseUEContextWithHttpInfo(ueContextId, uEContextRelease);
    }

    /**
     * Release UE Context
     * see 29.518 6.1.3.2
     * @param ueContextId ueContextId. (required)
     * @param uEContextRelease Defines the UE Context to be created. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> postReleaseUEContextWithHttpInfo(String ueContextId, AMFUEContextRelease uEContextRelease) throws ApiException {
        com.squareup.okhttp.Call call = postReleaseUEContextValidateBeforeCall(ueContextId, uEContextRelease, null, null);
        return apiClient.execute(call);
    }

    /**
     * Release UE Context (asynchronously)
     * see 29.518 6.1.3.2
     * @param ueContextId ueContextId. (required)
     * @param uEContextRelease Defines the UE Context to be created. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postReleaseUEContextAsync(String ueContextId, AMFUEContextRelease uEContextRelease, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postReleaseUEContextValidateBeforeCall(ueContextId, uEContextRelease, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}