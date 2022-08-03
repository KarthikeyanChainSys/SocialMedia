package com.chainsys.socialmedia.services;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.dto.UserFriendDTO;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.repository.FriendRepository;
import com.chainsys.socialmedia.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FriendRepository friendRepository;
	
	public User save(User ur) {
		return userRepository.save(ur);
	}
	
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	
	public List<User> getUsers(){
		List<User> listuser = userRepository.findAll();
		return listuser;
	}
	
	public UserFriendDTO getUserAndFriend(int id) {
//		User user = findById(id);
		UserFriendDTO userFriendDto = new UserFriendDTO();
		userFriendDto.setUser(getUsers().get(id));
		List<Friend> friend = friendRepository.findByUserUserId(id);
		Iterator<Friend> friendItr = friend.iterator();
		while (friendItr.hasNext()) {
			userFriendDto.addFriend((Friend) friendItr.next());
		}
		return userFriendDto;
	}
}
