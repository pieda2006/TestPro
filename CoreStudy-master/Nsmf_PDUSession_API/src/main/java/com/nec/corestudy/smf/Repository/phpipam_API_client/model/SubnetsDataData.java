/*
 * phpipam API(for SMF)
 * phpipam API(for SMF)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Repository.phpipam_API_client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * SubnetsDataData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-12T13:25:06.537+09:00")
public class SubnetsDataData {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("subnet")
  private String subnet = null;

  @SerializedName("mask")
  private String mask = "0";

  @SerializedName("description")
  private String description = null;

  public SubnetsDataData id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SubnetsDataData subnet(String subnet) {
    this.subnet = subnet;
    return this;
  }

   /**
   * Get subnet
   * @return subnet
  **/
  @ApiModelProperty(required = true, value = "")
  public String getSubnet() {
    return subnet;
  }

  public void setSubnet(String subnet) {
    this.subnet = subnet;
  }

  public SubnetsDataData mask(String mask) {
    this.mask = mask;
    return this;
  }

   /**
   * Get mask
   * @return mask
  **/
  @ApiModelProperty(value = "")
  public String getMask() {
    return mask;
  }

  public void setMask(String mask) {
    this.mask = mask;
  }

  public SubnetsDataData description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubnetsDataData subnetsDataData = (SubnetsDataData) o;
    return Objects.equals(this.id, subnetsDataData.id) &&
        Objects.equals(this.subnet, subnetsDataData.subnet) &&
        Objects.equals(this.mask, subnetsDataData.mask) &&
        Objects.equals(this.description, subnetsDataData.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subnet, mask, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubnetsDataData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
    sb.append("    mask: ").append(toIndentedString(mask)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
