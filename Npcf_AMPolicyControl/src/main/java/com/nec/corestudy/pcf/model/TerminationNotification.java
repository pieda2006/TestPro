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
 * TerminationNotification
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class TerminationNotification   {

  
    

    
  
  @JsonProperty("polAssoId")
  
  
  
  
  
  
  private String polAssoId = null;
  

  
  
  public TerminationNotification polAssoId(String polAssoId) {
    this.polAssoId = polAssoId;
    return this;
  }
  
  

  /**
  
  
   * Get polAssoId
  
  
  
   * @return polAssoId
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getPolAssoId() {
    return polAssoId;
  }

  public void setPolAssoId(String polAssoId) {
    this.polAssoId = polAssoId;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TerminationNotification terminationNotification = (TerminationNotification) o;
    return Objects.equals(this.polAssoId, terminationNotification.polAssoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(polAssoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TerminationNotification {\n");
    
    sb.append("    polAssoId: ").append(toIndentedString(polAssoId)).append("\n");
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




