package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.socialmedia.model.Post;

import java.util.List;
@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {
	Post findById(int id);
	@SuppressWarnings("unchecked")
	Post save(Post theUser);
	void deleteById(int id);
	List<Post> findAll();
	List<Post> findByPostIdIn(List<Integer> postId);
	List<Post> findByUserId(int id);
}