package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ArpDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class ArpDB   {
  @JsonProperty("priorityLevel")
  private Integer priorityLevel = null;

  /**
   * Gets or Sets preemptCap
   */
  public enum PreemptCapEnum {
    NOT_PREEMPT("NOT_PREEMPT"),
    
    MAY_PREEMPT("MAY_PREEMPT");

    private String value;

    PreemptCapEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PreemptCapEnum fromValue(String text) {
      for (PreemptCapEnum b : PreemptCapEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("preemptCap")
  private PreemptCapEnum preemptCap = null;

  /**
   * Gets or Sets preemptVuln
   */
  public enum PreemptVulnEnum {
    NOT_PREEMPTABLE("NOT_PREEMPTABLE"),
    
    PREEMPTABLE("PREEMPTABLE");

    private String value;

    PreemptVulnEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PreemptVulnEnum fromValue(String text) {
      for (PreemptVulnEnum b : PreemptVulnEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("preemptVuln")
  private PreemptVulnEnum preemptVuln = null;

  public ArpDB priorityLevel(Integer priorityLevel) {
    this.priorityLevel = priorityLevel;
    return this;
  }

  /**
   * Get priorityLevel
   * @return priorityLevel
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getPriorityLevel() {
    return priorityLevel;
  }

  public void setPriorityLevel(Integer priorityLevel) {
    this.priorityLevel = priorityLevel;
  }

  public ArpDB preemptCap(PreemptCapEnum preemptCap) {
    this.preemptCap = preemptCap;
    return this;
  }

  /**
   * Get preemptCap
   * @return preemptCap
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public PreemptCapEnum getPreemptCap() {
    return preemptCap;
  }

  public void setPreemptCap(PreemptCapEnum preemptCap) {
    this.preemptCap = preemptCap;
  }

  public ArpDB preemptVuln(PreemptVulnEnum preemptVuln) {
    this.preemptVuln = preemptVuln;
    return this;
  }

  /**
   * Get preemptVuln
   * @return preemptVuln
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public PreemptVulnEnum getPreemptVuln() {
    return preemptVuln;
  }

  public void setPreemptVuln(PreemptVulnEnum preemptVuln) {
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
    ArpDB arpDB = (ArpDB) o;
    return Objects.equals(this.priorityLevel, arpDB.priorityLevel) &&
        Objects.equals(this.preemptCap, arpDB.preemptCap) &&
        Objects.equals(this.preemptVuln, arpDB.preemptVuln);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priorityLevel, preemptCap, preemptVuln);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArpDB {\n");
    
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

