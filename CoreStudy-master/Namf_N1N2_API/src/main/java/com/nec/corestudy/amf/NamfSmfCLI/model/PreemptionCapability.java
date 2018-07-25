package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets PreemptionCapability
 */
public enum PreemptionCapability {
  
  NOT_PREEMPT("NOT_PREEMPT"),
  
  MAY_PREEMPT("MAY_PREEMPT");

  private String value;

  PreemptionCapability(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PreemptionCapability fromValue(String text) {
    for (PreemptionCapability b : PreemptionCapability.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

