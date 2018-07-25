package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets PduSessionType
 */
public enum PduSessionType {
  
  IP("IP"),
  
  IPV4("IPV4"),
  
  IPV6("IPV6"),
  
  UNSTRUCT("UNSTRUCT"),
  
  ETHERNET("ETHERNET");

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

