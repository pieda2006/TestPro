package com.nec.corestudy.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * Ambr
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:30:35.896+09:00[Asia/Tokyo]")

public class Ambr   {

  
    

    
  
  @JsonProperty("uplink")
  
  
  
  
  
  
  private String uplink = null;
  

  
    

    
  
  @JsonProperty("downlink")
  
  
  
  
  
  
  private String downlink = null;
  

  
  
  public Ambr uplink(String uplink) {
    this.uplink = uplink;
    return this;
  }
  
  

  /**
  
  
   * Get uplink
  
  
  
   * @return uplink
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getUplink() {
    return uplink;
  }

  public void setUplink(String uplink) {
    this.uplink = uplink;
  }

  
  public Ambr downlink(String downlink) {
    this.downlink = downlink;
    return this;
  }
  
  

  /**
  
  
   * Get downlink
  
  
  
   * @return downlink
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


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
    Ambr ambr = (Ambr) o;
    return Objects.equals(this.uplink, ambr.uplink) &&
        Objects.equals(this.downlink, ambr.downlink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uplink, downlink);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ambr {\n");
    
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




