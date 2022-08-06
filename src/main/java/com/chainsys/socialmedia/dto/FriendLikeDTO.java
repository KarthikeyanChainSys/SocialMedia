package com.chainsys.socialmedia.dto;

import java.util.List;

import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.Like;

public class FriendLikeDTO {
	private Friend friend;
	private List<Like> like;
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	public List<Like> getLike() {
		return like;
	}
	public void addLike(List<Like> like) {
		this.like = like;
	}
}
