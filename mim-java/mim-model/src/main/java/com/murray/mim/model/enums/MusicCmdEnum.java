package com.murray.mim.model.enums;

import lombok.Getter;

/**
 * @author Murray Law
 */
@Getter
public enum MusicCmdEnum {
    /**
     * 音乐状态
     */
    Play("play"),
    Pause("pause"),
    Resume("resume"),
    Stop("stop"),
    Next("next");

    private final String type;

    MusicCmdEnum(String type) {
        this.type = type;
    }
}