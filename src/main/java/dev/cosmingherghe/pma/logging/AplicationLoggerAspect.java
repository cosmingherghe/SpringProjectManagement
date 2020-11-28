package dev.cosmingherghe.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(dev.cosmingherghe.pma.controllers..*)")
    public void definePackagePointcuts() {
        // empty method to name the location specified in the pointcut
    }

    @Before("definePackagePointcuts()")
    public void logBefore() {
        log.debug(" \nBefore Execution -<>-<>-<>-<>-\n ");
    }

    @After("definePackagePointcuts()")
    public void logAfter(JoinPoint joinPoint) {
        log.debug(" \n\nAfter Execution -<>-<>-<>-<>-\n ");

        log.debug(" {} \n {} () with arguments [s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

        log.debug(" \n\n---<>-<>-<>-<>---\n ");
    }

}
