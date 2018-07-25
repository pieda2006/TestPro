package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * QosFlowReleaseRequestItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class QosFlowReleaseRequestItem   {
  @JsonProperty("qfi")
  private Integer qfi = null;

  @JsonProperty("qosRules")
  private String qosRules = null;

  public QosFlowReleaseRequestItem qfi(Integer qfi) {
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

  public QosFlowReleaseRequestItem qosRules(String qosRules) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QosFlowReleaseRequestItem qosFlowReleaseRequestItem = (QosFlowReleaseRequestItem) o;
    return Objects.equals(this.qfi, qosFlowReleaseRequestItem.qfi) &&
        Objects.equals(this.qosRules, qosFlowReleaseRequestItem.qosRules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qfi, qosRules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QosFlowReleaseRequestItem {\n");
    
    sb.append("    qfi: ").append(toIndentedString(qfi)).append("\n");
    sb.append("    qosRules: ").append(toIndentedString(qosRules)).append("\n");
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

