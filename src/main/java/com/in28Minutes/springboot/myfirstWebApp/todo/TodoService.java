package com.in28Minutes.springboot.myfirstWebApp.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;


@Service
public class TodoService {

	private static  List<Todo> todos=new ArrayList<>();
	public static int todosCount=0;
	static {
		todos.add(new Todo(++todosCount, "in2Minutes", "Learn AWS",LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "in2Minutes", "Learn Devops",LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "in2Minutes", "Learn Full Stack Development",LocalDate.now().plusYears(3), false));
		
	}
	public List<Todo> findByUsername(String username) {
		return todos;
		
	}
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo= new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
		
	}
	public void deleteById(int id) {
		//todo.getId==id
		
		
		Predicate<? super Todo> predicate
		= todo-> todo.getId()==id ;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		
		Predicate<? super Todo> predicate
		= todo-> todo.getId()==id ;
	Todo todo=	todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Validated Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}

}
