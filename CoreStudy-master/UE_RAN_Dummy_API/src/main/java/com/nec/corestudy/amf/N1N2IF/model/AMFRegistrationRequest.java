package com.nec.corestudy.amf.N1N2IF.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFRegistrationRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:32:13.674+09:00")

public class AMFRegistrationRequest   {
  @JsonProperty("registrationType")
  private String registrationType = null;

  @JsonProperty("suci")
  private String suci = null;

  @JsonProperty("guti")
  private String guti = null;

  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("lastVisitedTai")
  private String lastVisitedTai = null;

  @JsonProperty("securityParameters")
  private String securityParameters = null;

  @JsonProperty("requestedNssai")
  private String requestedNssai = null;

  @JsonProperty("ue5GCCapability")
  private String ue5GCCapability = null;

  @JsonProperty("pduSessionStatus")
  private String pduSessionStatus = null;

  @JsonProperty("pduSessionsToBeActivated")
  @Valid
  private List<String> pduSessionsToBeActivated = null;

  @JsonProperty("followOnRequest")
  private String followOnRequest = null;

  @JsonProperty("micoModePreference")
  private String micoModePreference = null;

  @JsonProperty("requestedDrxParameters")
  private String requestedDrxParameters = null;

  @JsonProperty("ueSupportOfRequestTypeFlag")
  private String ueSupportOfRequestTypeFlag = null;

  public AMFRegistrationRequest registrationType(String registrationType) {
    this.registrationType = registrationType;
    return this;
  }

  /**
   * Get registrationType
   * @return registrationType
  **/
  @ApiModelProperty(value = "")


  public String getRegistrationType() {
    return registrationType;
  }

  public void setRegistrationType(String registrationType) {
    this.registrationType = registrationType;
  }

  public AMFRegistrationRequest suci(String suci) {
    this.suci = suci;
    return this;
  }

  /**
   * use as SUPI
   * @return suci
  **/
  @ApiModelProperty(value = "use as SUPI")


  public String getSuci() {
    return suci;
  }

  public void setSuci(String suci) {
    this.suci = suci;
  }

  public AMFRegistrationRequest guti(String guti) {
    this.guti = guti;
    return this;
  }

  /**
   * use as UEID
   * @return guti
  **/
  @ApiModelProperty(value = "use as UEID")


  public String getGuti() {
    return guti;
  }

  public void setGuti(String guti) {
    this.guti = guti;
  }

