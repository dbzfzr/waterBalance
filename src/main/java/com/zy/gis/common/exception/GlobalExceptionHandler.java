package com.zy.gis.common.exception;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
 * 全局异常处理类
 * @author  Wangchong
 * @date 20201215
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
    @author Wangchong
    @date 2021/12/7 11:13
    @description TODO 处理自定义服务异常
    @param e
    @return
    */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public JSONObject exceptionHandler(Exception e) {

        JSONObject msg = new JSONObject();
        msg.put("code", 0);
        msg.put("status",false);

        if (log.isErrorEnabled()) {
            log.error("出现问题:" + e.getCause() + e.getMessage());
        }
        msg.put("message", e.getMessage());
        return msg;
    }

    /**
    @author Wangchong
    @date 2021/12/7 11:15
    @description TODO 处理运行时异常
    @param
    @return
    */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JSONObject runtimeExceptionHandler(RuntimeException runtimeException){
        JSONObject msg = new JSONObject();
        msg.put("code", 0);
        msg.put("status",false);

        if (log.isErrorEnabled()) {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(runtimeException.getStackTrace()).forEach( stackTraceElement ->
                stringBuilder.append(stackTraceElement.toString())
            );

            log.error("出现问题:{}", stringBuilder.toString());
        }

        msg.put("message", "操作失败");
        return msg;
    }
}
