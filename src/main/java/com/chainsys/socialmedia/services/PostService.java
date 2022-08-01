package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.pojo.Post;
import com.chainsys.socialmedia.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository prepo;
	
	public Post save(Post ur) {
		return prepo.save(ur);
	}
	
	public Post findById(int id) {
		return prepo.findById(id);
	}
	
	public void deleteById(int id) {
		prepo.deleteById(id);
	}
	
	public List<Post> getPosts(){
		List<Post> listPost = prepo.findAll();
		return listPost;
	}
}
