package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.Ncgi;
import com.nec.corestudy.amf.NamfSmfCLI.model.Tai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NrLocation
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class NrLocation   {
  @JsonProperty("tai")
  private Tai tai = null;

  @JsonProperty("ncgi")
  private Ncgi ncgi = null;

  public NrLocation tai(Tai tai) {
    this.tai = tai;
    return this;
  }

  /**
   * Get tai
   * @return tai
  **/
  @ApiModelProperty(value = "")
  public Tai getTai() {
    return tai;
  }

  public void setTai(Tai tai) {
    this.tai = tai;
  }

  public NrLocation ncgi(Ncgi ncgi) {
    this.ncgi = ncgi;
    return this;
  }

  /**
   * Get ncgi
   * @return ncgi
  **/
  @ApiModelProperty(value = "")
  public Ncgi getNcgi() {
    return ncgi;
  }

  public void setNcgi(Ncgi ncgi) {
    this.ncgi = ncgi;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NrLocation nrLocation = (NrLocation) o;
    return Objects.equals(this.tai, nrLocation.tai) &&
        Objects.equals(this.ncgi, nrLocation.ncgi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tai, ncgi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NrLocation {\n");
    
    sb.append("    tai: ").append(toIndentedString(tai)).append("\n");
    sb.append("    ncgi: ").append(toIndentedString(ncgi)).append("\n");
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
