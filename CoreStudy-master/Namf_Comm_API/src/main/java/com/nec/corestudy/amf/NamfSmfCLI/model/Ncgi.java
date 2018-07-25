package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.PlmnId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Ncgi
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class Ncgi   {
  @JsonProperty("plmnId")
  private PlmnId plmnId = null;

  @JsonProperty("nrCellId")
  private String nrCellId = null;

  public Ncgi plmnId(PlmnId plmnId) {
    this.plmnId = plmnId;
    return this;
  }

  /**
   * Get plmnId
   * @return plmnId
  **/
  @ApiModelProperty(value = "")
  public PlmnId getPlmnId() {
    return plmnId;
  }

  public void setPlmnId(PlmnId plmnId) {
    this.plmnId = plmnId;
  }

  public Ncgi nrCellId(String nrCellId) {
    this.nrCellId = nrCellId;
    return this;
  }

  /**
   * Get nrCellId
   * @return nrCellId
  **/
  @ApiModelProperty(value = "")
  public String getNrCellId() {
    return nrCellId;
  }

  public void setNrCellId(String nrCellId) {
    this.nrCellId = nrCellId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ncgi ncgi = (Ncgi) o;
    return Objects.equals(this.plmnId, ncgi.plmnId) &&
        Objects.equals(this.nrCellId, ncgi.nrCellId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, nrCellId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ncgi {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    nrCellId: ").append(toIndentedString(nrCellId)).append("\n");
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

