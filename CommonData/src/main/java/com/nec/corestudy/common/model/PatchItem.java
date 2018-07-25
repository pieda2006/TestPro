package com.nec.corestudy.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.common.model.PatchOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * PatchItem
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:30:35.896+09:00[Asia/Tokyo]")

public class PatchItem   {

  
    

    
  
  @JsonProperty("op")
  
  
  
  
  
  
  private PatchOperation op = null;
  

  
    

    
  
  @JsonProperty("path")
  
  
  
  
  
  
  private String path = null;
  

  
    

    
  
  @JsonProperty("from")
  
  
  
  
  
  
  private String from = null;
  

  
    

    
  
  @JsonProperty("value")
  
  
  
  
  
  
  private Object value = null;
  

  
  
  public PatchItem op(PatchOperation op) {
    this.op = op;
    return this;
  }
  
  

  /**
  
  
   * Get op
  
  
  
   * @return op
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull

  @Valid

  public PatchOperation getOp() {
    return op;
  }

  public void setOp(PatchOperation op) {
    this.op = op;
  }

  
  public PatchItem path(String path) {
    this.path = path;
    return this;
  }
  
  

  /**
  
  
   * Get path
  
  
  
   * @return path
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  
  public PatchItem from(String from) {
    this.from = from;
    return this;
  }
  
  

  /**
  
  
   * Get from
  
  
  
   * @return from
  **/
 
  @ApiModelProperty(value = "")


  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  
  public PatchItem value(Object value) {
    this.value = value;
    return this;
  }
  
  

  /**
  
  
   * Get value
  
  
  
   * @return value
  **/
 
  @ApiModelProperty(value = "")


  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchItem patchItem = (PatchItem) o;
    return Objects.equals(this.op, patchItem.op) &&
        Objects.equals(this.path, patchItem.path) &&
        Objects.equals(this.from, patchItem.from) &&
        Objects.equals(this.value, patchItem.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(op, path, from, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchItem {\n");
    
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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




