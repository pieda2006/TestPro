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
 * AMFAssignEbiData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAssignEbiData   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("arps")
  @Valid
  private List<AMFArp> arps = null;

  @JsonProperty("releasedEbiList")
  @Valid
  private List<Integer> releasedEbiList = null;

  public AMFAssignEbiData pduSessionId(Integer pduSessionId) {
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

  public AMFAssignEbiData arps(List<AMFArp> arps) {
    this.arps = arps;
    return this;
  }

  public AMFAssignEbiData addArpsItem(AMFArp arpsItem) {
    if (this.arps == null) {
      this.arps = new ArrayList<AMFArp>();
    }
    this.arps.add(arpsItem);
    return this;
  }

  /**
   * Get arps
   * @return arps
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFArp> getArps() {
    return arps;
  }

  public void setArps(List<AMFArp> arps) {
    this.arps = arps;
  }

  public AMFAssignEbiData releasedEbiList(List<Integer> releasedEbiList) {
    this.releasedEbiList = releasedEbiList;
    return this;
  }

  public AMFAssignEbiData addReleasedEbiListItem(Integer releasedEbiListItem) {
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
    AMFAssignEbiData amFAssignEbiData = (AMFAssignEbiData) o;
    return Objects.equals(this.pduSessionId, amFAssignEbiData.pduSessionId) &&
        Objects.equals(this.arps, amFAssignEbiData.arps) &&
        Objects.equals(this.releasedEbiList, amFAssignEbiData.releasedEbiList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, arps, releasedEbiList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAssignEbiData {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    arps: ").append(toIndentedString(arps)).append("\n");
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

