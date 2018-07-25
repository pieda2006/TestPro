package com.nec.corestudy.udm.NudmUECM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmsfRegistrationDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-28T19:20:18.368+09:00")

public class SmsfRegistrationDB   {
  @JsonProperty("smsfId")
  private String smsfId = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public SmsfRegistrationDB smsfId(String smsfId) {
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

  public SmsfRegistrationDB supportedFeatures(String supportedFeatures) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsfRegistrationDB smsfRegistrationDB = (SmsfRegistrationDB) o;
    return Objects.equals(this.smsfId, smsfRegistrationDB.smsfId) &&
        Objects.equals(this.supportedFeatures, smsfRegistrationDB.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsfId, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsfRegistrationDB {\n");
    
    sb.append("    smsfId: ").append(toIndentedString(smsfId)).append("\n");
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
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

