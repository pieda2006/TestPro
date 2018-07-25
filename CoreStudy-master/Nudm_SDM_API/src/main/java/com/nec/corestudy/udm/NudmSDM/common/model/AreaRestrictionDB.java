package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.udm.NudmSDM.common.model.AreaInformationDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AreaRestrictionDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class AreaRestrictionDB   {
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
  private AreaInformationDB areaInformation = null;

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

  public AreaRestrictionDB restrictionType(RestrictionTypeEnum restrictionType) {
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

  public AreaRestrictionDB areaInformation(AreaInformationDB areaInformation) {
    this.areaInformation = areaInformation;
    return this;
  }

  /**
   * Get areaInformation
   * @return areaInformation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AreaInformationDB getAreaInformation() {
    return areaInformation;
  }

  public void setAreaInformation(AreaInformationDB areaInformation) {
    this.areaInformation = areaInformation;
  }

  public AreaRestrictionDB ratType(List<RatTypeEnum> ratType) {
    this.ratType = ratType;
    return this;
  }

  public AreaRestrictionDB addRatTypeItem(RatTypeEnum ratTypeItem) {
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
    AreaRestrictionDB areaRestrictionDB = (AreaRestrictionDB) o;
    return Objects.equals(this.restrictionType, areaRestrictionDB.restrictionType) &&
        Objects.equals(this.areaInformation, areaRestrictionDB.areaInformation) &&
        Objects.equals(this.ratType, areaRestrictionDB.ratType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restrictionType, areaInformation, ratType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AreaRestrictionDB {\n");
    
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

