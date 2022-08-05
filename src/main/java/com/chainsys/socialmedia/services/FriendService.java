package com.chainsys.socialmedia.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.dto.FriendCommentDTO;
import com.chainsys.socialmedia.model.Comment;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.repository.CommentsRepository;
import com.chainsys.socialmedia.repository.FriendRepository;


@Service
public class FriendService {
	@Autowired
	private FriendRepository friendRepository;
	@Autowired
	private CommentsRepository commentRepository;
	
	public Friend save(Friend ur) {
		return friendRepository.save(ur);
	}
	
	public Friend findById(int id) {
		return friendRepository.findById(id);
	}
	
	public void deleteById(int id) {
		friendRepository.deleteById(id);
	}
	
	public List<Friend> getFriends(){
		List<Friend> listFriend = friendRepository.findAll();
		return listFriend;
	}
	
	public FriendCommentDTO getFriendAndComment(int id) {
		FriendCommentDTO friendCommentDto = new FriendCommentDTO();
		friendCommentDto.setFriend(getFriends().get(id));
		List<Comment> comment = commentRepository.findByFriendId(id);
		Iterator<Comment> commentItr = comment.iterator();
		while (commentItr.hasNext()) {
			friendCommentDto.addComment((Comment) commentItr.next());
		}
		return friendCommentDto;
	}
}
