package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets RequestType
 */
public enum RequestType {
  
  INITIAL_REQUEST("INITIAL_REQUEST"),
  
  EXISTING_PDU_SESSION("EXISTING_PDU_SESSION"),
  
  INITIAL_EMERGENCY_REQUEST("INITIAL_EMERGENCY_REQUEST"),
  
  EXISTING_EMERGENCY_PDU_SESSION("EXISTING_EMERGENCY_PDU_SESSION");

  private String value;

  RequestType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RequestType fromValue(String text) {
    for (RequestType b : RequestType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
