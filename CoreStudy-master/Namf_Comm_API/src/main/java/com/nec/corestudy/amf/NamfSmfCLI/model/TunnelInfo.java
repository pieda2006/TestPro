package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TunnelInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class TunnelInfo   {
  @JsonProperty("ipv4Addr")
  private String ipv4Addr = null;

  @JsonProperty("ipv6Addr")
  private String ipv6Addr = null;

  @JsonProperty("gtpTeid")
  private String gtpTeid = null;

  public TunnelInfo ipv4Addr(String ipv4Addr) {
    this.ipv4Addr = ipv4Addr;
    return this;
  }

  /**
   * Get ipv4Addr
   * @return ipv4Addr
  **/
  @ApiModelProperty(value = "")
  public String getIpv4Addr() {
    return ipv4Addr;
  }

  public void setIpv4Addr(String ipv4Addr) {
    this.ipv4Addr = ipv4Addr;
  }

  public TunnelInfo ipv6Addr(String ipv6Addr) {
    this.ipv6Addr = ipv6Addr;
    return this;
  }

  /**
   * Get ipv6Addr
   * @return ipv6Addr
  **/
  @ApiModelProperty(value = "")
  public String getIpv6Addr() {
    return ipv6Addr;
  }

  public void setIpv6Addr(String ipv6Addr) {
    this.ipv6Addr = ipv6Addr;
  }

  public TunnelInfo gtpTeid(String gtpTeid) {
    this.gtpTeid = gtpTeid;
    return this;
  }

  /**
   * Get gtpTeid
   * @return gtpTeid
  **/
  @ApiModelProperty(value = "")
  public String getGtpTeid() {
    return gtpTeid;
  }

  public void setGtpTeid(String gtpTeid) {
    this.gtpTeid = gtpTeid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TunnelInfo tunnelInfo = (TunnelInfo) o;
    return Objects.equals(this.ipv4Addr, tunnelInfo.ipv4Addr) &&
        Objects.equals(this.ipv6Addr, tunnelInfo.ipv6Addr) &&
        Objects.equals(this.gtpTeid, tunnelInfo.gtpTeid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipv4Addr, ipv6Addr, gtpTeid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TunnelInfo {\n");
    
    sb.append("    ipv4Addr: ").append(toIndentedString(ipv4Addr)).append("\n");
    sb.append("    ipv6Addr: ").append(toIndentedString(ipv6Addr)).append("\n");
    sb.append("    gtpTeid: ").append(toIndentedString(gtpTeid)).append("\n");
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

