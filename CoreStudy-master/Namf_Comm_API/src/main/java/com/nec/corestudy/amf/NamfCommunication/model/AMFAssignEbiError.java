package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAssignEbiFailed;
import com.nec.corestudy.amf.NamfCommunication.model.AMFProblemDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFAssignEbiError
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAssignEbiError   {
  @JsonProperty("error")
  private AMFProblemDetails error = null;

  @JsonProperty("failureDetails")
  private AMFAssignEbiFailed failureDetails = null;

  public AMFAssignEbiError error(AMFProblemDetails error) {
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

  public AMFAssignEbiError failureDetails(AMFAssignEbiFailed failureDetails) {
    this.failureDetails = failureDetails;
    return this;
  }

  /**
   * Get failureDetails
   * @return failureDetails
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFAssignEbiFailed getFailureDetails() {
    return failureDetails;
  }

  public void setFailureDetails(AMFAssignEbiFailed failureDetails) {
    this.failureDetails = failureDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAssignEbiError amFAssignEbiError = (AMFAssignEbiError) o;
    return Objects.equals(this.error, amFAssignEbiError.error) &&
        Objects.equals(this.failureDetails, amFAssignEbiError.failureDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, failureDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAssignEbiError {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    failureDetails: ").append(toIndentedString(failureDetails)).append("\n");
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

