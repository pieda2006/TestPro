package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfCommunication.model.AMFArp;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN1MessageContainer;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2InfoContainer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFN1N2MessageData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFN1N2MessageData   {
  @JsonProperty("n1MessageContainer")
  private AMFN1MessageContainer n1MessageContainer = null;

  @JsonProperty("n2InfoContainer")
  private AMFN2InfoContainer n2InfoContainer = null;

  @JsonProperty("lastMsgIndication")
  private Boolean lastMsgIndication = null;

  @JsonProperty("sessionId")
  private String sessionId = null;

  /**
   * Gets or Sets anType
   */
  public enum AnTypeEnum {
    _3GPP_ACCESS("Jamf_3GPP_ACCESS"),
    
    NON_3GPP_ACCESS("Jamf_NON_3GPP_ACCESS");

    private String value;

    AnTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AnTypeEnum fromValue(String text) {
      for (AnTypeEnum b : AnTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("anType")
  private AnTypeEnum anType = null;

  @JsonProperty("ppi")
  private Integer ppi = null;

  @JsonProperty("arp")
  private AMFArp arp = null;

  @JsonProperty("fiveQi")
  private Integer fiveQi = null;

  @JsonProperty("n1n2FailureTxfNotifURI")
  private String n1n2FailureTxfNotifURI = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public AMFN1N2MessageData n1MessageContainer(AMFN1MessageContainer n1MessageContainer) {
    this.n1MessageContainer = n1MessageContainer;
    return this;
  }

  /**
   * Get n1MessageContainer
   * @return n1MessageContainer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFN1MessageContainer getN1MessageContainer() {
    return n1MessageContainer;
  }

  public void setN1MessageContainer(AMFN1MessageContainer n1MessageContainer) {
    this.n1MessageContainer = n1MessageContainer;
  }

  public AMFN1N2MessageData n2InfoContainer(AMFN2InfoContainer n2InfoContainer) {
    this.n2InfoContainer = n2InfoContainer;
    return this;
  }

  /**
   * Get n2InfoContainer
   * @return n2InfoContainer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFN2InfoContainer getN2InfoContainer() {
    return n2InfoContainer;
  }

  public void setN2InfoContainer(AMFN2InfoContainer n2InfoContainer) {
    this.n2InfoContainer = n2InfoContainer;
  }

  public AMFN1N2MessageData lastMsgIndication(Boolean lastMsgIndication) {
    this.lastMsgIndication = lastMsgIndication;
    return this;
  }

  /**
   * Get lastMsgIndication
   * @return lastMsgIndication
  **/
  @ApiModelProperty(value = "")


  public Boolean isLastMsgIndication() {
    return lastMsgIndication;
  }

  public void setLastMsgIndication(Boolean lastMsgIndication) {
    this.lastMsgIndication = lastMsgIndication;
  }

  public AMFN1N2MessageData sessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  /**
   * Get sessionId
   * @return sessionId
  **/
  @ApiModelProperty(value = "")


  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public AMFN1N2MessageData anType(AnTypeEnum anType) {
    this.anType = anType;
    return this;
  }

  /**
   * Get anType
   * @return anType
  **/
  @ApiModelProperty(value = "")


  public AnTypeEnum getAnType() {
    return anType;
  }

  public void setAnType(AnTypeEnum anType) {
    this.anType = anType;
  }

  public AMFN1N2MessageData ppi(Integer ppi) {
    this.ppi = ppi;
    return this;
  }

  /**
   * Get ppi
   * @return ppi
  **/
  @ApiModelProperty(value = "")


  public Integer getPpi() {
    return ppi;
  }

  public void setPpi(Integer ppi) {
    this.ppi = ppi;
  }

  public AMFN1N2MessageData arp(AMFArp arp) {
    this.arp = arp;
    return this;
  }

  /**
   * Get arp
   * @return arp
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFArp getArp() {
    return arp;
  }

  public void setArp(AMFArp arp) {
    this.arp = arp;
  }

  public AMFN1N2MessageData fiveQi(Integer fiveQi) {
    this.fiveQi = fiveQi;
    return this;
  }

  /**
   * Get fiveQi
   * @return fiveQi
  **/
  @ApiModelProperty(value = "")


  public Integer getFiveQi() {
    return fiveQi;
  }

  public void setFiveQi(Integer fiveQi) {
    this.fiveQi = fiveQi;
  }

  public AMFN1N2MessageData n1n2FailureTxfNotifURI(String n1n2FailureTxfNotifURI) {
    this.n1n2FailureTxfNotifURI = n1n2FailureTxfNotifURI;
    return this;
  }

  /**
   * Get n1n2FailureTxfNotifURI
   * @return n1n2FailureTxfNotifURI
  **/
  @ApiModelProperty(value = "")


  public String getN1n2FailureTxfNotifURI() {
    return n1n2FailureTxfNotifURI;
  }

  public void setN1n2FailureTxfNotifURI(String n1n2FailureTxfNotifURI) {
    this.n1n2FailureTxfNotifURI = n1n2FailureTxfNotifURI;
  }

  public AMFN1N2MessageData supportedFeatures(String supportedFeatures) {
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
    AMFN1N2MessageData amFN1N2MessageData = (AMFN1N2MessageData) o;
    return Objects.equals(this.n1MessageContainer, amFN1N2MessageData.n1MessageContainer) &&
        Objects.equals(this.n2InfoContainer, amFN1N2MessageData.n2InfoContainer) &&
        Objects.equals(this.lastMsgIndication, amFN1N2MessageData.lastMsgIndication) &&
        Objects.equals(this.sessionId, amFN1N2MessageData.sessionId) &&
        Objects.equals(this.anType, amFN1N2MessageData.anType) &&
        Objects.equals(this.ppi, amFN1N2MessageData.ppi) &&
        Objects.equals(this.arp, amFN1N2MessageData.arp) &&
        Objects.equals(this.fiveQi, amFN1N2MessageData.fiveQi) &&
        Objects.equals(this.n1n2FailureTxfNotifURI, amFN1N2MessageData.n1n2FailureTxfNotifURI) &&
        Objects.equals(this.supportedFeatures, amFN1N2MessageData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(n1MessageContainer, n2InfoContainer, lastMsgIndication, sessionId, anType, ppi, arp, fiveQi, n1n2FailureTxfNotifURI, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN1N2MessageData {\n");
    
    sb.append("    n1MessageContainer: ").append(toIndentedString(n1MessageContainer)).append("\n");
    sb.append("    n2InfoContainer: ").append(toIndentedString(n2InfoContainer)).append("\n");
    sb.append("    lastMsgIndication: ").append(toIndentedString(lastMsgIndication)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
    sb.append("    anType: ").append(toIndentedString(anType)).append("\n");
    sb.append("    ppi: ").append(toIndentedString(ppi)).append("\n");
    sb.append("    arp: ").append(toIndentedString(arp)).append("\n");
    sb.append("    fiveQi: ").append(toIndentedString(fiveQi)).append("\n");
    sb.append("    n1n2FailureTxfNotifURI: ").append(toIndentedString(n1n2FailureTxfNotifURI)).append("\n");
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

