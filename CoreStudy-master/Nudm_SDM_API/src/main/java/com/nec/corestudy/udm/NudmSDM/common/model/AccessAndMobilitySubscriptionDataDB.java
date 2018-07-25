package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.udm.NudmSDM.common.model.AmbrDB;
import com.nec.corestudy.udm.NudmSDM.common.model.AreaRestrictionDB;
import com.nec.corestudy.udm.NudmSDM.common.model.NssaiDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccessAndMobilitySubscriptionDataDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class AccessAndMobilitySubscriptionDataDB   {
  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("gpsi")
  @Valid
  private List<String> gpsi = null;

  @JsonProperty("internalGroupId")
  @Valid
  private List<String> internalGroupId = null;

  @JsonProperty("subscribed-UeAmbr")
  private AmbrDB subscribedUeAmbr = null;

  @JsonProperty("nssai")
  private NssaiDB nssai = null;

  /**
   * Gets or Sets ratRestriction
   */
  public enum RatRestrictionEnum {
    NR("NR"),
    
    EUTRA("EUTRA"),
    
    WLAN("WLAN"),
    
    VIRTUAL("VIRTUAL");

    private String value;

    RatRestrictionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RatRestrictionEnum fromValue(String text) {
      for (RatRestrictionEnum b : RatRestrictionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("ratRestriction")
  @Valid
  private List<RatRestrictionEnum> ratRestriction = null;

  @JsonProperty("areaRestriction")
  @Valid
  private List<AreaRestrictionDB> areaRestriction = null;

  @JsonProperty("coreNetworkTypeRestriction")
  private String coreNetworkTypeRestriction = null;

  @JsonProperty("rfspIndex")
  private Integer rfspIndex = null;

  @JsonProperty("subsRegTimer")
  private Integer subsRegTimer = null;

  @JsonProperty("ueUsageType")
  private Integer ueUsageType = null;

  @JsonProperty("ladnInformation")
  private String ladnInformation = null;

  @JsonProperty("mpsPriority")
  private Boolean mpsPriority = null;

  public AccessAndMobilitySubscriptionDataDB supportedFeatures(String supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
    return this;
  }

  /**
   * Get supportedFeatures
   * @return supportedFeatures
  **/
  @ApiModelProperty(value = "")


  public String getSupportedFeatures() {
    return supportedFeatures;
  }

  public void setSupportedFeatures(String supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
  }

  public AccessAndMobilitySubscriptionDataDB gpsi(List<String> gpsi) {
    this.gpsi = gpsi;
    return this;
  }

  public AccessAndMobilitySubscriptionDataDB addGpsiItem(String gpsiItem) {
    if (this.gpsi == null) {
      this.gpsi = new ArrayList<String>();
    }
    this.gpsi.add(gpsiItem);
    return this;
  }

  /**
   * Get gpsi
   * @return gpsi
  **/
  @ApiModelProperty(value = "")


  public List<String> getGpsi() {
    return gpsi;
  }

  public void setGpsi(List<String> gpsi) {
    this.gpsi = gpsi;
  }

  public AccessAndMobilitySubscriptionDataDB internalGroupId(List<String> internalGroupId) {
    this.internalGroupId = internalGroupId;
    return this;
  }

  public AccessAndMobilitySubscriptionDataDB addInternalGroupIdItem(String internalGroupIdItem) {
    if (this.internalGroupId == null) {
      this.internalGroupId = new ArrayList<String>();
    }
    this.internalGroupId.add(internalGroupIdItem);
    return this;
  }

  /**
   * Get internalGroupId
   * @return internalGroupId
  **/
  @ApiModelProperty(value = "")


  public List<String> getInternalGroupId() {
    return internalGroupId;
  }

  public void setInternalGroupId(List<String> internalGroupId) {
    this.internalGroupId = internalGroupId;
  }

  public AccessAndMobilitySubscriptionDataDB subscribedUeAmbr(AmbrDB subscribedUeAmbr) {
    this.subscribedUeAmbr = subscribedUeAmbr;
    return this;
  }

  /**
   * Get subscribedUeAmbr
   * @return subscribedUeAmbr
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AmbrDB getSubscribedUeAmbr() {
    return subscribedUeAmbr;
  }

  public void setSubscribedUeAmbr(AmbrDB subscribedUeAmbr) {
    this.subscribedUeAmbr = subscribedUeAmbr;
  }

  public AccessAndMobilitySubscriptionDataDB nssai(NssaiDB nssai) {
    this.nssai = nssai;
    return this;
  }

  /**
   * Get nssai
   * @return nssai
  **/
  @ApiModelProperty(value = "")

  @Valid

  public NssaiDB getNssai() {
    return nssai;
  }

  public void setNssai(NssaiDB nssai) {
    this.nssai = nssai;
  }

  public AccessAndMobilitySubscriptionDataDB ratRestriction(List<RatRestrictionEnum> ratRestriction) {
    this.ratRestriction = ratRestriction;
    return this;
  }

  public AccessAndMobilitySubscriptionDataDB addRatRestrictionItem(RatRestrictionEnum ratRestrictionItem) {
    if (this.ratRestriction == null) {
      this.ratRestriction = new ArrayList<RatRestrictionEnum>();
    }
    this.ratRestriction.add(ratRestrictionItem);
    return this;
  }

  /**
   * Get ratRestriction
   * @return ratRestriction
  **/
  @ApiModelProperty(value = "")


  public List<RatRestrictionEnum> getRatRestriction() {
    return ratRestriction;
  }

  public void setRatRestriction(List<RatRestrictionEnum> ratRestriction) {
    this.ratRestriction = ratRestriction;
  }

  public AccessAndMobilitySubscriptionDataDB areaRestriction(List<AreaRestrictionDB> areaRestriction) {
    this.areaRestriction = areaRestriction;
    return this;
  }

  public AccessAndMobilitySubscriptionDataDB addAreaRestrictionItem(AreaRestrictionDB areaRestrictionItem) {
    if (this.areaRestriction == null) {
      this.areaRestriction = new ArrayList<AreaRestrictionDB>();
    }
    this.areaRestriction.add(areaRestrictionItem);
    return this;
  }

  /**
   * Get areaRestriction
   * @return areaRestriction
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AreaRestrictionDB> getAreaRestriction() {
    return areaRestriction;
  }

  public void setAreaRestriction(List<AreaRestrictionDB> areaRestriction) {
    this.areaRestriction = areaRestriction;
  }

  public AccessAndMobilitySubscriptionDataDB coreNetworkTypeRestriction(String coreNetworkTypeRestriction) {
    this.coreNetworkTypeRestriction = coreNetworkTypeRestriction;
    return this;
  }

  /**
   * Get coreNetworkTypeRestriction
   * @return coreNetworkTypeRestriction
  **/
  @ApiModelProperty(value = "")


  public String getCoreNetworkTypeRestriction() {
    return coreNetworkTypeRestriction;
  }

  public void setCoreNetworkTypeRestriction(String coreNetworkTypeRestriction) {
    this.coreNetworkTypeRestriction = coreNetworkTypeRestriction;
  }

  public AccessAndMobilitySubscriptionDataDB rfspIndex(Integer rfspIndex) {
    this.rfspIndex = rfspIndex;
    return this;
  }

  /**
   * Get rfspIndex
   * @return rfspIndex
  **/
  @ApiModelProperty(value = "")


  public Integer getRfspIndex() {
    return rfspIndex;
  }

  public void setRfspIndex(Integer rfspIndex) {
    this.rfspIndex = rfspIndex;
  }

  public AccessAndMobilitySubscriptionDataDB subsRegTimer(Integer subsRegTimer) {
    this.subsRegTimer = subsRegTimer;
    return this;
  }

  /**
   * Get subsRegTimer
   * @return subsRegTimer
  **/
  @ApiModelProperty(value = "")


  public Integer getSubsRegTimer() {
    return subsRegTimer;
  }

  public void setSubsRegTimer(Integer subsRegTimer) {
    this.subsRegTimer = subsRegTimer;
  }

  public AccessAndMobilitySubscriptionDataDB ueUsageType(Integer ueUsageType) {
    this.ueUsageType = ueUsageType;
    return this;
  }

  /**
   * Get ueUsageType
   * @return ueUsageType
  **/
  @ApiModelProperty(value = "")


  public Integer getUeUsageType() {
    return ueUsageType;
  }

  public void setUeUsageType(Integer ueUsageType) {
    this.ueUsageType = ueUsageType;
  }

  public AccessAndMobilitySubscriptionDataDB ladnInformation(String ladnInformation) {
    this.ladnInformation = ladnInformation;
    return this;
  }

  /**
   * Get ladnInformation
   * @return ladnInformation
  **/
  @ApiModelProperty(value = "")


  public String getLadnInformation() {
    return ladnInformation;
  }

  public void setLadnInformation(String ladnInformation) {
    this.ladnInformation = ladnInformation;
  }

  public AccessAndMobilitySubscriptionDataDB mpsPriority(Boolean mpsPriority) {
    this.mpsPriority = mpsPriority;
    return this;
  }

  /**
   * Get mpsPriority
   * @return mpsPriority
  **/
  @ApiModelProperty(value = "")


  public Boolean isMpsPriority() {
    return mpsPriority;
  }

  public void setMpsPriority(Boolean mpsPriority) {
    this.mpsPriority = mpsPriority;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessAndMobilitySubscriptionDataDB accessAndMobilitySubscriptionDataDB = (AccessAndMobilitySubscriptionDataDB) o;
    return Objects.equals(this.supportedFeatures, accessAndMobilitySubscriptionDataDB.supportedFeatures) &&
        Objects.equals(this.gpsi, accessAndMobilitySubscriptionDataDB.gpsi) &&
        Objects.equals(this.internalGroupId, accessAndMobilitySubscriptionDataDB.internalGroupId) &&
        Objects.equals(this.subscribedUeAmbr, accessAndMobilitySubscriptionDataDB.subscribedUeAmbr) &&
        Objects.equals(this.nssai, accessAndMobilitySubscriptionDataDB.nssai) &&
        Objects.equals(this.ratRestriction, accessAndMobilitySubscriptionDataDB.ratRestriction) &&
        Objects.equals(this.areaRestriction, accessAndMobilitySubscriptionDataDB.areaRestriction) &&
        Objects.equals(this.coreNetworkTypeRestriction, accessAndMobilitySubscriptionDataDB.coreNetworkTypeRestriction) &&
        Objects.equals(this.rfspIndex, accessAndMobilitySubscriptionDataDB.rfspIndex) &&
        Objects.equals(this.subsRegTimer, accessAndMobilitySubscriptionDataDB.subsRegTimer) &&
        Objects.equals(this.ueUsageType, accessAndMobilitySubscriptionDataDB.ueUsageType) &&
        Objects.equals(this.ladnInformation, accessAndMobilitySubscriptionDataDB.ladnInformation) &&
        Objects.equals(this.mpsPriority, accessAndMobilitySubscriptionDataDB.mpsPriority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportedFeatures, gpsi, internalGroupId, subscribedUeAmbr, nssai, ratRestriction, areaRestriction, coreNetworkTypeRestriction, rfspIndex, subsRegTimer, ueUsageType, ladnInformation, mpsPriority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessAndMobilitySubscriptionDataDB {\n");
    
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    gpsi: ").append(toIndentedString(gpsi)).append("\n");
    sb.append("    internalGroupId: ").append(toIndentedString(internalGroupId)).append("\n");
    sb.append("    subscribedUeAmbr: ").append(toIndentedString(subscribedUeAmbr)).append("\n");
    sb.append("    nssai: ").append(toIndentedString(nssai)).append("\n");
    sb.append("    ratRestriction: ").append(toIndentedString(ratRestriction)).append("\n");
    sb.append("    areaRestriction: ").append(toIndentedString(areaRestriction)).append("\n");
    sb.append("    coreNetworkTypeRestriction: ").append(toIndentedString(coreNetworkTypeRestriction)).append("\n");
    sb.append("    rfspIndex: ").append(toIndentedString(rfspIndex)).append("\n");
    sb.append("    subsRegTimer: ").append(toIndentedString(subsRegTimer)).append("\n");
    sb.append("    ueUsageType: ").append(toIndentedString(ueUsageType)).append("\n");
    sb.append("    ladnInformation: ").append(toIndentedString(ladnInformation)).append("\n");
    sb.append("    mpsPriority: ").append(toIndentedString(mpsPriority)).append("\n");
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

