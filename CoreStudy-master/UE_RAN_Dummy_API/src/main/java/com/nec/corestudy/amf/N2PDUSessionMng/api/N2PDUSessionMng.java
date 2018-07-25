package com.nec.corestudy.amf.N2PDUSessionMng.api;


import com.nec.corestudy.amf.N1N2IF.model.*;
import com.nec.corestudy.amf.GTPU_GNB1_CLI.api.*;
import com.nec.corestudy.amf.GTPU_GNB1_CLI.model.*;
import com.nec.corestudy.amf.common.AMFcommon.*;
import com.nec.corestudy.amf.N2PDUSessionMng.model.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import java.net.URI;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class N2PDUSessionMng {

    private AMFN2PduSesReqData estRcvData = null;
    private AMFN2ResRelReqData relRcvData = null;
    private AMFN2SmInformation n2SmInf = null;
    private AMFNasMessage nasMsg = null;

    private String teId = null;
    private String upfIpaddr = null;
    private String[] auth = {"api_key"};
    private HttpHeaders header = new HttpHeaders();

    private static final Logger log = LoggerFactory.getLogger(N2PDUSessionMng.class);

    public N2PDUSessionMng(AMFN2PduSesReqData rcvData){
        log.debug("N2PDUSessionMng(Est) Constructor");
        this.estRcvData = rcvData;
    }
    public N2PDUSessionMng(AMFN2ResRelReqData rcvData){
        log.debug("N2PDUSessionMng(Rel) Constructor");
        this.relRcvData = rcvData;
        header.set("ACCEPT","application/json");
        header.set("Content-Type","application/json");
    }

    public int N2PDUSession(){
        log.debug("N2PDUSession START");

        String teId = null;
        CreategtpuGnb reqData = new CreategtpuGnb();
        AMFN2InfoContent n2InfContent = n2SmInf.getN2InfoContent();
        String upf_data = n2InfContent.getNgapData();

        AMFN1MessageContainer n1mesContainer =  nasMsg.getN1MessageContainer();
        String ue_data = n1mesContainer.getN1MessageContent();

       log.debug("upf_data = {}",upf_data);
       log.debug("ue_data = {}",ue_data);

        UpfData upfdata = null;
        UeData uedata = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            upfdata = objectMapper.readValue(upf_data, UpfData.class);
            uedata = objectMapper.readValue(ue_data,UeData.class);
        }catch(Exception e){
            log.error("Recv Json Data parse NG");
            log.error("UpfData : {}",upfdata);
            log.error("ueData : {}",uedata);
            e.printStackTrace();
            log.error("N2PDUSession END");
            return constants.Jamf_NG;
        }

        reqData.setDstIp(upfdata.getUpfIpaddr());
        reqData.setUeIpMask(uedata.getUeIpaddr());
        reqData.setUeGw(uedata.getUeGw());
        teId = String.valueOf(upfdata.getTeId());
        String upfpath = null;
        if(upfdata.getUpfIpaddr().equals("172.16.2.2")){
            upfpath = System.getenv("UPFPATH");
            log.debug("selected REAL UPF : {}",upfpath);
        }else{
            upfpath = System.getenv("DUMMYUPFPATH");
            log.debug("selected DUMMY UPF : {}",upfpath);
        }

        UPFAccess upf_acc = new UPFAccess(upfpath);
        upf_acc.tunnelCreate(teId, reqData, auth, header);

        log.debug("N2PDUSession END");
        return constants.Jamf_OK;
    }

    public int N2PDUSessionRel(){
        log.debug("N2PDUSessionRel START");

        String upfpath = null;
        if(upfIpaddr.equals("172.16.2.2")){
            upfpath = System.getenv("UPFPATH");
            log.debug("selected REAL UPF : {}",upfpath);
        }else{
            upfpath = System.getenv("DUMMYUPFPATH");
            log.debug("selected DUMMY UPF : {}",upfpath);
        }

        UPFAccess upf_acc = new UPFAccess(upfpath);
        upf_acc.tunnelDelete(teId, auth, header);

        log.debug("N2PDUSession END");
        return constants.Jamf_OK;
    }


    public int chk_param_est(){
        if(null == estRcvData){
            log.error("rcvData NG(null)");
            return constants.Jamf_NG;
        }
        n2SmInf = estRcvData.getN2SmInformation();
        if(null == n2SmInf){
             log.error("n2SmInf NG(null)");
             return constants.Jamf_NG;
        }
        nasMsg = estRcvData.getNasMessage();
        if(null == nasMsg){
             log.error("nasMsg NG(null)");
             return constants.Jamf_NG;
        }
        return constants.Jamf_OK;
    }

    public int chk_param_rel(){
        if(null == relRcvData){
            log.error("rcvData NG(null)");
            return constants.Jamf_NG;
        }
        int i_teId = relRcvData.getTeid();
        if(0 >= i_teId){
             log.error("teId NG(teId : {})",i_teId);
             return constants.Jamf_NG;
        }
        this.teId = Integer.toString(i_teId);

        this.upfIpaddr = relRcvData.getUpfipaddr();
        if(null == this.upfIpaddr){
             log.error("upfipaddr NG(null)");
             return constants.Jamf_NG;
        }
        return constants.Jamf_OK;
    }

}

