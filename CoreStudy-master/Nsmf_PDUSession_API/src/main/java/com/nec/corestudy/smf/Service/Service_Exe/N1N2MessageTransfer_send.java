package com.nec.corestudy.smf.Service.Service_Exe;

import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.model.AMFN1N2MessageTransferRspData;
import com.nec.corestudy.smf.Controller.Namf_Communication_API_client.api.N1N2MessageTransferApi;
import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;
import java.util.List;


public class N1N2MessageTransfer_send {

  private String basePath_AMF = NFInfo_Mng.GetbasePath_Namf_Communication_API();

  public AMFN1N2MessageTransferRspData send_post(String supi, AMFN1N2MessageData snddata) {

    /* N1N2MessageTransfer(POST) */
    N1N2MessageTransferApi api = new N1N2MessageTransferApi();
    api.getApiClient().setBasePath(basePath_AMF);
    try{
        AMFN1N2MessageTransferRspData result = api.postN1N2MessageTransfer(supi, snddata);
//        System.out.println(result);
        return result;
    } catch (com.nec.corestudy.smf.Controller.Namf_Communication_API_client.ApiException ae) {
        System.err.println("Exception when calling #getSmData");
        ae.printStackTrace();
        return null;
    }

  }
}
