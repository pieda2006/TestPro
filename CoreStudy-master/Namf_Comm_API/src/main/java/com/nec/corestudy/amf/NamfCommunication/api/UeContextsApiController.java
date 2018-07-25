package com.nec.corestudy.amf.NamfCommunication.api;

import com.nec.corestudy.amf.NamfCommunication.model.AMFAssignEbiData;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAssignEbiError;
import com.nec.corestudy.amf.NamfCommunication.model.AMFAssignedEbiData;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN1N2MessageData;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN1N2MessageTransferError;
import com.nec.corestudy.amf.NamfCommunication.model.AMFN1N2MessageTransferRspData;
import com.nec.corestudy.amf.NamfCommunication.model.AMFProblemDetails;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUEContextRelease;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContextCreateData;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContextCreateError;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContextCreatedData;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContextTransferReqData;
import com.nec.corestudy.amf.NamfCommunication.model.AMFUeContextTransferRspData;
import com.nec.corestudy.amf.CommunicationMng.api.*;
import com.nec.corestudy.amf.common.AMFcommon.*;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-22T15:31:52.210+09:00")

@Controller
public class UeContextsApiController implements UeContextsApi {

    private static final Logger log = LoggerFactory.getLogger(UeContextsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UeContextsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AMFAssignedEbiData> postEBIAssignment(@ApiParam(value = "ueContextId.",required=true) @PathVariable("ueContextId") String ueContextId,@ApiParam(value = "The information required for AMF to allocate EPS bearer ID(s)." ,required=true )  @Valid @RequestBody AMFAssignEbiData assignEbiData) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AMFAssignedEbiData>(objectMapper.readValue("{  \"assignedEbis\" : [ {    \"ebi\" : 1,    \"arp\" : {      \"priorityLevel\" : 6,      \"preemptCap\" : \"Jamf_NOT_PREEMPT\",      \"preemptVuln\" : \"Jamf_NOT_PREEMPTABLE\"    }  }, {    \"ebi\" : 1,    \"arp\" : {      \"priorityLevel\" : 6,      \"preemptCap\" : \"Jamf_NOT_PREEMPT\",      \"preemptVuln\" : \"Jamf_NOT_PREEMPTABLE\"    }  } ],  \"pduSessionId\" : 0,  \"failedArpList\" : [ {    \"priorityLevel\" : 6,    \"preemptCap\" : \"Jamf_NOT_PREEMPT\",    \"preemptVuln\" : \"Jamf_NOT_PREEMPTABLE\"  }, {    \"priorityLevel\" : 6,    \"preemptCap\" : \"Jamf_NOT_PREEMPT\",    \"preemptVuln\" : \"Jamf_NOT_PREEMPTABLE\"  } ],  \"releasedEbiList\" : [ 5, 5 ]}", AMFAssignedEbiData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AMFAssignedEbiData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<AMFAssignedEbiData>(objectMapper.readValue("<null>  <pduSessionId>123</pduSessionId>  <releasedEbiList>123</releasedEbiList></null>", AMFAssignedEbiData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<AMFAssignedEbiData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AMFAssignedEbiData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AMFN1N2MessageTransferRspData> postN1N2MessageTransfer(@ApiParam(value = "ueContextId.",required=true) @PathVariable("ueContextId") String ueContextId,@ApiParam(value = "N1N2MessageData." ,required=true )  @Valid @RequestBody AMFN1N2MessageData n1N2MessageData) {
        String accept = request.getHeader("Accept");
         /* add start */
        log.debug("recv N1N2MessageTransfer");
        log.debug("ueContextId : {}",ueContextId);
        log.debug("n1N2MessageData :{}",n1N2MessageData);
        int ret = constants.Jamf_NG;
        if (accept != null && accept.contains("application/json")) {
            try {
                CommunicationMng comMng = new CommunicationMng(constants.Jamf_COMM_N1N2TRANSFER, ueContextId, null, null, null, n1N2MessageData);
                ret = comMng.chkParam();
                if(constants.Jamf_NG == ret){
                    log.error("postN1N2MessageTransfer NG");
                    return new ResponseEntity<AMFN1N2MessageTransferRspData>(HttpStatus.BAD_REQUEST);
                }
                comMng.start();
                return new ResponseEntity<AMFN1N2MessageTransferRspData>(objectMapper.readValue("{  \"supportedFeatures\" : \"supportedFeatures\",  \"cause\" : \"Jamf_ATTEMPTING_TO_REACH_UE\"}", AMFN1N2MessageTransferRspData.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AMFN1N2MessageTransferRspData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        /* add end */
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<AMFN1N2MessageTransferRspData>(objectMapper.readValue("<null>  <cause>aeiou</cause>  <supportedFeatures>aeiou</supportedFeatures></null>", AMFN1N2MessageTransferRspData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<AMFN1N2MessageTransferRspData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AMFN1N2MessageTransferRspData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postReleaseUEContext(@ApiParam(value = "ueContextId.",required=true) @PathVariable("ueContextId") String ueContextId,@ApiParam(value = "Defines the UE Context to be created." ,required=true )  @Valid @RequestBody AMFUEContextRelease uEContextRelease) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AMFUeContextTransferRspData> postUEContextTransfer(@ApiParam(value = "ueContextId.",required=true) @PathVariable("ueContextId") String ueContextId,@ApiParam(value = "The information required for AMF to allocate EPS bearer ID(s)." ,required=true )  @Valid @RequestBody AMFUeContextTransferReqData ueContextTransferReqData) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AMFUeContextTransferRspData>(objectMapper.readValue("{  \"ueContext\" : {    \"seafData\" : {      \"ngKsi\" : \"ngKsi\",      \"keyAmf\" : \"keyAmf\",      \"TBD\" : \"TBD\"    },    \"drxParameter\" : \"drxParameter\",    \"smsSupport\" : \"Jamf_3GPP\",    \"supiUnauthInd\" : true,    \"groups\" : [ \"groups\", \"groups\" ],    \"sessionContexts\" : [ {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"hsmfId\" : \"hsmfId\",      \"allocatedEbiList\" : [ \"allocatedEbiList\", \"allocatedEbiList\" ],      \"vsmfId\" : \"vsmfId\",      \"dnn\" : \"dnn\",      \"nsInstance\" : \"nsInstance\",      \"pduSessionId\" : 3,      \"sNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 9      },      \"smContextRef\" : \"smContextRef\"    }, {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"hsmfId\" : \"hsmfId\",      \"allocatedEbiList\" : [ \"allocatedEbiList\", \"allocatedEbiList\" ],      \"vsmfId\" : \"vsmfId\",      \"dnn\" : \"dnn\",      \"nsInstance\" : \"nsInstance\",      \"pduSessionId\" : 3,      \"sNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 9      },      \"smContextRef\" : \"smContextRef\"    } ],    \"supi\" : \"supi\",    \"subRfsp\" : 0,    \"gpsi\" : [ \"gpsi\", \"gpsi\" ],    \"pei\" : \"pei\",    \"pcfId\" : \"pcfId\",    \"hpcfId\" : \"hpcfId\",    \"mmContexts\" : [ {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"fiveGmmCapability\" : \"fiveGmmCapability\",      \"nasSecurityMode\" : {        \"integrityAlgorithm\" : \"Jamf_NIA0\",        \"cipheringAlgorithm\" : \"Jamf_NEA0\"      },      \"nasDownlinkCount\" : 5,      \"nssaiMapping\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"allowedNssai\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"nasUplinkCount\" : 2,      \"nsInstances\" : [ \"nsInstances\", \"nsInstances\" ],      \"s1UeNetworkCapability\" : \"s1UeNetworkCapability\",      \"ueSecurityCapability\" : \"ueSecurityCapability\",      \"mobilityRestrictions\" : {        \"ratRestriction\" : [ \"Jamf_NR\", \"Jamf_NR\" ],        \"saRestriction\" : {          \"allowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"nonAllowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"maxAllowedTais\" : 7        },        \"forbiddenArea\" : [ {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        }, {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        } ]      }    }, {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"fiveGmmCapability\" : \"fiveGmmCapability\",      \"nasSecurityMode\" : {        \"integrityAlgorithm\" : \"Jamf_NIA0\",        \"cipheringAlgorithm\" : \"Jamf_NEA0\"      },      \"nasDownlinkCount\" : 5,      \"nssaiMapping\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"allowedNssai\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"nasUplinkCount\" : 2,      \"nsInstances\" : [ \"nsInstances\", \"nsInstances\" ],      \"s1UeNetworkCapability\" : \"s1UeNetworkCapability\",      \"ueSecurityCapability\" : \"ueSecurityCapability\",      \"mobilityRestrictions\" : {        \"ratRestriction\" : [ \"Jamf_NR\", \"Jamf_NR\" ],        \"saRestriction\" : {          \"allowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"nonAllowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"maxAllowedTais\" : 7        },        \"forbiddenArea\" : [ {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        }, {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        } ]      }    } ],    \"usedRfsp\" : 6,    \"smsfId\" : \"smsfId\",    \"eventSubscriptions\" : [ {      \"nfId\" : \"nfId\",      \"pei\" : \"pei\",      \"anyUE\" : true,      \"groupId\" : \"groupId\",      \"notifCorelationId\" : \"notifCorelationId\",      \"notifyUri\" : \"notifyUri\",      \"supi\" : \"supi\",      \"events\" : {        \"area\" : [ {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        }, {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        } ],        \"subscribedDataFilters\" : [ \"Jamf_SARI\", \"Jamf_SARI\" ],        \"options\" : {          \"duration\" : 5,          \"trigger\" : \"Jamf_ONE_TIME\",          \"maxReports\" : 1        },        \"locationFilters\" : [ \"Jamf_TAI\", \"Jamf_TAI\" ],        \"type\" : \"Jamf_LOCATION_REPORT\",        \"immediateFlag\" : true      },      \"gpsi\" : \"gpsi\"    }, {      \"nfId\" : \"nfId\",      \"pei\" : \"pei\",      \"anyUE\" : true,      \"groupId\" : \"groupId\",      \"notifCorelationId\" : \"notifCorelationId\",      \"notifyUri\" : \"notifyUri\",      \"supi\" : \"supi\",      \"events\" : {        \"area\" : [ {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        }, {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        } ],        \"subscribedDataFilters\" : [ \"Jamf_SARI\", \"Jamf_SARI\" ],        \"options\" : {          \"duration\" : 5,          \"trigger\" : \"Jamf_ONE_TIME\",          \"maxReports\" : 1        },        \"locationFilters\" : [ \"Jamf_TAI\", \"Jamf_TAI\" ],        \"type\" : \"Jamf_LOCATION_REPORT\",        \"immediateFlag\" : true      },      \"gpsi\" : \"gpsi\"    } ]  },  \"supportedFeatures\" : \"supportedFeatures\",  \"regCompleteNotifyUri\" : \"regCompleteNotifyUri\"}", AMFUeContextTransferRspData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AMFUeContextTransferRspData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<AMFUeContextTransferRspData>(objectMapper.readValue("<null>  <regCompleteNotifyUri>aeiou</regCompleteNotifyUri>  <supportedFeatures>aeiou</supportedFeatures></null>", AMFUeContextTransferRspData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<AMFUeContextTransferRspData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AMFUeContextTransferRspData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AMFUeContextCreatedData> putCreateUEContext(@ApiParam(value = "ueContextId.",required=true) @PathVariable("ueContextId") String ueContextId,@ApiParam(value = "Defines the UE Context to be created." ,required=true )  @Valid @RequestBody AMFUeContextCreateData ueContextCreateData) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AMFUeContextCreatedData>(objectMapper.readValue("{  \"pduSessions\" : [ {    \"ngapData\" : \"ngapData\",    \"ngapIeType\" : 4  }, {    \"ngapData\" : \"ngapData\",    \"ngapIeType\" : 4  } ],  \"failedSessions\" : [ 6, 6 ],  \"ueContext\" : {    \"seafData\" : {      \"ngKsi\" : \"ngKsi\",      \"keyAmf\" : \"keyAmf\",      \"TBD\" : \"TBD\"    },    \"drxParameter\" : \"drxParameter\",    \"smsSupport\" : \"Jamf_3GPP\",    \"supiUnauthInd\" : true,    \"groups\" : [ \"groups\", \"groups\" ],    \"sessionContexts\" : [ {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"hsmfId\" : \"hsmfId\",      \"allocatedEbiList\" : [ \"allocatedEbiList\", \"allocatedEbiList\" ],      \"vsmfId\" : \"vsmfId\",      \"dnn\" : \"dnn\",      \"nsInstance\" : \"nsInstance\",      \"pduSessionId\" : 3,      \"sNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 9      },      \"smContextRef\" : \"smContextRef\"    }, {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"hsmfId\" : \"hsmfId\",      \"allocatedEbiList\" : [ \"allocatedEbiList\", \"allocatedEbiList\" ],      \"vsmfId\" : \"vsmfId\",      \"dnn\" : \"dnn\",      \"nsInstance\" : \"nsInstance\",      \"pduSessionId\" : 3,      \"sNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 9      },      \"smContextRef\" : \"smContextRef\"    } ],    \"supi\" : \"supi\",    \"subRfsp\" : 0,    \"gpsi\" : [ \"gpsi\", \"gpsi\" ],    \"pei\" : \"pei\",    \"pcfId\" : \"pcfId\",    \"hpcfId\" : \"hpcfId\",    \"mmContexts\" : [ {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"fiveGmmCapability\" : \"fiveGmmCapability\",      \"nasSecurityMode\" : {        \"integrityAlgorithm\" : \"Jamf_NIA0\",        \"cipheringAlgorithm\" : \"Jamf_NEA0\"      },      \"nasDownlinkCount\" : 5,      \"nssaiMapping\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"allowedNssai\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"nasUplinkCount\" : 2,      \"nsInstances\" : [ \"nsInstances\", \"nsInstances\" ],      \"s1UeNetworkCapability\" : \"s1UeNetworkCapability\",      \"ueSecurityCapability\" : \"ueSecurityCapability\",      \"mobilityRestrictions\" : {        \"ratRestriction\" : [ \"Jamf_NR\", \"Jamf_NR\" ],        \"saRestriction\" : {          \"allowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"nonAllowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"maxAllowedTais\" : 7        },        \"forbiddenArea\" : [ {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        }, {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        } ]      }    }, {      \"accessType\" : \"Jamf_3GPP_ACCESS\",      \"fiveGmmCapability\" : \"fiveGmmCapability\",      \"nasSecurityMode\" : {        \"integrityAlgorithm\" : \"Jamf_NIA0\",        \"cipheringAlgorithm\" : \"Jamf_NEA0\"      },      \"nasDownlinkCount\" : 5,      \"nssaiMapping\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"allowedNssai\" : [ {        \"sd\" : \"sd\",        \"sst\" : 9      }, {        \"sd\" : \"sd\",        \"sst\" : 9      } ],      \"nasUplinkCount\" : 2,      \"nsInstances\" : [ \"nsInstances\", \"nsInstances\" ],      \"s1UeNetworkCapability\" : \"s1UeNetworkCapability\",      \"ueSecurityCapability\" : \"ueSecurityCapability\",      \"mobilityRestrictions\" : {        \"ratRestriction\" : [ \"Jamf_NR\", \"Jamf_NR\" ],        \"saRestriction\" : {          \"allowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"nonAllowedTais\" : [ \"Jamf_NR\", \"Jamf_NR\" ],          \"maxAllowedTais\" : 7        },        \"forbiddenArea\" : [ {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        }, {          \"tac\" : \"tac\",          \"plmnId\" : {            \"mnc\" : \"mnc\",            \"mcc\" : \"mcc\"          }        } ]      }    } ],    \"usedRfsp\" : 6,    \"smsfId\" : \"smsfId\",    \"eventSubscriptions\" : [ {      \"nfId\" : \"nfId\",      \"pei\" : \"pei\",      \"anyUE\" : true,      \"groupId\" : \"groupId\",      \"notifCorelationId\" : \"notifCorelationId\",      \"notifyUri\" : \"notifyUri\",      \"supi\" : \"supi\",      \"events\" : {        \"area\" : [ {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        }, {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        } ],        \"subscribedDataFilters\" : [ \"Jamf_SARI\", \"Jamf_SARI\" ],        \"options\" : {          \"duration\" : 5,          \"trigger\" : \"Jamf_ONE_TIME\",          \"maxReports\" : 1        },        \"locationFilters\" : [ \"Jamf_TAI\", \"Jamf_TAI\" ],        \"type\" : \"Jamf_LOCATION_REPORT\",        \"immediateFlag\" : true      },      \"gpsi\" : \"gpsi\"    }, {      \"nfId\" : \"nfId\",      \"pei\" : \"pei\",      \"anyUE\" : true,      \"groupId\" : \"groupId\",      \"notifCorelationId\" : \"notifCorelationId\",      \"notifyUri\" : \"notifyUri\",      \"supi\" : \"supi\",      \"events\" : {        \"area\" : [ {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        }, {          \"ngRanId\" : [ \"ngRanId\", \"ngRanId\" ],          \"areaId\" : \"areaId\",          \"ncgi\" : [ {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          }, {            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            },            \"nrCellId\" : \"nrCellId\"          } ],          \"trackingAreas\" : {            \"tac\" : \"tac\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          },          \"ladn\" : \"ladn\",          \"ecgi\" : [ {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          }, {            \"eutraCellId\" : \"eutraCellId\",            \"plmnId\" : {              \"mnc\" : \"mnc\",              \"mcc\" : \"mcc\"            }          } ]        } ],        \"subscribedDataFilters\" : [ \"Jamf_SARI\", \"Jamf_SARI\" ],        \"options\" : {          \"duration\" : 5,          \"trigger\" : \"Jamf_ONE_TIME\",          \"maxReports\" : 1        },        \"locationFilters\" : [ \"Jamf_TAI\", \"Jamf_TAI\" ],        \"type\" : \"Jamf_LOCATION_REPORT\",        \"immediateFlag\" : true      },      \"gpsi\" : \"gpsi\"    } ]  },  \"targetToSourceData\" : {    \"n2InformationClass\" : \"Jamf_SM\",    \"areaOfValidity\" : {      \"taList\" : [ {        \"tac\" : \"tac\",        \"plmnId\" : {          \"mnc\" : \"mnc\",          \"mcc\" : \"mcc\"        }      }, {        \"tac\" : \"tac\",        \"plmnId\" : {          \"mnc\" : \"mnc\",          \"mcc\" : \"mcc\"        }      } ]    },    \"smInfo\" : [ {      \"nasPdu\" : 7,      \"subjectToHo\" : true,      \"pduSessionId\" : 2,      \"n2InfoContent\" : {        \"ngapData\" : \"ngapData\",        \"ngapIeType\" : 4      },      \"sNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 9      }    }, {      \"nasPdu\" : 7,      \"subjectToHo\" : true,      \"pduSessionId\" : 2,      \"n2InfoContent\" : {        \"ngapData\" : \"ngapData\",        \"ngapIeType\" : 4      },      \"sNssai\" : {        \"sd\" : \"sd\",        \"sst\" : 9      }    } ],    \"pwsInfo\" : {      \"serialNumber\" : 1,      \"messageIdentifier\" : 1,      \"sendN2Container\" : true,      \"pwsContainer\" : {        \"ngapData\" : \"ngapData\",        \"ngapIeType\" : 4      },      \"omcId\" : \"omcId\"    },    \"nrppaInfo\" : {      \"routingId\" : \"routingId\",      \"nrppaPdu\" : {        \"ngapData\" : \"ngapData\",        \"ngapIeType\" : 4      }    }  },  \"supportedFeatures\" : \"supportedFeatures\",  \"ngapCause\" : 1}", AMFUeContextCreatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AMFUeContextCreatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<AMFUeContextCreatedData>(objectMapper.readValue("<null>  <ngapCause>123</ngapCause>  <failedSessions>123</failedSessions>  <supportedFeatures>aeiou</supportedFeatures></null>", AMFUeContextCreatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<AMFUeContextCreatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AMFUeContextCreatedData>(HttpStatus.NOT_IMPLEMENTED);
    }

}
