package com.murray.mim.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.websocket.Session;
import java.io.Serializable;

/**
 * @author Murray Law
 * @date 2022/9/8 11:35
 */
@Data
@AllArgsConstructor
public class SessionDto implements Serializable {

    private static final long serialVersionUID = -6096205892849764378L;

    /**
     * 是否初始化
     */
    private Boolean isInit;

    /**
     * 会话
     */
    private Session session;
}
