package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAreaOfValidity;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2SmInformation;
import com.nec.corestudy.amf.NamfCommunication.model.AMFNrppaInformation;
import com.nec.corestudy.amf.NamfCommunication.model.AMFPwsInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFN2InfoContainer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFN2InfoContainer   {
  /**
   * Gets or Sets n2InformationClass
   */
  public enum N2InformationClassEnum {
    SM("Jamf_SM"),
    
    NRPPA("Jamf_NRPPa");

    private String value;

    N2InformationClassEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static N2InformationClassEnum fromValue(String text) {
      for (N2InformationClassEnum b : N2InformationClassEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("n2InformationClass")
  private N2InformationClassEnum n2InformationClass = null;

  @JsonProperty("smInfo")
  @Valid
  private List<AMFN2SmInformation> smInfo = null;

  @JsonProperty("nrppaInfo")
  private AMFNrppaInformation nrppaInfo = null;

  @JsonProperty("pwsInfo")
  private AMFPwsInformation pwsInfo = null;

  @JsonProperty("areaOfValidity")
  private AMFAreaOfValidity areaOfValidity = null;

  public AMFN2InfoContainer n2InformationClass(N2InformationClassEnum n2InformationClass) {
    this.n2InformationClass = n2InformationClass;
    return this;
  }

  /**
   * Get n2InformationClass
   * @return n2InformationClass
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public N2InformationClassEnum getN2InformationClass() {
    return n2InformationClass;
  }

  public void setN2InformationClass(N2InformationClassEnum n2InformationClass) {
    this.n2InformationClass = n2InformationClass;
  }

  public AMFN2InfoContainer smInfo(List<AMFN2SmInformation> smInfo) {
    this.smInfo = smInfo;
    return this;
  }

  public AMFN2InfoContainer addSmInfoItem(AMFN2SmInformation smInfoItem) {
    if (this.smInfo == null) {
      this.smInfo = new ArrayList<AMFN2SmInformation>();
    }
    this.smInfo.add(smInfoItem);
    return this;
  }

  /**
   * Get smInfo
   * @return smInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFN2SmInformation> getSmInfo() {
    return smInfo;
  }

  public void setSmInfo(List<AMFN2SmInformation> smInfo) {
    this.smInfo = smInfo;
  }

  public AMFN2InfoContainer nrppaInfo(AMFNrppaInformation nrppaInfo) {
    this.nrppaInfo = nrppaInfo;
    return this;
  }

  /**
   * Get nrppaInfo
   * @return nrppaInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFNrppaInformation getNrppaInfo() {
    return nrppaInfo;
  }

  public void setNrppaInfo(AMFNrppaInformation nrppaInfo) {
    this.nrppaInfo = nrppaInfo;
  }

  public AMFN2InfoContainer pwsInfo(AMFPwsInformation pwsInfo) {
    this.pwsInfo = pwsInfo;
    return this;
  }

  /**
   * Get pwsInfo
   * @return pwsInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFPwsInformation getPwsInfo() {
    return pwsInfo;
  }

  public void setPwsInfo(AMFPwsInformation pwsInfo) {
    this.pwsInfo = pwsInfo;
  }

  public AMFN2InfoContainer areaOfValidity(AMFAreaOfValidity areaOfValidity) {
    this.areaOfValidity = areaOfValidity;
    return this;
  }

  /**
   * Get areaOfValidity
   * @return areaOfValidity
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFAreaOfValidity getAreaOfValidity() {
    return areaOfValidity;
  }

  public void setAreaOfValidity(AMFAreaOfValidity areaOfValidity) {
    this.areaOfValidity = areaOfValidity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN2InfoContainer amFN2InfoContainer = (AMFN2InfoContainer) o;
    return Objects.equals(this.n2InformationClass, amFN2InfoContainer.n2InformationClass) &&
        Objects.equals(this.smInfo, amFN2InfoContainer.smInfo) &&
        Objects.equals(this.nrppaInfo, amFN2InfoContainer.nrppaInfo) &&
        Objects.equals(this.pwsInfo, amFN2InfoContainer.pwsInfo) &&
        Objects.equals(this.areaOfValidity, amFN2InfoContainer.areaOfValidity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(n2InformationClass, smInfo, nrppaInfo, pwsInfo, areaOfValidity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN2InfoContainer {\n");
    
    sb.append("    n2InformationClass: ").append(toIndentedString(n2InformationClass)).append("\n");
    sb.append("    smInfo: ").append(toIndentedString(smInfo)).append("\n");
    sb.append("    nrppaInfo: ").append(toIndentedString(nrppaInfo)).append("\n");
    sb.append("    pwsInfo: ").append(toIndentedString(pwsInfo)).append("\n");
    sb.append("    areaOfValidity: ").append(toIndentedString(areaOfValidity)).append("\n");
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

