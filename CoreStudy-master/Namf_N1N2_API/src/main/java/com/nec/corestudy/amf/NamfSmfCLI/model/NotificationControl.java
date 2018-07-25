package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets NotificationControl
 */
public enum NotificationControl {
  
  REQUESTED("REQUESTED"),
  
  NOT_REQUESTED("NOT_REQUESTED");

  private String value;

  NotificationControl(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static NotificationControl fromValue(String text) {
    for (NotificationControl b : NotificationControl.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

