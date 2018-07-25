package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.PduSessionType;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.QosFlowsSetupList;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.RefToBinaryData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SessionAmbr;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.TunnelInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PduSessionCreatedData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class PduSessionCreatedData   {
  @JsonProperty("pduSessionType")
  private PduSessionType pduSessionType = null;

  @JsonProperty("hcnTunnelInfo")
  private TunnelInfo hcnTunnelInfo = null;

  @JsonProperty("sessionAmbr")
  private SessionAmbr sessionAmbr = null;

  @JsonProperty("qosFlowsSetupList")
  private QosFlowsSetupList qosFlowsSetupList = null;

  @JsonProperty("enablePauseCharging")
  private Boolean enablePauseCharging = null;

  @JsonProperty("ueIpv4Address")
  private String ueIpv4Address = null;

  @JsonProperty("ueIpv6Prefix")
  private String ueIpv6Prefix = null;

  @JsonProperty("n1SmInfoToUe")
  private RefToBinaryData n1SmInfoToUe = null;

  @JsonProperty("pgwS8fteid")
  private TunnelInfo pgwS8fteid = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public PduSessionCreatedData pduSessionType(PduSessionType pduSessionType) {
    this.pduSessionType = pduSessionType;
    return this;
  }

  /**
   * Get pduSessionType
   * @return pduSessionType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PduSessionType getPduSessionType() {
    return pduSessionType;
  }

  public void setPduSessionType(PduSessionType pduSessionType) {
    this.pduSessionType = pduSessionType;
  }

  public PduSessionCreatedData hcnTunnelInfo(TunnelInfo hcnTunnelInfo) {
    this.hcnTunnelInfo = hcnTunnelInfo;
    return this;
  }

  /**
   * Get hcnTunnelInfo
   * @return hcnTunnelInfo
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TunnelInfo getHcnTunnelInfo() {
    return hcnTunnelInfo;
  }

  public void setHcnTunnelInfo(TunnelInfo hcnTunnelInfo) {
    this.hcnTunnelInfo = hcnTunnelInfo;
  }

  public PduSessionCreatedData sessionAmbr(SessionAmbr sessionAmbr) {
    this.sessionAmbr = sessionAmbr;
    return this;
  }

  /**
   * Get sessionAmbr
   * @return sessionAmbr
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SessionAmbr getSessionAmbr() {
    return sessionAmbr;
  }

  public void setSessionAmbr(SessionAmbr sessionAmbr) {
    this.sessionAmbr = sessionAmbr;
  }

  public PduSessionCreatedData qosFlowsSetupList(QosFlowsSetupList qosFlowsSetupList) {
    this.qosFlowsSetupList = qosFlowsSetupList;
    return this;
  }

  /**
   * Get qosFlowsSetupList
   * @return qosFlowsSetupList
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public QosFlowsSetupList getQosFlowsSetupList() {
    return qosFlowsSetupList;
  }

  public void setQosFlowsSetupList(QosFlowsSetupList qosFlowsSetupList) {
    this.qosFlowsSetupList = qosFlowsSetupList;
  }

  public PduSessionCreatedData enablePauseCharging(Boolean enablePauseCharging) {
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

  public PduSessionCreatedData ueIpv4Address(String ueIpv4Address) {
    this.ueIpv4Address = ueIpv4Address;
    return this;
  }

  /**
   * Get ueIpv4Address
   * @return ueIpv4Address
  **/
  @ApiModelProperty(value = "")


  public String getUeIpv4Address() {
    return ueIpv4Address;
  }

  public void setUeIpv4Address(String ueIpv4Address) {
    this.ueIpv4Address = ueIpv4Address;
  }

  public PduSessionCreatedData ueIpv6Prefix(String ueIpv6Prefix) {
    this.ueIpv6Prefix = ueIpv6Prefix;
    return this;
  }

  /**
   * Get ueIpv6Prefix
   * @return ueIpv6Prefix
  **/
  @ApiModelProperty(value = "")


  public String getUeIpv6Prefix() {
    return ueIpv6Prefix;
  }

  public void setUeIpv6Prefix(String ueIpv6Prefix) {
    this.ueIpv6Prefix = ueIpv6Prefix;
  }

  public PduSessionCreatedData n1SmInfoToUe(RefToBinaryData n1SmInfoToUe) {
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

  public PduSessionCreatedData pgwS8fteid(TunnelInfo pgwS8fteid) {
    this.pgwS8fteid = pgwS8fteid;
    return this;
  }

  /**
   * Get pgwS8fteid
   * @return pgwS8fteid
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TunnelInfo getPgwS8fteid() {
    return pgwS8fteid;
  }

  public void setPgwS8fteid(TunnelInfo pgwS8fteid) {
    this.pgwS8fteid = pgwS8fteid;
  }

  public PduSessionCreatedData supportedFeatures(String supportedFeatures) {
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
    PduSessionCreatedData pduSessionCreatedData = (PduSessionCreatedData) o;
    return Objects.equals(this.pduSessionType, pduSessionCreatedData.pduSessionType) &&
        Objects.equals(this.hcnTunnelInfo, pduSessionCreatedData.hcnTunnelInfo) &&
        Objects.equals(this.sessionAmbr, pduSessionCreatedData.sessionAmbr) &&
        Objects.equals(this.qosFlowsSetupList, pduSessionCreatedData.qosFlowsSetupList) &&
        Objects.equals(this.enablePauseCharging, pduSessionCreatedData.enablePauseCharging) &&
        Objects.equals(this.ueIpv4Address, pduSessionCreatedData.ueIpv4Address) &&
        Objects.equals(this.ueIpv6Prefix, pduSessionCreatedData.ueIpv6Prefix) &&
        Objects.equals(this.n1SmInfoToUe, pduSessionCreatedData.n1SmInfoToUe) &&
        Objects.equals(this.pgwS8fteid, pduSessionCreatedData.pgwS8fteid) &&
        Objects.equals(this.supportedFeatures, pduSessionCreatedData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionType, hcnTunnelInfo, sessionAmbr, qosFlowsSetupList, enablePauseCharging, ueIpv4Address, ueIpv6Prefix, n1SmInfoToUe, pgwS8fteid, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PduSessionCreatedData {\n");
    
    sb.append("    pduSessionType: ").append(toIndentedString(pduSessionType)).append("\n");
    sb.append("    hcnTunnelInfo: ").append(toIndentedString(hcnTunnelInfo)).append("\n");
    sb.append("    sessionAmbr: ").append(toIndentedString(sessionAmbr)).append("\n");
    sb.append("    qosFlowsSetupList: ").append(toIndentedString(qosFlowsSetupList)).append("\n");
    sb.append("    enablePauseCharging: ").append(toIndentedString(enablePauseCharging)).append("\n");
    sb.append("    ueIpv4Address: ").append(toIndentedString(ueIpv4Address)).append("\n");
    sb.append("    ueIpv6Prefix: ").append(toIndentedString(ueIpv6Prefix)).append("\n");
    sb.append("    n1SmInfoToUe: ").append(toIndentedString(n1SmInfoToUe)).append("\n");
    sb.append("    pgwS8fteid: ").append(toIndentedString(pgwS8fteid)).append("\n");
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

