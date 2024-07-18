package com.murray.mim.rest.prod;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.murray.mim.commons.controller.BaseController;
import com.murray.mim.commons.controller.R;
import com.murray.mim.commons.service.ProdProcessService;
import com.murray.mim.commons.service.SysUserService;
import com.murray.mim.model.dao.ProdProcessDao;
import com.murray.mim.model.vo.ProdProcessPageVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/prod/process")
public class ProdProcessController implements BaseController {

    private final ProdProcessService prodProcessService;

    /**
     * 获取用户编号(测试用)
     */
    @PostMapping("/page/condition")
    public R<IPage<ProdProcessDao>> getImageCode(@RequestBody ProdProcessPageVo vo) {
        return R.success(prodProcessService.pageConditions(vo));
    }
}
