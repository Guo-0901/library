package com.example.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Logger log =LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.example.library.server.*.*(..))")
    public void serviceMethod() {}

    @Before("serviceMethod()")
    public void before(JoinPoint jp) {
        log.info("代理在方法{}上调用了@Before", jp.getSignature().getName());
    }

    @AfterReturning("serviceMethod()")
    public void afterReturning(JoinPoint jp) {
        log.info("代理在方法{}上调用了@AfterReturning", jp.getSignature().getName());
    }

    @AfterThrowing(pointcut = "serviceMethod()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e) {
        log.info("代理在方法{}上调用了@AfterThrowing", jp.getSignature().getName());
        log.info("异常={}", e.getMessage());
    }

    @After("serviceMethod()")
    public void after(JoinPoint jp) {
        log.info("代理在方法{}上调用了@After", jp.getSignature().getName());
    }

    @Around("serviceMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("在方法{}上执行Around前半段", pjp.getSignature().getName());

        try {
            Object result = pjp.proceed();
            log.info("方法{}正常返回", pjp.getSignature().getName());
            return result;
        }
        catch (Throwable e) {
            log.info("方法{}出现异常", pjp.getSignature().getName());
            throw e;
        }
    }
}
