package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.model.AccessAndMobilitySubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.SmfSelectionSubscriptionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubscriptionDataSets
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class SubscriptionDataSets   {
  @JsonProperty("amData")
  private AccessAndMobilitySubscriptionData amData = null;

  @JsonProperty("smfSelData")
  private SmfSelectionSubscriptionData smfSelData = null;

  public SubscriptionDataSets amData(AccessAndMobilitySubscriptionData amData) {
    this.amData = amData;
    return this;
  }

  /**
   * Get amData
   * @return amData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccessAndMobilitySubscriptionData getAmData() {
    return amData;
  }

  public void setAmData(AccessAndMobilitySubscriptionData amData) {
    this.amData = amData;
  }

  public SubscriptionDataSets smfSelData(SmfSelectionSubscriptionData smfSelData) {
    this.smfSelData = smfSelData;
    return this;
  }

  /**
   * Get smfSelData
   * @return smfSelData
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SmfSelectionSubscriptionData getSmfSelData() {
    return smfSelData;
  }

  public void setSmfSelData(SmfSelectionSubscriptionData smfSelData) {
    this.smfSelData = smfSelData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionDataSets subscriptionDataSets = (SubscriptionDataSets) o;
    return Objects.equals(this.amData, subscriptionDataSets.amData) &&
        Objects.equals(this.smfSelData, subscriptionDataSets.smfSelData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amData, smfSelData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionDataSets {\n");
    
    sb.append("    amData: ").append(toIndentedString(amData)).append("\n");
    sb.append("    smfSelData: ").append(toIndentedString(smfSelData)).append("\n");
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

