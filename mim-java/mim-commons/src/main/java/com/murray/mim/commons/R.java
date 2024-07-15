package com.murray.mim.commons;

import java.io.Serializable;
import java.util.Objects;

/**
 * 返回信息包装类
 *
 * @author Murray Law
 */
public class R<T> implements Serializable {
    public static final String CODE_SUCCESS = "0";
    public static final String CODE_ERROR = "9999";
    public static final String CODE_ERROR_BUSINESS = "500";
    public static final String CODE_NOT_FOUND = "404";
    public static final String CODE_END = "1";
    public static final String CODE_SUCCESS_MSG = "成功";
    public static final String CODE_ERROR_MSG = "系统异常，请稍后再试";

    private static final long serialVersionUID = -1684780611444450539L;

    private String code;
    private String msg;
    private T data;

    public R(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> success(T data) {
        return new R<>(CODE_SUCCESS, CODE_SUCCESS_MSG, data);
    }

    public static <T> R<T> success(String msg, T data) {
        return new R<>(CODE_SUCCESS, msg, data);
    }

    public static <T> R<T> assertion(T data) {
        return Objects.nonNull(data) ? success(data) : notFound();
    }

    public static <T> R<T> notFound() {
        return new R<>(CODE_NOT_FOUND, "数据不存在", null);
    }

    public static <T> R<T> error(String msg) {
        return new R<>(CODE_ERROR, msg, null);
    }

    public static <T> R<T> error(String code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    public boolean isSuccess() {
        return CODE_SUCCESS.equals(this.code);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public R() {
    }
}