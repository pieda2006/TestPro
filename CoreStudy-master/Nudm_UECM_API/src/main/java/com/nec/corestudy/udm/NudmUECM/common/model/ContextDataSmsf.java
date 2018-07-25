package com.nec.corestudy.udm.NudmUECM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmUECM.common.model.SmsfRegistrationDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContextDataSmsf
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-28T19:20:18.368+09:00")

public class ContextDataSmsf   {
  @JsonProperty("smsf3GppAccessRegistration")
  private SmsfRegistrationDB smsf3GppAccessRegistration = null;

  @JsonProperty("smsfNon3GppAccessRegistration")
  private SmsfRegistrationDB smsfNon3GppAccessRegistration = null;

  public ContextDataSmsf smsf3GppAccessRegistration(SmsfRegistrationDB smsf3GppAccessRegistration) {
    this.smsf3GppAccessRegistration = smsf3GppAccessRegistration;
    return this;
  }

  /**
   * Get smsf3GppAccessRegistration
   * @return smsf3GppAccessRegistration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SmsfRegistrationDB getSmsf3GppAccessRegistration() {
    return smsf3GppAccessRegistration;
  }

  public void setSmsf3GppAccessRegistration(SmsfRegistrationDB smsf3GppAccessRegistration) {
    this.smsf3GppAccessRegistration = smsf3GppAccessRegistration;
  }

  public ContextDataSmsf smsfNon3GppAccessRegistration(SmsfRegistrationDB smsfNon3GppAccessRegistration) {
    this.smsfNon3GppAccessRegistration = smsfNon3GppAccessRegistration;
    return this;
  }

  /**
   * Get smsfNon3GppAccessRegistration
   * @return smsfNon3GppAccessRegistration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SmsfRegistrationDB getSmsfNon3GppAccessRegistration() {
    return smsfNon3GppAccessRegistration;
  }

  public void setSmsfNon3GppAccessRegistration(SmsfRegistrationDB smsfNon3GppAccessRegistration) {
    this.smsfNon3GppAccessRegistration = smsfNon3GppAccessRegistration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContextDataSmsf contextDataSmsf = (ContextDataSmsf) o;
    return Objects.equals(this.smsf3GppAccessRegistration, contextDataSmsf.smsf3GppAccessRegistration) &&
        Objects.equals(this.smsfNon3GppAccessRegistration, contextDataSmsf.smsfNon3GppAccessRegistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsf3GppAccessRegistration, smsfNon3GppAccessRegistration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextDataSmsf {\n");
    
    sb.append("    smsf3GppAccessRegistration: ").append(toIndentedString(smsf3GppAccessRegistration)).append("\n");
    sb.append("    smsfNon3GppAccessRegistration: ").append(toIndentedString(smsfNon3GppAccessRegistration)).append("\n");
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

