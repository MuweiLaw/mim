package com.murray.mim.rest.sys;

import com.murray.mim.commons.R;
import com.murray.mim.commons.service.SysUserService;
import com.murray.mim.rest.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sys/user")
public class SysUserController implements BaseController {

    private final SysUserService SysUserService;


    public SysUserController(SysUserService SysUserService) {
        this.SysUserService = SysUserService;
    }

    /**
     * 获取用户编号(测试用)
     */
    @GetMapping("/user-no/{id}")
    public R<String> getImageCode(@PathVariable("id") String id) {
        return R.assertion(SysUserService.getUserNoById(id));
    }
}
