/*
 * Nudm_SDM API
 * This is a UDM Server API.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * OpenAPI spec version: 0.6.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AreaInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-21T18:27:13.711+09:00")
public class AreaInformation {
  @SerializedName("tac")
  private List<String> tac = null;

  @SerializedName("areaCode")
  private List<String> areaCode = null;

  @SerializedName("maxNumberTAs")
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
