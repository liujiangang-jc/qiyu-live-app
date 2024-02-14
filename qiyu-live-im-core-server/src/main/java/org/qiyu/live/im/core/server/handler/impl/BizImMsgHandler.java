package org.qiyu.live.im.core.server.handler.impl;

import io.netty.channel.ChannelHandlerContext;
import org.qiyu.live.im.core.server.common.ImMsg;
import org.qiyu.live.im.core.server.handler.SimplyHandler;
import org.springframework.stereotype.Component;

/**
 * 业务消息处理器
 *
 * @Author idea
 * @Date: Created in 20:41 2023/7/6
 * @Description
 */
@Component
public class BizImMsgHandler implements SimplyHandler {

    @Override
    public void handler(ChannelHandlerContext ctx, ImMsg imMsg) {
        System.out.println("[bizImMsg]:" + imMsg);
        ctx.writeAndFlush(imMsg);
    }
}
