package com.nec.corestudy.smf.Service.NFInfo_Mng;

import java.io.File;
import java.util.*;

public class NFInfo_Mng {

  private static NFInfo_Mng instance = new NFInfo_Mng();

  private static String uecm_str;
  private static String sdm_str;
  private static String amf_str;

  private static String upf1_str;
  private static String upf2_str;

  private static String redis_host;
  private static String redis_port;

  private static String phpipam_access_flg;

  private static String smfid;


  private NFInfo_Mng(){
    /* UECM URL Set(getenv) */
    uecm_str = System.getenv("UECM_URL");
    System.out.println("UECM_URL:" + uecm_str);
    /* SDM URL Set(getenv) */
    sdm_str = System.getenv("SDM_URL");
    System.out.println("SDM_URL:" + sdm_str);
    /* AMF URL Set(getenv) */
    amf_str = System.getenv("AMF_URL");
    System.out.println("AMF_URL:" + amf_str);

    /* UPF URL 1 Set(getenv) */
    upf1_str = System.getenv("UPF_URL_1");
    System.out.println("UPF_URL_1:" + upf1_str);
    /* UPF URL 2 Set(getenv) */
    upf2_str = System.getenv("UPF_URL_2");
    System.out.println("UPF_URL_2:" + upf2_str);

    /* REDIS_HOST Set(getenv) */
    redis_host = System.getenv("REDIS_HOST");
    System.out.println("REDIS_HOST:" + redis_host);
    /* REDIS_PORT Set(getenv) */
    redis_port = System.getenv("REDIS_PORT");
    System.out.println("REDIS_PORT:" + redis_port);

    /* PHPIPAM_ACCESS Set(getenv) */
    phpipam_access_flg = System.getenv("PHPIPAM_ACCESS_FLG");
    System.out.println("PHPIPAM_ACCESS_FLG:" + phpipam_access_flg);

    /* SMFID Set */
    smfid = "1"; /* kari */
  }

  public static String GetbasePath_Nudm_UECM_API() {
    return uecm_str;
  }
  public static String GetbasePath_Nudm_SDM_API() {
    return sdm_str;
  }
  public static String GetbasePath_Namf_Communication_API() {
    return amf_str;
  }
  public static String GetbasePath_UPF1_API() {
    return upf1_str;
  }
  public static String GetbasePath_UPF2_API() {
    return upf2_str;
  }
  public static String GetRedisHost() {
    return redis_host;
  }
  public static String GetRedisPort() {
    return redis_port;
  }
  public static String GetSmfID() {
    return smfid;
  }
  public static String GetPhpipam_Access_Flg() {
    return phpipam_access_flg;
  }

  public static NFInfo_Mng getInstance(){
    return instance;
  }

}

