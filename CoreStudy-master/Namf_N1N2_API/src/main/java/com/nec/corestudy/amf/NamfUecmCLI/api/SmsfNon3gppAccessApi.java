/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.nec.corestudy.amf.NamfUecmCLI.api;

import com.nec.corestudy.amf.NamfUecmCLI.model.SmsfRegistration;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-15T18:19:23.613+09:00")

@Api(value = "SmsfNon3gppAccess", description = "the SmsfNon3gppAccess API")
public interface SmsfNon3gppAccessApi {

    @ApiOperation(value = "smsf-non-3gpp-access.", nickname = "deleteSmsfNon3gppAccess", notes = "see 29.503 6.2.3.7", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No Content.") })
    @RequestMapping(value = "/{ueId}/registrations/smsf-non-3gpp-access",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSmsfNon3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId);


    @ApiOperation(value = "smsf-non-3gpp-access.", nickname = "getSmsfNon3gppAccess", notes = "see 29.503 6.2.3.7", response = SmsfRegistration.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK.", response = SmsfRegistration.class) })
    @RequestMapping(value = "/{ueId}/registrations/smsf-non-3gpp-access",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.GET)
    ResponseEntity<SmsfRegistration> getSmsfNon3gppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "")  @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures);


    @ApiOperation(value = "smsf-non-3gpp-access.", nickname = "putSmsfNon3GppAccess", notes = "see 29.503 6.2.3.7", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No Content.") })
    @RequestMapping(value = "/{ueId}/registrations/smsf-non-3gpp-access",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> putSmsfNon3GppAccess(@ApiParam(value = "ueId. ",required=true) @PathVariable("ueId") String ueId,@ApiParam(value = "The SMSF registration for non 3GPP access is created or updated with the received information." ,required=true )   @RequestBody SmsfRegistration smsfRegistration);

}