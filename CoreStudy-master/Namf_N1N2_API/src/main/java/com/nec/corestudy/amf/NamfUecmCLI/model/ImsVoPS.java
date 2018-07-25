package com.nec.corestudy.amf.NamfUecmCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ImsVoPS
 */
public enum ImsVoPS {
  
  HOMOGENEOUS_SUPPORT("HOMOGENEOUS_SUPPORT"),
  
  HOMOGENEOUS_NON_SUPPORT("HOMOGENEOUS_NON_SUPPORT"),
  
  NON_HOMOGENEOUS_OR_UNKNOWN("NON_HOMOGENEOUS_OR_UNKNOWN");

  private String value;

  ImsVoPS(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ImsVoPS fromValue(String text) {
    for (ImsVoPS b : ImsVoPS.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

