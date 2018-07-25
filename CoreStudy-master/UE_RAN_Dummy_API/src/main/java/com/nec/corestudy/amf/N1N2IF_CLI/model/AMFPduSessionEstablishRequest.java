package com.nec.corestudy.amf.N1N2IF_CLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.N1N2IF_CLI.model.AMFN1MessageContainer;
import com.nec.corestudy.amf.N1N2IF_CLI.model.AMFSnssai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AMFPduSessionEstablishRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:33:39.136+09:00")

public class AMFPduSessionEstablishRequest   {
  @JsonProperty("snssai")
  private AMFSnssai snssai = null;

  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("requestType")
  private String requestType = null;

  @JsonProperty("oldPduSessionId")
  private Integer oldPduSessionId = null;

  @JsonProperty("n1SmContainer")
  private AMFN1MessageContainer n1SmContainer = null;

  public AMFPduSessionEstablishRequest snssai(AMFSnssai snssai) {
    this.snssai = snssai;
    return this;
  }

  /**
   * Get snssai
   * @return snssai
  **/
  @ApiModelProperty(value = "")
  public AMFSnssai getSnssai() {
    return snssai;
  }

  public void setSnssai(AMFSnssai snssai) {
    this.snssai = snssai;
  }

  public AMFPduSessionEstablishRequest dnn(String dnn) {
    this.dnn = dnn;
    return this;
  }

  /**
   * Get dnn
   * @return dnn
  **/
  @ApiModelProperty(value = "")
  public String getDnn() {
    return dnn;
  }

  public void setDnn(String dnn) {
    this.dnn = dnn;
  }

  public AMFPduSessionEstablishRequest pduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
    return this;
  }

  /**
   * Get pduSessionId
   * @return pduSessionId
  **/
  @ApiModelProperty(value = "")
  public Integer getPduSessionId() {
    return pduSessionId;
  }

  public void setPduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
  }

  public AMFPduSessionEstablishRequest requestType(String requestType) {
    this.requestType = requestType;
    return this;
  }

  /**
   * Get requestType
   * @return requestType
  **/
  @ApiModelProperty(value = "")
  public String getRequestType() {
    return requestType;
  }

  public void setRequestType(String requestType) {
    this.requestType = requestType;
  }

  public AMFPduSessionEstablishRequest oldPduSessionId(Integer oldPduSessionId) {
    this.oldPduSessionId = oldPduSessionId;
    return this;
  }

  /**
   * Get oldPduSessionId
   * @return oldPduSessionId
  **/
  @ApiModelProperty(value = "")
  public Integer getOldPduSessionId() {
    return oldPduSessionId;
  }

  public void setOldPduSessionId(Integer oldPduSessionId) {
    this.oldPduSessionId = oldPduSessionId;
  }

  public AMFPduSessionEstablishRequest n1SmContainer(AMFN1MessageContainer n1SmContainer) {
    this.n1SmContainer = n1SmContainer;
    return this;
  }

  /**
   * Get n1SmContainer
   * @return n1SmContainer
  **/
  @ApiModelProperty(value = "")
  public AMFN1MessageContainer getN1SmContainer() {
    return n1SmContainer;
  }

  public void setN1SmContainer(AMFN1MessageContainer n1SmContainer) {
    this.n1SmContainer = n1SmContainer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFPduSessionEstablishRequest amFPduSessionEstablishRequest = (AMFPduSessionEstablishRequest) o;
    return Objects.equals(this.snssai, amFPduSessionEstablishRequest.snssai) &&
        Objects.equals(this.dnn, amFPduSessionEstablishRequest.dnn) &&
        Objects.equals(this.pduSessionId, amFPduSessionEstablishRequest.pduSessionId) &&
        Objects.equals(this.requestType, amFPduSessionEstablishRequest.requestType) &&
        Objects.equals(this.oldPduSessionId, amFPduSessionEstablishRequest.oldPduSessionId) &&
        Objects.equals(this.n1SmContainer, amFPduSessionEstablishRequest.n1SmContainer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(snssai, dnn, pduSessionId, requestType, oldPduSessionId, n1SmContainer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFPduSessionEstablishRequest {\n");
    
    sb.append("    snssai: ").append(toIndentedString(snssai)).append("\n");
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    requestType: ").append(toIndentedString(requestType)).append("\n");
    sb.append("    oldPduSessionId: ").append(toIndentedString(oldPduSessionId)).append("\n");
    sb.append("    n1SmContainer: ").append(toIndentedString(n1SmContainer)).append("\n");
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

