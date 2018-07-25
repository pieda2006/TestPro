package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.QosFlowAddModifyRequestItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * QosFlowsAddModifyRequestList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class QosFlowsAddModifyRequestList   {
  @JsonProperty("qosFlowItem")
  private QosFlowAddModifyRequestItem qosFlowItem = null;

  public QosFlowsAddModifyRequestList qosFlowItem(QosFlowAddModifyRequestItem qosFlowItem) {
    this.qosFlowItem = qosFlowItem;
    return this;
  }

  /**
   * Get qosFlowItem
   * @return qosFlowItem
  **/
  @ApiModelProperty(value = "")

  @Valid

  public QosFlowAddModifyRequestItem getQosFlowItem() {
    return qosFlowItem;
  }

  public void setQosFlowItem(QosFlowAddModifyRequestItem qosFlowItem) {
    this.qosFlowItem = qosFlowItem;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QosFlowsAddModifyRequestList qosFlowsAddModifyRequestList = (QosFlowsAddModifyRequestList) o;
    return Objects.equals(this.qosFlowItem, qosFlowsAddModifyRequestList.qosFlowItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qosFlowItem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QosFlowsAddModifyRequestList {\n");
    
    sb.append("    qosFlowItem: ").append(toIndentedString(qosFlowItem)).append("\n");
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

