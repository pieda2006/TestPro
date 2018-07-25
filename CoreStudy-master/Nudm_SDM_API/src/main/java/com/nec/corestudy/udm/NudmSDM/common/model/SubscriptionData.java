package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.AccessAndMobilitySubscriptionDataDB;
import com.nec.corestudy.udm.NudmSDM.common.model.NssaiDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SessionManagementSubscriptionDataDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SmfSelectionSubscriptionDataDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SmsManagementSubscriptionDataDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SmsSubscriptionDataDB;
import com.nec.corestudy.udm.NudmSDM.common.model.UeContextInSmfDataDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubscriptionData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SubscriptionData   {
  @JsonProperty("nssai")
  private NssaiDB nssai = null;

  @JsonProperty("amData")
  private AccessAndMobilitySubscriptionDataDB amData = null;

  @JsonProperty("smfSelData")
  private SmfSelectionSubscriptionDataDB smfSelData = null;

  @JsonProperty("ueContextInSmfData")
  private UeContextInSmfDataDB ueContextInSmfData = null;

  @JsonProperty("sessionManagementSubscriptionData")
  @Valid
  private List<SessionManagementSubscriptionDataDB> sessionManagementSubscriptionData = null;

  @JsonProperty("smsSubscriptionData")
  private SmsSubscriptionDataDB smsSubscriptionData = null;

  @JsonProperty("smsManagementSubscriptionData")
  private SmsManagementSubscriptionDataDB smsManagementSubscriptionData = null;

  public SubscriptionData nssai(NssaiDB nssai) {
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

  public SubscriptionData amData(AccessAndMobilitySubscriptionDataDB amData) {
    this.amData = amData;
    return this;
  }

  /**
   * Get amData
   * @return amData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccessAndMobilitySubscriptionDataDB getAmData() {
    return amData;
  }

  public void setAmData(AccessAndMobilitySubscriptionDataDB amData) {
    this.amData = amData;
  }

  public SubscriptionData smfSelData(SmfSelectionSubscriptionDataDB smfSelData) {
    this.smfSelData = smfSelData;
    return this;
  }

  /**
   * Get smfSelData
   * @return smfSelData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SmfSelectionSubscriptionDataDB getSmfSelData() {
    return smfSelData;
  }

  public void setSmfSelData(SmfSelectionSubscriptionDataDB smfSelData) {
    this.smfSelData = smfSelData;
  }

  public SubscriptionData ueContextInSmfData(UeContextInSmfDataDB ueContextInSmfData) {
    this.ueContextInSmfData = ueContextInSmfData;
    return this;
  }

  /**
   * Get ueContextInSmfData
   * @return ueContextInSmfData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UeContextInSmfDataDB getUeContextInSmfData() {
    return ueContextInSmfData;
  }

  public void setUeContextInSmfData(UeContextInSmfDataDB ueContextInSmfData) {
    this.ueContextInSmfData = ueContextInSmfData;
  }

  public SubscriptionData sessionManagementSubscriptionData(List<SessionManagementSubscriptionDataDB> sessionManagementSubscriptionData) {
    this.sessionManagementSubscriptionData = sessionManagementSubscriptionData;
    return this;
  }

  public SubscriptionData addSessionManagementSubscriptionDataItem(SessionManagementSubscriptionDataDB sessionManagementSubscriptionDataItem) {
    if (this.sessionManagementSubscriptionData == null) {
      this.sessionManagementSubscriptionData = new ArrayList<SessionManagementSubscriptionDataDB>();
    }
    this.sessionManagementSubscriptionData.add(sessionManagementSubscriptionDataItem);
    return this;
  }

  /**
   * Get sessionManagementSubscriptionData
   * @return sessionManagementSubscriptionData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SessionManagementSubscriptionDataDB> getSessionManagementSubscriptionData() {
    return sessionManagementSubscriptionData;
  }

  public void setSessionManagementSubscriptionData(List<SessionManagementSubscriptionDataDB> sessionManagementSubscriptionData) {
    this.sessionManagementSubscriptionData = sessionManagementSubscriptionData;
  }

  public SubscriptionData smsSubscriptionData(SmsSubscriptionDataDB smsSubscriptionData) {
    this.smsSubscriptionData = smsSubscriptionData;
    return this;
  }

  /**
   * Get smsSubscriptionData
   * @return smsSubscriptionData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SmsSubscriptionDataDB getSmsSubscriptionData() {
    return smsSubscriptionData;
  }

  public void setSmsSubscriptionData(SmsSubscriptionDataDB smsSubscriptionData) {
    this.smsSubscriptionData = smsSubscriptionData;
  }

  public SubscriptionData smsManagementSubscriptionData(SmsManagementSubscriptionDataDB smsManagementSubscriptionData) {
    this.smsManagementSubscriptionData = smsManagementSubscriptionData;
    return this;
  }

  /**
   * Get smsManagementSubscriptionData
   * @return smsManagementSubscriptionData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SmsManagementSubscriptionDataDB getSmsManagementSubscriptionData() {
    return smsManagementSubscriptionData;
  }

  public void setSmsManagementSubscriptionData(SmsManagementSubscriptionDataDB smsManagementSubscriptionData) {
    this.smsManagementSubscriptionData = smsManagementSubscriptionData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionData subscriptionData = (SubscriptionData) o;
    return Objects.equals(this.nssai, subscriptionData.nssai) &&
        Objects.equals(this.amData, subscriptionData.amData) &&
        Objects.equals(this.smfSelData, subscriptionData.smfSelData) &&
        Objects.equals(this.ueContextInSmfData, subscriptionData.ueContextInSmfData) &&
        Objects.equals(this.sessionManagementSubscriptionData, subscriptionData.sessionManagementSubscriptionData) &&
        Objects.equals(this.smsSubscriptionData, subscriptionData.smsSubscriptionData) &&
        Objects.equals(this.smsManagementSubscriptionData, subscriptionData.smsManagementSubscriptionData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nssai, amData, smfSelData, ueContextInSmfData, sessionManagementSubscriptionData, smsSubscriptionData, smsManagementSubscriptionData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionData {\n");
    
    sb.append("    nssai: ").append(toIndentedString(nssai)).append("\n");
    sb.append("    amData: ").append(toIndentedString(amData)).append("\n");
    sb.append("    smfSelData: ").append(toIndentedString(smfSelData)).append("\n");
    sb.append("    ueContextInSmfData: ").append(toIndentedString(ueContextInSmfData)).append("\n");
    sb.append("    sessionManagementSubscriptionData: ").append(toIndentedString(sessionManagementSubscriptionData)).append("\n");
    sb.append("    smsSubscriptionData: ").append(toIndentedString(smsSubscriptionData)).append("\n");
    sb.append("    smsManagementSubscriptionData: ").append(toIndentedString(smsManagementSubscriptionData)).append("\n");
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

