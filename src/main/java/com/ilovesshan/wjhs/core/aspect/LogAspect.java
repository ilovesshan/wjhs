package com.ilovesshan.wjhs.core.aspect;

import com.ilovesshan.wjhs.beans.pojo.OperationLog;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.service.OperationLogService;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Aspect
@Component
public class LogAspect {

    @Autowired
    private OperationLogService operationLogService;

    // 最终通知
    @AfterReturning(pointcut = "@annotation(log)")
    public void afterReturningAdvice(JoinPoint joinPoint, Log log) {
        OperationLog operationLog = generatorLogOperation(joinPoint, log, null);
        operationLogService.insert(operationLog);
    }


    // 异常通知
    @AfterThrowing(pointcut = "@annotation(log)", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Log log, Exception exception) {
        OperationLog operationLog = generatorLogOperation(joinPoint, log, exception);
        operationLogService.insert(operationLog);
    }


    public OperationLog generatorLogOperation(JoinPoint joinPoint, Log log, Exception exception) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        OperationLog operationLog = new OperationLog();
        operationLog.setId(UuidUtil.generator());
        operationLog.setBusinessModule(log.businessModule());
        operationLog.setBusinessType(log.businessType());
        operationLog.setBusinessDescribe(log.businessDescribe());
        operationLog.setApiMethod(joinPoint.getSignature().getName());
        operationLog.setRequestMethod(request.getMethod());
        operationLog.setUserId(UserCache.get("userId"));
        operationLog.setUserName(UserCache.get("username"));
        operationLog.setUserType(UserCache.get("userType"));
        operationLog.setUrl(request.getRequestURI());
        operationLog.setIp(request.getRemoteAddr());
        if (exception == null) {
            operationLog.setStatus("200");
            operationLog.setErrorMessage("");
        } else {
            operationLog.setStatus("500");
            operationLog.setErrorMessage(exception.getMessage());
        }
        operationLog.setOperationTime(new Date());

        return operationLog;
    }

}
