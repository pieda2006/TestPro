package com.nec.corestudy.smf.Service.Session_Mng;

import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextCreateData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextCreatedData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SingleNssai;
import com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.model.SmfRegistration;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.model.SessionManagementSubscriptionData;

import com.nec.corestudy.smf.Service.Service_Exe.IndividualSmfRegistration_send;
import com.nec.corestudy.smf.Service.Service_Exe.SessionManagementSubscriptionData_send;
import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;

import java.util.List;


public class CreateSession_Initial {

  public SmContextCreatedData execute(SmContextCreateData req_body) {

    SmContextCreatedData resp_body = new SmContextCreatedData();

    /* IndividualSmfRegistration_put() */
    SmfRegistration smfreg_snd_data = new SmfRegistration();

    /* ---M--- */
    smfreg_snd_data.setSmfId(NFInfo_Mng.GetSmfID());
    smfreg_snd_data.setPduSessionId(req_body.getPduSessionId());
//    smfreg_snd_data.setDnn(req_body.getDnn()); /* kari */
    smfreg_snd_data.setDnn("dnn_hoge");          /* kari */

    /* ---O--- (zantei) */
    smfreg_snd_data.setSupportedFeatures("SMContextID:0001");
    smfreg_snd_data.setPcscfRestorationCallbackUri("http://5gc.smf.example.com/dummy/PcscfRestorationCallbackUri/");

    IndividualSmfRegistration_send SmfReg_obj = new IndividualSmfRegistration_send();
    SmfRegistration SmfReg_send_result = SmfReg_obj.send_put(req_body.getSupi(),
                                                             req_body.getPduSessionId(),
                                                             smfreg_snd_data);

    /* SmData_get() */
    SessionManagementSubscriptionData_send SmData_obj = new SessionManagementSubscriptionData_send();
    List<SessionManagementSubscriptionData> SmData_get_result = SmData_obj.send_get(req_body.getSupi());

    /* Event Continue. */
    SMContext_Internal cont_in = new SMContext_Internal();
    cont_in.setSupi(req_body.getSupi());
    cont_in.setPDUSessionID(req_body.getPduSessionId());
    cont_in.setDNN(req_body.getDnn());

    SingleNssai input_snssai = new SingleNssai();
    input_snssai.setSd(SmData_get_result.get(0).getSingleNssai().getSd());
    input_snssai.setSst(SmData_get_result.get(0).getSingleNssai().getSst());
    cont_in.setsNssai(input_snssai);

    cont_in.setUP_gNodeB_IP(req_body.getN1SmMsg().getContentId());

    EventContinue event_cont = new EventContinue();
    event_cont.exec(1,cont_in); /* eventtype:kari */


    /* Dummy */
    resp_body.setSupportedFeatures("SMContextID:0001"); /* kari */

    return resp_body;
  }
}

