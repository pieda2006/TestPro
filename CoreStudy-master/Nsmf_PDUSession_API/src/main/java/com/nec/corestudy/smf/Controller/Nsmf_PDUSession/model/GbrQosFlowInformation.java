package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.NotificationControl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GbrQosFlowInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class GbrQosFlowInformation   {
  @JsonProperty("maxFbrDl")
  private String maxFbrDl = null;

  @JsonProperty("maxFbrUl")
  private String maxFbrUl = null;

  @JsonProperty("guaFbrDl")
  private String guaFbrDl = null;

  @JsonProperty("guaFbrUl")
  private String guaFbrUl = null;

  @JsonProperty("notifControl")
  private NotificationControl notifControl = null;

  @JsonProperty("maxPacketLossRateDl")
  private String maxPacketLossRateDl = null;

  @JsonProperty("maxPacketLossRateUl")
  private String maxPacketLossRateUl = null;

  public GbrQosFlowInformation maxFbrDl(String maxFbrDl) {
    this.maxFbrDl = maxFbrDl;
    return this;
  }

  /**
   * Get maxFbrDl
   * @return maxFbrDl
  **/
  @ApiModelProperty(value = "")


  public String getMaxFbrDl() {
    return maxFbrDl;
  }

  public void setMaxFbrDl(String maxFbrDl) {
    this.maxFbrDl = maxFbrDl;
  }

  public GbrQosFlowInformation maxFbrUl(String maxFbrUl) {
    this.maxFbrUl = maxFbrUl;
    return this;
  }

  /**
   * Get maxFbrUl
   * @return maxFbrUl
  **/
  @ApiModelProperty(value = "")


  public String getMaxFbrUl() {
    return maxFbrUl;
  }

  public void setMaxFbrUl(String maxFbrUl) {
    this.maxFbrUl = maxFbrUl;
  }

  public GbrQosFlowInformation guaFbrDl(String guaFbrDl) {
    this.guaFbrDl = guaFbrDl;
    return this;
  }

  /**
   * Get guaFbrDl
   * @return guaFbrDl
  **/
  @ApiModelProperty(value = "")


  public String getGuaFbrDl() {
    return guaFbrDl;
  }

  public void setGuaFbrDl(String guaFbrDl) {
    this.guaFbrDl = guaFbrDl;
  }

  public GbrQosFlowInformation guaFbrUl(String guaFbrUl) {
    this.guaFbrUl = guaFbrUl;
    return this;
  }

  /**
   * Get guaFbrUl
   * @return guaFbrUl
  **/
  @ApiModelProperty(value = "")


  public String getGuaFbrUl() {
    return guaFbrUl;
  }

  public void setGuaFbrUl(String guaFbrUl) {
    this.guaFbrUl = guaFbrUl;
  }

  public GbrQosFlowInformation notifControl(NotificationControl notifControl) {
    this.notifControl = notifControl;
    return this;
  }

  /**
   * Get notifControl
   * @return notifControl
  **/
  @ApiModelProperty(value = "")

  @Valid

  public NotificationControl getNotifControl() {
    return notifControl;
  }

  public void setNotifControl(NotificationControl notifControl) {
    this.notifControl = notifControl;
  }

  public GbrQosFlowInformation maxPacketLossRateDl(String maxPacketLossRateDl) {
    this.maxPacketLossRateDl = maxPacketLossRateDl;
    return this;
  }

  /**
   * Get maxPacketLossRateDl
   * @return maxPacketLossRateDl
  **/
  @ApiModelProperty(value = "")


  public String getMaxPacketLossRateDl() {
    return maxPacketLossRateDl;
  }

  public void setMaxPacketLossRateDl(String maxPacketLossRateDl) {
    this.maxPacketLossRateDl = maxPacketLossRateDl;
  }

  public GbrQosFlowInformation maxPacketLossRateUl(String maxPacketLossRateUl) {
    this.maxPacketLossRateUl = maxPacketLossRateUl;
    return this;
  }

  /**
   * Get maxPacketLossRateUl
   * @return maxPacketLossRateUl
  **/
  @ApiModelProperty(value = "")


  public String getMaxPacketLossRateUl() {
    return maxPacketLossRateUl;
  }

  public void setMaxPacketLossRateUl(String maxPacketLossRateUl) {
    this.maxPacketLossRateUl = maxPacketLossRateUl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GbrQosFlowInformation gbrQosFlowInformation = (GbrQosFlowInformation) o;
    return Objects.equals(this.maxFbrDl, gbrQosFlowInformation.maxFbrDl) &&
        Objects.equals(this.maxFbrUl, gbrQosFlowInformation.maxFbrUl) &&
        Objects.equals(this.guaFbrDl, gbrQosFlowInformation.guaFbrDl) &&
        Objects.equals(this.guaFbrUl, gbrQosFlowInformation.guaFbrUl) &&
        Objects.equals(this.notifControl, gbrQosFlowInformation.notifControl) &&
        Objects.equals(this.maxPacketLossRateDl, gbrQosFlowInformation.maxPacketLossRateDl) &&
        Objects.equals(this.maxPacketLossRateUl, gbrQosFlowInformation.maxPacketLossRateUl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxFbrDl, maxFbrUl, guaFbrDl, guaFbrUl, notifControl, maxPacketLossRateDl, maxPacketLossRateUl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GbrQosFlowInformation {\n");
    
    sb.append("    maxFbrDl: ").append(toIndentedString(maxFbrDl)).append("\n");
    sb.append("    maxFbrUl: ").append(toIndentedString(maxFbrUl)).append("\n");
    sb.append("    guaFbrDl: ").append(toIndentedString(guaFbrDl)).append("\n");
    sb.append("    guaFbrUl: ").append(toIndentedString(guaFbrUl)).append("\n");
    sb.append("    notifControl: ").append(toIndentedString(notifControl)).append("\n");
    sb.append("    maxPacketLossRateDl: ").append(toIndentedString(maxPacketLossRateDl)).append("\n");
    sb.append("    maxPacketLossRateUl: ").append(toIndentedString(maxPacketLossRateUl)).append("\n");
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

