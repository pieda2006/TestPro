package com.nec.corestudy.amf.CommunicationMng.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class UpfData {

    @JsonProperty("reqtype")
    private int reqType = -1;

    @JsonProperty("teid")
    private int teId = -1;

    @JsonProperty("upfipaddr")
    private String upfIpaddr = null;


    public UpfData reqType(int reqType){
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


    public UpfData teId(int teId){
        this.teId = teId;
        return this;
    }

    @ApiModelProperty(value = "")

    public int getTeId(){
        return teId;
    }

    public void setTeId(int teId){
        this.teId = teId;
    }


    public UpfData upfIpaddr(String upfIpaddr){
        this.upfIpaddr = upfIpaddr;
        return this;
    }

    @ApiModelProperty(value = "")

    public String getUpfIpaddr(){
        return upfIpaddr;
    }

    public void setUpfIpaddr(String upfIpaddr){
        this.upfIpaddr = upfIpaddr;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpfData upfData = (UpfData) o;
        return Objects.equals(this.teId, upfData.teId) &&
               Objects.equals(this.upfIpaddr,upfData.upfIpaddr);
    }


    @Override
    public int hashCode() {
        return Objects.hash(teId, upfIpaddr);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpfData {\n");
        sb.append("    reqType: ").append(toIndentedString(reqType)).append("\n");
        sb.append("    teId: ").append(toIndentedString(teId)).append("\n");
        sb.append("    upfIpaddr: ").append(toIndentedString(upfIpaddr)).append("\n");
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

