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
 * SmsfRegistration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-21T18:27:47.006+09:00")
public class SmsfRegistration {
  @SerializedName("smsfId")
  private String smsfId = null;

  @SerializedName("supportedFeatures")
  private String supportedFeatures = null;

  public SmsfRegistration smsfId(String smsfId) {
    this.smsfId = smsfId;
    return this;
  }

   /**
   * Get smsfId
   * @return smsfId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getSmsfId() {
    return smsfId;
  }

  public void setSmsfId(String smsfId) {
    this.smsfId = smsfId;
  }

  public SmsfRegistration supportedFeatures(String supportedFeatures) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsfRegistration smsfRegistration = (SmsfRegistration) o;
    return Objects.equals(this.smsfId, smsfRegistration.smsfId) &&
        Objects.equals(this.supportedFeatures, smsfRegistration.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsfId, supportedFeatures);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsfRegistration {\n");
    
    sb.append("    smsfId: ").append(toIndentedString(smsfId)).append("\n");
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
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
