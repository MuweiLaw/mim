package com.murray.mim.model.enums;

import lombok.Getter;

/**
 * @author Murray Law
 */
@Getter
public enum WsMsgGroupEnum {
    /**
     * 客户端初始化
     */
    ClientInit("clientInit"),
    UserSingleMsg("userSingleMsg"),
    SystemMsg("systemMsg"),
    MusicCmd("musicCmd"),
    ClientMsg("clientMsg");

    private final String group;

    WsMsgGroupEnum(String group) {
        this.group = group;
    }

    public static WsMsgGroupEnum matchGroup(String group) {
        for (WsMsgGroupEnum enums : WsMsgGroupEnum.values()) {
            if (enums.getGroup().equals(group)) {
                return enums;
            }
        }
        return null;
    }
}