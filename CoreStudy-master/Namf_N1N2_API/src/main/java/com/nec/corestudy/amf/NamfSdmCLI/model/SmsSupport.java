package com.nec.corestudy.amf.NamfSdmCLI.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets SmsSupport
 */
public enum SmsSupport {
  
  _3GPP("SMS_3GPP"),
  
  NON_3GPP("SMS_NON_3GPP"),
  
  _3GPP_AND_NON_3GPP("SMS_3GPP_AND_NON_3GPP");

  private String value;

  SmsSupport(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SmsSupport fromValue(String text) {
    for (SmsSupport b : SmsSupport.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

