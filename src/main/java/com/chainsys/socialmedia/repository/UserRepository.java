package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.socialmedia.pojo.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
	User findById(int id);
	@SuppressWarnings("unchecked")
	User save(User theUser);
	void deleteById(int id);
	List<User> findAll();
}