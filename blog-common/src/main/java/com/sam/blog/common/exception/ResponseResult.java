package com.sam.blog.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.blog.common.exceptionenum.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult {
    public static final Logger LOGGER = LoggerFactory.getLogger(ResponseResult.class);
    /**
     *  是否成功
     */
    private Boolean success;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 操作编码
     */
    private Integer code;

    /**
     * 返回数据
     */
    private Object data;

    public ResponseResult() {
    }

    /**
     * 使用response输出JSON
     * @Author Sans
     * @CreateTime 2019/9/28 11:23
     * @Param  resultMap 数据
     * @Return void
     */
    public static void responseJson(ServletResponse response, ResponseResult resultMap){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSONObject.parseObject(JSONObject.toJSONString(resultMap)));
        } catch (Exception e) {
            LOGGER.error("【JSON输出异常】"+e);
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }

    public ResponseResult(ResultCode resultCode) {
        this.code = resultCode.code;
        this.success = resultCode.success;
        this.message = resultCode.message;
    }
    public ResponseResult(ResultCode resultCode, Object data) {
        this.code = resultCode.code;
        this.data = data;
        this.success = resultCode.success;
        this.message = resultCode.message;
    }

    public ResponseResult(Boolean success, Integer code, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
    public static ResponseResult SUCCESS(){
        return new ResponseResult(ResultCode.SUCCESS);
    }
    public static ResponseResult ERROR(){
        return new ResponseResult(ResultCode.ERROR);
    }
    public static ResponseResult FAIL(){
        return new ResponseResult(ResultCode.FAIL);
    }
}
