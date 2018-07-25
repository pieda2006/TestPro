package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.AccessAndMobilitySubscriptionDataDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SmfSelectionSubscriptionDataDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubscriptionDataSetsDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SubscriptionDataSetsDB   {
  @JsonProperty("amData")
  private AccessAndMobilitySubscriptionDataDB amData = null;

  @JsonProperty("smfSelData")
  private SmfSelectionSubscriptionDataDB smfSelData = null;

  public SubscriptionDataSetsDB amData(AccessAndMobilitySubscriptionDataDB amData) {
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

  public SubscriptionDataSetsDB smfSelData(SmfSelectionSubscriptionDataDB smfSelData) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionDataSetsDB subscriptionDataSetsDB = (SubscriptionDataSetsDB) o;
    return Objects.equals(this.amData, subscriptionDataSetsDB.amData) &&
        Objects.equals(this.smfSelData, subscriptionDataSetsDB.smfSelData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amData, smfSelData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionDataSetsDB {\n");
    
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

