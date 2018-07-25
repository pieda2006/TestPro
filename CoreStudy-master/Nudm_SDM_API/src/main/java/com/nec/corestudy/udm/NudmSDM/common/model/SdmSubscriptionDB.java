package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SdmSubscriptionDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SdmSubscriptionDB   {
  @JsonProperty("callbackReference")
  private String callbackReference = null;

  @JsonProperty("monitoredResourceUri")
  @Valid
  private List<String> monitoredResourceUri = null;

  public SdmSubscriptionDB callbackReference(String callbackReference) {
    this.callbackReference = callbackReference;
    return this;
  }

  /**
   * Get callbackReference
   * @return callbackReference
  **/
  @ApiModelProperty(value = "")


  public String getCallbackReference() {
    return callbackReference;
  }

  public void setCallbackReference(String callbackReference) {
    this.callbackReference = callbackReference;
  }

  public SdmSubscriptionDB monitoredResourceUri(List<String> monitoredResourceUri) {
    this.monitoredResourceUri = monitoredResourceUri;
    return this;
  }

  public SdmSubscriptionDB addMonitoredResourceUriItem(String monitoredResourceUriItem) {
    if (this.monitoredResourceUri == null) {
      this.monitoredResourceUri = new ArrayList<String>();
    }
    this.monitoredResourceUri.add(monitoredResourceUriItem);
    return this;
  }

  /**
   * Get monitoredResourceUri
   * @return monitoredResourceUri
  **/
  @ApiModelProperty(value = "")


  public List<String> getMonitoredResourceUri() {
    return monitoredResourceUri;
  }

  public void setMonitoredResourceUri(List<String> monitoredResourceUri) {
    this.monitoredResourceUri = monitoredResourceUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SdmSubscriptionDB sdmSubscriptionDB = (SdmSubscriptionDB) o;
    return Objects.equals(this.callbackReference, sdmSubscriptionDB.callbackReference) &&
        Objects.equals(this.monitoredResourceUri, sdmSubscriptionDB.monitoredResourceUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackReference, monitoredResourceUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SdmSubscriptionDB {\n");
    
    sb.append("    callbackReference: ").append(toIndentedString(callbackReference)).append("\n");
    sb.append("    monitoredResourceUri: ").append(toIndentedString(monitoredResourceUri)).append("\n");
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

