package com.noetic.siteminder.service.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noetic.siteminder.config.DeployProfileConfig;
import com.noetic.siteminder.config.DeployProfileConfigFactory;
import com.noetic.siteminder.domain.internal.RunTimeConfig;
import com.noetic.siteminder.enums.RunTimeTag;
import com.noetic.siteminder.service.admin.RunTimeConfigService;

/**
 * Created by hurman on 13/07/2017.
 */
@Component
public class ImperialClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImperialClient.class);
    private transient CloseableHttpClient httpClient;
    private transient DeployProfileConfig deployProfileConfig;
    
    private static final String IMPERIAL_USER_NAME = "imperialUsername";
    private static final String IMPERIAL_PASSWORD = "imperialPassword";
    private static final String IMPERIAL_CMS_PASSWORD = "imperialCmsPassword";

    @Autowired
    private RunTimeConfigService runTimeConfigService; 

    @PostConstruct
    public void init() {

        try {
            LOGGER.debug("PostConstruct");

            TrustStrategy trustStrategy = new TrustSelfSignedStrategy();

            /**
             * Front end TLSv1 has been removed, HTTP client defaults to use SSL
             * which will fail on handshake.
             * Have to specify
             */
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS() // Only this turned out to be not enough
                    .build();
            SSLConnectionSocketFactory socket = new SSLConnectionSocketFactory(
                    sslContext, new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"}, null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
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

            updateAuthorization(deployProfileConfig, httpPost, false);

            if (payload != null && !payload.isEmpty()) {
                httpPost.setEntity(new StringEntity(payload, StandardCharsets.UTF_8));
            }

            CloseableHttpResponse response = httpClient.execute(httpPost);
            body = getBody(response);

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

    public String doGet(String url, boolean isCmsEndpoint) throws IOException {

        init();

        HttpGet httpGet = new HttpGet(url);
        LOGGER.debug("RequestURL to Guest Login : {}", httpGet.getURI());
        String body = "";

        try {

            deployProfileConfig = DeployProfileConfigFactory.forEnvironment();

            // set headers
            httpGet.setHeader("Content-Type", "application/json");
            httpGet.setHeader("Connection", "keep-alive");

            updateAuthorization(deployProfileConfig, httpGet, isCmsEndpoint);

            CloseableHttpResponse response = httpClient.execute(httpGet);

            int code = response.getStatusLine().getStatusCode();
            String reason = response.getStatusLine().getReasonPhrase();

            if (code == HttpServletResponse.SC_OK) {
                LOGGER.debug("GET response body {}", body);
                body = getBody(response);

            } else {
                LOGGER.error("API http get error [{}] {} response body {}", code, reason, body);
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
     */
    private String getBody(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, "UTF-8");
    }

    /**
     * Update Request Header with Basic authorisation
     *
     * @param deployProfileConfig
     * @param httpRequest
     * @throws Exception 
     */
    private void updateAuthorization(DeployProfileConfig deployProfileConfig, HttpRequestBase httpRequest,
            boolean isCmsEndpoint) throws Exception {

        byte[] credentials = null;

        Map<String, RunTimeConfig> configs = runTimeConfigService
                .getRuntimeConfigCached(deployProfileConfig.getDeployProfile(), RunTimeTag.DEPLOY_CONFIG);

        if (isCmsEndpoint) {

            credentials = Base64.encodeBase64((configs.get(IMPERIAL_USER_NAME).getConfigValue() + ":"
                    + configs.get(IMPERIAL_CMS_PASSWORD).getConfigValue()).getBytes(StandardCharsets.UTF_8));
        } else {
            credentials = Base64.encodeBase64((configs.get(IMPERIAL_USER_NAME).getConfigValue() + ":"
                    + configs.get(IMPERIAL_PASSWORD).getConfigValue()).getBytes(StandardCharsets.UTF_8));
        }

        httpRequest.setHeader("Authorization", "Basic " + new String(credentials, StandardCharsets.UTF_8));
    }
}
