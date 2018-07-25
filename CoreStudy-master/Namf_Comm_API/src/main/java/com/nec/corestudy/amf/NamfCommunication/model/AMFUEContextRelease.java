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
 * AMFUEContextRelease
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFUEContextRelease   {
  @JsonProperty("supi")
  private String supi = null;

  @JsonProperty("indicationFlags")
  private Integer indicationFlags = null;

  @JsonProperty("ngapCause")
  private Integer ngapCause = null;

  public AMFUEContextRelease supi(String supi) {
    this.supi = supi;
    return this;
  }

  /**
   * Get supi
   * @return supi
  **/
  @ApiModelProperty(value = "")


  public String getSupi() {
    return supi;
  }

  public void setSupi(String supi) {
    this.supi = supi;
  }

  public AMFUEContextRelease indicationFlags(Integer indicationFlags) {
    this.indicationFlags = indicationFlags;
    return this;
  }

  /**
   * Get indicationFlags
   * @return indicationFlags
  **/
  @ApiModelProperty(value = "")


  public Integer getIndicationFlags() {
    return indicationFlags;
  }

  public void setIndicationFlags(Integer indicationFlags) {
    this.indicationFlags = indicationFlags;
  }

  public AMFUEContextRelease ngapCause(Integer ngapCause) {
    this.ngapCause = ngapCause;
    return this;
  }

  /**
   * Get ngapCause
   * @return ngapCause
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


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
    AMFUEContextRelease amFUEContextRelease = (AMFUEContextRelease) o;
    return Objects.equals(this.supi, amFUEContextRelease.supi) &&
        Objects.equals(this.indicationFlags, amFUEContextRelease.indicationFlags) &&
        Objects.equals(this.ngapCause, amFUEContextRelease.ngapCause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supi, indicationFlags, ngapCause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFUEContextRelease {\n");
    
    sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
    sb.append("    indicationFlags: ").append(toIndentedString(indicationFlags)).append("\n");
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

