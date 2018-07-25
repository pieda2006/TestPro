package com.nec.corestudy.amf.NFselection.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PCFselection implements NFselection{

    private static final Logger log = LoggerFactory.getLogger(PCFselection.class);
    private String path = null;
    private String ipaddr = null;

    /* Constructor */
    public PCFselection(){
        log.debug("PCFselection Constructor");
        this.path = this.getEnv("PCFPATH");
    }

    public PCFselection(String path, String ipaddr){
        log.debug("PCFselection Constructor (path : {}, ipaddr : {})", path, ipaddr);
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

    public String getIpaddr() {
        return this.ipaddr;
    }

    /* get env */
    public String getEnv(String env){
        return System.getenv(env);
    }

}
