package com.blog.by.kotor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.blog.by.kotor.service..*(..))")
    public void serviceLayer() {
    }

    @Before("serviceLayer()")
    public void loggingBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature methodSignature) {
            String methodName = methodSignature.getName();
            Class<?> returnType = methodSignature.getReturnType();
            Class<?>[] parameterTypes = methodSignature.getParameterTypes();
            log.info("The {} method has started its work, returns {}, parameters: {} ", methodName, returnType.getSimpleName(), Arrays.toString(parameterTypes));
        }
    }

    @After("serviceLayer()")
    public void loggingAfter(JoinPoint joinPoint) {
        log.info("The {} method has finished its work", joinPoint.getSignature().getName());
    }

}
