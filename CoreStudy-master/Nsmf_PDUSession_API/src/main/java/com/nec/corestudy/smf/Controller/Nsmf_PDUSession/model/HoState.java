package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets HoState
 */
public enum HoState {
  
  NONE("NONE"),
  
  PREPARING("PREPARING"),
  
  PREPARED("PREPARED"),
  
  COMPLETED("COMPLETED"),
  
  CANCELLED("CANCELLED");

  private String value;

  HoState(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static HoState fromValue(String text) {
    for (HoState b : HoState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

