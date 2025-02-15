package com.in28Min.springboot.myfurstwebapp.todo.withoutjpa;

import com.in28Min.springboot.myfurstwebapp.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private  static  int todosCount = 0;
    private static List<Todo> todos = new ArrayList<>();
    static  {
        todos.add(new Todo(++todosCount, "Valera", "Learn Aws",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Valera", "Learn Java",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "Valera", "Learn C",
                LocalDate.now().plusYears(3), false));


    }
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username) ;
        return  todos.stream().filter(predicate).toList();
    }
    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount, username,description,targetDate,done);
        todos.add(todo);

    }
    public void deletById(int id){

        Predicate<? super Todo> predicate = todo -> todo.getId() == id;

        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
       Todo todo = todos.stream().filter(predicate).findFirst().get();
        return  todo;
    }

    public void updateTodo(Todo todo) {
        deletById(todo.getId());
        todos.add(todo);
    }
}
