package com.nec.corestudy.udm.NudmUECM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmUECM.common.model.SmfRegistrationDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContextDataSmf
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-28T19:20:18.368+09:00")

public class ContextDataSmf   {
  @JsonProperty("smfRegistration")
  private SmfRegistrationDB smfRegistration = null;

  public ContextDataSmf smfRegistration(SmfRegistrationDB smfRegistration) {
    this.smfRegistration = smfRegistration;
    return this;
  }

  /**
   * Get smfRegistration
   * @return smfRegistration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SmfRegistrationDB getSmfRegistration() {
    return smfRegistration;
  }

  public void setSmfRegistration(SmfRegistrationDB smfRegistration) {
    this.smfRegistration = smfRegistration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContextDataSmf contextDataSmf = (ContextDataSmf) o;
    return Objects.equals(this.smfRegistration, contextDataSmf.smfRegistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smfRegistration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextDataSmf {\n");
    
    sb.append("    smfRegistration: ").append(toIndentedString(smfRegistration)).append("\n");
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

