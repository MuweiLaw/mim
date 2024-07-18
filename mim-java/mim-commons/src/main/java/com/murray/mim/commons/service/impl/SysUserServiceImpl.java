package com.murray.mim.commons.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.murray.mim.commons.mapper.SysUserMapper;
import com.murray.mim.commons.service.SysUserService;
import com.murray.mim.model.dao.SysUserDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 系统用户资料 服务实现类
 *
 * @author Murray
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDao> implements SysUserService {

    public IPage<SysUserDao> getPageSystemUser(IPage<SysUserDao> queryMap, SysUserDao dao) {
        return baseMapper.getPageAdminSysUser(queryMap, dao);
    }

    /**
     * 目前 TokenUntil.getUid()是获取主键ID, 业务需要字段user_id
     *
     * @param id 主键ID,
     * @return java.lang.String
     * @author Murray Law
     */
    @Cacheable(cacheNames = "getUserNoById", key = "#id")
    public String getUserNoById(String id) {
        return baseMapper.getUserNoById(id);
    }

    public String getUserNoByIdMapper(String id) {
        return baseMapper.getUserNoByIdMapper(id);
    }
}

      