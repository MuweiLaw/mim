package com.murray.mim.model.vo;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.murray.mim.model.dao.ProdProcessDao;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProdProcessPageVo extends ProdProcessDao implements Serializable {

    private static final long serialVersionUID = 2149145813733933085L;

    @ApiModelProperty(value = "创建时间-开始", name = "createTimeStart")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTimeStart;

    @ApiModelProperty(value = "创建时间-结束", name = "createTimeEnd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTimeEnd;

    @ApiModelProperty(value = "更新时间-开始", name = "updateTimeStart")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTimeStart;

    @ApiModelProperty(value = "更新时间-结束", name = "updateTimeEnd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTimeEnd;


    @ApiModelProperty(value = "主键列表", name = "ids")
    private List<Long> ids;

    @ApiModelProperty(value = "排序元素", name = "orders")
    private List<OrderItem> orders;

    @ApiModelProperty(value = "页面大小", name = "size")
    private Long size;

    @ApiModelProperty(value = "页码", name = "current")
    private Long current;
}
