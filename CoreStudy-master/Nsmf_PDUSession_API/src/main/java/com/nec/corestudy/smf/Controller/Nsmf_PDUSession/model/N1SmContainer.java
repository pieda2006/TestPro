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
 * N1SmContainer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class N1SmContainer   {
  @JsonProperty("ffs")
  private String ffs = null;

  public N1SmContainer ffs(String ffs) {
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
    N1SmContainer n1SmContainer = (N1SmContainer) o;
    return Objects.equals(this.ffs, n1SmContainer.ffs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ffs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class N1SmContainer {\n");
    
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

