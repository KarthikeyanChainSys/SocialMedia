package com.chainsys.socialmedia.dto;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.model.Post;

public class PostCommentDTO {
	private Post post;
	private List<Comment> commentList = new ArrayList<>();
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<Comment> getCommentList(){
		return commentList;
	}
	public void addComment(Comment comment) {
		commentList.add(comment);
	}
}
