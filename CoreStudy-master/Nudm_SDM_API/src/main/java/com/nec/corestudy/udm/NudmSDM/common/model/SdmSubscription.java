package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.SdmSubscriptionDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SdmSubscription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SdmSubscription   {
  @JsonProperty("sdmSubscriptions")
  private SdmSubscriptionDB sdmSubscriptions = null;

  public SdmSubscription sdmSubscriptions(SdmSubscriptionDB sdmSubscriptions) {
    this.sdmSubscriptions = sdmSubscriptions;
    return this;
  }

  /**
   * Get sdmSubscriptions
   * @return sdmSubscriptions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SdmSubscriptionDB getSdmSubscriptions() {
    return sdmSubscriptions;
  }

  public void setSdmSubscriptions(SdmSubscriptionDB sdmSubscriptions) {
    this.sdmSubscriptions = sdmSubscriptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SdmSubscription sdmSubscription = (SdmSubscription) o;
    return Objects.equals(this.sdmSubscriptions, sdmSubscription.sdmSubscriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sdmSubscriptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SdmSubscription {\n");
    
    sb.append("    sdmSubscriptions: ").append(toIndentedString(sdmSubscriptions)).append("\n");
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

