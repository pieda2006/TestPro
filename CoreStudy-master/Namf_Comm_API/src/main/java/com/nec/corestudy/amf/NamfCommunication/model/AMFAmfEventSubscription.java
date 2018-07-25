package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAmfEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFAmfEventSubscription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAmfEventSubscription   {
  @JsonProperty("events")
  private AMFAmfEvent events = null;

  @JsonProperty("notifyUri")
  private String notifyUri = null;

  @JsonProperty("notifCorelationId")
  private String notifCorelationId = null;

  @JsonProperty("nfId")
  private String nfId = null;

  @JsonProperty("supi")
  private String supi = null;

  @JsonProperty("groupId")
  private String groupId = null;

  @JsonProperty("gpsi")
  private String gpsi = null;

  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("anyUE")
  private Boolean anyUE = null;

  public AMFAmfEventSubscription events(AMFAmfEvent events) {
    this.events = events;
    return this;
  }

  /**
   * Get events
   * @return events
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFAmfEvent getEvents() {
    return events;
  }

  public void setEvents(AMFAmfEvent events) {
    this.events = events;
  }

  public AMFAmfEventSubscription notifyUri(String notifyUri) {
    this.notifyUri = notifyUri;
    return this;
  }

  /**
   * Get notifyUri
   * @return notifyUri
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNotifyUri() {
    return notifyUri;
  }

  public void setNotifyUri(String notifyUri) {
    this.notifyUri = notifyUri;
  }

  public AMFAmfEventSubscription notifCorelationId(String notifCorelationId) {
    this.notifCorelationId = notifCorelationId;
    return this;
  }

  /**
   * Get notifCorelationId
   * @return notifCorelationId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNotifCorelationId() {
    return notifCorelationId;
  }

  public void setNotifCorelationId(String notifCorelationId) {
    this.notifCorelationId = notifCorelationId;
  }

  public AMFAmfEventSubscription nfId(String nfId) {
    this.nfId = nfId;
    return this;
  }

  /**
   * Get nfId
   * @return nfId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNfId() {
    return nfId;
  }

  public void setNfId(String nfId) {
    this.nfId = nfId;
  }

  public AMFAmfEventSubscription supi(String supi) {
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

  public AMFAmfEventSubscription groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * Get groupId
   * @return groupId
  **/
  @ApiModelProperty(value = "")


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public AMFAmfEventSubscription gpsi(String gpsi) {
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

  public AMFAmfEventSubscription pei(String pei) {
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

  public AMFAmfEventSubscription anyUE(Boolean anyUE) {
    this.anyUE = anyUE;
    return this;
  }

  /**
   * Get anyUE
   * @return anyUE
  **/
  @ApiModelProperty(value = "")


  public Boolean isAnyUE() {
    return anyUE;
  }

  public void setAnyUE(Boolean anyUE) {
    this.anyUE = anyUE;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAmfEventSubscription amFAmfEventSubscription = (AMFAmfEventSubscription) o;
    return Objects.equals(this.events, amFAmfEventSubscription.events) &&
        Objects.equals(this.notifyUri, amFAmfEventSubscription.notifyUri) &&
        Objects.equals(this.notifCorelationId, amFAmfEventSubscription.notifCorelationId) &&
        Objects.equals(this.nfId, amFAmfEventSubscription.nfId) &&
        Objects.equals(this.supi, amFAmfEventSubscription.supi) &&
        Objects.equals(this.groupId, amFAmfEventSubscription.groupId) &&
        Objects.equals(this.gpsi, amFAmfEventSubscription.gpsi) &&
        Objects.equals(this.pei, amFAmfEventSubscription.pei) &&
        Objects.equals(this.anyUE, amFAmfEventSubscription.anyUE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(events, notifyUri, notifCorelationId, nfId, supi, groupId, gpsi, pei, anyUE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAmfEventSubscription {\n");
    
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    notifyUri: ").append(toIndentedString(notifyUri)).append("\n");
    sb.append("    notifCorelationId: ").append(toIndentedString(notifCorelationId)).append("\n");
    sb.append("    nfId: ").append(toIndentedString(nfId)).append("\n");
    sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    gpsi: ").append(toIndentedString(gpsi)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    anyUE: ").append(toIndentedString(anyUE)).append("\n");
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

