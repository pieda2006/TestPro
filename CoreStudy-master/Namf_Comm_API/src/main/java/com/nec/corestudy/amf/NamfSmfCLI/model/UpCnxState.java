package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets UpCnxState
 */
public enum UpCnxState {
  
  ACTIVATED("ACTIVATED"),
  
  DEACTIVATED("DEACTIVATED"),
  
  ACTIVATING("ACTIVATING");

  private String value;

  UpCnxState(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static UpCnxState fromValue(String text) {
    for (UpCnxState b : UpCnxState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

