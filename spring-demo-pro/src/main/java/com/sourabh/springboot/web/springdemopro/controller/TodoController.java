package com.sourabh.springboot.web.springdemopro.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sourabh.springboot.web.springdemopro.services.LoginService;
import com.sourabh.springboot.web.springdemopro.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	TodoService service;

	
	@RequestMapping(value="/todos", method=RequestMethod.GET)
	
	public String showTodos(ModelMap m) {
		String name = (String) m.get("name");
		m.put("todos",service.retrieveTodos(name));
		return "todos";
	}
	
@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	
	public String showTodo(ModelMap m) {
		
		return "add-todo";
	}
@RequestMapping(value="/add-todo", method=RequestMethod.POST)

public String addTodo(ModelMap m, @RequestParam String desc) {
	service.addTodo((String) m.get("name"), desc, new Date(), false);
	return "redirect:/todos";
}

@RequestMapping(value="/deleteTodo", method=RequestMethod.GET)

public String deleteTodo(@RequestParam int id) {
	service.deleteTodo(id);
	return "redirect:/todos";
}

}
