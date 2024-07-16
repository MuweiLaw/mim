package com.murray.mim.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class IMMessage {

    private String msgId;

    private String userNo;

    private Object body;

    private String verSion;

    private String group;
}
