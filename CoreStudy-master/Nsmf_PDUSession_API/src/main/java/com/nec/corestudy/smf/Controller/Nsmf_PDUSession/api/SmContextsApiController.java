package com.nec.corestudy.smf.Controller.Nsmf_PDUSession.api;

import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.ProblemDetails;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextCreateData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextCreatedData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextQueriedData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextReleaseData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextReleasedData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextUpdateData;
import com.nec.corestudy.smf.Controller.Nsmf_PDUSession.model.SmContextUpdatedData;
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

/* apl add start */
import com.nec.corestudy.smf.Service.Service_Exe.*;
/* apl add end   */

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-11T17:31:20.195+09:00")

@Controller
public class SmContextsApiController implements SmContextsApi {

    private static final Logger log = LoggerFactory.getLogger(SmContextsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SmContextsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<SmContextCreatedData> createSMContext(@ApiParam(value = "Representation of the SM context to be created in the SMF" ,required=true )  @Valid @RequestBody SmContextCreateData body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<SmContextCreatedData>(objectMapper.readValue("<SmContextCreatedData></SmContextCreatedData>", SmContextCreatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<SmContextCreatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
//            try {

                /* SP.4 add start */
                createSMContext_exe ServiceClass = new createSMContext_exe();
                SmContextCreatedData resp_body = ServiceClass.execute(body);
                return new ResponseEntity<SmContextCreatedData>(resp_body, HttpStatus.CREATED);
                /* SP.4 add end   */

//                return new ResponseEntity<SmContextCreatedData>(objectMapper.readValue("{  \"n2SmInfo\" : {    \"contentId\" : \"contentId\"  },  \"allocatedEbiList\" : {    \"epsBearerId\" : { }  },  \"hoState\" : { },  \"supportedFeatures\" : { },  \"upCnxState\" : { },  \"pduSessionId\" : { }}", SmContextCreatedData.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<SmContextCreatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
        }

        return new ResponseEntity<SmContextCreatedData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SmContextQueriedData> querySMContext(@ApiParam(value = "SM context reference",required=true) @PathVariable("smContextRef") Long smContextRef) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<SmContextQueriedData>(objectMapper.readValue("<null></null>", SmContextQueriedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<SmContextQueriedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SmContextQueriedData>(objectMapper.readValue("{  \"ueEpsPdnConnection\" : { }}", SmContextQueriedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SmContextQueriedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SmContextQueriedData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SmContextReleasedData> releaseSMContext(@ApiParam(value = "",required=true) @PathVariable("smContextRef") String smContextRef,@ApiParam(value = "Representation of the data to be sent to the SMF when releasing the SM context."  )  @Valid @RequestBody SmContextReleaseData body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<SmContextReleasedData>(objectMapper.readValue("<null></null>", SmContextReleasedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<SmContextReleasedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
//            try {

                /* SP.7 Detach add start */
                releaseSMContext_exe ServiceClass = new releaseSMContext_exe();
                SmContextReleasedData resp_body = ServiceClass.execute(smContextRef,body);
                return new ResponseEntity<SmContextReleasedData>(HttpStatus.NO_CONTENT);
                /* SP.7 Detach add end   */

//                return new ResponseEntity<SmContextReleasedData>(objectMapper.readValue("{  \"ffs\" : { }}", SmContextReleasedData.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<SmContextReleasedData>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
        }

        return new ResponseEntity<SmContextReleasedData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SmContextUpdatedData> updateSMContext(@ApiParam(value = "SM context reference",required=true) @PathVariable("smContextRef") Long smContextRef,@ApiParam(value = "Representation of the updates to apply to the SM context." ,required=true )  @Valid @RequestBody SmContextUpdateData body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<SmContextUpdatedData>(objectMapper.readValue("<SmContextUpdatedData>  <dataForwarding>true</dataForwarding></SmContextUpdatedData>", SmContextUpdatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<SmContextUpdatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SmContextUpdatedData>(objectMapper.readValue("{  \"dataForwarding\" : true,  \"allocatedEbiList\" : {    \"epsBearerId\" : { }  },  \"n2SmInfo\" : {    \"contentId\" : \"contentId\"  },  \"hoState\" : { },  \"upCnxState\" : { },  \"epsBearerSetup\" : { },  \"n1SmMsg\" : {    \"contentId\" : \"contentId\"  },  \"pduSessionId\" : { },  \"releaseEbiList\" : {    \"epsBearerId\" : { }  }}", SmContextUpdatedData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SmContextUpdatedData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SmContextUpdatedData>(HttpStatus.NOT_IMPLEMENTED);
    }

}
