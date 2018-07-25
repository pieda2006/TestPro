package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfCommunication.model.AMFSnssai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFPduSessionContext
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFPduSessionContext   {
  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("smContextRef")
  private String smContextRef = null;

  @JsonProperty("sNssai")
  private AMFSnssai sNssai = null;

  @JsonProperty("dnn")
  private String dnn = null;

  /**
   * Gets or Sets accessType
   */
  public enum AccessTypeEnum {
    _3GPP_ACCESS("Jamf_3GPP_ACCESS"),
    
    NON_3GPP_ACCESS("Jamf_NON_3GPP_ACCESS");

    private String value;

    AccessTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AccessTypeEnum fromValue(String text) {
      for (AccessTypeEnum b : AccessTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("accessType")
  private AccessTypeEnum accessType = null;

  @JsonProperty("allocatedEbiList")
  @Valid
  private List<String> allocatedEbiList = new ArrayList<String>();

  @JsonProperty("hsmfId")
  private String hsmfId = null;

  @JsonProperty("vsmfId")
  private String vsmfId = null;

  @JsonProperty("nsInstance")
  private String nsInstance = null;

  public AMFPduSessionContext pduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
    return this;
  }

  /**
   * Get pduSessionId
   * @return pduSessionId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getPduSessionId() {
    return pduSessionId;
  }

  public void setPduSessionId(Integer pduSessionId) {
    this.pduSessionId = pduSessionId;
  }

  public AMFPduSessionContext smContextRef(String smContextRef) {
    this.smContextRef = smContextRef;
    return this;
  }

  /**
   * Get smContextRef
   * @return smContextRef
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSmContextRef() {
    return smContextRef;
  }

  public void setSmContextRef(String smContextRef) {
    this.smContextRef = smContextRef;
  }

  public AMFPduSessionContext sNssai(AMFSnssai sNssai) {
    this.sNssai = sNssai;
    return this;
  }

  /**
   * Get sNssai
   * @return sNssai
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFSnssai getSNssai() {
    return sNssai;
  }

  public void setSNssai(AMFSnssai sNssai) {
    this.sNssai = sNssai;
  }

  public AMFPduSessionContext dnn(String dnn) {
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

  public AMFPduSessionContext accessType(AccessTypeEnum accessType) {
    this.accessType = accessType;
    return this;
  }

  /**
   * Get accessType
   * @return accessType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public AccessTypeEnum getAccessType() {
    return accessType;
  }

  public void setAccessType(AccessTypeEnum accessType) {
    this.accessType = accessType;
  }

  public AMFPduSessionContext allocatedEbiList(List<String> allocatedEbiList) {
    this.allocatedEbiList = allocatedEbiList;
    return this;
  }

  public AMFPduSessionContext addAllocatedEbiListItem(String allocatedEbiListItem) {
    this.allocatedEbiList.add(allocatedEbiListItem);
    return this;
  }

  /**
   * Definition of EpsArpMapping is not found
   * @return allocatedEbiList
  **/
  @ApiModelProperty(required = true, value = "Definition of EpsArpMapping is not found")
  @NotNull


  public List<String> getAllocatedEbiList() {
    return allocatedEbiList;
  }

  public void setAllocatedEbiList(List<String> allocatedEbiList) {
    this.allocatedEbiList = allocatedEbiList;
  }

  public AMFPduSessionContext hsmfId(String hsmfId) {
    this.hsmfId = hsmfId;
    return this;
  }

  /**
   * Get hsmfId
   * @return hsmfId
  **/
  @ApiModelProperty(value = "")


  public String getHsmfId() {
    return hsmfId;
  }

  public void setHsmfId(String hsmfId) {
    this.hsmfId = hsmfId;
  }

  public AMFPduSessionContext vsmfId(String vsmfId) {
    this.vsmfId = vsmfId;
    return this;
  }

  /**
   * Get vsmfId
   * @return vsmfId
  **/
  @ApiModelProperty(value = "")


  public String getVsmfId() {
    return vsmfId;
  }

  public void setVsmfId(String vsmfId) {
    this.vsmfId = vsmfId;
  }

  public AMFPduSessionContext nsInstance(String nsInstance) {
    this.nsInstance = nsInstance;
    return this;
  }

  /**
   * FFS
   * @return nsInstance
  **/
  @ApiModelProperty(value = "FFS")


  public String getNsInstance() {
    return nsInstance;
  }

  public void setNsInstance(String nsInstance) {
    this.nsInstance = nsInstance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFPduSessionContext amFPduSessionContext = (AMFPduSessionContext) o;
    return Objects.equals(this.pduSessionId, amFPduSessionContext.pduSessionId) &&
        Objects.equals(this.smContextRef, amFPduSessionContext.smContextRef) &&
        Objects.equals(this.sNssai, amFPduSessionContext.sNssai) &&
        Objects.equals(this.dnn, amFPduSessionContext.dnn) &&
        Objects.equals(this.accessType, amFPduSessionContext.accessType) &&
        Objects.equals(this.allocatedEbiList, amFPduSessionContext.allocatedEbiList) &&
        Objects.equals(this.hsmfId, amFPduSessionContext.hsmfId) &&
        Objects.equals(this.vsmfId, amFPduSessionContext.vsmfId) &&
        Objects.equals(this.nsInstance, amFPduSessionContext.nsInstance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pduSessionId, smContextRef, sNssai, dnn, accessType, allocatedEbiList, hsmfId, vsmfId, nsInstance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFPduSessionContext {\n");
    
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    smContextRef: ").append(toIndentedString(smContextRef)).append("\n");
    sb.append("    sNssai: ").append(toIndentedString(sNssai)).append("\n");
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    accessType: ").append(toIndentedString(accessType)).append("\n");
    sb.append("    allocatedEbiList: ").append(toIndentedString(allocatedEbiList)).append("\n");
    sb.append("    hsmfId: ").append(toIndentedString(hsmfId)).append("\n");
    sb.append("    vsmfId: ").append(toIndentedString(vsmfId)).append("\n");
    sb.append("    nsInstance: ").append(toIndentedString(nsInstance)).append("\n");
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

