package com.chainsys.socialmedia.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class Friend {
	@Id
	private int friendid;
	private int userid;
	private String requeststatus;
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}
	
}
