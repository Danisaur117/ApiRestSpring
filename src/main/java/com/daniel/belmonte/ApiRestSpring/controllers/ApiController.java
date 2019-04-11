package com.daniel.belmonte.ApiRestSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@RequestMapping(value="actors/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ActorEntity> getActorById(@PathVariable int id){
		ActorEntity actorEntity = actorService.getEntityById(id);
		
		if(actorEntity == null) return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		
		return new ResponseEntity<>(actorEntity, HttpStatus.OK);
	}
	
//	@RequestMapping(value="addActor/{firstName}/{lastName}", method=RequestMethod.GET,
//					produces="application/json")
//	public ResponseEntity<ActorEntity> addActor(@PathVariable String firstName,
//			@PathVariable(required = false) String lastName) {
//		
//		ActorEntity actorEntity = actorService.addEntity(new ActorEntity(firstName, lastName));
//		
//		if(actorEntity == null) return new ResponseEntity<>(null, HttpStatus.CONFLICT);
//		
//		return new ResponseEntity<>(actorEntity, HttpStatus.OK);
//	}
	
	@RequestMapping(value="actors", method=RequestMethod.POST)
	public ResponseEntity<Void> addActor(@RequestBody ActorEntity actor, UriComponentsBuilder builder){
		ActorEntity actorEntity = new ActorEntity(actor.getFirst_name(), actor.getLast_name());
		actor = actorService.addEntity(actorEntity);
		
		if(actor == null) return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
