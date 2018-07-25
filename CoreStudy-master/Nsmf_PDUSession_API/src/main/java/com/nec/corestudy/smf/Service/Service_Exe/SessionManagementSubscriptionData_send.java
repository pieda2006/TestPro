package com.nec.corestudy.smf.Service.Service_Exe;

import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.model.SessionManagementSubscriptionData;
import com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.api.SessionManagementSubscriptionDataApi;
import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;
import java.util.List;


public class SessionManagementSubscriptionData_send {

  public SessionManagementSubscriptionDataApi api = new SessionManagementSubscriptionDataApi();

  private String basePath_SDM = NFInfo_Mng.GetbasePath_Nudm_SDM_API();

  public List<SessionManagementSubscriptionData> send_get(String supi) {

    /* SessionManagementSubscriptionData(GET) */
//    SessionManagementSubscriptionDataApi api = new SessionManagementSubscriptionDataApi();
    api.getApiClient().setBasePath(basePath_SDM);


//    System.err.println("getConnectTimeout():" + api.getApiClient().getConnectTimeout() );
//    System.err.println("getReadTimeout():" + api.getApiClient().getReadTimeout() );
//    System.err.println("getWriteTimeout():" + api.getApiClient().getWriteTimeout() );



    try{
        List<SessionManagementSubscriptionData> result = api.getSmData(supi, null, null, null, null);
//        System.out.println(result);
        return result;
    } catch (com.nec.corestudy.smf.Controller.Nudm_SDM_API_client.ApiException ae) {
        System.err.println("Exception when calling #getSmData");
        ae.printStackTrace();
        return null;
    }

  }
}
