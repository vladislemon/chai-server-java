package net.vladislemon.chai.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.id(in.readInt());
        int length = in.readInt();
        if (length > 1024 * 1024) {
            throw new IllegalArgumentException(String.format("Message length too large (%d)", length));
        }
        byte[] data = new byte[length];
        in.readBytes(data);
        messageBuilder.data(data);
        out.add(messageBuilder.build());
    }
}
