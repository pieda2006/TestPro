package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.udm.NudmSDM.model.AreaInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AreaRestriction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class AreaRestriction   {
  /**
   * Gets or Sets restrictionType
   */
  public enum RestrictionTypeEnum {
    SAR_ALLOWED_AREA("SAR_ALLOWED_AREA"),
    
    SAR_NOT_ALLOWED_AREA("SAR_NOT_ALLOWED_AREA"),
    
    FORBIDDEN_AREA("FORBIDDEN_AREA");

    private String value;

    RestrictionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RestrictionTypeEnum fromValue(String text) {
      for (RestrictionTypeEnum b : RestrictionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("restrictionType")
  private RestrictionTypeEnum restrictionType = null;

  @JsonProperty("areaInformation")
  private AreaInformation areaInformation = null;

  /**
   * Gets or Sets ratType
   */
  public enum RatTypeEnum {
    NR("NR"),
    
    EUTRA("EUTRA"),
    
    WLAN("WLAN"),
    
    VIRTUAL("VIRTUAL");

    private String value;

    RatTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RatTypeEnum fromValue(String text) {
      for (RatTypeEnum b : RatTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("ratType")
  @Valid
  private List<RatTypeEnum> ratType = null;

  public AreaRestriction restrictionType(RestrictionTypeEnum restrictionType) {
    this.restrictionType = restrictionType;
    return this;
  }

  /**
   * Get restrictionType
   * @return restrictionType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public RestrictionTypeEnum getRestrictionType() {
    return restrictionType;
  }

  public void setRestrictionType(RestrictionTypeEnum restrictionType) {
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

  @Valid

  public AreaInformation getAreaInformation() {
    return areaInformation;
  }

  public void setAreaInformation(AreaInformation areaInformation) {
    this.areaInformation = areaInformation;
  }

  public AreaRestriction ratType(List<RatTypeEnum> ratType) {
    this.ratType = ratType;
    return this;
  }

  public AreaRestriction addRatTypeItem(RatTypeEnum ratTypeItem) {
    if (this.ratType == null) {
      this.ratType = new ArrayList<RatTypeEnum>();
    }
    this.ratType.add(ratTypeItem);
    return this;
  }

  /**
   * Get ratType
   * @return ratType
  **/
  @ApiModelProperty(value = "")


  public List<RatTypeEnum> getRatType() {
    return ratType;
  }

  public void setRatType(List<RatTypeEnum> ratType) {
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

