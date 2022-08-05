package com.chainsys.socialmedia.dto;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.model.User;

public class UserPostDTO {
	private User user;
	private List<Post> postList = new ArrayList<Post>();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Post> getPostList(){
		return postList;
	}
	public void addPost(Post post) {
		postList.add(post);
	}
}
