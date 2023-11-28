package com.in28minutes.rest.webservices.restfulwebservices.todos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	public static int todoCount = 0;
	
	public static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(++todoCount,"in28minutes","Learn spring boot",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"in28minutes","Learn AWS",
				LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todoCount,"in28minutes","Learn Devops",
				LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUserName(String userName){
		return todos;
	}
	
	public void addTodo(String username, String description, 
			LocalDate targetDate, boolean done) {
		todos.add(new Todo(++todoCount,username,description,targetDate,done));
	}
	
	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		todos.removeIf(predicate );
	}
	
    public void updateTodo(Todo newTodo) {		
		
		Todo oldtodo = findById(newTodo.getId());
		oldtodo.setDescription(newTodo.getDescription());
		oldtodo.setTargetDate(newTodo.getTargetDate());
		oldtodo.setDone(newTodo.isDone());		
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo-> todo.getId()==id;
		
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		
		return todo;
	}
}
