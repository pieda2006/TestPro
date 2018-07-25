package com.nec.corestudy.amf.NamfCommunication.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.amf.NamfCommunication.model.AMFTai;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AMFAreaOfValidity
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

public class AMFAreaOfValidity   {
  @JsonProperty("taList")
  @Valid
  private List<AMFTai> taList = new ArrayList<AMFTai>();

  public AMFAreaOfValidity taList(List<AMFTai> taList) {
    this.taList = taList;
    return this;
  }

  public AMFAreaOfValidity addTaListItem(AMFTai taListItem) {
    this.taList.add(taListItem);
    return this;
  }

  /**
   * Get taList
   * @return taList
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<AMFTai> getTaList() {
    return taList;
  }

  public void setTaList(List<AMFTai> taList) {
    this.taList = taList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AMFAreaOfValidity amFAreaOfValidity = (AMFAreaOfValidity) o;
    return Objects.equals(this.taList, amFAreaOfValidity.taList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AMFAreaOfValidity {\n");
    
    sb.append("    taList: ").append(toIndentedString(taList)).append("\n");
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

