package com.nec.corestudy.amf.NFselection.api;

public interface NFselection {

    /* setter */
    void setPath(String path);
    void setIpaddr(String ipaddr);

    /* getter */
    String getPath();
    String getIpaddr();

    /* get env */
    String getEnv(String env);

}

