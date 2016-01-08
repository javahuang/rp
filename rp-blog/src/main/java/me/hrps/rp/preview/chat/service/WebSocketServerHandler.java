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

import static io.netty.handler.codec.http.HttpHeaderNames.ACCESS_CONTROL_ALLOW_CREDENTIALS;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderUtil;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

import java.util.Iterator;
import java.util.List;

import me.hrps.rp.preview.chat.dao.PreChatUserMapper;
import me.hrps.rp.preview.chat.domain.Message;
import me.hrps.rp.preview.chat.domain.MetaData;
import me.hrps.rp.preview.chat.domain.PreChatUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.huang.rp.common.mapper.JacksonMapper;
import com.huang.rp.common.utils.Encodes;
import com.huang.rp.common.utils.ReflectionUtils;

/**
 * Handles handshakes and messages
 */
@Service("chatHandler")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
	@Autowired
	PreChatUserMapper chatUserMapper; 
	
    private static final String WEBSOCKET_PATH = "/websocket";
    
    private HttpPostRequestDecoder decoder;
    private static final HttpDataFactory factory =
            new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE); // Disk if size exceed
    
    private WebSocketServerHandshaker handshaker;

    @Override
    public void messageReceived(ChannelHandlerContext ctx, Object msg) {
    	System.out.println(ctx.channel().id().toString());
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    @Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
	}

	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        // Handle a bad request.
        if (!req.decoderResult().isSuccess()) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
            return;
        }
        //HttpObjectAggregator $ AggregatedFullHttpRequest
        if(req.method()==POST){
        	 try {
        		 //TODO 没有找到一个简便的方法来获取post请求参数
                 decoder = new HttpPostRequestDecoder(factory, req);
                 List<InterfaceHttpData> data=decoder.getBodyHttpDatas();
                 for(InterfaceHttpData postData:data){
                	 Attribute attr=(Attribute)postData;
                	 System.out.println(attr.getName()+" "+attr.getValue());
                 }
             } catch (Exception e1) {
                 e1.printStackTrace();
                 ctx.channel().close();
                 return;
             }
        	 ByteBuf buffer=Unpooled.copiedBuffer("success", CharsetUtil.UTF_8);
        	 FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, OK,buffer);
        	 res.headers().set(CONTENT_TYPE, "text/html; charset=UTF-8");
        	 res.headers().set(ACCESS_CONTROL_ALLOW_CREDENTIALS,"*");
        	 sendHttpResponse(ctx, req, res);
        	return;
        }
        // Allow only GET methods.
//        if (req.method() != GET) {
//            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN));
//            return;
//        }

        // Send the demo page and favicon.ico
        if ("/".equals(req.uri())) {
            ByteBuf content = WebSocketServerIndexPage.getContent(getWebSocketLocation(req));
            FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, OK, content);
            res.headers().set(ACCESS_CONTROL_ALLOW_CREDENTIALS,"*");
            res.headers().set(CONTENT_TYPE, "text/html; charset=UTF-8");
            HttpHeaderUtil.setContentLength(res, content.readableBytes());

            sendHttpResponse(ctx, req, res);
            return;
        }
        if ("/favicon.ico".equals(req.uri())) {
            FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, NOT_FOUND);
            sendHttpResponse(ctx, req, res);
            return;
        }

        // Handshake
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                getWebSocketLocation(req), null, true);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
    	Channel chn=ctx.channel();
    	String chnId=chn.id().toString();
        // Check for closing frame
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass()
                    .getName()));
        }

        // Send the uppercase string back.
        String request = ((TextWebSocketFrame) frame).text().toLowerCase();
        //MSG=&FROM=4&TO=%235&TYPING=TRUE  正在输入
        //MSG=222&FROM=4&TO=%235&TYPING=FALSE	输出消息
        if(request!=null&&request.startsWith("msg")){
        	request=Encodes.urlDecode(request.toLowerCase());
        	String[] reqMsg=request.split("&");
        	Message msg=new Message();
        	for(String input:reqMsg){
        		String[] inputvalue=input.split("=");
        		if(inputvalue.length==2)
        			ReflectionUtils.invokeSetter(msg, inputvalue[0], inputvalue[1]);
        	}
        	Channel toChannel=WebSocketServerInitializer.chs.get(msg.getChannelid());
        	
        	//用户发出消息
        	if("false".equals(msg.getTyping())){
        		if(msg.getTo()!=null){
        			msg.setTo(msg.getTo().replace("#", ""));
        		}
        		MetaData chatMsgInfo=new MetaData();
        		chatMsgInfo.setType(2);
        		chatMsgInfo.setMsg(msg);
        		if(toChannel.isActive()){
        			String pushChatInfo=JacksonMapper.toJSONString(chatMsgInfo);
            		toChannel.writeAndFlush(new TextWebSocketFrame(pushChatInfo));
            	}
        	}
        	return;
        }
        
        MetaData md=JacksonMapper.readValue(request, MetaData.class);
        //执行认证操作,将登录用户信息放入集合
        if(WebSocketServerInitializer.mds.get(chnId)==null&&md!=null&&md.getType()==3){
        	PreChatUser user=chatUserMapper.selectByPrimaryKey(md.getUser().getId());
        	user.setChannelid(chnId);
        	if(user!=null)
        		md.setUser(user);
        	 WebSocketServerInitializer.mds.put(chnId, md);
        	 //推送用户上线消息,更新在线用户列表
        	 MetaData onlineMemberInfo=new MetaData();
        	 onlineMemberInfo.setType(1);
        	 List<PreChatUser> users=Lists.newArrayList();
        	 Iterator<MetaData> it=WebSocketServerInitializer.mds.values().iterator();
        	 while(it.hasNext()){
        		 MetaData onlineUser=it.next();
        		 users.add(onlineUser.getUser());
        	 }
        	 onlineMemberInfo.setUsers(users);
        	 String pushOnlineInfo=JacksonMapper.toJSONString(onlineMemberInfo);
        	 Iterator<Channel>chnItor=WebSocketServerInitializer.chs.values().iterator();
        	 while(chnItor.hasNext()){
        		 Channel currChn=chnItor.next();
        		 if(currChn.isActive()){
        			 currChn.writeAndFlush(new TextWebSocketFrame(pushOnlineInfo));
        		 }
        	 }
        	 return;
    	}
        
        System.err.printf("%s received %s%n", ctx.channel(), request);
        ChannelFuture f=ctx.channel().write(new TextWebSocketFrame(request.toUpperCase()));
        if("bye".equals(request)){
        	f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private static void sendHttpResponse(
            ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
        // Generate an error page if response getStatus code is not OK (200).
        if (res.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
            HttpHeaderUtil.setContentLength(res, res.content().readableBytes());
        }

        // Send the response and close the connection if necessary.
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!HttpHeaderUtil.isKeepAlive(req) || res.status().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    private static String getWebSocketLocation(FullHttpRequest req) {
        String location =  req.headers().get(HOST) + WEBSOCKET_PATH;
        if (WebSocketServer.SSL) {
            return "wss://" + location;
        } else {
            return "ws://" + location;
        }
    }
}
