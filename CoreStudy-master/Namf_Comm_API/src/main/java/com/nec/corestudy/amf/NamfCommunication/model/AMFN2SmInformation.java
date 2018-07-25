package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN2InfoContent;
import com.nec.corestudy.amf.NamfCommunication.model.AMFSnssai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFN2SmInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFN2SmInformation   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("n2InfoContent")
  private AMFN2InfoContent n2InfoContent = null;

  @JsonProperty("nasPdu")
  private Integer nasPdu = null;

  @JsonProperty("sNssai")
  private AMFSnssai sNssai = null;

  @JsonProperty("subjectToHo")
  private Boolean subjectToHo = null;

  public AMFN2SmInformation pduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
    return this;
  }

  /**
   * Get pduSessionId
   * @return pduSessionId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getPduSessionId() {
    return pduSessionId;
  }

  public void setPduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
  }

  public AMFN2SmInformation n2InfoContent(AMFN2InfoContent n2InfoContent) {
    this.n2InfoContent = n2InfoContent;
    return this;
  }

  /**
   * Get n2InfoContent
   * @return n2InfoContent
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFN2InfoContent getN2InfoContent() {
    return n2InfoContent;
  }

  public void setN2InfoContent(AMFN2InfoContent n2InfoContent) {
    this.n2InfoContent = n2InfoContent;
  }

  public AMFN2SmInformation nasPdu(Integer nasPdu) {
    this.nasPdu = nasPdu;
    return this;
  }

  /**
   * Get nasPdu
   * @return nasPdu
  **/
  @ApiModelProperty(value = "")


  public Integer getNasPdu() {
    return nasPdu;
  }

  public void setNasPdu(Integer nasPdu) {
    this.nasPdu = nasPdu;
  }

  public AMFN2SmInformation sNssai(AMFSnssai sNssai) {
    this.sNssai = sNssai;
    return this;
  }

  /**
   * Get sNssai
   * @return sNssai
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFSnssai getSNssai() {
    return sNssai;
  }

  public void setSNssai(AMFSnssai sNssai) {
    this.sNssai = sNssai;
  }

  public AMFN2SmInformation subjectToHo(Boolean subjectToHo) {
    this.subjectToHo = subjectToHo;
    return this;
  }

  /**
   * Get subjectToHo
   * @return subjectToHo
  **/
  @ApiModelProperty(value = "")


  public Boolean isSubjectToHo() {
    return subjectToHo;
  }

  public void setSubjectToHo(Boolean subjectToHo) {
    this.subjectToHo = subjectToHo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN2SmInformation amFN2SmInformation = (AMFN2SmInformation) o;
    return Objects.equals(this.pduSessionId, amFN2SmInformation.pduSessionId) &&
        Objects.equals(this.n2InfoContent, amFN2SmInformation.n2InfoContent) &&
        Objects.equals(this.nasPdu, amFN2SmInformation.nasPdu) &&
        Objects.equals(this.sNssai, amFN2SmInformation.sNssai) &&
        Objects.equals(this.subjectToHo, amFN2SmInformation.subjectToHo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, n2InfoContent, nasPdu, sNssai, subjectToHo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN2SmInformation {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    n2InfoContent: ").append(toIndentedString(n2InfoContent)).append("\n");
    sb.append("    nasPdu: ").append(toIndentedString(nasPdu)).append("\n");
    sb.append("    sNssai: ").append(toIndentedString(sNssai)).append("\n");
    sb.append("    subjectToHo: ").append(toIndentedString(subjectToHo)).append("\n");
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

