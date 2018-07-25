package com.nec.corestudy.udm.NudmUECM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SmfRegistration
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T20:24:10.908+09:00")

public class SmfRegistration   {
  @JsonProperty("smfId")
  private String smfId = null;

  @JsonProperty("supportedFeatures")
  private String supportedFeatures = null;

  @JsonProperty("pduSessionId")
  private Integer pduSessionId = null;

  @JsonProperty("dnn")
  private String dnn = null;

  @JsonProperty("pcscfRestorationCallbackUri")
  private String pcscfRestorationCallbackUri = null;

  public SmfRegistration smfId(String smfId) {
    this.smfId = smfId;
    return this;
  }

  /**
   * Get smfId
   * @return smfId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSmfId() {
    return smfId;
  }

  public void setSmfId(String smfId) {
    this.smfId = smfId;
  }

  public SmfRegistration supportedFeatures(String supportedFeatures) {
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

  public SmfRegistration pduSessionId(Integer pduSessionId) {
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

  public SmfRegistration dnn(String dnn) {
    this.dnn = dnn;
    return this;
  }

  /**
   * Get dnn
   * @return dnn
  **/
  @ApiModelProperty(value = "")


  public String getDnn() {
    return dnn;
  }

  public void setDnn(String dnn) {
    this.dnn = dnn;
  }

  public SmfRegistration pcscfRestorationCallbackUri(String pcscfRestorationCallbackUri) {
    this.pcscfRestorationCallbackUri = pcscfRestorationCallbackUri;
    return this;
  }

  /**
   * Get pcscfRestorationCallbackUri
   * @return pcscfRestorationCallbackUri
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPcscfRestorationCallbackUri() {
    return pcscfRestorationCallbackUri;
  }

  public void setPcscfRestorationCallbackUri(String pcscfRestorationCallbackUri) {
    this.pcscfRestorationCallbackUri = pcscfRestorationCallbackUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmfRegistration smfRegistration = (SmfRegistration) o;
    return Objects.equals(this.smfId, smfRegistration.smfId) &&
        Objects.equals(this.supportedFeatures, smfRegistration.supportedFeatures) &&
        Objects.equals(this.pduSessionId, smfRegistration.pduSessionId) &&
        Objects.equals(this.dnn, smfRegistration.dnn) &&
        Objects.equals(this.pcscfRestorationCallbackUri, smfRegistration.pcscfRestorationCallbackUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smfId, supportedFeatures, pduSessionId, dnn, pcscfRestorationCallbackUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmfRegistration {\n");
    
    sb.append("    smfId: ").append(toIndentedString(smfId)).append("\n");
    sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
    sb.append("    pduSessionId: ").append(toIndentedString(pduSessionId)).append("\n");
    sb.append("    dnn: ").append(toIndentedString(dnn)).append("\n");
    sb.append("    pcscfRestorationCallbackUri: ").append(toIndentedString(pcscfRestorationCallbackUri)).append("\n");
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

