package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFPlmnId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFTai
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFTai   {
  @JsonProperty("plmnId")
  private AMFPlmnId plmnId = null;

  @JsonProperty("tac")
  private String tac = null;

  public AMFTai plmnId(AMFPlmnId plmnId) {
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

  public AMFTai tac(String tac) {
    this.tac = tac;
    return this;
  }

  /**
   * Get tac
   * @return tac
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTac() {
    return tac;
  }

  public void setTac(String tac) {
    this.tac = tac;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFTai amFTai = (AMFTai) o;
    return Objects.equals(this.plmnId, amFTai.plmnId) &&
        Objects.equals(this.tac, amFTai.tac);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, tac);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFTai {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    tac: ").append(toIndentedString(tac)).append("\n");
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

