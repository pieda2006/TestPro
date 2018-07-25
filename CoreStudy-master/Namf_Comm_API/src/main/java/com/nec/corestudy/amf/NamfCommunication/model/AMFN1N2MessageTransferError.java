package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2N2MsgTxfrErrDetail;
import com.nec.corestudy.amf.NamfCommunication.model.AMFProblemDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFN1N2MessageTransferError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFN1N2MessageTransferError   {
  @JsonProperty("error")
  private AMFProblemDetails error = null;

  @JsonProperty("errInfo")
  private AMFN2N2MsgTxfrErrDetail errInfo = null;

  public AMFN1N2MessageTransferError error(AMFProblemDetails error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFProblemDetails getError() {
    return error;
  }

  public void setError(AMFProblemDetails error) {
    this.error = error;
  }

  public AMFN1N2MessageTransferError errInfo(AMFN2N2MsgTxfrErrDetail errInfo) {
    this.errInfo = errInfo;
    return this;
  }

  /**
   * Get errInfo
   * @return errInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFN2N2MsgTxfrErrDetail getErrInfo() {
    return errInfo;
  }

  public void setErrInfo(AMFN2N2MsgTxfrErrDetail errInfo) {
    this.errInfo = errInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN1N2MessageTransferError amFN1N2MessageTransferError = (AMFN1N2MessageTransferError) o;
    return Objects.equals(this.error, amFN1N2MessageTransferError.error) &&
        Objects.equals(this.errInfo, amFN1N2MessageTransferError.errInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, errInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN1N2MessageTransferError {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errInfo: ").append(toIndentedString(errInfo)).append("\n");
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

