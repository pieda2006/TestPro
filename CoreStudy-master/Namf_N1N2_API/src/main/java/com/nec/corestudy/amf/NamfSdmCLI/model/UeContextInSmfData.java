package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfSdmCLI.model.PduSession;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * UeContextInSmfData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:45.878+09:00")

public class UeContextInSmfData   {
  @JsonProperty("pduSessions")
  
  private List<PduSession> pduSessions = null;

  public UeContextInSmfData pduSessions(List<PduSession> pduSessions) {
    this.pduSessions = pduSessions;
    return this;
  }

  public UeContextInSmfData addPduSessionsItem(PduSession pduSessionsItem) {
    if (this.pduSessions == null) {
      this.pduSessions = new ArrayList<PduSession>();
    }
    this.pduSessions.add(pduSessionsItem);
    return this;
  }

  /**
   * Get pduSessions
   * @return pduSessions
  **/
  @ApiModelProperty(value = "")
  public List<PduSession> getPduSessions() {
    return pduSessions;
  }

  public void setPduSessions(List<PduSession> pduSessions) {
    this.pduSessions = pduSessions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UeContextInSmfData ueContextInSmfData = (UeContextInSmfData) o;
    return Objects.equals(this.pduSessions, ueContextInSmfData.pduSessions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UeContextInSmfData {\n");
    
    sb.append("    pduSessions: ").append(toIndentedString(pduSessions)).append("\n");
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

