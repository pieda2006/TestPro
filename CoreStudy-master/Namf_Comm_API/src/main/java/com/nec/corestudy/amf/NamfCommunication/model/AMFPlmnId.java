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
 * AMFPlmnId
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFPlmnId   {
  @JsonProperty("mcc")
  private String mcc = null;

  @JsonProperty("mnc")
  private String mnc = null;

  public AMFPlmnId mcc(String mcc) {
    this.mcc = mcc;
    return this;
  }

  /**
   * Get mcc
   * @return mcc
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMcc() {
    return mcc;
  }

  public void setMcc(String mcc) {
    this.mcc = mcc;
  }

  public AMFPlmnId mnc(String mnc) {
    this.mnc = mnc;
    return this;
  }

  /**
   * Get mnc
   * @return mnc
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMnc() {
    return mnc;
  }

  public void setMnc(String mnc) {
    this.mnc = mnc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFPlmnId amFPlmnId = (AMFPlmnId) o;
    return Objects.equals(this.mcc, amFPlmnId.mcc) &&
        Objects.equals(this.mnc, amFPlmnId.mnc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mcc, mnc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFPlmnId {\n");
    
    sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
    sb.append("    mnc: ").append(toIndentedString(mnc)).append("\n");
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
