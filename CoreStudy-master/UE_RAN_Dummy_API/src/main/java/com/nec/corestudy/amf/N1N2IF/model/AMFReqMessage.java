package com.nec.corestudy.amf.N1N2IF.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.N1N2IF.model.AMFPduSessionEstablishRequest;
import com.nec.corestudy.amf.N1N2IF.model.AMFPduSessionReleaseRequest;
import com.nec.corestudy.amf.N1N2IF.model.AMFRegistrationRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Message of Request
 */
@ApiModel(description = "Message of Request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T17:00:57.205+09:00")

public class AMFReqMessage   {
  @JsonProperty("reqType")
  private String reqType = null;

  @JsonProperty("registrationRequest")
  private AMFRegistrationRequest registrationRequest = null;

  @JsonProperty("pduSessionEstablishRequest")
  private AMFPduSessionEstablishRequest pduSessionEstablishRequest = null;

  @JsonProperty("pduSessionReleaseRequest")
  private AMFPduSessionReleaseRequest pduSessionReleaseRequest = null;

  public AMFReqMessage reqType(String reqType) {
    this.reqType = reqType;
    return this;
  }

  /**
   * Get reqType
   * @return reqType
  **/
  @ApiModelProperty(value = "")


  public String getReqType() {
    return reqType;
  }

  public void setReqType(String reqType) {
    this.reqType = reqType;
  }

  public AMFReqMessage registrationRequest(AMFRegistrationRequest registrationRequest) {
    this.registrationRequest = registrationRequest;
    return this;
  }

  /**
   * Get registrationRequest
   * @return registrationRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFRegistrationRequest getRegistrationRequest() {
    return registrationRequest;
  }

  public void setRegistrationRequest(AMFRegistrationRequest registrationRequest) {
    this.registrationRequest = registrationRequest;
  }

  public AMFReqMessage pduSessionEstablishRequest(AMFPduSessionEstablishRequest pduSessionEstablishRequest) {
    this.pduSessionEstablishRequest = pduSessionEstablishRequest;
    return this;
  }

  /**
   * Get pduSessionEstablishRequest
   * @return pduSessionEstablishRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFPduSessionEstablishRequest getPduSessionEstablishRequest() {
    return pduSessionEstablishRequest;
  }

  public void setPduSessionEstablishRequest(AMFPduSessionEstablishRequest pduSessionEstablishRequest) {
    this.pduSessionEstablishRequest = pduSessionEstablishRequest;
  }

  public AMFReqMessage pduSessionReleaseRequest(AMFPduSessionReleaseRequest pduSessionReleaseRequest) {
    this.pduSessionReleaseRequest = pduSessionReleaseRequest;
    return this;
  }

  /**
   * Get pduSessionReleaseRequest
   * @return pduSessionReleaseRequest
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AMFPduSessionReleaseRequest getPduSessionReleaseRequest() {
    return pduSessionReleaseRequest;
  }

  public void setPduSessionReleaseRequest(AMFPduSessionReleaseRequest pduSessionReleaseRequest) {
    this.pduSessionReleaseRequest = pduSessionReleaseRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFReqMessage amFReqMessage = (AMFReqMessage) o;
    return Objects.equals(this.reqType, amFReqMessage.reqType) &&
        Objects.equals(this.registrationRequest, amFReqMessage.registrationRequest) &&
        Objects.equals(this.pduSessionEstablishRequest, amFReqMessage.pduSessionEstablishRequest) &&
        Objects.equals(this.pduSessionReleaseRequest, amFReqMessage.pduSessionReleaseRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reqType, registrationRequest, pduSessionEstablishRequest, pduSessionReleaseRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFReqMessage {\n");
    
    sb.append("    reqType: ").append(toIndentedString(reqType)).append("\n");
    sb.append("    registrationRequest: ").append(toIndentedString(registrationRequest)).append("\n");
    sb.append("    pduSessionEstablishRequest: ").append(toIndentedString(pduSessionEstablishRequest)).append("\n");
    sb.append("    pduSessionReleaseRequest: ").append(toIndentedString(pduSessionReleaseRequest)).append("\n");
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

