package com.noetic.api.siteminder.resource.v1;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noetic.api.siteminder.config.DeployProfileConfig;
import com.noetic.common.v1.dto.MessageDTO;
import com.noetic.common.v1.dto.ResponseDTO;
import com.noetic.common.v1.enums.ResultStatus;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@RestController(value = "SITEMINDERResourceImplV1")
public class SiteminderResourceImpl implements SiteminderResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteminderResourceImpl.class);
    private HttpClient httpClient = HttpClientBuilder.create().build();
    private ObjectMapper objMapper = new ObjectMapper();
    private ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_COMMENTS, true);

    @Value("${default.base.endpoint}")
    private String baseURL;

    /**
     * Update Request Header with Basic authorisation
     *
     * @param deployProfileConfig
     * @param httpRequest
     */
    private void updateAuthorization(String xAuthorisation, DeployProfileConfig deployProfileConfig,
            HttpRequestBase httpRequest) {

        byte[] credentials = Base64.encodeBase64(
                (deployProfileConfig.getInternalApiUsername() + ":" + deployProfileConfig.getInternalApiPassword())
                        .getBytes(StandardCharsets.UTF_8));
        httpRequest.setHeader("Authorization", "Basic " + new String(credentials, StandardCharsets.UTF_8));
        if (xAuthorisation != null) {
            httpRequest.setHeader("X-Authorisation", xAuthorisation);

        }
    }

    @SuppressWarnings("rawtypes")
    public boolean isEmptyParameter(String paramVal, String paramName, ResponseDTO response) {

        if ((paramVal != null) && (!paramVal.isEmpty()) && !"string".equals(paramVal)) {
            return false;
        }
        response.setHttpCode(response.getHttpStatus() != null ? response.getHttpStatus().toString()
                : HttpStatus.BAD_REQUEST.toString());
        response.setMessage(new MessageDTO("Valid value is required for request parameter: " + paramName));

        response.setHttpStatus(HttpStatus.BAD_REQUEST);

        return true;
    }

    // ==============================================================================================

    @SuppressWarnings("rawtypes")
    public boolean isEmptyParameter(int paramVal, String paramName, ResponseDTO response) {

        if (paramVal != 0) {
            return false;
        }
        response.setHttpCode(response.getHttpStatus() != null ? response.getHttpStatus().toString()
                : HttpStatus.BAD_REQUEST.toString());
        response.setMessage(new MessageDTO("Valid value is required for request parameter: " + paramName));

        response.setHttpStatus(HttpStatus.BAD_REQUEST);

        return true;
    }

    private void setupRequestHeader(HttpPut httpRequest) {
        httpRequest.setHeader("Content-Type", "application/json");
        httpRequest.setHeader("Connection", "keep-alive");
    }

    /**
     * 
     * @param response
     * @param message
     * @param e
     */
    private void updateResponse(ResponseDTO<?> response, String message, Exception e) {
        response.setResultStatus(ResultStatus.FAILED);
        response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        LOGGER.error("Error  {} ,  {}", message, e);
        response.setMessage(new MessageDTO(e.getMessage()));
    }
    // ==============================================================================================
}
