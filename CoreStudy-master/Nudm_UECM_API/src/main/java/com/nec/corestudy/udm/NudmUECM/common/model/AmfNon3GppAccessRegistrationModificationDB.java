package com.nec.corestudy.udm.NudmUECM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AmfNon3GppAccessRegistrationModificationDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-28T19:20:18.368+09:00")

public class AmfNon3GppAccessRegistrationModificationDB   {
  @JsonProperty("purgeFlag")
  private Boolean purgeFlag = null;

  @JsonProperty("pei")
  private String pei = null;

  public AmfNon3GppAccessRegistrationModificationDB purgeFlag(Boolean purgeFlag) {
    this.purgeFlag = purgeFlag;
    return this;
  }

  /**
   * Get purgeFlag
   * @return purgeFlag
  **/
  @ApiModelProperty(value = "")


  public Boolean isPurgeFlag() {
    return purgeFlag;
  }

  public void setPurgeFlag(Boolean purgeFlag) {
    this.purgeFlag = purgeFlag;
  }

  public AmfNon3GppAccessRegistrationModificationDB pei(String pei) {
    this.pei = pei;
    return this;
  }

  /**
   * Get pei
   * @return pei
  **/
  @ApiModelProperty(value = "")


  public String getPei() {
    return pei;
  }

  public void setPei(String pei) {
    this.pei = pei;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmfNon3GppAccessRegistrationModificationDB amfNon3GppAccessRegistrationModificationDB = (AmfNon3GppAccessRegistrationModificationDB) o;
    return Objects.equals(this.purgeFlag, amfNon3GppAccessRegistrationModificationDB.purgeFlag) &&
        Objects.equals(this.pei, amfNon3GppAccessRegistrationModificationDB.pei);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purgeFlag, pei);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmfNon3GppAccessRegistrationModificationDB {\n");
    
    sb.append("    purgeFlag: ").append(toIndentedString(purgeFlag)).append("\n");
    sb.append("    pei: ").append(toIndentedString(pei)).append("\n");
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

