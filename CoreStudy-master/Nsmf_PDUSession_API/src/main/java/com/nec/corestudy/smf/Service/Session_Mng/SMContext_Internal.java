package com.nec.corestudy.smf.Service.Session_Mng;

import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SingleNssai;
import com.nec.corestudy.smf.Service.IP_Mng.AllocateIPinfo;


public class SMContext_Internal {

    private String supi;
    private int PDUSessionID;
    private String DNN;
    private SingleNssai sNssai;
    private String UP_gNodeB_IP;

    private AllocateIPinfo UeipInfo;


    /* supi */
    public String getSupi() {
      return supi;
    }

    public void setSupi(String supi) {
      this.supi = supi;
    }

    /* PDUSessionID */
    public int getPDUSessionID() {
      return PDUSessionID;
    }

    public void setPDUSessionID(int PDUSessionID) {
      this.PDUSessionID = PDUSessionID;
    }

    /* DNN */
    public String getDNN() {
      return DNN;
    }

    public void setDNN(String DNN) {
      this.DNN = DNN;
    }

    /* sNssai */
    public SingleNssai getsNssai() {
      return sNssai;
    }

    public void setsNssai(SingleNssai sNssai) {
      this.sNssai = sNssai;
    }

    /* UP_gNodeB_IP */
    public String getUP_gNodeB_IP() {
      return UP_gNodeB_IP;
    }

    public void setUP_gNodeB_IP(String UP_gNodeB_IP) {
      this.UP_gNodeB_IP = UP_gNodeB_IP;
    }


    /* ueip_info */
    public AllocateIPinfo getUeipInfo() {
      return UeipInfo;
    }

    public void setUeipInfo(AllocateIPinfo UeipInfo) {
      this.UeipInfo = UeipInfo;
    }

}

