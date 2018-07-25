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
 * SmContextUpdatedData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

public class SmContextUpdatedData   {
  @JsonProperty("upCnxState")
  private UpCnxState upCnxState = null;

  @JsonProperty("hoState")
  private HoState hoState = null;

  @JsonProperty("releaseEbiList")
  private EbiList releaseEbiList = null;

  @JsonProperty("allocatedEbiList")
  private EbiList allocatedEbiList = null;

  @JsonProperty("n1SmMsg")
  private RefToBinaryData n1SmMsg = null;

  @JsonProperty("n2SmInfo")
  private RefToBinaryData n2SmInfo = null;

  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("epsBearerSetup")
  private String epsBearerSetup = null;

  @JsonProperty("dataForwarding")
  private Boolean dataForwarding = null;

  public SmContextUpdatedData upCnxState(UpCnxState upCnxState) {
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

  public SmContextUpdatedData hoState(HoState hoState) {
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

  public SmContextUpdatedData releaseEbiList(EbiList releaseEbiList) {
    this.releaseEbiList = releaseEbiList;
    return this;
  }

  /**
   * Get releaseEbiList
   * @return releaseEbiList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public EbiList getReleaseEbiList() {
    return releaseEbiList;
  }

  public void setReleaseEbiList(EbiList releaseEbiList) {
    this.releaseEbiList = releaseEbiList;
  }

  public SmContextUpdatedData allocatedEbiList(EbiList allocatedEbiList) {
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

  public SmContextUpdatedData n1SmMsg(RefToBinaryData n1SmMsg) {
    this.n1SmMsg = n1SmMsg;
    return this;
  }

  /**
   * Get n1SmMsg
   * @return n1SmMsg
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RefToBinaryData getN1SmMsg() {
    return n1SmMsg;
  }

  public void setN1SmMsg(RefToBinaryData n1SmMsg) {
    this.n1SmMsg = n1SmMsg;
  }

  public SmContextUpdatedData n2SmInfo(RefToBinaryData n2SmInfo) {
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

  public SmContextUpdatedData pduSessionId(Integer pduSessionId) {
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

  public SmContextUpdatedData epsBearerSetup(String epsBearerSetup) {
    this.epsBearerSetup = epsBearerSetup;
    return this;
  }

  /**
   * Get epsBearerSetup
   * @return epsBearerSetup
  **/
  @ApiModelProperty(value = "")


  public String getEpsBearerSetup() {
    return epsBearerSetup;
  }

  public void setEpsBearerSetup(String epsBearerSetup) {
    this.epsBearerSetup = epsBearerSetup;
  }

  public SmContextUpdatedData dataForwarding(Boolean dataForwarding) {
    this.dataForwarding = dataForwarding;
    return this;
  }

  /**
   * Get dataForwarding
   * @return dataForwarding
  **/
  @ApiModelProperty(value = "")


  public Boolean isDataForwarding() {
    return dataForwarding;
  }

  public void setDataForwarding(Boolean dataForwarding) {
    this.dataForwarding = dataForwarding;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmContextUpdatedData smContextUpdatedData = (SmContextUpdatedData) o;
    return Objects.equals(this.upCnxState, smContextUpdatedData.upCnxState) &&
        Objects.equals(this.hoState, smContextUpdatedData.hoState) &&
        Objects.equals(this.releaseEbiList, smContextUpdatedData.releaseEbiList) &&
        Objects.equals(this.allocatedEbiList, smContextUpdatedData.allocatedEbiList) &&
        Objects.equals(this.n1SmMsg, smContextUpdatedData.n1SmMsg) &&
        Objects.equals(this.n2SmInfo, smContextUpdatedData.n2SmInfo) &&
        Objects.equals(this.pduSessionId, smContextUpdatedData.pduSessionId) &&
        Objects.equals(this.epsBearerSetup, smContextUpdatedData.epsBearerSetup) &&
        Objects.equals(this.dataForwarding, smContextUpdatedData.dataForwarding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upCnxState, hoState, releaseEbiList, allocatedEbiList, n1SmMsg, n2SmInfo, pduSessionId, epsBearerSetup, dataForwarding);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmContextUpdatedData {\n");
    
    sb.append("    upCnxState: ").append(toIndentedString(upCnxState)).append("\n");
    sb.append("    hoState: ").append(toIndentedString(hoState)).append("\n");
    sb.append("    releaseEbiList: ").append(toIndentedString(releaseEbiList)).append("\n");
    sb.append("    allocatedEbiList: ").append(toIndentedString(allocatedEbiList)).append("\n");
    sb.append("    n1SmMsg: ").append(toIndentedString(n1SmMsg)).append("\n");
    sb.append("    n2SmInfo: ").append(toIndentedString(n2SmInfo)).append("\n");
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    epsBearerSetup: ").append(toIndentedString(epsBearerSetup)).append("\n");
    sb.append("    dataForwarding: ").append(toIndentedString(dataForwarding)).append("\n");
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

