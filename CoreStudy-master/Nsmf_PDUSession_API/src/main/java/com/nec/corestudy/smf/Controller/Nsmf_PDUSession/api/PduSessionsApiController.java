package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.api;

import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.HsmfUpdateData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.HsmfUpdatedData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.PduSessionCreateData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.PduSessionCreatedData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.ReleaseData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.ReleasedData;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

@Controller
public class PduSessionsApiController implements PduSessionsApi {

    private static final Logger log = LoggerFactory.getLogger(PduSessionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PduSessionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PduSessionCreatedData> createPDUSession(@ApiParam(value = "Representation of the SM context to be created in the SMF"  )  @Valid @RequestBody PduSessionCreateData body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<PduSessionCreatedData>(objectMapper.readValue("<PduSessionCreatedData>  <enablePauseCharging>true</enablePauseCharging></PduSessionCreatedData>", PduSessionCreatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<PduSessionCreatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PduSessionCreatedData>(objectMapper.readValue("{  \"enablePauseCharging\" : true,  \"sessionAmbr\" : {    \"uplink\" : { },    \"downlink\" : null  },  \"qosFlowsSetupList\" : {    \"qosFlowItem\" : {      \"qosFlowProfile\" : {        \"dynamic5qi\" : {          \"delayCritical\" : { },          \"packetDelBudget\" : \"\",          \"priorityLevel\" : null,          \"maxDataBurstVol\" : \"\",          \"packetErrRate\" : \"\",          \"averWindow\" : \"\"        },        \"rqa\" : { },        \"gbrQosFlowInfo\" : {          \"maxFbrDl\" : null,          \"notifControl\" : { },          \"maxFbrUl\" : null,          \"maxPacketLossRateUl\" : null,          \"maxPacketLossRateDl\" : { },          \"guaFbrUl\" : null,          \"guaFbrDl\" : null        },        \"5qi\" : { },        \"nonDynamic5qi\" : {          \"priorityLevel\" : { },          \"maxDataBurstVol\" : \"\",          \"averWindow\" : \"\"        },        \"arp\" : {          \"priorityLevel\" : { },          \"preemptCap\" : { },          \"preemptVuln\" : { }        }      },      \"qosRules\" : { },      \"qfi\" : { }    }  },  \"pgwS8fteid\" : {    \"ipv6Addr\" : { },    \"gtpTeid\" : \"gtpTeid\",    \"ipv4Addr\" : { }  },  \"supportedFeatures\" : { },  \"pduSessionType\" : { },  \"n1SmInfoToUe\" : {    \"contentId\" : \"contentId\"  },  \"hcnTunnelInfo\" : {    \"ipv6Addr\" : { },    \"gtpTeid\" : \"gtpTeid\",    \"ipv4Addr\" : { }  },  \"ueIpv4Address\" : null,  \"ueIpv6Prefix\" : { }}", PduSessionCreatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PduSessionCreatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PduSessionCreatedData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ReleasedData> releasePDUSession(@ApiParam(value = "",required=true) @PathVariable("pduSessionRef") Long pduSessionRef,@ApiParam(value = "Representation of the data to be sent to the SMF when releasing the SM context."  )  @Valid @RequestBody ReleaseData body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<ReleasedData>(objectMapper.readValue("<ReleasedData>  <ffs>aeiou</ffs></ReleasedData>", ReleasedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<ReleasedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ReleasedData>(objectMapper.readValue("{  \"ffs\" : \"ffs\"}", ReleasedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ReleasedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ReleasedData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<HsmfUpdatedData> updatePDUSession(@ApiParam(value = "PDU session reference",required=true) @PathVariable("pduSessionRef") Long pduSessionRef,@ApiParam(value = "Representation of the updates to apply to the SM context." ,required=true )  @Valid @RequestBody HsmfUpdateData body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<HsmfUpdatedData>(objectMapper.readValue("<HsmfUpdatedData>  <enablePauseCharging>true</enablePauseCharging></HsmfUpdatedData>", HsmfUpdatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<HsmfUpdatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<HsmfUpdatedData>(objectMapper.readValue("{  \"enablePauseCharging\" : true,  \"sessionAmbr\" : {    \"uplink\" : { },    \"downlink\" : null  },  \"qosFlowsSetupList\" : {    \"qosFlowItem\" : {      \"qosFlowProfile\" : {        \"dynamic5qi\" : {          \"delayCritical\" : { },          \"packetDelBudget\" : \"\",          \"priorityLevel\" : null,          \"maxDataBurstVol\" : \"\",          \"packetErrRate\" : \"\",          \"averWindow\" : \"\"        },        \"rqa\" : { },        \"gbrQosFlowInfo\" : {          \"maxFbrDl\" : null,          \"notifControl\" : { },          \"maxFbrUl\" : null,          \"maxPacketLossRateUl\" : null,          \"maxPacketLossRateDl\" : { },          \"guaFbrUl\" : null,          \"guaFbrDl\" : null        },        \"5qi\" : { },        \"nonDynamic5qi\" : {          \"priorityLevel\" : { },          \"maxDataBurstVol\" : \"\",          \"averWindow\" : \"\"        },        \"arp\" : {          \"priorityLevel\" : { },          \"preemptCap\" : { },          \"preemptVuln\" : { }        }      },      \"qosRules\" : { },      \"qfi\" : { }    }  },  \"n1SmInfoToUe\" : {    \"contentId\" : \"contentId\"  },  \"pduSessionType\" : { },  \"pduSessionId\" : { }}", HsmfUpdatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<HsmfUpdatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<HsmfUpdatedData>(HttpStatus.NOT_IMPLEMENTED);
    }

}
