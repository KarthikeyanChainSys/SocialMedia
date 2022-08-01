package com.chainsys.socialmedia.model;

import java.sql.Blob;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Comments")
public class Comment {
	@Id
	private int commentId;
	private int postId;
	private int friendId;
	private String commentText;
	private Blob comments;
	private Date dates;
	private TimeZone times;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Blob getComments() {
		return comments;
	}
	public void setComments(Blob comments) {
		this.comments = comments;
	}
	public Date getDates() {
		return dates;
	}
	public void setDate(Date dates) {
		this.dates = dates;
	}
	public TimeZone getTimes() {
		return times;
	}
	public void setTime(TimeZone times) {
		this.times = times;
	}
}
