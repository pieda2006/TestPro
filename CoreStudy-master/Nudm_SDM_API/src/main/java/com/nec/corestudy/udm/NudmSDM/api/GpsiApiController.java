package com.nec.corestudy.udm.NudmSDM.api;

import com.nec.corestudy.udm.NudmSDM.model.IdTranslationResult;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T19:47:33.905+09:00")

@Controller
public class GpsiApiController implements GpsiApi {

    private static final Logger log = LoggerFactory.getLogger(GpsiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GpsiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<IdTranslationResult> getIdTranslationResult(@ApiParam(value = "",required=true) @PathVariable("gpsi") String gpsi,@ApiParam(value = "[TBD].") @Valid @RequestParam(value = "supportedFeatures", required = false) String supportedFeatures) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<IdTranslationResult>(objectMapper.readValue("<null>  <supportedFeatures>aeiou</supportedFeatures>  <supi>aeiou</supi>  <gpsi>aeiou</gpsi></null>", IdTranslationResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<IdTranslationResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<IdTranslationResult>(objectMapper.readValue("{  \"supportedFeatures\" : \"supportedFeatures\",  \"supi\" : \"supi\",  \"gpsi\" : \"gpsi\"}", IdTranslationResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<IdTranslationResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<IdTranslationResult>(HttpStatus.NOT_IMPLEMENTED);
    }

}
