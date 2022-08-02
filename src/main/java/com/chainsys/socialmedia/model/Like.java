package com.chainsys.socialmedia.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.chainsys.socialmedia.compositekey.LikeCompositeKey;

@Entity
@Table(name="likes")
@IdClass(LikeCompositeKey.class)
public class Like {
	@Id
	@Column(name="postid")
	private int postId;
	@Column(name="friendid")
	private int friendId;
	@Column(name="datetime")
	private String dateTime;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime() {
		Calendar vCalendar = Calendar.getInstance();
		String dateTime = vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR) + "_" + vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.dateTime = dateTime;
	}
}
