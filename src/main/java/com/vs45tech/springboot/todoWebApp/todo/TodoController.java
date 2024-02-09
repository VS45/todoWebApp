package com.vs45tech.springboot.todoWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String getAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUserName(getLoggedInUsername());
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodos(ModelMap model) {
        Todo todo=new Todo(0, getLoggedInUsername(), "", LocalDate.now().plusYears(1), false);
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
       todoService.addTodo(getLoggedInUsername(), todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
      todoService.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
     Todo todo=todoService.findById(id);
     model.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
        if(result.hasErrors()){
            // model.put("error",result);
            System.out.println(result);
             return "todo";
           }
        //   String username=(String)model.get("name");
           todo.setUsername(getLoggedInUsername());
            todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
     private String getLoggedInUsername(){
   Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
