package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.socialmedia.model.Friend;

import java.util.List;
@Repository
public interface FriendRepository extends CrudRepository<Friend,Integer> {
	Friend findById(int id);
	@SuppressWarnings("unchecked")
	Friend save(Friend theUser);
	void deleteById(int id);
	List<Friend> findAll();
	
	List<Friend> findByUserUserId(int id);
}