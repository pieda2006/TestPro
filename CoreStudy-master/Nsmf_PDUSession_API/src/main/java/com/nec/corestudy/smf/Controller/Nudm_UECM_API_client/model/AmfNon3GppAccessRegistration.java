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


package com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * AmfNon3GppAccessRegistration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-21T18:27:47.006+09:00")
public class AmfNon3GppAccessRegistration {
  @SerializedName("amfId")
  private String amfId = null;

  @SerializedName("supportedFeatures")
  private String supportedFeatures = null;

  @SerializedName("purgeFlag")
  private Boolean purgeFlag = null;

  @SerializedName("pei")
  private String pei = null;

  @SerializedName("deregCallbackUri")
  private String deregCallbackUri = null;

  public AmfNon3GppAccessRegistration amfId(String amfId) {
    this.amfId = amfId;
    return this;
  }

   /**
   * Get amfId
   * @return amfId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getAmfId() {
    return amfId;
  }

  public void setAmfId(String amfId) {
    this.amfId = amfId;
  }

  public AmfNon3GppAccessRegistration supportedFeatures(String supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
    return this;
  }

   /**
   * Get supportedFeatures
   * @return supportedFeatures
  **/
  @ApiModelProperty(value = "")
  public String getSupportedFeatures() {
    return supportedFeatures;
  }

  public void setSupportedFeatures(String supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
  }

  public AmfNon3GppAccessRegistration purgeFlag(Boolean purgeFlag) {
    this.purgeFlag = purgeFlag;
    return this;
  }

   /**
   * Get purgeFlag
   * @return purgeFlag
  **/
  @ApiModelProperty(value = "")
  public Boolean isPurgeFlag() {
    return purgeFlag;
  }

  public void setPurgeFlag(Boolean purgeFlag) {
    this.purgeFlag = purgeFlag;
  }

  public AmfNon3GppAccessRegistration pei(String pei) {
    this.pei = pei;
    return this;
  }

   /**
   * Get pei
   * @return pei
  **/
  @ApiModelProperty(value = "")
  public String getPei() {
    return pei;
  }

  public void setPei(String pei) {
    this.pei = pei;
  }

  public AmfNon3GppAccessRegistration deregCallbackUri(String deregCallbackUri) {
    this.deregCallbackUri = deregCallbackUri;
    return this;
  }

   /**
   * Get deregCallbackUri
   * @return deregCallbackUri
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDeregCallbackUri() {
    return deregCallbackUri;
  }

  public void setDeregCallbackUri(String deregCallbackUri) {
    this.deregCallbackUri = deregCallbackUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmfNon3GppAccessRegistration amfNon3GppAccessRegistration = (AmfNon3GppAccessRegistration) o;
    return Objects.equals(this.amfId, amfNon3GppAccessRegistration.amfId) &&
        Objects.equals(this.supportedFeatures, amfNon3GppAccessRegistration.supportedFeatures) &&
        Objects.equals(this.purgeFlag, amfNon3GppAccessRegistration.purgeFlag) &&
        Objects.equals(this.pei, amfNon3GppAccessRegistration.pei) &&
        Objects.equals(this.deregCallbackUri, amfNon3GppAccessRegistration.deregCallbackUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amfId, supportedFeatures, purgeFlag, pei, deregCallbackUri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmfNon3GppAccessRegistration {\n");
    
    sb.append("    amfId: ").append(toIndentedString(amfId)).append("\n");
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    purgeFlag: ").append(toIndentedString(purgeFlag)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    deregCallbackUri: ").append(toIndentedString(deregCallbackUri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
