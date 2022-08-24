package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.repository.CommentsRepository;

@Service
public class CommentService {
	@Autowired
	private CommentsRepository commentRepository;
	
	public Comment save(Comment ur) {
		return commentRepository.save(ur);
	}
	
	public Comment findById(int id) {
		return commentRepository.findById(id);
	}
	
	public void deleteById(int id) {
		commentRepository.deleteById(id);
	}
	
	public List<Comment> getComments(int id){
		return commentRepository.findByPostId(id);
	}
	
	public List<Comment> getComments(){
		return commentRepository.findAll();
	}
	
	public byte[] getCommentImageByteArray(int id) {
		Comment comment = commentRepository.findById(id);
		byte[] imageBytes = null;	
			if(comment != null)
			{
				imageBytes = comment.getComments();
			}	
		return imageBytes;
	}
}
