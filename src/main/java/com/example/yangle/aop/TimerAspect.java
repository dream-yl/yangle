package com.example.yangle.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

  /**
   * @param pjp
   * @return
   * @throws Throwable
   */
  @Around("execution(* com.example.yangle.service.impl.*.*(..))")
  public Object aop(ProceedingJoinPoint pjp) throws Throwable {
    // 记录开始时间
    long st = System.currentTimeMillis();

    // 调用目标方法git修改
    Object result = pjp.proceed();

    // 记录结束时间
    long et = System.currentTimeMillis();
    // 输出耗时
    System.err.println(pjp.getSignature().getName() + "-> 耗时：" + (et - st) + "ms.");

    return result;
  }

}
