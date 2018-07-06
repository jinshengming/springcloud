package net.htjs.pt4.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author ming.js
 * @Date 2018/6/15
 */
@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public String globalExceptionHandler(HttpServletRequest request, Exception exp){

        log.error(exp.getMessage());
        exp.printStackTrace();
        return "Exception, Contact The Administrator";
    }
}
