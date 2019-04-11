package com.daniel.belmonte.ApiRestSpring.dao.repository;

import com.daniel.belmonte.ApiRestSpring.dao.entity.ActorEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorEntityRepository extends CrudRepository<ActorEntity, Integer> {
	
}
