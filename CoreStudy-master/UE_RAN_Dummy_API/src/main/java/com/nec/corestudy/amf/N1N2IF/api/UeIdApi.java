/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.nec.corestudy.amf.N1N2IF.api;

import com.nec.corestudy.amf.N1N2IF.model.AMFN2PduSesReqData;
import com.nec.corestudy.amf.N1N2IF.model.AMFN2ResRelReqData;
import com.nec.corestudy.amf.N1N2IF.model.AMFRegistrationAccData;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-12T20:14:44.512+09:00")

@Api(value = "{ueId}", description = "the {ueId} API")
public interface UeIdApi {

    @ApiOperation(value = "N2 PDU Session Request", nickname = "postN2PDUSessionRequest", notes = "", tags={ "N2 PDU Session Request", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK.") })
    @RequestMapping(value = "/{ueId}/n2pdu-session/request",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postN2PDUSessionRequest(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFN2PduSesReqData n2PduSesReqData);


    @ApiOperation(value = "N2 Resource Release Request", nickname = "postN2ResourceReleaseRequest", notes = "", tags={ "N2 Resource Release Request", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK.") })
    @RequestMapping(value = "/{ueId}/n2resource-release/request",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postN2ResourceReleaseRequest(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFN2ResRelReqData n2ResRelReqData);


    @ApiOperation(value = "Registration Accept", nickname = "postRegistrationAccept", notes = "", tags={ "Registration Accept", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK.") })
    @RequestMapping(value = "/{ueId}/registration/accept",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postRegistrationAccept(@ApiParam(value = "ueId.",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = ""  )  @Valid @RequestBody AMFRegistrationAccData regAccData);

}