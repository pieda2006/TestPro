package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AmfId
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:38:40.778+09:00")

public class AmfId   {
  @JsonProperty("ffs")
  private String ffs = null;

  public AmfId ffs(String ffs) {
    this.ffs = ffs;
    return this;
  }

  /**
   * Get ffs
   * @return ffs
  **/
  @ApiModelProperty(value = "")
  public String getFfs() {
    return ffs;
  }

  public void setFfs(String ffs) {
    this.ffs = ffs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmfId amfId = (AmfId) o;
    return Objects.equals(this.ffs, amfId.ffs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ffs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmfId {\n");
    
    sb.append("    ffs: ").append(toIndentedString(ffs)).append("\n");
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

