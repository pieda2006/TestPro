package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAmfEventSubscription;
import com.nec.corestudy.amf.NamfCommunication.model.AMFMmContext;
import com.nec.corestudy.amf.NamfCommunication.model.AMFPduSessionContext;
import com.nec.corestudy.amf.NamfCommunication.model.AMFSeafData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFUeContext
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFUeContext   {
  @JsonProperty("supi")
  private String supi = null;

  @JsonProperty("supiUnauthInd")
  private Boolean supiUnauthInd = null;

  @JsonProperty("gpsi")
  @Valid
  private List<String> gpsi = null;

  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("groups")
  @Valid
  private List<String> groups = null;

  @JsonProperty("drxParameter")
  private String drxParameter = null;

  @JsonProperty("subRfsp")
  private Integer subRfsp = null;

  @JsonProperty("usedRfsp")
  private Integer usedRfsp = null;

  /**
   * Gets or Sets smsSupport
   */
  public enum SmsSupportEnum {
    _3GPP("Jamf_3GPP"),
    
    NON_3GPP("Jamf_NON_3GPP"),
    
    BOTH("Jamf_BOTH"),
    
    NONE("Jamf_NONE");

    private String value;

    SmsSupportEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SmsSupportEnum fromValue(String text) {
      for (SmsSupportEnum b : SmsSupportEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("smsSupport")
  private SmsSupportEnum smsSupport = null;

  @JsonProperty("smsfId")
  private String smsfId = null;

  @JsonProperty("seafData")
  private AMFSeafData seafData = null;

  @JsonProperty("pcfId")
  private String pcfId = null;

  @JsonProperty("hpcfId")
  private String hpcfId = null;

  @JsonProperty("eventSubscriptions")
  @Valid
  private List<AMFAmfEventSubscription> eventSubscriptions = null;

  @JsonProperty("mmContexts")
  @Valid
  private List<AMFMmContext> mmContexts = null;

  @JsonProperty("sessionContexts")
  @Valid
  private List<AMFPduSessionContext> sessionContexts = null;

  public AMFUeContext supi(String supi) {
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

  public AMFUeContext supiUnauthInd(Boolean supiUnauthInd) {
    this.supiUnauthInd = supiUnauthInd;
    return this;
  }

  /**
   * Get supiUnauthInd
   * @return supiUnauthInd
  **/
  @ApiModelProperty(value = "")


  public Boolean isSupiUnauthInd() {
    return supiUnauthInd;
  }

  public void setSupiUnauthInd(Boolean supiUnauthInd) {
    this.supiUnauthInd = supiUnauthInd;
  }

  public AMFUeContext gpsi(List<String> gpsi) {
    this.gpsi = gpsi;
    return this;
  }

  public AMFUeContext addGpsiItem(String gpsiItem) {
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

  public AMFUeContext pei(String pei) {
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

  public AMFUeContext groups(List<String> groups) {
    this.groups = groups;
    return this;
  }

  public AMFUeContext addGroupsItem(String groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<String>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * Get groups
   * @return groups
  **/
  @ApiModelProperty(value = "")


  public List<String> getGroups() {
    return groups;
  }

  public void setGroups(List<String> groups) {
    this.groups = groups;
  }

  public AMFUeContext drxParameter(String drxParameter) {
    this.drxParameter = drxParameter;
    return this;
  }

  /**
   * Get drxParameter
   * @return drxParameter
  **/
  @ApiModelProperty(value = "")


  public String getDrxParameter() {
    return drxParameter;
  }

  public void setDrxParameter(String drxParameter) {
    this.drxParameter = drxParameter;
  }

  public AMFUeContext subRfsp(Integer subRfsp) {
    this.subRfsp = subRfsp;
    return this;
  }

  /**
   * Get subRfsp
   * @return subRfsp
  **/
  @ApiModelProperty(value = "")


  public Integer getSubRfsp() {
    return subRfsp;
  }

  public void setSubRfsp(Integer subRfsp) {
    this.subRfsp = subRfsp;
  }

  public AMFUeContext usedRfsp(Integer usedRfsp) {
    this.usedRfsp = usedRfsp;
    return this;
  }

  /**
   * Get usedRfsp
   * @return usedRfsp
  **/
  @ApiModelProperty(value = "")


  public Integer getUsedRfsp() {
    return usedRfsp;
  }

  public void setUsedRfsp(Integer usedRfsp) {
    this.usedRfsp = usedRfsp;
  }

  public AMFUeContext smsSupport(SmsSupportEnum smsSupport) {
    this.smsSupport = smsSupport;
    return this;
  }

  /**
   * Get smsSupport
   * @return smsSupport
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public SmsSupportEnum getSmsSupport() {
    return smsSupport;
  }

  public void setSmsSupport(SmsSupportEnum smsSupport) {
    this.smsSupport = smsSupport;
  }

  public AMFUeContext smsfId(String smsfId) {
    this.smsfId = smsfId;
    return this;
  }

  /**
   * Get smsfId
   * @return smsfId
  **/
  @ApiModelProperty(value = "")


  public String getSmsfId() {
    return smsfId;
  }

  public void setSmsfId(String smsfId) {
    this.smsfId = smsfId;
  }

  public AMFUeContext seafData(AMFSeafData seafData) {
    this.seafData = seafData;
    return this;
  }

  /**
   * Get seafData
   * @return seafData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFSeafData getSeafData() {
    return seafData;
  }

  public void setSeafData(AMFSeafData seafData) {
    this.seafData = seafData;
  }

  public AMFUeContext pcfId(String pcfId) {
    this.pcfId = pcfId;
    return this;
  }

  /**
   * Get pcfId
   * @return pcfId
  **/
  @ApiModelProperty(value = "")


  public String getPcfId() {
    return pcfId;
  }

  public void setPcfId(String pcfId) {
    this.pcfId = pcfId;
  }

  public AMFUeContext hpcfId(String hpcfId) {
    this.hpcfId = hpcfId;
    return this;
  }

  /**
   * Get hpcfId
   * @return hpcfId
  **/
  @ApiModelProperty(value = "")


  public String getHpcfId() {
    return hpcfId;
  }

  public void setHpcfId(String hpcfId) {
    this.hpcfId = hpcfId;
  }

  public AMFUeContext eventSubscriptions(List<AMFAmfEventSubscription> eventSubscriptions) {
    this.eventSubscriptions = eventSubscriptions;
    return this;
  }

  public AMFUeContext addEventSubscriptionsItem(AMFAmfEventSubscription eventSubscriptionsItem) {
    if (this.eventSubscriptions == null) {
      this.eventSubscriptions = new ArrayList<AMFAmfEventSubscription>();
    }
    this.eventSubscriptions.add(eventSubscriptionsItem);
    return this;
  }

  /**
   * Get eventSubscriptions
   * @return eventSubscriptions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFAmfEventSubscription> getEventSubscriptions() {
    return eventSubscriptions;
  }

  public void setEventSubscriptions(List<AMFAmfEventSubscription> eventSubscriptions) {
    this.eventSubscriptions = eventSubscriptions;
  }

  public AMFUeContext mmContexts(List<AMFMmContext> mmContexts) {
    this.mmContexts = mmContexts;
    return this;
  }

  public AMFUeContext addMmContextsItem(AMFMmContext mmContextsItem) {
    if (this.mmContexts == null) {
      this.mmContexts = new ArrayList<AMFMmContext>();
    }
    this.mmContexts.add(mmContextsItem);
    return this;
  }

  /**
   * Get mmContexts
   * @return mmContexts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFMmContext> getMmContexts() {
    return mmContexts;
  }

  public void setMmContexts(List<AMFMmContext> mmContexts) {
    this.mmContexts = mmContexts;
  }

  public AMFUeContext sessionContexts(List<AMFPduSessionContext> sessionContexts) {
    this.sessionContexts = sessionContexts;
    return this;
  }

  public AMFUeContext addSessionContextsItem(AMFPduSessionContext sessionContextsItem) {
    if (this.sessionContexts == null) {
      this.sessionContexts = new ArrayList<AMFPduSessionContext>();
    }
    this.sessionContexts.add(sessionContextsItem);
    return this;
  }

  /**
   * Get sessionContexts
   * @return sessionContexts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFPduSessionContext> getSessionContexts() {
    return sessionContexts;
  }

  public void setSessionContexts(List<AMFPduSessionContext> sessionContexts) {
    this.sessionContexts = sessionContexts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFUeContext amFUeContext = (AMFUeContext) o;
    return Objects.equals(this.supi, amFUeContext.supi) &&
        Objects.equals(this.supiUnauthInd, amFUeContext.supiUnauthInd) &&
        Objects.equals(this.gpsi, amFUeContext.gpsi) &&
        Objects.equals(this.pei, amFUeContext.pei) &&
        Objects.equals(this.groups, amFUeContext.groups) &&
        Objects.equals(this.drxParameter, amFUeContext.drxParameter) &&
        Objects.equals(this.subRfsp, amFUeContext.subRfsp) &&
        Objects.equals(this.usedRfsp, amFUeContext.usedRfsp) &&
        Objects.equals(this.smsSupport, amFUeContext.smsSupport) &&
        Objects.equals(this.smsfId, amFUeContext.smsfId) &&
        Objects.equals(this.seafData, amFUeContext.seafData) &&
        Objects.equals(this.pcfId, amFUeContext.pcfId) &&
        Objects.equals(this.hpcfId, amFUeContext.hpcfId) &&
        Objects.equals(this.eventSubscriptions, amFUeContext.eventSubscriptions) &&
        Objects.equals(this.mmContexts, amFUeContext.mmContexts) &&
        Objects.equals(this.sessionContexts, amFUeContext.sessionContexts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supi, supiUnauthInd, gpsi, pei, groups, drxParameter, subRfsp, usedRfsp, smsSupport, smsfId, seafData, pcfId, hpcfId, eventSubscriptions, mmContexts, sessionContexts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFUeContext {\n");
    
    sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
    sb.append("    supiUnauthInd: ").append(toIndentedString(supiUnauthInd)).append("\n");
    sb.append("    gpsi: ").append(toIndentedString(gpsi)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    drxParameter: ").append(toIndentedString(drxParameter)).append("\n");
    sb.append("    subRfsp: ").append(toIndentedString(subRfsp)).append("\n");
    sb.append("    usedRfsp: ").append(toIndentedString(usedRfsp)).append("\n");
    sb.append("    smsSupport: ").append(toIndentedString(smsSupport)).append("\n");
    sb.append("    smsfId: ").append(toIndentedString(smsfId)).append("\n");
    sb.append("    seafData: ").append(toIndentedString(seafData)).append("\n");
    sb.append("    pcfId: ").append(toIndentedString(pcfId)).append("\n");
    sb.append("    hpcfId: ").append(toIndentedString(hpcfId)).append("\n");
    sb.append("    eventSubscriptions: ").append(toIndentedString(eventSubscriptions)).append("\n");
    sb.append("    mmContexts: ").append(toIndentedString(mmContexts)).append("\n");
    sb.append("    sessionContexts: ").append(toIndentedString(sessionContexts)).append("\n");
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

