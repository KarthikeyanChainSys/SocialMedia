package com.chainsys.socialmedia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.compositekey.LikeCompositeKey;
import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.repository.LikesRepository;

@Service
public class LikeService {
	@Autowired
	private LikesRepository likerepo;
	
	public Like save(Like ur) {
		return likerepo.save(ur);
	}
	
	public Optional<Like> findById(LikeCompositeKey id) {
		return likerepo.findById(id);
	}
	
	public void deleteById(LikeCompositeKey id) {
		likerepo.deleteById(id);
	}
	
	public List<Like> getLikes(){
		List<Like> listLike = likerepo.findAll();
		return listLike;
	}

}
