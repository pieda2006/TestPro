package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2InfoContainer;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2SmInformation;
import com.nec.corestudy.amf.NamfCommunication.model.AMFNgRanTargetId;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContext;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFUeContextCreateData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFUeContextCreateData   {
  @JsonProperty("ueContext")
  private AMFUeContext ueContext = null;

  @JsonProperty("handoverType")
  private String handoverType = null;

  @JsonProperty("targetId")
  private AMFNgRanTargetId targetId = null;

  @JsonProperty("sourceToTargetData")
  private AMFN2InfoContainer sourceToTargetData = null;

  @JsonProperty("pduSessions")
  private AMFN2SmInformation pduSessions = null;

  @JsonProperty("ngapCause")
  private Integer ngapCause = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public AMFUeContextCreateData ueContext(AMFUeContext ueContext) {
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

  public AMFUeContextCreateData handoverType(String handoverType) {
    this.handoverType = handoverType;
    return this;
  }

  /**
   * FFS
   * @return handoverType
  **/
  @ApiModelProperty(required = true, value = "FFS")
  @NotNull


  public String getHandoverType() {
    return handoverType;
  }

  public void setHandoverType(String handoverType) {
    this.handoverType = handoverType;
  }

  public AMFUeContextCreateData targetId(AMFNgRanTargetId targetId) {
    this.targetId = targetId;
    return this;
  }

  /**
   * Get targetId
   * @return targetId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFNgRanTargetId getTargetId() {
    return targetId;
  }

  public void setTargetId(AMFNgRanTargetId targetId) {
    this.targetId = targetId;
  }

  public AMFUeContextCreateData sourceToTargetData(AMFN2InfoContainer sourceToTargetData) {
    this.sourceToTargetData = sourceToTargetData;
    return this;
  }

  /**
   * Get sourceToTargetData
   * @return sourceToTargetData
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFN2InfoContainer getSourceToTargetData() {
    return sourceToTargetData;
  }

  public void setSourceToTargetData(AMFN2InfoContainer sourceToTargetData) {
    this.sourceToTargetData = sourceToTargetData;
  }

  public AMFUeContextCreateData pduSessions(AMFN2SmInformation pduSessions) {
    this.pduSessions = pduSessions;
    return this;
  }

  /**
   * Get pduSessions
   * @return pduSessions
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFN2SmInformation getPduSessions() {
    return pduSessions;
  }

  public void setPduSessions(AMFN2SmInformation pduSessions) {
    this.pduSessions = pduSessions;
  }

  public AMFUeContextCreateData ngapCause(Integer ngapCause) {
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

  public AMFUeContextCreateData supportedFeatures(String supportedFeatures) {
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
    AMFUeContextCreateData amFUeContextCreateData = (AMFUeContextCreateData) o;
    return Objects.equals(this.ueContext, amFUeContextCreateData.ueContext) &&
        Objects.equals(this.handoverType, amFUeContextCreateData.handoverType) &&
        Objects.equals(this.targetId, amFUeContextCreateData.targetId) &&
        Objects.equals(this.sourceToTargetData, amFUeContextCreateData.sourceToTargetData) &&
        Objects.equals(this.pduSessions, amFUeContextCreateData.pduSessions) &&
        Objects.equals(this.ngapCause, amFUeContextCreateData.ngapCause) &&
        Objects.equals(this.supportedFeatures, amFUeContextCreateData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ueContext, handoverType, targetId, sourceToTargetData, pduSessions, ngapCause, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFUeContextCreateData {\n");
    
    sb.append("    ueContext: ").append(toIndentedString(ueContext)).append("\n");
    sb.append("    handoverType: ").append(toIndentedString(handoverType)).append("\n");
    sb.append("    targetId: ").append(toIndentedString(targetId)).append("\n");
    sb.append("    sourceToTargetData: ").append(toIndentedString(sourceToTargetData)).append("\n");
    sb.append("    pduSessions: ").append(toIndentedString(pduSessions)).append("\n");
    sb.append("    ngapCause: ").append(toIndentedString(ngapCause)).append("\n");
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

