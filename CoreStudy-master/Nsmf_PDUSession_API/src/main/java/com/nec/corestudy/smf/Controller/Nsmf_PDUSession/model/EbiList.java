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
 * EbiList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class EbiList   {
  @JsonProperty("epsBearerId")
  private Integer epsBearerId = null;

  public EbiList epsBearerId(Integer epsBearerId) {
    this.epsBearerId = epsBearerId;
    return this;
  }

  /**
   * Get epsBearerId
   * @return epsBearerId
  **/
  @ApiModelProperty(value = "")


  public Integer getEpsBearerId() {
    return epsBearerId;
  }

  public void setEpsBearerId(Integer epsBearerId) {
    this.epsBearerId = epsBearerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EbiList ebiList = (EbiList) o;
    return Objects.equals(this.epsBearerId, ebiList.epsBearerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epsBearerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EbiList {\n");
    
    sb.append("    epsBearerId: ").append(toIndentedString(epsBearerId)).append("\n");
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

