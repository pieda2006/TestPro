package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.AccessType;
import com.nec.corestudy.amf.NamfSmfCLI.model.QosFlowsList;
import com.nec.corestudy.amf.NamfSmfCLI.model.QosFlowsNotifyList;
import com.nec.corestudy.amf.NamfSmfCLI.model.RefToBinaryData;
import com.nec.corestudy.amf.NamfSmfCLI.model.RequestIndication;
import com.nec.corestudy.amf.NamfSmfCLI.model.TunnelInfo;
import com.nec.corestudy.amf.NamfSmfCLI.model.UserLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * HsmfUpdateData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class HsmfUpdateData   {
  @JsonProperty("requestIndication")
  private RequestIndication requestIndication = null;

  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("vcnTunnelInfo")
  private TunnelInfo vcnTunnelInfo = null;

  @JsonProperty("anType")
  private AccessType anType = null;

  @JsonProperty("ueLocation")
  private UserLocation ueLocation = null;

  @JsonProperty("ueTimeZone")
  private String ueTimeZone = null;

  @JsonProperty("pauseCharging")
  private Boolean pauseCharging = null;

  @JsonProperty("pti")
  private Integer pti = null;

  @JsonProperty("n1SmInfoFromUe")
  private RefToBinaryData n1SmInfoFromUe = null;

  @JsonProperty("unknownN1SmInfo")
  private RefToBinaryData unknownN1SmInfo = null;

  @JsonProperty("qosFlowsRelNotifyList")
  private QosFlowsList qosFlowsRelNotifyList = null;

  @JsonProperty("qosFlowsNotifyList")
  private QosFlowsNotifyList qosFlowsNotifyList = null;

  @JsonProperty("epsBearerId")
  private Integer epsBearerId = null;

  @JsonProperty("vsmfId")
  private String vsmfId = null;

  @JsonProperty("vsmfPduSessionUri")
  private String vsmfPduSessionUri = null;

  @JsonProperty("hoPreparationIndication")
  private Boolean hoPreparationIndication = null;

  public HsmfUpdateData requestIndication(RequestIndication requestIndication) {
    this.requestIndication = requestIndication;
    return this;
  }

  /**
   * Get requestIndication
   * @return requestIndication
  **/
  @ApiModelProperty(required = true, value = "")
  public RequestIndication getRequestIndication() {
    return requestIndication;
  }

  public void setRequestIndication(RequestIndication requestIndication) {
    this.requestIndication = requestIndication;
  }

  public HsmfUpdateData pei(String pei) {
    this.pei = pei;
    return this;
  }

  /**
   * Get pei
   * @return pei
  **/
  @ApiModelProperty(value = "")
  public String getPei() {
    return pei;
  }

  public void setPei(String pei) {
    this.pei = pei;
  }

  public HsmfUpdateData vcnTunnelInfo(TunnelInfo vcnTunnelInfo) {
    this.vcnTunnelInfo = vcnTunnelInfo;
    return this;
  }

  /**
   * Get vcnTunnelInfo
   * @return vcnTunnelInfo
  **/
  @ApiModelProperty(value = "")
  public TunnelInfo getVcnTunnelInfo() {
    return vcnTunnelInfo;
  }

  public void setVcnTunnelInfo(TunnelInfo vcnTunnelInfo) {
    this.vcnTunnelInfo = vcnTunnelInfo;
  }

  public HsmfUpdateData anType(AccessType anType) {
    this.anType = anType;
    return this;
  }

  /**
   * Get anType
   * @return anType
  **/
  @ApiModelProperty(value = "")
  public AccessType getAnType() {
    return anType;
  }

  public void setAnType(AccessType anType) {
    this.anType = anType;
  }

  public HsmfUpdateData ueLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
    return this;
  }

  /**
   * Get ueLocation
   * @return ueLocation
  **/
  @ApiModelProperty(value = "")
  public UserLocation getUeLocation() {
    return ueLocation;
  }

  public void setUeLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
  }

  public HsmfUpdateData ueTimeZone(String ueTimeZone) {
    this.ueTimeZone = ueTimeZone;
    return this;
  }

  /**
   * Get ueTimeZone
   * @return ueTimeZone
  **/
  @ApiModelProperty(value = "")
  public String getUeTimeZone() {
    return ueTimeZone;
  }

  public void setUeTimeZone(String ueTimeZone) {
    this.ueTimeZone = ueTimeZone;
  }

  public HsmfUpdateData pauseCharging(Boolean pauseCharging) {
    this.pauseCharging = pauseCharging;
    return this;
  }

  /**
   * Get pauseCharging
   * @return pauseCharging
  **/
  @ApiModelProperty(value = "")
  public Boolean isPauseCharging() {
    return pauseCharging;
  }

  public void setPauseCharging(Boolean pauseCharging) {
    this.pauseCharging = pauseCharging;
  }

  public HsmfUpdateData pti(Integer pti) {
    this.pti = pti;
    return this;
  }

  /**
   * Get pti
   * @return pti
  **/
  @ApiModelProperty(value = "")
  public Integer getPti() {
    return pti;
  }

  public void setPti(Integer pti) {
    this.pti = pti;
  }

  public HsmfUpdateData n1SmInfoFromUe(RefToBinaryData n1SmInfoFromUe) {
    this.n1SmInfoFromUe = n1SmInfoFromUe;
    return this;
  }

  /**
   * Get n1SmInfoFromUe
   * @return n1SmInfoFromUe
  **/
  @ApiModelProperty(value = "")
  public RefToBinaryData getN1SmInfoFromUe() {
    return n1SmInfoFromUe;
  }

  public void setN1SmInfoFromUe(RefToBinaryData n1SmInfoFromUe) {
    this.n1SmInfoFromUe = n1SmInfoFromUe;
  }

  public HsmfUpdateData unknownN1SmInfo(RefToBinaryData unknownN1SmInfo) {
    this.unknownN1SmInfo = unknownN1SmInfo;
    return this;
  }

  /**
   * Get unknownN1SmInfo
   * @return unknownN1SmInfo
  **/
  @ApiModelProperty(value = "")
  public RefToBinaryData getUnknownN1SmInfo() {
    return unknownN1SmInfo;
  }

  public void setUnknownN1SmInfo(RefToBinaryData unknownN1SmInfo) {
    this.unknownN1SmInfo = unknownN1SmInfo;
  }

  public HsmfUpdateData qosFlowsRelNotifyList(QosFlowsList qosFlowsRelNotifyList) {
    this.qosFlowsRelNotifyList = qosFlowsRelNotifyList;
    return this;
  }

  /**
   * Get qosFlowsRelNotifyList
   * @return qosFlowsRelNotifyList
  **/
  @ApiModelProperty(value = "")
  public QosFlowsList getQosFlowsRelNotifyList() {
    return qosFlowsRelNotifyList;
  }

  public void setQosFlowsRelNotifyList(QosFlowsList qosFlowsRelNotifyList) {
    this.qosFlowsRelNotifyList = qosFlowsRelNotifyList;
  }

  public HsmfUpdateData qosFlowsNotifyList(QosFlowsNotifyList qosFlowsNotifyList) {
    this.qosFlowsNotifyList = qosFlowsNotifyList;
    return this;
  }

  /**
   * Get qosFlowsNotifyList
   * @return qosFlowsNotifyList
  **/
  @ApiModelProperty(value = "")
  public QosFlowsNotifyList getQosFlowsNotifyList() {
    return qosFlowsNotifyList;
  }

  public void setQosFlowsNotifyList(QosFlowsNotifyList qosFlowsNotifyList) {
    this.qosFlowsNotifyList = qosFlowsNotifyList;
  }

  public HsmfUpdateData epsBearerId(Integer epsBearerId) {
    this.epsBearerId = epsBearerId;
    return this;
  }

  /**
   * Get epsBearerId
   * @return epsBearerId
  **/
  @ApiModelProperty(value = "")
  public Integer getEpsBearerId() {
    return epsBearerId;
  }

  public void setEpsBearerId(Integer epsBearerId) {
    this.epsBearerId = epsBearerId;
  }

  public HsmfUpdateData vsmfId(String vsmfId) {
    this.vsmfId = vsmfId;
    return this;
  }

  /**
   * Get vsmfId
   * @return vsmfId
  **/
  @ApiModelProperty(value = "")
  public String getVsmfId() {
    return vsmfId;
  }

  public void setVsmfId(String vsmfId) {
    this.vsmfId = vsmfId;
  }

  public HsmfUpdateData vsmfPduSessionUri(String vsmfPduSessionUri) {
    this.vsmfPduSessionUri = vsmfPduSessionUri;
    return this;
  }

  /**
   * Get vsmfPduSessionUri
   * @return vsmfPduSessionUri
  **/
  @ApiModelProperty(value = "")
  public String getVsmfPduSessionUri() {
    return vsmfPduSessionUri;
  }

  public void setVsmfPduSessionUri(String vsmfPduSessionUri) {
    this.vsmfPduSessionUri = vsmfPduSessionUri;
  }

  public HsmfUpdateData hoPreparationIndication(Boolean hoPreparationIndication) {
    this.hoPreparationIndication = hoPreparationIndication;
    return this;
  }

  /**
   * Get hoPreparationIndication
   * @return hoPreparationIndication
  **/
  @ApiModelProperty(value = "")
  public Boolean isHoPreparationIndication() {
    return hoPreparationIndication;
  }

  public void setHoPreparationIndication(Boolean hoPreparationIndication) {
    this.hoPreparationIndication = hoPreparationIndication;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HsmfUpdateData hsmfUpdateData = (HsmfUpdateData) o;
    return Objects.equals(this.requestIndication, hsmfUpdateData.requestIndication) &&
        Objects.equals(this.pei, hsmfUpdateData.pei) &&
        Objects.equals(this.vcnTunnelInfo, hsmfUpdateData.vcnTunnelInfo) &&
        Objects.equals(this.anType, hsmfUpdateData.anType) &&
        Objects.equals(this.ueLocation, hsmfUpdateData.ueLocation) &&
        Objects.equals(this.ueTimeZone, hsmfUpdateData.ueTimeZone) &&
        Objects.equals(this.pauseCharging, hsmfUpdateData.pauseCharging) &&
        Objects.equals(this.pti, hsmfUpdateData.pti) &&
        Objects.equals(this.n1SmInfoFromUe, hsmfUpdateData.n1SmInfoFromUe) &&
        Objects.equals(this.unknownN1SmInfo, hsmfUpdateData.unknownN1SmInfo) &&
        Objects.equals(this.qosFlowsRelNotifyList, hsmfUpdateData.qosFlowsRelNotifyList) &&
        Objects.equals(this.qosFlowsNotifyList, hsmfUpdateData.qosFlowsNotifyList) &&
        Objects.equals(this.epsBearerId, hsmfUpdateData.epsBearerId) &&
        Objects.equals(this.vsmfId, hsmfUpdateData.vsmfId) &&
        Objects.equals(this.vsmfPduSessionUri, hsmfUpdateData.vsmfPduSessionUri) &&
        Objects.equals(this.hoPreparationIndication, hsmfUpdateData.hoPreparationIndication);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestIndication, pei, vcnTunnelInfo, anType, ueLocation, ueTimeZone, pauseCharging, pti, n1SmInfoFromUe, unknownN1SmInfo, qosFlowsRelNotifyList, qosFlowsNotifyList, epsBearerId, vsmfId, vsmfPduSessionUri, hoPreparationIndication);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HsmfUpdateData {\n");
    
    sb.append("    requestIndication: ").append(toIndentedString(requestIndication)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    vcnTunnelInfo: ").append(toIndentedString(vcnTunnelInfo)).append("\n");
    sb.append("    anType: ").append(toIndentedString(anType)).append("\n");
    sb.append("    ueLocation: ").append(toIndentedString(ueLocation)).append("\n");
    sb.append("    ueTimeZone: ").append(toIndentedString(ueTimeZone)).append("\n");
    sb.append("    pauseCharging: ").append(toIndentedString(pauseCharging)).append("\n");
    sb.append("    pti: ").append(toIndentedString(pti)).append("\n");
    sb.append("    n1SmInfoFromUe: ").append(toIndentedString(n1SmInfoFromUe)).append("\n");
    sb.append("    unknownN1SmInfo: ").append(toIndentedString(unknownN1SmInfo)).append("\n");
    sb.append("    qosFlowsRelNotifyList: ").append(toIndentedString(qosFlowsRelNotifyList)).append("\n");
    sb.append("    qosFlowsNotifyList: ").append(toIndentedString(qosFlowsNotifyList)).append("\n");
    sb.append("    epsBearerId: ").append(toIndentedString(epsBearerId)).append("\n");
    sb.append("    vsmfId: ").append(toIndentedString(vsmfId)).append("\n");
    sb.append("    vsmfPduSessionUri: ").append(toIndentedString(vsmfPduSessionUri)).append("\n");
    sb.append("    hoPreparationIndication: ").append(toIndentedString(hoPreparationIndication)).append("\n");
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

