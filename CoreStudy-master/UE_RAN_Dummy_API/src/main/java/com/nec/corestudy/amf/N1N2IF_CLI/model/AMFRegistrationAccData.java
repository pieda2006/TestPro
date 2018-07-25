package com.nec.corestudy.amf.N1N2IF_CLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AMFRegistrationAccData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:33:39.136+09:00")

public class AMFRegistrationAccData   {
  @JsonProperty("guti")
  private String guti = null;

  @JsonProperty("registrationArea")
  private String registrationArea = null;

  @JsonProperty("mobilityRestrictions")
  private String mobilityRestrictions = null;

  @JsonProperty("PDU Session status")
  private String pdUSessionStatus = null;

  @JsonProperty("allowedNSSAI")
  private String allowedNSSAI = null;

  @JsonProperty("periodicRegistrationUpdateTimer")
  private String periodicRegistrationUpdateTimer = null;

  @JsonProperty("ladnInformationAndAcceptedMICOMode")
  private String ladnInformationAndAcceptedMICOMode = null;

  @JsonProperty("imsVoiceOverPSSessionSupportedIndication")
  private String imsVoiceOverPSSessionSupportedIndication = null;

  @JsonProperty("EmergencyServiceSupportIndicator")
  private String emergencyServiceSupportIndicator = null;

  @JsonProperty("AcceptedDRXParameters")
  private String acceptedDRXParameters = null;

  @JsonProperty("NetworkSupportOfInterworkingWithoutN26")
  private String networkSupportOfInterworkingWithoutN26 = null;

  public AMFRegistrationAccData guti(String guti) {
    this.guti = guti;
    return this;
  }

  /**
   * Get guti
   * @return guti
  **/
  @ApiModelProperty(value = "")
  public String getGuti() {
    return guti;
  }

  public void setGuti(String guti) {
    this.guti = guti;
  }

  public AMFRegistrationAccData registrationArea(String registrationArea) {
    this.registrationArea = registrationArea;
    return this;
  }

  /**
   * Get registrationArea
   * @return registrationArea
  **/
  @ApiModelProperty(value = "")
  public String getRegistrationArea() {
    return registrationArea;
  }

  public void setRegistrationArea(String registrationArea) {
    this.registrationArea = registrationArea;
  }

  public AMFRegistrationAccData mobilityRestrictions(String mobilityRestrictions) {
    this.mobilityRestrictions = mobilityRestrictions;
    return this;
  }

  /**
   * Get mobilityRestrictions
   * @return mobilityRestrictions
  **/
  @ApiModelProperty(value = "")
  public String getMobilityRestrictions() {
    return mobilityRestrictions;
  }

  public void setMobilityRestrictions(String mobilityRestrictions) {
    this.mobilityRestrictions = mobilityRestrictions;
  }

  public AMFRegistrationAccData pdUSessionStatus(String pdUSessionStatus) {
    this.pdUSessionStatus = pdUSessionStatus;
    return this;
  }

  /**
   * Get pdUSessionStatus
   * @return pdUSessionStatus
  **/
  @ApiModelProperty(value = "")
  public String getPdUSessionStatus() {
    return pdUSessionStatus;
  }

  public void setPdUSessionStatus(String pdUSessionStatus) {
    this.pdUSessionStatus = pdUSessionStatus;
  }

  public AMFRegistrationAccData allowedNSSAI(String allowedNSSAI) {
    this.allowedNSSAI = allowedNSSAI;
    return this;
  }

  /**
   * Get allowedNSSAI
   * @return allowedNSSAI
  **/
  @ApiModelProperty(value = "")
  public String getAllowedNSSAI() {
    return allowedNSSAI;
  }

  public void setAllowedNSSAI(String allowedNSSAI) {
    this.allowedNSSAI = allowedNSSAI;
  }

  public AMFRegistrationAccData periodicRegistrationUpdateTimer(String periodicRegistrationUpdateTimer) {
    this.periodicRegistrationUpdateTimer = periodicRegistrationUpdateTimer;
    return this;
  }

  /**
   * Get periodicRegistrationUpdateTimer
   * @return periodicRegistrationUpdateTimer
  **/
  @ApiModelProperty(value = "")
  public String getPeriodicRegistrationUpdateTimer() {
    return periodicRegistrationUpdateTimer;
  }

  public void setPeriodicRegistrationUpdateTimer(String periodicRegistrationUpdateTimer) {
    this.periodicRegistrationUpdateTimer = periodicRegistrationUpdateTimer;
  }

  public AMFRegistrationAccData ladnInformationAndAcceptedMICOMode(String ladnInformationAndAcceptedMICOMode) {
    this.ladnInformationAndAcceptedMICOMode = ladnInformationAndAcceptedMICOMode;
    return this;
  }

  /**
   * Get ladnInformationAndAcceptedMICOMode
   * @return ladnInformationAndAcceptedMICOMode
  **/
  @ApiModelProperty(value = "")
  public String getLadnInformationAndAcceptedMICOMode() {
    return ladnInformationAndAcceptedMICOMode;
  }

  public void setLadnInformationAndAcceptedMICOMode(String ladnInformationAndAcceptedMICOMode) {
    this.ladnInformationAndAcceptedMICOMode = ladnInformationAndAcceptedMICOMode;
  }

  public AMFRegistrationAccData imsVoiceOverPSSessionSupportedIndication(String imsVoiceOverPSSessionSupportedIndication) {
    this.imsVoiceOverPSSessionSupportedIndication = imsVoiceOverPSSessionSupportedIndication;
    return this;
  }

