package net.vladislemon.chai.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageProcessor extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.id(message.id());
        messageBuilder.data(message.data().clone());
        ChannelFuture channelFuture = ctx.writeAndFlush(messageBuilder.build());
        channelFuture.addListener(ChannelFutureListener.CLOSE);
    }
}
