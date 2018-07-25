package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.SnssaiDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NssaiDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class NssaiDB   {
  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("defaultSingleNssais")
  @Valid
  private List<SnssaiDB> defaultSingleNssais = null;

  @JsonProperty("singleNssais")
  @Valid
  private List<SnssaiDB> singleNssais = null;

  public NssaiDB supportedFeatures(String supportedFeatures) {
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

  public NssaiDB defaultSingleNssais(List<SnssaiDB> defaultSingleNssais) {
    this.defaultSingleNssais = defaultSingleNssais;
    return this;
  }

  public NssaiDB addDefaultSingleNssaisItem(SnssaiDB defaultSingleNssaisItem) {
    if (this.defaultSingleNssais == null) {
      this.defaultSingleNssais = new ArrayList<SnssaiDB>();
    }
    this.defaultSingleNssais.add(defaultSingleNssaisItem);
    return this;
  }

  /**
   * Get defaultSingleNssais
   * @return defaultSingleNssais
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SnssaiDB> getDefaultSingleNssais() {
    return defaultSingleNssais;
  }

  public void setDefaultSingleNssais(List<SnssaiDB> defaultSingleNssais) {
    this.defaultSingleNssais = defaultSingleNssais;
  }

  public NssaiDB singleNssais(List<SnssaiDB> singleNssais) {
    this.singleNssais = singleNssais;
    return this;
  }

  public NssaiDB addSingleNssaisItem(SnssaiDB singleNssaisItem) {
    if (this.singleNssais == null) {
      this.singleNssais = new ArrayList<SnssaiDB>();
    }
    this.singleNssais.add(singleNssaisItem);
    return this;
  }

  /**
   * Get singleNssais
   * @return singleNssais
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SnssaiDB> getSingleNssais() {
    return singleNssais;
  }

  public void setSingleNssais(List<SnssaiDB> singleNssais) {
    this.singleNssais = singleNssais;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NssaiDB nssaiDB = (NssaiDB) o;
    return Objects.equals(this.supportedFeatures, nssaiDB.supportedFeatures) &&
        Objects.equals(this.defaultSingleNssais, nssaiDB.defaultSingleNssais) &&
        Objects.equals(this.singleNssais, nssaiDB.singleNssais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supportedFeatures, defaultSingleNssais, singleNssais);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NssaiDB {\n");
    
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    defaultSingleNssais: ").append(toIndentedString(defaultSingleNssais)).append("\n");
    sb.append("    singleNssais: ").append(toIndentedString(singleNssais)).append("\n");
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

