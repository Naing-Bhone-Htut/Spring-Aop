package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Aspect
@Component
public class AcccountServiceAspect {
    @Pointcut ("target(com.demo.service.AccountService)")

    public void thisPointCutAccountService(){}

    public void beforeAccountServiceAdvice(JoinPoint joinPoint){
        String className= joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with before advice in {%s}."
                        ,className, joinPoint.getSignature().getName(), LocalDateTime.now())
        );

    }
}
