package com.murray.mim.ws.service;

import cn.hutool.json.JSONUtil;
import com.murray.mim.commons.exception.BusinessException;
import com.murray.mim.model.dto.IMMessage;
import com.murray.mim.model.dto.SessionDto;
import com.murray.mim.model.enums.CommonErrorEnum;
import com.murray.mim.model.enums.ServerEnum;
import com.murray.mim.model.enums.WsMsgGroupEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static com.murray.mim.ws.config.WebSocketConfig.SESSION_MAP;

@ServerEndpoint("/commonUse/websocket/{serverName}/{userId}")
@Component
@Slf4j
public class CommonUseWebSocket {


    /**
     * 静态变量记录在线连接数
     */
    private static final AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 新的连接建立成功后调用此方法，此方法严禁加入死循环或线程堵塞，会导致其他事件监听失效
     *
     * @param session 会话
     * @param userId  用户ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "serverName") String serverName, @PathParam(value = "userId") String userId) {
        // session超时时间，超时后无法再发送消息，服务端N秒之后会触发onClose()
        session.setMaxIdleTimeout(60 * 1000 * 30);
        Map<String, SessionDto> subSessionMap = SESSION_MAP.get(serverName);
        if (CollectionUtils.isEmpty(subSessionMap)) {
            SESSION_MAP.put(serverName, new HashMap<>(15) {
                private static final long serialVersionUID = 5382236820686004656L;

                {
                    put(userId, new SessionDto(false, session));
                }
            });
        } else {
            subSessionMap.put(userId, new SessionDto(false, session));
        }
        // 在线用户连接数+1
        addOnlineCount();
        log.info("当前用户连接数onlineCount:{}", this.getOnlineCount());
        System.out.println(SESSION_MAP);
    }

    /**
     * 服务器端收到客户端消息时调用此方法发
     *
     * @param message 消息
     */
    @OnMessage
    public void onMessage(String message, @PathParam(value = "serverName") String serverName, @PathParam(value = "userId") String userId) {
        IMMessage imMessage = JSONUtil.toBean(message, IMMessage.class);
        if (ObjectUtils.isEmpty(imMessage)) {
            throw new BusinessException(CommonErrorEnum.PARAM_VALIDATION_ERROR);
        }
        String group = imMessage.getGroup();
        WsMsgGroupEnum wsMsg = WsMsgGroupEnum.matchGroup(group);
        if (ObjectUtils.isEmpty(wsMsg)) {
            throw new BusinessException(CommonErrorEnum.PARAM_VALIDATION_ERROR);
        }
        switch (wsMsg) {
            case ClientInit: {
                Object msgContent = imMessage.getBody();
                if (msgContent instanceof Boolean) {
                    Boolean isInit = (Boolean) msgContent;
                    clientInit(serverName, userId, isInit);
                }
                break;
            }
            case UserSingleMsg: {
                break;
            }
            case SystemMsg: {
                break;
            }
            default: {
                break;
            }
        }
        System.out.println("当前发送人sessionId = " + userId + "， 发送内容为：" + message);
        System.out.println(SESSION_MAP);

    }

    private void clientInit(String serverName, String userId, Boolean isInit) {
        SessionDto sessionDto = getSessionDto(serverName, userId);
        sessionDto.setIsInit(isInit);
    }

    /**
     * 断开连接时调用此方法，此demo刷新页面即调用
     */
    @OnClose
    public void onClose(@PathParam(value = "userId") String userId) {
        // 删除当前用户session
        SESSION_MAP.remove(userId);
        // 在线用户连接数-1
        subOnlineCount();
    }

    /**
     * 出现错误时调用此方法
     *
     * @param session session
     * @param error   错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.err.println("发生错误：" + error.getMessage() + "， sessionId = " + session.getId());
        error.printStackTrace();
    }

    /**
     * 客户端单发消息
     *
     * @param message 消息
     */
    private void sendMessage(String message, String serverName, String userId) {
        SessionDto sessionDto = this.getSessionDto(serverName, userId);
        try {
            sessionDto.getSession().getBasicRemote().sendText(message);
            System.out.println("客户端sessionId = " + userId + "，消息内容为：" + message);
        } catch (IOException e) {
            System.err.println("客户端发消息异常，异常信息为：" + e.getMessage());
        }
    }

    public void sendMessage(String message, ServerEnum serverEnum, String userId) {
        this.sendMessage(message, serverEnum.getServerName(), userId);
    }

    /**
     * 服务器群发消息给客户端
     *
     * @param message
     */
    public void sendMessageToAll(String message, String serverName) {
        for (SessionDto sessionDto : SESSION_MAP.get(serverName).values()) {
            try {
                sessionDto.getSession().getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                throw new BusinessException(CommonErrorEnum.FORBIDDEN);
            }
            System.out.println("服务端群发消息给客户端==>sessionId = " + sessionDto.getSession().getId() + "，消息内容为：" + message);
        }
    }

    /**
     * 获取当前用户连接数
     *
     * @return
     */
    public static synchronized Integer getOnlineCount() {
        return onlineCount.get();
    }

    /**
     * 当前在线用户连接数+1
     */
    private static synchronized void addOnlineCount() {
        onlineCount.addAndGet(1);
    }

    /**
     * 当前在线用户连接数-1
     */
    private static synchronized void subOnlineCount() {
        if (onlineCount.get() > 0) {
            onlineCount.addAndGet(-1);
        }
    }

    private SessionDto getSessionDto(String serverName, String userId) {
        Map<String, SessionDto> subSessionMap = SESSION_MAP.get(serverName);
        if (CollectionUtils.isEmpty(subSessionMap)) {
            throw new BusinessException(CommonErrorEnum.PARAM_VALIDATION_ERROR);
        }
        SessionDto sessionDto = subSessionMap.get(userId);
        if (ObjectUtils.isEmpty(sessionDto)) {
            throw new BusinessException(CommonErrorEnum.PARAM_VALIDATION_ERROR);
        }
        return sessionDto;
    }

    public SessionDto getSessionDto(ServerEnum serverEnum, String userId) {
        return this.getSessionDto(serverEnum.getServerName(), userId);
    }
}
