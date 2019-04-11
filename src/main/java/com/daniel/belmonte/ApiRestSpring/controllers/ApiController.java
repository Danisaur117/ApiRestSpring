package com.daniel.belmonte.ApiRestSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {
	@GetMapping("/hola")
	public String HolaMundo() {
		return "Hola mundo";
	}
}
