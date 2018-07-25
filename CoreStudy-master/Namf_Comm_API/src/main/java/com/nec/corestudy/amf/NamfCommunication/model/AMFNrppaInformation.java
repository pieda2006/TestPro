package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2InfoContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFNrppaInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFNrppaInformation   {
  @JsonProperty("routingId")
  private String routingId = null;

  @JsonProperty("nrppaPdu")
  private AMFN2InfoContent nrppaPdu = null;

  public AMFNrppaInformation routingId(String routingId) {
    this.routingId = routingId;
    return this;
  }

  /**
   * FFS
   * @return routingId
  **/
  @ApiModelProperty(required = true, value = "FFS")
  @NotNull


  public String getRoutingId() {
    return routingId;
  }

  public void setRoutingId(String routingId) {
    this.routingId = routingId;
  }

  public AMFNrppaInformation nrppaPdu(AMFN2InfoContent nrppaPdu) {
    this.nrppaPdu = nrppaPdu;
    return this;
  }

  /**
   * Get nrppaPdu
   * @return nrppaPdu
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFN2InfoContent getNrppaPdu() {
    return nrppaPdu;
  }

  public void setNrppaPdu(AMFN2InfoContent nrppaPdu) {
    this.nrppaPdu = nrppaPdu;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFNrppaInformation amFNrppaInformation = (AMFNrppaInformation) o;
    return Objects.equals(this.routingId, amFNrppaInformation.routingId) &&
        Objects.equals(this.nrppaPdu, amFNrppaInformation.nrppaPdu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routingId, nrppaPdu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFNrppaInformation {\n");
    
    sb.append("    routingId: ").append(toIndentedString(routingId)).append("\n");
    sb.append("    nrppaPdu: ").append(toIndentedString(nrppaPdu)).append("\n");
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

