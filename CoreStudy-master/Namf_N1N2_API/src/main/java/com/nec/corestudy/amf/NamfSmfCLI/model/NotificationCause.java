package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets NotificationCause
 */
public enum NotificationCause {
  
  FULFILLED("QOS_FULFILLED"),
  
  NOT_FULFILLED("QOS_NOT_FULFILLED");

  private String value;

  NotificationCause(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static NotificationCause fromValue(String text) {
    for (NotificationCause b : NotificationCause.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

