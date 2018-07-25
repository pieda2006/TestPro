package com.nec.corestudy.amf.NFselection.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UDMselection implements NFselection{

    private static final Logger log = LoggerFactory.getLogger(UDMselection.class);
    private String path = null;
    private String ipaddr = null;
    private String uecm_path = null;
    private String sdm_path = null;
    private String uecm_ipaddr = null;
    private String sdm_ipaddr = null;

    /* Constructor */
    public UDMselection(){
        log.debug("UDMselection Constructor");
        this.path = this.getEnv("UDMPATH");
        this.uecm_path = this.getEnv("UECMPATH");
        this.sdm_path = this.getEnv("SDMPATH");
    }

    public UDMselection(String path, String ipaddr){
        log.debug("UDMselection Constructor (path : {}, ipaddr : {})", path, ipaddr);
        this.path = path;
        this.ipaddr = ipaddr;
    }

    /* setter */
    public void setPath(String path) {
        this.path = path;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    /* getter */
    public String getPath() {
        return this.path;
    }
    public String getPath(String type) {
        String ret;
        switch (type){
        case "UECM" :
            ret = this.uecm_path;
            break;
        case "SDM" :
            ret = this.sdm_path;
            break;
        default :
            ret = this.path;
        }
        return ret;
    }

    public String getIpaddr() {
        return this.ipaddr;
    }

    /* get env */
    public String getEnv(String env){
        return System.getenv(env);
    }

}
