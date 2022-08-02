package com.chainsys.socialmedia.model;

import java.sql.Blob;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Comments")
public class Comment {
	@Id
	@Column(name="commentid")
	private int commentId;
	@Column(name="postid")
	private int postId;
	@Column(name="friendid")
	private int friendId;
	@Column(name="commentText")
	private String commentText;
	private Blob comments;
	private String dates;
	private String times;
	
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
	public String getDates() {
		return dates;
	}
	public void setDates() {
		Calendar vCalendar = Calendar.getInstance();
		String dates = vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR) + "_" + vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.dates = dates;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes() {
		Calendar vCalendar = Calendar.getInstance();
		String times = vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR) + "_" + vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.times = times;
	}
}
