package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.model.User;
import com.chainsys.socialmedia.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;
	
	public User save(User ur) {
		return userrepo.save(ur);
	}
	
	public User findById(int id) {
		return userrepo.findById(id);
	}
	
	public void deleteById(int id) {
		userrepo.deleteById(id);
	}
	
	public List<User> getUsers(){
		List<User> listuser = userrepo.findAll();
		return listuser;
	}
}
