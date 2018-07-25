package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.AverWindow;
import com.nec.corestudy.amf.NamfSmfCLI.model.DelayCritical;
import com.nec.corestudy.amf.NamfSmfCLI.model.MaxDataBurstVol;
import com.nec.corestudy.amf.NamfSmfCLI.model.PacketDelBudget;
import com.nec.corestudy.amf.NamfSmfCLI.model.PacketErrRate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dynamic5qi
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class Dynamic5qi   {
  @JsonProperty("priorityLevel")
  private Integer priorityLevel = null;

  @JsonProperty("packetDelBudget")
  private PacketDelBudget packetDelBudget = null;

  @JsonProperty("packetErrRate")
  private PacketErrRate packetErrRate = null;

  @JsonProperty("delayCritical")
  private DelayCritical delayCritical = null;

  @JsonProperty("averWindow")
  private AverWindow averWindow = null;

  @JsonProperty("maxDataBurstVol")
  private MaxDataBurstVol maxDataBurstVol = null;

  public Dynamic5qi priorityLevel(Integer priorityLevel) {
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

  public Dynamic5qi packetDelBudget(PacketDelBudget packetDelBudget) {
    this.packetDelBudget = packetDelBudget;
    return this;
  }

  /**
   * Get packetDelBudget
   * @return packetDelBudget
  **/
  @ApiModelProperty(value = "")
  public PacketDelBudget getPacketDelBudget() {
    return packetDelBudget;
  }

  public void setPacketDelBudget(PacketDelBudget packetDelBudget) {
    this.packetDelBudget = packetDelBudget;
  }

  public Dynamic5qi packetErrRate(PacketErrRate packetErrRate) {
    this.packetErrRate = packetErrRate;
    return this;
  }

  /**
   * Get packetErrRate
   * @return packetErrRate
  **/
  @ApiModelProperty(value = "")
  public PacketErrRate getPacketErrRate() {
    return packetErrRate;
  }

  public void setPacketErrRate(PacketErrRate packetErrRate) {
    this.packetErrRate = packetErrRate;
  }

  public Dynamic5qi delayCritical(DelayCritical delayCritical) {
    this.delayCritical = delayCritical;
    return this;
  }

  /**
   * Get delayCritical
   * @return delayCritical
  **/
  @ApiModelProperty(value = "")
  public DelayCritical getDelayCritical() {
    return delayCritical;
  }

  public void setDelayCritical(DelayCritical delayCritical) {
    this.delayCritical = delayCritical;
  }

  public Dynamic5qi averWindow(AverWindow averWindow) {
    this.averWindow = averWindow;
    return this;
  }

  /**
   * Get averWindow
   * @return averWindow
  **/
  @ApiModelProperty(value = "")
  public AverWindow getAverWindow() {
    return averWindow;
  }

  public void setAverWindow(AverWindow averWindow) {
    this.averWindow = averWindow;
  }

  public Dynamic5qi maxDataBurstVol(MaxDataBurstVol maxDataBurstVol) {
    this.maxDataBurstVol = maxDataBurstVol;
    return this;
  }

  /**
   * Get maxDataBurstVol
   * @return maxDataBurstVol
  **/
  @ApiModelProperty(value = "")
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
    Dynamic5qi dynamic5qi = (Dynamic5qi) o;
    return Objects.equals(this.priorityLevel, dynamic5qi.priorityLevel) &&
        Objects.equals(this.packetDelBudget, dynamic5qi.packetDelBudget) &&
        Objects.equals(this.packetErrRate, dynamic5qi.packetErrRate) &&
        Objects.equals(this.delayCritical, dynamic5qi.delayCritical) &&
        Objects.equals(this.averWindow, dynamic5qi.averWindow) &&
        Objects.equals(this.maxDataBurstVol, dynamic5qi.maxDataBurstVol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priorityLevel, packetDelBudget, packetErrRate, delayCritical, averWindow, maxDataBurstVol);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dynamic5qi {\n");
    
    sb.append("    priorityLevel: ").append(toIndentedString(priorityLevel)).append("\n");
    sb.append("    packetDelBudget: ").append(toIndentedString(packetDelBudget)).append("\n");
    sb.append("    packetErrRate: ").append(toIndentedString(packetErrRate)).append("\n");
    sb.append("    delayCritical: ").append(toIndentedString(delayCritical)).append("\n");
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

