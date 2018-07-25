package com.nec.corestudy.amf.N1N2IF_CLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AMFN2InfoContent
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:33:39.136+09:00")

public class AMFN2InfoContent   {
  @JsonProperty("ngapIeType")
  private Integer ngapIeType = null;

  @JsonProperty("ngapData")
  private String ngapData = null;

  public AMFN2InfoContent ngapIeType(Integer ngapIeType) {
    this.ngapIeType = ngapIeType;
    return this;
  }

  /**
   * Get ngapIeType
   * @return ngapIeType
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getNgapIeType() {
    return ngapIeType;
  }

  public void setNgapIeType(Integer ngapIeType) {
    this.ngapIeType = ngapIeType;
  }

  public AMFN2InfoContent ngapData(String ngapData) {
    this.ngapData = ngapData;
    return this;
  }

  /**
   * Get ngapData
   * @return ngapData
  **/
  @ApiModelProperty(required = true, value = "")
  public String getNgapData() {
    return ngapData;
  }

  public void setNgapData(String ngapData) {
    this.ngapData = ngapData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN2InfoContent amFN2InfoContent = (AMFN2InfoContent) o;
    return Objects.equals(this.ngapIeType, amFN2InfoContent.ngapIeType) &&
        Objects.equals(this.ngapData, amFN2InfoContent.ngapData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ngapIeType, ngapData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN2InfoContent {\n");
    
    sb.append("    ngapIeType: ").append(toIndentedString(ngapIeType)).append("\n");
    sb.append("    ngapData: ").append(toIndentedString(ngapData)).append("\n");
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

