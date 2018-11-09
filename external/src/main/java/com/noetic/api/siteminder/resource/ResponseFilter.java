package com.noetic.api.siteminder.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@Component
public class ResponseFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(ResponseFilter.class);

    @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        java.util.Date date = new java.util.Date();

        log.info("Init ==================>{}<==================", new Timestamp(date.getTime()));
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        long startTime = System.currentTimeMillis();

        log.info("Before ==================>{}<==================", new Timestamp(new java.util.Date().getTime()));
        try {

            //Cross-origin resource sharing (CORS), setting to allow access from any "Origin"
            response.setHeader("Access-Control-Allow-Origin",
                    request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers",
                    "Content-Type, Accept, X-Requested-With, remember-me, Authorization");

            filterChain.doFilter(servletRequest, servletResponse);
        }catch(Exception e) {
            log.error(e.getMessage());
        }
        long endTime = System.currentTimeMillis();

        log.info("After ==================>{}<==================", new Timestamp(new java.util.Date().getTime()));
        log.info("Time taken in Millis ==================>{}<==================", endTime - startTime);
    }

    @Override
    public void destroy() {
        java.util.Date date = new java.util.Date();

        log.info("Destroy ==================>{}<==================", new Timestamp(date.getTime()));
    }
}
