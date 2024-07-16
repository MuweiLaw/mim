package com.murray.mim.model.enums;

import lombok.Getter;

/**
 * @author Murray Law
 */
@Getter
public enum ServerEnum {
    /**
     * 服务名称
     */
    Music("music"),
    Camera("camera"),
    Dashboard("dashboard"),
    TtsProcess("ttsProcess"),
    ChatPerson("chatPerson");

    private final String serverName;

    ServerEnum(String serverName) {
        this.serverName = serverName;
    }
}