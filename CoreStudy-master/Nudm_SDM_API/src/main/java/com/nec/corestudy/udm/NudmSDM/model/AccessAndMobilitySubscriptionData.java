package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.udm.NudmSDM.model.Ambr;
import com.nec.corestudy.udm.NudmSDM.model.AreaRestriction;
import com.nec.corestudy.udm.NudmSDM.model.Nssai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccessAndMobilitySubscriptionData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class AccessAndMobilitySubscriptionData   {
  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("gpsi")
  @Valid
  private List<String> gpsi = null;

  @JsonProperty("internalGroupId")
  @Valid
  private List<String> internalGroupId = null;

  @JsonProperty("subscribed-UeAmbr")
  private Ambr subscribedUeAmbr = null;

  @JsonProperty("nssai")
  private Nssai nssai = null;

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
  private List<AreaRestriction> areaRestriction = null;

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

  public AccessAndMobilitySubscriptionData supportedFeatures(String supportedFeatures) {
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

  public AccessAndMobilitySubscriptionData gpsi(List<String> gpsi) {
    this.gpsi = gpsi;
    return this;
  }

  public AccessAndMobilitySubscriptionData addGpsiItem(String gpsiItem) {
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

  public AccessAndMobilitySubscriptionData internalGroupId(List<String> internalGroupId) {
    this.internalGroupId = internalGroupId;
    return this;
  }

  public AccessAndMobilitySubscriptionData addInternalGroupIdItem(String internalGroupIdItem) {
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

  public AccessAndMobilitySubscriptionData subscribedUeAmbr(Ambr subscribedUeAmbr) {
    this.subscribedUeAmbr = subscribedUeAmbr;
    return this;
  }

  /**
   * Get subscribedUeAmbr
   * @return subscribedUeAmbr
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Ambr getSubscribedUeAmbr() {
    return subscribedUeAmbr;
  }

  public void setSubscribedUeAmbr(Ambr subscribedUeAmbr) {
    this.subscribedUeAmbr = subscribedUeAmbr;
  }

  public AccessAndMobilitySubscriptionData nssai(Nssai nssai) {
    this.nssai = nssai;
    return this;
  }

  /**
   * Get nssai
   * @return nssai
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Nssai getNssai() {
    return nssai;
  }

  public void setNssai(Nssai nssai) {
    this.nssai = nssai;
  }

  public AccessAndMobilitySubscriptionData ratRestriction(List<RatRestrictionEnum> ratRestriction) {
    this.ratRestriction = ratRestriction;
    return this;
  }

  public AccessAndMobilitySubscriptionData addRatRestrictionItem(RatRestrictionEnum ratRestrictionItem) {
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

  public AccessAndMobilitySubscriptionData areaRestriction(List<AreaRestriction> areaRestriction) {
    this.areaRestriction = areaRestriction;
    return this;
  }

  public AccessAndMobilitySubscriptionData addAreaRestrictionItem(AreaRestriction areaRestrictionItem) {
    if (this.areaRestriction == null) {
      this.areaRestriction = new ArrayList<AreaRestriction>();
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

  public List<AreaRestriction> getAreaRestriction() {
    return areaRestriction;
  }

  public void setAreaRestriction(List<AreaRestriction> areaRestriction) {
    this.areaRestriction = areaRestriction;
  }

  public AccessAndMobilitySubscriptionData coreNetworkTypeRestriction(String coreNetworkTypeRestriction) {
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

  public AccessAndMobilitySubscriptionData rfspIndex(Integer rfspIndex) {
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

  public AccessAndMobilitySubscriptionData subsRegTimer(Integer subsRegTimer) {
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

  public AccessAndMobilitySubscriptionData ueUsageType(Integer ueUsageType) {
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

  public AccessAndMobilitySubscriptionData ladnInformation(String ladnInformation) {
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

  public AccessAndMobilitySubscriptionData mpsPriority(Boolean mpsPriority) {
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
    AccessAndMobilitySubscriptionData accessAndMobilitySubscriptionData = (AccessAndMobilitySubscriptionData) o;
    return Objects.equals(this.supportedFeatures, accessAndMobilitySubscriptionData.supportedFeatures) &&
        Objects.equals(this.gpsi, accessAndMobilitySubscriptionData.gpsi) &&
        Objects.equals(this.internalGroupId, accessAndMobilitySubscriptionData.internalGroupId) &&
        Objects.equals(this.subscribedUeAmbr, accessAndMobilitySubscriptionData.subscribedUeAmbr) &&
        Objects.equals(this.nssai, accessAndMobilitySubscriptionData.nssai) &&
        Objects.equals(this.ratRestriction, accessAndMobilitySubscriptionData.ratRestriction) &&
        Objects.equals(this.areaRestriction, accessAndMobilitySubscriptionData.areaRestriction) &&
        Objects.equals(this.coreNetworkTypeRestriction, accessAndMobilitySubscriptionData.coreNetworkTypeRestriction) &&
        Objects.equals(this.rfspIndex, accessAndMobilitySubscriptionData.rfspIndex) &&
        Objects.equals(this.subsRegTimer, accessAndMobilitySubscriptionData.subsRegTimer) &&
        Objects.equals(this.ueUsageType, accessAndMobilitySubscriptionData.ueUsageType) &&
        Objects.equals(this.ladnInformation, accessAndMobilitySubscriptionData.ladnInformation) &&
        Objects.equals(this.mpsPriority, accessAndMobilitySubscriptionData.mpsPriority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportedFeatures, gpsi, internalGroupId, subscribedUeAmbr, nssai, ratRestriction, areaRestriction, coreNetworkTypeRestriction, rfspIndex, subsRegTimer, ueUsageType, ladnInformation, mpsPriority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessAndMobilitySubscriptionData {\n");
    
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

