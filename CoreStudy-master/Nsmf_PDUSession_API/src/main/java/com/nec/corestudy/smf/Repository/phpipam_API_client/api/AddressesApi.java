/*
 * phpipam API(for SMF)
 * phpipam API(for SMF)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Repository.phpipam_API_client.api;

import com.nec.corestudy.smf.Repository.phpipam_API_client.ApiCallback;
import com.nec.corestudy.smf.Repository.phpipam_API_client.ApiClient;
import com.nec.corestudy.smf.Repository.phpipam_API_client.ApiException;
import com.nec.corestudy.smf.Repository.phpipam_API_client.ApiResponse;
import com.nec.corestudy.smf.Repository.phpipam_API_client.Configuration;
import com.nec.corestudy.smf.Repository.phpipam_API_client.Pair;
import com.nec.corestudy.smf.Repository.phpipam_API_client.ProgressRequestBody;
import com.nec.corestudy.smf.Repository.phpipam_API_client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.nec.corestudy.smf.Repository.phpipam_API_client.model.CreateNewAddressData;
import com.nec.corestudy.smf.Repository.phpipam_API_client.model.DeleteAddressData;
import com.nec.corestudy.smf.Repository.phpipam_API_client.model.SubnetsAddressData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressesApi {
    private ApiClient apiClient;

    public AddressesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AddressesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createsNewAddressInSubnets
     * @param subnetId  (required)
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createsNewAddressInSubnetsCall(Integer subnetId, CreateNewAddressData body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/addresses/first_free/{subnetId}/"
            .replaceAll("\\{" + "subnetId" + "\\}", apiClient.escapeString(subnetId.toString()));

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

        String[] localVarAuthNames = new String[] { "api_token", "id_pass" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createsNewAddressInSubnetsValidateBeforeCall(Integer subnetId, CreateNewAddressData body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'subnetId' is set
        if (subnetId == null) {
            throw new ApiException("Missing the required parameter 'subnetId' when calling createsNewAddressInSubnets(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling createsNewAddressInSubnets(Async)");
        }
        

        com.squareup.okhttp.Call call = createsNewAddressInSubnetsCall(subnetId, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Creates new address in subnets
     * Creates new address in subnets – first available (subnetId can be provided with parameters) 
     * @param subnetId  (required)
     * @param body  (required)
     * @return SubnetsAddressData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubnetsAddressData createsNewAddressInSubnets(Integer subnetId, CreateNewAddressData body) throws ApiException {
        ApiResponse<SubnetsAddressData> resp = createsNewAddressInSubnetsWithHttpInfo(subnetId, body);
        return resp.getData();
    }

    /**
     * Creates new address in subnets
     * Creates new address in subnets – first available (subnetId can be provided with parameters) 
     * @param subnetId  (required)
     * @param body  (required)
     * @return ApiResponse&lt;SubnetsAddressData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubnetsAddressData> createsNewAddressInSubnetsWithHttpInfo(Integer subnetId, CreateNewAddressData body) throws ApiException {
        com.squareup.okhttp.Call call = createsNewAddressInSubnetsValidateBeforeCall(subnetId, body, null, null);
        Type localVarReturnType = new TypeToken<SubnetsAddressData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Creates new address in subnets (asynchronously)
     * Creates new address in subnets – first available (subnetId can be provided with parameters) 
     * @param subnetId  (required)
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createsNewAddressInSubnetsAsync(Integer subnetId, CreateNewAddressData body, final ApiCallback<SubnetsAddressData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createsNewAddressInSubnetsValidateBeforeCall(subnetId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubnetsAddressData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deletesAddress
     * @param id  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deletesAddressCall(Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/addresses/{id}/"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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

        String[] localVarAuthNames = new String[] { "api_token", "id_pass" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deletesAddressValidateBeforeCall(Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deletesAddress(Async)");
        }
        

        com.squareup.okhttp.Call call = deletesAddressCall(id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes address
     * Deletes address use &#39;remove_dns&#x3D;1&#39; parameter to remove all related DNS records 1.3  
     * @param id  (required)
     * @return DeleteAddressData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeleteAddressData deletesAddress(Integer id) throws ApiException {
        ApiResponse<DeleteAddressData> resp = deletesAddressWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Deletes address
     * Deletes address use &#39;remove_dns&#x3D;1&#39; parameter to remove all related DNS records 1.3  
     * @param id  (required)
     * @return ApiResponse&lt;DeleteAddressData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeleteAddressData> deletesAddressWithHttpInfo(Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deletesAddressValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<DeleteAddressData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes address (asynchronously)
     * Deletes address use &#39;remove_dns&#x3D;1&#39; parameter to remove all related DNS records 1.3  
     * @param id  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deletesAddressAsync(Integer id, final ApiCallback<DeleteAddressData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deletesAddressValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DeleteAddressData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deletesAddressByIPInSubnet
     * @param ip  (required)
     * @param subnetId  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deletesAddressByIPInSubnetCall(String ip, Integer subnetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/addresses/{ip}/{subnetId}/"
            .replaceAll("\\{" + "ip" + "\\}", apiClient.escapeString(ip.toString()))
            .replaceAll("\\{" + "subnetId" + "\\}", apiClient.escapeString(subnetId.toString()));

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

        String[] localVarAuthNames = new String[] { "api_token", "id_pass" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deletesAddressByIPInSubnetValidateBeforeCall(String ip, Integer subnetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'ip' is set
        if (ip == null) {
            throw new ApiException("Missing the required parameter 'ip' when calling deletesAddressByIPInSubnet(Async)");
        }
        
        // verify the required parameter 'subnetId' is set
        if (subnetId == null) {
            throw new ApiException("Missing the required parameter 'subnetId' when calling deletesAddressByIPInSubnet(Async)");
        }
        

        com.squareup.okhttp.Call call = deletesAddressByIPInSubnetCall(ip, subnetId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes address
     * Deletes address by IP in specific subnet
     * @param ip  (required)
     * @param subnetId  (required)
     * @return DeleteAddressData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeleteAddressData deletesAddressByIPInSubnet(String ip, Integer subnetId) throws ApiException {
        ApiResponse<DeleteAddressData> resp = deletesAddressByIPInSubnetWithHttpInfo(ip, subnetId);
        return resp.getData();
    }

    /**
     * Deletes address
     * Deletes address by IP in specific subnet
     * @param ip  (required)
     * @param subnetId  (required)
     * @return ApiResponse&lt;DeleteAddressData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeleteAddressData> deletesAddressByIPInSubnetWithHttpInfo(String ip, Integer subnetId) throws ApiException {
        com.squareup.okhttp.Call call = deletesAddressByIPInSubnetValidateBeforeCall(ip, subnetId, null, null);
        Type localVarReturnType = new TypeToken<DeleteAddressData>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deletes address (asynchronously)
     * Deletes address by IP in specific subnet
     * @param ip  (required)
     * @param subnetId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deletesAddressByIPInSubnetAsync(String ip, Integer subnetId, final ApiCallback<DeleteAddressData> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deletesAddressByIPInSubnetValidateBeforeCall(ip, subnetId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DeleteAddressData>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}