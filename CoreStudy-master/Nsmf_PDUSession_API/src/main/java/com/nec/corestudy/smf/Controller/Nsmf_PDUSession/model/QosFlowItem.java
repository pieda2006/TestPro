package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.Cause;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * QosFlowItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class QosFlowItem   {
  @JsonProperty("qfi")
  private Integer qfi = null;

  @JsonProperty("cause")
  private Cause cause = null;

  public QosFlowItem qfi(Integer qfi) {
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

  public QosFlowItem cause(Cause cause) {
    this.cause = cause;
    return this;
  }

  /**
   * Get cause
   * @return cause
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Cause getCause() {
    return cause;
  }

  public void setCause(Cause cause) {
    this.cause = cause;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QosFlowItem qosFlowItem = (QosFlowItem) o;
    return Objects.equals(this.qfi, qosFlowItem.qfi) &&
        Objects.equals(this.cause, qosFlowItem.cause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qfi, cause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QosFlowItem {\n");
    
    sb.append("    qfi: ").append(toIndentedString(qfi)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
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
