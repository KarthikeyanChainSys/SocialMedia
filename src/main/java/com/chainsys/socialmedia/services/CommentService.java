package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.repository.CommentsRepository;

@Service
public class CommentService {
	@Autowired
	private CommentsRepository commentrepo;
	
	public Comment save(Comment ur) {
		return commentrepo.save(ur);
	}
	
	public Comment findById(int id) {
		return commentrepo.findById(id);
	}
	
	public void deleteById(int id) {
		commentrepo.deleteById(id);
	}
	
	public List<Comment> getComments(){
		List<Comment> listComment = commentrepo.findAll();
		return listComment;
	}
}
