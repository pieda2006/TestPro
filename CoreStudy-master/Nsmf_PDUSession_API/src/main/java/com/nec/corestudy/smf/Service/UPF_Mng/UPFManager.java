package com.nec.corestudy.smf.Service.UPF_Mng;

import com.nec.corestudy.smf.Service.Session_Mng.SMContext_Internal;
import com.nec.corestudy.smf.Service.Service_Exe.VPPUPF_send;
import com.nec.corestudy.smf.Service.SMCont_Mng.SMContextManager;

import com.nec.corestudy.smf.Controller.VPPUPF_API_client.model.CreategtpuUpf;

import java.io.File;
import java.util.*;


public class UPFManager {

  public UPFInfo UP_Session_Establishment(SMContext_Internal context_data) {

    /* UPF_Selection() */
    UPFInfo upf_info = UPF_Selection(context_data);

    /* N4 Session Context Create */
    /* (TBD)                     */

    /* N4 Session Establishment Send */
    VPPUPF_send vppupf = new VPPUPF_send();
    CreategtpuUpf upf_body = new CreategtpuUpf();
    upf_body.setDstIp(context_data.getUP_gNodeB_IP());
    upf_body.setUeIp(context_data.getUeipInfo().ipaddr);

    vppupf.UP_SessionCreate(context_data.getUeipInfo().teid, /* kari */
                            upf_info.upf_id,
                            upf_body);
    return upf_info;
  }

  public UPFInfo UP_Session_Release(SMContext_Internal context_data) {

    /* UPF_Selection() */
    UPFInfo upf_info = UPF_Selection(context_data);

    /* N4 Session Release Send */
    VPPUPF_send vppupf = new VPPUPF_send();
    vppupf.UP_SessionDelete(context_data.getUeipInfo().teid, /* kari */
                            upf_info.upf_id);

    /* N4 Session Context Release */
    /* (TBD)                      */

    return upf_info;
  }


  private UPFInfo UPF_Selection(SMContext_Internal context_data) { /* kari */

    UPFInfo upf_info = new UPFInfo();

    if( context_data.getsNssai().getSst() == 1 ){
      upf_info.upf_id = 1;
      upf_info.upf_ipaddr = "172.16.2.2";
    }
    else{
      upf_info.upf_id = 2;
      upf_info.upf_ipaddr = "172.16.3.2";
    }

    return upf_info;
  }

//  public String getupf_ipaddr() {
//    return upf_ipaddr;
//  }

}

