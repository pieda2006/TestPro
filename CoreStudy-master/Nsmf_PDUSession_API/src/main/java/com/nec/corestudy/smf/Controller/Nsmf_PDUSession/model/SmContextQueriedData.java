package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmContextQueriedData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class SmContextQueriedData   {
  @JsonProperty("ueEpsPdnConnection")
  private String ueEpsPdnConnection = null;

  public SmContextQueriedData ueEpsPdnConnection(String ueEpsPdnConnection) {
    this.ueEpsPdnConnection = ueEpsPdnConnection;
    return this;
  }

  /**
   * Get ueEpsPdnConnection
   * @return ueEpsPdnConnection
  **/
  @ApiModelProperty(value = "")


  public String getUeEpsPdnConnection() {
    return ueEpsPdnConnection;
  }

  public void setUeEpsPdnConnection(String ueEpsPdnConnection) {
    this.ueEpsPdnConnection = ueEpsPdnConnection;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmContextQueriedData smContextQueriedData = (SmContextQueriedData) o;
    return Objects.equals(this.ueEpsPdnConnection, smContextQueriedData.ueEpsPdnConnection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ueEpsPdnConnection);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmContextQueriedData {\n");
    
    sb.append("    ueEpsPdnConnection: ").append(toIndentedString(ueEpsPdnConnection)).append("\n");
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

