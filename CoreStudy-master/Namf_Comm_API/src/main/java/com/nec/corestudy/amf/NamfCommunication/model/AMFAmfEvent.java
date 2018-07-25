package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAmfEventArea;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAmfEventMode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFAmfEvent
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAmfEvent   {
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    LOCATION_REPORT("Jamf_LOCATION_REPORT"),
    
    PRESENCE_IN_AOI_REPORT("Jamf_PRESENCE_IN_AOI_REPORT"),
    
    TIMEZONE_REPORT("Jamf_TIMEZONE_REPORT"),
    
    ACCESS_TYPE_REPORT("Jamf_ACCESS_TYPE_REPORT"),
    
    REGISTRATION_STATE_REPORT("Jamf_REGISTRATION_STATE_REPORT"),
    
    CONNECTIVITY_STATE_REPORT("Jamf_CONNECTIVITY_STATE_REPORT"),
    
    REACHABILITY_REPORT("Jamf_REACHABILITY_REPORT"),
    
    SUBSCRIBED_DATA_REPORT("Jamf_SUBSCRIBED_DATA_REPORT"),
    
    COMMIUNICATION_FAILURE_REPORT("Jamf_COMMIUNICATION_FAILURE_REPORT"),
    
    UES_IN_AREA_REPORT("Jamf_UES_IN_AREA_REPORT");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("options")
  private AMFAmfEventMode options = null;

  @JsonProperty("immediateFlag")
  private Boolean immediateFlag = null;

  @JsonProperty("area")
  @Valid
  private List<AMFAmfEventArea> area = null;

  /**
   * Gets or Sets locationFilters
   */
  public enum LocationFiltersEnum {
    TAI("Jamf_TAI"),
    
    CELL_ID("Jamf_CELL_ID"),
    
    N3IWF("Jamf_N3IWF"),
    
    UE_IP("Jamf_UE_IP"),
    
    UDP_PORT("Jamf_UDP_PORT");

    private String value;

    LocationFiltersEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LocationFiltersEnum fromValue(String text) {
      for (LocationFiltersEnum b : LocationFiltersEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("locationFilters")
  @Valid
  private List<LocationFiltersEnum> locationFilters = null;

  /**
   * Gets or Sets subscribedDataFilters
   */
  public enum SubscribedDataFiltersEnum {
    SARI("Jamf_SARI"),
    
    RFSP_INDEX("Jamf_RFSP_INDEX");

    private String value;

    SubscribedDataFiltersEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SubscribedDataFiltersEnum fromValue(String text) {
      for (SubscribedDataFiltersEnum b : SubscribedDataFiltersEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("subscribedDataFilters")
  @Valid
  private List<SubscribedDataFiltersEnum> subscribedDataFilters = null;

  public AMFAmfEvent type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public AMFAmfEvent options(AMFAmfEventMode options) {
    this.options = options;
    return this;
  }

  /**
   * Get options
   * @return options
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public AMFAmfEventMode getOptions() {
    return options;
  }

  public void setOptions(AMFAmfEventMode options) {
    this.options = options;
  }

  public AMFAmfEvent immediateFlag(Boolean immediateFlag) {
    this.immediateFlag = immediateFlag;
    return this;
  }

  /**
   * Get immediateFlag
   * @return immediateFlag
  **/
  @ApiModelProperty(value = "")


  public Boolean isImmediateFlag() {
    return immediateFlag;
  }

  public void setImmediateFlag(Boolean immediateFlag) {
    this.immediateFlag = immediateFlag;
  }

  public AMFAmfEvent area(List<AMFAmfEventArea> area) {
    this.area = area;
    return this;
  }

  public AMFAmfEvent addAreaItem(AMFAmfEventArea areaItem) {
    if (this.area == null) {
      this.area = new ArrayList<AMFAmfEventArea>();
    }
    this.area.add(areaItem);
    return this;
  }

  /**
   * Get area
   * @return area
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AMFAmfEventArea> getArea() {
    return area;
  }

  public void setArea(List<AMFAmfEventArea> area) {
    this.area = area;
  }

  public AMFAmfEvent locationFilters(List<LocationFiltersEnum> locationFilters) {
    this.locationFilters = locationFilters;
    return this;
  }

  public AMFAmfEvent addLocationFiltersItem(LocationFiltersEnum locationFiltersItem) {
    if (this.locationFilters == null) {
      this.locationFilters = new ArrayList<LocationFiltersEnum>();
    }
    this.locationFilters.add(locationFiltersItem);
    return this;
  }

  /**
   * Get locationFilters
   * @return locationFilters
  **/
  @ApiModelProperty(value = "")


  public List<LocationFiltersEnum> getLocationFilters() {
    return locationFilters;
  }

  public void setLocationFilters(List<LocationFiltersEnum> locationFilters) {
    this.locationFilters = locationFilters;
  }

  public AMFAmfEvent subscribedDataFilters(List<SubscribedDataFiltersEnum> subscribedDataFilters) {
    this.subscribedDataFilters = subscribedDataFilters;
    return this;
  }

  public AMFAmfEvent addSubscribedDataFiltersItem(SubscribedDataFiltersEnum subscribedDataFiltersItem) {
    if (this.subscribedDataFilters == null) {
      this.subscribedDataFilters = new ArrayList<SubscribedDataFiltersEnum>();
    }
    this.subscribedDataFilters.add(subscribedDataFiltersItem);
    return this;
  }

  /**
   * Get subscribedDataFilters
   * @return subscribedDataFilters
  **/
  @ApiModelProperty(value = "")


  public List<SubscribedDataFiltersEnum> getSubscribedDataFilters() {
    return subscribedDataFilters;
  }

  public void setSubscribedDataFilters(List<SubscribedDataFiltersEnum> subscribedDataFilters) {
    this.subscribedDataFilters = subscribedDataFilters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAmfEvent amFAmfEvent = (AMFAmfEvent) o;
    return Objects.equals(this.type, amFAmfEvent.type) &&
        Objects.equals(this.options, amFAmfEvent.options) &&
        Objects.equals(this.immediateFlag, amFAmfEvent.immediateFlag) &&
        Objects.equals(this.area, amFAmfEvent.area) &&
        Objects.equals(this.locationFilters, amFAmfEvent.locationFilters) &&
        Objects.equals(this.subscribedDataFilters, amFAmfEvent.subscribedDataFilters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, options, immediateFlag, area, locationFilters, subscribedDataFilters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAmfEvent {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    immediateFlag: ").append(toIndentedString(immediateFlag)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    locationFilters: ").append(toIndentedString(locationFilters)).append("\n");
    sb.append("    subscribedDataFilters: ").append(toIndentedString(subscribedDataFilters)).append("\n");
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

