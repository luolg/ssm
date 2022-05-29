package com.luolg.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before() {
        System.out.println("before enhance");
    }

    public void after() {
        System.out.println("after enhance");
    }

    public void afterRunning() {
        System.out.println("after running enhance ...");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around enhance ..... ");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("after around enhance ..... ");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("after throwing ......... ???????????");
    }


}
