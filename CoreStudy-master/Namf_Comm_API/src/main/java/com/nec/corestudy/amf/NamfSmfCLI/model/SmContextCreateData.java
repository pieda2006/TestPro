package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.AccessType;
import com.nec.corestudy.amf.NamfSmfCLI.model.HSmfId;
import com.nec.corestudy.amf.NamfSmfCLI.model.HoState;
import com.nec.corestudy.amf.NamfSmfCLI.model.IndicationFlags;
import com.nec.corestudy.amf.NamfSmfCLI.model.RefToBinaryData;
import com.nec.corestudy.amf.NamfSmfCLI.model.RequestType;
import com.nec.corestudy.amf.NamfSmfCLI.model.SingleNssai;
import com.nec.corestudy.amf.NamfSmfCLI.model.UserLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * SmContextCreateData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class SmContextCreateData   {
  @JsonProperty("supi")
  private String supi = null;

  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("gpsi")
  private String gpsi = null;

  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("sNssai")
  private SingleNssai sNssai = null;

  @JsonProperty("amfId")
  private String amfId = null;

  @JsonProperty("requestType")
  private RequestType requestType = null;

  @JsonProperty("n1SmMsg")
  private RefToBinaryData n1SmMsg = null;

  @JsonProperty("anType")
  private AccessType anType = null;

  @JsonProperty("ueLocation")
  private UserLocation ueLocation = null;

  @JsonProperty("ueTimeZone")
  private String ueTimeZone = null;

  @JsonProperty("smContextStatusUri")
  private String smContextStatusUri = null;

  @JsonProperty("hSmfId")
  private HSmfId hSmfId = null;

  @JsonProperty("indicationFlags")
  private IndicationFlags indicationFlags = null;

  @JsonProperty("oldPduSessionId")
  private Integer oldPduSessionId = null;

  @JsonProperty("pduSessionsActivateList")
  private Integer pduSessionsActivateList = null;

  @JsonProperty("ueEpsPdnConnection")
  private String ueEpsPdnConnection = null;

  @JsonProperty("hoState")
  private HoState hoState = null;

  @JsonProperty("pcfId")
  private String pcfId = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public SmContextCreateData supi(String supi) {
    this.supi = supi;
    return this;
  }

  /**
   * Get supi
   * @return supi
  **/
  @ApiModelProperty(value = "")
  public String getSupi() {
    return supi;
  }

  public void setSupi(String supi) {
    this.supi = supi;
  }

  public SmContextCreateData pei(String pei) {
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

  public SmContextCreateData gpsi(String gpsi) {
    this.gpsi = gpsi;
    return this;
  }

  /**
   * Get gpsi
   * @return gpsi
  **/
  @ApiModelProperty(value = "")
  public String getGpsi() {
    return gpsi;
  }

  public void setGpsi(String gpsi) {
    this.gpsi = gpsi;
  }

  public SmContextCreateData pduSessionId(Integer pduSessionId) {
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

  public SmContextCreateData dnn(String dnn) {
    this.dnn = dnn;
    return this;
  }

  /**
   * Get dnn
   * @return dnn
  **/
  @ApiModelProperty(value = "")
  public String getDnn() {
    return dnn;
  }

  public void setDnn(String dnn) {
    this.dnn = dnn;
  }

  public SmContextCreateData sNssai(SingleNssai sNssai) {
    this.sNssai = sNssai;
    return this;
  }

  /**
   * Get sNssai
   * @return sNssai
  **/
  @ApiModelProperty(required = true, value = "")
  public SingleNssai getSNssai() {
    return sNssai;
  }

  public void setSNssai(SingleNssai sNssai) {
    this.sNssai = sNssai;
  }

  public SmContextCreateData amfId(String amfId) {
    this.amfId = amfId;
    return this;
  }

  /**
   * Get amfId
   * @return amfId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getAmfId() {
    return amfId;
  }

  public void setAmfId(String amfId) {
    this.amfId = amfId;
  }

  public SmContextCreateData requestType(RequestType requestType) {
    this.requestType = requestType;
    return this;
  }

  /**
   * Get requestType
   * @return requestType
  **/
  @ApiModelProperty(value = "")
  public RequestType getRequestType() {
    return requestType;
  }

  public void setRequestType(RequestType requestType) {
    this.requestType = requestType;
  }

  public SmContextCreateData n1SmMsg(RefToBinaryData n1SmMsg) {
    this.n1SmMsg = n1SmMsg;
    return this;
  }

  /**
   * Get n1SmMsg
   * @return n1SmMsg
  **/
  @ApiModelProperty(required = true, value = "")
  public RefToBinaryData getN1SmMsg() {
    return n1SmMsg;
  }

  public void setN1SmMsg(RefToBinaryData n1SmMsg) {
    this.n1SmMsg = n1SmMsg;
  }

  public SmContextCreateData anType(AccessType anType) {
    this.anType = anType;
    return this;
  }

  /**
   * Get anType
   * @return anType
  **/
  @ApiModelProperty(required = true, value = "")
  public AccessType getAnType() {
    return anType;
  }

  public void setAnType(AccessType anType) {
    this.anType = anType;
  }

  public SmContextCreateData ueLocation(UserLocation ueLocation) {
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

  public SmContextCreateData ueTimeZone(String ueTimeZone) {
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

  public SmContextCreateData smContextStatusUri(String smContextStatusUri) {
    this.smContextStatusUri = smContextStatusUri;
    return this;
  }

  /**
   * Get smContextStatusUri
   * @return smContextStatusUri
  **/
  @ApiModelProperty(required = true, value = "")
  public String getSmContextStatusUri() {
    return smContextStatusUri;
  }

  public void setSmContextStatusUri(String smContextStatusUri) {
    this.smContextStatusUri = smContextStatusUri;
  }

  public SmContextCreateData hSmfId(HSmfId hSmfId) {
    this.hSmfId = hSmfId;
    return this;
  }

  /**
   * Get hSmfId
   * @return hSmfId
  **/
  @ApiModelProperty(value = "")
  public HSmfId getHSmfId() {
    return hSmfId;
  }

  public void setHSmfId(HSmfId hSmfId) {
    this.hSmfId = hSmfId;
  }

  public SmContextCreateData indicationFlags(IndicationFlags indicationFlags) {
    this.indicationFlags = indicationFlags;
    return this;
  }

  /**
   * Get indicationFlags
   * @return indicationFlags
  **/
  @ApiModelProperty(value = "")
  public IndicationFlags getIndicationFlags() {
    return indicationFlags;
  }

  public void setIndicationFlags(IndicationFlags indicationFlags) {
    this.indicationFlags = indicationFlags;
  }

  public SmContextCreateData oldPduSessionId(Integer oldPduSessionId) {
    this.oldPduSessionId = oldPduSessionId;
    return this;
  }

  /**
   * Get oldPduSessionId
   * @return oldPduSessionId
  **/
  @ApiModelProperty(value = "")
  public Integer getOldPduSessionId() {
    return oldPduSessionId;
  }

  public void setOldPduSessionId(Integer oldPduSessionId) {
    this.oldPduSessionId = oldPduSessionId;
  }

  public SmContextCreateData pduSessionsActivateList(Integer pduSessionsActivateList) {
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

  public SmContextCreateData ueEpsPdnConnection(String ueEpsPdnConnection) {
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

  public SmContextCreateData hoState(HoState hoState) {
    this.hoState = hoState;
    return this;
  }

  /**
   * Get hoState
   * @return hoState
  **/
  @ApiModelProperty(value = "")
  public HoState getHoState() {
    return hoState;
  }

  public void setHoState(HoState hoState) {
    this.hoState = hoState;
  }

  public SmContextCreateData pcfId(String pcfId) {
    this.pcfId = pcfId;
    return this;
  }

  /**
   * Get pcfId
   * @return pcfId
  **/
  @ApiModelProperty(value = "")
  public String getPcfId() {
    return pcfId;
  }

  public void setPcfId(String pcfId) {
    this.pcfId = pcfId;
  }

  public SmContextCreateData supportedFeatures(String supportedFeatures) {
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
    SmContextCreateData smContextCreateData = (SmContextCreateData) o;
    return Objects.equals(this.supi, smContextCreateData.supi) &&
        Objects.equals(this.pei, smContextCreateData.pei) &&
        Objects.equals(this.gpsi, smContextCreateData.gpsi) &&
        Objects.equals(this.pduSessionId, smContextCreateData.pduSessionId) &&
        Objects.equals(this.dnn, smContextCreateData.dnn) &&
        Objects.equals(this.sNssai, smContextCreateData.sNssai) &&
        Objects.equals(this.amfId, smContextCreateData.amfId) &&
        Objects.equals(this.requestType, smContextCreateData.requestType) &&
        Objects.equals(this.n1SmMsg, smContextCreateData.n1SmMsg) &&
        Objects.equals(this.anType, smContextCreateData.anType) &&
        Objects.equals(this.ueLocation, smContextCreateData.ueLocation) &&
        Objects.equals(this.ueTimeZone, smContextCreateData.ueTimeZone) &&
        Objects.equals(this.smContextStatusUri, smContextCreateData.smContextStatusUri) &&
        Objects.equals(this.hSmfId, smContextCreateData.hSmfId) &&
        Objects.equals(this.indicationFlags, smContextCreateData.indicationFlags) &&
        Objects.equals(this.oldPduSessionId, smContextCreateData.oldPduSessionId) &&
        Objects.equals(this.pduSessionsActivateList, smContextCreateData.pduSessionsActivateList) &&
        Objects.equals(this.ueEpsPdnConnection, smContextCreateData.ueEpsPdnConnection) &&
        Objects.equals(this.hoState, smContextCreateData.hoState) &&
        Objects.equals(this.pcfId, smContextCreateData.pcfId) &&
        Objects.equals(this.supportedFeatures, smContextCreateData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supi, pei, gpsi, pduSessionId, dnn, sNssai, amfId, requestType, n1SmMsg, anType, ueLocation, ueTimeZone, smContextStatusUri, hSmfId, indicationFlags, oldPduSessionId, pduSessionsActivateList, ueEpsPdnConnection, hoState, pcfId, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmContextCreateData {\n");
    
    sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    gpsi: ").append(toIndentedString(gpsi)).append("\n");
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    sNssai: ").append(toIndentedString(sNssai)).append("\n");
    sb.append("    amfId: ").append(toIndentedString(amfId)).append("\n");
    sb.append("    requestType: ").append(toIndentedString(requestType)).append("\n");
    sb.append("    n1SmMsg: ").append(toIndentedString(n1SmMsg)).append("\n");
    sb.append("    anType: ").append(toIndentedString(anType)).append("\n");
    sb.append("    ueLocation: ").append(toIndentedString(ueLocation)).append("\n");
    sb.append("    ueTimeZone: ").append(toIndentedString(ueTimeZone)).append("\n");
    sb.append("    smContextStatusUri: ").append(toIndentedString(smContextStatusUri)).append("\n");
    sb.append("    hSmfId: ").append(toIndentedString(hSmfId)).append("\n");
    sb.append("    indicationFlags: ").append(toIndentedString(indicationFlags)).append("\n");
    sb.append("    oldPduSessionId: ").append(toIndentedString(oldPduSessionId)).append("\n");
    sb.append("    pduSessionsActivateList: ").append(toIndentedString(pduSessionsActivateList)).append("\n");
    sb.append("    ueEpsPdnConnection: ").append(toIndentedString(ueEpsPdnConnection)).append("\n");
    sb.append("    hoState: ").append(toIndentedString(hoState)).append("\n");
    sb.append("    pcfId: ").append(toIndentedString(pcfId)).append("\n");
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

