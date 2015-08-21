package me.hrps.rp.preview.chat.domain;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author rp
 *
 */
public class MetaData {

	private int type;
	private PreChatUser user;// 当前登录用户
	private List<PreChatUser> users;// 所有在线用户
	private Message msg;
	private Date lastAccessTime;// 最后登录时间

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public PreChatUser getUser() {
		return user;
	}

	public void setUser(PreChatUser user) {
		this.user = user;
	}

	public List<PreChatUser> getUsers() {
		return users;
	}

	public void setUsers(List<PreChatUser> users) {
		this.users = users;
	}

}
