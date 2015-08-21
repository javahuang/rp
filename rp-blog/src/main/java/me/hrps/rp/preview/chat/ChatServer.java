/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package me.hrps.rp.preview.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import me.hrps.rp.preview.chat.service.WebSocketServerInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * <p/>在于spring集成的过程中,开始服务器一直启动不起来，后来想想应该是在init方法中如果直接启动netty,因为netty是阻塞的,导致当前线程停顿，后续的整个web容器就不能启动
 * <p/>所以想到一个方法，就是另外开一个线程来启动netty，并且在启动之前将端口号设置为chatServer的静态变量
 * <p>
 * User: Huang rp
 * <p>
 * Date: 2015年8月18日 下午6:42:12
 * <p>
 * Version: 1.0
 */
public class ChatServer{
	Logger log = LoggerFactory.getLogger(getClass());
	@Value("${chat.port}")
	private int PORT;
	@Autowired
	WebSocketServerInitializer socketServerInit;
	
	/**
	 * 聊天服务器初始化
	 */
	public void init() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				log.info("聊天服务初始化...");
				EventLoopGroup bossGroup = new NioEventLoopGroup(1);
				EventLoopGroup workerGroup = new NioEventLoopGroup();
				try {
					ServerBootstrap b = new ServerBootstrap();
					b.group(bossGroup, workerGroup)
							.channel(NioServerSocketChannel.class)
							.handler(new LoggingHandler(LogLevel.INFO))
							.childHandler(socketServerInit);
					Channel ch = b.bind(PORT).sync().channel();
					ch.closeFuture().sync();
				} catch (Exception e) {
					log.error(e.getMessage());
				} finally {
					bossGroup.shutdownGracefully();
					workerGroup.shutdownGracefully();
				}
			}
		}).start();
	}

	// static final int PORT = Integer.parseInt(System.getProperty("port",
	// "9080"));

}
