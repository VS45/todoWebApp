package com.vs45tech.springboot.todoWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todoList=new ArrayList<>();
    private static int todoCount=0;
    static{
        todoList.add(new Todo(++todoCount, "vs45Tech",
         "Get AWS Certified", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(++todoCount, "vs45Tech",
         "Learn DevOps", LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(++todoCount, "vs45Tech",
         "Learn Full Stack", LocalDate.now().plusYears(3), false));
    }
    public List<Todo> findTodosList(){
        return todoList;
    }
    public List<Todo> findByUserName(String username){
        Predicate <? super Todo> predicate=todo->todo.getUsername().equalsIgnoreCase(username);
        return todoList.stream().filter(predicate).toList();
    }
    public void addTodo(String username,String description, LocalDate targetDate,boolean done){
int count=todoList.size();
        todoList.add(new Todo(count+1,username,description,targetDate,done));
    }
    public void deleteById(int id){
        Predicate <? super Todo> predicate=todo->todo.getId()==id;
todoList.removeIf(predicate);
    }
    public Todo findById(int id){
        Predicate <? super Todo> predicate=todo->todo.getId()==id;
return todoList.stream().filter(predicate).findFirst().get();
    }
    public void updateTodo(Todo todo){
        deleteById(todo.getId());
        todoList.add(todo);
    }
}
