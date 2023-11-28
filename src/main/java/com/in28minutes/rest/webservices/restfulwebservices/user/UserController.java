package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserDaoService userDaoService;
	
	public UserController(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}

	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User getUserBasedOnId(@PathVariable int id) {
		return userDaoService.findOne(id);
	}
	
	@PostMapping(path="/users")
	public User saveUser(@Valid @RequestBody User user) {
		
		return userDaoService.saveUser(user);		 
	}
	
	@DeleteMapping(path="/users/{id}")
	public User deleteUser(@PathVariable int id) {
		return userDaoService.deleteUser(id);
	}

}
