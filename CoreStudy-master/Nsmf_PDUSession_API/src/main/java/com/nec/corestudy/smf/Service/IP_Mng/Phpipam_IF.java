package com.nec.corestudy.smf.Service.IP_Mng;


abstract class Phpipam_IF {

  abstract AllocateIPinfo SubnetFirstfreePost(String subnet_name, String Supi, int PDUSessionID);

  abstract void DeleteAddress(AllocateIPinfo ip_info);

}
