package com.chainsys.socialmedia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.socialmedia.pojo.Users;
import com.chainsys.socialmedia.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository urepo;
	
	public Users save(Users ur) {
		return urepo.save(ur);
	}
	
	public Users findById(int id) {
		return urepo.findById(id);
	}
	
	public void deleteById(int id) {
		urepo.deleteById(id);
	}
	
	public List<Users> getUsers(){
		List<Users> listuser = urepo.findAll();
		return listuser;
	}
}
