package com.nec.corestudy.pcf.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.pcf.model.RequestTrigger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * PolicyUpdate
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class PolicyUpdate   {

  
    

    
  
  @JsonProperty("polAssoId")
  
  
  
  
  
  
  private String polAssoId = null;
  

  
    

    
  
  @JsonProperty("uePolicy")
  
  
  
  
  
  
  private String uePolicy = null;
  

  
    

    
  
  @JsonProperty("triggers")
  
  
  
  
  
  @Valid
  private List<RequestTrigger> triggers = null;
  
  

  
    

    
  
  @JsonProperty("servAreaRes")
  
  
  
  
  
  
  private String servAreaRes = null;
  

  
    

    
  
  @JsonProperty("rfsp")
  
  
  
  
  
  
  private Integer rfsp = null;
  

  
  
  public PolicyUpdate polAssoId(String polAssoId) {
    this.polAssoId = polAssoId;
    return this;
  }
  
  

  /**
  
  
   * Get polAssoId
  
  
  
   * @return polAssoId
  **/
 
  @ApiModelProperty(value = "")


  public String getPolAssoId() {
    return polAssoId;
  }

  public void setPolAssoId(String polAssoId) {
    this.polAssoId = polAssoId;
  }

  
  public PolicyUpdate uePolicy(String uePolicy) {
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

  
  public PolicyUpdate triggers(List<RequestTrigger> triggers) {
    this.triggers = triggers;
    return this;
  }
  

  public PolicyUpdate addTriggersItem(RequestTrigger triggersItem) {
    
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

  
  public PolicyUpdate servAreaRes(String servAreaRes) {
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

  
  public PolicyUpdate rfsp(Integer rfsp) {
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

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyUpdate policyUpdate = (PolicyUpdate) o;
    return Objects.equals(this.polAssoId, policyUpdate.polAssoId) &&
        Objects.equals(this.uePolicy, policyUpdate.uePolicy) &&
        Objects.equals(this.triggers, policyUpdate.triggers) &&
        Objects.equals(this.servAreaRes, policyUpdate.servAreaRes) &&
        Objects.equals(this.rfsp, policyUpdate.rfsp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(polAssoId, uePolicy, triggers, servAreaRes, rfsp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyUpdate {\n");
    
    sb.append("    polAssoId: ").append(toIndentedString(polAssoId)).append("\n");
    sb.append("    uePolicy: ").append(toIndentedString(uePolicy)).append("\n");
    sb.append("    triggers: ").append(toIndentedString(triggers)).append("\n");
    sb.append("    servAreaRes: ").append(toIndentedString(servAreaRes)).append("\n");
    sb.append("    rfsp: ").append(toIndentedString(rfsp)).append("\n");
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




