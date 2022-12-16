package org.frakin.Application.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Before("execution(* org.frakin.Application.Service.MessageService_1.giveMessage(..))")
    public void beforeGiveMessageMethod(JoinPoint joinPoint) {
        System.out.println("Catched Before giveMessage().param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* org.frakin.Application.Service.*.*(..))")
    public void afterGiveMessageMethod(JoinPoint joinPoint) {
        System.out.println("Catched After giveMessage().param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
