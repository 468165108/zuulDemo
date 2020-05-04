package com.example.admin.aop.demo;


import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class LogAspects {


    @Pointcut("execution(public int com.example.admin.aop.demo.MathCalculator.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void logStart(){
        log.info("方法运行 参数列表是");
    }

    @After("pointCut()")
    public void logAfter(){
        log.info("方法结束 参数列表是");
    }


}
