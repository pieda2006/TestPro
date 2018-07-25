package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSdmCLI.model.AreaInformation;
import com.nec.corestudy.amf.NamfSdmCLI.model.RatType;
import com.nec.corestudy.amf.NamfSdmCLI.model.RestrictionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * AreaRestriction
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:45.878+09:00")

public class AreaRestriction   {
  @JsonProperty("restrictionType")
  private RestrictionType restrictionType = null;

  @JsonProperty("areaInformation")
  private AreaInformation areaInformation = null;

  @JsonProperty("ratType")
  
  private List<RatType> ratType = null;

  public AreaRestriction restrictionType(RestrictionType restrictionType) {
    this.restrictionType = restrictionType;
    return this;
  }

  /**
   * Get restrictionType
   * @return restrictionType
  **/
  @ApiModelProperty(required = true, value = "")
  public RestrictionType getRestrictionType() {
    return restrictionType;
  }

  public void setRestrictionType(RestrictionType restrictionType) {
    this.restrictionType = restrictionType;
  }

  public AreaRestriction areaInformation(AreaInformation areaInformation) {
    this.areaInformation = areaInformation;
    return this;
  }

  /**
   * Get areaInformation
   * @return areaInformation
  **/
  @ApiModelProperty(value = "")
  public AreaInformation getAreaInformation() {
    return areaInformation;
  }

  public void setAreaInformation(AreaInformation areaInformation) {
    this.areaInformation = areaInformation;
  }

  public AreaRestriction ratType(List<RatType> ratType) {
    this.ratType = ratType;
    return this;
  }

  public AreaRestriction addRatTypeItem(RatType ratTypeItem) {
    if (this.ratType == null) {
      this.ratType = new ArrayList<RatType>();
    }
    this.ratType.add(ratTypeItem);
    return this;
  }

  /**
   * Get ratType
   * @return ratType
  **/
  @ApiModelProperty(value = "")
  public List<RatType> getRatType() {
    return ratType;
  }

  public void setRatType(List<RatType> ratType) {
    this.ratType = ratType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AreaRestriction areaRestriction = (AreaRestriction) o;
    return Objects.equals(this.restrictionType, areaRestriction.restrictionType) &&
        Objects.equals(this.areaInformation, areaRestriction.areaInformation) &&
        Objects.equals(this.ratType, areaRestriction.ratType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restrictionType, areaInformation, ratType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AreaRestriction {\n");
    
    sb.append("    restrictionType: ").append(toIndentedString(restrictionType)).append("\n");
    sb.append("    areaInformation: ").append(toIndentedString(areaInformation)).append("\n");
    sb.append("    ratType: ").append(toIndentedString(ratType)).append("\n");
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

