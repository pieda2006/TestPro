package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.Arp;
import com.nec.corestudy.amf.NamfSmfCLI.model.Dynamic5qi;
import com.nec.corestudy.amf.NamfSmfCLI.model.GbrQosFlowInformation;
import com.nec.corestudy.amf.NamfSmfCLI.model.NonDynamic5qi;
import com.nec.corestudy.amf.NamfSmfCLI.model.ReflectiveQosAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * QosFlowProfile
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class QosFlowProfile   {
  @JsonProperty("5qi")
  private Integer _5qi = null;

  @JsonProperty("nonDynamic5qi")
  private NonDynamic5qi nonDynamic5qi = null;

  @JsonProperty("dynamic5qi")
  private Dynamic5qi dynamic5qi = null;

  @JsonProperty("arp")
  private Arp arp = null;

  @JsonProperty("gbrQosFlowInfo")
  private GbrQosFlowInformation gbrQosFlowInfo = null;

  @JsonProperty("rqa")
  private ReflectiveQosAttribute rqa = null;

  public QosFlowProfile _5qi(Integer _5qi) {
    this._5qi = _5qi;
    return this;
  }

  /**
   * Get _5qi
   * @return _5qi
  **/
  @ApiModelProperty(value = "")
  public Integer get5qi() {
    return _5qi;
  }

  public void set5qi(Integer _5qi) {
    this._5qi = _5qi;
  }

  public QosFlowProfile nonDynamic5qi(NonDynamic5qi nonDynamic5qi) {
    this.nonDynamic5qi = nonDynamic5qi;
    return this;
  }

  /**
   * Get nonDynamic5qi
   * @return nonDynamic5qi
  **/
  @ApiModelProperty(value = "")
  public NonDynamic5qi getNonDynamic5qi() {
    return nonDynamic5qi;
  }

  public void setNonDynamic5qi(NonDynamic5qi nonDynamic5qi) {
    this.nonDynamic5qi = nonDynamic5qi;
  }

  public QosFlowProfile dynamic5qi(Dynamic5qi dynamic5qi) {
    this.dynamic5qi = dynamic5qi;
    return this;
  }

  /**
   * Get dynamic5qi
   * @return dynamic5qi
  **/
  @ApiModelProperty(value = "")
  public Dynamic5qi getDynamic5qi() {
    return dynamic5qi;
  }

  public void setDynamic5qi(Dynamic5qi dynamic5qi) {
    this.dynamic5qi = dynamic5qi;
  }

  public QosFlowProfile arp(Arp arp) {
    this.arp = arp;
    return this;
  }

  /**
   * Get arp
   * @return arp
  **/
  @ApiModelProperty(value = "")
  public Arp getArp() {
    return arp;
  }

  public void setArp(Arp arp) {
    this.arp = arp;
  }

  public QosFlowProfile gbrQosFlowInfo(GbrQosFlowInformation gbrQosFlowInfo) {
    this.gbrQosFlowInfo = gbrQosFlowInfo;
    return this;
  }

  /**
   * Get gbrQosFlowInfo
   * @return gbrQosFlowInfo
  **/
  @ApiModelProperty(value = "")
  public GbrQosFlowInformation getGbrQosFlowInfo() {
    return gbrQosFlowInfo;
  }

  public void setGbrQosFlowInfo(GbrQosFlowInformation gbrQosFlowInfo) {
    this.gbrQosFlowInfo = gbrQosFlowInfo;
  }

  public QosFlowProfile rqa(ReflectiveQosAttribute rqa) {
    this.rqa = rqa;
    return this;
  }

  /**
   * Get rqa
   * @return rqa
  **/
  @ApiModelProperty(value = "")
  public ReflectiveQosAttribute getRqa() {
    return rqa;
  }

  public void setRqa(ReflectiveQosAttribute rqa) {
    this.rqa = rqa;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QosFlowProfile qosFlowProfile = (QosFlowProfile) o;
    return Objects.equals(this._5qi, qosFlowProfile._5qi) &&
        Objects.equals(this.nonDynamic5qi, qosFlowProfile.nonDynamic5qi) &&
        Objects.equals(this.dynamic5qi, qosFlowProfile.dynamic5qi) &&
        Objects.equals(this.arp, qosFlowProfile.arp) &&
        Objects.equals(this.gbrQosFlowInfo, qosFlowProfile.gbrQosFlowInfo) &&
        Objects.equals(this.rqa, qosFlowProfile.rqa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_5qi, nonDynamic5qi, dynamic5qi, arp, gbrQosFlowInfo, rqa);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QosFlowProfile {\n");
    
    sb.append("    _5qi: ").append(toIndentedString(_5qi)).append("\n");
    sb.append("    nonDynamic5qi: ").append(toIndentedString(nonDynamic5qi)).append("\n");
    sb.append("    dynamic5qi: ").append(toIndentedString(dynamic5qi)).append("\n");
    sb.append("    arp: ").append(toIndentedString(arp)).append("\n");
    sb.append("    gbrQosFlowInfo: ").append(toIndentedString(gbrQosFlowInfo)).append("\n");
    sb.append("    rqa: ").append(toIndentedString(rqa)).append("\n");
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

