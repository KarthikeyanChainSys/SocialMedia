package com.chainsys.socialmedia.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chainsys.socialmedia.compositekey.LikeCompositeKey;

@Entity
@Table(name="likes")
@IdClass(LikeCompositeKey.class)
public class Like {
	@Id
	@Column(name="postid")
	private int postId;
	@Id
	@Column(name="friendid")
	private int friendId;
	@Column(name="datetime")
	private String dateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postid", nullable = false, insertable = false, updatable = false)
	private Post post;
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "friendid", nullable = false, updatable = false, insertable = false)
	private Friend friend;
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
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
