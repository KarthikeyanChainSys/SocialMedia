package com.chainsys.socialmedia.dto;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.User;

public class UserFriendDTO {
	private User user;
	private List<Friend> friendList=new ArrayList<>();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Friend> getFriendList() {
		return friendList;
	}
	public void addFriend(Friend friend) {
		friendList.add(friend);
	}
}
