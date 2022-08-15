package com.chainsys.socialmedia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.chainsys.socialmedia.compositekey.FriendCompositeKey;

@Entity
@Table(name="friends")
@IdClass(FriendCompositeKey.class)
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "friendid")
    @SequenceGenerator(name = "friendid", sequenceName = "friendid",  allocationSize = 1)
	@Column(name="friendid")
	private int friendId;
	
	@Id
	@Column(name="userid")
	private int userId;
	
	@Column(name="requeststatus")
	@NotEmpty(message = "*Please enter gender")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "*Value should be in Alphabets ")
	private String requestStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
}
