/*
 * gtpu_upf1
 * 21_add_gtpu_upf1.sh
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Controller.VPPUPF_API_client.api;

import com.nec.corestudy.smf.Controller.VPPUPF_API_client.ApiCallback;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.ApiClient;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.ApiException;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.ApiResponse;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.Configuration;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.Pair;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.ProgressRequestBody;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.nec.corestudy.smf.Controller.VPPUPF_API_client.model.CreategtpuUpf;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TunnelCreateApi {
    private ApiClient apiClient;

    public TunnelCreateApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TunnelCreateApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for tunnelCreate
     * @param teid  (required)
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call tunnelCreateCall(Integer teid, CreategtpuUpf body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/{teid}/"
            .replaceAll("\\{" + "teid" + "\\}", apiClient.escapeString(teid.toString()));

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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call tunnelCreateValidateBeforeCall(Integer teid, CreategtpuUpf body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'teid' is set
        if (teid == null) {
            throw new ApiException("Missing the required parameter 'teid' when calling tunnelCreate(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling tunnelCreate(Async)");
        }
        

        com.squareup.okhttp.Call call = tunnelCreateCall(teid, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Tunnel Create
     * 
     * @param teid  (required)
     * @param body  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void tunnelCreate(Integer teid, CreategtpuUpf body) throws ApiException {
        tunnelCreateWithHttpInfo(teid, body);
    }

    /**
     * Tunnel Create
     * 
     * @param teid  (required)
     * @param body  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> tunnelCreateWithHttpInfo(Integer teid, CreategtpuUpf body) throws ApiException {
        com.squareup.okhttp.Call call = tunnelCreateValidateBeforeCall(teid, body, null, null);
        return apiClient.execute(call);
    }

    /**
     * Tunnel Create (asynchronously)
     * 
     * @param teid  (required)
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call tunnelCreateAsync(Integer teid, CreategtpuUpf body, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = tunnelCreateValidateBeforeCall(teid, body, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}