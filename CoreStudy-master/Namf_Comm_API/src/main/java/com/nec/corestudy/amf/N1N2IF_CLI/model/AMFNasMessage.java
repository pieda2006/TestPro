package com.nec.corestudy.amf.N1N2IF_CLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
//import com.nec.corestudy.amf.N1N2IF_CLI.model.AMFN1MessageContainer;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN1MessageContainer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AMFNasMessage
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:33:39.136+09:00")

public class AMFNasMessage   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("n1MessageContainer")
  private AMFN1MessageContainer n1MessageContainer = null;

  public AMFNasMessage pduSessionId(Integer pduSessionId) {
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

  public AMFNasMessage n1MessageContainer(AMFN1MessageContainer n1MessageContainer) {
    this.n1MessageContainer = n1MessageContainer;
    return this;
  }

  /**
   * Get n1MessageContainer
   * @return n1MessageContainer
  **/
  @ApiModelProperty(value = "")
  public AMFN1MessageContainer getN1MessageContainer() {
    return n1MessageContainer;
  }

  public void setN1MessageContainer(AMFN1MessageContainer n1MessageContainer) {
    this.n1MessageContainer = n1MessageContainer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFNasMessage amFNasMessage = (AMFNasMessage) o;
    return Objects.equals(this.pduSessionId, amFNasMessage.pduSessionId) &&
        Objects.equals(this.n1MessageContainer, amFNasMessage.n1MessageContainer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, n1MessageContainer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFNasMessage {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    n1MessageContainer: ").append(toIndentedString(n1MessageContainer)).append("\n");
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

