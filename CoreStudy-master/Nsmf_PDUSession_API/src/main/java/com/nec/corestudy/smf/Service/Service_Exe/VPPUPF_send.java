package com.nec.corestudy.smf.Service.Service_Exe;

import com.nec.corestudy.smf.Controller.VPPUPF_API_client.*;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.auth.*;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.model.*;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.api.TunnelCreateApi;
import com.nec.corestudy.smf.Controller.VPPUPF_API_client.api.TunnelDeleteApi;

import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;

import java.io.File;
import java.util.*;


public class VPPUPF_send {

  private String basePath_UPF_1 = NFInfo_Mng.getInstance().GetbasePath_UPF1_API();
  private String basePath_UPF_2 = NFInfo_Mng.getInstance().GetbasePath_UPF2_API();
  private String basePath_UPF;

  public void UP_SessionCreate(Integer teid, Integer upf_id, CreategtpuUpf body) {

    /* tunnelCreate(PUT) */
    TunnelCreateApi api = new TunnelCreateApi();

    BasePathSet(upf_id);
    api.getApiClient().setBasePath(basePath_UPF);

    try{
      api.tunnelCreate(teid, body);
    }
    catch (com.nec.corestudy.smf.Controller.VPPUPF_API_client.ApiException ae) {
      System.err.println("Exception when calling #tunnelCreate()");
      ae.printStackTrace();
    }

  }

  public void UP_SessionDelete(Integer teid, Integer upf_id) {

    /* tunnelDelete(DELETE) */
    TunnelDeleteApi api = new TunnelDeleteApi();

    BasePathSet(upf_id);
    api.getApiClient().setBasePath(basePath_UPF);

    try{
      api.tunnelDelete(teid);
    }
    catch (com.nec.corestudy.smf.Controller.VPPUPF_API_client.ApiException ae) {
      System.err.println("Exception when calling #tunnelDelete()");
      ae.printStackTrace();
    }

  }

  private void BasePathSet(Integer upf_id){
    if( 1 == upf_id ){
      basePath_UPF = basePath_UPF_1;
    }
    else{
      basePath_UPF = basePath_UPF_2;
    }
    return;
  }

}
