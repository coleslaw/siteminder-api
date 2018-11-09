package com.noetic.dto.google;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * @author Ruwan Chathuranga created on 26-04-2018
 *
 */
@JacksonXmlRootElement(localName = "RunTimeConfigCacheRefresh")
public class RunTimeConfigCacheRefresh implements Serializable {
    
    public RunTimeConfigCacheRefresh() {
    }

    private static final long serialVersionUID = 3550321250032977032L;

    @JacksonXmlProperty(isAttribute = true)
    private long timestamp;

    @JacksonXmlProperty(isAttribute = true)
    private boolean status;

    @JacksonXmlProperty(isAttribute = true)
    private String message;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
