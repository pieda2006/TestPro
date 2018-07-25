package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2InfoContainer;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2InfoContent;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContext;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFUeContextCreatedData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFUeContextCreatedData   {
  @JsonProperty("ueContext")
  private AMFUeContext ueContext = null;

  @JsonProperty("targetToSourceData")
  private AMFN2InfoContainer targetToSourceData = null;

  @JsonProperty("pduSessions")
  @Valid
  private List<AMFN2InfoContent> pduSessions = new ArrayList<AMFN2InfoContent>();

  @JsonProperty("ngapCause")
  private Integer ngapCause = null;

  @JsonProperty("failedSessions")
  @Valid
  private List<Integer> failedSessions = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public AMFUeContextCreatedData ueContext(AMFUeContext ueContext) {
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

  public AMFUeContextCreatedData targetToSourceData(AMFN2InfoContainer targetToSourceData) {
    this.targetToSourceData = targetToSourceData;
    return this;
  }

  /**
   * Get targetToSourceData
   * @return targetToSourceData
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFN2InfoContainer getTargetToSourceData() {
    return targetToSourceData;
  }

  public void setTargetToSourceData(AMFN2InfoContainer targetToSourceData) {
    this.targetToSourceData = targetToSourceData;
  }

  public AMFUeContextCreatedData pduSessions(List<AMFN2InfoContent> pduSessions) {
    this.pduSessions = pduSessions;
    return this;
  }

  public AMFUeContextCreatedData addPduSessionsItem(AMFN2InfoContent pduSessionsItem) {
    this.pduSessions.add(pduSessionsItem);
    return this;
  }

  /**
   * Definition of N2SmInfoContent not found.
   * @return pduSessions
  **/
  @ApiModelProperty(required = true, value = "Definition of N2SmInfoContent not found.")
  @NotNull

  @Valid

  public List<AMFN2InfoContent> getPduSessions() {
    return pduSessions;
  }

  public void setPduSessions(List<AMFN2InfoContent> pduSessions) {
    this.pduSessions = pduSessions;
  }

  public AMFUeContextCreatedData ngapCause(Integer ngapCause) {
    this.ngapCause = ngapCause;
    return this;
  }

  /**
   * Get ngapCause
   * @return ngapCause
  **/
  @ApiModelProperty(value = "")


  public Integer getNgapCause() {
    return ngapCause;
  }

  public void setNgapCause(Integer ngapCause) {
    this.ngapCause = ngapCause;
  }

  public AMFUeContextCreatedData failedSessions(List<Integer> failedSessions) {
    this.failedSessions = failedSessions;
    return this;
  }

  public AMFUeContextCreatedData addFailedSessionsItem(Integer failedSessionsItem) {
    if (this.failedSessions == null) {
      this.failedSessions = new ArrayList<Integer>();
    }
    this.failedSessions.add(failedSessionsItem);
    return this;
  }

  /**
   * Get failedSessions
   * @return failedSessions
  **/
  @ApiModelProperty(value = "")


  public List<Integer> getFailedSessions() {
    return failedSessions;
  }

  public void setFailedSessions(List<Integer> failedSessions) {
    this.failedSessions = failedSessions;
  }

  public AMFUeContextCreatedData supportedFeatures(String supportedFeatures) {
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
    AMFUeContextCreatedData amFUeContextCreatedData = (AMFUeContextCreatedData) o;
    return Objects.equals(this.ueContext, amFUeContextCreatedData.ueContext) &&
        Objects.equals(this.targetToSourceData, amFUeContextCreatedData.targetToSourceData) &&
        Objects.equals(this.pduSessions, amFUeContextCreatedData.pduSessions) &&
        Objects.equals(this.ngapCause, amFUeContextCreatedData.ngapCause) &&
        Objects.equals(this.failedSessions, amFUeContextCreatedData.failedSessions) &&
        Objects.equals(this.supportedFeatures, amFUeContextCreatedData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ueContext, targetToSourceData, pduSessions, ngapCause, failedSessions, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFUeContextCreatedData {\n");
    
    sb.append("    ueContext: ").append(toIndentedString(ueContext)).append("\n");
    sb.append("    targetToSourceData: ").append(toIndentedString(targetToSourceData)).append("\n");
    sb.append("    pduSessions: ").append(toIndentedString(pduSessions)).append("\n");
    sb.append("    ngapCause: ").append(toIndentedString(ngapCause)).append("\n");
    sb.append("    failedSessions: ").append(toIndentedString(failedSessions)).append("\n");
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