  /**
   * Get imsVoiceOverPSSessionSupportedIndication
   * @return imsVoiceOverPSSessionSupportedIndication
  **/
  @ApiModelProperty(value = "")
  public String getImsVoiceOverPSSessionSupportedIndication() {
    return imsVoiceOverPSSessionSupportedIndication;
  }

  public void setImsVoiceOverPSSessionSupportedIndication(String imsVoiceOverPSSessionSupportedIndication) {
    this.imsVoiceOverPSSessionSupportedIndication = imsVoiceOverPSSessionSupportedIndication;
  }

  public AMFRegistrationAccData emergencyServiceSupportIndicator(String emergencyServiceSupportIndicator) {
    this.emergencyServiceSupportIndicator = emergencyServiceSupportIndicator;
    return this;
  }

  /**
   * Get emergencyServiceSupportIndicator
   * @return emergencyServiceSupportIndicator
  **/
  @ApiModelProperty(value = "")
  public String getEmergencyServiceSupportIndicator() {
    return emergencyServiceSupportIndicator;
  }

  public void setEmergencyServiceSupportIndicator(String emergencyServiceSupportIndicator) {
    this.emergencyServiceSupportIndicator = emergencyServiceSupportIndicator;
  }

  public AMFRegistrationAccData acceptedDRXParameters(String acceptedDRXParameters) {
    this.acceptedDRXParameters = acceptedDRXParameters;
    return this;
  }

  /**
   * Get acceptedDRXParameters
   * @return acceptedDRXParameters
  **/
  @ApiModelProperty(value = "")
  public String getAcceptedDRXParameters() {
    return acceptedDRXParameters;
  }

  public void setAcceptedDRXParameters(String acceptedDRXParameters) {
    this.acceptedDRXParameters = acceptedDRXParameters;
  }

  public AMFRegistrationAccData networkSupportOfInterworkingWithoutN26(String networkSupportOfInterworkingWithoutN26) {
    this.networkSupportOfInterworkingWithoutN26 = networkSupportOfInterworkingWithoutN26;
    return this;
  }

  /**
   * Get networkSupportOfInterworkingWithoutN26
   * @return networkSupportOfInterworkingWithoutN26
  **/
  @ApiModelProperty(value = "")
  public String getNetworkSupportOfInterworkingWithoutN26() {
    return networkSupportOfInterworkingWithoutN26;
  }

  public void setNetworkSupportOfInterworkingWithoutN26(String networkSupportOfInterworkingWithoutN26) {
    this.networkSupportOfInterworkingWithoutN26 = networkSupportOfInterworkingWithoutN26;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFRegistrationAccData amFRegistrationAccData = (AMFRegistrationAccData) o;
    return Objects.equals(this.guti, amFRegistrationAccData.guti) &&
        Objects.equals(this.registrationArea, amFRegistrationAccData.registrationArea) &&
        Objects.equals(this.mobilityRestrictions, amFRegistrationAccData.mobilityRestrictions) &&
        Objects.equals(this.pdUSessionStatus, amFRegistrationAccData.pdUSessionStatus) &&
        Objects.equals(this.allowedNSSAI, amFRegistrationAccData.allowedNSSAI) &&
        Objects.equals(this.periodicRegistrationUpdateTimer, amFRegistrationAccData.periodicRegistrationUpdateTimer) &&
        Objects.equals(this.ladnInformationAndAcceptedMICOMode, amFRegistrationAccData.ladnInformationAndAcceptedMICOMode) &&
        Objects.equals(this.imsVoiceOverPSSessionSupportedIndication, amFRegistrationAccData.imsVoiceOverPSSessionSupportedIndication) &&
        Objects.equals(this.emergencyServiceSupportIndicator, amFRegistrationAccData.emergencyServiceSupportIndicator) &&
        Objects.equals(this.acceptedDRXParameters, amFRegistrationAccData.acceptedDRXParameters) &&
        Objects.equals(this.networkSupportOfInterworkingWithoutN26, amFRegistrationAccData.networkSupportOfInterworkingWithoutN26);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guti, registrationArea, mobilityRestrictions, pdUSessionStatus, allowedNSSAI, periodicRegistrationUpdateTimer, ladnInformationAndAcceptedMICOMode, imsVoiceOverPSSessionSupportedIndication, emergencyServiceSupportIndicator, acceptedDRXParameters, networkSupportOfInterworkingWithoutN26);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFRegistrationAccData {\n");
    
    sb.append("    guti: ").append(toIndentedString(guti)).append("\n");
    sb.append("    registrationArea: ").append(toIndentedString(registrationArea)).append("\n");
    sb.append("    mobilityRestrictions: ").append(toIndentedString(mobilityRestrictions)).append("\n");
    sb.append("    pdUSessionStatus: ").append(toIndentedString(pdUSessionStatus)).append("\n");
    sb.append("    allowedNSSAI: ").append(toIndentedString(allowedNSSAI)).append("\n");
    sb.append("    periodicRegistrationUpdateTimer: ").append(toIndentedString(periodicRegistrationUpdateTimer)).append("\n");
    sb.append("    ladnInformationAndAcceptedMICOMode: ").append(toIndentedString(ladnInformationAndAcceptedMICOMode)).append("\n");
    sb.append("    imsVoiceOverPSSessionSupportedIndication: ").append(toIndentedString(imsVoiceOverPSSessionSupportedIndication)).append("\n");
    sb.append("    emergencyServiceSupportIndicator: ").append(toIndentedString(emergencyServiceSupportIndicator)).append("\n");
    sb.append("    acceptedDRXParameters: ").append(toIndentedString(acceptedDRXParameters)).append("\n");
    sb.append("    networkSupportOfInterworkingWithoutN26: ").append(toIndentedString(networkSupportOfInterworkingWithoutN26)).append("\n");
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

