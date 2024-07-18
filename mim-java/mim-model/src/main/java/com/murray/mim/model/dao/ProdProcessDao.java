package com.murray.mim.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("prod_process")
public class ProdProcessDao implements Serializable {


    private static final long serialVersionUID = 3532742476603567766L;

    @ApiModelProperty(value = "主键自增ID  ", name = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "产品流程编号", name = "processNo")
    private String processNo;

    @ApiModelProperty(value = "产品流程标题", name = "processTitle")
    private String processTitle;

    @ApiModelProperty(value = "产品流程内容", name = "processBody")
    private String processBody;

    @ApiModelProperty(value = "产品流程所需时间,单位/毫秒ms", name = "processTime")
    private Long processTime;

    @ApiModelProperty(value = "执行角色", name = "exeRole")
    private String exeRole;

    @ApiModelProperty(value = "乐观锁版本号", name = "version")
    private Long version;

    @ApiModelProperty(value = "逻辑删除[0:禁用,1:启用] ", name = "isEnable")
    private Byte isEnable;

    @ApiModelProperty(value = "创建者用户编号", name = "createBy")
    private String createBy;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新者用户编号", name = "updateBy")
    private String updateBy;

    @ApiModelProperty(value = "更新时间", name = "updateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}