package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfCommunication.model.AMFServiceAreaRestriction;
import com.nec.corestudy.amf.NamfCommunication.model.AMFTai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFMobilityRestrictions
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFMobilityRestrictions   {
  /**
   * Gets or Sets ratRestriction
   */
  public enum RatRestrictionEnum {
    NR("Jamf_NR"),
    
    EUTRA("Jamf_EUTRA"),
    
    WLAN("Jamf_WLAN"),
    
    VIRTUAL("Jamf_VIRTUAL");

    private String value;

    RatRestrictionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RatRestrictionEnum fromValue(String text) {
      for (RatRestrictionEnum b : RatRestrictionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("ratRestriction")
  @Valid
  private List<RatRestrictionEnum> ratRestriction = new ArrayList<RatRestrictionEnum>();

  @JsonProperty("forbiddenArea")
  @Valid
  private List<AMFTai> forbiddenArea = new ArrayList<AMFTai>();

  @JsonProperty("saRestriction")
  private AMFServiceAreaRestriction saRestriction = null;

  public AMFMobilityRestrictions ratRestriction(List<RatRestrictionEnum> ratRestriction) {
    this.ratRestriction = ratRestriction;
    return this;
  }

  public AMFMobilityRestrictions addRatRestrictionItem(RatRestrictionEnum ratRestrictionItem) {
    this.ratRestriction.add(ratRestrictionItem);
    return this;
  }

  /**
   * Get ratRestriction
   * @return ratRestriction
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public List<RatRestrictionEnum> getRatRestriction() {
    return ratRestriction;
  }

  public void setRatRestriction(List<RatRestrictionEnum> ratRestriction) {
    this.ratRestriction = ratRestriction;
  }

  public AMFMobilityRestrictions forbiddenArea(List<AMFTai> forbiddenArea) {
    this.forbiddenArea = forbiddenArea;
    return this;
  }

  public AMFMobilityRestrictions addForbiddenAreaItem(AMFTai forbiddenAreaItem) {
    this.forbiddenArea.add(forbiddenAreaItem);
    return this;
  }

  /**
   * FFS
   * @return forbiddenArea
  **/
  @ApiModelProperty(required = true, value = "FFS")
  @NotNull

  @Valid

  public List<AMFTai> getForbiddenArea() {
    return forbiddenArea;
  }

  public void setForbiddenArea(List<AMFTai> forbiddenArea) {
    this.forbiddenArea = forbiddenArea;
  }

  public AMFMobilityRestrictions saRestriction(AMFServiceAreaRestriction saRestriction) {
    this.saRestriction = saRestriction;
    return this;
  }

  /**
   * Get saRestriction
   * @return saRestriction
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFServiceAreaRestriction getSaRestriction() {
    return saRestriction;
  }

  public void setSaRestriction(AMFServiceAreaRestriction saRestriction) {
    this.saRestriction = saRestriction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFMobilityRestrictions amFMobilityRestrictions = (AMFMobilityRestrictions) o;
    return Objects.equals(this.ratRestriction, amFMobilityRestrictions.ratRestriction) &&
        Objects.equals(this.forbiddenArea, amFMobilityRestrictions.forbiddenArea) &&
        Objects.equals(this.saRestriction, amFMobilityRestrictions.saRestriction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ratRestriction, forbiddenArea, saRestriction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFMobilityRestrictions {\n");
    
    sb.append("    ratRestriction: ").append(toIndentedString(ratRestriction)).append("\n");
    sb.append("    forbiddenArea: ").append(toIndentedString(forbiddenArea)).append("\n");
    sb.append("    saRestriction: ").append(toIndentedString(saRestriction)).append("\n");
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

