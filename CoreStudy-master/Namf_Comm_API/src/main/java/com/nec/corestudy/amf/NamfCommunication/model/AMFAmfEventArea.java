package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFEcgi;
import com.nec.corestudy.amf.NamfCommunication.model.AMFNcgi;
import com.nec.corestudy.amf.NamfCommunication.model.AMFTai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFAmfEventArea
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAmfEventArea   {
  @JsonProperty("trackingAreas")
  private AMFTai trackingAreas = null;

  @JsonProperty("areaId")
  private String areaId = null;

  @JsonProperty("ladn")
  private String ladn = null;

  @JsonProperty("ecgi")
  @Valid
  private List<AMFEcgi> ecgi = null;

  @JsonProperty("ncgi")
  @Valid
  private List<AMFNcgi> ncgi = null;

  @JsonProperty("ngRanId")
  @Valid
  private List<String> ngRanId = null;

  public AMFAmfEventArea trackingAreas(AMFTai trackingAreas) {
    this.trackingAreas = trackingAreas;
    return this;
  }

  /**
   * Get trackingAreas
   * @return trackingAreas
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFTai getTrackingAreas() {
    return trackingAreas;
  }

  public void setTrackingAreas(AMFTai trackingAreas) {
    this.trackingAreas = trackingAreas;
  }

  public AMFAmfEventArea areaId(String areaId) {
    this.areaId = areaId;
    return this;
  }

  /**
   * Get areaId
   * @return areaId
  **/
  @ApiModelProperty(value = "")


  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }

  public AMFAmfEventArea ladn(String ladn) {
    this.ladn = ladn;
    return this;
  }

  /**
   * Get ladn
   * @return ladn
  **/
  @ApiModelProperty(value = "")


  public String getLadn() {
    return ladn;
  }

  public void setLadn(String ladn) {
    this.ladn = ladn;
  }

  public AMFAmfEventArea ecgi(List<AMFEcgi> ecgi) {
    this.ecgi = ecgi;
    return this;
  }

  public AMFAmfEventArea addEcgiItem(AMFEcgi ecgiItem) {
    if (this.ecgi == null) {
      this.ecgi = new ArrayList<AMFEcgi>();
    }
    this.ecgi.add(ecgiItem);
    return this;
  }

  /**
   * Get ecgi
   * @return ecgi
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFEcgi> getEcgi() {
    return ecgi;
  }

  public void setEcgi(List<AMFEcgi> ecgi) {
    this.ecgi = ecgi;
  }

  public AMFAmfEventArea ncgi(List<AMFNcgi> ncgi) {
    this.ncgi = ncgi;
    return this;
  }

  public AMFAmfEventArea addNcgiItem(AMFNcgi ncgiItem) {
    if (this.ncgi == null) {
      this.ncgi = new ArrayList<AMFNcgi>();
    }
    this.ncgi.add(ncgiItem);
    return this;
  }

  /**
   * Get ncgi
   * @return ncgi
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFNcgi> getNcgi() {
    return ncgi;
  }

  public void setNcgi(List<AMFNcgi> ncgi) {
    this.ncgi = ncgi;
  }

  public AMFAmfEventArea ngRanId(List<String> ngRanId) {
    this.ngRanId = ngRanId;
    return this;
  }

  public AMFAmfEventArea addNgRanIdItem(String ngRanIdItem) {
    if (this.ngRanId == null) {
      this.ngRanId = new ArrayList<String>();
    }
    this.ngRanId.add(ngRanIdItem);
    return this;
  }

  /**
   * Get ngRanId
   * @return ngRanId
  **/
  @ApiModelProperty(value = "")


  public List<String> getNgRanId() {
    return ngRanId;
  }

  public void setNgRanId(List<String> ngRanId) {
    this.ngRanId = ngRanId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAmfEventArea amFAmfEventArea = (AMFAmfEventArea) o;
    return Objects.equals(this.trackingAreas, amFAmfEventArea.trackingAreas) &&
        Objects.equals(this.areaId, amFAmfEventArea.areaId) &&
        Objects.equals(this.ladn, amFAmfEventArea.ladn) &&
        Objects.equals(this.ecgi, amFAmfEventArea.ecgi) &&
        Objects.equals(this.ncgi, amFAmfEventArea.ncgi) &&
        Objects.equals(this.ngRanId, amFAmfEventArea.ngRanId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trackingAreas, areaId, ladn, ecgi, ncgi, ngRanId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAmfEventArea {\n");
    
    sb.append("    trackingAreas: ").append(toIndentedString(trackingAreas)).append("\n");
    sb.append("    areaId: ").append(toIndentedString(areaId)).append("\n");
    sb.append("    ladn: ").append(toIndentedString(ladn)).append("\n");
    sb.append("    ecgi: ").append(toIndentedString(ecgi)).append("\n");
    sb.append("    ncgi: ").append(toIndentedString(ncgi)).append("\n");
    sb.append("    ngRanId: ").append(toIndentedString(ngRanId)).append("\n");
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

