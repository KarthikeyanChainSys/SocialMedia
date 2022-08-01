package com.chainsys.socialmedia.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="likes")
public class Like {
	@Id
	private int postid;
	private int friendid;
	private String datetime;
	
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime() {
		Calendar vCalendar = Calendar.getInstance();
		String dateTime = vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR) + "_" + vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);;
		this.datetime = dateTime;
	}
}
