package com.nec.corestudy.smf.Service.IP_Mng;



public class Phpipam_Send_Dummy extends Phpipam_IF{

  private static Phpipam_Send_Dummy instance = new Phpipam_Send_Dummy();

  private static Integer default_ippool = 1;
  private static Integer forvpp_ippool = 1;

  private Phpipam_Send_Dummy(){
  }

  @Override
  public AllocateIPinfo SubnetFirstfreePost(String subnet_name, String Supi, int PDUSessionID) {

    AllocateIPinfo ip_info = new AllocateIPinfo();
    Integer teid = 1;
    if("default" == subnet_name){
      ip_info.teid = default_ippool;
      ip_info.ipaddr = "251.0.0." + default_ippool;
      default_ippool++;
      if(254 <= default_ippool){
        default_ippool = 1;
      }
    }
    else{
      ip_info.teid = forvpp_ippool;
      ip_info.ipaddr = "10.0.0." + forvpp_ippool;
      forvpp_ippool++;
      if(254 <= forvpp_ippool){
        forvpp_ippool = 1;
      }
    }

    ip_info.mask = "24";
    ip_info.subnet_name = subnet_name;

    return ip_info;
  }

  @Override
  public void DeleteAddress(AllocateIPinfo ip_info) {
    return;
  }

  public static Phpipam_Send_Dummy getInstance(){
    return instance;
  }

}
