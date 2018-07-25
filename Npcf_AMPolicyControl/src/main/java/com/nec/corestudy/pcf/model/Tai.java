package com.nec.corestudy.pcf.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.pcf.model.PlmnId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * Tai
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class Tai   {

  
    

    
  
  @JsonProperty("plmnId")
  
  
  
  
  
  
  private PlmnId plmnId = null;
  

  
    

    
  
  @JsonProperty("tac")
  
  
  
  
  
  
  private String tac = null;
  

  
  
  public Tai plmnId(PlmnId plmnId) {
    this.plmnId = plmnId;
    return this;
  }
  
  

  /**
  
  
   * Get plmnId
  
  
  
   * @return plmnId
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull

  @Valid

  public PlmnId getPlmnId() {
    return plmnId;
  }

  public void setPlmnId(PlmnId plmnId) {
    this.plmnId = plmnId;
  }

  
  public Tai tac(String tac) {
    this.tac = tac;
    return this;
  }
  
  

  /**
  
  
   * Get tac
  
  
  
   * @return tac
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getTac() {
    return tac;
  }

  public void setTac(String tac) {
    this.tac = tac;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tai tai = (Tai) o;
    return Objects.equals(this.plmnId, tai.plmnId) &&
        Objects.equals(this.tac, tai.tac);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, tac);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tai {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    tac: ").append(toIndentedString(tac)).append("\n");
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




