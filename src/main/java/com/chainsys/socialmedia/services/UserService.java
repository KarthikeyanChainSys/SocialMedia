package com.chainsys.socialmedia.services;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chainsys.socialmedia.dto.UserFriendDTO;
import com.chainsys.socialmedia.dto.UserPostDTO;
import com.chainsys.socialmedia.model.Friend;
import com.chainsys.socialmedia.model.Post;
import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.repository.FriendRepository;
import com.chainsys.socialmedia.repository.PostRepository;
import com.chainsys.socialmedia.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FriendRepository friendRepository;
	@Autowired
	private PostRepository postRepository;
	
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
		return userRepository.findAll();
	}
	
	public UserFriendDTO getUserAndFriend(int id) {
		UserFriendDTO userFriendDto = new UserFriendDTO();
		userFriendDto.setUser(getUsers().get(id));
		List<Friend> friend = friendRepository.findByUserId(id);
		Iterator<Friend> friendItr = friend.iterator();
		while (friendItr.hasNext()) {
			userFriendDto.addFriend(friendItr.next());
		}
		return userFriendDto;
	}
	
	public UserPostDTO getUserAndPost(int id) {
		UserPostDTO userPostDto = new UserPostDTO();
		userPostDto.setUser(getUsers().get(id));
		List<Post> post = postRepository.findByUserId(id);
		Iterator<Post> postItr = post.iterator();
		while (postItr.hasNext()) {
			userPostDto.addPost(postItr.next());
		}
		return userPostDto;
	}
	
	public List<User> getUsersWithoutFriends(int userId) {
		List<Friend> friendList = friendRepository.findByUserId(userId);
		if(friendList.isEmpty()) {
			return filterOwnId(userRepository.findAll(), userId);
		}
		List<Integer> duplicateUserList = friendList.stream().map(Friend::getFriendId).collect(Collectors.toList());
		List<Integer> userIdList = duplicateUserList.stream().distinct().collect(Collectors.toList());
		List<User> userDetails = userRepository.findByUserIdNotIn(userIdList);
		return filterOwnId(userDetails,userId);
	}
	
	public User getEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public List<User> filterOwnId(List<User> user, int id){
		return user.stream().filter(filteredUser->filteredUser.getUserId()!=id).collect(Collectors.toList()); 
		
	}
	
	public byte[] getUserImageByteArray(int id) {
		User user = userRepository.findById(id);
		byte[] imageBytes = null;
			if(user != null)
			{
				imageBytes = user.getProfile();
			}
		return imageBytes;
	}
}
