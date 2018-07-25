package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AreaInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class AreaInformation   {
  @JsonProperty("tac")
  @Valid
  private List<String> tac = null;

  @JsonProperty("areaCode")
  @Valid
  private List<String> areaCode = null;

  @JsonProperty("maxNumberTAs")
  @Valid
  private List<Integer> maxNumberTAs = null;

  public AreaInformation tac(List<String> tac) {
    this.tac = tac;
    return this;
  }

  public AreaInformation addTacItem(String tacItem) {
    if (this.tac == null) {
      this.tac = new ArrayList<String>();
    }
    this.tac.add(tacItem);
    return this;
  }

  /**
   * Get tac
   * @return tac
  **/
  @ApiModelProperty(value = "")


  public List<String> getTac() {
    return tac;
  }

  public void setTac(List<String> tac) {
    this.tac = tac;
  }

  public AreaInformation areaCode(List<String> areaCode) {
    this.areaCode = areaCode;
    return this;
  }

  public AreaInformation addAreaCodeItem(String areaCodeItem) {
    if (this.areaCode == null) {
      this.areaCode = new ArrayList<String>();
    }
    this.areaCode.add(areaCodeItem);
    return this;
  }

  /**
   * Get areaCode
   * @return areaCode
  **/
  @ApiModelProperty(value = "")


  public List<String> getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(List<String> areaCode) {
    this.areaCode = areaCode;
  }

  public AreaInformation maxNumberTAs(List<Integer> maxNumberTAs) {
    this.maxNumberTAs = maxNumberTAs;
    return this;
  }

  public AreaInformation addMaxNumberTAsItem(Integer maxNumberTAsItem) {
    if (this.maxNumberTAs == null) {
      this.maxNumberTAs = new ArrayList<Integer>();
    }
    this.maxNumberTAs.add(maxNumberTAsItem);
    return this;
  }

  /**
   * Get maxNumberTAs
   * @return maxNumberTAs
  **/
  @ApiModelProperty(value = "")


  public List<Integer> getMaxNumberTAs() {
    return maxNumberTAs;
  }

  public void setMaxNumberTAs(List<Integer> maxNumberTAs) {
    this.maxNumberTAs = maxNumberTAs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AreaInformation areaInformation = (AreaInformation) o;
    return Objects.equals(this.tac, areaInformation.tac) &&
        Objects.equals(this.areaCode, areaInformation.areaCode) &&
        Objects.equals(this.maxNumberTAs, areaInformation.maxNumberTAs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tac, areaCode, maxNumberTAs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AreaInformation {\n");
    
    sb.append("    tac: ").append(toIndentedString(tac)).append("\n");
    sb.append("    areaCode: ").append(toIndentedString(areaCode)).append("\n");
    sb.append("    maxNumberTAs: ").append(toIndentedString(maxNumberTAs)).append("\n");
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

