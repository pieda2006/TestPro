package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.PduSessionType;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.QosFlowsSetupList;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.RefToBinaryData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SessionAmbr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HsmfUpdatedData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class HsmfUpdatedData   {
  @JsonProperty("n1SmInfoToUe")
  private RefToBinaryData n1SmInfoToUe = null;

  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("pduSessionType")
  private PduSessionType pduSessionType = null;

  @JsonProperty("sessionAmbr")
  private SessionAmbr sessionAmbr = null;

  @JsonProperty("qosFlowsSetupList")
  private QosFlowsSetupList qosFlowsSetupList = null;

  @JsonProperty("enablePauseCharging")
  private Boolean enablePauseCharging = null;

  public HsmfUpdatedData n1SmInfoToUe(RefToBinaryData n1SmInfoToUe) {
    this.n1SmInfoToUe = n1SmInfoToUe;
    return this;
  }

  /**
   * Get n1SmInfoToUe
   * @return n1SmInfoToUe
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RefToBinaryData getN1SmInfoToUe() {
    return n1SmInfoToUe;
  }

  public void setN1SmInfoToUe(RefToBinaryData n1SmInfoToUe) {
    this.n1SmInfoToUe = n1SmInfoToUe;
  }

  public HsmfUpdatedData pduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
    return this;
  }

  /**
   * Get pduSessionId
   * @return pduSessionId
  **/
  @ApiModelProperty(value = "")


  public Integer getPduSessionId() {
    return pduSessionId;
  }

  public void setPduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
  }

  public HsmfUpdatedData pduSessionType(PduSessionType pduSessionType) {
    this.pduSessionType = pduSessionType;
    return this;
  }

  /**
   * Get pduSessionType
   * @return pduSessionType
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PduSessionType getPduSessionType() {
    return pduSessionType;
  }

  public void setPduSessionType(PduSessionType pduSessionType) {
    this.pduSessionType = pduSessionType;
  }

  public HsmfUpdatedData sessionAmbr(SessionAmbr sessionAmbr) {
    this.sessionAmbr = sessionAmbr;
    return this;
  }

  /**
   * Get sessionAmbr
   * @return sessionAmbr
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SessionAmbr getSessionAmbr() {
    return sessionAmbr;
  }

  public void setSessionAmbr(SessionAmbr sessionAmbr) {
    this.sessionAmbr = sessionAmbr;
  }

  public HsmfUpdatedData qosFlowsSetupList(QosFlowsSetupList qosFlowsSetupList) {
    this.qosFlowsSetupList = qosFlowsSetupList;
    return this;
  }

  /**
   * Get qosFlowsSetupList
   * @return qosFlowsSetupList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public QosFlowsSetupList getQosFlowsSetupList() {
    return qosFlowsSetupList;
  }

  public void setQosFlowsSetupList(QosFlowsSetupList qosFlowsSetupList) {
    this.qosFlowsSetupList = qosFlowsSetupList;
  }

  public HsmfUpdatedData enablePauseCharging(Boolean enablePauseCharging) {
    this.enablePauseCharging = enablePauseCharging;
    return this;
  }

  /**
   * Get enablePauseCharging
   * @return enablePauseCharging
  **/
  @ApiModelProperty(value = "")


  public Boolean isEnablePauseCharging() {
    return enablePauseCharging;
  }

  public void setEnablePauseCharging(Boolean enablePauseCharging) {
    this.enablePauseCharging = enablePauseCharging;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HsmfUpdatedData hsmfUpdatedData = (HsmfUpdatedData) o;
    return Objects.equals(this.n1SmInfoToUe, hsmfUpdatedData.n1SmInfoToUe) &&
        Objects.equals(this.pduSessionId, hsmfUpdatedData.pduSessionId) &&
        Objects.equals(this.pduSessionType, hsmfUpdatedData.pduSessionType) &&
        Objects.equals(this.sessionAmbr, hsmfUpdatedData.sessionAmbr) &&
        Objects.equals(this.qosFlowsSetupList, hsmfUpdatedData.qosFlowsSetupList) &&
        Objects.equals(this.enablePauseCharging, hsmfUpdatedData.enablePauseCharging);
  }

  @Override
  public int hashCode() {
    return Objects.hash(n1SmInfoToUe, pduSessionId, pduSessionType, sessionAmbr, qosFlowsSetupList, enablePauseCharging);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HsmfUpdatedData {\n");
    
    sb.append("    n1SmInfoToUe: ").append(toIndentedString(n1SmInfoToUe)).append("\n");
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    pduSessionType: ").append(toIndentedString(pduSessionType)).append("\n");
    sb.append("    sessionAmbr: ").append(toIndentedString(sessionAmbr)).append("\n");
    sb.append("    qosFlowsSetupList: ").append(toIndentedString(qosFlowsSetupList)).append("\n");
    sb.append("    enablePauseCharging: ").append(toIndentedString(enablePauseCharging)).append("\n");
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

