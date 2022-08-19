package com.chainsys.socialmedia.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chainsys.socialmedia.compositekey.FriendCompositeKey;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.repository.FriendRepository;
@Service
public class FriendService {
	@Autowired
	private FriendRepository friendRepository;
	
	public Friend save(Friend theFriend) {
		return friendRepository.save(theFriend);
	}
	
	public Optional<Friend> findById(FriendCompositeKey id) {
		return friendRepository.findById(id);
	}
	
	public void deleteById(FriendCompositeKey id) {
		friendRepository.deleteById(id);
	}
	
	public List<Friend> getFriends(){
		return friendRepository.findAll();
	}
	
	public List<Friend> findByUserId(int id){
		return friendRepository.findByUserId(id);
	}
	
	public List<Friend> findByFriendId(int id){
		return friendRepository.findByFriendId(id);
	}
	
//	public FriendCommentDTO getFriendAndComment(FriendCompositeKey id) {
//		Optional<Friend> friend = findById(id);
//		FriendCommentDTO friendCommentDto = new FriendCommentDTO();
//		friendCommentDto.setFriend(friend);
//		List<Comment> comment = commentRepository.findByFriendId(id);
//		friendCommentDto.addComment(comment);
//		return friendCommentDto;
//	}
//	
//	public FriendLikeDTO getFriendAndLike(int id) {
//		Friend friend = findById(id);
//		FriendLikeDTO friendLikeDto = new FriendLikeDTO();
//		friendLikeDto.setFriend(friend);
//		List<Like> like = likeRepository.findByFriendId(id);
//		friendLikeDto.addLike(like);
//		return friendLikeDto;
//	}
	
}
