package com.murray.mim.commons.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.murray.mim.commons.mapper.SysUserMapper;
import com.murray.mim.model.dao.SysUserDao;

/**
 * 系统用户资料 服务接口
 *
 * @author Murray
 */
public interface SysUserService extends IService<SysUserDao> {

    IPage<SysUserDao> getPageSystemUser(IPage<SysUserDao> queryMap, SysUserDao dao);

    String getUserNoById(String id);

    String getUserNoByIdMapper(String id);
}

      