/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.nec.corestudy.amf.GTPU_GNB1_CLI.api;

import com.nec.corestudy.amf.GTPU_GNB1_CLI.model.CreategtpuGnb;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-12T13:57:30.887+09:00")

@Api(value = "TunnelCreate", description = "the TunnelCreate API")
public interface TunnelCreateApi {

    @ApiOperation(value = "Tunnel Create", nickname = "tunnelCreate", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "successful operation") })
    @RequestMapping(value = "/{teid}/",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<?> tunnelCreate(@ApiParam(value = "",required=true) @PathVariable("teid") Integer teid,@ApiParam(value = "" ,required=true )   @RequestBody CreategtpuGnb body);

}