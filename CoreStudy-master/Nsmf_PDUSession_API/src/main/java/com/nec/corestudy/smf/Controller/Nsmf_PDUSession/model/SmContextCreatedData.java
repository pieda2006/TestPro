package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.EbiList;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.HoState;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.RefToBinaryData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.UpCnxState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmContextCreatedData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class SmContextCreatedData   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("upCnxState")
  private UpCnxState upCnxState = null;

  @JsonProperty("n2SmInfo")
  private RefToBinaryData n2SmInfo = null;

  @JsonProperty("allocatedEbiList")
  private EbiList allocatedEbiList = null;

  @JsonProperty("hoState")
  private HoState hoState = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  public SmContextCreatedData pduSessionId(Integer pduSessionId) {
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

  public SmContextCreatedData upCnxState(UpCnxState upCnxState) {
    this.upCnxState = upCnxState;
    return this;
  }

  /**
   * Get upCnxState
   * @return upCnxState
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UpCnxState getUpCnxState() {
    return upCnxState;
  }

  public void setUpCnxState(UpCnxState upCnxState) {
    this.upCnxState = upCnxState;
  }

  public SmContextCreatedData n2SmInfo(RefToBinaryData n2SmInfo) {
    this.n2SmInfo = n2SmInfo;
    return this;
  }

  /**
   * Get n2SmInfo
   * @return n2SmInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RefToBinaryData getN2SmInfo() {
    return n2SmInfo;
  }

  public void setN2SmInfo(RefToBinaryData n2SmInfo) {
    this.n2SmInfo = n2SmInfo;
  }

  public SmContextCreatedData allocatedEbiList(EbiList allocatedEbiList) {
    this.allocatedEbiList = allocatedEbiList;
    return this;
  }

  /**
   * Get allocatedEbiList
   * @return allocatedEbiList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public EbiList getAllocatedEbiList() {
    return allocatedEbiList;
  }

  public void setAllocatedEbiList(EbiList allocatedEbiList) {
    this.allocatedEbiList = allocatedEbiList;
  }

  public SmContextCreatedData hoState(HoState hoState) {
    this.hoState = hoState;
    return this;
  }

  /**
   * Get hoState
   * @return hoState
  **/
  @ApiModelProperty(value = "")

  @Valid

  public HoState getHoState() {
    return hoState;
  }

  public void setHoState(HoState hoState) {
    this.hoState = hoState;
  }

  public SmContextCreatedData supportedFeatures(String supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
    return this;
  }

  /**
   * Get supportedFeatures
   * @return supportedFeatures
  **/
  @ApiModelProperty(value = "")


  public String getSupportedFeatures() {
    return supportedFeatures;
  }

  public void setSupportedFeatures(String supportedFeatures) {
    this.supportedFeatures = supportedFeatures;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmContextCreatedData smContextCreatedData = (SmContextCreatedData) o;
    return Objects.equals(this.pduSessionId, smContextCreatedData.pduSessionId) &&
        Objects.equals(this.upCnxState, smContextCreatedData.upCnxState) &&
        Objects.equals(this.n2SmInfo, smContextCreatedData.n2SmInfo) &&
        Objects.equals(this.allocatedEbiList, smContextCreatedData.allocatedEbiList) &&
        Objects.equals(this.hoState, smContextCreatedData.hoState) &&
        Objects.equals(this.supportedFeatures, smContextCreatedData.supportedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, upCnxState, n2SmInfo, allocatedEbiList, hoState, supportedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmContextCreatedData {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    upCnxState: ").append(toIndentedString(upCnxState)).append("\n");
    sb.append("    n2SmInfo: ").append(toIndentedString(n2SmInfo)).append("\n");
    sb.append("    allocatedEbiList: ").append(toIndentedString(allocatedEbiList)).append("\n");
    sb.append("    hoState: ").append(toIndentedString(hoState)).append("\n");
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
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
