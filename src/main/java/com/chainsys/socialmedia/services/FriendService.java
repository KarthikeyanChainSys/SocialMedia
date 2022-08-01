package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.pojo.Friend;
import com.chainsys.socialmedia.repository.FriendRepository;


@Service
public class FriendService {
	@Autowired
	private FriendRepository frepo;
	
	public Friend save(Friend ur) {
		return frepo.save(ur);
	}
	
	public Friend findById(int id) {
		return frepo.findById(id);
	}
	
	public void deleteById(int id) {
		frepo.deleteById(id);
	}
	
	public List<Friend> getFriends(){
		List<Friend> listFriend = frepo.findAll();
		return listFriend;
	}
}
