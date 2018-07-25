package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFArp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFAssignEbiFailed
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAssignEbiFailed   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("ailedArpList")
  @Valid
  private List<AMFArp> ailedArpList = null;

  public AMFAssignEbiFailed pduSessionId(Integer pduSessionId) {
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

  public AMFAssignEbiFailed ailedArpList(List<AMFArp> ailedArpList) {
    this.ailedArpList = ailedArpList;
    return this;
  }

  public AMFAssignEbiFailed addAiledArpListItem(AMFArp ailedArpListItem) {
    if (this.ailedArpList == null) {
      this.ailedArpList = new ArrayList<AMFArp>();
    }
    this.ailedArpList.add(ailedArpListItem);
    return this;
  }

  /**
   * Get ailedArpList
   * @return ailedArpList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFArp> getAiledArpList() {
    return ailedArpList;
  }

  public void setAiledArpList(List<AMFArp> ailedArpList) {
    this.ailedArpList = ailedArpList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAssignEbiFailed amFAssignEbiFailed = (AMFAssignEbiFailed) o;
    return Objects.equals(this.pduSessionId, amFAssignEbiFailed.pduSessionId) &&
        Objects.equals(this.ailedArpList, amFAssignEbiFailed.ailedArpList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, ailedArpList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAssignEbiFailed {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    ailedArpList: ").append(toIndentedString(ailedArpList)).append("\n");
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

