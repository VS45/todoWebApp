package com.vs45tech.springboot.todoWebApp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
   private TodoService todoService;

    public TodoController(TodoService todoService) {
    this.todoService = todoService;
}

@RequestMapping("list-todos")
    public String getAllTodos(/* @RequestParam String username, */ModelMap model){
       List<Todo> todos= todoService.findTodosList();
       model.put("todos",todos);
return "listTodos";
    }
}
