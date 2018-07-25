package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSdmCLI.model.PduSessionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * PduSessionTypes
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:45.878+09:00")

public class PduSessionTypes   {
  @JsonProperty("defaultSessionType")
  private PduSessionType defaultSessionType = null;

  @JsonProperty("allowedSessionType")
  
  private List<PduSessionType> allowedSessionType = null;

  public PduSessionTypes defaultSessionType(PduSessionType defaultSessionType) {
    this.defaultSessionType = defaultSessionType;
    return this;
  }

  /**
   * Get defaultSessionType
   * @return defaultSessionType
  **/
  @ApiModelProperty(required = true, value = "")
  public PduSessionType getDefaultSessionType() {
    return defaultSessionType;
  }

  public void setDefaultSessionType(PduSessionType defaultSessionType) {
    this.defaultSessionType = defaultSessionType;
  }

  public PduSessionTypes allowedSessionType(List<PduSessionType> allowedSessionType) {
    this.allowedSessionType = allowedSessionType;
    return this;
  }

  public PduSessionTypes addAllowedSessionTypeItem(PduSessionType allowedSessionTypeItem) {
    if (this.allowedSessionType == null) {
      this.allowedSessionType = new ArrayList<PduSessionType>();
    }
    this.allowedSessionType.add(allowedSessionTypeItem);
    return this;
  }

  /**
   * Get allowedSessionType
   * @return allowedSessionType
  **/
  @ApiModelProperty(value = "")
  public List<PduSessionType> getAllowedSessionType() {
    return allowedSessionType;
  }

  public void setAllowedSessionType(List<PduSessionType> allowedSessionType) {
    this.allowedSessionType = allowedSessionType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PduSessionTypes pduSessionTypes = (PduSessionTypes) o;
    return Objects.equals(this.defaultSessionType, pduSessionTypes.defaultSessionType) &&
        Objects.equals(this.allowedSessionType, pduSessionTypes.allowedSessionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultSessionType, allowedSessionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PduSessionTypes {\n");
    
    sb.append("    defaultSessionType: ").append(toIndentedString(defaultSessionType)).append("\n");
    sb.append("    allowedSessionType: ").append(toIndentedString(allowedSessionType)).append("\n");
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

