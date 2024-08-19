package com.ish.spring_boot_rest_jpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    return type, class-name.method-name(args)

//    for getting based on all methods with all args
//    @Before("execution(* com.ish.spring_boot_rest_jpa.service.JobService.*(..))")
//    public void logMethodCall(){
//        LOGGER.info("Method Called");
//    }
//}


//    for getting based on specific methods with all args
    @Before("execution(* com.ish.spring_boot_rest_jpa.service.JobService.getJob(..)) || execution(* com.ish.spring_boot_rest_jpa.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called "+ jp.getSignature().getName());
    }

    //executes all time when method get called
    @After("execution(* com.ish.spring_boot_rest_jpa.service.JobService.getJob(..)) || execution(* com.ish.spring_boot_rest_jpa.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed "+ jp.getSignature().getName());
    }

    // executes only method throw any exceptions
    @AfterThrowing("execution(* com.ish.spring_boot_rest_jpa.service.JobService.getJob(..)) || execution(* com.ish.spring_boot_rest_jpa.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some issue "+ jp.getSignature().getName());
    }

    //executes only method dont have any exceptions
    @AfterReturning("execution(* com.ish.spring_boot_rest_jpa.service.JobService.getJob(..)) || execution(* com.ish.spring_boot_rest_jpa.service.JobService.updateJob(..))")
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Method Executed Successfully "+ jp.getSignature().getName());
    }

}