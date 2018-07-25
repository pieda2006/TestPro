package com.nec.corestudy.pcf.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * NetworkId
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class NetworkId   {

  
    

    
  
  @JsonProperty("mnc")
  
  
  
  
  
  
  private String mnc = null;
  

  
    

    
  
  @JsonProperty("mcc")
  
  
  
  
  
  
  private String mcc = null;
  

  
  
  public NetworkId mnc(String mnc) {
    this.mnc = mnc;
    return this;
  }
  
  

  /**
  
  
   * Get mnc
  
  
  
   * @return mnc
  **/
 
  @ApiModelProperty(value = "")


  public String getMnc() {
    return mnc;
  }

  public void setMnc(String mnc) {
    this.mnc = mnc;
  }

  
  public NetworkId mcc(String mcc) {
    this.mcc = mcc;
    return this;
  }
  
  

  /**
  
  
   * Get mcc
  
  
  
   * @return mcc
  **/
 
  @ApiModelProperty(value = "")


  public String getMcc() {
    return mcc;
  }

  public void setMcc(String mcc) {
    this.mcc = mcc;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkId networkId = (NetworkId) o;
    return Objects.equals(this.mnc, networkId.mnc) &&
        Objects.equals(this.mcc, networkId.mcc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mnc, mcc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkId {\n");
    
    sb.append("    mnc: ").append(toIndentedString(mnc)).append("\n");
    sb.append("    mcc: ").append(toIndentedString(mcc)).append("\n");
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




