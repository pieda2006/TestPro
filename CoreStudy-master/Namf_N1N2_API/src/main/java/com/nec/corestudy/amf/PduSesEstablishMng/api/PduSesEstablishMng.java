package com.nec.corestudy.amf.PduSesEstablishMng.api;

import com.nec.corestudy.amf.*;
import com.nec.corestudy.amf.N1N2IF.model.*;
import com.nec.corestudy.amf.NamfSmfCLI.model.*;
import com.nec.corestudy.amf.NFselection.api.*;
import com.nec.corestudy.amf.common.AMFcommon.*;
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
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PduSesEstablishMng extends Thread {
    private AMFReqMessage reqMsg     = null;
    private String reqType   = null;
    private String supi      = null;
    private int pduSessionId = 0;
    private String requestType = null;
    private AMFPduSessionEstablishRequest pduEst = null;
    private AMFPduSessionReleaseRequest   pduRel = null;
    private AMFSnssai snssai = null;

    private String smf_path = null;
    private String upf_addr = null;

    private String[] auth = {"api_key"};
    private HttpHeaders header = new HttpHeaders();

    private static final Logger log = LoggerFactory.getLogger(PduSesEstablishMng.class);

    /* Constructor */
    public PduSesEstablishMng( AMFReqMessage reqMsg ) {
        this.reqMsg = reqMsg;
        log.debug("PduSesEstablishMng Constructor");
        log.debug("reqMsg : {}", reqMsg);
//        header.set("ACCEPT","application/json");
//        header.set("Content-Type","application/json");
    }

    public void run(){
        int ret = constants.Jamf_NG;
        switch( reqType ) {
            case constants.Jamf_PDUSESSIONESTABLISHMENT :
                ret = pduSesEstablish();
                if(constants.Jamf_NG == ret){
                    log.error("PduSesEstablishMng NG");
                    return ;
                }
            break;
            case constants.Jamf_PDUSESSIONRELEASE :
                ret = pduSesRelease();
                if(constants.Jamf_NG == ret){
                    log.error("PduSesEstablishMng NG");
                    return ;
                }
            break;
            default:
                log.error("This ReqType({}) is not supported", reqType);
                log.error("PduSesEstablishMng NG");
                return;
        }
    }


    private int pduSesEstablish(){
        log.debug("pduSesEstablish START");
        int ret = constants.Jamf_NG;
        /* SMF selection */
        selectSmf();
        if(null == smf_path){
            log.error("SMF selection ERROR");
            return constants.Jamf_NG;
        }

        /* for test call */
        String tmp_imsi = supi.substring(5);
        String test_imsi = "IMSI=" + tmp_imsi;
        header.set(HttpHeaders.COOKIE,test_imsi);

        /* 3a. Nsmf_PDUSession_CreateSMContext Request SEND */
        SmContextCreateData reqBody = new SmContextCreateData();
        SingleNssai tmp_snssai = new SingleNssai();
        RefToBinaryData N1SmMsg = new RefToBinaryData();
        tmp_snssai.setSst(snssai.getSst());
        tmp_snssai.setSd(snssai.getSd());
        N1SmMsg.setContentId(upf_addr);

        reqBody.setSupi(supi);
        reqBody.setPduSessionId(pduEst.getPduSessionId());
        reqBody.setSNssai(tmp_snssai);
        reqBody.setAmfId("AMF1");
        reqBody.setN1SmMsg(N1SmMsg);
        reqBody.setAnType(AccessType._3GPP_ACCESS);
        reqBody.setSmContextStatusUri(System.getenv("AMFPATH"));

        log.debug("reqBody : {}", reqBody);

        SmfAccess smf_acc = new SmfAccess(smf_path);
        ret = smf_acc.PDU_CreSMContext(reqBody,auth,header);
        if(constants.Jamf_NG == ret){
            log.error("pduSesEstablish END(Jamf_NG)");
            return constants.Jamf_NG;
        }
        log.debug("pduSesEstablish END(Jamf_OK)");
        return constants.Jamf_OK;
    }

    private int pduSesRelease(){
        log.debug("pduSesRelease START");
        int ret = constants.Jamf_NG;
        /* SMF selection */
        selectSmf();
        if(null == smf_path){
            log.error("SMF selection ERROR");
            return constants.Jamf_NG;
        }

        /* 1c.Nsmf_PDUSession_ReleaseSMContext Request SEND */
        SmContextReleaseData reqBody = new SmContextReleaseData();
        log.debug("reqBody : {}", reqBody);

        SmfAccess smf_acc = new SmfAccess(smf_path);
        ret = smf_acc.PDU_RelSMContext(supi,reqBody,auth,header);
        if(constants.Jamf_NG == ret){
            log.error("pduSesRelease END(Jamf_NG)");
            return constants.Jamf_NG;
        }

        log.debug("pduSesRelease END(Jamf_OK)");
        return constants.Jamf_OK;
    }

    /* SMF select */
    private void selectSmf() {
        SMFselection smfSel = new SMFselection();
        smf_path = smfSel.getPath();
    }

    /* parameter check */
    public int chkParam(){
        reqType = reqMsg.getReqType();
        if( null == reqType ) {
            log.error("reqType NG(null)" );
            return constants.Jamf_NG;
        }

        switch(reqType){
        case constants.Jamf_PDUSESSIONESTABLISHMENT :
            pduEst  = reqMsg.getPduSessionEstablishRequest();
            if(null == pduEst) {
                log.error("pduEst NG(null)" );
                return constants.Jamf_NG;
            }
            supi = pduEst.getDnn();
            if(null == supi) {
                log.error("supi NG(null)" );
                return constants.Jamf_NG;
            }
            snssai = pduEst.getSnssai();
            if(null == snssai) {
                log.error("snssai NG(null)" );
                return constants.Jamf_NG;
            }
            pduSessionId = pduEst.getPduSessionId();
            if(0 == pduSessionId) {
                log.error("pduSessionId NG(0)" );
                return constants.Jamf_NG;
            }
            requestType = pduEst.getRequestType();
            if( null == requestType ) {
                log.error("requestType NG(null)" );
                return constants.Jamf_NG;
            }
            AMFN1MessageContainer n1MesCon = pduEst.getN1SmContainer();
            upf_addr = n1MesCon.getN1MessageContent();
            if( null == upf_addr ) {
                log.error("upf_addr NG(null)" );
                return constants.Jamf_NG;
            }
            break;
        case constants.Jamf_PDUSESSIONRELEASE:
            pduRel = reqMsg.getPduSessionReleaseRequest();
            if(null == pduRel) {
                log.error("pduRel NG(null)" );
                return constants.Jamf_NG;
            }
            pduSessionId = pduRel.getPduSessionId();
            if(0 == pduSessionId) {
                log.error("pduSessionId NG(0)" );
                return constants.Jamf_NG;
            }
            supi = pduRel.getSupi();
            if(null == supi) {
                log.error("supi NG(null)" );
                return constants.Jamf_NG;
            }
            break;
        default:
            log.error("reqType NG(unsupported reqType : {})", reqType);
            return constants.Jamf_NG;
        }
        return constants.Jamf_OK;
    }
}
