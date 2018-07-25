package com.nec.corestudy.gnb.GNB_Tunnel.api;

import com.nec.corestudy.gnb.GTPU_GNB1.model.*;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class GNB_Tunnel {

    private static final Logger log = LoggerFactory.getLogger(GNB_Tunnel.class);

    public GNB_Tunnel(){}

    public void createGNBTunnel(int teid, CreategtpuGnb body){
        log.debug("deleteGNBTunnel START");
        log.info("teid : {}, body : {}",teid, body);

        String s_teid = null;
        String dst_ip = null;
        String ue_ip  = null;
        String ue_gw  = null;

        if(0 >= teid ) {
            log.error("TEID({}) is not Correct",teid);
            return;
        }
        s_teid = String.valueOf(teid);

        if(null == body){
            log.error("body is not Correct(null)");
            return;
        }
        dst_ip = body.getDstIp();
        ue_ip  = body.getUeIpMask();
        ue_gw  = body.getUeGw();

        if(null == dst_ip || null == ue_ip || null == ue_gw){
            log.error("body is not Correct(dst_ip:{}, ue_ip,{}, ue_gw:{}",dst_ip, ue_ip, ue_gw);
            return;
        }

        try {
            /* exec sh */
            ProcessBuilder pb = new ProcessBuilder("bash", "/home/ubuntu/upf-demo-sandbox-master_CloudT/22_add_gtpu_gnb1.sh",
                                                 s_teid, dst_ip, ue_ip, ue_gw );
            pb = pb.redirectErrorStream(true);
            Process process = pb.start();

            String result = null;
            InputStream is = process.getInputStream();

            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);

            log.info("result mseesage :");
            while ((result = reader.readLine()) != null) {
                log.info(result);
            }

            int ret = process.waitFor();
            log.info("return : {}",ret);
            reader.close();
         }catch (IOException | InterruptedException e) {
             log.error("22_add_gtpu_gnb1.sh {} {} {} {} ERROR", s_teid, dst_ip, ue_ip, ue_gw);
             e.printStackTrace();
        }
    }

    public void deleteGNBTunnel(int teid){
        log.debug("deleteGNBTunnel START");
        log.info("teid : {}",teid);

        String s_teid = null;
        if(0 >= teid ) {
            log.error("TEID({}) is not Correct",teid);
            return;
        }
        s_teid = String.valueOf(teid);

        try {
            /* exec sh */
            ProcessBuilder pb = new ProcessBuilder("bash", "/home/ubuntu/upf-demo-sandbox-master_CloudT/32_del_gtpu_gnb1.sh",
                                                   s_teid);
            pb = pb.redirectErrorStream(true);
            Process process = pb.start();

            String result = null;
            InputStream is = process.getInputStream();

            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);

            log.info("result mseesage :");
            while ((result = reader.readLine()) != null) {
                log.info(result);
            }

            int ret = process.waitFor();
            log.info("return : {}",ret);
            reader.close();
         }catch (IOException | InterruptedException e) {
             log.error("32_del_gtpu_gnb1.sh {} ERROR", s_teid);
             e.printStackTrace();
        }
    }
}
