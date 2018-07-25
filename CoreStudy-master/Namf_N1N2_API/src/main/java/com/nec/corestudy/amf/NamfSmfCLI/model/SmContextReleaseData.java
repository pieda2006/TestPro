package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.UserLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * SmContextReleaseData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class SmContextReleaseData   {
  @JsonProperty("ueLocation")
  private UserLocation ueLocation = null;

  @JsonProperty("ueTimeZone")
  private String ueTimeZone = null;

  @JsonProperty("vsmfReleaseOnly")
  private Boolean vsmfReleaseOnly = null;

  public SmContextReleaseData ueLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
    return this;
  }

  /**
   * Get ueLocation
   * @return ueLocation
  **/
  @ApiModelProperty(value = "")
  public UserLocation getUeLocation() {
    return ueLocation;
  }

  public void setUeLocation(UserLocation ueLocation) {
    this.ueLocation = ueLocation;
  }

  public SmContextReleaseData ueTimeZone(String ueTimeZone) {
    this.ueTimeZone = ueTimeZone;
    return this;
  }

  /**
   * Get ueTimeZone
   * @return ueTimeZone
  **/
  @ApiModelProperty(value = "")
  public String getUeTimeZone() {
    return ueTimeZone;
  }

  public void setUeTimeZone(String ueTimeZone) {
    this.ueTimeZone = ueTimeZone;
  }

  public SmContextReleaseData vsmfReleaseOnly(Boolean vsmfReleaseOnly) {
    this.vsmfReleaseOnly = vsmfReleaseOnly;
    return this;
  }

  /**
   * Get vsmfReleaseOnly
   * @return vsmfReleaseOnly
  **/
  @ApiModelProperty(value = "")
  public Boolean isVsmfReleaseOnly() {
    return vsmfReleaseOnly;
  }

  public void setVsmfReleaseOnly(Boolean vsmfReleaseOnly) {
    this.vsmfReleaseOnly = vsmfReleaseOnly;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmContextReleaseData smContextReleaseData = (SmContextReleaseData) o;
    return Objects.equals(this.ueLocation, smContextReleaseData.ueLocation) &&
        Objects.equals(this.ueTimeZone, smContextReleaseData.ueTimeZone) &&
        Objects.equals(this.vsmfReleaseOnly, smContextReleaseData.vsmfReleaseOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ueLocation, ueTimeZone, vsmfReleaseOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmContextReleaseData {\n");
    
    sb.append("    ueLocation: ").append(toIndentedString(ueLocation)).append("\n");
    sb.append("    ueTimeZone: ").append(toIndentedString(ueTimeZone)).append("\n");
    sb.append("    vsmfReleaseOnly: ").append(toIndentedString(vsmfReleaseOnly)).append("\n");
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

