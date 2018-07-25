package com.nec.corestudy.amf.NamfSmfCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ReflectiveQosAttribute
 */
public enum ReflectiveQosAttribute {
  
  RQOS("RQOS"),
  
  NO_RQOS("NO_RQOS");

  private String value;

  ReflectiveQosAttribute(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ReflectiveQosAttribute fromValue(String text) {
    for (ReflectiveQosAttribute b : ReflectiveQosAttribute.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

