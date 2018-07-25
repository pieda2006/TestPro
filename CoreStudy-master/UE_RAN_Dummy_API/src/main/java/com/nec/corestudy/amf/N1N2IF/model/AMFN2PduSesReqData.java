package com.nec.corestudy.amf.N1N2IF.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.N1N2IF.model.AMFN2SmInformation;
import com.nec.corestudy.amf.N1N2IF.model.AMFNasMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFN2PduSesReqData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:32:13.674+09:00")

public class AMFN2PduSesReqData   {
  @JsonProperty("n2SmInformation")
  private AMFN2SmInformation n2SmInformation = null;

  @JsonProperty("nasMessage")
  private AMFNasMessage nasMessage = null;

  public AMFN2PduSesReqData n2SmInformation(AMFN2SmInformation n2SmInformation) {
    this.n2SmInformation = n2SmInformation;
    return this;
  }

  /**
   * Get n2SmInformation
   * @return n2SmInformation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFN2SmInformation getN2SmInformation() {
    return n2SmInformation;
  }

  public void setN2SmInformation(AMFN2SmInformation n2SmInformation) {
    this.n2SmInformation = n2SmInformation;
  }

  public AMFN2PduSesReqData nasMessage(AMFNasMessage nasMessage) {
    this.nasMessage = nasMessage;
    return this;
  }

  /**
   * Get nasMessage
   * @return nasMessage
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFNasMessage getNasMessage() {
    return nasMessage;
  }

  public void setNasMessage(AMFNasMessage nasMessage) {
    this.nasMessage = nasMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN2PduSesReqData amFN2PduSesReqData = (AMFN2PduSesReqData) o;
    return Objects.equals(this.n2SmInformation, amFN2PduSesReqData.n2SmInformation) &&
        Objects.equals(this.nasMessage, amFN2PduSesReqData.nasMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(n2SmInformation, nasMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN2PduSesReqData {\n");
    
    sb.append("    n2SmInformation: ").append(toIndentedString(n2SmInformation)).append("\n");
    sb.append("    nasMessage: ").append(toIndentedString(nasMessage)).append("\n");
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

