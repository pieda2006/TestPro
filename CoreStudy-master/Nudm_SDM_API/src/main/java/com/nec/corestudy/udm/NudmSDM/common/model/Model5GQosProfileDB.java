package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.ArpDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Model5GQosProfileDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class Model5GQosProfileDB   {
  @JsonProperty("5qi")
  private Integer _5qi = null;

  @JsonProperty("arp")
  private ArpDB arp = null;

  public Model5GQosProfileDB _5qi(Integer _5qi) {
    this._5qi = _5qi;
    return this;
  }

  /**
   * Get _5qi
   * @return _5qi
  **/
  @ApiModelProperty(value = "")


  public Integer get5qi() {
    return _5qi;
  }

  public void set5qi(Integer _5qi) {
    this._5qi = _5qi;
  }

  public Model5GQosProfileDB arp(ArpDB arp) {
    this.arp = arp;
    return this;
  }

  /**
   * Get arp
   * @return arp
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ArpDB getArp() {
    return arp;
  }

  public void setArp(ArpDB arp) {
    this.arp = arp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Model5GQosProfileDB _5gQosProfileDB = (Model5GQosProfileDB) o;
    return Objects.equals(this._5qi, _5gQosProfileDB._5qi) &&
        Objects.equals(this.arp, _5gQosProfileDB.arp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_5qi, arp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Model5GQosProfileDB {\n");
    
    sb.append("    _5qi: ").append(toIndentedString(_5qi)).append("\n");
    sb.append("    arp: ").append(toIndentedString(arp)).append("\n");
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

