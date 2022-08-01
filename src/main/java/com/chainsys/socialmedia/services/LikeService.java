package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.pojo.Like;
import com.chainsys.socialmedia.repository.LikesRepository;

@Service
public class LikeService {
	@Autowired
	private LikesRepository lrepo;
	
	public Like save(Like ur) {
		return lrepo.save(ur);
	}
	
	public Like findById(int id) {
		return lrepo.findById(id);
	}
	
	public void deleteById(int id) {
		lrepo.deleteById(id);
	}
	
	public List<Like> getLikes(){
		List<Like> listLike = lrepo.findAll();
		return listLike;
	}

}
