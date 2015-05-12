package com.huang.rp.common.shiro;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <pre>
 * 功能说明：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * </pre>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ShiroUser implements Serializable {

	private Long id;// UserId
	private String userName;// name
	private boolean isAdmin;//是否系统级管理员
	private String IP;
	private List<Long> roleIdList;   
	
	public ShiroUser(){
	}
	public ShiroUser(Long id, String userName, Boolean isAdmin, String clientIp,
			List<Long> roleIdList) {
		this.id = id;
		this.userName=userName;
		this.IP = clientIp;
		this.isAdmin = isAdmin;
		this.roleIdList = roleIdList;
	}
	
	public ShiroUser(Long id,String userName,Boolean isAdmin,String clientIp){
		this.id = id;
		this.IP = clientIp;
		this.isAdmin = isAdmin;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShiroUser other = (ShiroUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	@Override
	public String toString() {
		return "ShiroUser [id=" + id + ", isAdmin=" + isAdmin + ", IP=" + IP +  "]";
	}

	
}
