/*
 * Namf_Communication API
 * This is a AMF Server API.   [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
 *
 * OpenAPI spec version: 1.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN2InfoContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * AMFNrppaInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:58:37.428+09:00")
public class AMFNrppaInformation {
  @SerializedName("routingId")
  private String routingId = null;

  @SerializedName("nrppaPdu")
  private AMFN2InfoContent nrppaPdu = null;

  public AMFNrppaInformation routingId(String routingId) {
    this.routingId = routingId;
    return this;
  }

   /**
   * FFS
   * @return routingId
  **/
  @ApiModelProperty(required = true, value = "FFS")
  public String getRoutingId() {
    return routingId;
  }

  public void setRoutingId(String routingId) {
    this.routingId = routingId;
  }

  public AMFNrppaInformation nrppaPdu(AMFN2InfoContent nrppaPdu) {
    this.nrppaPdu = nrppaPdu;
    return this;
  }

   /**
   * Get nrppaPdu
   * @return nrppaPdu
  **/
  @ApiModelProperty(required = true, value = "")
  public AMFN2InfoContent getNrppaPdu() {
    return nrppaPdu;
  }

  public void setNrppaPdu(AMFN2InfoContent nrppaPdu) {
    this.nrppaPdu = nrppaPdu;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFNrppaInformation amFNrppaInformation = (AMFNrppaInformation) o;
    return Objects.equals(this.routingId, amFNrppaInformation.routingId) &&
        Objects.equals(this.nrppaPdu, amFNrppaInformation.nrppaPdu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routingId, nrppaPdu);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFNrppaInformation {\n");
    
    sb.append("    routingId: ").append(toIndentedString(routingId)).append("\n");
    sb.append("    nrppaPdu: ").append(toIndentedString(nrppaPdu)).append("\n");
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
