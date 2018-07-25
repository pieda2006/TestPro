package com.nec.corestudy.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.common.model.InvalidParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * ProblemDetails
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:30:35.896+09:00[Asia/Tokyo]")

public class ProblemDetails   {

  
    

    
  
  @JsonProperty("type")
  
  
  
  
  
  
  private String type = null;
  

  
    

    
  
  @JsonProperty("title")
  
  
  
  
  
  
  private String title = null;
  

  
    

    
  
  @JsonProperty("status")
  
  
  
  
  
  
  private Integer status = null;
  

  
    

    
  
  @JsonProperty("instance")
  
  
  
  
  
  
  private String instance = null;
  

  
    

    
  
  @JsonProperty("cause")
  
  
  
  
  
  
  private String cause = null;
  

  
    

    
  
  @JsonProperty("invalidParams")
  
  
  
  
  
  @Valid
  private List<InvalidParam> invalidParams = null;
  
  

  
  
  public ProblemDetails type(String type) {
    this.type = type;
    return this;
  }
  
  

  /**
  
  
   * Get type
  
  
  
   * @return type
  **/
 
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  
  public ProblemDetails title(String title) {
    this.title = title;
    return this;
  }
  
  

  /**
  
  
   * Get title
  
  
  
   * @return title
  **/
 
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  
  public ProblemDetails status(Integer status) {
    this.status = status;
    return this;
  }
  
  

  /**
  
  
   * Get status
  
  
  
   * @return status
  **/
 
  @ApiModelProperty(value = "")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  
  public ProblemDetails instance(String instance) {
    this.instance = instance;
    return this;
  }
  
  

  /**
  
  
   * Get instance
  
  
  
   * @return instance
  **/
 
  @ApiModelProperty(value = "")


  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }

  
  public ProblemDetails cause(String cause) {
    this.cause = cause;
    return this;
  }
  
  

  /**
  
  
   * Get cause
  
  
  
   * @return cause
  **/
 
  @ApiModelProperty(value = "")


  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  
  public ProblemDetails invalidParams(List<InvalidParam> invalidParams) {
    this.invalidParams = invalidParams;
    return this;
  }
  

  public ProblemDetails addInvalidParamsItem(InvalidParam invalidParamsItem) {
    
    if (this.invalidParams == null) {
      this.invalidParams = new ArrayList<InvalidParam>();
    }
    
    this.invalidParams.add(invalidParamsItem);
    return this;
  }
  
  

  /**
  
  
   * Get invalidParams
  
  
  
   * @return invalidParams
  **/
 
  @ApiModelProperty(value = "")

  @Valid

  public List<InvalidParam> getInvalidParams() {
    return invalidParams;
  }

  public void setInvalidParams(List<InvalidParam> invalidParams) {
    this.invalidParams = invalidParams;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemDetails problemDetails = (ProblemDetails) o;
    return Objects.equals(this.type, problemDetails.type) &&
        Objects.equals(this.title, problemDetails.title) &&
        Objects.equals(this.status, problemDetails.status) &&
        Objects.equals(this.instance, problemDetails.instance) &&
        Objects.equals(this.cause, problemDetails.cause) &&
        Objects.equals(this.invalidParams, problemDetails.invalidParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, instance, cause, invalidParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDetails {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
    sb.append("    invalidParams: ").append(toIndentedString(invalidParams)).append("\n");
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




