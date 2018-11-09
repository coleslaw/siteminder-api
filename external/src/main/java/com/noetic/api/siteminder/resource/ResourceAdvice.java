package com.noetic.api.siteminder.resource;

import com.noetic.common.v1.dto.MessageDTO;
import com.noetic.common.v1.dto.ResponseDTO;
import com.noetic.common.v1.enums.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@ControllerAdvice
@Controller
public class ResourceAdvice {

    private static Logger log = LoggerFactory.getLogger(ResourceAdvice.class);

    @ModelAttribute
    public void addAttributes(Model model) {
        log.info("ResourceAdvice");
    }

    @ExceptionHandler({Exception.class })
    @ResponseBody
    public ResponseEntity<?> handleAnyException(Exception e) {
        return errorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ UsernameNotFoundException.class, AuthenticationException.class})
    @ResponseBody
    public ResponseEntity<?> handleAuthenticationException(Exception e) {
        return errorResponse(e, HttpStatus.UNAUTHORIZED);
    }

    /**
     *
     * @param throwable
     * @param status
     * @return
     */

    protected ResponseEntity<?> errorResponse(Throwable throwable, HttpStatus status) {
        ResponseDTO<?> response = new ResponseDTO<>();
        response.setResultStatus(ResultStatus.FAILED);
        response.setHttpStatus(status);
        response.setHttpCode(status.toString());
        if (null != throwable) {
            log.error("Error  {} ,  {}", "Exception", throwable.getMessage());
            response.setMessage(new MessageDTO(throwable.getMessage()));
        }

        return response(response, status);
    }

    /**
     *
     * @param body
     * @param status
     * @param <T>
     * @return
     */
    protected <T> ResponseEntity<T> response(T body, HttpStatus status) {
        return new ResponseEntity<T>(body, new HttpHeaders(), status);
    }

}
