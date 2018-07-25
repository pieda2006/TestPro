package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFServiceAreaRestriction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFServiceAreaRestriction   {
  /**
   * Gets or Sets allowedTais
   */
  public enum AllowedTaisEnum {
    NR("Jamf_NR"),
    
    EUTRA("Jamf_EUTRA"),
    
    WLAN("Jamf_WLAN"),
    
    VIRTUAL("Jamf_VIRTUAL");

    private String value;

    AllowedTaisEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AllowedTaisEnum fromValue(String text) {
      for (AllowedTaisEnum b : AllowedTaisEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("allowedTais")
  @Valid
  private List<AllowedTaisEnum> allowedTais = null;

  /**
   * Gets or Sets nonAllowedTais
   */
  public enum NonAllowedTaisEnum {
    NR("Jamf_NR"),
    
    EUTRA("Jamf_EUTRA"),
    
    WLAN("Jamf_WLAN"),
    
    VIRTUAL("Jamf_VIRTUAL");

    private String value;

    NonAllowedTaisEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NonAllowedTaisEnum fromValue(String text) {
      for (NonAllowedTaisEnum b : NonAllowedTaisEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("nonAllowedTais")
  @Valid
  private List<NonAllowedTaisEnum> nonAllowedTais = null;

  @JsonProperty("maxAllowedTais")
  private Integer maxAllowedTais = null;

  public AMFServiceAreaRestriction allowedTais(List<AllowedTaisEnum> allowedTais) {
    this.allowedTais = allowedTais;
    return this;
  }

  public AMFServiceAreaRestriction addAllowedTaisItem(AllowedTaisEnum allowedTaisItem) {
    if (this.allowedTais == null) {
      this.allowedTais = new ArrayList<AllowedTaisEnum>();
    }
    this.allowedTais.add(allowedTaisItem);
    return this;
  }

  /**
   * Get allowedTais
   * @return allowedTais
  **/
  @ApiModelProperty(value = "")


  public List<AllowedTaisEnum> getAllowedTais() {
    return allowedTais;
  }

  public void setAllowedTais(List<AllowedTaisEnum> allowedTais) {
    this.allowedTais = allowedTais;
  }

  public AMFServiceAreaRestriction nonAllowedTais(List<NonAllowedTaisEnum> nonAllowedTais) {
    this.nonAllowedTais = nonAllowedTais;
    return this;
  }

  public AMFServiceAreaRestriction addNonAllowedTaisItem(NonAllowedTaisEnum nonAllowedTaisItem) {
    if (this.nonAllowedTais == null) {
      this.nonAllowedTais = new ArrayList<NonAllowedTaisEnum>();
    }
    this.nonAllowedTais.add(nonAllowedTaisItem);
    return this;
  }

  /**
   * Get nonAllowedTais
   * @return nonAllowedTais
  **/
  @ApiModelProperty(value = "")


  public List<NonAllowedTaisEnum> getNonAllowedTais() {
    return nonAllowedTais;
  }

  public void setNonAllowedTais(List<NonAllowedTaisEnum> nonAllowedTais) {
    this.nonAllowedTais = nonAllowedTais;
  }

  public AMFServiceAreaRestriction maxAllowedTais(Integer maxAllowedTais) {
    this.maxAllowedTais = maxAllowedTais;
    return this;
  }

  /**
   * Get maxAllowedTais
   * @return maxAllowedTais
  **/
  @ApiModelProperty(value = "")


  public Integer getMaxAllowedTais() {
    return maxAllowedTais;
  }

  public void setMaxAllowedTais(Integer maxAllowedTais) {
    this.maxAllowedTais = maxAllowedTais;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFServiceAreaRestriction amFServiceAreaRestriction = (AMFServiceAreaRestriction) o;
    return Objects.equals(this.allowedTais, amFServiceAreaRestriction.allowedTais) &&
        Objects.equals(this.nonAllowedTais, amFServiceAreaRestriction.nonAllowedTais) &&
        Objects.equals(this.maxAllowedTais, amFServiceAreaRestriction.maxAllowedTais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowedTais, nonAllowedTais, maxAllowedTais);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFServiceAreaRestriction {\n");
    
    sb.append("    allowedTais: ").append(toIndentedString(allowedTais)).append("\n");
    sb.append("    nonAllowedTais: ").append(toIndentedString(nonAllowedTais)).append("\n");
    sb.append("    maxAllowedTais: ").append(toIndentedString(maxAllowedTais)).append("\n");
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

