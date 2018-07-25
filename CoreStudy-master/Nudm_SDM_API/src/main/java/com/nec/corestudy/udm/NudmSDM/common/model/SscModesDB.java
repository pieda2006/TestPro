package com.nec.corestudy.udm.NudmSDM.common.model;

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
 * SscModesDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SscModesDB   {
  /**
   * Gets or Sets defaultSscMode
   */
  public enum DefaultSscModeEnum {
    _1("SSC_MODE_1"),
    
    _2("SSC_MODE_2"),
    
    _3("SSC_MODE_3");

    private String value;

    DefaultSscModeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DefaultSscModeEnum fromValue(String text) {
      for (DefaultSscModeEnum b : DefaultSscModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("defaultSscMode")
  private DefaultSscModeEnum defaultSscMode = null;

  /**
   * Gets or Sets allowedSscMode
   */
  public enum AllowedSscModeEnum {
    _1("SSC_MODE_1"),
    
    _2("SSC_MODE_2"),
    
    _3("SSC_MODE_3");

    private String value;

    AllowedSscModeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AllowedSscModeEnum fromValue(String text) {
      for (AllowedSscModeEnum b : AllowedSscModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("allowedSscMode")
  @Valid
  private List<AllowedSscModeEnum> allowedSscMode = null;

  public SscModesDB defaultSscMode(DefaultSscModeEnum defaultSscMode) {
    this.defaultSscMode = defaultSscMode;
    return this;
  }

  /**
   * Get defaultSscMode
   * @return defaultSscMode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public DefaultSscModeEnum getDefaultSscMode() {
    return defaultSscMode;
  }

  public void setDefaultSscMode(DefaultSscModeEnum defaultSscMode) {
    this.defaultSscMode = defaultSscMode;
  }

  public SscModesDB allowedSscMode(List<AllowedSscModeEnum> allowedSscMode) {
    this.allowedSscMode = allowedSscMode;
    return this;
  }

  public SscModesDB addAllowedSscModeItem(AllowedSscModeEnum allowedSscModeItem) {
    if (this.allowedSscMode == null) {
      this.allowedSscMode = new ArrayList<AllowedSscModeEnum>();
    }
    this.allowedSscMode.add(allowedSscModeItem);
    return this;
  }

  /**
   * Get allowedSscMode
   * @return allowedSscMode
  **/
  @ApiModelProperty(value = "")


  public List<AllowedSscModeEnum> getAllowedSscMode() {
    return allowedSscMode;
  }

  public void setAllowedSscMode(List<AllowedSscModeEnum> allowedSscMode) {
    this.allowedSscMode = allowedSscMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SscModesDB sscModesDB = (SscModesDB) o;
    return Objects.equals(this.defaultSscMode, sscModesDB.defaultSscMode) &&
        Objects.equals(this.allowedSscMode, sscModesDB.allowedSscMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultSscMode, allowedSscMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SscModesDB {\n");
    
    sb.append("    defaultSscMode: ").append(toIndentedString(defaultSscMode)).append("\n");
    sb.append("    allowedSscMode: ").append(toIndentedString(allowedSscMode)).append("\n");
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

