package com.murray.mim.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class IMMessage {

    @ApiModelProperty(value="消息ID",name="msgId")
    private String msgId;

    @ApiModelProperty(value="用户编号",name="userNo")
    private String userNo;

    @ApiModelProperty(value="信息体",name="body")
    private Object body;

    @ApiModelProperty(value="版本",name="version")
    private String version;

    @ApiModelProperty(value="组别",name="group")
    private String group;

    @ApiModelProperty(value="类别别",name="type")
    private Integer type;

    @ApiModelProperty(value="熵,魔数",name="entropy")
    private Long entropy;

    @ApiModelProperty(value="源头域",name="origins")
    private String origins;
}
