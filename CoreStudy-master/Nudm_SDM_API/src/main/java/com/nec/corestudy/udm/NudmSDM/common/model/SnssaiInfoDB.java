package com.nec.corestudy.udm.NudmSDM.common.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nec.corestudy.udm.NudmSDM.common.model.DnnInfoDB;
import com.nec.corestudy.udm.NudmSDM.common.model.SnssaiDB;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SnssaiInfoDB
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-30T18:27:17.699+09:00")

public class SnssaiInfoDB   {
  @JsonProperty("singleNssai")
  private SnssaiDB singleNssai = null;

  @JsonProperty("dnnInfos")
  @Valid
  private List<DnnInfoDB> dnnInfos = new ArrayList<DnnInfoDB>();

  public SnssaiInfoDB singleNssai(SnssaiDB singleNssai) {
    this.singleNssai = singleNssai;
    return this;
  }

  /**
   * Get singleNssai
   * @return singleNssai
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SnssaiDB getSingleNssai() {
    return singleNssai;
  }

  public void setSingleNssai(SnssaiDB singleNssai) {
    this.singleNssai = singleNssai;
  }

  public SnssaiInfoDB dnnInfos(List<DnnInfoDB> dnnInfos) {
    this.dnnInfos = dnnInfos;
    return this;
  }

  public SnssaiInfoDB addDnnInfosItem(DnnInfoDB dnnInfosItem) {
    this.dnnInfos.add(dnnInfosItem);
    return this;
  }

  /**
   * Get dnnInfos
   * @return dnnInfos
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<DnnInfoDB> getDnnInfos() {
    return dnnInfos;
  }

  public void setDnnInfos(List<DnnInfoDB> dnnInfos) {
    this.dnnInfos = dnnInfos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnssaiInfoDB snssaiInfoDB = (SnssaiInfoDB) o;
    return Objects.equals(this.singleNssai, snssaiInfoDB.singleNssai) &&
        Objects.equals(this.dnnInfos, snssaiInfoDB.dnnInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(singleNssai, dnnInfos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnssaiInfoDB {\n");
    
    sb.append("    singleNssai: ").append(toIndentedString(singleNssai)).append("\n");
    sb.append("    dnnInfos: ").append(toIndentedString(dnnInfos)).append("\n");
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

