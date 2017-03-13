package com.learn.controller;

import com.learn.log.annotation.Trace;
import com.learn.log.eventType.LogEventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mohammad on 13/3/17.
 */
@Slf4j
@RestController
public class LearnRestController {


  @Trace(type = LogEventType.CONTROLLER)
  @GetMapping(value = "learn/hibernate")
  public String hello() throws Exception {
    throw new Exception(" i dont like you");

  }
}
