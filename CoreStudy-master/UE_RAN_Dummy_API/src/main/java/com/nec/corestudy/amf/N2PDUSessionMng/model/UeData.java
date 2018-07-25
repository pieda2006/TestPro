package com.nec.corestudy.amf.N2PDUSessionMng.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class UeData {

    @JsonProperty("reqtype")
    private int reqType = -1;

    @JsonProperty("ueipaddr")
    private String ueIpaddr = null;

    @JsonProperty("uegw")
    private String ueGw = null;

    public UeData reqType(int reqType){
        this.reqType = reqType;
        return this;
    }

    @ApiModelProperty(value = "")

    public int getReqType(){
        return reqType;
    }

    public void setReqType(int reqType){
        this.reqType = reqType;
    }

    public UeData ueIpaddr(String ueIpaddr){
        this.ueIpaddr = ueIpaddr;
        return this;
    }

    @ApiModelProperty(value = "")

    public String getUeIpaddr(){
        return ueIpaddr;
    }

    public void setUeIpaddr(String ueIpaddr){
        this.ueIpaddr = ueIpaddr;
    }

    public UeData ueGw(String ueGw){
        this.ueGw = ueGw;
        return this;
    }


    @ApiModelProperty(value = "")

    public String getUeGw(){
        return ueGw;
    }

    public void setUeGw(String ueGw){
        this.ueGw = ueGw;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UeData ueData = (UeData) o;
        return Objects.equals(this.ueIpaddr, ueData.ueIpaddr) &&
               Objects.equals(this.ueGw, ueData.ueGw);
    }


    @Override
    public int hashCode() {
        return Objects.hash(ueIpaddr,ueGw);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UeData {\n");
        sb.append("    reqType: ").append(toIndentedString(reqType)).append("\n");
        sb.append("    ueIpaddr: ").append(toIndentedString(ueIpaddr)).append("\n");
        sb.append("    ueGw: ").append(toIndentedString(ueGw)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

