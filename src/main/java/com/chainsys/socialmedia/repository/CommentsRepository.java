package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.socialmedia.pojo.Comment;

import java.util.List;

public interface CommentsRepository extends CrudRepository<Comment,Integer> {
	Comment findById(int id);
	@SuppressWarnings("unchecked")
	Comment save(Comment theUser);
	void deleteById(int id);
	List<Comment> findAll();
}