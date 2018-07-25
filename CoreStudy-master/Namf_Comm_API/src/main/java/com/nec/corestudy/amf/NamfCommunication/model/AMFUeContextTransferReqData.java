package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN1MessageContainer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFUeContextTransferReqData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFUeContextTransferReqData   {
  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("regRequest")
  private AMFN1MessageContainer regRequest = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public AMFUeContextTransferReqData reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * FFS
   * @return reason
  **/
  @ApiModelProperty(required = true, value = "FFS")
  @NotNull


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public AMFUeContextTransferReqData regRequest(AMFN1MessageContainer regRequest) {
    this.regRequest = regRequest;
    return this;
  }

  /**
   * Get regRequest
   * @return regRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFN1MessageContainer getRegRequest() {
    return regRequest;
  }

  public void setRegRequest(AMFN1MessageContainer regRequest) {
    this.regRequest = regRequest;
  }

  public AMFUeContextTransferReqData supportedFeatures(String supportedFeatures) {
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
    AMFUeContextTransferReqData amFUeContextTransferReqData = (AMFUeContextTransferReqData) o;
    return Objects.equals(this.reason, amFUeContextTransferReqData.reason) &&
        Objects.equals(this.regRequest, amFUeContextTransferReqData.regRequest) &&
        Objects.equals(this.supportedFeatures, amFUeContextTransferReqData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason, regRequest, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFUeContextTransferReqData {\n");
    
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    regRequest: ").append(toIndentedString(regRequest)).append("\n");
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

