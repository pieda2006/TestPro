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


package com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.model;

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
 * SmsSubscriptionData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-21T18:27:13.711+09:00")
public class SmsSubscriptionData {
  /**
   * Gets or Sets smsSupported
   */
  @JsonAdapter(SmsSupportedEnum.Adapter.class)
  public enum SmsSupportedEnum {
    _3GPP("SMS_3GPP"),
    
    NON_3GPP("SMS_NON_3GPP"),
    
    _3GPP_AND_NON_3GPP("SMS_3GPP_AND_NON_3GPP");

    private String value;

    SmsSupportedEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SmsSupportedEnum fromValue(String text) {
      for (SmsSupportedEnum b : SmsSupportedEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SmsSupportedEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SmsSupportedEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SmsSupportedEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return SmsSupportedEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("smsSupported")
  private SmsSupportedEnum smsSupported = null;

  @SerializedName("smsf3GppAddress")
  private String smsf3GppAddress = null;

  @SerializedName("smsfNon3GppAddress")
  private String smsfNon3GppAddress = null;

  public SmsSubscriptionData smsSupported(SmsSupportedEnum smsSupported) {
    this.smsSupported = smsSupported;
    return this;
  }

   /**
   * Get smsSupported
   * @return smsSupported
  **/
  @ApiModelProperty(value = "")
  public SmsSupportedEnum getSmsSupported() {
    return smsSupported;
  }

  public void setSmsSupported(SmsSupportedEnum smsSupported) {
    this.smsSupported = smsSupported;
  }

  public SmsSubscriptionData smsf3GppAddress(String smsf3GppAddress) {
    this.smsf3GppAddress = smsf3GppAddress;
    return this;
  }

   /**
   * Get smsf3GppAddress
   * @return smsf3GppAddress
  **/
  @ApiModelProperty(value = "")
  public String getSmsf3GppAddress() {
    return smsf3GppAddress;
  }

  public void setSmsf3GppAddress(String smsf3GppAddress) {
    this.smsf3GppAddress = smsf3GppAddress;
  }

  public SmsSubscriptionData smsfNon3GppAddress(String smsfNon3GppAddress) {
    this.smsfNon3GppAddress = smsfNon3GppAddress;
    return this;
  }

   /**
   * Get smsfNon3GppAddress
   * @return smsfNon3GppAddress
  **/
  @ApiModelProperty(value = "")
  public String getSmsfNon3GppAddress() {
    return smsfNon3GppAddress;
  }

  public void setSmsfNon3GppAddress(String smsfNon3GppAddress) {
    this.smsfNon3GppAddress = smsfNon3GppAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsSubscriptionData smsSubscriptionData = (SmsSubscriptionData) o;
    return Objects.equals(this.smsSupported, smsSubscriptionData.smsSupported) &&
        Objects.equals(this.smsf3GppAddress, smsSubscriptionData.smsf3GppAddress) &&
        Objects.equals(this.smsfNon3GppAddress, smsSubscriptionData.smsfNon3GppAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsSupported, smsf3GppAddress, smsfNon3GppAddress);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsSubscriptionData {\n");
    
    sb.append("    smsSupported: ").append(toIndentedString(smsSupported)).append("\n");
    sb.append("    smsf3GppAddress: ").append(toIndentedString(smsf3GppAddress)).append("\n");
    sb.append("    smsfNon3GppAddress: ").append(toIndentedString(smsfNon3GppAddress)).append("\n");
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
