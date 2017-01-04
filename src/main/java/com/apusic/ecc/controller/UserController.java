package com.apusic.ecc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apusic.ecc.entity.User;
import com.apusic.ecc.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/{id}")
	public User findDetail(@PathVariable String id){
		User user = new User();
		user.setId(id);
		user.setPassword("123456");
		user.setUserName("wang");
		return user;
	}
	
	@RequestMapping("/save")
	public String save(){
		User user = new User();
		user.setPassword("123456");
		user.setUserName("test");
		userRepository.save(user);
		return "ok";
	}
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
