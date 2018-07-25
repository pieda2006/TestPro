package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmsSubscriptionDataDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SmsSubscriptionDataDB   {
  /**
   * Gets or Sets smsSupported
   */
  public enum SmsSupportedEnum {
    _3GPP("SMS_3GPP"),
    
    NON_3GPP("SMS_NON_3GPP"),
    
    _3GPP_AND_NON_3GPP("SMS_3GPP_AND_NON_3GPP");

    private String value;

    SmsSupportedEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SmsSupportedEnum fromValue(String text) {
      for (SmsSupportedEnum b : SmsSupportedEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("smsSupported")
  private SmsSupportedEnum smsSupported = null;

  @JsonProperty("smsf3GppAddress")
  private String smsf3GppAddress = null;

  @JsonProperty("smsfNon3GppAddress")
  private String smsfNon3GppAddress = null;

  public SmsSubscriptionDataDB smsSupported(SmsSupportedEnum smsSupported) {
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

  public SmsSubscriptionDataDB smsf3GppAddress(String smsf3GppAddress) {
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

  public SmsSubscriptionDataDB smsfNon3GppAddress(String smsfNon3GppAddress) {
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
    SmsSubscriptionDataDB smsSubscriptionDataDB = (SmsSubscriptionDataDB) o;
    return Objects.equals(this.smsSupported, smsSubscriptionDataDB.smsSupported) &&
        Objects.equals(this.smsf3GppAddress, smsSubscriptionDataDB.smsf3GppAddress) &&
        Objects.equals(this.smsfNon3GppAddress, smsSubscriptionDataDB.smsfNon3GppAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsSupported, smsf3GppAddress, smsfNon3GppAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsSubscriptionDataDB {\n");
    
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

