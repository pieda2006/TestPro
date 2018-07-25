package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFArp;
import com.nec.corestudy.amf.NamfCommunication.model.AMFSingleAssignedEbi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFAssignedEbiData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAssignedEbiData   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("assignedEbis")
  @Valid
  private List<AMFSingleAssignedEbi> assignedEbis = new ArrayList<AMFSingleAssignedEbi>();

  @JsonProperty("failedArpList")
  @Valid
  private List<AMFArp> failedArpList = null;

  @JsonProperty("releasedEbiList")
  @Valid
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
  @NotNull


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
  @NotNull

  @Valid

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

  @Valid

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

