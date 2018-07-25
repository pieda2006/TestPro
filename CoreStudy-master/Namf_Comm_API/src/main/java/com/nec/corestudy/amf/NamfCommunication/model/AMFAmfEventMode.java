package com.nec.corestudy.amf.NamfCommunication.model;

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
 * AMFAmfEventMode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAmfEventMode   {
  /**
   * Gets or Sets trigger
   */
  public enum TriggerEnum {
    ONE_TIME("Jamf_ONE_TIME"),
    
    CONTINUOUS("Jamf_CONTINUOUS");

    private String value;

    TriggerEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TriggerEnum fromValue(String text) {
      for (TriggerEnum b : TriggerEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("trigger")
  private TriggerEnum trigger = null;

  @JsonProperty("maxReports")
  private Integer maxReports = null;

  @JsonProperty("duration")
  private Integer duration = null;

  public AMFAmfEventMode trigger(TriggerEnum trigger) {
    this.trigger = trigger;
    return this;
  }

  /**
   * Get trigger
   * @return trigger
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public TriggerEnum getTrigger() {
    return trigger;
  }

  public void setTrigger(TriggerEnum trigger) {
    this.trigger = trigger;
  }

  public AMFAmfEventMode maxReports(Integer maxReports) {
    this.maxReports = maxReports;
    return this;
  }

  /**
   * Get maxReports
   * @return maxReports
  **/
  @ApiModelProperty(value = "")


  public Integer getMaxReports() {
    return maxReports;
  }

  public void setMaxReports(Integer maxReports) {
    this.maxReports = maxReports;
  }

  public AMFAmfEventMode duration(Integer duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
  **/
  @ApiModelProperty(value = "")


  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAmfEventMode amFAmfEventMode = (AMFAmfEventMode) o;
    return Objects.equals(this.trigger, amFAmfEventMode.trigger) &&
        Objects.equals(this.maxReports, amFAmfEventMode.maxReports) &&
        Objects.equals(this.duration, amFAmfEventMode.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trigger, maxReports, duration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAmfEventMode {\n");
    
    sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
    sb.append("    maxReports: ").append(toIndentedString(maxReports)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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

