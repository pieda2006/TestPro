package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreategtpuUpf
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T20:46:03.930+09:00")

public class CreategtpuUpf   {
  @JsonProperty("dst_ip")
  private String dstIp = null;

  @JsonProperty("ue_ip")
  private String ueIp = null;

  public CreategtpuUpf dstIp(String dstIp) {
    this.dstIp = dstIp;
    return this;
  }

  /**
   * ex.)172.0.0.1
   * @return dstIp
  **/
  @ApiModelProperty(required = true, value = "ex.)172.0.0.1")
  @NotNull


  public String getDstIp() {
    return dstIp;
  }

  public void setDstIp(String dstIp) {
    this.dstIp = dstIp;
  }

  public CreategtpuUpf ueIp(String ueIp) {
    this.ueIp = ueIp;
    return this;
  }

  /**
   * ex.)172.0.0.1
   * @return ueIp
  **/
  @ApiModelProperty(required = true, value = "ex.)172.0.0.1")
  @NotNull


  public String getUeIp() {
    return ueIp;
  }

  public void setUeIp(String ueIp) {
    this.ueIp = ueIp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreategtpuUpf creategtpuUpf = (CreategtpuUpf) o;
    return Objects.equals(this.dstIp, creategtpuUpf.dstIp) &&
        Objects.equals(this.ueIp, creategtpuUpf.ueIp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dstIp, ueIp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreategtpuUpf {\n");
    
    sb.append("    dstIp: ").append(toIndentedString(dstIp)).append("\n");
    sb.append("    ueIp: ").append(toIndentedString(ueIp)).append("\n");
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

