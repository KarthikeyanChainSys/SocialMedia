package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.socialmedia.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	User findById(int id);
	@SuppressWarnings("unchecked")
	User save(User theUser);
	void deleteById(int id);
	List<User> findAll();
	User findByEmail(String email);
//	User findByEmailAndPassword(String email, String password);
}