  public AMFRegistrationRequest pei(String pei) {
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

  public AMFRegistrationRequest lastVisitedTai(String lastVisitedTai) {
    this.lastVisitedTai = lastVisitedTai;
    return this;
  }

  /**
   * Get lastVisitedTai
   * @return lastVisitedTai
  **/
  @ApiModelProperty(value = "")


  public String getLastVisitedTai() {
    return lastVisitedTai;
  }

  public void setLastVisitedTai(String lastVisitedTai) {
    this.lastVisitedTai = lastVisitedTai;
  }

  public AMFRegistrationRequest securityParameters(String securityParameters) {
    this.securityParameters = securityParameters;
    return this;
  }

  /**
   * Get securityParameters
   * @return securityParameters
  **/
  @ApiModelProperty(value = "")


  public String getSecurityParameters() {
    return securityParameters;
  }

  public void setSecurityParameters(String securityParameters) {
    this.securityParameters = securityParameters;
  }

  public AMFRegistrationRequest requestedNssai(String requestedNssai) {
    this.requestedNssai = requestedNssai;
    return this;
  }

  /**
   * Get requestedNssai
   * @return requestedNssai
  **/
  @ApiModelProperty(value = "")


  public String getRequestedNssai() {
    return requestedNssai;
  }

  public void setRequestedNssai(String requestedNssai) {
    this.requestedNssai = requestedNssai;
  }

  public AMFRegistrationRequest ue5GCCapability(String ue5GCCapability) {
    this.ue5GCCapability = ue5GCCapability;
    return this;
  }

  /**
   * Get ue5GCCapability
   * @return ue5GCCapability
  **/
  @ApiModelProperty(value = "")


  public String getUe5GCCapability() {
    return ue5GCCapability;
  }

  public void setUe5GCCapability(String ue5GCCapability) {
    this.ue5GCCapability = ue5GCCapability;
  }

  public AMFRegistrationRequest pduSessionStatus(String pduSessionStatus) {
    this.pduSessionStatus = pduSessionStatus;
    return this;
  }

  /**
   * Get pduSessionStatus
   * @return pduSessionStatus
  **/
  @ApiModelProperty(value = "")


  public String getPduSessionStatus() {
    return pduSessionStatus;
  }

  public void setPduSessionStatus(String pduSessionStatus) {
    this.pduSessionStatus = pduSessionStatus;
  }

  public AMFRegistrationRequest pduSessionsToBeActivated(List<String> pduSessionsToBeActivated) {
    this.pduSessionsToBeActivated = pduSessionsToBeActivated;
    return this;
  }

  public AMFRegistrationRequest addPduSessionsToBeActivatedItem(String pduSessionsToBeActivatedItem) {
    if (this.pduSessionsToBeActivated == null) {
      this.pduSessionsToBeActivated = new ArrayList<String>();
    }
    this.pduSessionsToBeActivated.add(pduSessionsToBeActivatedItem);
    return this;
  }

  /**
   * Get pduSessionsToBeActivated
   * @return pduSessionsToBeActivated
  **/
  @ApiModelProperty(value = "")


  public List<String> getPduSessionsToBeActivated() {
    return pduSessionsToBeActivated;
  }

  public void setPduSessionsToBeActivated(List<String> pduSessionsToBeActivated) {
    this.pduSessionsToBeActivated = pduSessionsToBeActivated;
  }

  public AMFRegistrationRequest followOnRequest(String followOnRequest) {
    this.followOnRequest = followOnRequest;
    return this;
  }

  /**
   * Get followOnRequest
   * @return followOnRequest
  **/
  @ApiModelProperty(value = "")


  public String getFollowOnRequest() {
    return followOnRequest;
  }

  public void setFollowOnRequest(String followOnRequest) {
    this.followOnRequest = followOnRequest;
  }

  public AMFRegistrationRequest micoModePreference(String micoModePreference) {
    this.micoModePreference = micoModePreference;
    return this;
  }

  /**
   * Get micoModePreference
   * @return micoModePreference
  **/
  @ApiModelProperty(value = "")


  public String getMicoModePreference() {
    return micoModePreference;
  }

  public void setMicoModePreference(String micoModePreference) {
    this.micoModePreference = micoModePreference;
  }

  public AMFRegistrationRequest requestedDrxParameters(String requestedDrxParameters) {
    this.requestedDrxParameters = requestedDrxParameters;
    return this;
  }

  /**
   * Get requestedDrxParameters
   * @return requestedDrxParameters
  **/
  @ApiModelProperty(value = "")


  public String getRequestedDrxParameters() {
    return requestedDrxParameters;
  }

  public void setRequestedDrxParameters(String requestedDrxParameters) {
    this.requestedDrxParameters = requestedDrxParameters;
  }

  public AMFRegistrationRequest ueSupportOfRequestTypeFlag(String ueSupportOfRequestTypeFlag) {
    this.ueSupportOfRequestTypeFlag = ueSupportOfRequestTypeFlag;
    return this;
  }

  /**
   * Get ueSupportOfRequestTypeFlag
   * @return ueSupportOfRequestTypeFlag
  **/
  @ApiModelProperty(value = "")


  public String getUeSupportOfRequestTypeFlag() {
    return ueSupportOfRequestTypeFlag;
  }

  public void setUeSupportOfRequestTypeFlag(String ueSupportOfRequestTypeFlag) {
    this.ueSupportOfRequestTypeFlag = ueSupportOfRequestTypeFlag;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFRegistrationRequest amFRegistrationRequest = (AMFRegistrationRequest) o;
    return Objects.equals(this.registrationType, amFRegistrationRequest.registrationType) &&
        Objects.equals(this.suci, amFRegistrationRequest.suci) &&
        Objects.equals(this.guti, amFRegistrationRequest.guti) &&
        Objects.equals(this.pei, amFRegistrationRequest.pei) &&
        Objects.equals(this.lastVisitedTai, amFRegistrationRequest.lastVisitedTai) &&
        Objects.equals(this.securityParameters, amFRegistrationRequest.securityParameters) &&
        Objects.equals(this.requestedNssai, amFRegistrationRequest.requestedNssai) &&
        Objects.equals(this.ue5GCCapability, amFRegistrationRequest.ue5GCCapability) &&
        Objects.equals(this.pduSessionStatus, amFRegistrationRequest.pduSessionStatus) &&
        Objects.equals(this.pduSessionsToBeActivated, amFRegistrationRequest.pduSessionsToBeActivated) &&
        Objects.equals(this.followOnRequest, amFRegistrationRequest.followOnRequest) &&
        Objects.equals(this.micoModePreference, amFRegistrationRequest.micoModePreference) &&
        Objects.equals(this.requestedDrxParameters, amFRegistrationRequest.requestedDrxParameters) &&
        Objects.equals(this.ueSupportOfRequestTypeFlag, amFRegistrationRequest.ueSupportOfRequestTypeFlag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registrationType, suci, guti, pei, lastVisitedTai, securityParameters, requestedNssai, ue5GCCapability, pduSessionStatus, pduSessionsToBeActivated, followOnRequest, micoModePreference, requestedDrxParameters, ueSupportOfRequestTypeFlag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFRegistrationRequest {\n");
    
    sb.append("    registrationType: ").append(toIndentedString(registrationType)).append("\n");
    sb.append("    suci: ").append(toIndentedString(suci)).append("\n");
    sb.append("    guti: ").append(toIndentedString(guti)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    lastVisitedTai: ").append(toIndentedString(lastVisitedTai)).append("\n");
    sb.append("    securityParameters: ").append(toIndentedString(securityParameters)).append("\n");
    sb.append("    requestedNssai: ").append(toIndentedString(requestedNssai)).append("\n");
    sb.append("    ue5GCCapability: ").append(toIndentedString(ue5GCCapability)).append("\n");
    sb.append("    pduSessionStatus: ").append(toIndentedString(pduSessionStatus)).append("\n");
    sb.append("    pduSessionsToBeActivated: ").append(toIndentedString(pduSessionsToBeActivated)).append("\n");
    sb.append("    followOnRequest: ").append(toIndentedString(followOnRequest)).append("\n");
    sb.append("    micoModePreference: ").append(toIndentedString(micoModePreference)).append("\n");
    sb.append("    requestedDrxParameters: ").append(toIndentedString(requestedDrxParameters)).append("\n");
    sb.append("    ueSupportOfRequestTypeFlag: ").append(toIndentedString(ueSupportOfRequestTypeFlag)).append("\n");
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

