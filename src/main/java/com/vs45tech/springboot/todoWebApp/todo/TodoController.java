package com.vs45tech.springboot.todoWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String getAllTodos(/* @RequestParam String username, */ModelMap model) {
        List<Todo> todos = todoService.findTodosList();
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodos(ModelMap model) {
        Todo todo=new Todo(0, (String)model.get("name"), "", LocalDate.now().plusYears(1), false);
        model.put("todo",todo);
        return "todo";
    }
    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodos(ModelMap model,@Valid Todo todo,BindingResult result) {
      if(result.hasErrors()){
       // model.put("error",result);
       System.out.println(result);
        return "todo";
      }
        String username=(String)model.get("name");
       todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
      todoService.deleteById(id);
        return "redirect:list-todos";
    }
}
