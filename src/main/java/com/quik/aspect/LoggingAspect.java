package com.quik.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value = "execution(* com.quik.strategy.TradingStrategy.execute(..))")
    private void logStrategyExecution() {

    }

    @Around(value = "logStrategyExecution()")
    public void aroundExecution(ProceedingJoinPoint jp) throws Throwable {
        LOGGER.debug("Trading strategy: {}", jp.getSignature().getDeclaringType());
        final long start = System.nanoTime();
        try {
            jp.proceed();
        } finally {
            final long end = System.nanoTime();
            LOGGER.debug("Trading strategy processing time: {} nanoseconds", end - start);
        }
    }
}
