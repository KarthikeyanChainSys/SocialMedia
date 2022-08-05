package com.chainsys.socialmedia.dto;

import java.util.List;

import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.model.Post;

public class PostLikeDTO {
	private Post post;
	private List<Like> likeList;
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<Like> getLikeList(){
		return likeList;
	}
	public void addLike(List<Like> like) {
		this.likeList = like;
	}
	
}
