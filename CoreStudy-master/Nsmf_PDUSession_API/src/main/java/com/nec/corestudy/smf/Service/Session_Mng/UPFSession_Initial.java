package com.nec.corestudy.smf.Service.Session_Mng;

import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageTransferRspData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1MessageContainer;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN2InfoContainer;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN2SmInformation;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN2InfoContent;
import com.nec.corestudy.smf.Controller.Namf_N1N2_OrgModel.model.n1MessageContent_forvpp;
import com.nec.corestudy.smf.Controller.Namf_N1N2_OrgModel.model.n2InfoContent_forvpp;

import com.nec.corestudy.smf.Service.Service_Exe.N1N2MessageTransfer_send;
import com.nec.corestudy.smf.Service.Session_Mng.SMContext_Internal;
import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;
import com.nec.corestudy.smf.Service.IP_Mng.IP_allocation;
import com.nec.corestudy.smf.Service.IP_Mng.AllocateIPinfo;
import com.nec.corestudy.smf.Service.UPF_Mng.*;
import com.nec.corestudy.smf.Service.SMCont_Mng.SMContextManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.ArrayList;


public class UPFSession_Initial {

  public void execute(SMContext_Internal context_data) {

    /* UE IP allocation */
    IP_allocation ip_alloc_api = new IP_allocation();
    AllocateIPinfo ueip_info = ip_alloc_api.create(context_data);

    /* UP_Session_Establishment */
    UPFManager upf_mng = new UPFManager();
    context_data.setUeipInfo(ueip_info);
    UPFInfo upf_info = upf_mng.UP_Session_Establishment(context_data);

    /* InternalSMContext_Set */
    /* (TBD)                 */
    SMContextManager smcont_mng = new SMContextManager();
    smcont_mng.InternalSMContext_Set(context_data); /* kari */


    /*----------------------------------*/
    /* N1N2MessageTransfer_post() Start */

    AMFN1N2MessageData amfn1n2_snd_data = new AMFN1N2MessageData();

    AMFN1MessageContainer n1msg_cont = new AMFN1MessageContainer();
    n1msg_cont.setN1MessageClass(AMFN1MessageContainer.N1MessageClassEnum.SM);
    n1msg_cont.setN1MessageContent("UE_IPaddr:" + ueip_info.ipaddr);
    amfn1n2_snd_data.setN1MessageContainer(n1msg_cont);


    AMFN2InfoContainer amf_n2info_cont = new AMFN2InfoContainer();
    amf_n2info_cont.setN2InformationClass(AMFN2InfoContainer.N2InformationClassEnum.SM);

    List<AMFN2SmInformation> N2SmInfo_List = new ArrayList<AMFN2SmInformation>();
    AMFN2SmInformation N2SmInfo = new AMFN2SmInformation();
    N2SmInfo.setPduSessionId(context_data.getPDUSessionID());
    N2SmInfo_List.add(N2SmInfo);

    amf_n2info_cont.setSmInfo(N2SmInfo_List);
    amfn1n2_snd_data.setN2InfoContainer(amf_n2info_cont);


    amfn1n2_snd_data.setSessionId(String.valueOf(context_data.getPDUSessionID()));
    amfn1n2_snd_data.setAnType(AMFN1N2MessageData.AnTypeEnum._3GPP_ACCESS);

    /* N1N2_forvpp */
    n1MessageContent_forvpp n1_cont = new n1MessageContent_forvpp();
    n2InfoContent_forvpp n2_cont = new n2InfoContent_forvpp();

    n1_cont.reqtype = 0;  /* reqtype：0(ESTABLISH) */
    n1_cont.ueipaddr = (ueip_info.ipaddr + "/" + ueip_info.mask);
    n1_cont.uegw = ueip_info.uegw;

    n2_cont.reqtype = 0;  /* reqtype：0(ESTABLISH) */
    n2_cont.teid = ueip_info.teid;
    n2_cont.upfipaddr = upf_info.upf_ipaddr;

    // Java Obj -> JSON String
    try {
      ObjectMapper mapper = new ObjectMapper();
      String n1_json = mapper.writeValueAsString(n1_cont);
      String n2_json = mapper.writeValueAsString(n2_cont);

      amfn1n2_snd_data.getN1MessageContainer().
                        setN1MessageContent(n1_json);

      amfn1n2_snd_data.getN2InfoContainer().
                        getSmInfo().
                         get(0).
                          setN2InfoContent(new AMFN2InfoContent());

      amfn1n2_snd_data.getN2InfoContainer().
                        getSmInfo().
                         get(0).
                          getN2InfoContent().
                           setNgapData(n2_json);

      amfn1n2_snd_data.getN2InfoContainer().
                        getSmInfo().
                         get(0).
                          getN2InfoContent().
                           setNgapIeType(0); /* kari */

    }
    catch (JsonProcessingException je) {
      System.err.println("Exception when calling jackson#mapper.writeValueAsString()");
      je.printStackTrace();
    }

    N1N2MessageTransfer_send N1N2Msg_obj = new N1N2MessageTransfer_send();
    AMFN1N2MessageTransferRspData send_result = N1N2Msg_obj.send_post(context_data.getSupi(),
                                                                      amfn1n2_snd_data);

    /* N1N2MessageTransfer_post() End   */
    /*----------------------------------*/
    return;
  }

}

