package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.repository.FriendRepository;


@Service
public class FriendService {
	@Autowired
	private FriendRepository friendRepository;
	
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
}
