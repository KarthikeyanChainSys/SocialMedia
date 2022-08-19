package com.chainsys.socialmedia.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "postid")
    @SequenceGenerator(name = "postid", sequenceName = "postid",  allocationSize = 1)
	@Column(name="postid")
	private int postId;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="posts")
	private byte[] posts;
	
	@Column(name="medialocation")
	private String mediaLocation;
	
	@Column(name="visibility")
	private String visibility;

	@Column(name="dates")
	private String date;
	
	@Column(name="times")
	private String time;
	
	@Column(name="likecount")
	private int likeCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<Like> like;
		
	public List<Like> getLike() {
		return like;
	}
	public void setLike(List<Like> like) {
		this.like = like;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public byte[] getPosts() {
		return posts;
	}
	public void setPosts(byte[] posts) {
		this.posts = posts;
	}
	public String getMediaLocation() {
		return mediaLocation;
	}
	public void setMediaLocation(String mediaLocation) {
		this.mediaLocation = mediaLocation;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate() {
		Calendar vCalendar = Calendar.getInstance();
		String dateDetails =  vCalendar.get(Calendar.DATE) + "/" + (vCalendar.get(Calendar.MONTH)+1) + "/" + vCalendar.get(Calendar.YEAR);
		this.date = dateDetails;
	}
	public String getTime() {
		return time;
	}
	public void setTime() {
		Calendar vCalendar = Calendar.getInstance();
		String timeDetails = vCalendar.get(Calendar.HOUR) + ":" + vCalendar.get(Calendar.MINUTE);
		this.time = timeDetails;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
}
