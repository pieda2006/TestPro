package com.nec.corestudy.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










import com.fasterxml.jackson.annotation.JsonCreator;


/**
 * Gets or Sets AccessType
 */
public enum AccessType {
  
  
  
  _3GPP_ACCESS("3GPP_ACCESS"),
  
  NON_3GPP_ACCESS("NON_3GPP_ACCESS");
  

  private String value;

  AccessType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccessType fromValue(String text) {
    for (AccessType b : AccessType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}





