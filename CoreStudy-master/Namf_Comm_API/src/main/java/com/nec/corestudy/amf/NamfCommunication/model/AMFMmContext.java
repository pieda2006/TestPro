package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfCommunication.model.AMFMobilityRestrictions;
import com.nec.corestudy.amf.NamfCommunication.model.AMFNasSecurityMode;
import com.nec.corestudy.amf.NamfCommunication.model.AMFSnssai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFMmContext
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFMmContext   {
  /**
   * Gets or Sets accessType
   */
  public enum AccessTypeEnum {
    _3GPP_ACCESS("Jamf_3GPP_ACCESS"),
    
    NON_3GPP_ACCESS("Jamf_NON_3GPP_ACCESS");

    private String value;

    AccessTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AccessTypeEnum fromValue(String text) {
      for (AccessTypeEnum b : AccessTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("accessType")
  private AccessTypeEnum accessType = null;

  @JsonProperty("nasSecurityMode")
  private AMFNasSecurityMode nasSecurityMode = null;

  @JsonProperty("nasDownlinkCount")
  private Integer nasDownlinkCount = null;

  @JsonProperty("nasUplinkCount")
  private Integer nasUplinkCount = null;

  @JsonProperty("fiveGmmCapability")
  private String fiveGmmCapability = null;

  @JsonProperty("mobilityRestrictions")
  private AMFMobilityRestrictions mobilityRestrictions = null;

  @JsonProperty("ueSecurityCapability")
  private String ueSecurityCapability = null;

  @JsonProperty("s1UeNetworkCapability")
  private String s1UeNetworkCapability = null;

  @JsonProperty("allowedNssai")
  @Valid
  private List<AMFSnssai> allowedNssai = null;

  @JsonProperty("nssaiMapping")
  @Valid
  private List<AMFSnssai> nssaiMapping = null;

  @JsonProperty("nsInstances")
  @Valid
  private List<String> nsInstances = null;

  public AMFMmContext accessType(AccessTypeEnum accessType) {
    this.accessType = accessType;
    return this;
  }

  /**
   * Get accessType
   * @return accessType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public AccessTypeEnum getAccessType() {
    return accessType;
  }

  public void setAccessType(AccessTypeEnum accessType) {
    this.accessType = accessType;
  }

  public AMFMmContext nasSecurityMode(AMFNasSecurityMode nasSecurityMode) {
    this.nasSecurityMode = nasSecurityMode;
    return this;
  }

  /**
   * Get nasSecurityMode
   * @return nasSecurityMode
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFNasSecurityMode getNasSecurityMode() {
    return nasSecurityMode;
  }

  public void setNasSecurityMode(AMFNasSecurityMode nasSecurityMode) {
    this.nasSecurityMode = nasSecurityMode;
  }

  public AMFMmContext nasDownlinkCount(Integer nasDownlinkCount) {
    this.nasDownlinkCount = nasDownlinkCount;
    return this;
  }

  /**
   * Get nasDownlinkCount
   * @return nasDownlinkCount
  **/
  @ApiModelProperty(value = "")


  public Integer getNasDownlinkCount() {
    return nasDownlinkCount;
  }

  public void setNasDownlinkCount(Integer nasDownlinkCount) {
    this.nasDownlinkCount = nasDownlinkCount;
  }

  public AMFMmContext nasUplinkCount(Integer nasUplinkCount) {
    this.nasUplinkCount = nasUplinkCount;
    return this;
  }

  /**
   * Get nasUplinkCount
   * @return nasUplinkCount
  **/
  @ApiModelProperty(value = "")


  public Integer getNasUplinkCount() {
    return nasUplinkCount;
  }

  public void setNasUplinkCount(Integer nasUplinkCount) {
    this.nasUplinkCount = nasUplinkCount;
  }

  public AMFMmContext fiveGmmCapability(String fiveGmmCapability) {
    this.fiveGmmCapability = fiveGmmCapability;
    return this;
  }

  /**
   * Get fiveGmmCapability
   * @return fiveGmmCapability
  **/
  @ApiModelProperty(value = "")


  public String getFiveGmmCapability() {
    return fiveGmmCapability;
  }

  public void setFiveGmmCapability(String fiveGmmCapability) {
    this.fiveGmmCapability = fiveGmmCapability;
  }

  public AMFMmContext mobilityRestrictions(AMFMobilityRestrictions mobilityRestrictions) {
    this.mobilityRestrictions = mobilityRestrictions;
    return this;
  }

  /**
   * Get mobilityRestrictions
   * @return mobilityRestrictions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFMobilityRestrictions getMobilityRestrictions() {
    return mobilityRestrictions;
  }

  public void setMobilityRestrictions(AMFMobilityRestrictions mobilityRestrictions) {
    this.mobilityRestrictions = mobilityRestrictions;
  }

  public AMFMmContext ueSecurityCapability(String ueSecurityCapability) {
    this.ueSecurityCapability = ueSecurityCapability;
    return this;
  }

  /**
   * Get ueSecurityCapability
   * @return ueSecurityCapability
  **/
  @ApiModelProperty(value = "")


  public String getUeSecurityCapability() {
    return ueSecurityCapability;
  }

  public void setUeSecurityCapability(String ueSecurityCapability) {
    this.ueSecurityCapability = ueSecurityCapability;
  }

  public AMFMmContext s1UeNetworkCapability(String s1UeNetworkCapability) {
    this.s1UeNetworkCapability = s1UeNetworkCapability;
    return this;
  }

  /**
   * Get s1UeNetworkCapability
   * @return s1UeNetworkCapability
  **/
  @ApiModelProperty(value = "")


  public String getS1UeNetworkCapability() {
    return s1UeNetworkCapability;
  }

  public void setS1UeNetworkCapability(String s1UeNetworkCapability) {
    this.s1UeNetworkCapability = s1UeNetworkCapability;
  }

  public AMFMmContext allowedNssai(List<AMFSnssai> allowedNssai) {
    this.allowedNssai = allowedNssai;
    return this;
  }

  public AMFMmContext addAllowedNssaiItem(AMFSnssai allowedNssaiItem) {
    if (this.allowedNssai == null) {
      this.allowedNssai = new ArrayList<AMFSnssai>();
    }
    this.allowedNssai.add(allowedNssaiItem);
    return this;
  }

  /**
   * Get allowedNssai
   * @return allowedNssai
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFSnssai> getAllowedNssai() {
    return allowedNssai;
  }

  public void setAllowedNssai(List<AMFSnssai> allowedNssai) {
    this.allowedNssai = allowedNssai;
  }

  public AMFMmContext nssaiMapping(List<AMFSnssai> nssaiMapping) {
    this.nssaiMapping = nssaiMapping;
    return this;
  }

  public AMFMmContext addNssaiMappingItem(AMFSnssai nssaiMappingItem) {
    if (this.nssaiMapping == null) {
      this.nssaiMapping = new ArrayList<AMFSnssai>();
    }
    this.nssaiMapping.add(nssaiMappingItem);
    return this;
  }

  /**
   * Get nssaiMapping
   * @return nssaiMapping
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFSnssai> getNssaiMapping() {
    return nssaiMapping;
  }

  public void setNssaiMapping(List<AMFSnssai> nssaiMapping) {
    this.nssaiMapping = nssaiMapping;
  }

  public AMFMmContext nsInstances(List<String> nsInstances) {
    this.nsInstances = nsInstances;
    return this;
  }

  public AMFMmContext addNsInstancesItem(String nsInstancesItem) {
    if (this.nsInstances == null) {
      this.nsInstances = new ArrayList<String>();
    }
    this.nsInstances.add(nsInstancesItem);
    return this;
  }

  /**
   * FFS
   * @return nsInstances
  **/
  @ApiModelProperty(value = "FFS")


  public List<String> getNsInstances() {
    return nsInstances;
  }

  public void setNsInstances(List<String> nsInstances) {
    this.nsInstances = nsInstances;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFMmContext amFMmContext = (AMFMmContext) o;
    return Objects.equals(this.accessType, amFMmContext.accessType) &&
        Objects.equals(this.nasSecurityMode, amFMmContext.nasSecurityMode) &&
        Objects.equals(this.nasDownlinkCount, amFMmContext.nasDownlinkCount) &&
        Objects.equals(this.nasUplinkCount, amFMmContext.nasUplinkCount) &&
        Objects.equals(this.fiveGmmCapability, amFMmContext.fiveGmmCapability) &&
        Objects.equals(this.mobilityRestrictions, amFMmContext.mobilityRestrictions) &&
        Objects.equals(this.ueSecurityCapability, amFMmContext.ueSecurityCapability) &&
        Objects.equals(this.s1UeNetworkCapability, amFMmContext.s1UeNetworkCapability) &&
        Objects.equals(this.allowedNssai, amFMmContext.allowedNssai) &&
        Objects.equals(this.nssaiMapping, amFMmContext.nssaiMapping) &&
        Objects.equals(this.nsInstances, amFMmContext.nsInstances);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessType, nasSecurityMode, nasDownlinkCount, nasUplinkCount, fiveGmmCapability, mobilityRestrictions, ueSecurityCapability, s1UeNetworkCapability, allowedNssai, nssaiMapping, nsInstances);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFMmContext {\n");
    
    sb.append("    accessType: ").append(toIndentedString(accessType)).append("\n");
    sb.append("    nasSecurityMode: ").append(toIndentedString(nasSecurityMode)).append("\n");
    sb.append("    nasDownlinkCount: ").append(toIndentedString(nasDownlinkCount)).append("\n");
    sb.append("    nasUplinkCount: ").append(toIndentedString(nasUplinkCount)).append("\n");
    sb.append("    fiveGmmCapability: ").append(toIndentedString(fiveGmmCapability)).append("\n");
    sb.append("    mobilityRestrictions: ").append(toIndentedString(mobilityRestrictions)).append("\n");
    sb.append("    ueSecurityCapability: ").append(toIndentedString(ueSecurityCapability)).append("\n");
    sb.append("    s1UeNetworkCapability: ").append(toIndentedString(s1UeNetworkCapability)).append("\n");
    sb.append("    allowedNssai: ").append(toIndentedString(allowedNssai)).append("\n");
    sb.append("    nssaiMapping: ").append(toIndentedString(nssaiMapping)).append("\n");
    sb.append("    nsInstances: ").append(toIndentedString(nsInstances)).append("\n");
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
