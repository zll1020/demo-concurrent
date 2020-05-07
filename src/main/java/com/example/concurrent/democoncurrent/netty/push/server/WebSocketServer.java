/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.example.concurrent.democoncurrent.netty.push.server;

import com.study.netty.push.test.TestCenter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public final class WebSocketServer {

    static int PORT = 9000;

    public static void main(String[] args) throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .childHandler(new WebSocketServerInitializer())
                    .childOption(ChannelOption.SO_REUSEADDR, true);
            for (int i = 0; i < 100; i++) {
                b.bind(++PORT).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if ("true".equals(System.getProperty("netease.debug")))
                            System.out.println("端口绑定完成：" + future.channel().localAddress());
                    }
                });
            }
            // 端口绑定完成，启动消息随机推送(测试)
            TestCenter.startTest();

            System.in.read();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
