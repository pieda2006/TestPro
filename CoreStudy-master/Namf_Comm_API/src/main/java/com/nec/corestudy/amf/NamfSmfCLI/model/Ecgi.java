package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSmfCLI.model.PlmnId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Ecgi
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class Ecgi   {
  @JsonProperty("plmnId")
  private PlmnId plmnId = null;

  @JsonProperty("eutraCellId")
  private String eutraCellId = null;

  public Ecgi plmnId(PlmnId plmnId) {
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

  public Ecgi eutraCellId(String eutraCellId) {
    this.eutraCellId = eutraCellId;
    return this;
  }

  /**
   * Get eutraCellId
   * @return eutraCellId
  **/
  @ApiModelProperty(value = "")
  public String getEutraCellId() {
    return eutraCellId;
  }

  public void setEutraCellId(String eutraCellId) {
    this.eutraCellId = eutraCellId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ecgi ecgi = (Ecgi) o;
    return Objects.equals(this.plmnId, ecgi.plmnId) &&
        Objects.equals(this.eutraCellId, ecgi.eutraCellId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plmnId, eutraCellId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ecgi {\n");
    
    sb.append("    plmnId: ").append(toIndentedString(plmnId)).append("\n");
    sb.append("    eutraCellId: ").append(toIndentedString(eutraCellId)).append("\n");
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
