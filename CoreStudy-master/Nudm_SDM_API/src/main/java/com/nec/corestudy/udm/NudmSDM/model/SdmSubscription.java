package com.nec.corestudy.udm.NudmSDM.model;

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
 * SdmSubscription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class SdmSubscription   {
  @JsonProperty("callbackReference")
  private String callbackReference = null;

  @JsonProperty("monitoredResourceUri")
  @Valid
  private List<String> monitoredResourceUri = new ArrayList<String>();

  public SdmSubscription callbackReference(String callbackReference) {
    this.callbackReference = callbackReference;
    return this;
  }

  /**
   * Get callbackReference
   * @return callbackReference
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCallbackReference() {
    return callbackReference;
  }

  public void setCallbackReference(String callbackReference) {
    this.callbackReference = callbackReference;
  }

  public SdmSubscription monitoredResourceUri(List<String> monitoredResourceUri) {
    this.monitoredResourceUri = monitoredResourceUri;
    return this;
  }

  public SdmSubscription addMonitoredResourceUriItem(String monitoredResourceUriItem) {
    this.monitoredResourceUri.add(monitoredResourceUriItem);
    return this;
  }

  /**
   * Get monitoredResourceUri
   * @return monitoredResourceUri
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


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
    SdmSubscription sdmSubscription = (SdmSubscription) o;
    return Objects.equals(this.callbackReference, sdmSubscription.callbackReference) &&
        Objects.equals(this.monitoredResourceUri, sdmSubscription.monitoredResourceUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackReference, monitoredResourceUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SdmSubscription {\n");
    
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

