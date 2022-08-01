package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.repository.FriendRepository;


@Service
public class FriendService {
	@Autowired
	private FriendRepository friendrepo;
	
	public Friend save(Friend ur) {
		return friendrepo.save(ur);
	}
	
	public Friend findById(int id) {
		return friendrepo.findById(id);
	}
	
	public void deleteById(int id) {
		friendrepo.deleteById(id);
	}
	
	public List<Friend> getFriends(){
		List<Friend> listFriend = friendrepo.findAll();
		return listFriend;
	}
}
