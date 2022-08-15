package com.chainsys.socialmedia.compositekey;

import java.io.Serializable;
import javax.persistence.Column;
@SuppressWarnings("serial")
public class FriendCompositeKey implements Serializable {
	@Column(name="userid")
	private int userId;
	@Column(name="friendid")
	private int friendId;
	
	FriendCompositeKey(){
		
	}
	
	public FriendCompositeKey(int friendId, int userId){
		this.userId = userId;
		this.friendId = friendId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	
	
}
