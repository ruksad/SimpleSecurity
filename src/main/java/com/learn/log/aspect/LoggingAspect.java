package com.learn.log.aspect;

import com.learn.log.annotation.Trace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by mohammad on 13/3/17.
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Around("@annotation(trace)")
  public Object log(ProceedingJoinPoint proceedingJoinPoint,Trace trace)throws Throwable{
    long startTime=0;
    try{
      log.info(
          "[" + trace.type() + "] Execution started : " + proceedingJoinPoint.getSignature().toShortString());
      startTime= System.currentTimeMillis();
      return proceedingJoinPoint.proceed();
    }catch(Exception e){
      log.info("[" + trace.type() + "] Exception occurred while executing "
              + proceedingJoinPoint.getSignature().toShortString() + ".Rethrowing exception " + e.getMessage(),
          e);
      throw e;
    }finally {
      log.info(
          "["+ trace.type() +"] Execution Completed: "+ proceedingJoinPoint.getSignature().toShortString()+" , ExectionTime(in millis) : "+(System.currentTimeMillis()-startTime));
    }

  }
}
