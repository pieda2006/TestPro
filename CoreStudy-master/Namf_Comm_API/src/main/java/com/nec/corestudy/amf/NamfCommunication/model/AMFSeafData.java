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
 * AMFSeafData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFSeafData   {
  @JsonProperty("ngKsi")
  private String ngKsi = null;

  @JsonProperty("keyAmf")
  private String keyAmf = null;

  @JsonProperty("TBD")
  private String TBD = null;

  public AMFSeafData ngKsi(String ngKsi) {
    this.ngKsi = ngKsi;
    return this;
  }

  /**
   * Get ngKsi
   * @return ngKsi
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNgKsi() {
    return ngKsi;
  }

  public void setNgKsi(String ngKsi) {
    this.ngKsi = ngKsi;
  }

  public AMFSeafData keyAmf(String keyAmf) {
    this.keyAmf = keyAmf;
    return this;
  }

  /**
   * Get keyAmf
   * @return keyAmf
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getKeyAmf() {
    return keyAmf;
  }

  public void setKeyAmf(String keyAmf) {
    this.keyAmf = keyAmf;
  }

  public AMFSeafData TBD(String TBD) {
    this.TBD = TBD;
    return this;
  }

  /**
   * Get TBD
   * @return TBD
  **/
  @ApiModelProperty(value = "")


  public String getTBD() {
    return TBD;
  }

  public void setTBD(String TBD) {
    this.TBD = TBD;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFSeafData amFSeafData = (AMFSeafData) o;
    return Objects.equals(this.ngKsi, amFSeafData.ngKsi) &&
        Objects.equals(this.keyAmf, amFSeafData.keyAmf) &&
        Objects.equals(this.TBD, amFSeafData.TBD);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ngKsi, keyAmf, TBD);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFSeafData {\n");
    
    sb.append("    ngKsi: ").append(toIndentedString(ngKsi)).append("\n");
    sb.append("    keyAmf: ").append(toIndentedString(keyAmf)).append("\n");
    sb.append("    TBD: ").append(toIndentedString(TBD)).append("\n");
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

