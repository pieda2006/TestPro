package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2InfoContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFPwsInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFPwsInformation   {
  @JsonProperty("messageIdentifier")
  private Integer messageIdentifier = null;

  @JsonProperty("serialNumber")
  private Integer serialNumber = null;

  @JsonProperty("pwsContainer")
  private AMFN2InfoContent pwsContainer = null;

  @JsonProperty("sendN2Container")
  private Boolean sendN2Container = null;

  @JsonProperty("omcId")
  private String omcId = null;

  public AMFPwsInformation messageIdentifier(Integer messageIdentifier) {
    this.messageIdentifier = messageIdentifier;
    return this;
  }

  /**
   * Get messageIdentifier
   * @return messageIdentifier
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getMessageIdentifier() {
    return messageIdentifier;
  }

  public void setMessageIdentifier(Integer messageIdentifier) {
    this.messageIdentifier = messageIdentifier;
  }

  public AMFPwsInformation serialNumber(Integer serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  /**
   * Get serialNumber
   * @return serialNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(Integer serialNumber) {
    this.serialNumber = serialNumber;
  }

  public AMFPwsInformation pwsContainer(AMFN2InfoContent pwsContainer) {
    this.pwsContainer = pwsContainer;
    return this;
  }

  /**
   * Get pwsContainer
   * @return pwsContainer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFN2InfoContent getPwsContainer() {
    return pwsContainer;
  }

  public void setPwsContainer(AMFN2InfoContent pwsContainer) {
    this.pwsContainer = pwsContainer;
  }

  public AMFPwsInformation sendN2Container(Boolean sendN2Container) {
    this.sendN2Container = sendN2Container;
    return this;
  }

  /**
   * Get sendN2Container
   * @return sendN2Container
  **/
  @ApiModelProperty(value = "")


  public Boolean isSendN2Container() {
    return sendN2Container;
  }

  public void setSendN2Container(Boolean sendN2Container) {
    this.sendN2Container = sendN2Container;
  }

  public AMFPwsInformation omcId(String omcId) {
    this.omcId = omcId;
    return this;
  }

  /**
   * Definition of OmcIdentifier is not found
   * @return omcId
  **/
  @ApiModelProperty(value = "Definition of OmcIdentifier is not found")


  public String getOmcId() {
    return omcId;
  }

  public void setOmcId(String omcId) {
    this.omcId = omcId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFPwsInformation amFPwsInformation = (AMFPwsInformation) o;
    return Objects.equals(this.messageIdentifier, amFPwsInformation.messageIdentifier) &&
        Objects.equals(this.serialNumber, amFPwsInformation.serialNumber) &&
        Objects.equals(this.pwsContainer, amFPwsInformation.pwsContainer) &&
        Objects.equals(this.sendN2Container, amFPwsInformation.sendN2Container) &&
        Objects.equals(this.omcId, amFPwsInformation.omcId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageIdentifier, serialNumber, pwsContainer, sendN2Container, omcId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFPwsInformation {\n");
    
    sb.append("    messageIdentifier: ").append(toIndentedString(messageIdentifier)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    pwsContainer: ").append(toIndentedString(pwsContainer)).append("\n");
    sb.append("    sendN2Container: ").append(toIndentedString(sendN2Container)).append("\n");
    sb.append("    omcId: ").append(toIndentedString(omcId)).append("\n");
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

