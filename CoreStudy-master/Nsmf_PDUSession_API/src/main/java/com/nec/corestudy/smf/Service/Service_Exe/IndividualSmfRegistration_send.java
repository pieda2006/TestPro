package com.nec.corestudy.smf.Service.Service_Exe;

import com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.model.SmfRegistration;
import com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.api.IndividualSmfRegistrationApi;
import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;


public class IndividualSmfRegistration_send {

  private String basePath_UECM = NFInfo_Mng.GetbasePath_Nudm_UECM_API();

  public SmfRegistration send_put(String ueId, Integer pduSessionId, SmfRegistration req_body) {

    /* IndividualSmfRegistration(PUT) */
    IndividualSmfRegistrationApi api = new IndividualSmfRegistrationApi();
    api.getApiClient().setBasePath(basePath_UECM);
    String pduses_str = String.valueOf(pduSessionId);
    try{
        SmfRegistration result = api.putIndividualSmfRegistration(ueId, pduses_str, req_body);
//        System.out.println(result);
        return result;
    } catch (com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.ApiException ae) {
        System.err.println("Exception when calling #putIndividualSmfRegistration");
        ae.printStackTrace();
        return null;
    }

  }

  public void send_delete(String ueId, Integer pduSessionId) {

    /* IndividualSmfRegistration(DELETE) */
    IndividualSmfRegistrationApi api = new IndividualSmfRegistrationApi();
    api.getApiClient().setBasePath(basePath_UECM);
    String pduses_str = String.valueOf(pduSessionId);
    try{
        api.deleteIndividualSmfRegistration(ueId, pduses_str);
    } catch (com.nec.corestudy.smf.Controller.Nudm_UECM_API_client.ApiException ae) {
        System.err.println("Exception when calling #deleteIndividualSmfRegistration");
        ae.printStackTrace();
    }

    return;
  }

}
