package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@GetMapping("/hola")
	public String hello()	{
		return "hello";
	}
	@GetMapping("/hola/{name}")
	public String helloNombre(@PathVariable String name)	{
		return "hello " + name;
	}
		

}
