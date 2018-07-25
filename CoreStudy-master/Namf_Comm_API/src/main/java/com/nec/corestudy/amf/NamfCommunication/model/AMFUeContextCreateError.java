package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFProblemDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFUeContextCreateError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFUeContextCreateError   {
  @JsonProperty("error")
  private AMFProblemDetails error = null;

  @JsonProperty("ngapCause")
  private Integer ngapCause = null;

  public AMFUeContextCreateError error(AMFProblemDetails error) {
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

  public AMFUeContextCreateError ngapCause(Integer ngapCause) {
    this.ngapCause = ngapCause;
    return this;
  }

  /**
   * Get ngapCause
   * @return ngapCause
  **/
  @ApiModelProperty(value = "")


  public Integer getNgapCause() {
    return ngapCause;
  }

  public void setNgapCause(Integer ngapCause) {
    this.ngapCause = ngapCause;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFUeContextCreateError amFUeContextCreateError = (AMFUeContextCreateError) o;
    return Objects.equals(this.error, amFUeContextCreateError.error) &&
        Objects.equals(this.ngapCause, amFUeContextCreateError.ngapCause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, ngapCause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFUeContextCreateError {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    ngapCause: ").append(toIndentedString(ngapCause)).append("\n");
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

