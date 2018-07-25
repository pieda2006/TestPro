package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DnnInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class DnnInfo   {
  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("defaultDnnIndicator")
  private Boolean defaultDnnIndicator = null;

  @JsonProperty("lboRoamingAllowed")
  private Boolean lboRoamingAllowed = null;

  public DnnInfo dnn(String dnn) {
    this.dnn = dnn;
    return this;
  }

  /**
   * Get dnn
   * @return dnn
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDnn() {
    return dnn;
  }

  public void setDnn(String dnn) {
    this.dnn = dnn;
  }

  public DnnInfo defaultDnnIndicator(Boolean defaultDnnIndicator) {
    this.defaultDnnIndicator = defaultDnnIndicator;
    return this;
  }

  /**
   * Get defaultDnnIndicator
   * @return defaultDnnIndicator
  **/
  @ApiModelProperty(value = "")


  public Boolean isDefaultDnnIndicator() {
    return defaultDnnIndicator;
  }

  public void setDefaultDnnIndicator(Boolean defaultDnnIndicator) {
    this.defaultDnnIndicator = defaultDnnIndicator;
  }

  public DnnInfo lboRoamingAllowed(Boolean lboRoamingAllowed) {
    this.lboRoamingAllowed = lboRoamingAllowed;
    return this;
  }

  /**
   * Get lboRoamingAllowed
   * @return lboRoamingAllowed
  **/
  @ApiModelProperty(value = "")


  public Boolean isLboRoamingAllowed() {
    return lboRoamingAllowed;
  }

  public void setLboRoamingAllowed(Boolean lboRoamingAllowed) {
    this.lboRoamingAllowed = lboRoamingAllowed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DnnInfo dnnInfo = (DnnInfo) o;
    return Objects.equals(this.dnn, dnnInfo.dnn) &&
        Objects.equals(this.defaultDnnIndicator, dnnInfo.defaultDnnIndicator) &&
        Objects.equals(this.lboRoamingAllowed, dnnInfo.lboRoamingAllowed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dnn, defaultDnnIndicator, lboRoamingAllowed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DnnInfo {\n");
    
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    defaultDnnIndicator: ").append(toIndentedString(defaultDnnIndicator)).append("\n");
    sb.append("    lboRoamingAllowed: ").append(toIndentedString(lboRoamingAllowed)).append("\n");
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

