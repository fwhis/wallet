package com.tll.wallet.ex.handler;


import com.tll.wallet.ex.ServiceException;
import com.tll.wallet.web.JsonResult;
import com.tll.wallet.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * 全局异常处理器
 *
 * @author java@fwh
 * @version 0.0.1
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public JsonResult<Void> handleServiceException(ServiceException e) {
        log.debug("捕获到ServiceException：{}", e.getMessage());
        return JsonResult.fail(e.getServiceCode(), e.getMessage());
    }


    @ExceptionHandler
    public JsonResult<Void> handleThrowable(Throwable e) {
        log.debug("捕获到Throwable：{}", e.getMessage());
        e.printStackTrace();
        String message = "程序运行时出现未知错误，请联系系统管理员！";
        return JsonResult.fail(ServiceCode.ERR_UNKNOWN, message);
    }

}
