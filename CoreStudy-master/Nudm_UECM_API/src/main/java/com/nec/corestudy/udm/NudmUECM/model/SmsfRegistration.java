package com.nec.corestudy.udm.NudmUECM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmsfRegistration
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T20:24:10.908+09:00")

public class SmsfRegistration   {
  @JsonProperty("smsfId")
  private String smsfId = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public SmsfRegistration smsfId(String smsfId) {
    this.smsfId = smsfId;
    return this;
  }

  /**
   * Get smsfId
   * @return smsfId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSmsfId() {
    return smsfId;
  }

  public void setSmsfId(String smsfId) {
    this.smsfId = smsfId;
  }

  public SmsfRegistration supportedFeatures(String supportedFeatures) {
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
    SmsfRegistration smsfRegistration = (SmsfRegistration) o;
    return Objects.equals(this.smsfId, smsfRegistration.smsfId) &&
        Objects.equals(this.supportedFeatures, smsfRegistration.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsfId, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsfRegistration {\n");
    
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

