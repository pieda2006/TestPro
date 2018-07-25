package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSdmCLI.model.SmsSupport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * SmsSubscriptionData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:45.878+09:00")

public class SmsSubscriptionData   {
  @JsonProperty("smsSupported")
  private SmsSupport smsSupported = null;

  @JsonProperty("smsf3GppAddress")
  private String smsf3GppAddress = null;

  @JsonProperty("smsfNon3GppAddress")
  private String smsfNon3GppAddress = null;

  public SmsSubscriptionData smsSupported(SmsSupport smsSupported) {
    this.smsSupported = smsSupported;
    return this;
  }

  /**
   * Get smsSupported
   * @return smsSupported
  **/
  @ApiModelProperty(value = "")
  public SmsSupport getSmsSupported() {
    return smsSupported;
  }

  public void setSmsSupported(SmsSupport smsSupported) {
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

