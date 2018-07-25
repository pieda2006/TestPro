package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.PreemptionCapability;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.PreemptionVulnerability;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Arp
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class Arp   {
  @JsonProperty("priorityLevel")
  private Integer priorityLevel = null;

  @JsonProperty("preemptCap")
  private PreemptionCapability preemptCap = null;

  @JsonProperty("preemptVuln")
  private PreemptionVulnerability preemptVuln = null;

  public Arp priorityLevel(Integer priorityLevel) {
    this.priorityLevel = priorityLevel;
    return this;
  }

  /**
   * Get priorityLevel
   * @return priorityLevel
  **/
  @ApiModelProperty(value = "")


  public Integer getPriorityLevel() {
    return priorityLevel;
  }

  public void setPriorityLevel(Integer priorityLevel) {
    this.priorityLevel = priorityLevel;
  }

  public Arp preemptCap(PreemptionCapability preemptCap) {
    this.preemptCap = preemptCap;
    return this;
  }

  /**
   * Get preemptCap
   * @return preemptCap
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PreemptionCapability getPreemptCap() {
    return preemptCap;
  }

  public void setPreemptCap(PreemptionCapability preemptCap) {
    this.preemptCap = preemptCap;
  }

  public Arp preemptVuln(PreemptionVulnerability preemptVuln) {
    this.preemptVuln = preemptVuln;
    return this;
  }

  /**
   * Get preemptVuln
   * @return preemptVuln
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PreemptionVulnerability getPreemptVuln() {
    return preemptVuln;
  }

  public void setPreemptVuln(PreemptionVulnerability preemptVuln) {
    this.preemptVuln = preemptVuln;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Arp arp = (Arp) o;
    return Objects.equals(this.priorityLevel, arp.priorityLevel) &&
        Objects.equals(this.preemptCap, arp.preemptCap) &&
        Objects.equals(this.preemptVuln, arp.preemptVuln);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priorityLevel, preemptCap, preemptVuln);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Arp {\n");
    
    sb.append("    priorityLevel: ").append(toIndentedString(priorityLevel)).append("\n");
    sb.append("    preemptCap: ").append(toIndentedString(preemptCap)).append("\n");
    sb.append("    preemptVuln: ").append(toIndentedString(preemptVuln)).append("\n");
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

