/*
 * Copyright 2012 The Netty Project
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
package me.hrps.rp.preview.chat.service;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.ssl.SslContext;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.hrps.rp.preview.chat.domain.MetaData;

import com.google.common.collect.Maps;
import com.huang.rp.common.utils.SpringContextHolder;

/**
 * 都是单例
 * 这个ChannelHandlerAdapter是总的adapter
 * pipeline里面的adapter是每个channel独立的adapter
 */
@Service
public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {
	public static Map<String,Channel>chs=Maps.newConcurrentMap();
	public static Map<String,MetaData>mds=Maps.newConcurrentMap();

    public WebSocketServerInitializer() {
    }

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
    	System.out.println(ch.id());
    	
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new WebSocketServerCompressionHandler());
        pipeline.addLast((WebSocketServerHandler)SpringContextHolder.getBean("webSocketServerHandler"));
        verifyChannel(ch);
    }
    /**
     * 验证所有channel,关闭失效的channel
     */
    public void verifyChannel(SocketChannel ch){
    	for(Map.Entry<String, Channel>channel:chs.entrySet()){
        	Channel chn=channel.getValue();
        	String id=channel.getKey();
        	if(!chn.isActive()){
        		chs.remove(id);
        		mds.remove(id);
        	}else{
        		//向所有
        		chn.writeAndFlush(new TextWebSocketFrame("{\"name\":\"json\"}"));
        	}
        }
    	chs.put(ch.id().toString(), ch);
    }
    /**
     * 推送上线消息
     */
    public void pushMemberUpdate(SocketChannel ch){
    	//ChannelId id=DefaultChannelId();
    }
    
    public void test1(){
    	
    }
}
