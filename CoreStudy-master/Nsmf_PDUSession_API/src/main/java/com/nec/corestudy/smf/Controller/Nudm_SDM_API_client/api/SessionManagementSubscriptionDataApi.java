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


import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.model.SessionManagementSubscriptionData;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.model.SmsSubscriptionData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionManagementSubscriptionDataApi {
    private ApiClient apiClient;

    public SessionManagementSubscriptionDataApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SessionManagementSubscriptionDataApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getSmData
     * @param supi  (required)
     * @param supportedFeatures [TBD]. (optional)
     * @param singleNssai [TBD]. (optional)
     * @param dnn [TBD]. (optional)
     * @param plmnId [TBD]. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getSmDataCall(String supi, String supportedFeatures, String singleNssai, String dnn, String plmnId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{supi}/sm-data"
            .replaceAll("\\{" + "supi" + "\\}", apiClient.escapeString(supi.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (supportedFeatures != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("supportedFeatures", supportedFeatures));
        if (singleNssai != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("singleNssai", singleNssai));
        if (dnn != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dnn", dnn));
        if (plmnId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("plmn-id", plmnId));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSmDataValidateBeforeCall(String supi, String supportedFeatures, String singleNssai, String dnn, String plmnId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'supi' is set
        if (supi == null) {
            throw new ApiException("Missing the required parameter 'supi' when calling getSmData(Async)");
        }
        

        com.squareup.okhttp.Call call = getSmDataCall(supi, supportedFeatures, singleNssai, dnn, plmnId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * SessionManagementSubscriptionData
     * see 29.503 6.1.3.8
     * @param supi  (required)
     * @param supportedFeatures [TBD]. (optional)
     * @param singleNssai [TBD]. (optional)
     * @param dnn [TBD]. (optional)
     * @param plmnId [TBD]. (optional)
     * @return List&lt;SessionManagementSubscriptionData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<SessionManagementSubscriptionData> getSmData(String supi, String supportedFeatures, String singleNssai, String dnn, String plmnId) throws ApiException {
        ApiResponse<List<SessionManagementSubscriptionData>> resp = getSmDataWithHttpInfo(supi, supportedFeatures, singleNssai, dnn, plmnId);
        return resp.getData();
    }

    /**
     * SessionManagementSubscriptionData
     * see 29.503 6.1.3.8
     * @param supi  (required)
     * @param supportedFeatures [TBD]. (optional)
     * @param singleNssai [TBD]. (optional)
     * @param dnn [TBD]. (optional)
     * @param plmnId [TBD]. (optional)
     * @return ApiResponse&lt;List&lt;SessionManagementSubscriptionData&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<SessionManagementSubscriptionData>> getSmDataWithHttpInfo(String supi, String supportedFeatures, String singleNssai, String dnn, String plmnId) throws ApiException {
        com.squareup.okhttp.Call call = getSmDataValidateBeforeCall(supi, supportedFeatures, singleNssai, dnn, plmnId, null, null);
        Type localVarReturnType = new TypeToken<List<SessionManagementSubscriptionData>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * SessionManagementSubscriptionData (asynchronously)
     * see 29.503 6.1.3.8
     * @param supi  (required)
     * @param supportedFeatures [TBD]. (optional)
     * @param singleNssai [TBD]. (optional)
     * @param dnn [TBD]. (optional)
     * @param plmnId [TBD]. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSmDataAsync(String supi, String supportedFeatures, String singleNssai, String dnn, String plmnId, final ApiCallback<List<SessionManagementSubscriptionData>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getSmDataValidateBeforeCall(supi, supportedFeatures, singleNssai, dnn, plmnId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<SessionManagementSubscriptionData>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getSmsData
     * @param supi  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getSmsDataCall(String supi, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{supi}/sms-data"
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSmsDataValidateBeforeCall(String supi, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'supi' is set
        if (supi == null) {
            throw new ApiException("Missing the required parameter 'supi' when calling getSmsData(Async)");
        }
        

        com.squareup.okhttp.Call call = getSmsDataCall(supi, progressListener, progressRequestListener);
        return call;

    }

    /**
     * SessionManagementSubscriptionData
     * see 29.503 6.1.3.9
     * @param supi  (required)
     * @return SmsSubscriptionData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SmsSubscriptionData getSmsData(String supi) throws ApiException {
        ApiResponse<SmsSubscriptionData> resp = getSmsDataWithHttpInfo(supi);
        return resp.getData();
    }

    /**
     * SessionManagementSubscriptionData
     * see 29.503 6.1.3.9
     * @param supi  (required)
     * @return ApiResponse&lt;SmsSubscriptionData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SmsSubscriptionData> getSmsDataWithHttpInfo(String supi) throws ApiException {
        com.squareup.okhttp.Call call = getSmsDataValidateBeforeCall(supi, null, null);
        Type localVarReturnType = new TypeToken<SmsSubscriptionData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * SessionManagementSubscriptionData (asynchronously)
     * see 29.503 6.1.3.9
     * @param supi  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSmsDataAsync(String supi, final ApiCallback<SmsSubscriptionData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getSmsDataValidateBeforeCall(supi, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SmsSubscriptionData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}