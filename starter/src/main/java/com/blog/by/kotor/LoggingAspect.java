package com.blog.by.kotor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

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
            LOGGER.info("Метод {} начал свою работу, возращает {}, параметры: {} ", methodName, returnType.getSimpleName(), Arrays.toString(parameterTypes));
        }
    }

    @After("serviceLayer()")
    public void loggingAfter(JoinPoint joinPoint) {
        LOGGER.info("Метод {} закончил свою работу", joinPoint.getSignature().getName());
    }

}
