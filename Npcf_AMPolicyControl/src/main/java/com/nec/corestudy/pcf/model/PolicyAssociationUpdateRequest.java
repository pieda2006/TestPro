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
 * PolicyAssociationUpdateRequest
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class PolicyAssociationUpdateRequest   {

  
    

    
  
  @JsonProperty("notificationUri")
  
  
  
  
  
  
  private String notificationUri = null;
  

  
    

    
  
  @JsonProperty("triggers")
  
  
  
  
  
  @Valid
  private List<RequestTrigger> triggers = null;
  
  

  
    

    
  
  @JsonProperty("servAreaRes")
  
  
  
  
  
  
  private String servAreaRes = null;
  

  
    

    
  
  @JsonProperty("rfsp")
  
  
  
  
  
  
  private Integer rfsp = null;
  

  
  
  public PolicyAssociationUpdateRequest notificationUri(String notificationUri) {
    this.notificationUri = notificationUri;
    return this;
  }
  
  

  /**
  
  
   * Get notificationUri
  
  
  
   * @return notificationUri
  **/
 
  @ApiModelProperty(value = "")


  public String getNotificationUri() {
    return notificationUri;
  }

  public void setNotificationUri(String notificationUri) {
    this.notificationUri = notificationUri;
  }

  
  public PolicyAssociationUpdateRequest triggers(List<RequestTrigger> triggers) {
    this.triggers = triggers;
    return this;
  }
  

  public PolicyAssociationUpdateRequest addTriggersItem(RequestTrigger triggersItem) {
    
    if (this.triggers == null) {
      this.triggers = new ArrayList<RequestTrigger>();
    }
    
    this.triggers.add(triggersItem);
    return this;
  }
  
  

  /**
  
   * Request Triggers that the NF service consumer observes.
  
  
  
  
   * @return triggers
  **/
 
  @ApiModelProperty(value = "Request Triggers that the NF service consumer observes.")

  @Valid

  public List<RequestTrigger> getTriggers() {
    return triggers;
  }

  public void setTriggers(List<RequestTrigger> triggers) {
    this.triggers = triggers;
  }

  
  public PolicyAssociationUpdateRequest servAreaRes(String servAreaRes) {
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

  
  public PolicyAssociationUpdateRequest rfsp(Integer rfsp) {
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
    PolicyAssociationUpdateRequest policyAssociationUpdateRequest = (PolicyAssociationUpdateRequest) o;
    return Objects.equals(this.notificationUri, policyAssociationUpdateRequest.notificationUri) &&
        Objects.equals(this.triggers, policyAssociationUpdateRequest.triggers) &&
        Objects.equals(this.servAreaRes, policyAssociationUpdateRequest.servAreaRes) &&
        Objects.equals(this.rfsp, policyAssociationUpdateRequest.rfsp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notificationUri, triggers, servAreaRes, rfsp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyAssociationUpdateRequest {\n");
    
    sb.append("    notificationUri: ").append(toIndentedString(notificationUri)).append("\n");
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




