package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {
    @Pointcut("within(com.demo.service.*)")
    public void withinCurrencyPointCut(){}


    @Pointcut("@within(com.demo.annotation.Secured)")
    public void withinAnnotationCurrencyServicePointCut(){}

    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetAnnotationCurrencyServicePoinCut(){}

    @Pointcut("@within(com.demo.annotation.InTransaction)")
    public void annotationCurrencyServicePointCut(){}

    @Pointcut("bean(currency)")
    public void beanCurrencyServicePointCut(){}

    @Pointcut("args(int,int)")
    public void argsCurrencyServicePointcut(){}

    @Pointcut("@args(com.demo.annotation.Validate)")
    public void argsAnnotationCurrencyServicePointcut(){}


//    @Before("withinCurrencyPointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
            String className = joinPoint.getTarget().getClass().getSimpleName();
            System.out.println(className);
            System.out.println(
                    String.format("%s %s method is invoked with before advice in {%s}."
                            , className, joinPoint.getSignature().getName(), LocalDateTime.now())
            );

    }

  //  @Before("withinAnnotationCurrencyServicePointCut()")
    public void beforeWithinAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with before advice in {%s}."
                        , className, joinPoint.getSignature().getName(), LocalDateTime.now())
        );

    }
   // @Before("annotationCurrencyServicePointCut()")
    public void beforeAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with before advice in {%s}."
                        , className, joinPoint.getSignature().getName(), LocalDateTime.now())
        );

    }

   // @Before("beanCurrencyServicePointCut()")
    public void beforeBeanCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with before advice in {%s}."
                        , className, joinPoint.getSignature().getName(), LocalDateTime.now())
        );

    }

    @Before("withinAnnotationCurrencyServicePointCut() && argsCurrencyServicePointcut()")
    public void argBeanCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with before advice in {%s}."
                        , className, joinPoint.getSignature().getName(), LocalDateTime.now())
        );

    }
   // @After("argsAnnotationCurrencyServicePointcut()")
    public void argAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with after advice in {%s}."
                        , className, joinPoint.getSignature().getName(), LocalDateTime.now())
        );

    }

   // @AfterReturning(value = "argsAnnotationCurrencyServicePointcut()",returning="country")
    public void argAnnotationAfterReturningCurrencyAdvice(JoinPoint joinPoint,String country){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with after advice in {%s}."
                        , className, joinPoint.getSignature().getName(), LocalDateTime.now())
        );

    }

   // @AfterThrowing(value = "argsAnnotationCurrencyServicePointcut()",throwing="e")
    public void argAnnotationAfterThrowingCurrencyAdvice(JoinPoint joinPoint,Throwable e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with after throwing" +"advice exception class is :: [%s] in {%s}."
                        , className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
    }

    @Around("targetAnnotationCurrencyServicePoinCut()")
    public Object argAnnotationAfterThrowingCurrencyAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println(className);
        System.out.println(
                String.format("%s %s method is invoked with after throwing" +"advice exception class is :: [%s] in {%s}."
                        , className,
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        LocalDateTime.now())
        );
        try{
            return joinPoint.proceed();

        }finally {
            {
                System.out.println("After invoking method ......");
            }
        }
    }
}
