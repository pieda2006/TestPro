package com.nec.corestudy.amf.N1N2IF_CLI.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AMFN1MessageContainer
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-22T15:33:39.136+09:00")

public class AMFN1MessageContainer   {
  /**
   * Gets or Sets n1MessageClass
   */
  public enum N1MessageClassEnum {
    _5GMM("Jamf_5GMM"),
    
    SM("Jamf_SM"),
    
    LPP("Jamf_LPP"),
    
    SMS("Jamf_SMS");

    private String value;

    N1MessageClassEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static N1MessageClassEnum fromValue(String text) {
      for (N1MessageClassEnum b : N1MessageClassEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("n1MessageClass")
  private N1MessageClassEnum n1MessageClass = null;

  @JsonProperty("n1MessageContent")
  private String n1MessageContent = null;

  public AMFN1MessageContainer n1MessageClass(N1MessageClassEnum n1MessageClass) {
    this.n1MessageClass = n1MessageClass;
    return this;
  }

  /**
   * Get n1MessageClass
   * @return n1MessageClass
  **/
  @ApiModelProperty(required = true, value = "")
  public N1MessageClassEnum getN1MessageClass() {
    return n1MessageClass;
  }

  public void setN1MessageClass(N1MessageClassEnum n1MessageClass) {
    this.n1MessageClass = n1MessageClass;
  }

  public AMFN1MessageContainer n1MessageContent(String n1MessageContent) {
    this.n1MessageContent = n1MessageContent;
    return this;
  }

  /**
   * N1 Message shall encode a 5GS NAS message
   * @return n1MessageContent
  **/
  @ApiModelProperty(required = true, value = "N1 Message shall encode a 5GS NAS message")
  public String getN1MessageContent() {
    return n1MessageContent;
  }

  public void setN1MessageContent(String n1MessageContent) {
    this.n1MessageContent = n1MessageContent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFN1MessageContainer amFN1MessageContainer = (AMFN1MessageContainer) o;
    return Objects.equals(this.n1MessageClass, amFN1MessageContainer.n1MessageClass) &&
        Objects.equals(this.n1MessageContent, amFN1MessageContainer.n1MessageContent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(n1MessageClass, n1MessageContent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFN1MessageContainer {\n");
    
    sb.append("    n1MessageClass: ").append(toIndentedString(n1MessageClass)).append("\n");
    sb.append("    n1MessageContent: ").append(toIndentedString(n1MessageContent)).append("\n");
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

