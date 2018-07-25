package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.PduSessionDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UeContextInSmfDataDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class UeContextInSmfDataDB   {
  @JsonProperty("pduSessions")
  @Valid
  private List<PduSessionDB> pduSessions = null;

  public UeContextInSmfDataDB pduSessions(List<PduSessionDB> pduSessions) {
    this.pduSessions = pduSessions;
    return this;
  }

  public UeContextInSmfDataDB addPduSessionsItem(PduSessionDB pduSessionsItem) {
    if (this.pduSessions == null) {
      this.pduSessions = new ArrayList<PduSessionDB>();
    }
    this.pduSessions.add(pduSessionsItem);
    return this;
  }

  /**
   * Get pduSessions
   * @return pduSessions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PduSessionDB> getPduSessions() {
    return pduSessions;
  }

  public void setPduSessions(List<PduSessionDB> pduSessions) {
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
    UeContextInSmfDataDB ueContextInSmfDataDB = (UeContextInSmfDataDB) o;
    return Objects.equals(this.pduSessions, ueContextInSmfDataDB.pduSessions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UeContextInSmfDataDB {\n");
    
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

