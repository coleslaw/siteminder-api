package com.noetic.dto;

import com.noetic.common.v1.enums.ResultStatus;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created by hurman on 09/11/2017.
 */
public class ErrorDTO implements Serializable {

    private String error;
    private ResultStatus resultStatus;
    private HttpStatus httpStatus;
    private String httpCode;

    public ErrorDTO(String error, ResultStatus resultStatus, HttpStatus httpStatus, String httpCode) {
        this.error = error;
        this.resultStatus = resultStatus;
        this.httpStatus = httpStatus;
        this.httpCode = httpCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }

    @Override
    public String toString() {
        return "Error: " + error + ", " +
                "ResultStatus: " + resultStatus + ", " +
                "HttpStatus: " + httpStatus + ", " +
                "HttpCode: " + httpCode;
    }
}
