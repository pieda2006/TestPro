package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.NotificationCause;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * QosFlowNotifyItem
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class QosFlowNotifyItem   {
  @JsonProperty("qfi")
  private Integer qfi = null;

  @JsonProperty("notificationCause")
  private NotificationCause notificationCause = null;

  public QosFlowNotifyItem qfi(Integer qfi) {
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

  public QosFlowNotifyItem notificationCause(NotificationCause notificationCause) {
    this.notificationCause = notificationCause;
    return this;
  }

  /**
   * Get notificationCause
   * @return notificationCause
  **/
  @ApiModelProperty(value = "")
  public NotificationCause getNotificationCause() {
    return notificationCause;
  }

  public void setNotificationCause(NotificationCause notificationCause) {
    this.notificationCause = notificationCause;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QosFlowNotifyItem qosFlowNotifyItem = (QosFlowNotifyItem) o;
    return Objects.equals(this.qfi, qosFlowNotifyItem.qfi) &&
        Objects.equals(this.notificationCause, qosFlowNotifyItem.notificationCause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(qfi, notificationCause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QosFlowNotifyItem {\n");
    
    sb.append("    qfi: ").append(toIndentedString(qfi)).append("\n");
    sb.append("    notificationCause: ").append(toIndentedString(notificationCause)).append("\n");
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

