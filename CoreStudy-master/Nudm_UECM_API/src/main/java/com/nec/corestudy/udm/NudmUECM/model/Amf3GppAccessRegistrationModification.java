package com.nec.corestudy.udm.NudmUECM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Amf3GppAccessRegistrationModification
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T20:24:10.908+09:00")

public class Amf3GppAccessRegistrationModification   {
  @JsonProperty("purgeFlag")
  private Boolean purgeFlag = null;

  @JsonProperty("pei")
  private String pei = null;

  /**
   * Gets or Sets imsVoPS
   */
  public enum ImsVoPSEnum {
    HOMOGENEOUS_SUPPORT("HOMOGENEOUS_SUPPORT"),
    
    HOMOGENEOUS_NON_SUPPORT("HOMOGENEOUS_NON_SUPPORT"),
    
    NON_HOMOGENEOUS_OR_UNKNOWN("NON_HOMOGENEOUS_OR_UNKNOWN");

    private String value;

    ImsVoPSEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ImsVoPSEnum fromValue(String text) {
      for (ImsVoPSEnum b : ImsVoPSEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("imsVoPS")
  private ImsVoPSEnum imsVoPS = null;

  public Amf3GppAccessRegistrationModification purgeFlag(Boolean purgeFlag) {
    this.purgeFlag = purgeFlag;
    return this;
  }

  /**
   * Get purgeFlag
   * @return purgeFlag
  **/
  @ApiModelProperty(value = "")


  public Boolean isPurgeFlag() {
    return purgeFlag;
  }

  public void setPurgeFlag(Boolean purgeFlag) {
    this.purgeFlag = purgeFlag;
  }

  public Amf3GppAccessRegistrationModification pei(String pei) {
    this.pei = pei;
    return this;
  }

  /**
   * Get pei
   * @return pei
  **/
  @ApiModelProperty(value = "")


  public String getPei() {
    return pei;
  }

  public void setPei(String pei) {
    this.pei = pei;
  }

  public Amf3GppAccessRegistrationModification imsVoPS(ImsVoPSEnum imsVoPS) {
    this.imsVoPS = imsVoPS;
    return this;
  }

  /**
   * Get imsVoPS
   * @return imsVoPS
  **/
  @ApiModelProperty(value = "")


  public ImsVoPSEnum getImsVoPS() {
    return imsVoPS;
  }

  public void setImsVoPS(ImsVoPSEnum imsVoPS) {
    this.imsVoPS = imsVoPS;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amf3GppAccessRegistrationModification amf3GppAccessRegistrationModification = (Amf3GppAccessRegistrationModification) o;
    return Objects.equals(this.purgeFlag, amf3GppAccessRegistrationModification.purgeFlag) &&
        Objects.equals(this.pei, amf3GppAccessRegistrationModification.pei) &&
        Objects.equals(this.imsVoPS, amf3GppAccessRegistrationModification.imsVoPS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purgeFlag, pei, imsVoPS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Amf3GppAccessRegistrationModification {\n");
    
    sb.append("    purgeFlag: ").append(toIndentedString(purgeFlag)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
    sb.append("    imsVoPS: ").append(toIndentedString(imsVoPS)).append("\n");
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

