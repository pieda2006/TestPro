package com.nec.corestudy.smf.Service.IP_Mng;

import com.nec.corestudy.smf.Service.Session_Mng.SMContext_Internal;
import com.nec.corestudy.smf.Service.IP_Mng.IP_allocation;
import com.nec.corestudy.smf.Service.IP_Mng.IPMngTable;
import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;

import com.nec.corestudy.smf.Repository.phpipam_API_client.model.SubnetsDataData;

import java.io.File;
import java.util.*;


public class IP_allocation {

  private final String DEFAULT_SUBNET_NAME = "default";
  private Phpipam_IF ipam_send = null;
  private NFInfo_Mng nf_info = NFInfo_Mng.getInstance();



  public IP_allocation(){
  }

  public AllocateIPinfo create(SMContext_Internal context_data) {

    String subnet_name = SubnetSelect(context_data);
    Phpipam_IF ipam_send = IpamSendSelect(subnet_name);

    AllocateIPinfo ipinfo = ipam_send.SubnetFirstfreePost(subnet_name,
                                                          context_data.getSupi(),
                                                          context_data.getPDUSessionID());

    /* uegw set kari for vpp. */
    String[] ipstr = ipinfo.ipaddr.split("\\.", 0);
    ipinfo.uegw = "";
    for (int i = 0 ; i < 3 ; i++){
      ipinfo.uegw += (ipstr[i] + ".");
    }
    ipinfo.uegw += "254";

    return ipinfo;
  }

  public void delete(AllocateIPinfo ip_info) {

    Phpipam_IF ipam_send = IpamSendSelect(ip_info.subnet_name);

    ipam_send.DeleteAddress(ip_info);

    return;
  }



  private Phpipam_IF IpamSendSelect(String subnet_name){

    Phpipam_IF ipam_if = null;

    if(nf_info.GetPhpipam_Access_Flg().equals("1")){
      if( subnet_name.equals(DEFAULT_SUBNET_NAME) ){
        ipam_if = Phpipam_Send_Dummy.getInstance();
      }
      else{
        ipam_if = Phpipam_Send.getInstance();
      }
    }
    else{
      ipam_if = Phpipam_Send_Dummy.getInstance();
    }

    return ipam_if;
  }

  private String SubnetSelect(SMContext_Internal context_data){

    String subnet_name = IPMngTable.NSSAI_SUBNET_TABLE.get(context_data.getsNssai().getSst());

    if( null == subnet_name ){
      subnet_name = DEFAULT_SUBNET_NAME;
    }

    return subnet_name;
  }

}
