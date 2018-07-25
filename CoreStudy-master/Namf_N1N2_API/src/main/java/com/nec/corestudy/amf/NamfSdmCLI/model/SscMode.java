package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets SscMode
 */
public enum SscMode {
  
  _1("SSC_MODE_1"),
  
  _2("SSC_MODE_2"),
  
  _3("SSC_MODE_3");

  private String value;

  SscMode(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SscMode fromValue(String text) {
    for (SscMode b : SscMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

