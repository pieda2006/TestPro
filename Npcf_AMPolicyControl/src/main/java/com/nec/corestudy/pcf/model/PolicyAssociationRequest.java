package com.nec.corestudy.pcf.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.pcf.model.AccessType;
import com.nec.corestudy.pcf.model.NetworkId;
import com.nec.corestudy.pcf.model.RatType;
import com.nec.corestudy.pcf.model.UserLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * PolicyAssociationRequest
 */
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class PolicyAssociationRequest   {

  
    

    
  
  @JsonProperty("notificationUri")
  
  
  
  
  
  
  private String notificationUri = null;
  

  
    

    
  
  @JsonProperty("altNotifIpv4Addrs")
  
  
  
  
  
  @Valid
  private List<String> altNotifIpv4Addrs = null;
  
  

  
    

    
  
  @JsonProperty("altNotifIpv6Addrs")
  
  
  
  
  
  @Valid
  private List<String> altNotifIpv6Addrs = null;
  
  

  
    

    
  
  @JsonProperty("supi")
  
  
  
  
  
  
  private String supi = null;
  

  
    

    
  
  @JsonProperty("gpsi")
  
  
  
  
  
  
  private String gpsi = null;
  

  
    

    
  
  @JsonProperty("accessType")
  
  
  
  
  
  
  private AccessType accessType = null;
  

  
    

    
  
  @JsonProperty("pei")
  
  
  
  
  
  
  private String pei = null;
  

  
    

    
  
  @JsonProperty("userLoc")
  
  
  
  
  
  
  private UserLocation userLoc = null;
  

  
    

    
  
  @JsonProperty("timeZone")
  
  
  
  
  
  
  private String timeZone = null;
  

  
    

    
  
  @JsonProperty("servingPlmn")
  
  
  
  
  
  
  private NetworkId servingPlmn = null;
  

  
    

    
  
  @JsonProperty("ratType")
  
  
  
  
  
  
  private RatType ratType = null;
  

  
    

    
  
  @JsonProperty("groupId")
  
  
  
  
  
  
  private String groupId = null;
  

  
    

    
  
  @JsonProperty("vPcfId")
  
  
  
  
  
  
  private String vPcfId = null;
  

  
    

    
  
  @JsonProperty("hPcfId")
  
  
  
  
  
  
  private String hPcfId = null;
  

  
    

    
  
  @JsonProperty("servAreaRes")
  
  
  
  
  
  
  private String servAreaRes = null;
  

  
    

    
  
  @JsonProperty("rfsp")
  
  
  
  
  
  
  private Integer rfsp = null;
  

  
    

    
  
  @JsonProperty("psis")
  
  
  
  
  
  @Valid
  private List<String> psis = null;
  
  

  
    

    
  
  @JsonProperty("suppFeat")
  
  
  
  
  
  
  private String suppFeat = null;
  

  
  
  public PolicyAssociationRequest notificationUri(String notificationUri) {
    this.notificationUri = notificationUri;
    return this;
  }
  
  

  /**
  
  
   * Get notificationUri
  
  
  
   * @return notificationUri
  **/
 
  @ApiModelProperty(required = true, value = "")

  @NotNull


  public String getNotificationUri() {
    return notificationUri;
  }

  public void setNotificationUri(String notificationUri) {
    this.notificationUri = notificationUri;
  }

  
  public PolicyAssociationRequest altNotifIpv4Addrs(List<String> altNotifIpv4Addrs) {
    this.altNotifIpv4Addrs = altNotifIpv4Addrs;
    return this;
  }
  

  public PolicyAssociationRequest addAltNotifIpv4AddrsItem(String altNotifIpv4AddrsItem) {
    
    if (this.altNotifIpv4Addrs == null) {
      this.altNotifIpv4Addrs = new ArrayList<String>();
    }
    
    this.altNotifIpv4Addrs.add(altNotifIpv4AddrsItem);
    return this;
  }
  
  

  /**
  
   * Alternate or backup IPv4 Addess(es) where to send Notifications.
  
  
  
  
   * @return altNotifIpv4Addrs
  **/
 
  @ApiModelProperty(value = "Alternate or backup IPv4 Addess(es) where to send Notifications.")


  public List<String> getAltNotifIpv4Addrs() {
    return altNotifIpv4Addrs;
  }

  public void setAltNotifIpv4Addrs(List<String> altNotifIpv4Addrs) {
    this.altNotifIpv4Addrs = altNotifIpv4Addrs;
  }

  
  public PolicyAssociationRequest altNotifIpv6Addrs(List<String> altNotifIpv6Addrs) {
    this.altNotifIpv6Addrs = altNotifIpv6Addrs;
    return this;
  }
  

  public PolicyAssociationRequest addAltNotifIpv6AddrsItem(String altNotifIpv6AddrsItem) {
    
    if (this.altNotifIpv6Addrs == null) {
      this.altNotifIpv6Addrs = new ArrayList<String>();
    }
    
    this.altNotifIpv6Addrs.add(altNotifIpv6AddrsItem);
    return this;
  }
  
  

  /**
  
   * Alternate or backup IPv6 Addess(es) where to send Notifications.
  
  
  
  
   * @return altNotifIpv6Addrs
  **/
 
  @ApiModelProperty(value = "Alternate or backup IPv6 Addess(es) where to send Notifications.")


  public List<String> getAltNotifIpv6Addrs() {
    return altNotifIpv6Addrs;
  }

  public void setAltNotifIpv6Addrs(List<String> altNotifIpv6Addrs) {
    this.altNotifIpv6Addrs = altNotifIpv6Addrs;
  }

  
  public PolicyAssociationRequest supi(String supi) {
    this.supi = supi;
    return this;
  }
  
  

  /**
  
  
   * Get supi
  
  
  
   * @return supi
  **/
 
  @ApiModelProperty(value = "")


  public String getSupi() {
    return supi;
  }

  public void setSupi(String supi) {
    this.supi = supi;
  }

  
  public PolicyAssociationRequest gpsi(String gpsi) {
    this.gpsi = gpsi;
    return this;
  }
  
  

  /**
  
  
   * Get gpsi
  
  
  
   * @return gpsi
  **/
 
  @ApiModelProperty(value = "")


  public String getGpsi() {
    return gpsi;
  }

  public void setGpsi(String gpsi) {
    this.gpsi = gpsi;
  }

  
  public PolicyAssociationRequest accessType(AccessType accessType) {
    this.accessType = accessType;
    return this;
  }
  
  

  /**
  
  
   * Get accessType
  
  
  
   * @return accessType
  **/
 
  @ApiModelProperty(value = "")

  @Valid

  public AccessType getAccessType() {
    return accessType;
  }

  public void setAccessType(AccessType accessType) {
    this.accessType = accessType;
  }

  
  public PolicyAssociationRequest pei(String pei) {
    this.pei = pei;
    return this;
  }
  
  

  /**
  
  
   * Get pei
  
  
  
   * @return pei
  **/
 
  @ApiModelProperty(value = "")


  public String getPei() {
    return pei;
  }

  public void setPei(String pei) {
    this.pei = pei;
  }

  
  public PolicyAssociationRequest userLoc(UserLocation userLoc) {
    this.userLoc = userLoc;
    return this;
  }
  
  

  /**
  
  
   * Get userLoc
  
  
  
   * @return userLoc
  **/
 
  @ApiModelProperty(value = "")

  @Valid

  public UserLocation getUserLoc() {
    return userLoc;
  }

  public void setUserLoc(UserLocation userLoc) {
    this.userLoc = userLoc;
  }

  
  public PolicyAssociationRequest timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }
  
  

  /**
  
  
   * Get timeZone
  
  
  
   * @return timeZone
  **/
 
  @ApiModelProperty(value = "")


  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  
  public PolicyAssociationRequest servingPlmn(NetworkId servingPlmn) {
    this.servingPlmn = servingPlmn;
    return this;
  }
  
  

  /**
  
  
   * Get servingPlmn
  
  
  
   * @return servingPlmn
  **/
 
  @ApiModelProperty(value = "")

  @Valid

  public NetworkId getServingPlmn() {
    return servingPlmn;
  }

  public void setServingPlmn(NetworkId servingPlmn) {
    this.servingPlmn = servingPlmn;
  }

  
  public PolicyAssociationRequest ratType(RatType ratType) {
    this.ratType = ratType;
    return this;
  }
  
  

  /**
  
  
   * Get ratType
  
  
  
   * @return ratType
  **/
 
  @ApiModelProperty(value = "")

  @Valid

  public RatType getRatType() {
    return ratType;
  }

  public void setRatType(RatType ratType) {
    this.ratType = ratType;
  }

  
  public PolicyAssociationRequest groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }
  
  

  /**
  
  
   * Get groupId
  
  
  
   * @return groupId
  **/
 
  @ApiModelProperty(value = "")


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  
  public PolicyAssociationRequest vPcfId(String vPcfId) {
    this.vPcfId = vPcfId;
    return this;
  }
  
  

  /**
  
   * V-PCF Identifier. Shall be provided when available.
  
  
  
  
   * @return vPcfId
  **/
 
  @ApiModelProperty(value = "V-PCF Identifier. Shall be provided when available.")


  public String getVPcfId() {
    return vPcfId;
  }

  public void setVPcfId(String vPcfId) {
    this.vPcfId = vPcfId;
  }

  
  public PolicyAssociationRequest hPcfId(String hPcfId) {
    this.hPcfId = hPcfId;
    return this;
  }
  
  

  /**
  
   * H-PCF Identifier. Shall be provided when available.
  
  
  
  
   * @return hPcfId
  **/
 
  @ApiModelProperty(value = "H-PCF Identifier. Shall be provided when available.")


  public String getHPcfId() {
    return hPcfId;
  }

  public void setHPcfId(String hPcfId) {
    this.hPcfId = hPcfId;
  }

  
  public PolicyAssociationRequest servAreaRes(String servAreaRes) {
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

  
  public PolicyAssociationRequest rfsp(Integer rfsp) {
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

  
  public PolicyAssociationRequest psis(List<String> psis) {
    this.psis = psis;
    return this;
  }
  

  public PolicyAssociationRequest addPsisItem(String psisItem) {
    
    if (this.psis == null) {
      this.psis = new ArrayList<String>();
    }
    
    this.psis.add(psisItem);
    return this;
  }
  
  

  /**
  
   * A list of PSIs denoting fragments of UE Policy stored in the UE, as obtained from the UE. Shall be provided when available.
  
  
  
  
   * @return psis
  **/
 
  @ApiModelProperty(value = "A list of PSIs denoting fragments of UE Policy stored in the UE, as obtained from the UE. Shall be provided when available.")


  public List<String> getPsis() {
    return psis;
  }

  public void setPsis(List<String> psis) {
    this.psis = psis;
  }

  
  public PolicyAssociationRequest suppFeat(String suppFeat) {
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
    PolicyAssociationRequest policyAssociationRequest = (PolicyAssociationRequest) o;
    return Objects.equals(this.notificationUri, policyAssociationRequest.notificationUri) &&
        Objects.equals(this.altNotifIpv4Addrs, policyAssociationRequest.altNotifIpv4Addrs) &&
        Objects.equals(this.altNotifIpv6Addrs, policyAssociationRequest.altNotifIpv6Addrs) &&
        Objects.equals(this.supi, policyAssociationRequest.supi) &&
        Objects.equals(this.gpsi, policyAssociationRequest.gpsi) &&
        Objects.equals(this.accessType, policyAssociationRequest.accessType) &&
        Objects.equals(this.pei, policyAssociationRequest.pei) &&
        Objects.equals(this.userLoc, policyAssociationRequest.userLoc) &&
        Objects.equals(this.timeZone, policyAssociationRequest.timeZone) &&
        Objects.equals(this.servingPlmn, policyAssociationRequest.servingPlmn) &&
        Objects.equals(this.ratType, policyAssociationRequest.ratType) &&
        Objects.equals(this.groupId, policyAssociationRequest.groupId) &&
        Objects.equals(this.vPcfId, policyAssociationRequest.vPcfId) &&
        Objects.equals(this.hPcfId, policyAssociationRequest.hPcfId) &&
        Objects.equals(this.servAreaRes, policyAssociationRequest.servAreaRes) &&
        Objects.equals(this.rfsp, policyAssociationRequest.rfsp) &&
        Objects.equals(this.psis, policyAssociationRequest.psis) &&
        Objects.equals(this.suppFeat, policyAssociationRequest.suppFeat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notificationUri, altNotifIpv4Addrs, altNotifIpv6Addrs, supi, gpsi, accessType, pei, userLoc, timeZone, servingPlmn, ratType, groupId, vPcfId, hPcfId, servAreaRes, rfsp, psis, suppFeat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyAssociationRequest {\n");
    
    sb.append("    notificationUri: ").append(toIndentedString(notificationUri)).append("\n");
    sb.append("    altNotifIpv4Addrs: ").append(toIndentedString(altNotifIpv4Addrs)).append("\n");
    sb.append("    altNotifIpv6Addrs: ").append(toIndentedString(altNotifIpv6Addrs)).append("\n");
    sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
    sb.append("    gpsi: ").append(toIndentedString(gpsi)).append("\n");
    sb.append("    accessType: ").append(toIndentedString(accessType)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    userLoc: ").append(toIndentedString(userLoc)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    servingPlmn: ").append(toIndentedString(servingPlmn)).append("\n");
    sb.append("    ratType: ").append(toIndentedString(ratType)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    vPcfId: ").append(toIndentedString(vPcfId)).append("\n");
    sb.append("    hPcfId: ").append(toIndentedString(hPcfId)).append("\n");
    sb.append("    servAreaRes: ").append(toIndentedString(servAreaRes)).append("\n");
    sb.append("    rfsp: ").append(toIndentedString(rfsp)).append("\n");
    sb.append("    psis: ").append(toIndentedString(psis)).append("\n");
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




