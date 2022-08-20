package com.chainsys.socialmedia.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chainsys.socialmedia.model.Like;
import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.repository.LikesRepository;

@Service
public class LikeService {
	@Autowired
	private LikesRepository likeRepository;
	@Autowired
	private PostService postService;
	
	public Like save(Like likes) {
		List<Like> likeList = likeRepository.findByPostId(likes.getPostId());
		for(int i=0; i<likeList.size(); i++) {
			if(likeList.get(i).getFriendId() == likes.getFriendId()) {
				likeRepository.deleteById(likeList.get(i).getLikeId());
				return likes;
			}
		}
		Like like = likeRepository.save(likes);
		Post post = postService.findById(likes.getPostId());
		post.setLikeCount(post.getLikeCount() + 1);
		postService.save(post);
		return like;
	}
	
	public Like findById(int id) {
		return likeRepository.findById(id);
	}
	
	public void deleteById(int id) {
		likeRepository.deleteById(id);
	}
	
	public List<Like> getLikes(){
		return likeRepository.findAll();
	}
}
	