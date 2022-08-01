package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postrepo;
	
	public Post save(Post ur) {
		return postrepo.save(ur);
	}
	
	public Post findById(int id) {
		return postrepo.findById(id);
	}
	
	public void deleteById(int id) {
		postrepo.deleteById(id);
	}
	
	public List<Post> getPosts(){
		List<Post> listPost = postrepo.findAll();
		return listPost;
	}
}
