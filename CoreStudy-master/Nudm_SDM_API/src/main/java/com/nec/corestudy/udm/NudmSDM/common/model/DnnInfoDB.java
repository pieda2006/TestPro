package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DnnInfoDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class DnnInfoDB   {
  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("defaultDnnIndicator")
  private Boolean defaultDnnIndicator = null;

  @JsonProperty("lboRoamingAllowed")
  private Boolean lboRoamingAllowed = null;

  public DnnInfoDB dnn(String dnn) {
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

  public DnnInfoDB defaultDnnIndicator(Boolean defaultDnnIndicator) {
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

  public DnnInfoDB lboRoamingAllowed(Boolean lboRoamingAllowed) {
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
    DnnInfoDB dnnInfoDB = (DnnInfoDB) o;
    return Objects.equals(this.dnn, dnnInfoDB.dnn) &&
        Objects.equals(this.defaultDnnIndicator, dnnInfoDB.defaultDnnIndicator) &&
        Objects.equals(this.lboRoamingAllowed, dnnInfoDB.lboRoamingAllowed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dnn, defaultDnnIndicator, lboRoamingAllowed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DnnInfoDB {\n");
    
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

