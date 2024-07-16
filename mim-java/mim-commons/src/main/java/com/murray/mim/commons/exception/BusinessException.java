package com.murray.mim.commons.exception;

import com.murray.mim.model.enums.CommonErrorEnum;

import java.io.Serializable;

public class BusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -4473415698734249140L;

    private final Integer code; // 可以用于标识不同类型的业务异常

    private final String message; // 具体的错误消息

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public BusinessException(CommonErrorEnum commonErr) {
        this(commonErr.getCode(), commonErr.getMessage());
    }
    // 也可以添加其他辅助方法，如获取详细堆栈信息等
}