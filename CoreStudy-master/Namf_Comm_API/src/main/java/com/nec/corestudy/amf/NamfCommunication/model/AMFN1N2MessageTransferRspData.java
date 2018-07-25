package com.nec.corestudy.amf.NamfCommunication.model;

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
 * AMFN1N2MessageTransferRspData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFN1N2MessageTransferRspData   {
  /**
   * Gets or Sets cause
   */
  public enum CauseEnum {
    ATTEMPTING_TO_REACH_UE("Jamf_ATTEMPTING_TO_REACH_UE"),
    
    N1_N2_TRANSFER_INITIATED("Jamf_N1_N2_TRANSFER_INITIATED"),
    
    UE_NOT_REACHABLE("Jamf_UE_NOT_REACHABLE"),
    
    WAITING_FOR_ASYNCHRONOUS_TRANSFER("Jamf_WAITING_FOR_ASYNCHRONOUS_TRANSFER"),
    
    HIGHER_PRIORITY_REQUEST_ONGOING("Jamf_HIGHER_PRIORITY_REQUEST_ONGOING");

    private String value;

    CauseEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CauseEnum fromValue(String text) {
      for (CauseEnum b : CauseEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("cause")
  private CauseEnum cause = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public AMFN1N2MessageTransferRspData cause(CauseEnum cause) {
    this.cause = cause;
    return this;
  }

  /**
   * Get cause
   * @return cause
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public CauseEnum getCause() {
    return cause;
  }

  public void setCause(CauseEnum cause) {
    this.cause = cause;
  }

  public AMFN1N2MessageTransferRspData supportedFeatures(String supportedFeatures) {
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
    AMFN1N2MessageTransferRspData amFN1N2MessageTransferRspData = (AMFN1N2MessageTransferRspData) o;
    return Objects.equals(this.cause, amFN1N2MessageTransferRspData.cause) &&
        Objects.equals(this.supportedFeatures, amFN1N2MessageTransferRspData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cause, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN1N2MessageTransferRspData {\n");
    
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
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

