package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.socialmedia.pojo.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Integer> {
	Post findById(int id);
	@SuppressWarnings("unchecked")
	Post save(Post theUser);
	void deleteById(int id);
	List<Post> findAll();
}