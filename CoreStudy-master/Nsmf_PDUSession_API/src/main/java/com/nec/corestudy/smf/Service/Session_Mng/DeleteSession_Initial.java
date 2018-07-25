package com.nec.corestudy.smf.Service.Session_Mng;

import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageTransferRspData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN2InfoContainer;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN2SmInformation;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN2InfoContent;
import com.nec.corestudy.smf.Controller.Namf_N1N2_OrgModel.model.n2InfoContent_forvpp;

import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextReleaseData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextReleasedData;

import com.nec.corestudy.smf.Service.Service_Exe.N1N2MessageTransfer_send;
import com.nec.corestudy.smf.Service.Service_Exe.IndividualSmfRegistration_send;
import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;
import com.nec.corestudy.smf.Service.SMCont_Mng.SMContextManager;
import com.nec.corestudy.smf.Service.UPF_Mng.*;
import com.nec.corestudy.smf.Service.IP_Mng.IP_allocation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.ArrayList;


public class DeleteSession_Initial {

  public SmContextReleasedData execute(String smContextRef, SmContextReleaseData req_body) {
                                          /* smContextRef==supi(zantei) */

    SmContextReleasedData resp_body = new SmContextReleasedData();

    /* InternalSMContext Get */
    SMContextManager smcont_mng = new SMContextManager();
    SMContext_Internal smcont_int = smcont_mng.InternalSMContext_Get(smContextRef);

    /* UP_Session_Release */
    UPFManager upf_mng = new UPFManager();
    UPFInfo upf_info = upf_mng.UP_Session_Release(smcont_int);

    /*----------------------------------*/
    /* N1N2MessageTransfer_post() Start */

    AMFN1N2MessageData amfn1n2_snd_data = new AMFN1N2MessageData();
    amfn1n2_snd_data.
     setN2InfoContainer(new AMFN2InfoContainer());
    amfn1n2_snd_data.
     getN2InfoContainer().
      setN2InformationClass(AMFN2InfoContainer.N2InformationClassEnum.SM);
    amfn1n2_snd_data.
     getN2InfoContainer().
      setSmInfo(new ArrayList<AMFN2SmInformation>());
    AMFN2SmInformation N2SmInfo = new AMFN2SmInformation();
    N2SmInfo.setPduSessionId(smcont_int.getPDUSessionID());
    amfn1n2_snd_data.
     getN2InfoContainer().
      getSmInfo().
       add(N2SmInfo);


    amfn1n2_snd_data.setSessionId(String.valueOf(smcont_int.getPDUSessionID()));
    amfn1n2_snd_data.setAnType(AMFN1N2MessageData.AnTypeEnum._3GPP_ACCESS);

    /* N2_forvpp */
    n2InfoContent_forvpp n2_cont = new n2InfoContent_forvpp();

    n2_cont.reqtype = 1;  /* reqtype：1(RELEASE) */
    n2_cont.teid = smcont_int.getUeipInfo().teid;
    n2_cont.upfipaddr = upf_info.upf_ipaddr;

    // Java Obj -> JSON String
    try {
      ObjectMapper mapper = new ObjectMapper();
      String n2_json = mapper.writeValueAsString(n2_cont);

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
    AMFN1N2MessageTransferRspData send_result = N1N2Msg_obj.send_post(smcont_int.getSupi(),
                                                                      amfn1n2_snd_data);
    /* N1N2MessageTransfer_post() End   */
    /*----------------------------------*/


    /* UE IP allocation Delete */
    IP_allocation ip_alloc_api = new IP_allocation();
    ip_alloc_api.delete(smcont_int.getUeipInfo());

    /* IndividualSmfRegistration_delete() */
    IndividualSmfRegistration_send SmfReg_obj = new IndividualSmfRegistration_send();
    SmfReg_obj.send_delete(smcont_int.getSupi(),
                           smcont_int.getPDUSessionID());

    /* InternalSMContext Delete */
    smcont_mng.InternalSMContext_Del(smcont_int.getSupi());


    return resp_body;
  }
}

