package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmsManagementSubscriptionDataDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SmsManagementSubscriptionDataDB   {
  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("mtSmsSubscribed")
  private Boolean mtSmsSubscribed = null;

  @JsonProperty("mtSmsBarringAll")
  private Boolean mtSmsBarringAll = null;

  @JsonProperty("mtSmsbarringRoaming")
  private Boolean mtSmsbarringRoaming = null;

  @JsonProperty("moSmsSubscribed")
  private Boolean moSmsSubscribed = null;

  @JsonProperty("moSmsBarringAll")
  private Boolean moSmsBarringAll = null;

  @JsonProperty("moSmsbarringRoaming")
  private Boolean moSmsbarringRoaming = null;

  public SmsManagementSubscriptionDataDB supportedFeatures(String supportedFeatures) {
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

  public SmsManagementSubscriptionDataDB mtSmsSubscribed(Boolean mtSmsSubscribed) {
    this.mtSmsSubscribed = mtSmsSubscribed;
    return this;
  }

  /**
   * Get mtSmsSubscribed
   * @return mtSmsSubscribed
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isMtSmsSubscribed() {
    return mtSmsSubscribed;
  }

  public void setMtSmsSubscribed(Boolean mtSmsSubscribed) {
    this.mtSmsSubscribed = mtSmsSubscribed;
  }

  public SmsManagementSubscriptionDataDB mtSmsBarringAll(Boolean mtSmsBarringAll) {
    this.mtSmsBarringAll = mtSmsBarringAll;
    return this;
  }

  /**
   * Get mtSmsBarringAll
   * @return mtSmsBarringAll
  **/
  @ApiModelProperty(value = "")


  public Boolean isMtSmsBarringAll() {
    return mtSmsBarringAll;
  }

  public void setMtSmsBarringAll(Boolean mtSmsBarringAll) {
    this.mtSmsBarringAll = mtSmsBarringAll;
  }

  public SmsManagementSubscriptionDataDB mtSmsbarringRoaming(Boolean mtSmsbarringRoaming) {
    this.mtSmsbarringRoaming = mtSmsbarringRoaming;
    return this;
  }

  /**
   * Get mtSmsbarringRoaming
   * @return mtSmsbarringRoaming
  **/
  @ApiModelProperty(value = "")


  public Boolean isMtSmsbarringRoaming() {
    return mtSmsbarringRoaming;
  }

  public void setMtSmsbarringRoaming(Boolean mtSmsbarringRoaming) {
    this.mtSmsbarringRoaming = mtSmsbarringRoaming;
  }

  public SmsManagementSubscriptionDataDB moSmsSubscribed(Boolean moSmsSubscribed) {
    this.moSmsSubscribed = moSmsSubscribed;
    return this;
  }

  /**
   * Get moSmsSubscribed
   * @return moSmsSubscribed
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isMoSmsSubscribed() {
    return moSmsSubscribed;
  }

  public void setMoSmsSubscribed(Boolean moSmsSubscribed) {
    this.moSmsSubscribed = moSmsSubscribed;
  }

  public SmsManagementSubscriptionDataDB moSmsBarringAll(Boolean moSmsBarringAll) {
    this.moSmsBarringAll = moSmsBarringAll;
    return this;
  }

  /**
   * Get moSmsBarringAll
   * @return moSmsBarringAll
  **/
  @ApiModelProperty(value = "")


  public Boolean isMoSmsBarringAll() {
    return moSmsBarringAll;
  }

  public void setMoSmsBarringAll(Boolean moSmsBarringAll) {
    this.moSmsBarringAll = moSmsBarringAll;
  }

  public SmsManagementSubscriptionDataDB moSmsbarringRoaming(Boolean moSmsbarringRoaming) {
    this.moSmsbarringRoaming = moSmsbarringRoaming;
    return this;
  }

  /**
   * Get moSmsbarringRoaming
   * @return moSmsbarringRoaming
  **/
  @ApiModelProperty(value = "")


  public Boolean isMoSmsbarringRoaming() {
    return moSmsbarringRoaming;
  }

  public void setMoSmsbarringRoaming(Boolean moSmsbarringRoaming) {
    this.moSmsbarringRoaming = moSmsbarringRoaming;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsManagementSubscriptionDataDB smsManagementSubscriptionDataDB = (SmsManagementSubscriptionDataDB) o;
    return Objects.equals(this.supportedFeatures, smsManagementSubscriptionDataDB.supportedFeatures) &&
        Objects.equals(this.mtSmsSubscribed, smsManagementSubscriptionDataDB.mtSmsSubscribed) &&
        Objects.equals(this.mtSmsBarringAll, smsManagementSubscriptionDataDB.mtSmsBarringAll) &&
        Objects.equals(this.mtSmsbarringRoaming, smsManagementSubscriptionDataDB.mtSmsbarringRoaming) &&
        Objects.equals(this.moSmsSubscribed, smsManagementSubscriptionDataDB.moSmsSubscribed) &&
        Objects.equals(this.moSmsBarringAll, smsManagementSubscriptionDataDB.moSmsBarringAll) &&
        Objects.equals(this.moSmsbarringRoaming, smsManagementSubscriptionDataDB.moSmsbarringRoaming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportedFeatures, mtSmsSubscribed, mtSmsBarringAll, mtSmsbarringRoaming, moSmsSubscribed, moSmsBarringAll, moSmsbarringRoaming);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsManagementSubscriptionDataDB {\n");
    
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    mtSmsSubscribed: ").append(toIndentedString(mtSmsSubscribed)).append("\n");
    sb.append("    mtSmsBarringAll: ").append(toIndentedString(mtSmsBarringAll)).append("\n");
    sb.append("    mtSmsbarringRoaming: ").append(toIndentedString(mtSmsbarringRoaming)).append("\n");
    sb.append("    moSmsSubscribed: ").append(toIndentedString(moSmsSubscribed)).append("\n");
    sb.append("    moSmsBarringAll: ").append(toIndentedString(moSmsBarringAll)).append("\n");
    sb.append("    moSmsbarringRoaming: ").append(toIndentedString(moSmsbarringRoaming)).append("\n");
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
