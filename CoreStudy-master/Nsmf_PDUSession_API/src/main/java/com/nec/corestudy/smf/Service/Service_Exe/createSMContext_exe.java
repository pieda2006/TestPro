package com.nec.corestudy.smf.Service.Service_Exe;

import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextCreateData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextCreatedData;
import com.nec.corestudy.smf.Service.Session_Mng.CreateSession_Initial;


public class createSMContext_exe {

  public SmContextCreatedData execute(SmContextCreateData req_body) {

    CreateSession_Initial Session_Mng = new CreateSession_Initial();
    SmContextCreatedData resp_body = Session_Mng.execute(req_body);

    return resp_body;
  }
}

