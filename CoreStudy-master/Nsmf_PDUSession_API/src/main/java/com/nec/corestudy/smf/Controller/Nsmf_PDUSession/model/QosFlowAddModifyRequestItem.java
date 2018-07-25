package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.QosFlowProfile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * QosFlowAddModifyRequestItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class QosFlowAddModifyRequestItem   {
  @JsonProperty("qfi")
  private Integer qfi = null;

  @JsonProperty("qosRules")
  private String qosRules = null;

  @JsonProperty("qosFlowProfile")
  private QosFlowProfile qosFlowProfile = null;

  public QosFlowAddModifyRequestItem qfi(Integer qfi) {
    this.qfi = qfi;
    return this;
  }

  /**
   * Get qfi
   * @return qfi
  **/
  @ApiModelProperty(value = "")


  public Integer getQfi() {
    return qfi;
  }

  public void setQfi(Integer qfi) {
    this.qfi = qfi;
  }

  public QosFlowAddModifyRequestItem qosRules(String qosRules) {
    this.qosRules = qosRules;
    return this;
  }

  /**
   * Get qosRules
   * @return qosRules
  **/
  @ApiModelProperty(value = "")


  public String getQosRules() {
    return qosRules;
  }

  public void setQosRules(String qosRules) {
    this.qosRules = qosRules;
  }

  public QosFlowAddModifyRequestItem qosFlowProfile(QosFlowProfile qosFlowProfile) {
    this.qosFlowProfile = qosFlowProfile;
    return this;
  }

  /**
   * Get qosFlowProfile
   * @return qosFlowProfile
  **/
  @ApiModelProperty(value = "")

  @Valid

  public QosFlowProfile getQosFlowProfile() {
    return qosFlowProfile;
  }

  public void setQosFlowProfile(QosFlowProfile qosFlowProfile) {
    this.qosFlowProfile = qosFlowProfile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QosFlowAddModifyRequestItem qosFlowAddModifyRequestItem = (QosFlowAddModifyRequestItem) o;
    return Objects.equals(this.qfi, qosFlowAddModifyRequestItem.qfi) &&
        Objects.equals(this.qosRules, qosFlowAddModifyRequestItem.qosRules) &&
        Objects.equals(this.qosFlowProfile, qosFlowAddModifyRequestItem.qosFlowProfile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qfi, qosRules, qosFlowProfile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QosFlowAddModifyRequestItem {\n");
    
    sb.append("    qfi: ").append(toIndentedString(qfi)).append("\n");
    sb.append("    qosRules: ").append(toIndentedString(qosRules)).append("\n");
    sb.append("    qosFlowProfile: ").append(toIndentedString(qosFlowProfile)).append("\n");
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

