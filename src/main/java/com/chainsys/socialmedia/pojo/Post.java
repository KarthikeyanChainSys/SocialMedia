package com.chainsys.socialmedia.pojo;

import java.sql.Blob;
import java.util.Date;
import java.util.TimeZone;

public class Post {
	private int postId;
	private int userId;
	private Blob postType;
	private String mediaLocation;
	private String visibility;
	private Date dates;
	private TimeZone times;
	private int likeCount;
	
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

	public Blob getPostType() {
		return postType;
	}

	public void setPostType(Blob postType) {
		this.postType = postType;
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

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public TimeZone getTimes() {
		return times;
	}

	public void setTimes(TimeZone times) {
		this.times = times;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
}
