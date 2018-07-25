package com.nec.corestudy.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.common.model.Tai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * N3gaLocation
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:30:35.896+09:00[Asia/Tokyo]")

public class N3gaLocation   {

  
    

    
  
  @JsonProperty("n3gppTai")
  
  
  
  
  
  
  private Tai n3gppTai = null;
  

  
    

    
  
  @JsonProperty("n3IwfId")
  
  
  
  
  
  
  private String n3IwfId = null;
  

  
    

    
  
  @JsonProperty("ueIpv4Addr")
  
  
  
  
  
  
  private String ueIpv4Addr = null;
  

  
    

    
  
  @JsonProperty("ueIpv6Addr")
  
  
  
  
  
  
  private String ueIpv6Addr = null;
  

  
    

    
  
  @JsonProperty("portNumber")
  
  
  
  
  
  
  private Integer portNumber = null;
  

  
  
  public N3gaLocation n3gppTai(Tai n3gppTai) {
    this.n3gppTai = n3gppTai;
    return this;
  }
  
  

  /**
  
  
   * Get n3gppTai
  
  
  
   * @return n3gppTai
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull

  @Valid

  public Tai getN3gppTai() {
    return n3gppTai;
  }

  public void setN3gppTai(Tai n3gppTai) {
    this.n3gppTai = n3gppTai;
  }

  
  public N3gaLocation n3IwfId(String n3IwfId) {
    this.n3IwfId = n3IwfId;
    return this;
  }
  
  

  /**
  
  
   * Get n3IwfId
  
  
  
   * @return n3IwfId
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getN3IwfId() {
    return n3IwfId;
  }

  public void setN3IwfId(String n3IwfId) {
    this.n3IwfId = n3IwfId;
  }

  
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
    return Objects.equals(this.n3gppTai, n3gaLocation.n3gppTai) &&
        Objects.equals(this.n3IwfId, n3gaLocation.n3IwfId) &&
        Objects.equals(this.ueIpv4Addr, n3gaLocation.ueIpv4Addr) &&
        Objects.equals(this.ueIpv6Addr, n3gaLocation.ueIpv6Addr) &&
        Objects.equals(this.portNumber, n3gaLocation.portNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(n3gppTai, n3IwfId, ueIpv4Addr, ueIpv6Addr, portNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class N3gaLocation {\n");
    
    sb.append("    n3gppTai: ").append(toIndentedString(n3gppTai)).append("\n");
    sb.append("    n3IwfId: ").append(toIndentedString(n3IwfId)).append("\n");
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




