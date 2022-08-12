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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="Comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "commentid")
    @SequenceGenerator(name = "commentid", sequenceName = "commentid",  allocationSize = 1)
	@Column(name="commentid")
	private int commentId;
	
	@Column(name="postid")
	private int postId;
	
	@Column(name="friendid")
	private int friendId;
	
	@Column(name="commenttext")
	@Size(max = 50, min = 1, message = "*Comment length should be 1 to 50")
	@NotBlank(message = "*Comment can't be Empty")
	@Pattern(regexp = "^[A-Za-z]\\w{3,20}$", message = "*Enter valid Comment ")
	private String commentText;
	
	private byte[] comments;
	private String dates;
	private String times;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commentid", nullable = false, insertable = false, updatable = false)
	private Friend friend;
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
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
	public byte[] getComments() {
		return comments;
	}
	public void setComments(byte[] comments) {
		this.comments = comments;
	}
	public String getDates() {
		return dates;
	}
	public void setDates() {
		Calendar vCalendar = Calendar.getInstance();
		String dates = vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR);
		this.dates = dates;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes() {
		Calendar vCalendar = Calendar.getInstance();
		String times = vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.times = times;
	}
}
