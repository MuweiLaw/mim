package com.murray.mim.ws.controller;

import com.murray.mim.commons.controller.BaseController;
import com.murray.mim.commons.controller.R;
import com.murray.mim.commons.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/sys/user")
public class SysUserController implements BaseController {

    private final SysUserService SysUserService;

    /**
     * 获取用户编号(测试用)
     */
    @GetMapping("/user-no/{id}")
    public R<String> getImageCode(@PathVariable("id") String id) {
        return R.assertion(SysUserService.getUserNoById(id));
    }
}
