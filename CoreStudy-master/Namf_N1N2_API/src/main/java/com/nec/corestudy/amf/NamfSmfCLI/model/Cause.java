package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Cause
 */
public enum Cause {
  
  REL_DUE_TO_HO("REL_DUE_TO_HO"),
  
  EPS_FALLBACK("EPS_FALLBACK");

  private String value;

  Cause(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Cause fromValue(String text) {
    for (Cause b : Cause.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

