package com.chainsys.socialmedia.compositekey;

import java.io.Serializable;

import javax.persistence.Column;

public class LikeCompositeKey implements Serializable {
	@Column(name="postid")
	private int postId;
	@Column(name="friendid")
	private int friendId;
	
	LikeCompositeKey(){
		
	}
	
	public LikeCompositeKey(int postId, int friendId){
		this.postId = postId;
		this.friendId = friendId;
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
	
	
}
