package org.qiyu.live.im.core.server.common;

import io.netty.util.AttributeKey;

/**
 * im的channel上下文绑定属性
 *
 * @Author idea
 * @Date: Created in 21:40 2023/7/9
 * @Description
 */
public class ImContextAttr {

    /**
     * 绑定用户id
     */
    public static AttributeKey<Long> USER_ID = AttributeKey.valueOf("userId");

    /**
     * 绑定appId
     */
    public static AttributeKey<Integer> APP_ID = AttributeKey.valueOf("appId");
}
