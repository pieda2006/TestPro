package com.nec.corestudy.pcf.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.pcf.model.PolicyAssociationRequest;
import com.nec.corestudy.pcf.model.RequestTrigger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * PolicyAssociation
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class PolicyAssociation   {

  
    

    
  
  @JsonProperty("request")
  
  
  
  
  
  
  private PolicyAssociationRequest request = null;
  

  
    

    
  
  @JsonProperty("uePolicy")
  
  
  
  
  
  
  private String uePolicy = null;
  

  
    

    
  
  @JsonProperty("triggers")
  
  
  
  
  
  @Valid
  private List<RequestTrigger> triggers = null;
  
  

  
    

    
  
  @JsonProperty("servAreaRes")
  
  
  
  
  
  
  private String servAreaRes = null;
  

  
    

    
  
  @JsonProperty("rfsp")
  
  
  
  
  
  
  private Integer rfsp = null;
  

  
    

    
  
  @JsonProperty("suppFeat")
  
  
  
  
  
  
  private String suppFeat = null;
  

  
  
  public PolicyAssociation request(PolicyAssociationRequest request) {
    this.request = request;
    return this;
  }
  
  

  /**
  
  
   * Get request
  
  
  
   * @return request
  **/
 
  @ApiModelProperty(value = "")

  @Valid

  public PolicyAssociationRequest getRequest() {
    return request;
  }

  public void setRequest(PolicyAssociationRequest request) {
    this.request = request;
  }

  
  public PolicyAssociation uePolicy(String uePolicy) {
    this.uePolicy = uePolicy;
    return this;
  }
  
  

  /**
  
  
   * Get uePolicy
  
  
  
   * @return uePolicy
  **/
 
  @ApiModelProperty(value = "")


  public String getUePolicy() {
    return uePolicy;
  }

  public void setUePolicy(String uePolicy) {
    this.uePolicy = uePolicy;
  }

  
  public PolicyAssociation triggers(List<RequestTrigger> triggers) {
    this.triggers = triggers;
    return this;
  }
  

  public PolicyAssociation addTriggersItem(RequestTrigger triggersItem) {
    
    if (this.triggers == null) {
      this.triggers = new ArrayList<RequestTrigger>();
    }
    
    this.triggers.add(triggersItem);
    return this;
  }
  
  

  /**
  
   * Request Triggers that the PCF subscribes. Only values \"LOC_CH\" and \"PRA_CH\" are permitted.
  
  
  
  
   * @return triggers
  **/
 
  @ApiModelProperty(value = "Request Triggers that the PCF subscribes. Only values \"LOC_CH\" and \"PRA_CH\" are permitted.")

  @Valid

  public List<RequestTrigger> getTriggers() {
    return triggers;
  }

  public void setTriggers(List<RequestTrigger> triggers) {
    this.triggers = triggers;
  }

  
  public PolicyAssociation servAreaRes(String servAreaRes) {
    this.servAreaRes = servAreaRes;
    return this;
  }
  
  

  /**
  
  
   * Get servAreaRes
  
  
  
   * @return servAreaRes
  **/
 
  @ApiModelProperty(value = "")


  public String getServAreaRes() {
    return servAreaRes;
  }

  public void setServAreaRes(String servAreaRes) {
    this.servAreaRes = servAreaRes;
  }

  
  public PolicyAssociation rfsp(Integer rfsp) {
    this.rfsp = rfsp;
    return this;
  }
  
  

  /**
  
  
   * Get rfsp
  
  
  
   * @return rfsp
  **/
 
  @ApiModelProperty(value = "")


  public Integer getRfsp() {
    return rfsp;
  }

  public void setRfsp(Integer rfsp) {
    this.rfsp = rfsp;
  }

  
  public PolicyAssociation suppFeat(String suppFeat) {
    this.suppFeat = suppFeat;
    return this;
  }
  
  

  /**
  
  
   * Get suppFeat
  
  
  
   * @return suppFeat
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getSuppFeat() {
    return suppFeat;
  }

  public void setSuppFeat(String suppFeat) {
    this.suppFeat = suppFeat;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyAssociation policyAssociation = (PolicyAssociation) o;
    return Objects.equals(this.request, policyAssociation.request) &&
        Objects.equals(this.uePolicy, policyAssociation.uePolicy) &&
        Objects.equals(this.triggers, policyAssociation.triggers) &&
        Objects.equals(this.servAreaRes, policyAssociation.servAreaRes) &&
        Objects.equals(this.rfsp, policyAssociation.rfsp) &&
        Objects.equals(this.suppFeat, policyAssociation.suppFeat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(request, uePolicy, triggers, servAreaRes, rfsp, suppFeat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyAssociation {\n");
    
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    uePolicy: ").append(toIndentedString(uePolicy)).append("\n");
    sb.append("    triggers: ").append(toIndentedString(triggers)).append("\n");
    sb.append("    servAreaRes: ").append(toIndentedString(servAreaRes)).append("\n");
    sb.append("    rfsp: ").append(toIndentedString(rfsp)).append("\n");
    sb.append("    suppFeat: ").append(toIndentedString(suppFeat)).append("\n");
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




