package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets RestrictionType
 */
public enum RestrictionType {
  
  SAR_ALLOWED_AREA("SAR_ALLOWED_AREA"),
  
  SAR_NOT_ALLOWED_AREA("SAR_NOT_ALLOWED_AREA"),
  
  FORBIDDEN_AREA("FORBIDDEN_AREA");

  private String value;

  RestrictionType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RestrictionType fromValue(String text) {
    for (RestrictionType b : RestrictionType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

