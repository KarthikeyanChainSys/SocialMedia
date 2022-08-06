package com.chainsys.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chainsys.socialmedia.compositekey.LikeCompositeKey;
import com.chainsys.socialmedia.model.Like;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikesRepository extends CrudRepository<Like,LikeCompositeKey> {
	Optional<Like> findById(LikeCompositeKey id);
	@SuppressWarnings("unchecked")
	Like save(Like theUser);
	void deleteById(LikeCompositeKey id);
	List<Like> findAll();
	
	List<Like> findByPostPostId(int id);
	List<Like> findByFriendId(int id);
	
}