package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.socialmedia.pojo.Users;

import java.util.List;

public interface UserRepository extends CrudRepository<Users,Integer> {
	Users findById(int id);
	Users save(Users theUser);
	void deleteById(int id);
	List<Users> findAll();
}