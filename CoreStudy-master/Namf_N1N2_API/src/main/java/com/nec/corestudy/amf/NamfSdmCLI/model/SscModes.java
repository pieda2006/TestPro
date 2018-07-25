package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSdmCLI.model.SscMode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * SscModes
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:45.878+09:00")

public class SscModes   {
  @JsonProperty("defaultSscMode")
  private SscMode defaultSscMode = null;

  @JsonProperty("allowedSscMode")
  
  private List<SscMode> allowedSscMode = null;

  public SscModes defaultSscMode(SscMode defaultSscMode) {
    this.defaultSscMode = defaultSscMode;
    return this;
  }

  /**
   * Get defaultSscMode
   * @return defaultSscMode
  **/
  @ApiModelProperty(required = true, value = "")
  public SscMode getDefaultSscMode() {
    return defaultSscMode;
  }

  public void setDefaultSscMode(SscMode defaultSscMode) {
    this.defaultSscMode = defaultSscMode;
  }

  public SscModes allowedSscMode(List<SscMode> allowedSscMode) {
    this.allowedSscMode = allowedSscMode;
    return this;
  }

  public SscModes addAllowedSscModeItem(SscMode allowedSscModeItem) {
    if (this.allowedSscMode == null) {
      this.allowedSscMode = new ArrayList<SscMode>();
    }
    this.allowedSscMode.add(allowedSscModeItem);
    return this;
  }

  /**
   * Get allowedSscMode
   * @return allowedSscMode
  **/
  @ApiModelProperty(value = "")
  public List<SscMode> getAllowedSscMode() {
    return allowedSscMode;
  }

  public void setAllowedSscMode(List<SscMode> allowedSscMode) {
    this.allowedSscMode = allowedSscMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SscModes sscModes = (SscModes) o;
    return Objects.equals(this.defaultSscMode, sscModes.defaultSscMode) &&
        Objects.equals(this.allowedSscMode, sscModes.allowedSscMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultSscMode, allowedSscMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SscModes {\n");
    
    sb.append("    defaultSscMode: ").append(toIndentedString(defaultSscMode)).append("\n");
    sb.append("    allowedSscMode: ").append(toIndentedString(allowedSscMode)).append("\n");
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

