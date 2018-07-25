package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets PduSessionType
 */
public enum PduSessionType {
  
  IPV4V6("IPV4V6"),
  
  IPV4("IPV4"),
  
  IPV6("IPV6"),
  
  UNSTR("UNSTR"),
  
  ETHER("ETHER");

  private String value;

  PduSessionType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PduSessionType fromValue(String text) {
    for (PduSessionType b : PduSessionType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

