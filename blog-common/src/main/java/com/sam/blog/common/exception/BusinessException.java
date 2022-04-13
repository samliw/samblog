package com.sam.blog.common.exception;

import com.sam.blog.common.exceptionenum.ResultCode;
import lombok.Data;

/**
 *  自定义异常处理
 */
@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     *  是否成功
     */
    public Boolean success;

    /**
     * 提示信息
     */
    public String message;

    /**
     * 操作编码
     */
    public Integer code;

    public Exception exception;

    public BusinessException(ResultCode resultCode) {
        this.success = resultCode.success;
        this.message = resultCode.message;
        this.code = resultCode.code;
    }

    public BusinessException(Boolean success, Integer code, String message) {
        this.success = success;
        this.message = message;
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Boolean success, String message1, Integer code, Exception exception) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.success = success;
        this.message = message1;
        this.code = code;
        this.exception = exception;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.code = code;
    }

}
