package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.DnnConfigurationDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SnssaiDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SessionManagementSubscriptionDataDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SessionManagementSubscriptionDataDB   {
  @JsonProperty("singleNssai")
  private SnssaiDB singleNssai = null;

  @JsonProperty("dnnConfiguration")
  @Valid
  private List<DnnConfigurationDB> dnnConfiguration = null;

  public SessionManagementSubscriptionDataDB singleNssai(SnssaiDB singleNssai) {
    this.singleNssai = singleNssai;
    return this;
  }

  /**
   * Get singleNssai
   * @return singleNssai
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SnssaiDB getSingleNssai() {
    return singleNssai;
  }

  public void setSingleNssai(SnssaiDB singleNssai) {
    this.singleNssai = singleNssai;
  }

  public SessionManagementSubscriptionDataDB dnnConfiguration(List<DnnConfigurationDB> dnnConfiguration) {
    this.dnnConfiguration = dnnConfiguration;
    return this;
  }

  public SessionManagementSubscriptionDataDB addDnnConfigurationItem(DnnConfigurationDB dnnConfigurationItem) {
    if (this.dnnConfiguration == null) {
      this.dnnConfiguration = new ArrayList<DnnConfigurationDB>();
    }
    this.dnnConfiguration.add(dnnConfigurationItem);
    return this;
  }

  /**
   * Get dnnConfiguration
   * @return dnnConfiguration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<DnnConfigurationDB> getDnnConfiguration() {
    return dnnConfiguration;
  }

  public void setDnnConfiguration(List<DnnConfigurationDB> dnnConfiguration) {
    this.dnnConfiguration = dnnConfiguration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionManagementSubscriptionDataDB sessionManagementSubscriptionDataDB = (SessionManagementSubscriptionDataDB) o;
    return Objects.equals(this.singleNssai, sessionManagementSubscriptionDataDB.singleNssai) &&
        Objects.equals(this.dnnConfiguration, sessionManagementSubscriptionDataDB.dnnConfiguration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(singleNssai, dnnConfiguration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionManagementSubscriptionDataDB {\n");
    
    sb.append("    singleNssai: ").append(toIndentedString(singleNssai)).append("\n");
    sb.append("    dnnConfiguration: ").append(toIndentedString(dnnConfiguration)).append("\n");
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

