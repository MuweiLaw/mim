package com.murray.mim.commons.handler;


import com.murray.mim.commons.exception.BusinessException;
import com.murray.mim.commons.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.murray.mim.model.enums.CommonErrorEnum.INTERNAL_SERVER_ERROR;


/**
 * 统一异常处理
 *
 * @author Murray Law
 * @date 2022/3/17 1:52
 */
@RestControllerAdvice
@Slf4j
public class UnionExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder 网络数据绑定器
     * @date 2022/3/21 10:52
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest req) {
        var get = "GET";
        String method = req.getMethod();
        if (get.equals(method)) {
            log.info("<<<====== \"{}\" input params :: {}", req.getRequestURI(), req.getQueryString());
        } else {
            log.info("<<<====== \"{}\" input params :: {}", req.getRequestURI(), binder.getTarget());
        }
    }


    /**
     * 全局异常捕捉处理
     *
     * @param ex 异常
     * @return com.indiev.sc.common.result.Result
     * @date 2022/3/21 10:54
     */
    @ExceptionHandler(BusinessException.class)
    public R<Void> clientErrorExceptionHandler(Exception ex, HttpServletRequest req) {
        //抛出Keycloak客户端错误异常
        log.warn("======>>> \"{}\" throw business exception :: {}", req.getRequestURI(), ex.getMessage());
        return R.error(INTERNAL_SERVER_ERROR.getCode().toString(), ex.getMessage(), null);
    }

}

