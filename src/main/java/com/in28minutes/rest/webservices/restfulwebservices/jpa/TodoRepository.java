package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restfulwebservices.todos.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	public List<Todo> findByUserName(String userName);

}
