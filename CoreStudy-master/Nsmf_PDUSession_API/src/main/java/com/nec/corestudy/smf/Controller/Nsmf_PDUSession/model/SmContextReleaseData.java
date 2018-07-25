package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.UserLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmContextReleaseData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

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

  @Valid

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

