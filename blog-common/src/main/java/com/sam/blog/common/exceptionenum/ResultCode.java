package com.sam.blog.common.exceptionenum;

public enum ResultCode {
    ILLEGAL_PARAM(Boolean.FALSE,100,"非法参数"),
    INCOMPLETE_PARAM(Boolean.FALSE,101,"参数不完整"),
    UNKNOWN_EXCEPTION(Boolean.FALSE,102,"未知异常"),
    SUCCESS(Boolean.TRUE,200,"操作成功"),
    NOT_AUTH(Boolean.FALSE,403,"未授权"),
    NOT_FOUND(Boolean.FALSE,404,"请求的资源不存在"),
    ERROR(Boolean.FALSE,500,"系统错误"),
    FAIL(Boolean.FALSE,10000,"操作失败"),
    LOGIN_ERROR(Boolean.FALSE,10001,"登录失败"),
    NOT_LOGIN(Boolean.FALSE,10002,"未登录或账号密码失效！"),
    NOT_USER_NAME_EXIST(Boolean.FALSE,10003,"用户名不存在"),
    USER_LOCK(Boolean.FALSE,10004,"用户账号被锁"),
    PASSWORD_ERROR(Boolean.FALSE,10005,"密码不正确"),
    NULL_EXCEPTION(Boolean.FALSE,30002,"请求数据空！");


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

    ResultCode(Boolean success, Integer code, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
