package com.murray.mim.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.murray.mim.model.dao.SysUserDao;
import com.murray.mim.model.vo.ProdProcessPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Murray
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDao> {

    IPage<SysUserDao> getPageAdminSysUser(IPage<SysUserDao> page, @Param("query") SysUserDao dao);

    /**
     * 目前 TokenUntil.getUid()是获取主键ID, 业务需要字段user_id
     *
     * @param id 主键ID,
     * @return java.lang.String
     * @author Murray Law
     */
    @Select("SELECT `user_no` from sys_user WHERE id=#{id}")
    String getUserNoById(@Param("id") String id);

    String getUserNoByIdMapper(@Param("id") String id);

    List<String> getRolesByUserId(@Param("id") String id);
}