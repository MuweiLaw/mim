package com.murray.mim.commons.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.murray.mim.commons.mapper.ProdProcessMapper;
import com.murray.mim.commons.service.ProdProcessService;
import com.murray.mim.model.dao.ProdProcessDao;
import com.murray.mim.model.dao.SysUserDao;
import com.murray.mim.model.vo.ProdProcessPageVo;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 产品工序流程 服务实现类
 *
 * @author Murray
 */
@Service
@AllArgsConstructor
public class ProdProcessServiceImpl extends ServiceImpl<ProdProcessMapper, ProdProcessDao> implements ProdProcessService {

    private final ProdProcessMapper prodProcessMapper;

    @Override
    public IPage<ProdProcessDao> pageConditions(ProdProcessPageVo vo) {
        Page<ProdProcessDao> page = new Page<>();
        page.setOrders(vo.getOrders());
        page.setSize(vo.getSize());
        page.setCurrent(vo.getCurrent());
        return prodProcessMapper.pageConditions(page, vo);
    }
}

      