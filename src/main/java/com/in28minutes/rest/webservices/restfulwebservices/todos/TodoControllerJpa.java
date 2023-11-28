package com.in28minutes.rest.webservices.restfulwebservices.todos;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoControllerJpa {
		
	private TodoServiceJpa todoServiceJpa;
	
	public TodoControllerJpa(TodoService todoService, TodoServiceJpa todoServiceJpa) {
		super();
		this.todoServiceJpa = todoServiceJpa;
	}

	@GetMapping(path="/jpa/users/{username}/todos")
	public List<Todo> ListOfTodos(@PathVariable String username){
		
		return todoServiceJpa.findByUserName(username);
		
	}
	@GetMapping(path="/jpa/users/{username}/todos/{id}")
	public Todo retriveTodoById(@PathVariable String username ,
				@PathVariable int id) {
		
		return todoServiceJpa.findById(id);		
	}
	
	@DeleteMapping(path="/jpa/users/{username}/todos/{id}")
	public void deleteTodoById(@PathVariable String username,
			@PathVariable int id) {
		
		todoServiceJpa.deleteById(id);
		
	}
	
	@PutMapping(path="/jpa/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {
		todo.setId(id);
		todoServiceJpa.updateTodo(todo);
		return todo;		
	}
	
	@PostMapping(path="/jpa/users/{username}/todos")
	public void createTodo(@PathVariable String username, @RequestBody Todo todo) {
		
		todoServiceJpa.addTodo(username, todo.getDescription(), 
				todo.getTargetDate(), todo.isDone());
	}
}
