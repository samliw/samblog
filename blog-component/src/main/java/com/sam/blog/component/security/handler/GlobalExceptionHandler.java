package com.sam.blog.component.security.handler;

import com.sam.blog.common.exception.BusinessException;
import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseResult exceptionHandler(HttpServletRequest req,Exception e){
        LOGGER.error("未知异常！原因是：{}",e.getMessage());
        return new ResponseResult(ResultCode.ERROR,null);
    }

    /**
     * 自定义处理异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult bizExceptionHandler(HttpServletRequest req, BusinessException e){
        LOGGER.error("自定义处理异常！原因是：{}",e.getMessage());
        return new ResponseResult(Boolean.FALSE,e.code,null);
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    public ResponseResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        LOGGER.error("发生空指针异常！原因是:",e);
        return new ResponseResult(ResultCode.NULL_EXCEPTION,null);
    }
    /**
     * 处理404异常
     *
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseResult handleNoHandlerFoundException(NoHandlerFoundException e) {
        return new ResponseResult(ResultCode.NOT_FOUND,null);
    }


}
