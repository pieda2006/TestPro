package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.AccessType;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.Cause;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.HoState;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.RefToBinaryData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.UpCnxState;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.UserLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmContextUpdateData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class SmContextUpdateData   {
  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("amfId")
  private String amfId = null;

  @JsonProperty("anType")
  private AccessType anType = null;

  @JsonProperty("ueLocation")
  private UserLocation ueLocation = null;

  @JsonProperty("ueTimeZone")
  private String ueTimeZone = null;

  @JsonProperty("upCnxState")
  private UpCnxState upCnxState = null;

  @JsonProperty("hoState")
  private HoState hoState = null;

  @JsonProperty("n1SmMsg")
  private RefToBinaryData n1SmMsg = null;

  @JsonProperty("n2SmInfo")
  private RefToBinaryData n2SmInfo = null;

  @JsonProperty("targetAmfId")
  private String targetAmfId = null;

  @JsonProperty("pduSessionsActivateList")
  private Integer pduSessionsActivateList = null;

  @JsonProperty("ueEpsPdnConnection")
  private String ueEpsPdnConnection = null;

  @JsonProperty("dataForwarding")
  private Boolean dataForwarding = null;

  @JsonProperty("epsBearerSetup")
  private String epsBearerSetup = null;

  @JsonProperty("cause")
  private Cause cause = null;

  public SmContextUpdateData pei(String pei) {
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

  public SmContextUpdateData amfId(String amfId) {
    this.amfId = amfId;
    return this;
  }

  /**
   * Get amfId
   * @return amfId
  **/
  @ApiModelProperty(value = "")


  public String getAmfId() {
    return amfId;
  }

  public void setAmfId(String amfId) {
    this.amfId = amfId;
  }

  public SmContextUpdateData anType(AccessType anType) {
    this.anType = anType;
    return this;
  }

  /**
   * Get anType
   * @return anType
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccessType getAnType() {
    return anType;
  }

  public void setAnType(AccessType anType) {
    this.anType = anType;
  }

  public SmContextUpdateData ueLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
    return this;
  }

  /**
   * Get ueLocation
   * @return ueLocation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserLocation getUeLocation() {
    return ueLocation;
  }

  public void setUeLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
  }

  public SmContextUpdateData ueTimeZone(String ueTimeZone) {
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

  public SmContextUpdateData upCnxState(UpCnxState upCnxState) {
    this.upCnxState = upCnxState;
    return this;
  }

  /**
   * Get upCnxState
   * @return upCnxState
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UpCnxState getUpCnxState() {
    return upCnxState;
  }

  public void setUpCnxState(UpCnxState upCnxState) {
    this.upCnxState = upCnxState;
  }

  public SmContextUpdateData hoState(HoState hoState) {
    this.hoState = hoState;
    return this;
  }

  /**
   * Get hoState
   * @return hoState
  **/
  @ApiModelProperty(value = "")

  @Valid

  public HoState getHoState() {
    return hoState;
  }

  public void setHoState(HoState hoState) {
    this.hoState = hoState;
  }

  public SmContextUpdateData n1SmMsg(RefToBinaryData n1SmMsg) {
    this.n1SmMsg = n1SmMsg;
    return this;
  }

  /**
   * Get n1SmMsg
   * @return n1SmMsg
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RefToBinaryData getN1SmMsg() {
    return n1SmMsg;
  }

  public void setN1SmMsg(RefToBinaryData n1SmMsg) {
    this.n1SmMsg = n1SmMsg;
  }

  public SmContextUpdateData n2SmInfo(RefToBinaryData n2SmInfo) {
    this.n2SmInfo = n2SmInfo;
    return this;
  }

  /**
   * Get n2SmInfo
   * @return n2SmInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RefToBinaryData getN2SmInfo() {
    return n2SmInfo;
  }

  public void setN2SmInfo(RefToBinaryData n2SmInfo) {
    this.n2SmInfo = n2SmInfo;
  }

  public SmContextUpdateData targetAmfId(String targetAmfId) {
    this.targetAmfId = targetAmfId;
    return this;
  }

  /**
   * Get targetAmfId
   * @return targetAmfId
  **/
  @ApiModelProperty(value = "")


  public String getTargetAmfId() {
    return targetAmfId;
  }

  public void setTargetAmfId(String targetAmfId) {
    this.targetAmfId = targetAmfId;
  }

  public SmContextUpdateData pduSessionsActivateList(Integer pduSessionsActivateList) {
    this.pduSessionsActivateList = pduSessionsActivateList;
    return this;
  }

  /**
   * Get pduSessionsActivateList
   * @return pduSessionsActivateList
  **/
  @ApiModelProperty(value = "")


  public Integer getPduSessionsActivateList() {
    return pduSessionsActivateList;
  }

  public void setPduSessionsActivateList(Integer pduSessionsActivateList) {
    this.pduSessionsActivateList = pduSessionsActivateList;
  }

  public SmContextUpdateData ueEpsPdnConnection(String ueEpsPdnConnection) {
    this.ueEpsPdnConnection = ueEpsPdnConnection;
    return this;
  }

  /**
   * Get ueEpsPdnConnection
   * @return ueEpsPdnConnection
  **/
  @ApiModelProperty(value = "")


  public String getUeEpsPdnConnection() {
    return ueEpsPdnConnection;
  }

  public void setUeEpsPdnConnection(String ueEpsPdnConnection) {
    this.ueEpsPdnConnection = ueEpsPdnConnection;
  }

  public SmContextUpdateData dataForwarding(Boolean dataForwarding) {
    this.dataForwarding = dataForwarding;
    return this;
  }

  /**
   * Get dataForwarding
   * @return dataForwarding
  **/
  @ApiModelProperty(value = "")


  public Boolean isDataForwarding() {
    return dataForwarding;
  }

  public void setDataForwarding(Boolean dataForwarding) {
    this.dataForwarding = dataForwarding;
  }

  public SmContextUpdateData epsBearerSetup(String epsBearerSetup) {
    this.epsBearerSetup = epsBearerSetup;
    return this;
  }

  /**
   * Get epsBearerSetup
   * @return epsBearerSetup
  **/
  @ApiModelProperty(value = "")


  public String getEpsBearerSetup() {
    return epsBearerSetup;
  }

  public void setEpsBearerSetup(String epsBearerSetup) {
    this.epsBearerSetup = epsBearerSetup;
  }

  public SmContextUpdateData cause(Cause cause) {
    this.cause = cause;
    return this;
  }

  /**
   * Get cause
   * @return cause
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Cause getCause() {
    return cause;
  }

  public void setCause(Cause cause) {
    this.cause = cause;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmContextUpdateData smContextUpdateData = (SmContextUpdateData) o;
    return Objects.equals(this.pei, smContextUpdateData.pei) &&
        Objects.equals(this.amfId, smContextUpdateData.amfId) &&
        Objects.equals(this.anType, smContextUpdateData.anType) &&
        Objects.equals(this.ueLocation, smContextUpdateData.ueLocation) &&
        Objects.equals(this.ueTimeZone, smContextUpdateData.ueTimeZone) &&
        Objects.equals(this.upCnxState, smContextUpdateData.upCnxState) &&
        Objects.equals(this.hoState, smContextUpdateData.hoState) &&
        Objects.equals(this.n1SmMsg, smContextUpdateData.n1SmMsg) &&
        Objects.equals(this.n2SmInfo, smContextUpdateData.n2SmInfo) &&
        Objects.equals(this.targetAmfId, smContextUpdateData.targetAmfId) &&
        Objects.equals(this.pduSessionsActivateList, smContextUpdateData.pduSessionsActivateList) &&
        Objects.equals(this.ueEpsPdnConnection, smContextUpdateData.ueEpsPdnConnection) &&
        Objects.equals(this.dataForwarding, smContextUpdateData.dataForwarding) &&
        Objects.equals(this.epsBearerSetup, smContextUpdateData.epsBearerSetup) &&
        Objects.equals(this.cause, smContextUpdateData.cause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pei, amfId, anType, ueLocation, ueTimeZone, upCnxState, hoState, n1SmMsg, n2SmInfo, targetAmfId, pduSessionsActivateList, ueEpsPdnConnection, dataForwarding, epsBearerSetup, cause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmContextUpdateData {\n");
    
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    amfId: ").append(toIndentedString(amfId)).append("\n");
    sb.append("    anType: ").append(toIndentedString(anType)).append("\n");
    sb.append("    ueLocation: ").append(toIndentedString(ueLocation)).append("\n");
    sb.append("    ueTimeZone: ").append(toIndentedString(ueTimeZone)).append("\n");
    sb.append("    upCnxState: ").append(toIndentedString(upCnxState)).append("\n");
    sb.append("    hoState: ").append(toIndentedString(hoState)).append("\n");
    sb.append("    n1SmMsg: ").append(toIndentedString(n1SmMsg)).append("\n");
    sb.append("    n2SmInfo: ").append(toIndentedString(n2SmInfo)).append("\n");
    sb.append("    targetAmfId: ").append(toIndentedString(targetAmfId)).append("\n");
    sb.append("    pduSessionsActivateList: ").append(toIndentedString(pduSessionsActivateList)).append("\n");
    sb.append("    ueEpsPdnConnection: ").append(toIndentedString(ueEpsPdnConnection)).append("\n");
    sb.append("    dataForwarding: ").append(toIndentedString(dataForwarding)).append("\n");
    sb.append("    epsBearerSetup: ").append(toIndentedString(epsBearerSetup)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
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

