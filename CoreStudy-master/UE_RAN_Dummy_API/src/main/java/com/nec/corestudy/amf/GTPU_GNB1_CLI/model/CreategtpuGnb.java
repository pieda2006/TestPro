package com.nec.corestudy.amf.GTPU_GNB1_CLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CreategtpuGnb
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-12T13:57:30.887+09:00")

public class CreategtpuGnb   {
  @JsonProperty("dst_ip")
  private String dstIp = null;

  @JsonProperty("ue_ip_mask")
  private String ueIpMask = null;

  @JsonProperty("ue_gw")
  private String ueGw = null;

  public CreategtpuGnb dstIp(String dstIp) {
    this.dstIp = dstIp;
    return this;
  }

  /**
   * ex.)192.168.1.1
   * @return dstIp
  **/
  @ApiModelProperty(required = true, value = "ex.)192.168.1.1")
  public String getDstIp() {
    return dstIp;
  }

  public void setDstIp(String dstIp) {
    this.dstIp = dstIp;
  }

  public CreategtpuGnb ueIpMask(String ueIpMask) {
    this.ueIpMask = ueIpMask;
    return this;
  }

  /**
   * ex.)192.168.0.1/24
   * @return ueIpMask
  **/
  @ApiModelProperty(required = true, value = "ex.)192.168.0.1/24")
  public String getUeIpMask() {
    return ueIpMask;
  }

  public void setUeIpMask(String ueIpMask) {
    this.ueIpMask = ueIpMask;
  }

  public CreategtpuGnb ueGw(String ueGw) {
    this.ueGw = ueGw;
    return this;
  }

  /**
   * ex.)192.168.0.254
   * @return ueGw
  **/
  @ApiModelProperty(required = true, value = "ex.)192.168.0.254")
  public String getUeGw() {
    return ueGw;
  }

  public void setUeGw(String ueGw) {
    this.ueGw = ueGw;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreategtpuGnb creategtpuGnb = (CreategtpuGnb) o;
    return Objects.equals(this.dstIp, creategtpuGnb.dstIp) &&
        Objects.equals(this.ueIpMask, creategtpuGnb.ueIpMask) &&
        Objects.equals(this.ueGw, creategtpuGnb.ueGw);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dstIp, ueIpMask, ueGw);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreategtpuGnb {\n");
    
    sb.append("    dstIp: ").append(toIndentedString(dstIp)).append("\n");
    sb.append("    ueIpMask: ").append(toIndentedString(ueIpMask)).append("\n");
    sb.append("    ueGw: ").append(toIndentedString(ueGw)).append("\n");
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

