package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.AverWindow;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.MaxDataBurstVol;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NonDynamic5qi
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class NonDynamic5qi   {
  @JsonProperty("priorityLevel")
  private Integer priorityLevel = null;

  @JsonProperty("averWindow")
  private AverWindow averWindow = null;

  @JsonProperty("maxDataBurstVol")
  private MaxDataBurstVol maxDataBurstVol = null;

  public NonDynamic5qi priorityLevel(Integer priorityLevel) {
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

  public NonDynamic5qi averWindow(AverWindow averWindow) {
    this.averWindow = averWindow;
    return this;
  }

  /**
   * Get averWindow
   * @return averWindow
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AverWindow getAverWindow() {
    return averWindow;
  }

  public void setAverWindow(AverWindow averWindow) {
    this.averWindow = averWindow;
  }

  public NonDynamic5qi maxDataBurstVol(MaxDataBurstVol maxDataBurstVol) {
    this.maxDataBurstVol = maxDataBurstVol;
    return this;
  }

  /**
   * Get maxDataBurstVol
   * @return maxDataBurstVol
  **/
  @ApiModelProperty(value = "")

  @Valid

  public MaxDataBurstVol getMaxDataBurstVol() {
    return maxDataBurstVol;
  }

  public void setMaxDataBurstVol(MaxDataBurstVol maxDataBurstVol) {
    this.maxDataBurstVol = maxDataBurstVol;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonDynamic5qi nonDynamic5qi = (NonDynamic5qi) o;
    return Objects.equals(this.priorityLevel, nonDynamic5qi.priorityLevel) &&
        Objects.equals(this.averWindow, nonDynamic5qi.averWindow) &&
        Objects.equals(this.maxDataBurstVol, nonDynamic5qi.maxDataBurstVol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priorityLevel, averWindow, maxDataBurstVol);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NonDynamic5qi {\n");
    
    sb.append("    priorityLevel: ").append(toIndentedString(priorityLevel)).append("\n");
    sb.append("    averWindow: ").append(toIndentedString(averWindow)).append("\n");
    sb.append("    maxDataBurstVol: ").append(toIndentedString(maxDataBurstVol)).append("\n");
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

