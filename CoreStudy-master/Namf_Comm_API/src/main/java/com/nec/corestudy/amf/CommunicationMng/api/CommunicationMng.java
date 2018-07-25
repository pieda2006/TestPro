package com.nec.corestudy.amf.CommunicationMng.api;

//import com.nec.corestudy.amf.N1N2IF_CLI.*;
import com.nec.corestudy.amf.N1N2IF_CLI.model.AMFN2PduSesReqData;
import com.nec.corestudy.amf.N1N2IF_CLI.model.AMFPduSessionReleaseRequest;
import com.nec.corestudy.amf.N1N2IF_CLI.model.AMFNasMessage;
import com.nec.corestudy.amf.N1N2IF_CLI.model.AMFN2ResRelReqData;
import com.nec.corestudy.amf.NamfCommunication.model.*;
import com.nec.corestudy.amf.CommunicationMng.model.*;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommunicationMng extends Thread {

    private String type                   = null;
    private String ueContextId            = null;
    private String subscriptionsId        = null;
    private String n1N2MessageId          = null;
    private String n2NotifySubscriptionId = null;

    private Object Body = null;
    private UpfData upfdata = null;
    private UeData uedata = null;

    private String[] auth = {"api_key"};
    private HttpHeaders header = new HttpHeaders();

    private static final Logger log = LoggerFactory.getLogger(CommunicationMng.class);

    public CommunicationMng( String type, String ueContextId, String subscriptionsId, String n1N2MessageId, String n2NotifySubscriptionId, Object Body ){
        log.debug("CommunicationMng Constructor");
        log.debug("type : {}, ueContextId : {}, subscriptionsId : {}, n1N2MessageId : {}, n2NotifySubscriptionId : {}",
                   type, ueContextId, subscriptionsId, n1N2MessageId, n2NotifySubscriptionId);
        log.debug("Body : {}", Body);
        this.type                    = type;
        this.ueContextId             = ueContextId;
        this.subscriptionsId         = subscriptionsId;
        this.n1N2MessageId           = n1N2MessageId;
        this.n2NotifySubscriptionId  = n2NotifySubscriptionId;
        this.Body                    = Body;
    }


    public void run() {
        switch (type ) {
        case constants.Jamf_COMM_N1N2TRANSFER :
            AMFN1N2MessageData rcvBody = (AMFN1N2MessageData)Body;
            log.debug("rcvBody : {}",rcvBody);

            int reqtype = constants.Jamf_NG;
            reqtype = chk_reqType(rcvBody);
            if(constants.Jamf_PDUSESESTABLISHMENT == reqtype){
                N2pduSessionRequest(rcvBody);
            }else if(constants.Jamf_PDUSESRELEASE == reqtype){
                N2ResourceRelease(rcvBody);
            }else{
                log.error("this reqtype is not supported : {}", reqtype );
                return;
            }
        break;
        default :
            log.error("this operation is not supported : {}", type );
            return;
        }
        return;
    }


    private void N2pduSessionRequest(AMFN1N2MessageData rcvBody){
        log.debug("N2pduSessionRequest START");
        int ret = constants.Jamf_NG;
        AMFN2PduSesReqData reqData = new AMFN2PduSesReqData();

        AMFNasMessage nasMsg = new AMFNasMessage();
        nasMsg.setN1MessageContainer(rcvBody.getN1MessageContainer());
        reqData.setNasMessage(nasMsg);

        AMFN2InfoContainer rcv_n2Info = rcvBody.getN2InfoContainer();
        List<AMFN2SmInformation> rcv_smInfList = rcv_n2Info.getSmInfo();
        reqData.setN2SmInformation(rcv_smInfList.get(0));

        log.debug("reqData : {}",reqData);

        n1n2Access n1n2_acc = new n1n2Access();
        ret = n1n2_acc.N2pduSessionRequest(ueContextId, reqData, auth, header);
        if(constants.Jamf_NG == ret ){
            log.error("N2pduSessionRequest NG");
            return;
        }

        /* Skipp UpdateSMContext as not supported patch method */
//        smfAccess smf_acc = new smfAccess();
//        ret = smf_acc.updateSmContext(ueContextId, auth, header);
//        if(constants.Jamf_NG == ret ){
//            log.error("updateSmContext NG");
//            return constants.Jamf_NG;
//        }
        return;
    }


    private void N2ResourceRelease(AMFN1N2MessageData rcvBody){
        log.debug("N2ResourceRelease START");
        ObjectMapper objectMapper = new ObjectMapper();
        int ret = constants.Jamf_NG;
        AMFN2ResRelReqData reqData = new AMFN2ResRelReqData();

        reqData.setTeid(upfdata.getTeId());
        reqData.setUpfipaddr(upfdata.getUpfIpaddr());

        log.debug("reqData : {}",reqData);
        n1n2Access n1n2_acc = new n1n2Access();
        ret = n1n2_acc.N2ResourceRelease(ueContextId, reqData, auth, header);
        if(constants.Jamf_NG == ret ){
            log.error("N2ResourceRelease NG");
            return;
        }
        return;
    }

    private int chk_reqType(AMFN1N2MessageData rcvBody){
        ObjectMapper objectMapper = new ObjectMapper();
        AMFN1MessageContainer rcv_n1MesContainer = rcvBody.getN1MessageContainer();

        String n1MesContent = null;
        String ngapData = null;

        try{
            n1MesContent = rcv_n1MesContainer.getN1MessageContent();
            uedata = objectMapper.readValue(n1MesContent,UeData.class);
        }catch(NullPointerException e){
            /* n1MesContentは取得できなくてもOK */
            n1MesContent = null;
        }catch(Exception e){
            /* n1MesContentは取得できなくてもOK */
            log.info("Recv Json Data(UeData) parse NG");
            uedata = null;
        }
        try{
            AMFN2InfoContainer rcv_n2Info = rcvBody.getN2InfoContainer();
            List<AMFN2SmInformation> rcv_smInfList = rcv_n2Info.getSmInfo();
            AMFN2SmInformation sminfo = rcv_smInfList.get(0);
            AMFN2InfoContent n2InfoContent = sminfo.getN2InfoContent();
            ngapData = n2InfoContent.getNgapData();
            upfdata = objectMapper.readValue(ngapData, UpfData.class);
        }catch(NullPointerException e){
            /* ngapDataが取得できないと処理継続不可 */
            log.error("get ngapData NG");
            e.printStackTrace();
            return constants.Jamf_NG;
        }catch(Exception e){
            /* ngapDataが取得できないと処理継続不可 */
            log.error("Recv Json Data(UpfData) parse NG");
            log.error("UpfData : {}",upfdata);
            e.printStackTrace();
            return constants.Jamf_NG;
        }

        if( null != uedata && null != upfdata &&
           constants.Jamf_PDUSESESTABLISHMENT == upfdata.getReqType() &&
           constants.Jamf_PDUSESESTABLISHMENT == uedata.getReqType()){
            log.debug("chk_reqType END(Jamf_PDUSESESTABLISHMENT)");
            return constants.Jamf_PDUSESESTABLISHMENT;
        }else if(null != upfdata && constants.Jamf_PDUSESRELEASE == upfdata.getReqType()){
            log.debug("chk_reqType END(Jamf_PDUSESRELEASE)");
            return constants.Jamf_PDUSESRELEASE;
        }else{
            log.error("reqType is not correct(upfdata:{},uedata:{})",upfdata,uedata);
            return constants.Jamf_NG;
        }
     }

    /* parameter check */
    public int chkParam(){
        switch(type){
        case constants.Jamf_COMM_N1N2TRANSFER :
            if(null == ueContextId){
                log.error("ueContextId NG(null)");
                return constants.Jamf_NG;
            }
            if(null == Body){
                log.error("Body NG(null)");
                return constants.Jamf_NG;
            }
        break;
        default:
            log.error("type NG({})", type );
            return constants.Jamf_NG;
        }
        return constants.Jamf_OK;
    }

}


