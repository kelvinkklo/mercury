package com.kelvin.mercury.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Log4j2
@Aspect
@Component
public class InfoAspect {
    @Around("@annotation(com.kelvin.mercury.annotation.Info)")
    public Object logInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String annotatedMethodName = joinPoint.getSignature().getName();

        log.info("[{}.{}] start", className, annotatedMethodName);

        Object object = joinPoint.proceed();

        log.info("[{}.{}] end", className, annotatedMethodName);

        return object;
    }
}
