package net.vladislemon.chai.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInitializer());
        ChannelFuture channelFuture = serverBootstrap.bind(1337).sync();
        channelFuture.channel().closeFuture().sync();
        group.shutdownGracefully();
    }
}