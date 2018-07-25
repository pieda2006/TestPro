package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets RequestIndication
 */
public enum RequestIndication {
  
  UE_REQ_PDU_SES_MOD("UE_REQ_PDU_SES_MOD"),
  
  UE_REQ_PDU_SES_REL("UE_REQ_PDU_SES_REL"),
  
  PDU_SES_MOB("PDU_SES_MOB"),
  
  NW_REQ_PDU_SES_AUTH("NW_REQ_PDU_SES_AUTH"),
  
  NW_REQ_PDU_SES_MOD("NW_REQ_PDU_SES_MOD"),
  
  NW_REQ_PDU_SES_REL("NW_REQ_PDU_SES_REL");

  private String value;

  RequestIndication(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static RequestIndication fromValue(String text) {
    for (RequestIndication b : RequestIndication.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

