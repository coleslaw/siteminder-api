package com.noetic.siteminder.service.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noetic.exception.InvalidInputExceptionJson;
import com.noetic.siteminder.config.DeployProfileConfig;
import com.noetic.siteminder.config.DeployProfileConfigFactory;
import com.noetic.siteminder.domain.internal.RunTimeConfig;
import com.noetic.siteminder.enums.RunTimeTag;
import com.noetic.siteminder.service.admin.RunTimeConfigService;
import com.noetic.siteminder.util.SiteminderUtil;

/**
 * @author Ruwan Chathuranga on 03rd Aug 2018
 */
@Component
public class CurrencyMonitorClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyMonitorClient.class);
    private CloseableHttpClient httpClient;
    private DeployProfileConfig deployProfileConfig;
    
    private static final String CURRENCY_API_USERNAME = "currencyApiUserName";
    private static final String CURRENCY_API_PASSWORD = "currencyApiPassword";
    
    @Autowired
    private RunTimeConfigService runTimeConfigService;
    
    @PostConstruct
    public void init() {

        try {
            LOGGER.debug("PostConstruct");

            SSLContext sslContext = SSLContexts.custom().build();

            SSLConnectionSocketFactory socket = new SSLConnectionSocketFactory(sslContext,
                    new String[] { "TLSv1", "TLSv1.1", "TLSv1.2" }, null, new DefaultHostnameVerifier());

            httpClient = HttpClients.custom().setSSLSocketFactory(socket).build();

            deployProfileConfig = DeployProfileConfigFactory.forEnvironment();

        } catch (Exception e) {
            LOGGER.warn("Error initialising SSL {} ", e.getMessage());
        }
    }
    
    public String doPost(String payload, String url) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        LOGGER.debug("API Client POST to {} message: {}", url, payload);
        String body = "";

        try {

            // set headers
            deployProfileConfig = DeployProfileConfigFactory.forEnvironment();

            // set headers
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Connection", "keep-alive");

            updateAuthorization(deployProfileConfig, httpPost);

            if (payload != null && !payload.isEmpty()) {
                httpPost.setEntity(new StringEntity(payload, StandardCharsets.UTF_8));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);

            int code = response.getStatusLine().getStatusCode();
            String reason = response.getStatusLine().getReasonPhrase();

            if (code == HttpServletResponse.SC_OK) {
                LOGGER.debug("POST response body {}", body);
                body = getBody(response);

            } else {
                LOGGER.error("API http post error [{}] {} response body {}", code, reason, body);
            }
            response.close();

        } catch (Exception e) {
            LOGGER.error("Error {}", e.getMessage(), e);
        }
        return body;
    }
    
    /**
     * Converts Json to String
     *
     * @param response
     * @return
     * @throws IOException
     * @throws InvalidInputExceptionJson 
     */
    private String getBody(CloseableHttpResponse response)
            throws InvalidInputExceptionJson, IOException {

        return SiteminderUtil.convertStreamToString(response.getEntity().getContent());
    }
    
    /**
     * Update Request Header with Basic authorization
     *
     * @param deployProfileConfig
     * @param httpRequest
     * @throws Exception
     */
    private void updateAuthorization(DeployProfileConfig deployProfileConfig, HttpRequestBase httpRequest)
            throws Exception {

        Map<String, RunTimeConfig> configs = runTimeConfigService
                .getRuntimeConfigCached(deployProfileConfig.getDeployProfile(), RunTimeTag.DEPLOY_CONFIG);

        byte[] credentials = null;

        credentials = Base64.encodeBase64((configs.get(CURRENCY_API_USERNAME).getConfigValue() + ":"
                + configs.get(CURRENCY_API_PASSWORD).getConfigValue()).getBytes(StandardCharsets.UTF_8));

        httpRequest.setHeader("Authorization", "Basic " + new String(credentials, StandardCharsets.UTF_8));
    }

}
