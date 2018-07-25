package com.nec.corestudy.smf.Service.Service_Exe;

import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextReleaseData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextReleasedData;
import com.nec.corestudy.smf.Service.Session_Mng.DeleteSession_Initial;


public class releaseSMContext_exe {

  public SmContextReleasedData execute(String smContextRef, SmContextReleaseData req_body) {

    DeleteSession_Initial Session_Mng = new DeleteSession_Initial();
    SmContextReleasedData resp_body = Session_Mng.execute(smContextRef, req_body);

    return resp_body;
  }
}

