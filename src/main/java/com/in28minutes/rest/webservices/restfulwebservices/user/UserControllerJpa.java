package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.jpa.UserRepository;
import com.in28minutes.rest.webservices.restfulwebservices.posts.Post;

import jakarta.validation.Valid;

@RestController
public class UserControllerJpa {

	private UserDaoService userDaoService;
	private UserRepository userRepo;
	private PostRepository postRepo;

	public UserControllerJpa(UserRepository userRepo, PostRepository postRepo) {
		super();
		this.userRepo = userRepo;
		this.postRepo = postRepo;
	}

	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public User getUserBasedOnId(@PathVariable int id) {
		return userRepo.findById(id).get();
	}

	@PostMapping(path = "/jpa/users")
	public User saveUser(@Valid @RequestBody User user) {

		return userRepo.save(user);
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepo.deleteById(id);
	}

	
	  @GetMapping(path="/jpa/users/{id}/posts") 
	  public List<Post> getAllPostsForUser(@PathVariable int id){
	  
	  User user = userRepo.findById(id).get(); 
	  for(Post p:user.getPosts()) {
		  System.out.println(p);
	  }
	  return user.getPosts();
	  
	  }
	  
	  @PostMapping(path="/jpa/users/{id}/posts") 
	  public Post  createPostForUser(@PathVariable int id, @RequestBody Post post){
	  
	  User user = userRepo.findById(id).get();
	  post.setUser(user);
	  postRepo.save(post);
	  
	  return post;
	  
	  }
}
