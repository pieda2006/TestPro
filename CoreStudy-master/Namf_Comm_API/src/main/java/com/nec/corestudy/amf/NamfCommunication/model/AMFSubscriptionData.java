package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFGuami;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFSubscriptionData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFSubscriptionData   {
  @JsonProperty("amfStatusUri")
  private String amfStatusUri = null;

  @JsonProperty("guamis")
  private AMFGuami guamis = null;

  public AMFSubscriptionData amfStatusUri(String amfStatusUri) {
    this.amfStatusUri = amfStatusUri;
    return this;
  }

  /**
   * Get amfStatusUri
   * @return amfStatusUri
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAmfStatusUri() {
    return amfStatusUri;
  }

  public void setAmfStatusUri(String amfStatusUri) {
    this.amfStatusUri = amfStatusUri;
  }

  public AMFSubscriptionData guamis(AMFGuami guamis) {
    this.guamis = guamis;
    return this;
  }

  /**
   * Get guamis
   * @return guamis
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFGuami getGuamis() {
    return guamis;
  }

  public void setGuamis(AMFGuami guamis) {
    this.guamis = guamis;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFSubscriptionData amFSubscriptionData = (AMFSubscriptionData) o;
    return Objects.equals(this.amfStatusUri, amFSubscriptionData.amfStatusUri) &&
        Objects.equals(this.guamis, amFSubscriptionData.guamis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amfStatusUri, guamis);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFSubscriptionData {\n");
    
    sb.append("    amfStatusUri: ").append(toIndentedString(amfStatusUri)).append("\n");
    sb.append("    guamis: ").append(toIndentedString(guamis)).append("\n");
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

