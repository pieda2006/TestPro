package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PduSession
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:45.878+09:00")

public class PduSession   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("smfId")
  private String smfId = null;

  @JsonProperty("smfAddress")
  private String smfAddress = null;

  public PduSession pduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
    return this;
  }

  /**
   * Get pduSessionId
   * @return pduSessionId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPduSessionId() {
    return pduSessionId;
  }

  public void setPduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
  }

  public PduSession dnn(String dnn) {
    this.dnn = dnn;
    return this;
  }

  /**
   * Get dnn
   * @return dnn
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDnn() {
    return dnn;
  }

  public void setDnn(String dnn) {
    this.dnn = dnn;
  }

  public PduSession smfId(String smfId) {
    this.smfId = smfId;
    return this;
  }

  /**
   * Get smfId
   * @return smfId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getSmfId() {
    return smfId;
  }

  public void setSmfId(String smfId) {
    this.smfId = smfId;
  }

  public PduSession smfAddress(String smfAddress) {
    this.smfAddress = smfAddress;
    return this;
  }

  /**
   * Get smfAddress
   * @return smfAddress
  **/
  @ApiModelProperty(required = true, value = "")
  public String getSmfAddress() {
    return smfAddress;
  }

  public void setSmfAddress(String smfAddress) {
    this.smfAddress = smfAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PduSession pduSession = (PduSession) o;
    return Objects.equals(this.pduSessionId, pduSession.pduSessionId) &&
        Objects.equals(this.dnn, pduSession.dnn) &&
        Objects.equals(this.smfId, pduSession.smfId) &&
        Objects.equals(this.smfAddress, pduSession.smfAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, dnn, smfId, smfAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PduSession {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    smfId: ").append(toIndentedString(smfId)).append("\n");
    sb.append("    smfAddress: ").append(toIndentedString(smfAddress)).append("\n");
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

