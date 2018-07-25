package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFN2N2MsgTxfrErrDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFN2N2MsgTxfrErrDetail   {
  @JsonProperty("retryAfter")
  private Integer retryAfter = null;

  public AMFN2N2MsgTxfrErrDetail retryAfter(Integer retryAfter) {
    this.retryAfter = retryAfter;
    return this;
  }

  /**
   * Get retryAfter
   * @return retryAfter
  **/
  @ApiModelProperty(value = "")


  public Integer getRetryAfter() {
    return retryAfter;
  }

  public void setRetryAfter(Integer retryAfter) {
    this.retryAfter = retryAfter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN2N2MsgTxfrErrDetail amFN2N2MsgTxfrErrDetail = (AMFN2N2MsgTxfrErrDetail) o;
    return Objects.equals(this.retryAfter, amFN2N2MsgTxfrErrDetail.retryAfter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retryAfter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN2N2MsgTxfrErrDetail {\n");
    
    sb.append("    retryAfter: ").append(toIndentedString(retryAfter)).append("\n");
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

