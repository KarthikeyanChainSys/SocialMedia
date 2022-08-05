package com.chainsys.socialmedia.dto;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.model.Friend;

public class FriendCommentDTO {
	private Friend friend; 
	private List<Comment> commentList = new ArrayList<>();
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void addComment(Comment comment) {
		commentList.add(comment);
	}	
}
