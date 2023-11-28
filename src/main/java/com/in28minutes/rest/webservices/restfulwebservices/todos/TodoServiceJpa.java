package com.in28minutes.rest.webservices.restfulwebservices.todos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.jpa.TodoRepository;

import jakarta.persistence.criteria.Predicate;

@Service
public class TodoServiceJpa {
	
	private TodoRepository todoRepo;
	
	public TodoServiceJpa(TodoRepository todoRepo) {
		super();
		this.todoRepo = todoRepo;
	}

	public void addTodo(String username, String description, 
			LocalDate targetDate, boolean done) {
		Todo todo = new Todo();
		todo.setUserName(username);
		todo.setDescription(description);
		todo.setTargetDate(targetDate);
		todo.setDone(done);
		todoRepo.save(todo);
	}

	public void updateTodo(Todo todo) {
		
		Todo todoOld = todoRepo.findById(todo.getId()).get();
		
		/*
		 * todoOld.setDescription(todo.getDescription());
		 * todoOld.setTargetDate(todo.getTargetDate()); todoOld.setDone(todo.isDone());
		 * todoOld.setUserName(todo.getUserName());
		 */
		todoRepo.delete(todoOld);
		todoRepo.save(todo);
	}

	public void deleteById(int id) {
		
		todoRepo.deleteById(id);
		
	}

	public Todo findById(int id) {
		
		Todo todo = todoRepo.findById(id).get();
		return todo;
	}

	public List<Todo> findByUserName(String username) {
			
		List<Todo> todos = todoRepo.findByUserName(username);
		return todos;
	}

}
