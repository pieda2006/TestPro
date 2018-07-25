package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.SnssaiInfoDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmfSelectionSubscriptionDataDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SmfSelectionSubscriptionDataDB   {
  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("subscribedSnssaiInfo")
  @Valid
  private List<SnssaiInfoDB> subscribedSnssaiInfo = null;

  public SmfSelectionSubscriptionDataDB supportedFeatures(String supportedFeatures) {
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

  public SmfSelectionSubscriptionDataDB subscribedSnssaiInfo(List<SnssaiInfoDB> subscribedSnssaiInfo) {
    this.subscribedSnssaiInfo = subscribedSnssaiInfo;
    return this;
  }

  public SmfSelectionSubscriptionDataDB addSubscribedSnssaiInfoItem(SnssaiInfoDB subscribedSnssaiInfoItem) {
    if (this.subscribedSnssaiInfo == null) {
      this.subscribedSnssaiInfo = new ArrayList<SnssaiInfoDB>();
    }
    this.subscribedSnssaiInfo.add(subscribedSnssaiInfoItem);
    return this;
  }

  /**
   * Get subscribedSnssaiInfo
   * @return subscribedSnssaiInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SnssaiInfoDB> getSubscribedSnssaiInfo() {
    return subscribedSnssaiInfo;
  }

  public void setSubscribedSnssaiInfo(List<SnssaiInfoDB> subscribedSnssaiInfo) {
    this.subscribedSnssaiInfo = subscribedSnssaiInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmfSelectionSubscriptionDataDB smfSelectionSubscriptionDataDB = (SmfSelectionSubscriptionDataDB) o;
    return Objects.equals(this.supportedFeatures, smfSelectionSubscriptionDataDB.supportedFeatures) &&
        Objects.equals(this.subscribedSnssaiInfo, smfSelectionSubscriptionDataDB.subscribedSnssaiInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportedFeatures, subscribedSnssaiInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmfSelectionSubscriptionDataDB {\n");
    
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    subscribedSnssaiInfo: ").append(toIndentedString(subscribedSnssaiInfo)).append("\n");
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

