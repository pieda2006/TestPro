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
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFArp;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFSingleAssignedEbi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AMFAssignedEbiData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:58:37.428+09:00")
public class AMFAssignedEbiData {
  @SerializedName("pduSessionId")
  private Integer pduSessionId = null;

  @SerializedName("assignedEbis")
  private List<AMFSingleAssignedEbi> assignedEbis = new ArrayList<AMFSingleAssignedEbi>();

  @SerializedName("failedArpList")
  private List<AMFArp> failedArpList = null;

  @SerializedName("releasedEbiList")
  private List<Integer> releasedEbiList = null;

  public AMFAssignedEbiData pduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
    return this;
  }

   /**
   * Get pduSessionId
   * @return pduSessionId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPduSessionId() {
    return pduSessionId;
  }

  public void setPduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
  }

  public AMFAssignedEbiData assignedEbis(List<AMFSingleAssignedEbi> assignedEbis) {
    this.assignedEbis = assignedEbis;
    return this;
  }

  public AMFAssignedEbiData addAssignedEbisItem(AMFSingleAssignedEbi assignedEbisItem) {
    this.assignedEbis.add(assignedEbisItem);
    return this;
  }

   /**
   * Get assignedEbis
   * @return assignedEbis
  **/
  @ApiModelProperty(required = true, value = "")
  public List<AMFSingleAssignedEbi> getAssignedEbis() {
    return assignedEbis;
  }

  public void setAssignedEbis(List<AMFSingleAssignedEbi> assignedEbis) {
    this.assignedEbis = assignedEbis;
  }

  public AMFAssignedEbiData failedArpList(List<AMFArp> failedArpList) {
    this.failedArpList = failedArpList;
    return this;
  }

  public AMFAssignedEbiData addFailedArpListItem(AMFArp failedArpListItem) {
    if (this.failedArpList == null) {
      this.failedArpList = new ArrayList<AMFArp>();
    }
    this.failedArpList.add(failedArpListItem);
    return this;
  }

   /**
   * Get failedArpList
   * @return failedArpList
  **/
  @ApiModelProperty(value = "")
  public List<AMFArp> getFailedArpList() {
    return failedArpList;
  }

  public void setFailedArpList(List<AMFArp> failedArpList) {
    this.failedArpList = failedArpList;
  }

  public AMFAssignedEbiData releasedEbiList(List<Integer> releasedEbiList) {
    this.releasedEbiList = releasedEbiList;
    return this;
  }

  public AMFAssignedEbiData addReleasedEbiListItem(Integer releasedEbiListItem) {
    if (this.releasedEbiList == null) {
      this.releasedEbiList = new ArrayList<Integer>();
    }
    this.releasedEbiList.add(releasedEbiListItem);
    return this;
  }

   /**
   * Get releasedEbiList
   * @return releasedEbiList
  **/
  @ApiModelProperty(value = "")
  public List<Integer> getReleasedEbiList() {
    return releasedEbiList;
  }

  public void setReleasedEbiList(List<Integer> releasedEbiList) {
    this.releasedEbiList = releasedEbiList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAssignedEbiData amFAssignedEbiData = (AMFAssignedEbiData) o;
    return Objects.equals(this.pduSessionId, amFAssignedEbiData.pduSessionId) &&
        Objects.equals(this.assignedEbis, amFAssignedEbiData.assignedEbis) &&
        Objects.equals(this.failedArpList, amFAssignedEbiData.failedArpList) &&
        Objects.equals(this.releasedEbiList, amFAssignedEbiData.releasedEbiList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, assignedEbis, failedArpList, releasedEbiList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAssignedEbiData {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    assignedEbis: ").append(toIndentedString(assignedEbis)).append("\n");
    sb.append("    failedArpList: ").append(toIndentedString(failedArpList)).append("\n");
    sb.append("    releasedEbiList: ").append(toIndentedString(releasedEbiList)).append("\n");
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
