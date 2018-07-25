package com.nec.corestudy.amf.N1N2IF.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFN2ResRelReqData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-12T20:14:44.512+09:00")

public class AMFN2ResRelReqData   {
  @JsonProperty("teid")
  private Integer teid = null;

  @JsonProperty("upfipaddr")
  private String upfipaddr = null;

  public AMFN2ResRelReqData teid(Integer teid) {
    this.teid = teid;
    return this;
  }

  /**
   * Get teid
   * @return teid
  **/
  @ApiModelProperty(value = "")


  public Integer getTeid() {
    return teid;
  }

  public void setTeid(Integer teid) {
    this.teid = teid;
  }

  public AMFN2ResRelReqData upfipaddr(String upfipaddr) {
    this.upfipaddr = upfipaddr;
    return this;
  }

  /**
   * Get upfipaddr
   * @return upfipaddr
  **/
  @ApiModelProperty(value = "")


  public String getUpfipaddr() {
    return upfipaddr;
  }

  public void setUpfipaddr(String upfipaddr) {
    this.upfipaddr = upfipaddr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN2ResRelReqData amFN2ResRelReqData = (AMFN2ResRelReqData) o;
    return Objects.equals(this.teid, amFN2ResRelReqData.teid) &&
        Objects.equals(this.upfipaddr, amFN2ResRelReqData.upfipaddr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(teid, upfipaddr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN2ResRelReqData {\n");
    
    sb.append("    teid: ").append(toIndentedString(teid)).append("\n");
    sb.append("    upfipaddr: ").append(toIndentedString(upfipaddr)).append("\n");
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

