package com.nec.corestudy.udm.NudmSDM.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets RatType
 */
public enum RatType {
  
  NR("NR"),
  
  EUTRA("EUTRA"),
  
  WLAN("WLAN"),
  
  VIRTUAL("VIRTUAL");

  private String value;

  RatType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RatType fromValue(String text) {
    for (RatType b : RatType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

