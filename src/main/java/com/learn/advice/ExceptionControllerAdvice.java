package com.learn.advice;

import com.learn.model.RestErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mohammad on 13/3/17.
 */
@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

  @ResponseBody
  @ExceptionHandler(Exception.class)
  public ResponseEntity exception(Exception exception){
    log.error("Unhandled Exception",exception);
    ResponseEntity responseEntity;

    return responseEntity=new ResponseEntity(new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,"something went wrong"),HttpStatus.INTERNAL_SERVER_ERROR);

  }
}
