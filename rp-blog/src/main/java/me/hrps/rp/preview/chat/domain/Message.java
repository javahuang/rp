package me.hrps.rp.preview.chat.domain;

import java.util.Date;

public class Message {
	private String from;
	private String to;
	private String msg;
	private String channelid;//目标会话的channelid
	private String typing;
	
	private Date time;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTyping() {
		return typing;
	}
	public void setTyping(String typing) {
		this.typing = typing;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	
	
}
