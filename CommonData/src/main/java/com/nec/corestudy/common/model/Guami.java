package com.nec.corestudy.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.common.model.PlmnId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * Guami
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:30:35.896+09:00[Asia/Tokyo]")

public class Guami   {

  
    

    
  
  @JsonProperty("plmnId")
  
  
  
  
  
  
  private PlmnId plmnId = null;
  

  
    

    
  
  @JsonProperty("amfId")
  
  
  
  
  
  
  private String amfId = null;
  

  
  
  public Guami plmnId(PlmnId plmnId) {
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

  
  public Guami amfId(String amfId) {
    this.amfId = amfId;
    return this;
  }
  
  

  /**
  
  
   * Get amfId
  
  
  
   * @return amfId
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getAmfId() {
    return amfId;
  }

  public void setAmfId(String amfId) {
    this.amfId = amfId;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Guami guami = (Guami) o;
    return Objects.equals(this.plmnId, guami.plmnId) &&
        Objects.equals(this.amfId, guami.amfId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, amfId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Guami {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    amfId: ").append(toIndentedString(amfId)).append("\n");
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




