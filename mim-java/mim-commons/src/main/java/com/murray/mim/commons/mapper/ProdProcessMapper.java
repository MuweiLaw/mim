package com.murray.mim.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.murray.mim.model.dao.ProdProcessDao;
import com.murray.mim.model.vo.ProdProcessPageVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Murray
 */
@Mapper
public interface ProdProcessMapper extends BaseMapper<ProdProcessDao> {

    @MapKey("pageConditions")
    IPage<ProdProcessDao> pageConditions(IPage<ProdProcessDao> page, @Param("query") ProdProcessPageVo vo);
}