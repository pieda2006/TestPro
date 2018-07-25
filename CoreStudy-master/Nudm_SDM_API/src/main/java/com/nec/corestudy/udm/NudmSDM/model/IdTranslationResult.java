package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IdTranslationResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class IdTranslationResult   {
  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("supi")
  private String supi = null;

  @JsonProperty("gpsi")
  private String gpsi = null;

  public IdTranslationResult supportedFeatures(String supportedFeatures) {
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

  public IdTranslationResult supi(String supi) {
    this.supi = supi;
    return this;
  }

  /**
   * Get supi
   * @return supi
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSupi() {
    return supi;
  }

  public void setSupi(String supi) {
    this.supi = supi;
  }

  public IdTranslationResult gpsi(String gpsi) {
    this.gpsi = gpsi;
    return this;
  }

  /**
   * Get gpsi
   * @return gpsi
  **/
  @ApiModelProperty(value = "")


  public String getGpsi() {
    return gpsi;
  }

  public void setGpsi(String gpsi) {
    this.gpsi = gpsi;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdTranslationResult idTranslationResult = (IdTranslationResult) o;
    return Objects.equals(this.supportedFeatures, idTranslationResult.supportedFeatures) &&
        Objects.equals(this.supi, idTranslationResult.supi) &&
        Objects.equals(this.gpsi, idTranslationResult.gpsi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportedFeatures, supi, gpsi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdTranslationResult {\n");
    
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    supi: ").append(toIndentedString(supi)).append("\n");
    sb.append("    gpsi: ").append(toIndentedString(gpsi)).append("\n");
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

