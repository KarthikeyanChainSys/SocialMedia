package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.socialmedia.compositekey.FriendCompositeKey;
import com.chainsys.socialmedia.model.Friend;

import java.util.List;
import java.util.Optional;
@Repository
public interface FriendRepository extends CrudRepository<Friend, FriendCompositeKey> {
	Optional<Friend> findById(FriendCompositeKey id);
	@SuppressWarnings("unchecked")
	Friend save(Friend theFriend);
	void deleteById(FriendCompositeKey id);
	List<Friend> findAll();
	List<Friend> findByUserId(int id);
	List<Friend> findByFriendId(int id);
}