package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContext;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFUeContextTransferRspData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFUeContextTransferRspData   {
  @JsonProperty("ueContext")
  private AMFUeContext ueContext = null;

  @JsonProperty("regCompleteNotifyUri")
  private String regCompleteNotifyUri = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public AMFUeContextTransferRspData ueContext(AMFUeContext ueContext) {
    this.ueContext = ueContext;
    return this;
  }

  /**
   * Get ueContext
   * @return ueContext
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFUeContext getUeContext() {
    return ueContext;
  }

  public void setUeContext(AMFUeContext ueContext) {
    this.ueContext = ueContext;
  }

  public AMFUeContextTransferRspData regCompleteNotifyUri(String regCompleteNotifyUri) {
    this.regCompleteNotifyUri = regCompleteNotifyUri;
    return this;
  }

  /**
   * Get regCompleteNotifyUri
   * @return regCompleteNotifyUri
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRegCompleteNotifyUri() {
    return regCompleteNotifyUri;
  }

  public void setRegCompleteNotifyUri(String regCompleteNotifyUri) {
    this.regCompleteNotifyUri = regCompleteNotifyUri;
  }

  public AMFUeContextTransferRspData supportedFeatures(String supportedFeatures) {
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
    AMFUeContextTransferRspData amFUeContextTransferRspData = (AMFUeContextTransferRspData) o;
    return Objects.equals(this.ueContext, amFUeContextTransferRspData.ueContext) &&
        Objects.equals(this.regCompleteNotifyUri, amFUeContextTransferRspData.regCompleteNotifyUri) &&
        Objects.equals(this.supportedFeatures, amFUeContextTransferRspData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ueContext, regCompleteNotifyUri, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFUeContextTransferRspData {\n");
    
    sb.append("    ueContext: ").append(toIndentedString(ueContext)).append("\n");
    sb.append("    regCompleteNotifyUri: ").append(toIndentedString(regCompleteNotifyUri)).append("\n");
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

