package com.murray.mim.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CommonErrorEnum {

    PARAM_VALIDATION_ERROR(400,"参数校验错误"),
    FORBIDDEN(403,"服务拒绝处理"),
    NOT_FOUND(404,"找不到路径"),
    INTERNAL_SERVER_ERROR(500,"系统异常");

    private final Integer code;
    private final String message;
}
