package com.xinan.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author XinAnzzZ
 * @date 2018/8/21 13:50
 */
@Slf4j
@Aspect
@Component
public class ControllerAspectHandler {

    // @Pointcut("execution(public * com.xinan.controller.*.*(..))")
    // public void controllerPointCut() {
    // }

    // @Around("controllerPointCut()")
    // public Object unauthorizedExceptionHandler(ProceedingJoinPoint pjp) {
    // }
}
