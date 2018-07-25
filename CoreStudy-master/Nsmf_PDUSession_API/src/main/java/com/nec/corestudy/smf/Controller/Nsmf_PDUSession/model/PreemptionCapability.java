package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

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

