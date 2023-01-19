package net.vladislemon.chai.server;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteOrder;

public class MessageFrameDecoder extends LengthFieldBasedFrameDecoder {
    public MessageFrameDecoder() {
        super(
                ByteOrder.BIG_ENDIAN,
                maxFrameLength,
                lengthFieldOffset,
                lengthFieldLength,
                lengthAdjustment,
                initialBytesToStrip,
                failFast
        );
    }
}
