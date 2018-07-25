package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SessionAmbr
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class SessionAmbr   {
  @JsonProperty("uplink")
  private String uplink = null;

  @JsonProperty("downlink")
  private String downlink = null;

  public SessionAmbr uplink(String uplink) {
    this.uplink = uplink;
    return this;
  }

  /**
   * Get uplink
   * @return uplink
  **/
  @ApiModelProperty(value = "")


  public String getUplink() {
    return uplink;
  }

  public void setUplink(String uplink) {
    this.uplink = uplink;
  }

  public SessionAmbr downlink(String downlink) {
    this.downlink = downlink;
    return this;
  }

  /**
   * Get downlink
   * @return downlink
  **/
  @ApiModelProperty(value = "")


  public String getDownlink() {
    return downlink;
  }

  public void setDownlink(String downlink) {
    this.downlink = downlink;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionAmbr sessionAmbr = (SessionAmbr) o;
    return Objects.equals(this.uplink, sessionAmbr.uplink) &&
        Objects.equals(this.downlink, sessionAmbr.downlink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uplink, downlink);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionAmbr {\n");
    
    sb.append("    uplink: ").append(toIndentedString(uplink)).append("\n");
    sb.append("    downlink: ").append(toIndentedString(downlink)).append("\n");
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

