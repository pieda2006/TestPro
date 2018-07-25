package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFArp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFSingleAssignedEbi
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFSingleAssignedEbi   {
  @JsonProperty("arp")
  private AMFArp arp = null;

  @JsonProperty("ebi")
  private Integer ebi = null;

  public AMFSingleAssignedEbi arp(AMFArp arp) {
    this.arp = arp;
    return this;
  }

  /**
   * Get arp
   * @return arp
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFArp getArp() {
    return arp;
  }

  public void setArp(AMFArp arp) {
    this.arp = arp;
  }

  public AMFSingleAssignedEbi ebi(Integer ebi) {
    this.ebi = ebi;
    return this;
  }

  /**
   * Get ebi
   * @return ebi
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getEbi() {
    return ebi;
  }

  public void setEbi(Integer ebi) {
    this.ebi = ebi;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFSingleAssignedEbi amFSingleAssignedEbi = (AMFSingleAssignedEbi) o;
    return Objects.equals(this.arp, amFSingleAssignedEbi.arp) &&
        Objects.equals(this.ebi, amFSingleAssignedEbi.ebi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(arp, ebi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFSingleAssignedEbi {\n");
    
    sb.append("    arp: ").append(toIndentedString(arp)).append("\n");
    sb.append("    ebi: ").append(toIndentedString(ebi)).append("\n");
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

