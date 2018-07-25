package com.nec.corestudy.udm.NudmUECM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmUECM.common.model.Amf3GppAccessRegistrationDB;
import com.nec.corestudy.udm.NudmUECM.common.model.AmfNon3GppAccessRegistrationDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContextDataAmf
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-28T19:20:18.368+09:00")

public class ContextDataAmf   {
  @JsonProperty("amf3GppAccessRegistration")
  private Amf3GppAccessRegistrationDB amf3GppAccessRegistration = null;

  @JsonProperty("amfNon3GppAccessRegistration")
  private AmfNon3GppAccessRegistrationDB amfNon3GppAccessRegistration = null;

  public ContextDataAmf amf3GppAccessRegistration(Amf3GppAccessRegistrationDB amf3GppAccessRegistration) {
    this.amf3GppAccessRegistration = amf3GppAccessRegistration;
    return this;
  }

  /**
   * Get amf3GppAccessRegistration
   * @return amf3GppAccessRegistration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Amf3GppAccessRegistrationDB getAmf3GppAccessRegistration() {
    return amf3GppAccessRegistration;
  }

  public void setAmf3GppAccessRegistration(Amf3GppAccessRegistrationDB amf3GppAccessRegistration) {
    this.amf3GppAccessRegistration = amf3GppAccessRegistration;
  }

  public ContextDataAmf amfNon3GppAccessRegistration(AmfNon3GppAccessRegistrationDB amfNon3GppAccessRegistration) {
    this.amfNon3GppAccessRegistration = amfNon3GppAccessRegistration;
    return this;
  }

  /**
   * Get amfNon3GppAccessRegistration
   * @return amfNon3GppAccessRegistration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AmfNon3GppAccessRegistrationDB getAmfNon3GppAccessRegistration() {
    return amfNon3GppAccessRegistration;
  }

  public void setAmfNon3GppAccessRegistration(AmfNon3GppAccessRegistrationDB amfNon3GppAccessRegistration) {
    this.amfNon3GppAccessRegistration = amfNon3GppAccessRegistration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContextDataAmf contextDataAmf = (ContextDataAmf) o;
    return Objects.equals(this.amf3GppAccessRegistration, contextDataAmf.amf3GppAccessRegistration) &&
        Objects.equals(this.amfNon3GppAccessRegistration, contextDataAmf.amfNon3GppAccessRegistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amf3GppAccessRegistration, amfNon3GppAccessRegistration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextDataAmf {\n");
    
    sb.append("    amf3GppAccessRegistration: ").append(toIndentedString(amf3GppAccessRegistration)).append("\n");
    sb.append("    amfNon3GppAccessRegistration: ").append(toIndentedString(amfNon3GppAccessRegistration)).append("\n");
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

