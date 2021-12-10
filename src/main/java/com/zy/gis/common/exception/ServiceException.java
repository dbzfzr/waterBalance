package com.zy.gis.common.exception;

/**
 * 自定义业务异常类
 * @date 20210820
 * @author Wangchong
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
