package com.nec.corestudy.amf.NamfUecmCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfUecmCLI.model.ImsVoPS;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Amf3GppAccessRegistrationModification
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:23.613+09:00")

public class Amf3GppAccessRegistrationModification   {
  @JsonProperty("purgeFlag")
  private Boolean purgeFlag = null;

  @JsonProperty("pei")
  private String pei = null;

  @JsonProperty("imsVoPS")
  private ImsVoPS imsVoPS = null;

  public Amf3GppAccessRegistrationModification purgeFlag(Boolean purgeFlag) {
    this.purgeFlag = purgeFlag;
    return this;
  }

  /**
   * Get purgeFlag
   * @return purgeFlag
  **/
  @ApiModelProperty(value = "")
  public Boolean getPurgeFlag() {
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

  public Amf3GppAccessRegistrationModification imsVoPS(ImsVoPS imsVoPS) {
    this.imsVoPS = imsVoPS;
    return this;
  }

  /**
   * Get imsVoPS
   * @return imsVoPS
  **/
  @ApiModelProperty(value = "")
  public ImsVoPS getImsVoPS() {
    return imsVoPS;
  }

  public void setImsVoPS(ImsVoPS imsVoPS) {
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

