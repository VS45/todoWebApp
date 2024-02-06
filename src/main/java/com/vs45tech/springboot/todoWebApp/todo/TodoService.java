package com.vs45tech.springboot.todoWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todoList=new ArrayList<>();
    static{
        todoList.add(new Todo(1, "vs45 Tech Limited",
         "Learn AWS", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(2, "vs45 Tech Limited",
         "Learn DevOps", LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(3, "vs45 Tech Limited",
         "Learn Full Stack", LocalDate.now().plusYears(3), false));
    }
    public List<Todo> findTodosList(){
        return todoList;
    }
    public List<Todo> findByUserName(String username){
        return todoList;
    }
}
