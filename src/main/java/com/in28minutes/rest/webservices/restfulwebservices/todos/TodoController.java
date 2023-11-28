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
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@GetMapping(path="/users/{username}/todos")
	public List<Todo> ListOfTodos(@PathVariable String username){
		
		return todoService.findByUserName(username);
		
	}
	@GetMapping(path="/users/{username}/todos/{id}")
	public Todo retriveTodoById(@PathVariable String username ,
				@PathVariable int id) {
		
		return todoService.findById(id);		
	}
	
	@DeleteMapping(path="/users/{username}/todos/{id}")
	public void deleteTodoById(@PathVariable String username,
			@PathVariable int id) {
		
		todoService.deleteById(id);
		
	}
	
	@PutMapping(path="/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {		
		todoService.updateTodo(todo);
		return todo;		
	}
	
	@PostMapping(path="/users/{username}/todos")
	public void createTodo(@PathVariable String username, @RequestBody Todo todo) {
		
		todoService.addTodo(username, todo.getDescription(), 
				todo.getTargetDate(), todo.isDone());
	}
}
