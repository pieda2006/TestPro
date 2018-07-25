package com.nec.corestudy.amf.RegistrationMng.api;

import com.nec.corestudy.amf.*;
import com.nec.corestudy.amf.N1N2IF.model.*;
import com.nec.corestudy.amf.NamfSdmCLI.model.*;
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


public class RegistrationMng extends Thread {
    private String reqType  = null;
    private AMFRegistrationRequest regReq = null;
    private String ueId     = null;
    private String supi     = null;

    private String udm_path = null;
    private String uecm_path = null;
    private String sdm_path = null;
    private String pcf_path = null;

    private String[] auth = {"api_key"};
    private HttpHeaders header = new HttpHeaders();

    private static final Logger log = LoggerFactory.getLogger(RegistrationMng.class);

    /* Constructor */
    public RegistrationMng( AMFReqMessage reqMsg ) {
        log.debug("RegistrationMng Constructor");
        log.debug("reqMsg : {}", reqMsg);

        reqType = reqMsg.getReqType();
        regReq  = reqMsg.getRegistrationRequest();
        ueId    = regReq.getGuti();
        supi    = regReq.getSuci();
    }

    public void run(){
        int ret = constants.Jamf_NG;
        switch( reqType ) {
            case constants.Jamf_REGISTRATION :
                ret = regReq();
                if(constants.Jamf_NG == ret){
                    log.error("regReq NG");
                    return;
                }
            break;
            default:
                log.error("This ReqType({}) is not supported", reqType);
                log.error("RegistrationMng NG");
                return ;
        }
    }

    /* REGISTRATION REQUEST Main func */
    private int regReq(){
        log.debug("regReq START");

        int ret = constants.Jamf_NG;

        /* UDMselection */
        selectUdm();
        if(null == udm_path){
            log.error("UDM selection ERROR");
            return constants.Jamf_NG;
        }

        /* Nudm_UECM_Registration */
        UecmAccess uecm_acc = new UecmAccess(uecm_path);
        ret = uecm_acc.UECM_Registration(ueId, auth, header);
        if(constants.Jamf_NG == ret ) {
            log.error("UECM_Registration NG");
            return constants.Jamf_NG;
        }

        SdmAccess sdm_acc = new SdmAccess(sdm_path);
        /* Nudm_SDM_Get */
        AccessAndMobilitySubscriptionData amData = sdm_acc.SDM_GetAmData(supi, auth, header);
        if( null == amData ) {
            log.error("SDM_GetAmData NG");
            return constants.Jamf_NG;
        }
        log.debug("GET amData : {}",amData);

        SmfSelectionSubscriptionData smfSelData = sdm_acc.SDM_GetSmfSelData(supi, auth, header);
        if( null == smfSelData ) {
            log.error("SDM_GetSmfSelData NG");
            return constants.Jamf_NG;
        }
        log.debug("GET smfSelData : {}", smfSelData);

        UeContextInSmfData ucSmfData = sdm_acc.SDM_GetUCSmfData(supi, auth, header);
        if( null == ucSmfData ) {
            log.error("SDM_GetUCSmfData NG");
            return constants.Jamf_NG;
        }
        log.debug("GET ucSmfData : {}",ucSmfData);

        ret = sdm_acc.SDM_Subscribe(supi, auth, header);
        if(constants.Jamf_NG == ret ) {
            log.error("SDM_Subscribe NG");
            return constants.Jamf_NG;
        }

        /* PCFselection */
         selectPcf();
        if(null == pcf_path){
            log.error("PCF selection ERROR");
            return constants.Jamf_NG;
        }

        /* Npcf_AMPolicyControl */
        PcfAccess pcf_acc = new PcfAccess(pcf_path);
        String new_policy = pcf_acc.AMPolicyAssociationEst();
        log.debug("Policy is {}",new_policy);

        /* Send REGISTRATION REQUEST ACCEPT to UE*/
        N1N2Access n1n2_acc = new N1N2Access();
        ret = n1n2_acc.N1N2_RegistrationAccept(ueId, auth, header);
        if(constants.Jamf_NG == ret ) {
            log.error("N1N2_RegistrationAccept NG");
            return constants.Jamf_NG;
        }
        log.debug("N1N2_RegistrationAccept OK");
        return constants.Jamf_OK;
    }

    /* UDM select */
    private void selectUdm() {
        UDMselection udmSel = new UDMselection();
        this.udm_path = udmSel.getPath();
        this.uecm_path = udmSel.getPath("UECM");
        this.sdm_path = udmSel.getPath("SDM");
    }

    /* PCF select */
    private void selectPcf() {
        PCFselection pcfSel = new PCFselection();
        pcf_path = pcfSel.getPath();
    }

    /* parameter check */
    public int chkParam(){
        if( null == reqType ) {
            log.error("reqType NG(null)" );
            return constants.Jamf_NG;
        }
        if( null == ueId ) {
            log.error("ueId NG(null)" );
            return constants.Jamf_NG;
        }
        if( null == supi ) {
            log.error("supi NG(null)" );
            return constants.Jamf_NG;
        }
        return constants.Jamf_OK;
    }

}
