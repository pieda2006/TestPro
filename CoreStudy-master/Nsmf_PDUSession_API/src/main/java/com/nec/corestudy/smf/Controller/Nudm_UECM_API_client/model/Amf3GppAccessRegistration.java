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
 * Amf3GppAccessRegistration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-21T18:27:47.006+09:00")
public class Amf3GppAccessRegistration {
  @SerializedName("amfId")
  private String amfId = null;

  @SerializedName("supportedFeatures")
  private String supportedFeatures = null;

  @SerializedName("purgeFlag")
  private Boolean purgeFlag = null;

  @SerializedName("pei")
  private String pei = null;

  /**
   * Gets or Sets imsVoPS
   */
  @JsonAdapter(ImsVoPSEnum.Adapter.class)
  public enum ImsVoPSEnum {
    HOMOGENEOUS_SUPPORT("HOMOGENEOUS_SUPPORT"),
    
    HOMOGENEOUS_NON_SUPPORT("HOMOGENEOUS_NON_SUPPORT"),
    
    NON_HOMOGENEOUS_OR_UNKNOWN("NON_HOMOGENEOUS_OR_UNKNOWN");

    private String value;

    ImsVoPSEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ImsVoPSEnum fromValue(String text) {
      for (ImsVoPSEnum b : ImsVoPSEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ImsVoPSEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ImsVoPSEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ImsVoPSEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ImsVoPSEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("imsVoPS")
  private ImsVoPSEnum imsVoPS = null;

  @SerializedName("deregCallbackUri")
  private String deregCallbackUri = null;

  public Amf3GppAccessRegistration amfId(String amfId) {
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

  public Amf3GppAccessRegistration supportedFeatures(String supportedFeatures) {
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

  public Amf3GppAccessRegistration purgeFlag(Boolean purgeFlag) {
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

  public Amf3GppAccessRegistration pei(String pei) {
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

  public Amf3GppAccessRegistration imsVoPS(ImsVoPSEnum imsVoPS) {
    this.imsVoPS = imsVoPS;
    return this;
  }

   /**
   * Get imsVoPS
   * @return imsVoPS
  **/
  @ApiModelProperty(value = "")
  public ImsVoPSEnum getImsVoPS() {
    return imsVoPS;
  }

  public void setImsVoPS(ImsVoPSEnum imsVoPS) {
    this.imsVoPS = imsVoPS;
  }

  public Amf3GppAccessRegistration deregCallbackUri(String deregCallbackUri) {
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
    Amf3GppAccessRegistration amf3GppAccessRegistration = (Amf3GppAccessRegistration) o;
    return Objects.equals(this.amfId, amf3GppAccessRegistration.amfId) &&
        Objects.equals(this.supportedFeatures, amf3GppAccessRegistration.supportedFeatures) &&
        Objects.equals(this.purgeFlag, amf3GppAccessRegistration.purgeFlag) &&
        Objects.equals(this.pei, amf3GppAccessRegistration.pei) &&
        Objects.equals(this.imsVoPS, amf3GppAccessRegistration.imsVoPS) &&
        Objects.equals(this.deregCallbackUri, amf3GppAccessRegistration.deregCallbackUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amfId, supportedFeatures, purgeFlag, pei, imsVoPS, deregCallbackUri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amf3GppAccessRegistration {\n");
    
    sb.append("    amfId: ").append(toIndentedString(amfId)).append("\n");
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    purgeFlag: ").append(toIndentedString(purgeFlag)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    imsVoPS: ").append(toIndentedString(imsVoPS)).append("\n");
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
