package com.nec.corestudy.pcf.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;



import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;










/**
 * Possible values are - LOC_CH: Location change (tracking area)  the tracking area of the UE has changed. - PRA_CH: Change of UE presence in PRA  the UE is entering/leaving a Presence Reporting Area. - SERV_AREA_CH: Service Area Restriction change  the UDM notifies the AMF that the subscribed service area restriction information has changed. - RFSP_CH: RFSP index change  the UDM notifies the AMF that the subscribed RFSP index has changed. 
 */
@ApiModel(description = "Possible values are - LOC_CH: Location change (tracking area)  the tracking area of the UE has changed. - PRA_CH: Change of UE presence in PRA  the UE is entering/leaving a Presence Reporting Area. - SERV_AREA_CH: Service Area Restriction change  the UDM notifies the AMF that the subscribed service area restriction information has changed. - RFSP_CH: RFSP index change  the UDM notifies the AMF that the subscribed RFSP index has changed. ")
@Validated

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.SpringCodegen", date = "2018-07-20T19:29:12.075+09:00[Asia/Tokyo]")

public class RequestTrigger   {

  
  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestTrigger {\n");
    
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}




