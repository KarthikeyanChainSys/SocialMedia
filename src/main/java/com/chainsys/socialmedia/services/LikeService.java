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
	private LikesRepository likeRepository;
	
	public Like save(Like ur) {
		return likeRepository.save(ur);
	}
	
	public Optional<Like> findById(LikeCompositeKey id) {
		return likeRepository.findById(id);
	}
	
	public void deleteById(LikeCompositeKey id) {
		likeRepository.deleteById(id);
	}
	
	public List<Like> getLikes(){
		List<Like> listLike = likeRepository.findAll();
		return listLike;
	}
}
	