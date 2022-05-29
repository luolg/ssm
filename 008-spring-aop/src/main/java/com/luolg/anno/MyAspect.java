package com.luolg.anno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @Before("execution(* com.luolg.anno.*.*(..))")
    public void before() {
        System.out.println("before enhance");
    }

    @After("execution(* com.luolg.anno.*.*(..))")
    public void after() {
        System.out.println("after enhance");
    }

    @AfterReturning("execution(* com.luolg.anno.*.*(..))")
    public void afterRunning() {
        System.out.println("after running enhance ...");
    }

    @Around("execution(* com.luolg.anno.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around enhance ..... ");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("after around enhance ..... ");
        return proceed;
    }

    @AfterThrowing("execution(* com.luolg.anno.*.*(..))")
    public void afterThrowing() {
        System.out.println("after throwing ......... ???????????");
    }


}
