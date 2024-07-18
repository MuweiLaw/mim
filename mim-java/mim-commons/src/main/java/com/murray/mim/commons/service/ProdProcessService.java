package com.murray.mim.commons.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.murray.mim.model.dao.ProdProcessDao;
import com.murray.mim.model.vo.ProdProcessPageVo;

/**
 * 产品工序流程 服务接口
 *
 * @author Murray
 */
public interface ProdProcessService extends IService<ProdProcessDao> {

    IPage<ProdProcessDao> pageConditions(ProdProcessPageVo vo);
}

      