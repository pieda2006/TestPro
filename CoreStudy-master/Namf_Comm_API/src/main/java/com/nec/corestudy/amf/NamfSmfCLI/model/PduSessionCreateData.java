package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.AccessType;
import com.nec.corestudy.amf.NamfSmfCLI.model.IndicationFlags;
import com.nec.corestudy.amf.NamfSmfCLI.model.RefToBinaryData;
import com.nec.corestudy.amf.NamfSmfCLI.model.RequestType;
import com.nec.corestudy.amf.NamfSmfCLI.model.SingleNssai;
import com.nec.corestudy.amf.NamfSmfCLI.model.TunnelInfo;
import com.nec.corestudy.amf.NamfSmfCLI.model.UserLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PduSessionCreateData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class PduSessionCreateData   {
  @JsonProperty("supi")
  private String supi = null;

  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("sNssai")
  private SingleNssai sNssai = null;

  @JsonProperty("vsmfId")
  private String vsmfId = null;

  @JsonProperty("requestType")
  private RequestType requestType = null;

  @JsonProperty("vsmfPduSessionUri")
  private String vsmfPduSessionUri = null;

  @JsonProperty("vcnTunnelInfo")
  private TunnelInfo vcnTunnelInfo = null;

  @JsonProperty("anType")
  private AccessType anType = null;

  @JsonProperty("ueLocation")
  private UserLocation ueLocation = null;

  @JsonProperty("ueTimeZone")
  private String ueTimeZone = null;

  @JsonProperty("indicationFlags")
  private IndicationFlags indicationFlags = null;

  @JsonProperty("gpsi")
  private String gpsi = null;

  @JsonProperty("n1SmInfoFromUe")
  private RefToBinaryData n1SmInfoFromUe = null;

  @JsonProperty("unknownN1SmInfo")
  private RefToBinaryData unknownN1SmInfo = null;

  @JsonProperty("5gsmCapability")
  private String _5gsmCapability = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("hPcfId")
  private String hPcfId = null;

  public PduSessionCreateData supi(String supi) {
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

  public PduSessionCreateData pei(String pei) {
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

  public PduSessionCreateData pduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
    return this;
  }

  /**
   * Get pduSessionId
   * @return pduSessionId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPduSessionId() {
    return pduSessionId;
  }

  public void setPduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
  }

  public PduSessionCreateData dnn(String dnn) {
    this.dnn = dnn;
    return this;
  }

  /**
   * Get dnn
   * @return dnn
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDnn() {
    return dnn;
  }

  public void setDnn(String dnn) {
    this.dnn = dnn;
  }

  public PduSessionCreateData sNssai(SingleNssai sNssai) {
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

  public PduSessionCreateData vsmfId(String vsmfId) {
    this.vsmfId = vsmfId;
    return this;
  }

  /**
   * Get vsmfId
   * @return vsmfId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getVsmfId() {
    return vsmfId;
  }

  public void setVsmfId(String vsmfId) {
    this.vsmfId = vsmfId;
  }

  public PduSessionCreateData requestType(RequestType requestType) {
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

  public PduSessionCreateData vsmfPduSessionUri(String vsmfPduSessionUri) {
    this.vsmfPduSessionUri = vsmfPduSessionUri;
    return this;
  }

  /**
   * Get vsmfPduSessionUri
   * @return vsmfPduSessionUri
  **/
  @ApiModelProperty(required = true, value = "")
  public String getVsmfPduSessionUri() {
    return vsmfPduSessionUri;
  }

  public void setVsmfPduSessionUri(String vsmfPduSessionUri) {
    this.vsmfPduSessionUri = vsmfPduSessionUri;
  }

  public PduSessionCreateData vcnTunnelInfo(TunnelInfo vcnTunnelInfo) {
    this.vcnTunnelInfo = vcnTunnelInfo;
    return this;
  }

  /**
   * Get vcnTunnelInfo
   * @return vcnTunnelInfo
  **/
  @ApiModelProperty(required = true, value = "")
  public TunnelInfo getVcnTunnelInfo() {
    return vcnTunnelInfo;
  }

  public void setVcnTunnelInfo(TunnelInfo vcnTunnelInfo) {
    this.vcnTunnelInfo = vcnTunnelInfo;
  }

  public PduSessionCreateData anType(AccessType anType) {
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

  public PduSessionCreateData ueLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
    return this;
  }

  /**
   * Get ueLocation
   * @return ueLocation
  **/
  @ApiModelProperty(required = true, value = "")
  public UserLocation getUeLocation() {
    return ueLocation;
  }

  public void setUeLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
  }

  public PduSessionCreateData ueTimeZone(String ueTimeZone) {
    this.ueTimeZone = ueTimeZone;
    return this;
  }

  /**
   * Get ueTimeZone
   * @return ueTimeZone
  **/
  @ApiModelProperty(required = true, value = "")
  public String getUeTimeZone() {
    return ueTimeZone;
  }

  public void setUeTimeZone(String ueTimeZone) {
    this.ueTimeZone = ueTimeZone;
  }

  public PduSessionCreateData indicationFlags(IndicationFlags indicationFlags) {
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

  public PduSessionCreateData gpsi(String gpsi) {
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

  public PduSessionCreateData n1SmInfoFromUe(RefToBinaryData n1SmInfoFromUe) {
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

  public PduSessionCreateData unknownN1SmInfo(RefToBinaryData unknownN1SmInfo) {
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

  public PduSessionCreateData _5gsmCapability(String _5gsmCapability) {
    this._5gsmCapability = _5gsmCapability;
    return this;
  }

  /**
   * Get _5gsmCapability
   * @return _5gsmCapability
  **/
  @ApiModelProperty(value = "")
  public String get5gsmCapability() {
    return _5gsmCapability;
  }

  public void set5gsmCapability(String _5gsmCapability) {
    this._5gsmCapability = _5gsmCapability;
  }

  public PduSessionCreateData supportedFeatures(String supportedFeatures) {
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

  public PduSessionCreateData hPcfId(String hPcfId) {
    this.hPcfId = hPcfId;
    return this;
  }

  /**
   * Get hPcfId
   * @return hPcfId
  **/
  @ApiModelProperty(value = "")
  public String getHPcfId() {
    return hPcfId;
  }

  public void setHPcfId(String hPcfId) {
    this.hPcfId = hPcfId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PduSessionCreateData pduSessionCreateData = (PduSessionCreateData) o;
    return Objects.equals(this.supi, pduSessionCreateData.supi) &&
        Objects.equals(this.pei, pduSessionCreateData.pei) &&
        Objects.equals(this.pduSessionId, pduSessionCreateData.pduSessionId) &&
        Objects.equals(this.dnn, pduSessionCreateData.dnn) &&
        Objects.equals(this.sNssai, pduSessionCreateData.sNssai) &&
        Objects.equals(this.vsmfId, pduSessionCreateData.vsmfId) &&
        Objects.equals(this.requestType, pduSessionCreateData.requestType) &&
        Objects.equals(this.vsmfPduSessionUri, pduSessionCreateData.vsmfPduSessionUri) &&
        Objects.equals(this.vcnTunnelInfo, pduSessionCreateData.vcnTunnelInfo) &&
        Objects.equals(this.anType, pduSessionCreateData.anType) &&
        Objects.equals(this.ueLocation, pduSessionCreateData.ueLocation) &&
        Objects.equals(this.ueTimeZone, pduSessionCreateData.ueTimeZone) &&
        Objects.equals(this.indicationFlags, pduSessionCreateData.indicationFlags) &&
        Objects.equals(this.gpsi, pduSessionCreateData.gpsi) &&
        Objects.equals(this.n1SmInfoFromUe, pduSessionCreateData.n1SmInfoFromUe) &&
        Objects.equals(this.unknownN1SmInfo, pduSessionCreateData.unknownN1SmInfo) &&
        Objects.equals(this._5gsmCapability, pduSessionCreateData._5gsmCapability) &&
        Objects.equals(this.supportedFeatures, pduSessionCreateData.supportedFeatures) &&
        Objects.equals(this.hPcfId, pduSessionCreateData.hPcfId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supi, pei, pduSessionId, dnn, sNssai, vsmfId, requestType, vsmfPduSessionUri, vcnTunnelInfo, anType, ueLocation, ueTimeZone, indicationFlags, gpsi, n1SmInfoFromUe, unknownN1SmInfo, _5gsmCapability, supportedFeatures, hPcfId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PduSessionCreateData {\n");
    
    sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    sNssai: ").append(toIndentedString(sNssai)).append("\n");
    sb.append("    vsmfId: ").append(toIndentedString(vsmfId)).append("\n");
    sb.append("    requestType: ").append(toIndentedString(requestType)).append("\n");
    sb.append("    vsmfPduSessionUri: ").append(toIndentedString(vsmfPduSessionUri)).append("\n");
    sb.append("    vcnTunnelInfo: ").append(toIndentedString(vcnTunnelInfo)).append("\n");
    sb.append("    anType: ").append(toIndentedString(anType)).append("\n");
    sb.append("    ueLocation: ").append(toIndentedString(ueLocation)).append("\n");
    sb.append("    ueTimeZone: ").append(toIndentedString(ueTimeZone)).append("\n");
    sb.append("    indicationFlags: ").append(toIndentedString(indicationFlags)).append("\n");
    sb.append("    gpsi: ").append(toIndentedString(gpsi)).append("\n");
    sb.append("    n1SmInfoFromUe: ").append(toIndentedString(n1SmInfoFromUe)).append("\n");
    sb.append("    unknownN1SmInfo: ").append(toIndentedString(unknownN1SmInfo)).append("\n");
    sb.append("    _5gsmCapability: ").append(toIndentedString(_5gsmCapability)).append("\n");
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    hPcfId: ").append(toIndentedString(hPcfId)).append("\n");
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

