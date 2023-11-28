package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static int usersCount =3;
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(3,"Jim",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		
		user.setId(++usersCount);
		users.add(user);
		
		return user;
	}
	
	public User findOne(int id) {
	
		Predicate<? super User> predicate = user -> user.getId()==id; 
		return users.stream().filter(predicate).findFirst().get();
	}

	public User deleteUser(int id) {
		
		Predicate<? super User> predicate = user -> user.getId()==id; 
		User user = users.stream().filter(predicate).findFirst().get();
		//users.remove(user);
		users.removeIf(predicate);
		return user;
	}
}
