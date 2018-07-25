package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFNasSecurityMode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFNasSecurityMode   {
  /**
   * Gets or Sets integrityAlgorithm
   */
  public enum IntegrityAlgorithmEnum {
    NIA0("Jamf_NIA0"),
    
    NIA1("Jamf_NIA1"),
    
    NIA2("Jamf_NIA2"),
    
    NIA3("Jamf_NIA3");

    private String value;

    IntegrityAlgorithmEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IntegrityAlgorithmEnum fromValue(String text) {
      for (IntegrityAlgorithmEnum b : IntegrityAlgorithmEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("integrityAlgorithm")
  private IntegrityAlgorithmEnum integrityAlgorithm = null;

  /**
   * Gets or Sets cipheringAlgorithm
   */
  public enum CipheringAlgorithmEnum {
    NEA0("Jamf_NEA0"),
    
    NEA1("Jamf_NEA1"),
    
    NEA2("Jamf_NEA2"),
    
    NEA3("Jamf_NEA3");

    private String value;

    CipheringAlgorithmEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CipheringAlgorithmEnum fromValue(String text) {
      for (CipheringAlgorithmEnum b : CipheringAlgorithmEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("cipheringAlgorithm")
  private CipheringAlgorithmEnum cipheringAlgorithm = null;

  public AMFNasSecurityMode integrityAlgorithm(IntegrityAlgorithmEnum integrityAlgorithm) {
    this.integrityAlgorithm = integrityAlgorithm;
    return this;
  }

  /**
   * Get integrityAlgorithm
   * @return integrityAlgorithm
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public IntegrityAlgorithmEnum getIntegrityAlgorithm() {
    return integrityAlgorithm;
  }

  public void setIntegrityAlgorithm(IntegrityAlgorithmEnum integrityAlgorithm) {
    this.integrityAlgorithm = integrityAlgorithm;
  }

  public AMFNasSecurityMode cipheringAlgorithm(CipheringAlgorithmEnum cipheringAlgorithm) {
    this.cipheringAlgorithm = cipheringAlgorithm;
    return this;
  }

  /**
   * Get cipheringAlgorithm
   * @return cipheringAlgorithm
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public CipheringAlgorithmEnum getCipheringAlgorithm() {
    return cipheringAlgorithm;
  }

  public void setCipheringAlgorithm(CipheringAlgorithmEnum cipheringAlgorithm) {
    this.cipheringAlgorithm = cipheringAlgorithm;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFNasSecurityMode amFNasSecurityMode = (AMFNasSecurityMode) o;
    return Objects.equals(this.integrityAlgorithm, amFNasSecurityMode.integrityAlgorithm) &&
        Objects.equals(this.cipheringAlgorithm, amFNasSecurityMode.cipheringAlgorithm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(integrityAlgorithm, cipheringAlgorithm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFNasSecurityMode {\n");
    
    sb.append("    integrityAlgorithm: ").append(toIndentedString(integrityAlgorithm)).append("\n");
    sb.append("    cipheringAlgorithm: ").append(toIndentedString(cipheringAlgorithm)).append("\n");
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

