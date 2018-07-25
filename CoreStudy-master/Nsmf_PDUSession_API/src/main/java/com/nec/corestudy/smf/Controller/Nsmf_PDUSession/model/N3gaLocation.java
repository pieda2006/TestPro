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
 * N3gaLocation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class N3gaLocation   {
  @JsonProperty("ueIpv4Addr")
  private String ueIpv4Addr = null;

  @JsonProperty("ueIpv6Addr")
  private String ueIpv6Addr = null;

  @JsonProperty("portNumber")
  private Integer portNumber = null;

  public N3gaLocation ueIpv4Addr(String ueIpv4Addr) {
    this.ueIpv4Addr = ueIpv4Addr;
    return this;
  }

  /**
   * Get ueIpv4Addr
   * @return ueIpv4Addr
  **/
  @ApiModelProperty(value = "")


  public String getUeIpv4Addr() {
    return ueIpv4Addr;
  }

  public void setUeIpv4Addr(String ueIpv4Addr) {
    this.ueIpv4Addr = ueIpv4Addr;
  }

  public N3gaLocation ueIpv6Addr(String ueIpv6Addr) {
    this.ueIpv6Addr = ueIpv6Addr;
    return this;
  }

  /**
   * Get ueIpv6Addr
   * @return ueIpv6Addr
  **/
  @ApiModelProperty(value = "")


  public String getUeIpv6Addr() {
    return ueIpv6Addr;
  }

  public void setUeIpv6Addr(String ueIpv6Addr) {
    this.ueIpv6Addr = ueIpv6Addr;
  }

  public N3gaLocation portNumber(Integer portNumber) {
    this.portNumber = portNumber;
    return this;
  }

  /**
   * Get portNumber
   * @return portNumber
  **/
  @ApiModelProperty(value = "")


  public Integer getPortNumber() {
    return portNumber;
  }

  public void setPortNumber(Integer portNumber) {
    this.portNumber = portNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    N3gaLocation n3gaLocation = (N3gaLocation) o;
    return Objects.equals(this.ueIpv4Addr, n3gaLocation.ueIpv4Addr) &&
        Objects.equals(this.ueIpv6Addr, n3gaLocation.ueIpv6Addr) &&
        Objects.equals(this.portNumber, n3gaLocation.portNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ueIpv4Addr, ueIpv6Addr, portNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class N3gaLocation {\n");
    
    sb.append("    ueIpv4Addr: ").append(toIndentedString(ueIpv4Addr)).append("\n");
    sb.append("    ueIpv6Addr: ").append(toIndentedString(ueIpv6Addr)).append("\n");
    sb.append("    portNumber: ").append(toIndentedString(portNumber)).append("\n");
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

