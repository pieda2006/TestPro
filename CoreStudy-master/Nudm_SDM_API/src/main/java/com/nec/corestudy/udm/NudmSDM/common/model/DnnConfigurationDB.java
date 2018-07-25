package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.AmbrDB;
import com.nec.corestudy.udm.NudmSDM.common.model.Model5GQosProfileDB;
import com.nec.corestudy.udm.NudmSDM.common.model.PduSessionTypesDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SscModesDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DnnConfigurationDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class DnnConfigurationDB   {
  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("pduSessionTypes")
  private PduSessionTypesDB pduSessionTypes = null;

  @JsonProperty("sscModes")
  private SscModesDB sscModes = null;

  @JsonProperty("ladnIndicator")
  private Boolean ladnIndicator = null;

  @JsonProperty("5gQosProfile")
  private Model5GQosProfileDB _5gQosProfile = null;

  @JsonProperty("sessionAMBR")
  private AmbrDB sessionAMBR = null;

  @JsonProperty("3gppChargingCharacteristics")
  private String _3gppChargingCharacteristics = null;

  @JsonProperty("staticIpAddress")
  @Valid
  private List<String> staticIpAddress = null;

  public DnnConfigurationDB dnn(String dnn) {
    this.dnn = dnn;
    return this;
  }

  /**
   * Get dnn
   * @return dnn
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDnn() {
    return dnn;
  }

  public void setDnn(String dnn) {
    this.dnn = dnn;
  }

  public DnnConfigurationDB pduSessionTypes(PduSessionTypesDB pduSessionTypes) {
    this.pduSessionTypes = pduSessionTypes;
    return this;
  }

  /**
   * Get pduSessionTypes
   * @return pduSessionTypes
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PduSessionTypesDB getPduSessionTypes() {
    return pduSessionTypes;
  }

  public void setPduSessionTypes(PduSessionTypesDB pduSessionTypes) {
    this.pduSessionTypes = pduSessionTypes;
  }

  public DnnConfigurationDB sscModes(SscModesDB sscModes) {
    this.sscModes = sscModes;
    return this;
  }

  /**
   * Get sscModes
   * @return sscModes
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SscModesDB getSscModes() {
    return sscModes;
  }

  public void setSscModes(SscModesDB sscModes) {
    this.sscModes = sscModes;
  }

  public DnnConfigurationDB ladnIndicator(Boolean ladnIndicator) {
    this.ladnIndicator = ladnIndicator;
    return this;
  }

  /**
   * Get ladnIndicator
   * @return ladnIndicator
  **/
  @ApiModelProperty(value = "")


  public Boolean isLadnIndicator() {
    return ladnIndicator;
  }

  public void setLadnIndicator(Boolean ladnIndicator) {
    this.ladnIndicator = ladnIndicator;
  }

  public DnnConfigurationDB _5gQosProfile(Model5GQosProfileDB _5gQosProfile) {
    this._5gQosProfile = _5gQosProfile;
    return this;
  }

  /**
   * Get _5gQosProfile
   * @return _5gQosProfile
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Model5GQosProfileDB get5gQosProfile() {
    return _5gQosProfile;
  }

  public void set5gQosProfile(Model5GQosProfileDB _5gQosProfile) {
    this._5gQosProfile = _5gQosProfile;
  }

  public DnnConfigurationDB sessionAMBR(AmbrDB sessionAMBR) {
    this.sessionAMBR = sessionAMBR;
    return this;
  }

  /**
   * Get sessionAMBR
   * @return sessionAMBR
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AmbrDB getSessionAMBR() {
    return sessionAMBR;
  }

  public void setSessionAMBR(AmbrDB sessionAMBR) {
    this.sessionAMBR = sessionAMBR;
  }

  public DnnConfigurationDB _3gppChargingCharacteristics(String _3gppChargingCharacteristics) {
    this._3gppChargingCharacteristics = _3gppChargingCharacteristics;
    return this;
  }

  /**
   * Get _3gppChargingCharacteristics
   * @return _3gppChargingCharacteristics
  **/
  @ApiModelProperty(value = "")


  public String get3gppChargingCharacteristics() {
    return _3gppChargingCharacteristics;
  }

  public void set3gppChargingCharacteristics(String _3gppChargingCharacteristics) {
    this._3gppChargingCharacteristics = _3gppChargingCharacteristics;
  }

  public DnnConfigurationDB staticIpAddress(List<String> staticIpAddress) {
    this.staticIpAddress = staticIpAddress;
    return this;
  }

  public DnnConfigurationDB addStaticIpAddressItem(String staticIpAddressItem) {
    if (this.staticIpAddress == null) {
      this.staticIpAddress = new ArrayList<String>();
    }
    this.staticIpAddress.add(staticIpAddressItem);
    return this;
  }

  /**
   * Get staticIpAddress
   * @return staticIpAddress
  **/
  @ApiModelProperty(value = "")


  public List<String> getStaticIpAddress() {
    return staticIpAddress;
  }

  public void setStaticIpAddress(List<String> staticIpAddress) {
    this.staticIpAddress = staticIpAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DnnConfigurationDB dnnConfigurationDB = (DnnConfigurationDB) o;
    return Objects.equals(this.dnn, dnnConfigurationDB.dnn) &&
        Objects.equals(this.pduSessionTypes, dnnConfigurationDB.pduSessionTypes) &&
        Objects.equals(this.sscModes, dnnConfigurationDB.sscModes) &&
        Objects.equals(this.ladnIndicator, dnnConfigurationDB.ladnIndicator) &&
        Objects.equals(this._5gQosProfile, dnnConfigurationDB._5gQosProfile) &&
        Objects.equals(this.sessionAMBR, dnnConfigurationDB.sessionAMBR) &&
        Objects.equals(this._3gppChargingCharacteristics, dnnConfigurationDB._3gppChargingCharacteristics) &&
        Objects.equals(this.staticIpAddress, dnnConfigurationDB.staticIpAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dnn, pduSessionTypes, sscModes, ladnIndicator, _5gQosProfile, sessionAMBR, _3gppChargingCharacteristics, staticIpAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DnnConfigurationDB {\n");
    
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    pduSessionTypes: ").append(toIndentedString(pduSessionTypes)).append("\n");
    sb.append("    sscModes: ").append(toIndentedString(sscModes)).append("\n");
    sb.append("    ladnIndicator: ").append(toIndentedString(ladnIndicator)).append("\n");
    sb.append("    _5gQosProfile: ").append(toIndentedString(_5gQosProfile)).append("\n");
    sb.append("    sessionAMBR: ").append(toIndentedString(sessionAMBR)).append("\n");
    sb.append("    _3gppChargingCharacteristics: ").append(toIndentedString(_3gppChargingCharacteristics)).append("\n");
    sb.append("    staticIpAddress: ").append(toIndentedString(staticIpAddress)).append("\n");
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

