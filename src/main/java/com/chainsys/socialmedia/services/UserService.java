package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.pojo.User;
import com.chainsys.socialmedia.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository urepo;
	
	public User save(User ur) {
		return urepo.save(ur);
	}
	
	public User findById(int id) {
		return urepo.findById(id);
	}
	
	public void deleteById(int id) {
		urepo.deleteById(id);
	}
	
	public List<User> getUsers(){
		List<User> listuser = urepo.findAll();
		return listuser;
	}
}
