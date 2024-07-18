package com.murray.mim.commons.handler;


import com.murray.mim.commons.controller.R;
import com.murray.mim.commons.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.murray.mim.model.enums.CommonErrorEnum.*;


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
     * 全局业务异常捕捉处理
     *
     * @param ex 异常
     */
    @ExceptionHandler(BusinessException.class)
    public R<Void> clientErrorExceptionHandler(BusinessException ex, HttpServletRequest req) {
        //抛出业务错误异常
        log.warn("======>>> \"{}\"  [{}] Exception :: {}", req.getRequestURI(), BUSINESS_LOGIC_ERROR, ex.getMessage());
        ex.printStackTrace();
        return R.error(BUSINESS_LOGIC_ERROR.getCode().toString(), ex.getMessage(), null);
    }


    /**
     * 全局mybatis绑定异常捕捉处理
     *
     * @param ex 异常
     */
    @ExceptionHandler(org.apache.ibatis.binding.BindingException.class)
    public R<Void> ExceptionHandler(org.apache.ibatis.binding.BindingException ex, HttpServletRequest req) {
        //抛出客户端业务错误异常
        log.warn("======>>> \"{}\" [{}] Exception :: {}", req.getRequestURI(), MYBATIS_BINDING_ERROR, ex.getMessage());
        ex.printStackTrace();
        return R.error(MYBATIS_BINDING_ERROR.getCode().toString(), ex.getMessage(), null);
    }

    /**
     * 全局异常捕捉处理
     *
     * @param ex 异常
     */
    @ExceptionHandler(Exception.class)
    public R<Void> ExceptionHandler(Exception ex, HttpServletRequest req) {
        //抛出客户端业务错误异常
        log.warn("======>>> \"{}\"  [{}] Exception :: {}", req.getRequestURI(), INTERNAL_SERVER_ERROR, ex.getMessage());
        ex.printStackTrace();
        return R.error(INTERNAL_SERVER_ERROR.getCode().toString(), ex.getMessage(), null);
    }

}

