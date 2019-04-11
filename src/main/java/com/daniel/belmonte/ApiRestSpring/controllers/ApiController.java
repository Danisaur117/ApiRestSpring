package com.daniel.belmonte.ApiRestSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.belmonte.ApiRestSpring.dao.entity.ActorEntity;
import com.daniel.belmonte.ApiRestSpring.dao.service.ActorEntityService;

@RestController
@RequestMapping("api")
public class ApiController {
	@Autowired
	private ActorEntityService actorService;
	
	@GetMapping("/hola")
	public String HolaMundo() {
		return "Hola mundo";
	}
	
	@RequestMapping(value="actors", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ActorEntity>> getActors(){
		List<ActorEntity> list = actorService.getAllEntities();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="actor", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ActorEntity> getEntityById(@RequestParam int id){
		ActorEntity actorEntity = actorService.getEntityById(id);
		
		if(actorEntity == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(actorEntity, HttpStatus.OK);
	}
}
