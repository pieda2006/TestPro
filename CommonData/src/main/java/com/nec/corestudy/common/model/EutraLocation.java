package com.nec.corestudy.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.common.model.Ecgi;
import com.nec.corestudy.common.model.Tai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * EutraLocation
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:30:35.896+09:00[Asia/Tokyo]")

public class EutraLocation   {

  
    

    
  
  @JsonProperty("tai")
  
  
  
  
  
  
  private Tai tai = null;
  

  
    

    
  
  @JsonProperty("ecgi")
  
  
  
  
  
  
  private Ecgi ecgi = null;
  

  
  
  public EutraLocation tai(Tai tai) {
    this.tai = tai;
    return this;
  }
  
  

  /**
  
  
   * Get tai
  
  
  
   * @return tai
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull

  @Valid

  public Tai getTai() {
    return tai;
  }

  public void setTai(Tai tai) {
    this.tai = tai;
  }

  
  public EutraLocation ecgi(Ecgi ecgi) {
    this.ecgi = ecgi;
    return this;
  }
  
  

  /**
  
  
   * Get ecgi
  
  
  
   * @return ecgi
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull

  @Valid

  public Ecgi getEcgi() {
    return ecgi;
  }

  public void setEcgi(Ecgi ecgi) {
    this.ecgi = ecgi;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EutraLocation eutraLocation = (EutraLocation) o;
    return Objects.equals(this.tai, eutraLocation.tai) &&
        Objects.equals(this.ecgi, eutraLocation.ecgi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tai, ecgi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EutraLocation {\n");
    
    sb.append("    tai: ").append(toIndentedString(tai)).append("\n");
    sb.append("    ecgi: ").append(toIndentedString(ecgi)).append("\n");
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




