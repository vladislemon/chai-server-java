package net.vladislemon.chai.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) {
        out.writeInt(message.id());
        out.writeInt(message.data().length);
        out.writeBytes(message.data());
    }
}
