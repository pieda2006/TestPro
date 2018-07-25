package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets DelayCritical
 */
public enum DelayCritical {
  
  CRITICAL("CRITICAL"),
  
  NON_CRITICAL("NON_CRITICAL");

  private String value;

  DelayCritical(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DelayCritical fromValue(String text) {
    for (DelayCritical b : DelayCritical.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

