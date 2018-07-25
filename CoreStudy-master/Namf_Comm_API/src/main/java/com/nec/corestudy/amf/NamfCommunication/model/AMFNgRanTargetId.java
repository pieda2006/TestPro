package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFPlmnId;
import com.nec.corestudy.amf.NamfCommunication.model.AMFTai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFNgRanTargetId
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFNgRanTargetId   {
  @JsonProperty("plmnId")
  private AMFPlmnId plmnId = null;

  @JsonProperty("ranNodeId")
  private String ranNodeId = null;

  @JsonProperty("tai")
  private AMFTai tai = null;

  public AMFNgRanTargetId plmnId(AMFPlmnId plmnId) {
    this.plmnId = plmnId;
    return this;
  }

  /**
   * Get plmnId
   * @return plmnId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFPlmnId getPlmnId() {
    return plmnId;
  }

  public void setPlmnId(AMFPlmnId plmnId) {
    this.plmnId = plmnId;
  }

  public AMFNgRanTargetId ranNodeId(String ranNodeId) {
    this.ranNodeId = ranNodeId;
    return this;
  }

  /**
   * Get ranNodeId
   * @return ranNodeId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRanNodeId() {
    return ranNodeId;
  }

  public void setRanNodeId(String ranNodeId) {
    this.ranNodeId = ranNodeId;
  }

  public AMFNgRanTargetId tai(AMFTai tai) {
    this.tai = tai;
    return this;
  }

  /**
   * Get tai
   * @return tai
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFTai getTai() {
    return tai;
  }

  public void setTai(AMFTai tai) {
    this.tai = tai;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFNgRanTargetId amFNgRanTargetId = (AMFNgRanTargetId) o;
    return Objects.equals(this.plmnId, amFNgRanTargetId.plmnId) &&
        Objects.equals(this.ranNodeId, amFNgRanTargetId.ranNodeId) &&
        Objects.equals(this.tai, amFNgRanTargetId.tai);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, ranNodeId, tai);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFNgRanTargetId {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    ranNodeId: ").append(toIndentedString(ranNodeId)).append("\n");
    sb.append("    tai: ").append(toIndentedString(tai)).append("\n");
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

