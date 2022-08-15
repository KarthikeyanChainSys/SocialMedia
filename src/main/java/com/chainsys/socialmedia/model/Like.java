package com.chainsys.socialmedia.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="likes")
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "likeid")
	@SequenceGenerator(name = "likeid", sequenceName = "likeid", allocationSize = 1)
	@Column(name="likeid")
	private int likeId;

	@Column(name="postid")
	private int postId;
	

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
	
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
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
		String datetime = vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR) + "_" + vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.dateTime = datetime;
	}
}
