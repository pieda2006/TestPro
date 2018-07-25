package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PduSessionTypes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

public class PduSessionTypes   {
  /**
   * Gets or Sets defaultSessionType
   */
  public enum DefaultSessionTypeEnum {
    IPV4V6("IPV4V6"),
    
    IPV4("IPV4"),
    
    IPV6("IPV6"),
    
    UNSTR("UNSTR"),
    
    ETHER("ETHER");

    private String value;

    DefaultSessionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DefaultSessionTypeEnum fromValue(String text) {
      for (DefaultSessionTypeEnum b : DefaultSessionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("defaultSessionType")
  private DefaultSessionTypeEnum defaultSessionType = null;

  /**
   * Gets or Sets allowedSessionType
   */
  public enum AllowedSessionTypeEnum {
    IPV4V6("IPV4V6"),
    
    IPV4("IPV4"),
    
    IPV6("IPV6"),
    
    UNSTR("UNSTR"),
    
    ETHER("ETHER");

    private String value;

    AllowedSessionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AllowedSessionTypeEnum fromValue(String text) {
      for (AllowedSessionTypeEnum b : AllowedSessionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("allowedSessionType")
  @Valid
  private List<AllowedSessionTypeEnum> allowedSessionType = null;

  public PduSessionTypes defaultSessionType(DefaultSessionTypeEnum defaultSessionType) {
    this.defaultSessionType = defaultSessionType;
    return this;
  }

  /**
   * Get defaultSessionType
   * @return defaultSessionType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public DefaultSessionTypeEnum getDefaultSessionType() {
    return defaultSessionType;
  }

  public void setDefaultSessionType(DefaultSessionTypeEnum defaultSessionType) {
    this.defaultSessionType = defaultSessionType;
  }

  public PduSessionTypes allowedSessionType(List<AllowedSessionTypeEnum> allowedSessionType) {
    this.allowedSessionType = allowedSessionType;
    return this;
  }

  public PduSessionTypes addAllowedSessionTypeItem(AllowedSessionTypeEnum allowedSessionTypeItem) {
    if (this.allowedSessionType == null) {
      this.allowedSessionType = new ArrayList<AllowedSessionTypeEnum>();
    }
    this.allowedSessionType.add(allowedSessionTypeItem);
    return this;
  }

  /**
   * Get allowedSessionType
   * @return allowedSessionType
  **/
  @ApiModelProperty(value = "")


  public List<AllowedSessionTypeEnum> getAllowedSessionType() {
    return allowedSessionType;
  }

  public void setAllowedSessionType(List<AllowedSessionTypeEnum> allowedSessionType) {
    this.allowedSessionType = allowedSessionType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PduSessionTypes pduSessionTypes = (PduSessionTypes) o;
    return Objects.equals(this.defaultSessionType, pduSessionTypes.defaultSessionType) &&
        Objects.equals(this.allowedSessionType, pduSessionTypes.allowedSessionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultSessionType, allowedSessionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PduSessionTypes {\n");
    
    sb.append("    defaultSessionType: ").append(toIndentedString(defaultSessionType)).append("\n");
    sb.append("    allowedSessionType: ").append(toIndentedString(allowedSessionType)).append("\n");
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

